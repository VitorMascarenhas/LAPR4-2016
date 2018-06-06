package csheets.ext.contacts.controller;

import csheets.ext.contacts.domain.CompanyContact;
import csheets.ext.contacts.domain.Contact;
import csheets.ext.contacts.domain.ContactFactory;
import csheets.ext.contacts.domain.IContact;
import csheets.ext.contacts.domain.Professions.IProfession;
import csheets.ext.contacts.domain.Professions.ProfessionsManagerXml;
import csheets.ext.contacts.domain.tags.ITag;
import csheets.ext.contacts.domain.tags.Tag;
import csheets.ext.contacts.domain.tags.TagsManagerXml;
import csheets.persistence.ICompanyContactRepository;
import csheets.persistence.IContactRepository;
import csheets.persistence.PersistenceContext;

import java.util.*;

/**
 * A controller for editing contacts.
 * @author Pedro Costa
 */
public class ContactEditionController
{

    /* IRepositories to retrieve data */
    private IContactRepository contactRepository;
    private ICompanyContactRepository companyContactRepository;

    /* Contact to delete or edit */
    private IContact contact;

    /* List of contacts in db*/
    private List<IContact> contactsList;
    /* List of available professions */
    private Set<IProfession> professionsList;

    private Set<ITag> tagsList;
    
    /**
     * Creates a new contact controller.
     *
     */
    public ContactEditionController()
    {
        this.contactRepository = PersistenceContext.repositories().contacts();
        this.companyContactRepository = PersistenceContext.repositories().companyContacts();
        this.professionsList = new HashSet<>();
        this.tagsList = new HashSet<>();
    }

    /**
     * Create a new contact.
     *
     * @param firstName String
     * @param lastName String
     * @param picture String with the name of picture
     * @param profession Profession of the contact
     *
     * @return boolean true if created with success, false otherwise.
     */
    public boolean createContact(String firstName, String lastName, String picture, IProfession profession, CompanyContact company)
    {
        ContactFactory factory = new ContactFactory();

        try {
            return this.contactRepository.add(factory.newContactWithProfession(firstName, lastName, picture, profession, company));
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Create a new contact.
     *
     * @param firstName String
     * @param lastName String
     * @param picture String with the name of picture
     * @param profession Profession of the contact
     * @param company
     *
     * @return boolean true if created with success, false otherwise.
     */
    public boolean createContact(String firstName, String lastName, String picture, IProfession profession, CompanyContact company, ITag tag)
    {
        ContactFactory factory = new ContactFactory();

        try {
            return this.contactRepository.add(factory.newContactWithTag(firstName, lastName, picture, profession, company, tag));
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Create a new company contact.
     *
     * @param name String
     *
     * @return boolean true if created with success, false otherwise.
     */
    public boolean createCompanyContact(String name)
    {
        ContactFactory factory = new ContactFactory();

        try {
            return this.companyContactRepository.add(factory.newCompanyContact(name));
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Save the selected contact id to use latter in edit or delete.
     *
     * @param contact IContact
     */
    public void saveContactToEditOrUpdate(IContact contact)
    {
        this.contact = contact;
    }

    /**
     * Update contact associated with controller.
     *
     * @param firstName String
     * @param lastName String
     *
     * @return boolean true if updated with success, false otherwise
     */
    public boolean editContact(String firstName, String lastName, String picture, IProfession profession, CompanyContact companyContact)
    {
        ContactFactory factory = new ContactFactory();
        IContact newContact = factory.newContactWithProfession(firstName, lastName, picture, profession, companyContact);

        if(this.contact.update(newContact)) {
            this.contactRepository.updateContact((Contact) this.contact);
            return true;
        }

        return false;
    }
    
    /**
     * Update contact associated with controller.
     *
     * @param firstName String
     * @param lastName String
     *
     * @return boolean true if updated with success, false otherwise
     */
    public boolean editContact(String firstName, String lastName, String picture, IProfession profession, CompanyContact companyContact, ITag tag)
    {
        ContactFactory factory = new ContactFactory();
        IContact newContact = factory.newContactWithTag(firstName, lastName, picture, profession, companyContact, tag);

        if(this.contact.update(newContact)) {
            this.contactRepository.updateContact((Contact) this.contact);
            return true;
        }

        return false;
    }

    /**
     * Remove a contact of the persist system.
     *
     * @return boolean true if removed with success, false otherwise.
     */
    public boolean removeContact()
    {
        try {
            if(this.contact instanceof Contact)
                this.contactRepository.deleteById(((Contact)this.contact).id());
            else
                this.companyContactRepository.deleteById(((CompanyContact)this.contact).id());
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    /**
     * Remove a tag from contact of the persist system.
     *
     * @return boolean true if removed with success, false otherwise.
     */
    public boolean removeTag(ITag tag)
    {
        try {
            if(this.contact instanceof Contact){
                ((Contact)this.contact).removeTag(tag);
                return ((Contact)this.contact).update(((Contact)this.contact));
            }
            else
                return false;
                //this.companyContactRepository.deleteById(((CompanyContact)this.contact).id());
        } catch (Exception e) {
            return false;
        }
        //return true;
    }

    /**
     * Update a contact of the persist system.
     *
     * @return boolean true if updated with success, false otherwise.
     */
    public boolean updateContact()
    {
        if(!this.contact.isValid())
            return false;
        try {
            if(this.contact instanceof Contact)
                this.contactRepository.updateContact((Contact)this.contact);
            else
                this.companyContactRepository.updateContact((CompanyContact)this.contact);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Get all contacts implementing IContact interface stored in persist system.
     *
     * @return Iterable
     */
    public List<IContact> getAllContacts()
    {
        this.contactsList = new ArrayList<>();
        Iterator<Contact> it = this.contactRepository.all().iterator();

        while(it.hasNext())
            this.contactsList.add(it.next());

        //Get also the companies contacts
        this.contactsList.addAll(this.getAllCompaniesContacts());

        return this.contactsList;
    }

    /**
     * Get all company contacts stored in persist system.
     *
     * @return Iterable
     */
    public List<CompanyContact> getAllCompaniesContacts()
    {
        List<CompanyContact> companies = new ArrayList<>();
        Iterator<CompanyContact> itCompany = this.companyContactRepository.all().iterator();

        while(itCompany.hasNext())
            companies.add(itCompany.next());

        return companies;
    }

    /**
     * Find a contact from the current list in memory. This list is updated
     * every time we make changes in contacts, so there are no risks of being
     * in inconsistent state.
     *
     * @param contactToFindId Long
     *
     * @return Contact if find or null otherwise
     */
    public IContact findContact(Long contactToFindId)
    {
        return this.contactsList.stream().filter( c -> c.id().equals(contactToFindId)).findFirst().get();
    }

    /**
     * Returns the current selected contact.
     *
     * @return IContact
     */
    public IContact getSelectedContact()
    {
        return this.contact;
    }

    /**
     * Return the list of professions available.
     *
     * @return Set of professions
     */
    public Set<IProfession> getProfessionsList()
    {
        if(this.professionsList.isEmpty()) {
            ProfessionsManagerXml manager = new ProfessionsManagerXml();
            this.professionsList = manager.read();
        }

        return this.professionsList;
    }
    
    /**
     * Return the list of tags available.
     * @return Set of tags
     */
    public Set<ITag> getTagsList()
    {
        if(this.tagsList.isEmpty()) {
            TagsManagerXml manager = new TagsManagerXml();
            this.tagsList = manager.read();
        }

        return this.tagsList;
    }
    
    /**
     * Add tag to Contact
     * @param tag a tag to add
     * @return success of operation
     */
    public boolean addTagToContact(ITag tag){
        if(this.contact instanceof Contact){
            ((Contact)this.contact).addTag(tag);
            return updateContact();
        }
        else
            return false;
        
    }
}
