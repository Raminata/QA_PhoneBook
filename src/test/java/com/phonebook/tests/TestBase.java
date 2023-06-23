package com.phonebook.tests;

import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", Browser.CHROME.browserName()));

    //@BeforeMethod
    @BeforeSuite
    public void setUp() {
        app.init();
    }

    //@AfterMethod(enabled = false)
    @AfterSuite
    public void tearDown() {
        app.stop();
    }

//@BeforeTest
    //@BeforeMethod
       //@BeforeClass
         //@BeforeSuite one time in one window
           //@BeforeGroups(groups name) test groups
           //@AfterGroups
        //@AfterSuite
    //@AfterClass
    //@AfterMethod
    //@AfterTest

    //@Test(priority 1)
    //@Test(priority 2)
}
