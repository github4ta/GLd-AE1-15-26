package by.onliner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AuthFormTest extends BaseTest {
    private AuthFormPage authFormPage;

    @BeforeEach
    public void setupAuth() {
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
}
