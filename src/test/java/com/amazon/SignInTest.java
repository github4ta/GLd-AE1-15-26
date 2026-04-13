package com.amazon;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInTest {
    private WebDriver driver;
    //protected WebDriverWait wait;
    private HomeAmazonPage homeAmazonPage;

    @BeforeEach
    public void openDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        homeAmazonPage = new HomeAmazonPage(driver);
        homeAmazonPage.openUrl();
    }

    @DisplayName("Проверка Title Sing in.")
    @Test
    public void testCheckTitleSignIn() {
        homeAmazonPage.clickButtonSignIn();

        SignInPage signInPage = new SignInPage(driver);
        Assertions.assertEquals("Sign in or create account", signInPage.getTitleSignIn());
    }

    @AfterEach
    public void driverQuitIfNotNull() {
        if (driver != null) {
            driver.quit();
        }
    }
}
