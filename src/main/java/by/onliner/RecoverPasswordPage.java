package by.onliner;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RecoverPasswordPage extends BasePage {
    private final String TITLE = "//div[contains(@class, 'auth-form__title')]";
    private final String INPUT_EMAIL = "//input[@placeholder='Ник, e-mail или номер телефона']";
    private final String BUTTON_AUTH = "//button[@type='submit']";
    private final String UNREGISTRED_USER_ERROR = "//div[contains(text(), 'Такой пользователь не зарегистрирован')]";
    private final String ERROR_MESSAGE_NOT_REGISTER = "//div[contains(text(), 'Такой пользователь не зарегистрирован')]";
    private final String EXTENDED_DESCRIPTION_ERROR = "//div[contains(text(), 'Укажите ник, e-mail или номер телефона')]";
    private final String SHOW_USER_NOT_FINISHED_REGISTER = "//div[contains(text(), 'Такой пользователь не зарегистрирован')]";

    private final String URL_RECOVER_PASSWORD = "https://profile.onliner.by/recover-password";

    public RecoverPasswordPage(ChromeDriver driver) {
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

    public void enterUsername(String text) {
        driver.findElement(By.xpath(INPUT_EMAIL)).clear();
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(text);
    }

    public void clickButtonAuth() {
        driver.findElement(By.xpath(BUTTON_AUTH)).click();
    }

    public String unregistredUserError() {
        return driver.findElement(By.xpath(UNREGISTRED_USER_ERROR)).getText();
    }

    public String getErrorMessageNotRegister() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ERROR_MESSAGE_NOT_REGISTER))).getText();
    }

    public String getExtendedDescriptionError() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EXTENDED_DESCRIPTION_ERROR))).getText();
    }

    public String getShowUserNotFinishedRegister() {
        return driver.findElement(By.xpath(SHOW_USER_NOT_FINISHED_REGISTER)).getText();
    }
}
