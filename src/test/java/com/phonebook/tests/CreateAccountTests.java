package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    //precondition: user should be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.isLoginLinkPresent()) {
            app.clickOnSignOutButton();
        }

        //click on login link
        //driver.findElement(By.xpath("//a[.='LOGIN']")).click();
        app.click(By.xpath("//a[.='LOGIN']"));//отптимизированный метод(расширенный для любого клика)

    }

    @Test
    public void existedUserRegistrationNegativeTest() {

        //enter email field
        //[placeholder='Email']

        app.fillLoginRegistrationForm(new User().setEmail("Rammmm123@gmail.com")
                .setPassword("rAmmmm123-$"));

        //click on Registration
        //by.name - registration
        app.clickOnRegistrationButton();


        //assert user logged in(check Sign out button displayed)
        Assert.assertTrue(app.isAlertPresent());
    }


}
