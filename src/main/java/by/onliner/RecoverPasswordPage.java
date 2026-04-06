package by.onliner;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RecoverPasswordPage extends ParentPage {
    private final String TITLE = "//*[@id=\"container\"]/div/div/div/div/div[2]/form/div[1]";
    private final String INPUT_EMAIL = "//*[@id=\"container\"]/div/div/div/div/div[2]/form/div[3]/div/div/div/div[1]/div/div/div/div/input";
    private final String BUTTON_AUTH = "//*[@id=\"container\"]/div/div/div/div/div[2]/form/div[4]/button";
    private final String UNREGISTRED_USER_ERROR = "//*[@id=\"container\"]/div/div/div/div/div[2]/form/div[3]/div/div/div/div[2]/div";
    private final String ERROR_MESSAGE_NOT_REGISTER = "//*[@id=\"container\"]/div/div/div/div/div[2]/form/div[3]/div/div/div/div[2]/div";
    private final String EXTENDED_DESCRIPTION_ERROR = "//*[@id=\"container\"]/div/div/div/div/div[2]/form/div[3]/div/div/div/div[1]/div/div/div[2]/div";
    private final String SHOW_USER_NOT_FINISHED_REGISTER = "//*[@id=\"container\"]/div/div/div/div/div[2]/form/div[3]/div/div/div/div[2]/div";

    private  final String URL_RECOVER_PASSWORD = "https://profile.onliner.by/recover-password";

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
    public String getErrorMessageNotRegister(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ERROR_MESSAGE_NOT_REGISTER))).getText();
    }

    public String getExtendedDescriptionError() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EXTENDED_DESCRIPTION_ERROR))).getText();
    }
    public String getShowUserNotFinishedRegister() {
        return driver.findElement(By.xpath(SHOW_USER_NOT_FINISHED_REGISTER)).getText();
    }
}
