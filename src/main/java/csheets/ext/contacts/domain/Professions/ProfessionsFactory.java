package csheets.ext.contacts.domain.Professions;

/**
 * Factory to generate new professions.
 *
 * @author Pedro Costa
 */
public class ProfessionsFactory
{
    IProfession newProfession(String name)
    {
        return new Profession(name);
    }
}
