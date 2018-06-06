package csheets.ext.contacts.ui;

import csheets.ext.contacts.domain.Contact;
import csheets.ext.contacts.domain.IContact;
import csheets.ext.contacts.domain.tags.ITag;
import csheets.ext.contacts.domain.tags.Tag;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.table.AbstractTableModel;

/**
 * A Table model used to show and edit tags.
 * @author José Vilela - 1010500
 */
public class TagsTableModel extends AbstractTableModel {
    
    private static final String[] COLUMNS = {"Tag", "Frequency"};
    private final String[][] data;
    private Set<ITag> tags;
    private List<IContact> contacts;

    /**
     * Constructor with tags and contacts as parameters
     * @param tags a Set of tags avaliable
     * @param contacts a List of Contacts avaliable
     */
    public TagsTableModel(Set<ITag> tags, List<IContact> contacts)
    {
        this.contacts = contacts;
        this.tags = tags;
        this.data = new String[tags.size()][COLUMNS.length+2];
        int i=0;
        //int freq;
        List<String> currentTags = new ArrayList<>();

        calculateFrequency();
        
        List<Tag> tagsToSort = new ArrayList<>();
        
        for(ITag t: tags)
        {
            Tag tag = (Tag) t;
            if(!currentTags.contains(tag.tagName())){
                tagsToSort.add(tag);
            }
        }
        
        Collections.sort(tagsToSort);
        
        for(Tag t: tagsToSort){
            this.data[i][0] = t.tagName();
            //freq = calculateFrequency(tag.tagName());
            this.data[i][1] = String.valueOf(t.getCount());
            this.data[i][2] = t.id().toString();
            i++;
        }
        
    }
    
    /**
     * Calculate then frequency of all tags
     * this feature will be improved in the future due to its low performance
     */
    public void calculateFrequency(){
        Set<ITag> cTags;
        
        for(ITag t: tags)
        {
            
            Tag tag = (Tag) t;
            cTags = new HashSet<>();
            int i=0;
            for (IContact c : this.contacts){
                Contact contact = (Contact) c;
                cTags = contact.tags();
                for(ITag t2 : cTags){
                    Tag tag2 = (Tag) t2;
                    if(tag2.tagName().equals(tag.tagName()))
                        i++;
                }
            }
            tag.setCount(i);
        }
    }
    
    /**
     * Retrieve the number of rows in the table
     * @return the number of rows in the table
     */
    @Override
    public int getRowCount() {
        return data.length;
    }

    /**
     * Retrieve the number of columns in the table
     * @return the number of columns in the table
     */
    @Override
    public int getColumnCount() {
        return COLUMNS.length;
    }

    /**
     * returns the Object of the cell identified by the given parameters
     * @param rowIndex index of row
     * @param columnIndex index of collumn
     * @return the Object of the cell identified by the given parameters
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }
    
    /**
     * Retrieve the Id of Tag in the row given as a parameter
     * @param row a row of the tag
     * @return the Id of Tag
     */
    public Long getSelectedTagId(int row)
    {
        return Long.parseLong(data[row][2]);
    }
    
}
