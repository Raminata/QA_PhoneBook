package com.phonebook.tests;

import com.phonebook.fw.DataProviders;
import com.phonebook.modle.Contact;
import com.phonebook.modle.User;
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

    @Test(dataProviderClass = DataProviders.class, dataProvider = "addContactFromCsvFile")
    public void addContactFromCsvFilePositiveTest(Contact contact) {
        app.getHeader().clickOnAddLink();

        app.getContact().fillAddContactForm(contact);

        app.getContact().clickOnSaveButton();
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "addContactFromCsvFileIncorrect")
    public void addContactFromCsvFileNegativeTest(Contact contact) {
        app.getHeader().clickOnAddLink();

        app.getContact().fillAddContactForm(contact);

        app.getContact().clickOnSaveButton();

        Assert.assertTrue(app.getUser().isAlertPresent());
    }

    /**
     * В классе CreateContactTests дописать постусловие(@AfterMethod), в котором будет
     * метод, удаляющий контакт(сам метод должен находиться в классе ApplicationManager)
     */
    @AfterMethod
    public void removeContact() {
        app.getContact().removeContact();
    }

    //POV page object
    //VOM value object
}
