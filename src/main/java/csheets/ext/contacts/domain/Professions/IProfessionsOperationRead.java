package csheets.ext.contacts.domain.Professions;

import java.util.Set;

/**
 * Interface that defines strategy to read professions.
 *
 * @author Pedro Costa
 */
public interface IProfessionsOperationRead
{
    Set<IProfession> read();
}
