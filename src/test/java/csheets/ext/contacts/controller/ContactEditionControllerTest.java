package csheets.ext.contacts.controller;

import csheets.ext.contacts.domain.Contact;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Few Tests for contact edition controller.
 * The other methods cannot be tested until we have time
 * to make mocks.
 */
public class ContactEditionControllerTest {

    ContactEditionController controller;

    @Before
    public void setUp()
    {
        this.controller = new ContactEditionController();
    }

    @Test
    public void saveContactToEditOrUpdate()
    {
        final String firstName = "Test firstname";
        final String lastName = "Test lastname";
        final String pictureName = "Test picture name";
        Contact contact = new Contact(firstName,lastName,pictureName);
        this.controller.saveContactToEditOrUpdate(contact);
        assertTrue(this.controller.getSelectedContact().equals(contact));
    }

}