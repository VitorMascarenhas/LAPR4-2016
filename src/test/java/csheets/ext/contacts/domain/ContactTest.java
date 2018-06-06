package csheets.ext.contacts.domain;

import csheets.ext.contacts.controller.ContactEditionController;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created tests for contact class.
 */
public class ContactTest {

    Contact contact;

    @Before
    public void setUp()
    {
        this.contact = new Contact("first name", "last name", "picture.jpg");
    }

    @Test
    public void isValid() throws Exception {

        assert(this.contact.isValid());
    }

    @Test
    public void isValidNot() throws Exception {

        Contact badContact = new Contact("first name","", "picture");
        assertFalse(badContact.isValid());
    }

    @Test
    public void equals(){
        Contact equalContact = new Contact("first name", "last name", "picture.jpg");
        assertTrue(equalContact.equals(this.contact));
    }

    @Test
    public void equalsNot(){
        Contact notEqualContact = new Contact("first name2", "last name", "picture.jpg");
        assertFalse(notEqualContact.equals(this.contact));
    }

}