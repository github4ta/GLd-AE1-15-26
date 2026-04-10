package by.onliner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.junit.jupiter.api.Assertions;

public class RegistrationTest {
    @Test
    public void testRG004() {
        ChromeDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);

        homePage.open();
        homePage.clickButtonAuth();

        AuthFormPage authFormPage = new AuthFormPage(driver);
        authFormPage.clickLinkRegistor();

        /*RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.setInputRepeatPassword("1234dfgDRF@$1313131");
        registrationPage.clickButtonSubmit();

        Assertions.assertEquals("", registrationPage.getErrorMessageEmail());
        Assertions.assertEquals("", registrationPage.getErrorMessagePassword());
        Assertions.assertEquals("", registrationPage.getErrorMessageRepeatPassword());*/
    }

    @Test
    public void testRG(){

    }

    @Test
    public void testRG003(){
        ChromeDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        AuthFormPage auth = new AuthFormPage(driver);
        //RegistrationPage registrationPage = new RegistrationPage(driver);

        homePage.open();
        homePage.clickButtonAuth();

        auth.clickLinkRegistor();
    }
}
