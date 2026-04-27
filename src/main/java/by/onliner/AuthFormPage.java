package by.onliner;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthFormPage extends BasePage {
    private final String TITEL = "//div[contains(@class, 'auth-form__title')]";
    private final String INPUT_NAME = "//input[@placeholder='Ник или e-mail']";
    private final String INPUT_PASSWORD = "//input[@placeholder='Пароль']";
    private final String BUTTON_SUBMIT = "//button[contains(@class, 'auth-form__button')]";
    private final String LINK_REGISTOR = "//a[@href='https://profile.onliner.by/registration']";
    private final String LINK_FORGOT_PASSWORD = "//a[@href='https://profile.onliner.by/recover-password']";
    private final String BUTTON_CLOSE = "//div[@class='auth-form__close']";
    private final String ERROR_MESSAGE_NAME = "//div[contains(text(), 'Укажите ник или e-mail')]";
    private final String ERROR_MESSAGE_PASSWORD = "//div[contains(text(), 'Укажите пароль')]";
    private final String ERROR_MESSAGE_AUTH = "//div[contains(text(), 'Неверный логин или пароль')]";

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
