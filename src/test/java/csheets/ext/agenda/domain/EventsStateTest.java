package csheets.ext.agenda.domain;

import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

/**
 * Test class for event state enum.
 */
public class EventsStateTest {


    @Test
    public void eventStateFromTimeStamp()
    {
        Date date = java.sql.Date.valueOf("2015-05-25");
        EventsState stateEnum = EventsState.eventStateFromTimeStamp(date);
        assertTrue(stateEnum == EventsState.PAST);
    }

    @Test
    public void eventStateFromTimeStampFuture()
    {
        Date date = java.sql.Date.valueOf("2017-05-25");
        assertTrue(EventsState.eventStateFromTimeStamp(date).equals(EventsState.FUTURE));
    }
}