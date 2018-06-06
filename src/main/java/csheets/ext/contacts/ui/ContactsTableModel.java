package csheets.ext.contacts.ui;

import csheets.ext.contacts.domain.CompanyContact;
import csheets.ext.contacts.domain.Contact;
import csheets.ext.contacts.domain.IContact;
import csheets.ext.contacts.domain.tags.ITag;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * A Table model used to show and edit contacts.
 * @author Pedro Costa.
 */
public class ContactsTableModel extends AbstractTableModel {

    private static final String[] COLUMNS = {"First Name", "Last Name", "Picture Name", "Profession","Company", "Type", "Tag"};
    private final String[][] data;
    private List<IContact> contacts;

    /**
     * Make the table model using a list of contacts.
     * @param contacts List of classes implementing icontact interface
     */
    public ContactsTableModel(List<IContact> contacts)
    {
        this.contacts = contacts;
        
        this.data = new String[contacts.size()][COLUMNS.length+2];
        int i=0;
        

        for(IContact c: contacts)
        {
            if(c instanceof Contact)
            {
                Contact contact = (Contact) c;
                this.data[i][0] = contact.getFirstName();
                this.data[i][1] = contact.getLastName();
                this.data[i][2] = contact.getPictureName();
                if(contact.profession() != null)
                    this.data[i][3] = contact.profession().toString();

                if(contact.company() != null)
                    this.data[i][4] = contact.company().toString();

                this.data[i][5] = "Personal Contact";
                
                String tags="";
                for(ITag tag : contact.tags())
                    tags += tag.tagName() + " ; ";
                this.data[i][6] = tags;
                this.data[i][7] = contact.id().toString();
                
            }
            else
            {
                CompanyContact companyContact = (CompanyContact) c;
                this.data[i][0] = companyContact.name();
                this.data[i][5] = "Company Contact";
                this.data[i][7] = companyContact.id().toString();
            }

            i++;
        }
    }

    /**
     * Retrieve columns number.
     *
     * @return int
     */
    @Override
    public int getColumnCount() {
        return COLUMNS.length;
    }

    /**
     * Retrieve rows number.
     *
     * @return int
     */
    @Override
    public int getRowCount() {
        return data.length;
    }

    /**
     * Get the column number
     *
     * @param col int of the column position
     *
     * @return String
     */
    @Override
    public String getColumnName(int col) {
        return COLUMNS[col];
    }

    /**
     * Get the value at certain position of the table.
     *
     * @param row int of row
     * @param col int of column
     *
     * @return object at position received
     */
    @Override
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    /**
     * Get the class of the column indicated.
     *
     * @param c int of the column
     *
     * @return Class String
     */
    @Override
    public Class getColumnClass(int c)
    {
        return String.class;
    }

    /**
     * Controls the editable cells.
     *
     * @param row int of row number
     * @param col int of column number
     *
     * @return boolean true if editable, false otherwise.
     */
    @Override
    public boolean isCellEditable(int row, int col)
    {
        return false;
    }

    /*
     * Update a value of table cell.
     */
    @Override
    public void setValueAt(Object value, int row, int col)
    {
        data[row][col] = (String)value;
        fireTableCellUpdated(row, col);
    }

    /**
     * Get the contact id according the row number received.
     *
     * @param row int of the row
     *
     * @return Long of the id
     */
    public Long getSelectedContactId(int row)
    {
        return Long.parseLong(data[row][7]);
    }

    /**
     * Get the contact id according the row number received.
     *
     * @param row int of the row
     *
     * @return Contact associated with the received row
     */
    public IContact getSelectedContact(int row)
    {
        return this.contacts.get(row);
    }
}


