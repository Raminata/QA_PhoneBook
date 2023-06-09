package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }

        app.getHeader().clickOnHomeLink();
    }

    @Test
    public void openHomePageTest() {
        Assert.assertTrue(app.getHomePage().isHomeComponentPresent());
    }

}
