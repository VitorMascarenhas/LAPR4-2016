package csheets.persistence;

import csheets.ext.contacts.domain.tags.Tag;
import java.util.List;

/**
 *
 * @author José Vilela - 1010500
 */
public interface ITagRepository extends IRepository<Tag, Long>{
    
    void deleteById(Long TagId);

    void delete(Tag tag);

    @Override
    long size();
    
    @Override
    List<Tag> all();
    
    @Override
    Tag findById(Long TagId);
    
    @Override
    Tag save(Tag tag);

    Tag update(Tag tag);

    void remove(Tag selectedTag);
        
}
