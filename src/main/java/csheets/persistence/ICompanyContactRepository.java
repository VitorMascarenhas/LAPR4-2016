package csheets.persistence;

import csheets.ext.contacts.domain.CompanyContact;
import csheets.ext.contacts.domain.IContact;

/**
 * Created by macbook on 09/06/16.
 */
public interface ICompanyContactRepository extends IRepository<CompanyContact, Long>
{
    void updateContact(IContact contact);
    void deleteById(Long contactId);
}
