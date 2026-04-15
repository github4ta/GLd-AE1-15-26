package by.onliner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeTest {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeEach
    public void beforeEach() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        homePage = new HomePage(driver);
        homePage.open();
        homePage.clickCookies();
    }

    @Test
    public void test1() {
        String textActualCopyRights = homePage.getCopyRights();
        Assertions.assertEquals("© 2001—2026 Onlíner", textActualCopyRights);
    }

    @Test
    public void HP002() {
        String textActualButtonAuth = homePage.getButtonAuthText();
        Assertions.assertEquals("Вход", textActualButtonAuth);
    }

    @Test
    public void testSQ007() {
        String dataForSearch = "any_text";
        homePage.fillInputSearch(dataForSearch);
        homePage.switchToIframe();
        String actualText = homePage.getSearchInputText();
        Assertions.assertEquals(dataForSearch, actualText);
    }

    @Test
    public void testSQ006() {
        String checkText = "Поиск в Каталоге";
        String actualText = homePage.getPlaceholderText();
        Assertions.assertTrue(
                actualText.contains(checkText),
                "Текст '" + checkText + "' не найден в actualText: " + actualText
        );
    }

    @Test
    public void testSQ001() {
        String searchQuery = "qqqqq";
        homePage.fillInputSearch(searchQuery);
        homePage.switchToIframe();
        Assertions.assertEquals("Ничего не найдено", homePage.getEmptyResultMessage());
    }

    @AfterEach
    public void afterEach() {
        driver.quit();
    }
}
