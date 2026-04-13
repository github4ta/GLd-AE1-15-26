package com.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private final String HOME_URL = "https://www.amazon.com/";
    private final String COPYRIGHTS = "//div[contains(@class,\"navFooterCopyright\")]/span";

    public HomePage(WebDriver driver) {
        this.driver = driver;
        //this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get(HOME_URL);
    }

    public String getTextCopyrights() {
//        WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(COPYRIGHTS)));
//        return text.getText();
        return driver.findElement(By.xpath(COPYRIGHTS)).getText();
    }
}
