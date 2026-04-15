package by.onliner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeEach
    public void beforeEach() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
        homePage.open();
        // homePage.clickCookies();
    }

    @AfterEach
    public void afterEach() {
        if (driver != null) {
            driver.quit();
        }
    }
}
