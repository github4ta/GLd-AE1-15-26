package by.onliner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class RecoverPasswordTest {
    @Test
    public void RE002() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        RecoverPasswordPage recoverPasswordPage = new RecoverPasswordPage(driver);
        recoverPasswordPage.open();

        recoverPasswordPage.enterUsername("1");
        recoverPasswordPage.clickButtonAuth();

        String actualError = recoverPasswordPage.unregistredUserError();
        Assertions.assertEquals("Такой пользователь не зарегистрирован", actualError);
    }
}

