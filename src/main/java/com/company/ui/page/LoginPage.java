package com.company.ui.page;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private final String LOGIN_AUTH_TITLE = "//div[@class='login__signin__title']";
    private final String EMAIL_INPUT = "//input[@name='email']";
    private final String LOGIN_BUTTON = "//div[@class='button']";
    private final String REGISTER_BUTTON = "//a[contains(@class,'button--alternative')]";

    public LoginPage() {
        super();
    }

    public String getLoginTitle(){
        return driver.findElement(By.xpath(LOGIN_AUTH_TITLE)).getText();

    }

    public void setEmailInputText(String email){
        driver.findElement(By.xpath(EMAIL_INPUT)).sendKeys(email);
    }

    public void clickLoginButton(){
        driver.findElement(By.xpath(LOGIN_BUTTON)).click();
    }

    public void clickRegisterButton(){
        driver.findElement(By.xpath(REGISTER_BUTTON)).click();

    }
}


