package csheets.ext.contacts.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class of Contact Factory.
 */
public class ContactFactoryTest {

    ContactFactory factory;

    @Before
    public void setUp()
    {
        this.factory = new ContactFactory();
    }

    @Test
    public void newContact() {

        final String firstName = "Test firstname";
        final String lastName = "Test lastname";
        final String pictureName = "Test picture name";

        Contact contact = this.factory.newContact("Test firstname", "Test lastname", "Test picture name");

        assertTrue(contact.getFirstName().equals(firstName));
        assertTrue(contact.getLastName().equals(lastName));
        assertTrue(contact.getPictureName().equals(pictureName));
    }

}