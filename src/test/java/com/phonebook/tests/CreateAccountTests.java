package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    //precondition: user should be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }

        app.getHeader().clickOnLoginLink();
    }

    @Test
    public void existedUserRegistrationNegativeTest() {

        //enter email field
        //[placeholder='Email']
        app.getUser().fillLoginRegistrationForm(new User().setEmail("Rammmm123@gmail.com")
                .setPassword("rAmmmm123-$"));

        //click on Registration
        //by.name - registration
        app.getUser().clickOnRegistrationButton();

        //assert user logged in(check Sign out button displayed)
        Assert.assertTrue(app.getUser().isAlertPresent());
    }
}
