package com.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    private final String HOME_URL = "https://www.amazon.com/";
    private final String COPYRIGHTS = "//div[contains(@class,\"navFooterCopyright\")]/span";
    private final String BUTTON_SIGNIN = "//span[@id=\"nav-link-accountList-nav-line-1\"]";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(HOME_URL);
    }

    public String getTextCopyrights() {
        return driver.findElement(By.xpath(COPYRIGHTS)).getText();
    }

    public void clickButtonSignin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BUTTON_SIGNIN)));
        element.click();
    }
}
