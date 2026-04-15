package by.onliner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchTest {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeEach
    public void beforeEach() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        homePage.open();
    }

    @AfterEach
    public void afterEach(){
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testSQ003() {
        homePage.setTextToInputSearch("a");

        SearchPage searchPage = new SearchPage(driver);
        searchPage.switchToIframe();
        searchPage.clearSearchInput();
        searchPage.setInputFullText("adidas");
        String textFirstAdidasProduct = searchPage.verifyFirstResultContainsAdidas();

        Assertions.assertTrue(textFirstAdidasProduct.contains("Adidas"),
                "Первый товар не содержит 'adidas'. Фактическое название: " + textFirstAdidasProduct);
    }

    @Test
    public void SQ002() {
        homePage.setTextToInputSearch("Велосипеды");

        SearchPage searchPage = new SearchPage(driver);
        searchPage.switchToIframe();
        String actualText = searchPage.getKidsBikeText();
        Assertions.assertEquals("Детские велосипеды", actualText);
    }

    @Test
    public void testSQ005() {
        homePage.setTextToInputSearch(" ");
        SearchPage searchPage = new SearchPage(driver);
        searchPage.switchToIframe();
        searchPage.setSearchInputIframe(Keys.BACK_SPACE);
        Assertions.assertEquals("Поиск", searchPage.getSearchInputIframePlaceholder());
        Assertions.assertEquals("", searchPage.getSearchInputIframeText());
    }

    @Test
    public void testSQ004() {
        homePage.setTextToInputSearch("Конструктор LEGO 10282 Кроссовки adidas Originals superstar");
        SearchPage searchPage = new SearchPage(driver);
        searchPage.switchToIframe();

        String textLegoPrpduct = searchPage.checkResultContainsLego();
        Assertions.assertTrue(textLegoPrpduct.contains("Конструктор LEGO 10282 Кроссовки adidas Originals Superstar"), "Первый товар не содержит 'Конструктор LEGO 10282 Кроссовки adidas Originals superstar'. Фактическое название: " + textLegoPrpduct);
    }
}
