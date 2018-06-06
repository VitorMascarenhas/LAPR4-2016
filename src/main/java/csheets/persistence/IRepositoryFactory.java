/**
 *
 */
package csheets.persistence;

/**
 * @author Pedro Costa
 */
public interface IRepositoryFactory
{
    IContactRepository contacts();
    ICompanyContactRepository companyContacts();
    ITagRepository tags();
}
