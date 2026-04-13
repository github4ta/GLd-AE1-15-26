package by.onliner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage extends ParentPage {
    private final String INPUT_SEARCH_BAR = "//input[@type='text' and contains(@class, 'search__input')]";
    private final String SEARCH_INPUT= "//input[@name=\"query\"]";
    private final String SEARCH_INPUT_IFRAME = "//input[@class=\"search__input ym-record-keys\"]";
    private final String SEARCH_IFRAME = "//iframe[@class=\"modal-iframe\"]";
    private final String FIELD ="//*[@id=\"search-page\"]/div[1]/div[1]/input";
    private final String FIRST_ADIDAS_PRODUCT = "(//a[contains(@class, 'product__title')])[1]";
    private final String SEARCH_INPUT_IFRAME_TEXT = "//span[@class='text_match']";
    private final String LEGO_PRODUCT_CARD = "//a[@href='https://catalog.onliner.by/buildingkit/lego/10282']";
            //"//a[contains(@class, 'product__title') and contains(normalize-space(), 'Футбольный мяч Adidas Adidas UCL League Box 2026 FIFA JP1548-4 (размер 4)')]";

    public SearchPage(ChromeDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void switchToIframe() {
        WebElement searchIframe = driver.findElement(By.xpath(SEARCH_IFRAME));
        driver.switchTo().frame(searchIframe);
    }
    public void clearSearchInput() {
        driver.findElement(By.xpath(INPUT_SEARCH_BAR)).clear();
    }

    public void setInputFullText(String textSearch) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(INPUT_SEARCH_BAR))).sendKeys(textSearch);
    }

    public String verifyFirstResultContainsAdidas() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FIRST_ADIDAS_PRODUCT))).getText();
    }

    public void setSearchInputIframe(Keys value) {
        driver.findElement(By.xpath(SEARCH_INPUT_IFRAME)).sendKeys(value);
    }

    public String getSearchInputIframeText() {
        return driver.findElement(By.xpath(SEARCH_INPUT_IFRAME_TEXT)).getText();
    }

    public String getSearchInputIframePlaceholder() {
        return driver.findElement(By.xpath(SEARCH_INPUT_IFRAME)).getAttribute("placeholder");
    }

    public String checkResultContainsLego() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LEGO_PRODUCT_CARD))).getText();
    }
}
