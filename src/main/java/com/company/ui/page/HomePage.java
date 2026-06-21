package com.company.ui.page;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private final String COPY_RIGHTS = "//p[@dir='ltr']";
    private final String INPUT_SEARCH = "//div[@class=\"search__box\"]";
    private final String LABEL_ACCOUNT = "//a[@aria-label=\"My Account\"]";
    private final String LABEL_WISHLIST = "//a[@aria-label=\"My Wishlist\"]";
    private final String LABEL_SOPPING_BAG = "//a[@aria-label=\"Shopping bag\"]";

    public HomePage() {
        super();
    }

    public void clickCopyright() {
        driver.findElement(By.xpath(COPY_RIGHTS)).click();
    }

    public void enterSearchText(String text) {
        driver.findElement(By.xpath(INPUT_SEARCH)).sendKeys(text);
    }

    public void clickAccountLabel() {
        driver.findElement(By.xpath(LABEL_ACCOUNT)).click();
    }

    public void clickWishlistLabel() {
        driver.findElement(By.xpath(LABEL_WISHLIST)).click();
    }

    public void clickShoppingBagLabel() {
        driver.findElement(By.xpath(LABEL_SOPPING_BAG)).click();
    }
}
