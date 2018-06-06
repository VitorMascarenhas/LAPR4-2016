package csheets.ext.agenda.domain;

import java.sql.Date;

/**
 * Created by macbook on 06/06/16.
 */
public class EventFactory {

    public EventFactory()
    {

    }

    public Event generateNewEvent(String dueDate, String description)
    {
        Date date;
        //Parse date
        try {
            date = java.sql.Date.valueOf(dueDate);
        } catch (IllegalArgumentException e)
        {
            return null;
        }

        return new Event(date,description);
    }
}
