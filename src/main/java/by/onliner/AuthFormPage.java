package by.onliner;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthFormPage extends ParentPage {
    private final String TITEL = "//*[@id=\"auth-container\"]/div/div[2]/div/div[1]";
    private final String INPUT_NAME = "//*[@id=\"auth-container\"]/div/div[2]/div/form/div[1]/div/div[2]/div/div/div/div/input";
    private final String INPUT_PASSWORD = "//*[@id=\"auth-container\"]/div/div[2]/div/form/div[2]/div/div/div/div/input";
    private final String BUTTON_SUBMIT = "//*[@id=\"auth-container\"]/div/div[2]/div/form/div[3]/button";
    private final String LINK_REGISTOR = "//a[@href=\"https://profile.onliner.by/registration\"]";
    private final String LINK_FORGOT_PASSWORD = "//*[@id=\"auth-container\"]/div/div[2]/div/form/div[4]/div[2]/a";
    private final String BUTTON_CLOSE = "//*[@id=\"auth-container\"]/div/div[1]/div[2]";
    private final String ERROR_MESSAGE_NAME = "//*[@id=\"auth-container\"]/div/div[2]/div/form/div[1]/div/div[2]/div/div/div[2]/div";
    private final String ERROR_MESSAGE_PASSWORD = "//*[@id=\"auth-container\"]/div/div[2]/div/form/div[2]/div/div/div[2]/div";
    private final String ERROR_MESSAGE_AUTH = "/html/body/div[5]/div/div/div/div/div/div/div/div[2]/div/form/div[3]/div";

    public AuthFormPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getTitleText() {
        return driver.findElement(By.xpath(TITEL)).getText();
    }

    public void setInputName(String name) {
        driver.findElement(By.xpath(INPUT_NAME)).sendKeys(name);
    }

    public void setInputPassword(String password) {
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(password);
    }

    public void clickButtonSubmit() {
        // 1. Исправлен тип переменной на Wait<WebDriver>
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500)) // 2. Ускорили опрос (0.5 сек вместо 5 сек)
                .ignoring(NoSuchElementException.class)
                .withMessage("Кнопка Submit не найдена за отведенное время");

        // 3. Добавлен @Override для чистоты кода
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BUTTON_SUBMIT)));
        element.click();
    }


    public void clickLinkRegistor() {
        driver.findElement(By.xpath(LINK_REGISTOR)).click();
    }

    public void clickLinkForgotPassword() {
        driver.findElement(By.xpath(LINK_FORGOT_PASSWORD)).click();
    }

    public void clickButtonClose() {
        driver.findElement(By.xpath(BUTTON_CLOSE)).click();
    }
    public String getErrorMessageName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ERROR_MESSAGE_NAME))).getText();
    }
    public String getErrorMessagePassword() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ERROR_MESSAGE_PASSWORD))).getText();
    }
    public String getErrorMessageAuth() {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500)) // 2. Ускорили опрос (0.5 сек вместо 5 сек)
                .ignoring(NoSuchElementException.class)
                .withMessage("Кнопка Submit не найдена за отведенное время");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ERROR_MESSAGE_AUTH))).getText();
    }
}

