package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateContactTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }

        app.getUser().click(By.xpath("//a[.='LOGIN']"));

        app.getUser().fillLoginRegistrationForm(new User()
                .setEmail("rammmm123@gmail.com")
                .setPassword("rAmmmm123-$")
        );

        app.getHeader().clickOnLoginLink();
    }

    @Test
    public void addContactPositiveTest() {
        //click on the ADD link
        app.getHeader().clickOnAddLink();
        //int i = (int) (System.currentTimeMillis()/1000)%3600;
        //type(By.cssSelector("input:nth-child(1)"), "Marc" + i);
        //fill in the add contact form
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
        app.getContact().searchNewCreatedContact();
        app.getContact().removeElement();
    }

    //teacher's code
    /*@AfterMethod
    public void postCondition() {

        app.getContact().removeContact();
    }*/


    //POV page object
    //VOM value object
}
