package Lesson2_10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class CommunicationServicesPage extends HomePage {

    @FindBy(xpath = "//div[@class='select__wrapper']")
    private WebElement selectListContainer;

    @FindBy(xpath = "//div[@class='pay__form']//input[@id='connection-phone']")
    private WebElement phoneNumberInput;

    @FindBy(xpath = "//div[@class='pay__form']//input[@id='connection-sum']")
    private WebElement sumInput;

    @FindBy(xpath = "//div[@class='input-wrapper']//input[@id='connection-email']")
    private WebElement emailInput;

    @FindBy(xpath = "//button[@class='button button__default ']")
    private WebElement submitButton;

    private String categoryItemsXpath = "//ul[contains(@class, 'select__list')]/li";

    private String emptyFieldsXpath = "//div[contains(@class, 'pay')]//input[@placeholder]";

    public CommunicationServicesPage(WebDriver driver) {
        super(driver);
    }

    public void selectPaymentCategory(String categoryName) {
        selectListContainer.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(categoryItemsXpath + "[contains(., '" + categoryName + "')]")
        )).click();
    }

    public List<String> getEmptyFieldPlaceholders() {
        return driver.findElements(By.xpath(emptyFieldsXpath)).stream()
                .map(e -> e.getAttribute("placeholder"))
                .collect(Collectors.toList());
    }

    public void fillMobileForm(String phone, String sum, String email) {
        phoneNumberInput.sendKeys(phone);
        sumInput.sendKeys(sum);
        emailInput.sendKeys(email);
    }

    public CardPaymentModal clickContinue() {
        submitButton.click();
        return new CardPaymentModal(driver);
    }
}