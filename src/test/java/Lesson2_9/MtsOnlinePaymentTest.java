package Lesson2_9;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MtsOnlinePaymentTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private final String SITE_URL = "https://www.mts.by/";
    private final String PHONE_NUMBER = "297777777";

    @BeforeAll
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get(SITE_URL);
        acceptCookiesIfPresent();
    }

    private void acceptCookiesIfPresent() {
        try {
            WebElement acceptButton = driver.findElement(
                    By.xpath("//div[@class=\"cookie__wrapper\"]//button[@id=\"cookie-agree\"]"
            ));
            acceptButton.click();
        } catch (Exception ignored) {}
    }

    @AfterAll
    public void complitePage() {
        driver.quit();
    }

    @BeforeEach
    public void openPage() {
        driver.get(SITE_URL);
    }

    @Test
    public void testBlockTitle() {
        WebElement blockTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class=\"pay__wrapper\"]//h2")
        ));
        String actualText = blockTitle.getText();
        assertTrue(actualText.contains("Онлайн пополнение"), "Заголовок не содержит 'Онлайн пополнение'");
        assertTrue(actualText.contains("без комиссии"), "Заголовок не содержит 'без комиссии'");
    }

    @Test
    public void testPaymentLogos() {
        List<WebElement> logos = driver.findElements(By.xpath("//div[@class=\"pay__wrapper\"]//li//img"));
        assertFalse(logos.isEmpty(), "Не найдены логотипы платёжных систем");
    }

    @Test
    public void testDetailsLink() {
        WebElement detailsLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(), 'Подробнее о сервисе')]")
        ));
        String originalWindow = driver.getWindowHandle();
        detailsLink.click();
        assertTrue(driver.getCurrentUrl().contains("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"), "Открыт неверный документ");
        driver.switchTo().window(originalWindow);
    }

    @Test
    public void testForm() {
        WebElement phoneInput = driver.findElement(By.xpath("//input[@placeholder= \"Номер телефона\"]"));
        phoneInput.clear();
        phoneInput.sendKeys(PHONE_NUMBER);

        WebElement amountInput = driver.findElement(By.xpath("//input[@placeholder=\"Сумма\"]"));
        amountInput.clear();
        amountInput.sendKeys("150");

        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='Продолжить']")
        ));
        button.click();
        assertTrue(button.isEnabled(), "Кнопка 'Продолжить' неактивна");
    }
}