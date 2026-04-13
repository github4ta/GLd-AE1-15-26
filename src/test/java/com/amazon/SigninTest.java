package com.amazon;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SigninTest {
    private final Duration DEFAULT_IMPLICITLY_WAIT_DURATION_OF_SECONDS = Duration.ofSeconds(4);
    private WebDriver driver;
    private HomePage homePage;
    private SigninPage signinPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICITLY_WAIT_DURATION_OF_SECONDS);
        homePage = new HomePage(driver);
        homePage.open();
        homePage.clickButtonSignin();
        SigninPage signinPage = new SigninPage(driver);
    }

    @DisplayName("Check sighninpage is open")
    @Test
    public void testSigninPage() {
        Assertions.assertEquals("Sign in or create account", signinPage.getTextSigninTitle());
    }

    @AfterEach
    public void tearDown(){
        if(driver != null) {
            driver.quit();
        }
    }
}