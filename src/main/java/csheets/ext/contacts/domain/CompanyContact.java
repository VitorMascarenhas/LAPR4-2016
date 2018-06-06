package csheets.ext.contacts.domain;

import csheets.ext.contacts.domain.tags.ITag;
import csheets.ext.contacts.domain.tags.Tag;
import csheets.persistence.AggregateRoot;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class that implements the concept of Company Contact.
 *
 * @author Pedro Costa
 */
@Entity
public class CompanyContact implements IContact, Serializable, AggregateRoot<Long>
{
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="companycontact_id")
    private List<Contact> relatedContacts;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Tag.class)
    @JoinColumn(name="companycontact_id")
    private Set<ITag> tags;
    
    /**
     * Persistence requirement.
     */
    protected CompanyContact()
    {
        this.relatedContacts = new ArrayList<>();
        this.tags = new HashSet<>();
    }

    /**
     * Company contact constructor.
     *
     * @param companyName String of company name
     */
    public CompanyContact(String companyName)
    {
        this.name = companyName;
        this.relatedContacts = new ArrayList<>();
    }

    /**
     * Returns the name of company contact.
     *
     * @return String with the name of contact.
     */
    public String name()
    {
        return this.name;
    }

    /**
     * Verify if company contact is valid.
     *
     * @return boolean true if valid, false otherwise
     */
    @Override
    public boolean isValid()
    {
        return !this.name.trim().isEmpty() && this.relatedContacts != null;
    }

    /**
     * Update a company contact.
     * @return boolean true if updated with success, false otherwise.
     */
    @Override
    public boolean update(IContact contact)
    {
        if(!(contact instanceof CompanyContact))
            return false;

        CompanyContact newContact = (CompanyContact) contact;

        if(!newContact.isValid())
            return false;

        this.name = newContact.name();

        return true;
    }

    /**
     * Check if two company contacts are the same.
     *
     * @param other Object to compare
     *
     * @return boolean true if are the same, false otherwise.
     */
    @Override
    public boolean sameAs(Object other) {
        if (this == other)
            return true;

        if (other == null || this.getClass() != other.getClass())
            return false;

        CompanyContact otherContact = (CompanyContact) other;

        return this.is(otherContact.id());
    }

    /**
     * Check if two contacts have the same id.
     *
     * @param id the identity to check
     *
     * @return boolean true if object have the same id, false otherwise.
     */
    @Override
    public boolean is(Long id)
    {
        return this.id.equals(id);
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

    /**
     * Return the name of the company.
     *
     * @return String
     */
    @Override
    public String toString() {
        return this.name();
    }
    
    /**
     * Get a set of tags of current contact.
     * @return a set of tags of current contact or null if contact has none associated
     */
    public Set<ITag> tags()
    {
        return this.tags;
    }
    
    /**
     * adds a tag to the current contact tags set
     * @param tag a tag to add to the set
     * @return true if the tag is added correctly
     *         false if the tag already exists in the set
     */
    public boolean addTag(ITag tag){
        return this.tags.add(tag);
    }
    
    /**
     * remove tag from current contact
     * @param tag a tag to remove
     * @return succees of operation
     */
    public boolean removeTag(ITag tag){
        return this.tags.remove(tag);
    }
}
