package by.onliner;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class RecoverPasswordPage {
    private ChromeDriver driver;
    private final String TITLE = "//*[@id=\"container\"]/div/div/div/div/div[2]/form/div[1]";
    private final String INPUT_EMAIL = "//*[@id=\"container\"]/div/div/div/div/div[2]/form/div[3]/div/div/div/div[1]/div/div/div/div/input";
    private final String BUTTON_AUTH = "//*[@id=\"container\"]/div/div/div/div/div[2]/form/div[4]/button";

    public RecoverPasswordPage(ChromeDriver driver) {
        this.driver = driver;
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
}
