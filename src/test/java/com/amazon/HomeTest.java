package com.amazon;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HomeTest {

    private final Duration DEFAULT_IMPLICITLY_WAIT_DURATION_OF_SECONDS = Duration.ofSeconds(4);
    private WebDriver driver;
    HomePage homePage;

    @BeforeEach
    public void openDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICITLY_WAIT_DURATION_OF_SECONDS);
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
        homePage.open();
    }

    @Test
    public void testCopyRightsText() {
        // подождать пока страничка действительно загрузиться
        // какие-то действия нужно выполнить чтобы дождаться появление нужного веб-элемента
        Assertions.assertEquals("© 1996-2026, Amazon.com, Inc. or its affiliates", homePage.getTextCopyRights());
    }

    @AfterEach
    public void closeDriver() {
        if (driver != null) {
            driver.close();
        }
    }
}
