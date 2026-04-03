package by.onliner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class RecoverPasswordTest {

    @Test
    public void testRE004(){
        ChromeDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();
        driver.manage().window().maximize();
        homePage.clickButtonAuth();

        AuthFormPage authFormPage = new AuthFormPage(driver);
        authFormPage.clickLinkForgotPassword();

        RecoverPasswordPage recoverPasswordPage = new RecoverPasswordPage(driver);
        recoverPasswordPage.setInputEmail("user@user.com");
        recoverPasswordPage.clickButtonAuth();

        Assertions.assertEquals("Такой пользователь не зарегистрирован", recoverPasswordPage.getErrorMessageNotRegister());
        driver.quit();
    }
}
