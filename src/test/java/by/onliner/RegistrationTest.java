package by.onliner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationTest {
    @Test
    public void testRG001() {
        ChromeDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        driver.manage().window().maximize();

        homePage.open();
        homePage.clickButtonAuth();

        AuthFormPage authFormPage = new AuthFormPage(driver);
        authFormPage.clickLinkRegistor();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickButtonSubmit();

        Assertions.assertEquals("Укажите e-mail", registrationPage.getErrorMessageEmail());
        Assertions.assertEquals("Укажите пароль", registrationPage.getErrorMessagePassword());
        Assertions.assertEquals("Укажите пароль", registrationPage.getErrorMessageRepeatPassword());
    }

    @Test
    public void testRG(){

    }
}
