package by.onliner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

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
        driver.manage().window().maximize();
        String email = "test@test.com";
        String password = "qwerty@147852";

        homePage.open();
        homePage.clickButtonAuth();

        AuthFormPage authFormPage = new AuthFormPage(driver);
        authFormPage.clickLinkRegistor();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.setInputEmail(email);
        registrationPage.setInputPassword(password);
        registrationPage.setInputRepeatPassword(password);
        registrationPage.clickButtonSubmit();

        String actualButtonCheckText = registrationPage.getButtonEmailCheck();
        Assertions.assertEquals("Перейти в почту", actualButtonCheckText);
    }
}
