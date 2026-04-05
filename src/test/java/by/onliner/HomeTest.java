package by.onliner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeTest {
    @Test
    public void test1(){
        ChromeDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);

        homePage.open();
        String textActualCopyRights = homePage.getCopyRights();

        Assertions.assertEquals("© 2001—2026 Onlíner", textActualCopyRights);
    }

    @Test
    public void HP002(){
        ChromeDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);

        homePage.open();
        driver.manage().window().maximize();

        String textActualButtonAuth = homePage.getButtonAuthText();
        Assertions.assertEquals("Вход", textActualButtonAuth);
    }

    @Test
    public void HP001(){
        ChromeDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);

        homePage.open();
        driver.manage().window().maximize();

        Assertions.assertEquals("Поиск в Каталоге.", homePage.getPartInputSearchText());
    }
}
