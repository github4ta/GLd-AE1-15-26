package by.onliner;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage extends ParentPage {
    private final String URL = "https://www.onliner.by/";
    private final String INPUT_SEARCH = "//*[@id=\"fast-search\"]/div/input";
    private final String BUTTON_AUTH = "//*[@id=\"userbar\"]/div[2]/div/div/div[1]";
    private final String COPY_RIGHTS = "/html/body/div[4]/footer/div/div/div/div[2]/div[2]";
    private final String COOKIES = "//*[@id=\"submit-button\"]";

    public HomePage(ChromeDriver driver) {
        this.driver = driver;
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

    public void setInputSearch(String text) {
        driver.findElement(By.xpath(INPUT_SEARCH)).sendKeys(text);
    }

    public String getCopyRights() {
        return driver.findElement(By.xpath(COPY_RIGHTS)).getText();
    }

    public void acceptCookies() {
        driver.findElement(By.xpath(COOKIES)).click();
    }
}