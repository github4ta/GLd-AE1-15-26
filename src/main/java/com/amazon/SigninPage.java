package com.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SigninPage extends BasePage {
    private final String SIGNIN_TITLE = "//h1";

    public SigninPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTextSigninTitle() {
        return driver.findElement(By.xpath(SIGNIN_TITLE)).getText();
    }
}
