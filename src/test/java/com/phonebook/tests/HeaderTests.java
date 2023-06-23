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
        Assert.assertTrue(app.getHeader().isLogoPresent());
    }

    @Test
    public void headerHome() {
        Assert.assertTrue(app.getHomePage().isHomeLinkPresent());
    }

    @Test
    public void headerAbout() {
        Assert.assertTrue(app.getHeader().isAboutLinkPresent());
    }

    @Test
    public void headerLogin() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }

        Assert.assertTrue(app.getHeader().isLoginLinkPresent());
    }

    @Test
    public void headerContacts(){
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }

        app.getHeader().clickOnLoginLink();

        app.getUser().fillLoginRegistrationForm(new User().setEmail("rammmm123@gmail.com")
                .setPassword("rAmmmm123-$"));

        app.getHeader().clickOnLoginButton();

        Assert.assertTrue(app.getHeader().isContactsLinkPresent());
    }

}

