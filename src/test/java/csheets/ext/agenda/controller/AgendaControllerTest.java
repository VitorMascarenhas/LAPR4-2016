package csheets.ext.agenda.controller;

import csheets.ext.agenda.domain.Event;
import csheets.ext.contacts.domain.Contact;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

/**
 * Tests for agenda controller.
 */
public class AgendaControllerTest {

    AgendaController controller;

    @Before
    public void setUp()
    {
        this.controller = new AgendaController();
    }

    @Test
    public void findEvent()
    {
        Contact contact = new Contact("first name", "last name2", "picture.jpg");
        Date date = java.sql.Date.valueOf("2016-05-25");
        Event event = new Event(date,"description");
        contact.agenda().addEvent(event);
        this.controller.saveSelectedSchedulable(contact);

        assert(this.controller.findEvent(event) != null);
    }

}