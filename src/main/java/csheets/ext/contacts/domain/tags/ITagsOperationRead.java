package csheets.ext.contacts.domain.tags;

import java.util.Set;

/**
 * Interface that defines strategy to read tags.
 * @author José Vilela
 */
public interface ITagsOperationRead
{

    Set<ITag> read();
}
