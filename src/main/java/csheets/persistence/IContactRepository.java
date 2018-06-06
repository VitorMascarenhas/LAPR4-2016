package csheets.persistence;

import csheets.ext.contacts.domain.Contact;
import csheets.ext.contacts.domain.IContact;

/**
 *
 * @author Pedro Costa
 */
public interface IContactRepository extends IRepository<Contact, Long>
{
    void deleteById(Long contactId);

    void delete(Contact contact);

    void updateContact(Contact contact);

}
