package by.onliner;

import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthFormTest {

    private ChromeDriver driver;
    private HomePage homePage;
    private AuthFormPage authFormPage;

    @BeforeEach
    public void initDriverAndManageWindowAndOpenHomePageAndClickButtonAuth() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
        homePage.open();
        homePage.clickButtonAuth();

        authFormPage = new AuthFormPage(driver);
    }

    @DisplayName("Проверка формы логина с пустыми значениями")
    @Test
    public void test1() {
        authFormPage.clickButtonSubmit();

        Assertions.assertEquals("Укажите ник или e-mail", authFormPage.getErrorMessageName());
        Assertions.assertEquals("Укажите пароль", authFormPage.getErrorMessagePassword());
    }
  
    @Test
    public void testAF004(){
        authFormPage.setInputName("katyatest97@gmail.com");
        authFormPage.setInputPassword("123456789");
        authFormPage.clickButtonSubmit();

        Assertions.assertEquals("Неверный логин или пароль", authFormPage.getErrorMessageAuth());
    }

    @Test
    public void testAF001(){
        authFormPage.clickButtonSubmit();

        Assertions.assertEquals("Укажите ник или e-mail", authFormPage.getErrorMessageName());
        Assertions.assertEquals("Укажите пароль", authFormPage.getErrorMessagePassword());
    }


    @DisplayName("Проверка ошибки для поля Имя в форме логинаю")
    @Test
    public void testAF003() {
        authFormPage.setInputPassword("1qazxsw2/.");
        authFormPage.clickButtonSubmit();

        Assertions.assertEquals("Укажите ник или e-mail", authFormPage.getErrorMessageName());
    }
  
	@Test
	public void testAF002(){
		authFormPage.setInputName("test@test.com");
		authFormPage.setInputPassword("");
		authFormPage.clickButtonSubmit();

		Assertions.assertEquals("Укажите пароль", authFormPage.getErrorMessagePassword());
	}

    @AfterEach
    public void driverQuitIfNotNull() {
        if (driver != null) {
            driver.quit();
        }
    }
}
