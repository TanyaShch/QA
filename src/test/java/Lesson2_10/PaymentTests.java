package Lesson2_10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PaymentTests {

    private WebDriver driver;
    private CommunicationServicesPage communicationServicesPage;
    private final String BASE_URL = "https://www.mts.by/";

    @BeforeEach
    public void Setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(BASE_URL);
        communicationServicesPage = new CommunicationServicesPage(driver);
        acceptCookiesIfPresent();
    }

    private void acceptCookiesIfPresent() {
        try {
            WebElement acceptButton = driver.findElement(
                    By.xpath("//div[@class='cookie__wrapper']//button[@id='cookie-agree']"
                    ));
            acceptButton.click();
        } catch (Exception ignored) {}
    }

    private static final Map<String, List<String>> EXPECTED_PLACEHOLDERS_BY_CATEGORY = Map.of(
            "Услуги связи", List.of("Номер телефона", "Сумма", "E-mail для отправки чека"),
            "Домашний интернет", List.of("Номер абонента", "Сумма", "E-mail для отправки чека"),
            "Рассрочка", List.of("Номер счета на 44", "Сумма", "E-mail для отправки чека"),
            "Задолженность", List.of("Номер счета на 2073", "Сумма", "E-mail для отправки чека")
    );

    @Test
    @DisplayName("Проверка надписей в незаполненных полях")
    public void testEmptyField() {

        String defaultCategory = "Услуги связи";
        List<String> defaultPlaceholders = communicationServicesPage.getEmptyFieldPlaceholders();
        List<String> defaultExpected = EXPECTED_PLACEHOLDERS_BY_CATEGORY.get(defaultCategory);

        assertTrue(
                defaultPlaceholders.containsAll(defaultExpected),
                "Для категории по умолчанию '" + defaultCategory + "':\n" +
                        "Ожидаемые: " + defaultExpected + "\n" +
                        "Фактические: " + defaultPlaceholders
        );

        for (String category : EXPECTED_PLACEHOLDERS_BY_CATEGORY.keySet()) {
            if (category.equals(defaultCategory)) continue; // Пропускаем категорию по умолчанию

            try {
                communicationServicesPage.selectPaymentCategory(category);

                // Ждем обновления формы
                new WebDriverWait(driver, Duration.ofSeconds(5))
                        .until(ExpectedConditions.numberOfElementsToBeMoreThan(
                                By.xpath("//div[contains(@class, 'pay')]//input[@placeholder]"),
                                EXPECTED_PLACEHOLDERS_BY_CATEGORY.get(category).size() - 1
                        ));

                List<String> actualPlaceholders = communicationServicesPage.getEmptyFieldPlaceholders();
                List<String> expectedPlaceholders = EXPECTED_PLACEHOLDERS_BY_CATEGORY.get(category);

                assertTrue(
                        actualPlaceholders.containsAll(expectedPlaceholders),
                        "Для категории '" + category + "':\n" +
                                "Ожидаемые: " + expectedPlaceholders + "\n" +
                                "Фактические: " + actualPlaceholders
                );

            } catch (Exception e) {
                throw new AssertionError("Ошибка при проверке категории: " + category, e);
            }
        }
    }

    @Test
    @DisplayName("Проверка модального окна для Услуг связи")
    public void testModalMobilePayment() {
        String phone = "297777777";
        String sum = "150";
        String email = "mail@mail.ru";

        communicationServicesPage.selectPaymentCategory("Услуги связи");
        communicationServicesPage.fillMobileForm(phone, sum, email);
        CardPaymentModal modal = communicationServicesPage.clickContinue();

        assertEquals(sum + ".00 BYN", modal.getSum(), "Сумма не совпадает");
        assertEquals("Оплата: Услуги связи Номер:375" + phone, modal.getPhone(), "Номер телефона не совпадает");
        assertTrue(modal.getSumOfButton().contains("Оплатить " + sum + ".00 BYN"), "Сумма на кнопке не совпадает");

        List<String> expectedText = List.of(
                "Номер карты",
                "Срок действия",
                "CVC",
                "Имя и фамилия на карте"
        );
        assertEquals(expectedText, modal.getCardEmptyField());

        assertTrue(modal.getPaymentIconsCount() >=4, "Не все иконки платежных систем отображаются");
    }

    //@AfterEach
    //public void complitePage() {

    //    driver.quit();
    //}
}