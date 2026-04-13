package by.onliner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends ParentPage {
    private final String URL = "https://www.onliner.by/";
    private final String INPUT_SEARCH = "//input[@name=\"query\"]";
    private final String BUTTON_AUTH = "//div[text()='Вход']";
    private final String COPY_RIGHTS = "//div[@class='footer-style__copy']";
    private final String COOKIES = "//*[@id=\"submit-button\"]";
    private final String SEARCH_INPUT_IFRAME = "//input[@class=\"search__input ym-record-keys\"]";
    private final String SEARCH_IFRAME = "//iframe[@class=\"modal-iframe\"]";
    private final String EMPTY_RESULT = "//*[contains(text(), 'Ничего не найдено')]";

    public HomePage(ChromeDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ;
    }

    public void open() {
        driver.get(URL);
    }

    public void clickButtonAuth() {
        driver.findElement(By.xpath(BUTTON_AUTH)).click();
    }

    public String getButtonAuthText() {
        return driver.findElement(By.xpath(BUTTON_AUTH)).getText();
    }

    public String getCopyRights() {
        return driver.findElement(By.xpath(COPY_RIGHTS)).getText();
    }

    public void setTextToInputSearch(String textSearch) {
        driver.findElement(By.xpath(INPUT_SEARCH)).sendKeys(textSearch);
    }

    public void clickCookies() {
        driver.findElement(By.xpath(COOKIES)).click();
    }

    public void fillInputSearch(String data) {
        driver.findElement(By.xpath(INPUT_SEARCH)).sendKeys(data);
    }

    public void switchToIframe() {
        WebElement searchIframe = driver.findElement(By.xpath(SEARCH_IFRAME));
        driver.switchTo().frame(searchIframe);
    }

    public String getSearchInputText() {
        WebElement searchInputIframeText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(SEARCH_INPUT_IFRAME)
        ));
        return searchInputIframeText.getAttribute("value");
    }

    public String getEmptyResultMessage() {
        WebElement getEmptyResultMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(EMPTY_RESULT)));
        return getEmptyResultMessage.getText();
    public String getPlaceholderText() {
        WebElement element = driver.findElement(By.xpath(INPUT_SEARCH));
        return element.getAttribute("placeholder");
    }
}
