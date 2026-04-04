package by.onliner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RecoverPasswordTest {
	private  ChromeDriver driver;

	@BeforeEach
	public  void setup(){
		System.setProperty("webdriver.chrome.driver", "/home/ekaterina/Desktop/drivers/chromedriver-linux64/chromedriver");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.setBinary("/home/ekaterina/Desktop/drivers/chrome-linux64/chrome");

		driver = new ChromeDriver(options);
	}

	@Test
	public void testRE004() {
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

	@Test
	public void checkUserEmptyData() {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		HomePage homePage = new HomePage(driver);
		homePage.open();
		homePage.clickButtonAuth();

		AuthFormPage authFormPage = new AuthFormPage(driver);
		authFormPage.clickLinkForgotPassword();

		RecoverPasswordPage recoverPasswordPage = new RecoverPasswordPage(driver);
		recoverPasswordPage.clickButtonAuth();

		String actualErrorMessage = recoverPasswordPage.getExtendedDescriptionError();
		Assertions.assertEquals("Укажите ник, e-mail или номер телефона", actualErrorMessage);
		driver.quit();
	}
	@Test
	public void testRE003() {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		HomePage homePage = new HomePage(driver);
		homePage.open();
		homePage.clickButtonAuth();

		AuthFormPage authFormPage = new AuthFormPage(driver);
		authFormPage.clickLinkForgotPassword();

		RecoverPasswordPage recoverPasswordPage = new RecoverPasswordPage(driver);
		recoverPasswordPage.clickButtonAuth();

		Assertions.assertEquals("Вы не завершили процесс регистрации", recoverPasswordPage.getShowUserNotFinishedRegister());
		driver.quit();
	}
}
