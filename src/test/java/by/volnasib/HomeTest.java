package by.volnasib;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeTest {
    @Test
    public void test1() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);

        homePage.open();
        String textActualCopyRights = homePage.getCopyRights();

        Assertions.assertEquals("© 2026 Все права защищены. Использование любых материалов данного сайта без согласования запрещается.", textActualCopyRights);
    }
}
