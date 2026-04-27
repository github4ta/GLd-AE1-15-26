package com.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SigninPage extends BasePage {
    private final String SIGNIN_TITLE = "//h1[contains(@class, 'a-size-medium-plus')]";

    public SigninPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTextSigninTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SIGNIN_TITLE)));
        return element.getText();
    }
}
