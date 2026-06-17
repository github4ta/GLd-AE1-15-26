package com.company.ui.page;

import com.company.ui.driver.Driver;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected final String BASE_URL = "";
    protected WebDriver driver;

    public BasePage() {
        driver = Driver.getDriver();
    }
}
