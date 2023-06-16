package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    //precondition: user should be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        if(!isElementPresent(By.xpath("//a[.='LOGIN']"))) {
            click(By.xpath("//button[.='Sign Out']"));
        }

        //click on login link
        //driver.findElement(By.xpath("//a[.='LOGIN']")).click();
        click(By.xpath("//a[.='LOGIN']"));//отптимизированный метод(расширенный для любого клика)

    }

@Test
    public void existedUserRegistrationNegativeTest() {

    //enter email field
    //[placeholder='Email']

    type(By.cssSelector("[placeholder='Email']"), "Rammmm123@gmail.com");
    //enter password field
    //[placeholder='Password']
    type(By.cssSelector("[placeholder='Password']"), "rAmmmm123-$");

    //click on Registration
    //by.name - registration
    click(By.name("registration"));


    //assert user logged in(check Sign out button displayed)
    Assert.assertTrue(isAlertPresent());
}


}
