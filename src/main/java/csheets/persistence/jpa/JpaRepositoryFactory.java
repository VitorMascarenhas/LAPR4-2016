package csheets.persistence.jpa;

import csheets.persistence.ICompanyContactRepository;
import csheets.persistence.IContactRepository;
import csheets.persistence.IRepositoryFactory;
import csheets.persistence.ITagRepository;
import csheets.persistence.jpa.CompanyContact.JpaCompanyContactRepository;
import csheets.persistence.jpa.contact.JpaContactRepository;
import csheets.persistence.jpa.tags.JpaTagsRepository;

/**
 * Class that implements the JPA IRepository.
 *
 * @author Pedro Costa
 */
public class JpaRepositoryFactory implements IRepositoryFactory
{

    @Override
    public IContactRepository contacts()
    {
        return new JpaContactRepository();
    }

    @Override
    public ICompanyContactRepository companyContacts()
    {
        return new JpaCompanyContactRepository();
    }

    @Override
    public ITagRepository tags() {
        return new JpaTagsRepository();
    }

}
