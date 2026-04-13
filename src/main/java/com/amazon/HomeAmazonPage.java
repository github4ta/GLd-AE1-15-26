package com.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeAmazonPage extends BasePage{
    private final String URL = "https://www.amazon.com/";
    private final String COPYRIGHT = "//div[@class ='navFooterLine navFooterLinkLine navFooterPadItemLine navFooterCopyright']/span";
    private final String BUTTON_SIGN_IN = "//span[@id='nav-link-accountList-nav-line-1']";

    public HomeAmazonPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openUrl(){
        driver.get(URL);
    }

    public String getTextCopyRights() {
        return driver.findElement(By.xpath(COPYRIGHT)).getText();
    }

    public void clickButtonSignIn() {
       driver.findElement(By.xpath(BUTTON_SIGN_IN)).click();
    }
}
