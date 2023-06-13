package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {


    @Test
    public void openHomePageTest() {

        //System.out.println("Home Component is " + isHomeComponentPresent1());
        //isElementPresent(By.xpath("//h1[text()='Home Component']"));
        Assert.assertTrue(isElementPresent(By.xpath("//h1[text()='Home Component']")));

        driver.findElement(By.xpath("//h1[text()='Home Component']"));
    }

    public boolean isHomeComponentPresent() {

        return isElementPresent(By.xpath("//h1[text()='Home Component']"));
    }

    public boolean isElementPresent1(By locator) {
       return isElementPresent(locator);
    }
}
