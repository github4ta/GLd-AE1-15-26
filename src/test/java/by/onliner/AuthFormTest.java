package by.onliner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AuthFormTest {
    @Test
    public void test1() {
        FirefoxDriver driver = new FirefoxDriver();
        HomePage homepage = new HomePage(driver);
        driver.manage().window().maximize();
        homepage.open();
        homepage.clickButtonAuth();
        AuthFormPage authformpage = new AuthFormPage(driver);
        authformpage.clickButtonSubmit();

        String textActualErrorMessage = authformpage.getErrorMessageName();
        Assertions.assertEquals("Укажите ник или e-mail ", textActualErrorMessage);
        String textActualErrorMessagePassword = authformpage.getErrorMessagePassword();
        Assertions.assertEquals("Укажите пароль", textActualErrorMessagePassword);
        driver.quit();
    }
    @Test
    public void testAF004(){
        FirefoxDriver driver = new FirefoxDriver();
        HomePage homepage = new HomePage(driver);
        driver.manage().window().maximize();
        homepage.open();
        homepage.clickButtonAuth();
        AuthFormPage authFormPage = new AuthFormPage(driver);
        authFormPage.setInputName("katyatest97@gmail.com");
        authFormPage.setInputPassword("123456789");
        authFormPage.clickButtonSubmit();

        String textActualErrorMessageAuth = authFormPage.getErrorMessageAuth();
        Assertions.assertEquals("Неверный логин или пароль", textActualErrorMessageAuth);
    }
}
