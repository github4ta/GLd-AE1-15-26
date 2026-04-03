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

    private final String ERROR_MESSAGE_NOT_REGISTER = "//*[@id=\"container\"]/div/div/div/div/div[2]/form/div[3]/div/div/div/div[2]/div";

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

    public void clickButtonAuth() {
        driver.findElement(By.xpath(BUTTON_AUTH)).click();
    }

    public String getErrorMessageNotRegister(){
        //return driver.findElement(By.xpath(ERROR_MESSAGE_NOT_REGISTER)).getText();
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ERROR_MESSAGE_NOT_REGISTER))).getText();
    }
}
