package csheets.ext.contacts.domain.tags;

import java.io.Serializable;

/**
 * Interface that implements the defines the contract for tags.
 * @author José Vilela
 */
public interface ITag extends Serializable, Comparable
{
    boolean isValid();
    
    String tagName();
    
    boolean update(ITag tag);

    Long id();
}
