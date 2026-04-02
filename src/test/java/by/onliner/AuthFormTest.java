package by.onliner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthFormTest {
    @Test
    public void testAF001(){
        ChromeDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);

        homePage.open();
        homePage.clickButtonAuth();
        AuthFormPage authFormPage = new AuthFormPage(driver);
        authFormPage.clickButtonSubmit();

        String getErrorMessageNameText = authFormPage.getErrorMessageNameText();

        Assertions.assertEquals("Укажите ник или e-mail", getErrorMessageNameText);

        String getErrorMessagePasswordText = authFormPage.getErrorMessagePassword();

        Assertions.assertEquals("Укажите пароль", getErrorMessagePasswordText);
    }
    @Test
    public void testAF003() {
        ChromeDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        driver.manage().window().maximize();

        homePage.open();
        homePage.clickButtonAuth();

        AuthFormPage authFormPage = new AuthFormPage(driver);
        authFormPage.setInputPassword("1qazxsw2/.");
        authFormPage.clickButtonSubmit();

        String textErrorMessageName = authFormPage.getErrorMessageName();
        Assertions.assertEquals("Укажите ник или e-mail", textErrorMessageName);
    }
}
