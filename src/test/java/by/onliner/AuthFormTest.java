package by.onliner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

    @Test
    public void testAF001(){
        ChromeDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        driver.manage().window().maximize();

        homePage.open();
        homePage.clickButtonAuth();
        AuthFormPage authFormPage = new AuthFormPage(driver);
        authFormPage.clickButtonSubmit();

        String getErrorMessageNameText = authFormPage.getErrorMessageName();
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
        driver.quit();
    }
  
	@Test
	public void testAF002(){
		ChromeDriver driver = new ChromeDriver();
		HomePage homePage = new HomePage(driver);

		homePage.open();
		AuthFormPage authFormPage = new AuthFormPage(driver);
		driver.manage().window().maximize();

		homePage.clickButtonAuth();
		authFormPage.setInputName("test@test.com");
		authFormPage.setInputPassword("");
		authFormPage.clickButtonSubmit();

		String textActualError = authFormPage.getErrorMessagePassword();

		Assertions.assertEquals("Укажите пароль", textActualError);
		driver.quit();
	}
}
