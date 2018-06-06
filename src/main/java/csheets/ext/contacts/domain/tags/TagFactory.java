package csheets.ext.contacts.domain.tags;
/**
 * Factory to generate new tags.
 * @author José Vilela
 */
public class TagFactory
{
    public Tag newTag(String name)
    {
        return new Tag(name);
    }
}
