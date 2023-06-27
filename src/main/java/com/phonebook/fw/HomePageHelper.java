package com.phonebook.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends BaseHelper {
    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isHomeLinkPresent() {
        return isElementPresent(By.xpath("//a[@href='/home']"));
    }

    public boolean isHomeComponentPresent() {
        return isElementPresent(By.xpath("//h1[text()='Home Component']"));
    }
}
