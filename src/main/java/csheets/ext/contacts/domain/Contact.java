package csheets.ext.contacts.domain;

import csheets.ext.agenda.domain.*;
import csheets.ext.contacts.domain.Professions.IProfession;
import csheets.ext.contacts.domain.Professions.Profession;
import csheets.ext.contacts.domain.tags.ITag;
import csheets.ext.contacts.domain.tags.Tag;
import csheets.persistence.AggregateRoot;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class that implements the concept of Contact.
 *
 * @author Pedro Costa
 */
@Entity
public class Contact implements IContact, ISchedulable, AggregateRoot<Long>, Serializable
{

    private static final int MIN_PIC_NAME_LENGTH = 5;

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Agenda.class)
    private Agenda agenda;
    private String pictureName;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Profession.class)
    private IProfession profession;
    @OneToOne
    private CompanyContact companyContact;
    
    //List of tgas associated with current contact
    //@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Tag.class)
    //private ITag tag;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Tag.class)
    @JoinColumn(name="contact_id")
    private Set<ITag> tags;
    /**
     * Persistence requirement.
     */
    protected Contact()
    {
    }

    /**
     * Creates a new contact.
     *
     * @param firstName String
     * @param lastName String
     * @param pictureName String
     */
    public Contact(String firstName, String lastName, String pictureName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pictureName = pictureName;
        this.agenda = new Agenda();
        this.tags = new HashSet<>();
    }

    /**
     * Creates a new contact.
     *
     * @param firstName String
     * @param lastName String
     * @param pictureName String
     * @param companyContact Company of contact
     */
    public Contact(String firstName, String lastName, String pictureName, IProfession profession, CompanyContact companyContact)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pictureName = pictureName;
        this.agenda = new Agenda();
        this.profession = profession;
        this.companyContact = companyContact;
        this.tags = new HashSet<>();
    }
    
    /**
     * Creates a new contact.
     *
     * @param firstName String
     * @param lastName String
     * @param pictureName String
     * @param companyContact Company of contact
     */
    public Contact(String firstName, String lastName, String pictureName, IProfession profession, CompanyContact companyContact, ITag tag)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pictureName = pictureName;
        this.agenda = new Agenda();
        this.profession = profession;
        this.companyContact = companyContact;
        this.tags = new HashSet<>();
        this.tags.add(tag);
        //this.tag=tag;
    }

    /**
     * Returns first name of contact.
     *
     * @return String
     */
    public String getFirstName()
    {
        return this.firstName;
    }

    /**
     * Returns last name of contact.
     *
     * @return String
     */
    public String getLastName()
    {
        return this.lastName;
    }

    /**
     * Returns picture name of contact.
     *
     * @return String
     */
    public String getPictureName()
    {
        return this.pictureName;
    }

    /**
     * Check if tw contacts have the same id.
     *
     * @param id the identity to check
     *
     * @return boolean true if object jhave the same id, false otherwise.
     */
    @Override
    public boolean is(Long id) {
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
     * Check if two contacts are the same.
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

        Contact otherContact = (Contact) other;

        return this.is(otherContact.id());
    }

    /**
     * Check if a contact is valid.
     *
     * @return boolean true if is valid, false, otherwise
     */
    @Override
    public boolean isValid() {

        if(this.firstName == null || this.firstName.length() == 0)
            return false;

        if(this.lastName == null || this.lastName.length() == 0)
            return false;

        if(this.pictureName == null || this.pictureName.length()<MIN_PIC_NAME_LENGTH)
            return false;

        return true;
    }

    /**
     * Returns the contact object as string.
     *
     * @return String
     */
    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder();
        str.append("First name: ").append(this.firstName);
        str.append(" Last name: ").append(this.lastName);
        str.append(" Picture: ").append(this.pictureName);

        return str.toString();
    }

    /**
     * Update a contact.
     * @return boolean true if updated with success, false otherwise.
     */
    public boolean update(IContact iContact)
    {
        Contact newContact = (Contact) iContact;

        if(newContact.isValid()){
            this.firstName = newContact.getFirstName();
            this.lastName = newContact.getLastName();
            this.pictureName = newContact.getPictureName();
            this.profession = newContact.profession();
            this.companyContact = newContact.company();
            //this.tag = newContact.tag();
            this.tags = newContact.tags();
            return true;
        }

        return false;
    }

    /**
     * Returns the agenda of contact.
     *
     * @return IAgenda object.
     */
    @Override
    public Agenda agenda()
    {
        return this.agenda;
    }

    /**
     * Check if two contacts are the same. We are assuming that two contacts cannot have the same
     * picture name.
     *
     * @param otherObject Object to compare
     *
     * @return boolean true if equal, false otherwise
     */
    @Override
    public boolean equals(Object otherObject)
    {

        if(!(otherObject instanceof Contact))
            return false;

        Contact otherContact = (Contact)otherObject;

        if(otherContact != null) {

            return this.firstName.equals(otherContact.getFirstName()) &&
                    this.lastName.equals(otherContact.getLastName()) &&
                    this.getPictureName().equals(otherContact.getPictureName());
        }
        return false;
    }

    /**
     * Hashcode implementation.
     *
     * @return int of hashcode generated.
     */
    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + agenda.hashCode();
        result = 31 * result + pictureName.hashCode();
        return result;
    }

    /**
     * Get profession of contact.
     *
     * @return IProfession or null if contact has none associated
     */
    public IProfession profession()
    {
        return this.profession;
    }

    /**
     * Get the contact companyContact of the contact.
     *
     * @return contact companyContact of the personal contact if exists.
     */
    public CompanyContact company()
    {
        return this.companyContact;
    }
    
    /**
     * Get a set of tags of current contact.
     * @return a set of tags of current contact or null if contact has none associated
     */
    /*public ITag tag()
    {
        return this.tag;
    }*/
    
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
