package csheets.ext.agenda.domain;

import csheets.persistence.AggregateRoot;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Class that implements the concept of Event.
 *
 * @author Pedro Costa
 */
@Entity
public class Event implements IEvent, Serializable, AggregateRoot<Long>
{
    @Id
    @GeneratedValue
    private Long id;
    private Date dueDate;
    private String description;

    /**
     * Constructor. Persistence system requirement.
     */
    protected Event()
    {

    }

    /**
     * Create a new Event.
     *
     * @param dueDate Date of the event
     * @param description Description of the event
     */
    public Event(Date dueDate, String description)
    {
        this.dueDate = dueDate;
        this.description = description;
    }

    /**
     * Verify if the object received in param is the same.
     *
     * @param other Object to compare
     *
     * @return boolean true if the same, false otherwise
     */
    @Override
    public boolean sameAs(Object other)
    {
        if (this == other)
            return true;

        if (other == null || this.getClass() != other.getClass())
            return false;

        Event otherEvent = (Event) other;

        return this.is(otherEvent.id());
    }

    /**
     * Verify if some event is the same that
     * have the received id.
     *
     * @param id the identity to check
     *
     * @return boolean true if the same, false otherwise
     */
    @Override
    public boolean is(Long id)
    {
        return this.id.equals(id);
    }

    /**
     * Returns the id of event entity.
     * @return Long
     */
    @Override
    public Long id()
    {
        return this.id;
    }

    /**
     * Check if the event is valid
     *
     * @return boolean true if valid, false otherwise.
     */
    @Override
    public boolean isValid()
    {
        return this.dueDate() != null && !this.description().trim().isEmpty();
    }

    /**
     * Update the description of event.
     *
     * @param description String
     *
     * @return true if updated with sucess, false otherwise.
     */
    @Override
    public boolean updateDescription(String description) {
        if(description == null || description.trim().isEmpty())
            return false;

        this.description = description;

        return true;
    }

    /**
     * Update the dueDate of event.
     *
     * @param dueDate Timestamp
     *
     * @return
     */
    @Override
    public boolean updateDueDate(Date dueDate) {

        if(dueDate == null)
            return false;

        this.dueDate = dueDate;

        return true;
    }

    /**
     * Returns the timestamp of event.
     * @return Timestamp
     */
    @Override
    public Date dueDate()
    {
        return this.dueDate;
    }

    /**
     * Return the description of event.
     * @return String
     */
    @Override
    public String description()
    {
        return this.description;
    }


    /**
     * Compares two events using the description and due date.
     * @param otherObject the other event(Object) to compare
     *
     * @return boolean true if equal, false otherwise
     */
    @Override
    public boolean equals(Object otherObject)
    {
        if(this== otherObject)
            return true;

        if(!(otherObject instanceof Event))
            return false;

        Event event = (Event) otherObject;

        return dueDate.equals(event.dueDate()) && description.equals(event.description());
    }

    /**
     * Generate the hash code for instance.
     *
     * @return int of generated hashcode
     */
    @Override
    public int hashCode() {
        int result = dueDate != null ? dueDate.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
