package csheets.ext.contacts.domain.tags;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Class that implements Tag.
 *
 * @author José Vilela 1010500
 */
@Entity
public class Tag implements Serializable, ITag, Comparable 
{
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int count;

    /**
     * Constructor.
     *
     * @param name String of profession name.
     */
    public Tag(String name)
    {
        this.name = name;
        this.count = 0;
    }

    /**
     * Persistence System requirement.
     */
    protected Tag()
    {
    }

    /**
     * Prints Tag string.
     * @return a tag string
     */
    @Override
    public String toString()
    {
        return this.name;
    }

    /**
     * Retrieve the Tag's name.
     * @return the tag's name
     */
    @Override
    public String tagName() {
        return this.name;
    }
    
    /**
     * Retrieve the tag's id.
     * @return the tag's id.
     */
    @Override
    public Long id()
    {
        return this.id;
    }

    /**
     * Update the tag given by parameter
     * @param tag a tag to be updated
     * @return sucess of operation
     */
    @Override
    public boolean update(ITag tag) {
        Tag newTag = (Tag) tag;

        if(newTag.isValid()){
            this.name = newTag.tagName();
            return true;
        }

        return false;
    }

    /**
     * Verify if the current tag is valid
     * @return true if the tag is valid and false otherwise
     */
    @Override
    public boolean isValid() {
        if(this.name == null || this.name.length() == 0)
            return false;

        return true;
    }
    
    /**
     * Get the frequency of the current tag
     * @return a frequency of a current tag
     */
    public int getCount(){
        return count;
    }
    
    /**
     * Change the frequency of current tag
     * @param count the new frequency of tag
     */
    public void setCount(int count){
        this.count = count;
    }

    /**
     * Compare the frequency of current tag with the frequency of tag given by parameter
     * @param o the tag to be compared
     * @return  0 if the frequency is equal;
     *          less then 0 if the tag given by parameter is higher than the current tag
     *          greater than 0 outherwise
     */
    @Override
    public int compareTo(Object o) {
        int compareCount = ((Tag)o).getCount();
        
        return compareCount-this.getCount();
    }

}
