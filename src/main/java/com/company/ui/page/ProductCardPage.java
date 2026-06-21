package com.company.ui.page;

import org.openqa.selenium.By;

public class ProductCardPage extends BasePage {
	private final String BRAND_LINK = "//a[@class=\"product__area__branding__designer__link\"]";
	private final String PRODUCT_NAME = "//div[@class=\"product__area__branding__name\"]";
	private final String ORIGINAL_PRICE = "//span[contains(@class, \"pricing__prices__value--original\")]/span[@class=\"pricing__prices__price\"]";
	private final String DISCOUNT_PRICE = "//span[contains(@class, \"pricing__prices__value--discount\")]/span[@class=\"pricing__prices__price\"]";
	private final String SIZE_DROPDOWN = "//div[@class=\"dropdown__select\"]";
	private final String ADD_TO_BAG_BUTTON = "//div[@aria-label=\"Add to bag\"]";

	public ProductCardPage() {
		super();
	}

	public void clickBrandLink() {
		driver.findElement(By.xpath(BRAND_LINK)).click();
	}

	public String getBrandLinkText() {
		return driver.findElement(By.xpath(BRAND_LINK)).getText();
	}

	public String getProductNameText() {
		return driver.findElement(By.xpath(PRODUCT_NAME)).getText();
	}

	public String getOriginalPrice() {
		return driver.findElement(By.xpath(ORIGINAL_PRICE)).getText();
	}

	public String getDiscountPrice() {
		return driver.findElement(By.xpath(DISCOUNT_PRICE)).getText();
	}

	public void clickSizeDropdown() {
		driver.findElement(By.xpath(SIZE_DROPDOWN)).click();
	}

	public void clickAddToBagButton() {
		driver.findElement(By.xpath(ADD_TO_BAG_BUTTON)).click();
	}
}
