package by.volnasib;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {
    private final String URL = "https://volnasib.ru/";
    public final String COPY_RIGHTS = "//*[@id=\"contacts\"]/div[3]/footer/div/div[2]/div";

    private ChromeDriver driver;

    public HomePage(ChromeDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(URL);
    }

    public String getCopyRights() {
        return driver.findElement(By.xpath(COPY_RIGHTS)).getText();
    }
}
