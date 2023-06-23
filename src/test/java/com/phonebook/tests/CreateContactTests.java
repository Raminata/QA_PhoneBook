package com.phonebook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateContactTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }

        app.getHeader().clickOnLoginLink();

        app.getUser().fillLoginRegistrationForm(new User()
                .setEmail("rammmm123@gmail.com")
                .setPassword("rAmmmm123-$")
        );

        app.getHeader().clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest() {
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
        Assert.assertTrue(app.getContact().isContactCreated("Marc"));//номер тел
    }

    /**
     * В классе CreateContactTests дописать постусловие(@AfterMethod), в котором будет
     * метод, удаляющий контакт(сам метод должен находиться в классе ApplicationManager)
     */
    @AfterMethod
    public void removeContact() {
        WebDriverWait wait = new WebDriverWait(app.driver,  Duration.ofMillis(10), Duration.ofMillis(100));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("dummy-element")));

        app.getContact().searchNewCreatedContact();
        app.getContact().removeElement();
    }

    //POV page object
    //VOM value object
}
