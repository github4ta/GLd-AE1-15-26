package com.amazon;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HomeTest {
    private final Duration DEFAULT_IMPLICITLY_WAIT_DURATION_OF_SECONDS = Duration.ofSeconds(4);
    private WebDriver driver;
    private HomePage homePage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICITLY_WAIT_DURATION_OF_SECONDS);
        homePage = new HomePage(driver);
        homePage.open();
    }

    @DisplayName("Check homepage is open")
    @Test
    public void testCopyrights() {
        Assertions.assertEquals("© 1996-2026, Amazon.com, Inc. or its affiliates", homePage.getTextCopyrights());
    }

    @AfterEach
    public void tearDown(){
        if(driver != null) {
            driver.quit();
        }
    }
}
