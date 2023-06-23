package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }

        //click on login link
        //driver.findElement(By.xpath("//a[.='LOGIN']")).click();
        app.getUser().click(By.xpath("//a[.='LOGIN']"));//отптимизированный метод(расширенный для любого клика)

        app.getUser().fillLoginRegistrationForm(new User()
                .setEmail("rammmm123@gmail.com")
                .setPassword("rAmmmm123-$"));

        //click on Registration
        //by.name - registration

        //click on the ADD link
        app.getHeader().clickOnAddLink();

        app.getContact().fillAddContactForm(new Contact()
                .setName("Marc")
                .setLastname("Eddinberg")
                .setPhone("12345678910")
                .setEmail("eddinberg@gmail.com")
                .setAddress("Koblenz")
                .setDesc("goalkeeper"));

        //click on the Save button
        app.getContact().clickOnSaveButton();

        //assert the contact is added
        Assert.assertTrue(app.getContact().isContactCreated("Marc"));
    }

    @Test
    public void removeContactPositiveTest() {
        app.getContact().searchNewCreatedContact();
        app.getContact().removeElement();

        // assert the contact can not be found
        Assert.assertFalse(app.getContact().isContactCreated("Marc"));
    }

}
