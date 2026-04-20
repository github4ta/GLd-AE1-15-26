package by.onliner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RegistrationTest extends BaseTest {
    private AuthFormPage authFormPage;
    private RegistrationPage registrationPage;

    @BeforeEach
    public void setupRegistation() {
        homePage.clickCookies();
        homePage.clickButtonAuth();
        authFormPage = new AuthFormPage(driver);
        authFormPage.clickLinkRegistor();
        registrationPage = new RegistrationPage(driver);
    }

    @Test
    public void testRG004() {
        String actualTitle = registrationPage.getTitleText();
        Assertions.assertEquals("Регистрация", actualTitle);
    }

    @Test
    public void testRG003(){
        String email = "test@test.com";
        String password = "qwerty@147852";

        registrationPage.setInputEmail(email);
        registrationPage.setInputPassword(password);
        registrationPage.setInputRepeatPassword(password);
        registrationPage.clickButtonSubmit();

        String actualButtonCheckText = registrationPage.getButtonEmailCheck();
        Assertions.assertEquals("Перейти в почту", actualButtonCheckText);
    }
}
