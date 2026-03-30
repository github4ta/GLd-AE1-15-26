package by.onliner;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {
	private final String URL = "https://www.onliner.by/";
	private final String INPUT_SEARCH = "//*[@id=\"fast-search\"]/div/input";
	private final String BUTTON_AUTH = "//*[@id=\"userbar\"]/div[2]/div/div/div[1]";

	private ChromeDriver driver;

	public HomePage(ChromeDriver driver) {
		this.driver = driver;
	}

	public void open() {
		driver.get(URL);
	}

	public void clickButtonAuth() {
		driver.findElement(By.xpath(BUTTON_AUTH)).click();
	}

	public void setInputSearch(String text) {
		driver.findElement(By.xpath(INPUT_SEARCH)).sendKeys(text);
	}
}
