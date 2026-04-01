package by.onliner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthFormTest {
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

		String textActualError = authFormPage.getErrorPasswordMessageText();

		Assertions.assertEquals("Укажите пароль", textActualError);
		driver.quit();
	}
}
