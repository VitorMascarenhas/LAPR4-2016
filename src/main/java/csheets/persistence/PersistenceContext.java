/**
 *
 */
package csheets.persistence;

import csheets.persistence.jpa.JpaRepositoryFactory;

/**
 * Provides easy access to the persistence layer. works as a factory of
 * factories. For now only return JPA Persistence type.
 */
public final class PersistenceContext
{

    public static IRepositoryFactory repositories()
    {
        return new JpaRepositoryFactory();
    }

    private PersistenceContext()
    {
    }
}
