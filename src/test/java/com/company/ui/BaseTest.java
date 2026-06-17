package com.company.ui;

import com.company.ui.driver.Driver;
import org.junit.jupiter.api.AfterEach;

public abstract class BaseTest {

    @AfterEach
    public void closeDriver() {
        Driver.quitDriver();
    }
}
