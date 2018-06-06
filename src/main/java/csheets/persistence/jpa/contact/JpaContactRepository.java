package csheets.persistence.jpa.contact;

import csheets.ext.contacts.domain.Contact;
import csheets.ext.contacts.domain.IContact;
import csheets.persistence.DataIntegrityViolationException;
import csheets.persistence.IContactRepository;
import csheets.persistence.jpa.JpaRepository;

/**
 * Class that implements the concept of Contact.
 *
 * @author Pedro Costa
 */
public class JpaContactRepository extends JpaRepository<Contact, Long> implements IContactRepository
{

    private static final String PERSISTENCE_NAME="csheets_lapr4";

    /**
     *
     */
    public JpaContactRepository()
    {

    }

    /**
     *
     * @return
     */
    @Override
    protected String persistenceUnitName()
    {
        return JpaContactRepository.PERSISTENCE_NAME;
    }

    /**
     *
     * @param contact
     * @return
     */
    @Override
    public void updateContact(Contact contact)
    {
        this.entityManager().getTransaction().begin();
        this.entityManager().merge(contact);
        entityManager().getTransaction().commit();
    }

    /**
     *
     * @param contact
     * @return
     * @throws DataIntegrityViolationException
     */
    @Override
    public boolean add(Contact contact) throws DataIntegrityViolationException
    {
        return contact.isValid() && super.add(contact);
    }

}
