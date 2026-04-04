package by.onliner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthFormTest {
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
