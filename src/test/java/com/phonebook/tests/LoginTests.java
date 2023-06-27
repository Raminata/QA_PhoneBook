package com.phonebook.tests;

import com.phonebook.modle.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }

        //click on login link
        //driver.findElement(By.xpath("//a[.='LOGIN']")).click();
        app.getHeader().clickOnLoginLink();
    }

    @Test
    public void loginPositiveTest() {
        //enter email field
        //[placeholder='Email']
        app.getUser().fillLoginRegistrationForm(new User().setEmail("rammmm123@gmail.com")
                .setPassword("rAmmmm123-$"));

        //click on Registration
        //by.name - registration
        app.getHeader().clickOnLoginButton();

        //assert user logged in(check Sign out button displayed)
        Assert.assertTrue(app.getHeader().isSignOutButtonPresent());
    }

    @Test
    public void loginNegativeWithoutPasswordTest() {
        app.getUser().fillLoginRegistrationForm(new User().setEmail("rammmm123@gmail.com"));

        app.getHeader().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}
