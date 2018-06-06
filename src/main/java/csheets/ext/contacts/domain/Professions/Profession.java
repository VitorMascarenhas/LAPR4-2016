package csheets.ext.contacts.domain.Professions;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Class that implements Profession.
 *
 * @author Pedro Costa
 */
@Entity
public class Profession implements Serializable, IProfession
{
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    /**
     * Constructor.
     *
     * @param name String of profession name.
     */
    public Profession(String name)
    {
        this.name = name;
    }

    /**
     * Persistence System requirement.
     */
    protected Profession()
    {

    }

    /**
     * Retrieve the profession name.
     *
     * @return String
     */
    @Override
    public String professionName()
    {
        return this.name;
    }

    /**
     * Prints profession string.
     *
     * @return String
     */
    public String toString()
    {
        return this.name;
    }

}
