package by.onliner;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthFormPage extends ParentPage {
    private final String TITEL = "//*[@id=\"auth-container\"]/div/div[2]/div/div[1]";
    private final String INPUT_NAME = "//*[@id=\"auth-container\"]/div/div[2]/div/form/div[1]/div/div[2]/div/div/div/div/input";
    private final String INPUT_PASSWORD = "//*[@id=\"auth-container\"]/div/div[2]/div/form/div[2]/div/div/div/div/input";
    private final String BUTTON_SUBMIT = "//*[@id=\"auth-container\"]/div/div[2]/div/form/div[3]/button";
    private final String LINK_REGISTOR = "//*[@id=\"auth-container\"]/div/div[2]/div/form/div[4]";
    private final String LINK_FORGOT_PASSWORD = "//*[@id=\"auth-container\"]/div/div[2]/div/form/div[4]/div[2]/a";
    private final String BUTTON_CLOSE = "//*[@id=\"auth-container\"]/div/div[1]/div[2]";
    private final String ERROR_MESSAGE_NAME = "//*[@id=\"auth-container\"]/div/div[2]/div/form/div[1]/div/div[2]/div/div/div[2]/div";
    private final String ERROR_MESSAGE_PASSWORD = "//*[@id=\"auth-container\"]/div/div[2]/div/form/div[2]/div/div/div[2]/div";

    public AuthFormPage(ChromeDriver driver) {
        this.driver = driver;
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
        driver.findElement(By.xpath(BUTTON_SUBMIT)).click();
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

    public String getErrorMessageNameText() {
        return driver.findElement(By.xpath(ERROR_MESSAGE_NAME)).getText();
    }

    public String getErrorMessagePassword() {
        return driver.findElement(By.xpath(ERROR_MESSAGE_PASSWORD)).getText();
    }
}
