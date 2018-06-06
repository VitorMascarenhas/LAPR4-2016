package csheets.ext.contacts.domain;

import csheets.ext.contacts.domain.Contact;
import csheets.ext.contacts.domain.Professions.IProfession;
import csheets.ext.contacts.domain.Professions.Profession;
import csheets.ext.contacts.domain.tags.ITag;
import csheets.ext.contacts.domain.tags.Tag;

/**
 * A factory to centralize the creating of contacts.
 * @author Pedro Costa
 */
public class ContactFactory {

    public ContactFactory()
    {

    }

    public Contact newContact(String firstName, String lastName, String pictureName)
    {
        return new Contact(firstName,lastName,pictureName);
    }

    public Contact newContactWithProfession(String firstName, String lastName, String pictureName, IProfession profession, CompanyContact company)
    {
        return new Contact(firstName,lastName,pictureName,profession,company);
    }
    
    public Contact newContactWithTag(String firstName, String lastName, String pictureName, IProfession profession, CompanyContact company, ITag tag)
    {
        return new Contact(firstName,lastName,pictureName,profession,company,tag);
    }

    public CompanyContact newCompanyContact(String name)
    {
        return new CompanyContact(name);
    }

}
