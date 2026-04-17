package by.onliner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RecoverPasswordPage extends BasePage {
    private final String TITLE = "//div[contains(@class, 'auth-form__title')]";
    private final String INPUT_EMAIL = "//input[@placeholder='Ник, e-mail или номер телефона']";
    private final String BUTTON_AUTH = "//button[@type='submit']";
    private final String ERROR_MESSAGE_NOT_REGISTER = "//div[contains(text(), 'Такой пользователь не зарегистрирован')]";
    private final String EXTENDED_DESCRIPTION_ERROR = "//div[contains(text(), 'Укажите ник, e-mail или номер телефона')]";
    private final String SHOW_USER_NOT_FINISHED_REGISTER = "//div[contains(text(), 'Вы не завершили процесс регистрации')]";
    private final String COOKIES = "//*[@id=\"submit-button\"]";

    private final String URL_RECOVER_PASSWORD = "https://profile.onliner.by/recover-password";

    public RecoverPasswordPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getTitleText() {
        return driver.findElement(By.xpath(TITLE)).getText();
    }

    public void setInputEmail(String email) {
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(email);
    }

    public void open() {
        driver.get(URL_RECOVER_PASSWORD);
    }

    public void clickCookies() {
        WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement cookies = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(COOKIES)));
        cookies.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(COOKIES)));
    }

    public void clickButtonAuth() {
        driver.findElement(By.xpath(BUTTON_AUTH)).click();
    }

    public String getErrorMessageNotRegister() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ERROR_MESSAGE_NOT_REGISTER))).getText();
    }

    public String getExtendedDescriptionError() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EXTENDED_DESCRIPTION_ERROR))).getText();
    }

    public String getShowUserNotFinishedRegister() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SHOW_USER_NOT_FINISHED_REGISTER))).getText();
    }
}
