package csheets.ext.agenda.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Defines Agenda contract.
 */
public interface IAgenda extends Serializable
{
    List<IEvent> allEvents();
    boolean addEvent(IEvent event);
    boolean removeEvent(IEvent event);
    boolean updateEvent(IEvent event);
    boolean isValid();
}
