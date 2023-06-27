package com.phonebook.fw;

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

    public void clickOnAboutLink() {
        click(By.xpath("//a[.='ABOUT']"));
    }

    public boolean isContactsLinkPresent() {
        return isElementPresent1(By.xpath("//a[@href='/contacts']"));
    }

    public void clickOnContactsLink() {
        click(By.xpath("//a[.='CONTACTS']"));
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

    public boolean isHomeLinkPresent() {
        return isElementPresent(By.xpath("//a[@href='/home']"));
    }

    public void clickOnHomeLink() {
        click(By.xpath("//a[.='HOME']"));
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
