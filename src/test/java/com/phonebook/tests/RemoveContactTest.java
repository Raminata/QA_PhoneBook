package com.phonebook.tests;

import com.phonebook.modle.Contact;
import com.phonebook.modle.User;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RemoveContactTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }

        //click on login link
        //driver.findElement(By.xpath("//a[.='LOGIN']")).click();
        app.getHeader().clickOnLoginLink();

        app.getUser().fillLoginRegistrationForm(new User()
                .setEmail("rammmm123@gmail.com")
                .setPassword("rAmmmm123-$"));

        app.getHeader().clickOnLoginButton();

        // remove all exisitng contact
        app.getHeader().clickOnContactsLink();

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

        // Refresh the page
        WebDriverWait wait = new WebDriverWait(app.driver,  Duration.ofMillis(10), Duration.ofMillis(100));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("dummy-element")));

        //assert the contact is added
        Assert.assertTrue(app.getContact().isContactCreated("Marc"));
    }

    @Test
    public void removeContactPositiveTest() {

        int sizeBefore = app.getContact().sizeOfContacts();
        System.out.println(sizeBefore);

        app.getContact().removeContact();
        app.getContact().pause(1000);

        int sizeAfter = app.getContact().sizeOfContacts();
        System.out.println(sizeAfter);
        Assert.assertEquals(sizeAfter,sizeBefore-1);

        // Refresh the page
       /* WebDriverWait wait = new WebDriverWait(app.driver,  Duration.ofMillis(10), Duration.ofMillis(100));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("dummy-element")));

        // assert the contact can not be found
        Assert.assertTrue(app.getContact().isContactListEmpty());*/
    }

}
