package csheets.persistence.jpa.CompanyContact;

import csheets.ext.contacts.domain.CompanyContact;
import csheets.ext.contacts.domain.Contact;
import csheets.ext.contacts.domain.IContact;
import csheets.persistence.ICompanyContactRepository;
import csheets.persistence.IContactRepository;
import csheets.persistence.jpa.JpaRepository;

/**
 * Class that implements the concept of Contact.
 *
 * @author Pedro Costa
 */
public class JpaCompanyContactRepository extends JpaRepository<CompanyContact, Long> implements ICompanyContactRepository
{
    private static final String PERSISTENCE_NAME="csheets_lapr4";

    @Override
    public void updateContact(IContact contact)
    {
        this.entityManager().getTransaction().begin();
        this.entityManager().merge(contact);
        entityManager().getTransaction().commit();
    }

    @Override
    protected String persistenceUnitName()
    {
        return PERSISTENCE_NAME;
    }
}
