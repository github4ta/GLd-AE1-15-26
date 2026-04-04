package by.onliner;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RegistrationTest {

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
    public void testRG(){

    }

    @Test
    public void testRG003(){

        HomePage homePage = new HomePage(driver);
        AuthFormPage auth = new AuthFormPage(driver);
        RegistrationPage registration = new RegistrationPage(driver);

        homePage.open();
        homePage.clickButtonAuth();

        auth.clickLinkRegistor();



    }
}
