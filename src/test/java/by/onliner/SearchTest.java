package by.onliner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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
    public void SQ002(){
        ChromeDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds(10));
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
    }

