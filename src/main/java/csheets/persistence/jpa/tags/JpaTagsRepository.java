package csheets.persistence.jpa.tags;

import csheets.ext.contacts.domain.tags.Tag;
import csheets.persistence.DataIntegrityViolationException;
import csheets.persistence.ITagRepository;
import csheets.persistence.jpa.JpaRepository;

/**
 *
 * @author José Vilela - 1010500
 */
public class JpaTagsRepository extends JpaRepository<Tag, Long> implements ITagRepository{

    private static final String PERSISTENCE_NAME="csheets_lapr4";
    
    /**
     * Deafault constructor
     */
    public JpaTagsRepository()
    {

    }
    
    /**
     * 
     * @return 
     */
    @Override
    protected String persistenceUnitName() {
        return JpaTagsRepository.PERSISTENCE_NAME;
    }
    
    public void updateTag(Tag tag)
    {
        this.entityManager().getTransaction().begin();
        this.entityManager().merge(tag);
        entityManager().getTransaction().commit();
    }
    
    @Override
    public boolean add(Tag tag) throws DataIntegrityViolationException
    {
        return super.add(tag);
    }
    
    @Override
	public long size() {
		return this.size();
    }   
    
    @Override
    public Tag findById(Long id) {
		return super.findById(id);
    }
    
    @Override
    public Tag save(Tag tag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Tag update(Tag tag) {
       return super.save(tag);
    }
    
    @Override
    public void remove(Tag selectedTag) {
        super.delete(selectedTag);
    }
}
