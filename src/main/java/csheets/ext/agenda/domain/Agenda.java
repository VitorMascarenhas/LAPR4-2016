package csheets.ext.agenda.domain;

import csheets.persistence.AggregateRoot;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that implements the concept of Agenda.
 *
 * @author Pedro Costa
 */
@Entity
public class Agenda implements IAgenda, Serializable, AggregateRoot<Long>
{
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany (cascade = CascadeType.ALL,orphanRemoval=true)
    @JoinColumn(name="agenda_id")
    private List<Event> eventsList;

    /**
     * Constructor without params.
     * Its also a requirement of persist system.
     */
    public Agenda()
    {
        this.eventsList = new ArrayList<>();
    }

    /**
     * Returns all events of the agenda.
     *
     * @return List of object that implement IEvent interface.
     */
    @Override
    public List<IEvent> allEvents()
    {
        return new ArrayList<>(this.eventsList);
    }

    /**
     * Add a new event to the agenda.
     * @param newEvent IEvent to add
     *
     * @return boolean true if added with success, false otherwise.
     */
    @Override
    public boolean addEvent(IEvent newEvent)
    {
        return newEvent.isValid() && this.eventsList.add((Event)newEvent);
    }

    /**
     * Remove a event of the agenda.
     * @param event IEvent to remove
     *
     * @return true if removed with success, false otherwise.
     */
    @Override
    public boolean removeEvent(IEvent event)
    {
        return this.eventsList.remove(event);
    }

    /**
     * Update a event.
     *
     * @param event IEvent to update.
     *
     * @return boolean true if updated with success, false otherwise.
     */
    @Override
    public boolean updateEvent(IEvent event)
    {
        if(!event.isValid())
            return false;

        for(Event ev: this.eventsList)
        {
            if(ev.sameAs(event)) {
                ev.updateDescription(event.description());
                ev.updateDueDate(event.dueDate());

                return true;
            }
        }
        return false;
    }

    /**
     * Check if the object is a valid agenda.
     *
     * @return boolean true if valid, false otherwise
     */
    @Override
    public boolean isValid()
    {
        return this.eventsList != null;
    }

    /**
     * Verify if the object is the same.
     *
     * @param other Object to compare
     *
     * @return boolean true if are the same, false otherwise.
     */
    @Override
    public boolean sameAs(Object other)
    {
        if (this == other)
            return true;

        if (other == null || this.getClass() != other.getClass())
            return false;

        Agenda otherContact = (Agenda) other;

        return this.is(otherContact.id());
    }

    /**
     * Check if two agendas are the same.
     *
     * @param id Long the identity to check
     *
     * @return boolean true if are the same, false otherwise.
     */
    @Override
    public boolean is(Long id)
    {
        return this.id().equals(id);
    }

    /**
     * Returns the id of entity.
     *
     * @return Long
     */
    @Override
    public Long id()
    {
        return this.id;
    }

}
