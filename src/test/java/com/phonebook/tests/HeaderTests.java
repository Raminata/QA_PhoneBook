package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * В проекте создать новый класс HeaderTests и в нем 4 метода, которые будут проверять наличие
 * элементов в навигационной панели(логотип, HOME, ABOUT и LOGIN)
 */


public class HeaderTests extends TestBase {

    @Test
    public void headerLogo() {
        Assert.assertTrue(isElementPresent(By.xpath("//h1")));
    }

    @Test
    public void headerHome() {
        Assert.assertTrue(isElementPresent(By.xpath("//a[@href='/home']")));
    }

    @Test
    public void headerAbout() {
        Assert.assertTrue(isElementPresent(By.xpath("//a[@href='/about']")));
    }

    @Test
    public void headerLogin() {
        Assert.assertTrue(isElementPresent(By.xpath("//a[@href='/login']")));
    }


}

