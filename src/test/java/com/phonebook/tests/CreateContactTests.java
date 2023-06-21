package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateContactTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.isLoginLinkPresent()) {
            app.clickOnSignOutButton();
        }

        app.click(By.xpath("//a[.='LOGIN']"));

        app.fillLoginRegistrationForm(new User().setEmail("rammmm123@gmail.com")
                .setPassword("rAmmmm123-$"));

        app.clickOnLoginLink();

    }

    @Test
    public void addContactPositiveTest() {
//click on the ADD link
        app.clickOnAddLink();
        //int i = (int) (System.currentTimeMillis()/1000)%3600;
        //type(By.cssSelector("input:nth-child(1)"), "Marc" + i);
        //fill in the add contact form
        app.fillAddContactForm("Marc", "Eddinberg", "12345678910", "eddinberg@gmail.com", "Koblenz", "goalkeeper");
        //click on the Save button
        app.clickOnSaveButton();
        //assert the contact is added
        Assert.assertTrue(app.isContactCreated("Marc"));//номер тел
    }

    //написать авто метод удаление (ремуве), без ассертов
    @AfterMethod
    public void removeContact(){
        app.searchNewCreatedContact();
        app.removeElement();
    }

    //POV page object
    //VOM value object
}
