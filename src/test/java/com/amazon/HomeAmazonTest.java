package com.amazon;


import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeAmazonTest {
    private WebDriver driver;
    protected WebDriverWait wait;
    private HomeAmazonPage homeAmazonPage;

    @BeforeEach
    public void openDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        homeAmazonPage = new HomeAmazonPage(driver);
        homeAmazonPage.openUrl();
    }

    @DisplayName("Проверка CopyRights")
    @Test
    public void testCheckCopyRights() {
        Assertions.assertEquals("© 1996-2026, Amazon.com, Inc. or its affiliates", homeAmazonPage.getTextCopyRights());
    }

    @AfterEach
    public void driverQuitIfNotNull() {
        if (driver != null) {
            driver.quit();
        }
    }
}
