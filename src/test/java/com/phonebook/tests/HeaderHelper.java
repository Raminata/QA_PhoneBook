package com.phonebook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderHelper extends BaseHelper {
    public HeaderHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isLogoPresent() {
        return isElementPresent1(By.xpath("//h1"));
    }

    public boolean isAboutLinkPresent() {
        return isElementPresent1(By.xpath("//a[@href='/about']"));
    }

    public boolean isSignOutButtonPresent() {
        return isElementPresent(By.xpath("//button[.='Sign Out']"));
    }

    public void clickOnLoginLink() {
        click(By.xpath("//a[.='LOGIN']"));
    }

    public boolean isButtonLoginPresent() {
        return isElementPresent(By.xpath("//button[.='Login']"));
    }

    public void clickOnLoginButton() {
        click(By.xpath("//button[.='Login']"));
    }

    public void clickOnSignOutButton() {
        click(By.xpath("//button[.='Sign Out']"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.xpath("//a[.='LOGIN']"));
    }

    public void clickOnAddLink() {
        click(By.cssSelector("[href='/add']"));
    }


}
