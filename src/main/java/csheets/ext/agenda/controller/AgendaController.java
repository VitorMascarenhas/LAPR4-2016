package csheets.ext.agenda.controller;

import csheets.ext.agenda.domain.*;
import csheets.ext.contacts.domain.Contact;
import csheets.persistence.AggregateRoot;
import csheets.persistence.IContactRepository;
import csheets.persistence.jpa.contact.JpaContactRepository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A controller for editing agenda.
 * @author Pedro Costa
 */
public class AgendaController
{
    private IContactRepository contactRepository;
    private IEvent selectedEvent;
    private List<ISchedulable> listSchedulables;
    private ISchedulable schedulable;

    /**
     * Creates a new agenda controller.
     */
    public AgendaController()
    {
        this.contactRepository = new JpaContactRepository();
    }

    /**
     * Get all objects that are schedulable.
     *
     * @return Iterable
     */
    public List<ISchedulable> getAllSchedulables()
    {
        this.listSchedulables = new ArrayList<>();
        Iterator<Contact> it = this.contactRepository.all().iterator();

        while(it.hasNext())
            this.listSchedulables.add(it.next());

        return this.listSchedulables;
    }

    /**
     * Saves the selected schedulable.
     *
     * @param schedulable IAgenda
     */
    public void saveSelectedSchedulable(ISchedulable schedulable)
    {
        this.schedulable = schedulable;
    }

    /**
     * Return all events associated with schedulable.
     * @param schedulable to get events
     *
     * @return List of all events
     */
    public List<IEvent> eventsOfSelectedSchedulable(ISchedulable schedulable)
    {
        this.schedulable = schedulable;
        List<ISchedulable> newSchedulables = getAllSchedulables();

        return newSchedulables.get(newSchedulables.indexOf(schedulable)).agenda().allEvents();
    }

    /**
     * Find a schedulable from the current list in memory. This list is updated
     * every time we make changes in events, so there are no risks of being
     * in inconsistent state.
     *
     * @param schedulableToFindId Long
     *
     * @return Contact if find or null otherwise
     */
    public ISchedulable findSchedulable(Long schedulableToFindId)
    {
        for(ISchedulable schedulable: this.listSchedulables)
        {
            if(((AggregateRoot)schedulable).id().equals(schedulableToFindId))
                return schedulable;
        }
        return null;
    }


    /**
     * Search for a event in the agenda of current schedulable
     * using description and due date, not id.
     *
     * @param eventToFind IEvent object
     *
     * @return Event if find, null otherwise
     */
    public IEvent findEvent(IEvent eventToFind)
    {
        for(IEvent event: this.schedulable.agenda().allEvents())
        {
            if(event.description().equals(eventToFind.description()) && event.dueDate().equals(eventToFind.dueDate()))
                return event;
        }
        return null;
    }

    /**
     * Search for a event in the agenda of current schedulable
     * using id.
     *
     * @param eventToFind Long representing id
     *
     * @return Event if find, null otherwise
     */
    public IEvent findEventById(Long eventToFind)
    {
        for(IEvent event: this.schedulable.agenda().allEvents())
        {
            if(event instanceof Event && eventToFind.equals(((Event) event).id()))
                return event;
        }
        return null;
    }

    /**
     * TODO
     *
     * @return
     */
    public boolean createEvent(String dueDate, String description)
    {
        EventFactory factory = new EventFactory();
        Event newEvent = factory.generateNewEvent(dueDate, description);
        if(newEvent == null)
            return false;
        this.schedulable.agenda().addEvent(newEvent);
        this.contactRepository.updateContact((Contact)this.schedulable);

        return true;
    }

    /**
     *
     * @return
     */
    public IEvent getSelectedEvent()
    {
        throw new IllegalArgumentException();
    }

    /**
     *
     * @return
     */
    public boolean removeEvent()
    {
        if(!this.schedulable.agenda().removeEvent(this.selectedEvent))
            return false;

        this.contactRepository.updateContact((Contact)this.schedulable);

        return true;
    }

    /**
     *
     * @param dueDate
     * @param description
     * @return
     */
    public boolean editEvent(String dueDate, String description)
    {
        throw new IllegalArgumentException();
    }


    public void saveSelectedEvent(IEvent event)
    {
        this.selectedEvent = event;
    }
}
