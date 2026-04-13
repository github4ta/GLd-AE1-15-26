package com.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final String HOME_URL = "https://www.amazon.com/";
    private final String COPYRIGHTS = "//div[@class=\"navFooterLine navFooterLinkLine navFooterPadItemLine navFooterCopyright\"]/span";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(HOME_URL);
    }

    public String getTextCopyRights() {
        return driver.findElement(By.xpath(COPYRIGHTS)).getText();
    }
}
