package by.onliner;

public class RegistrationTest {

    @Test
    public void testRG(){

    }

    @Test
    public void testRG003(){
        ChromeDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);
        AuthFormPage auth = new AuthFormPage(driver);
        RegistrationPage registration = new RegistrationPage(driver);

        homePage.open();
        homePage.clickButtonAuth();

        auth.clickLinkRegistor();



    }
}
