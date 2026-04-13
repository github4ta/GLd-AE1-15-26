package com.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePage {
    private final String TITLE_SIGN_IN = "//h1";

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitleSignIn() {
        return driver.findElement(By.xpath(TITLE_SIGN_IN)).getText();
    }
}
