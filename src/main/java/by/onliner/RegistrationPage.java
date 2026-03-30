package by.onliner;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationPage {
    private ChromeDriver driver;
    private final String TITLE = "//*[@id=\"container\"]/div/div/div/form/div[2]/div/div[1]";
    private final String INPUT_EMAIL = "//*[@id=\"container\"]/div/div/div/form/div[2]/div/div[5]/div/div/div/div/input";
    private final String INPUT_PASSWORD = "//*[@id=\"container\"]/div/div/div/form/div[2]/div/div[6]/div/div/div/div/input";
    private final String INPUT_REPEAT_PASSWORD = "//*[@id=\"container\"]/div/div/div/form/div[2]/div/div[8]/div/div/div/div/input";
    private final String BUTTON_SUBMIT = "//*[@id=\"container\"]/div/div/div/form/div[2]/div/div[9]/button";
    private final String LINK_LOGIN = "//*[@id=\"container\"]/div/div/div/form/div[2]/div/div[10]/a";

    public RegistrationPage(ChromeDriver driver) {
        this.driver = driver;
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
}
