package by.onliner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeTest {
    @Test
    public void test1() {
        ChromeDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);

        homePage.open();
        String textActualCopyRights = homePage.getCopyRights();

        Assertions.assertEquals("© 2001—2026 Onlíner", textActualCopyRights);
    }

    @Test
    public void HP002() {
        ChromeDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);

        homePage.open();
        driver.manage().window().maximize();

        String textActualButtonAuth = homePage.getButtonAuthText();
        Assertions.assertEquals("Вход", textActualButtonAuth);
    }

    @Test
    public void testSQ007() {
        String dataForSearch = "any_text";
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.fillInputSearch(dataForSearch);
        homePage.switchToIframe();

        String actualText = homePage.getSearchInputText();
        Assertions.assertEquals(dataForSearch, actualText);
        driver.quit();
    }

    @Test
    public void testSQ006() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.clickCookies();

        String checkText = "Поиск в Каталоге";
        String actualText = homePage.getPlaceholderText();
        Assertions.assertTrue(
                actualText.contains(checkText),
                "Текст '" + checkText + "' не найден в actualText: " + actualText
        );

        driver.quit();

    }
}
