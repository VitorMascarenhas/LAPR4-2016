package csheets.ext.agenda.domain;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

/**
 * Test the event class.
 */
public class EventTest {

    Event event;

    @Before
    public void setUp()
    {
        Date date = java.sql.Date.valueOf("2016-05-25");
        this.event = new Event(date,"description");
    }

    @Test
    public void updateDescription()
    {
        this.event.updateDescription("new Description");
        assertTrue(this.event.description().equals("new Description"));
    }

    @Test
    public void updateDueDate()
    {
        Date date = java.sql.Date.valueOf("2016-05-26");
        this.event.updateDueDate(date);
        assertTrue(this.event.dueDate().equals(date));
    }

    @Test
    public void equals()
    {
        Date date = java.sql.Date.valueOf("2016-05-25");
        Event event = new Event(date,"description");
        event.equals(this.event);
    }

    @Test
    public void equalsNot()
    {
        Date date = java.sql.Date.valueOf("2016-05-15");
        Event event = new Event(date,"description");
        event.equals(this.event);
    }

}