package com.amazon;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeTest {
    private WebDriver driver;
    HomePage homePage;

    @BeforeEach
    public void openDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        homePage.open();
    }

    @Test
    public void testCopyRightsText() {
        Assertions.assertEquals("© 1996-2026, Amazon.com, Inc. or its affiliates", homePage.getTextCopyRights());
    }

    @AfterEach
    public void closeDriver() {
        if (driver != null) {
            driver.close();
        }
    }
}
