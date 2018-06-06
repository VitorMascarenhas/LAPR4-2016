package csheets.ext.contacts.controller;

import csheets.ext.contacts.domain.Contact;
import csheets.ext.contacts.domain.IContact;
import csheets.ext.contacts.domain.tags.ITag;
import csheets.ext.contacts.domain.tags.Tag;
import csheets.ext.contacts.domain.tags.TagFactory;
import csheets.ext.contacts.domain.tags.TagsManagerXml;
import csheets.persistence.IContactRepository;
import csheets.persistence.ITagRepository;
import csheets.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author José Vilela - 1010500
 */
public class TagsController {
    private Set<ITag> tagsList;
    private ITagRepository tagRepository;
    private IContactRepository contactRepository;
    
    /* List of contacts in db*/
    private List<IContact> contactsList;
    
    /* Tag to delete or edit */
    private ITag tag;
    
    /**
     * Default Constructor
     */
    public TagsController(){
        this.contactRepository = PersistenceContext.repositories().contacts();
        this.tagRepository = PersistenceContext.repositories().tags();
        this.tagsList = new HashSet<>();
    }
    
    /**
     * Create a new tag in DB
     * @param tag a tag to be created
     * @return success of operation
     */
    public boolean createTag(String tag)
    {
        TagFactory factory = new TagFactory();

        try {
            return this.tagRepository.add(factory.newTag(tag));
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Return all tags without duplication
     * @return a set of all tags avaliable
     */
    public Set<ITag> getAllTags()
    {
        this.tagsList = new HashSet<>();
        List<String> tempList = new ArrayList<>();
        Iterator<Tag> it = this.tagRepository.all().iterator();
        Tag t;
        while(it.hasNext()){
            t = it.next();
            if(!tempList.contains(t.tagName())){
                this.tagsList.add(t);
                tempList.add(t.tagName());
            }
        }
        return this.tagsList;
    }
    
    /**
     * Return the list of tags available.
     * @return Set of tags
     */
    public Set<ITag> getTagsList()
    {
        if(this.tagsList.isEmpty()) {
            TagsManagerXml manager = new TagsManagerXml();
            this.tagsList = manager.read();
        }

        return this.tagsList;
    }
    
    public ITag findTag(Long tagToFindId)
    {
        return this.tagsList.stream().filter( c -> c.id().equals(tagToFindId)).findFirst().get();
    }
    
    public void saveTagToEditOrUpdate(ITag tag)
    {
        this.tag = tag;
    }
    
    /**
     * Get a list of all contacts avaliable in contactRepository
     * @return a list of all contacts
     */
    public List<IContact> getAllContacts()
    {
        this.contactsList = new ArrayList<>();
        Iterator<Contact> it = this.contactRepository.all().iterator();

        while(it.hasNext())
            this.contactsList.add(it.next());

        return this.contactsList;
    }
    
    
}
