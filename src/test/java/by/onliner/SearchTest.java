package by.onliner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchTest {
    @Test
    public void testSQ003() {
        ChromeDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        HomePage homePage = new HomePage(driver);

        homePage.open();
        driver.manage().window().maximize();

        homePage.setTextToInputSearch("a");

        SearchPage searchPage = new SearchPage(driver);
        searchPage.switchToIframe();
        searchPage.clearSearchInput();
        searchPage.setInputFullText("adidas");
        String textFirstAdidasProduct = searchPage.verifyFirstResultContainsAdidas();

        Assertions.assertTrue(textFirstAdidasProduct.contains("Adidas"),
                "Первый товар не содержит 'adidas'. Фактическое название: " + textFirstAdidasProduct);
        driver.quit();
    }

    @Test
    public void SQ002() {
        ChromeDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        HomePage homePage = new HomePage(driver);
        homePage.open();
        driver.manage().window().maximize();
        homePage.setTextToInputSearch("Велосипеды");

        SearchPage searchPage = new SearchPage(driver);
        searchPage.switchToIframe();
        String actualText = searchPage.getKidsBikeText();
        Assertions.assertEquals("Детские велосипеды", actualText);
        driver.quit();
    }

    @Test
    public void testSQ005() {
        ChromeDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        HomePage homePage = new HomePage(driver);

        homePage.open();
        driver.manage().window().maximize();

        homePage.setTextToInputSearch(" ");
        SearchPage searchPage = new SearchPage(driver);
        searchPage.switchToIframe();
        searchPage.setSearchInputIframe(Keys.BACK_SPACE);
        Assertions.assertEquals("Поиск", searchPage.getSearchInputIframePlaceholder());
        Assertions.assertEquals("", searchPage.getSearchInputIframeText());
    }

    @Test
    public void testSQ004() {
        ChromeDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);

        homePage.open();
        driver.manage().window().maximize();

        homePage.setTextToInputSearch("Конструктор LEGO 10282 Кроссовки adidas Originals superstar");
        SearchPage searchPage = new SearchPage(driver);
        searchPage.switchToIframe();

        String textLegoPrpduct = searchPage.checkResultContainsLego();
        Assertions.assertTrue(textLegoPrpduct.contains("Конструктор LEGO 10282 Кроссовки adidas Originals Superstar"), "Первый товар не содержит 'Конструктор LEGO 10282 Кроссовки adidas Originals superstar'. Фактическое название: " + textLegoPrpduct);
    }
}
