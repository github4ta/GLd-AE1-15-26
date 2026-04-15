package by.onliner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage  extends BasePage {
    private final String TITLE = "//div[contains(@class, 'auth-form__title')]";
    private final String INPUT_EMAIL = "//input[@type=\"email\"]";
    private final String INPUT_PASSWORD = "//input[@placeholder=\"Придумайте пароль\"]";
    private final String INPUT_REPEAT_PASSWORD = "//input[@placeholder=\"Повторите пароль\"]";
    private final String BUTTON_SUBMIT = "//button[@type=\"submit\"]";
    private final String LINK_LOGIN = "//a[@href=\"/login\"]";
    private final String ERROR_MESSAGE_EMAIL = "//div[contains(text(), \"Укажите e-mail\")]";
    private final String ERROR_MESSAGE_PASSWORD = "INPUT_PASSWORD + \"/following::div[contains(text(), 'Укажите пароль')]\"";
    private final String ERROR_MESSAGE_REPEAT_PASSWORD = "INPUT_REPEAT_PASSWORD + \"/following::div[contains(text(), 'Укажите пароль')]\"";
    private final String BUTTON_EMAIL_CHECK = "//a[contains(@class,\"auth-button_appendant\")]";

    public RegistrationPage(ChromeDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getTitleText() {
        return driver.findElement(By.xpath(TITLE)).getText();
    }

    public void setInputEmail(String email) {
        driver.findElement(By.xpath(INPUT_EMAIL)).sendKeys(email);
    }

    public void setInputPassword(String password) {
        driver.findElement(By.xpath(INPUT_PASSWORD)).sendKeys(password);
    }

    public void setInputRepeatPassword(String password) {
        driver.findElement(By.xpath(INPUT_REPEAT_PASSWORD)).sendKeys(password);
    }

    public void clickButtonSubmit() {
        driver.findElement(By.xpath(BUTTON_SUBMIT)).click();
    }

    public void clickLinkLogin() {
        driver.findElement(By.xpath(LINK_LOGIN)).click();
    }

    public String getErrorMessageEmail() {
        return driver.findElement(By.xpath(ERROR_MESSAGE_EMAIL)).getText();
    }

    public String getErrorMessagePassword() {
        return driver.findElement(By.xpath(ERROR_MESSAGE_PASSWORD)).getText();
    }

    public String getErrorMessageRepeatPassword() {
        return driver.findElement(By.xpath(ERROR_MESSAGE_REPEAT_PASSWORD)).getText();
    }

    public String getButtonEmailCheck() {
        WebElement buttonEmailCheck = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BUTTON_EMAIL_CHECK)));
        return buttonEmailCheck.getText();
    }
}
