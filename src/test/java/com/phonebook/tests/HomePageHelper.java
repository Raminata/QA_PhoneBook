package com.phonebook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends BaseHelper {
    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isHomeLinkPresent() {
        return isElementPresent1(By.xpath("//a[@href='/home']"));
    }
    public boolean isHomeComponentPresent1() {
        try {
            driver.findElement(By.xpath("//h1[text()='Home Component']"));
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isHomeComponentPresent() {

        return isElementPresent(By.xpath("//h1[text()='Home Component']"));
    }
}
