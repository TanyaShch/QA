package Lesson2_11;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CardPaymentModal extends HomePage {

    private final By sumBy = By.xpath("//div[@class='pay-description__cost']//span");
    private final By phoneBy = By.xpath("//div[@class='pay-description__text']//span");
    private final By cardNumberBy = By.xpath("//label[@class='ng-tns-c2312288139-1 ng-star-inserted']");
    private final By paymentIconsBy = By.xpath("//div[@class='icons-container ng-tns-c2312288139-1']//img");
    private final By expDateBy = By.xpath("//label[@class='ng-tns-c2312288139-4 ng-star-inserted']");
    private final By cvvBy = By.xpath("//label[@class='ng-tns-c2312288139-5 ng-star-inserted']");
    private final By nameBy = By.xpath("//label[@class='ng-tns-c2312288139-3 ng-star-inserted']");
    private final By buttonBy = By.xpath("//button[contains(@class, 'colored')]");

    public CardPaymentModal(WebDriver driver) {
        super(driver);
    }

    private void switchToFrame() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.xpath("//iframe[contains(@class, 'bepaid-iframe')]")
        ));
    }

    @Step("Получение суммы платежа")
    public String getSum() {
        switchToFrame();
        try {
            WebElement sumElement = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(sumBy));
            return sumElement.getText().trim();
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    @Step("Получение номера телефона")
    public String getPhone() {
        switchToFrame();
        try {
            WebElement phoneElement = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(phoneBy));
            return phoneElement.getText().trim();
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    @Step("Получение текста на кнопке оплаты")
    public String getSumOfButton() {
        switchToFrame();
        try {
            WebElement button = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(buttonBy));
            return button.getText().trim();
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    @Step("Получение текстовых подписей полей карты")
    public List<String> getCardEmptyField() {
        switchToFrame();
        try {
            List<String> fieldTexts = new ArrayList<>();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            fieldTexts.add(wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumberBy)).getText().trim());
            fieldTexts.add(wait.until(ExpectedConditions.visibilityOfElementLocated(expDateBy)).getText().trim());
            fieldTexts.add(wait.until(ExpectedConditions.visibilityOfElementLocated(cvvBy)).getText().trim());
            fieldTexts.add(wait.until(ExpectedConditions.visibilityOfElementLocated(nameBy)).getText().trim());

            return fieldTexts;
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    @Step("Получение количества иконок платежных систем")
    public int getPaymentIconsCount() {
        switchToFrame();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            List<WebElement> icons = wait.until(
                    ExpectedConditions.visibilityOfAllElementsLocatedBy(paymentIconsBy)
            );
            return icons.size();
        } finally {
            driver.switchTo().defaultContent();
        }
    }
}