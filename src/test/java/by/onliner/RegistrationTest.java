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
    public void testRG() {

    }

    /*"Мы отправили на admin1234@onliner.by письмо. Для завершения регистрации перейдите по ссылке из письма.
    Если вы не нашли письмо, проверьте спам."*/

    @Test
    public void testRE007() {
        ChromeDriver driver = new ChromeDriver();
        String textConfirmReg = "Мы отправили на admin1234@onliner.by письмо. " +
                "Для завершения регистрации перейдите по ссылке из письма." +
                "Если вы не нашли письмо, проверьте спам.";

        HomePage homePage = new HomePage(driver);
        homePage.open();

        homePage.clickButtonAuth();

        AuthFormPage authPage = new AuthFormPage(driver);
        authPage.clickLinkRegistor();

        RegistrationPage regPage = new RegistrationPage(driver);
        regPage.setInputEmail("admin@onliner.by");
        regPage.clickButtonSubmit();

        Assertions.assertEquals(textConfirmReg, regPage.getSuccesMessageConfirmReg());
    }
}
