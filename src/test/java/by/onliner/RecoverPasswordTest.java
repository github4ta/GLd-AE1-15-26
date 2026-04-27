package by.onliner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RecoverPasswordTest {
    private WebDriver driver;
    private RecoverPasswordPage recoverPasswordPage;

    @BeforeEach
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        recoverPasswordPage = new RecoverPasswordPage(driver);
        recoverPasswordPage.open();
        recoverPasswordPage.clickCookies();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void RE002() {
        recoverPasswordPage.setInputEmail("1");
        recoverPasswordPage.clickButtonAuth();

        Assertions.assertEquals("Такой пользователь не зарегистрирован", recoverPasswordPage.getErrorMessageNotRegister());
    }

    @Test
    public void testRE004() {
        recoverPasswordPage.setInputEmail("user@user.com");
        recoverPasswordPage.clickButtonAuth();

        Assertions.assertEquals("Такой пользователь не зарегистрирован", recoverPasswordPage.getErrorMessageNotRegister());
    }

    @Test
    public void checkUserEmptyData() {
        recoverPasswordPage.clickButtonAuth();

        Assertions.assertEquals("Укажите ник, e-mail или номер телефона", recoverPasswordPage.getExtendedDescriptionError());
    }

    @Test
    public void testRE003() {
        recoverPasswordPage.setInputEmail("test@test.com");
        recoverPasswordPage.clickButtonAuth();

        Assertions.assertEquals("Вы не завершили процесс регистрации", recoverPasswordPage.getShowUserNotFinishedRegister());
    }

    @Test
    public void testRE005() {
        recoverPasswordPage.setInputEmail("375");
        recoverPasswordPage.clickButtonAuth();

        Assertions.assertEquals("Такой пользователь не зарегистрирован", recoverPasswordPage.getErrorMessageNotRegister());
    }

    @Test
    public void testRE006() {
        recoverPasswordPage.setInputEmail("xyz");
        recoverPasswordPage.clickButtonAuth();

        Assertions.assertEquals("Такой пользователь не зарегистрирован", recoverPasswordPage.getErrorMessageNotRegister());
    }
}

