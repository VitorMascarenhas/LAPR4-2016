package csheets.ext.agenda.domain;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Enum class that define a list of the valid events states.
 */
public enum EventsState
{
    PAST, PRESENT, FUTURE;

    /**
     *
     * Returns the a event state according dates received.
     *
     * @param newDate Timestamp of the event date
     *
     * @return EventState or null we not match.
     */
    public static EventsState eventStateFromTimeStamp(java.sql.Date newDate)
    {
        Timestamp today = new Timestamp(new Date().getTime());

        if(newDate.before(today))
            return PAST;
        if(newDate.after(today))
            return FUTURE;
        if(newDate.equals(today))
            return PRESENT;

        return null;
    }
}
