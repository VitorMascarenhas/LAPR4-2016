package csheets.ext.contacts.ui;

import csheets.ext.contacts.ListTagsExtension;
import csheets.ext.contacts.controller.SearchContactsByTagsController;
import csheets.ext.contacts.controller.TagsController;
import csheets.ext.contacts.domain.CompanyContact;
import csheets.ext.contacts.domain.IContact;
import csheets.ext.contacts.domain.Professions.IProfession;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 * UI class to Search Contacts by tags and edit contacts
 * @author José Vilela - 1010500
 */
public class SearchContactsByTagsPanel extends JPanel{
    
    private static SearchContactsByTagsController controller;
    
    private JPanel tablePanel;
    private JTable contactsTable;
    private JTextField search;
    
    private JButton searchButton;

    /**
     * Default contructor
     */
    SearchContactsByTagsPanel() {
        // Configures panel
        super(new BorderLayout());
        setName(ListTagsExtension.NAME);

        // Creates controller
        this.controller = new SearchContactsByTagsController();

        //Add panels
        this.setLayout(new BorderLayout());
        this.add(this.createNewSearchPanel(), BorderLayout.NORTH);
        
        
    }
    
    /**
     * Create a new Jpanel to search Contacs by tags
     * @return a jpanel created
     */
    private JPanel createNewSearchPanel()
    {
        JPanel root = new JPanel(new BorderLayout());

        //Title
        JLabel title = new JLabel("SEARCH CONTACTS");
        title.setHorizontalAlignment(JLabel.CENTER);

        //Fields
        JPanel fieldsPanel = new JPanel(new GridLayout(1,2));

        this.search = new JTextField();
        fieldsPanel.add(this.search);

        fieldsPanel.add(createSearchButton());

        //Add to root
        root.add(title,BorderLayout.NORTH);
        root.add(fieldsPanel,BorderLayout.CENTER);

        return root;
    }
    
    /**
     * Create the button and listener used to search contacts by tags.
     * @return a button created
     */
    private JButton createSearchButton()
    {
        this.searchButton = new JButton("Search");

        searchButton.addActionListener(e -> {
            
            this.tablePanel = this.createContactsTablePanel();

            //Add contactsTable
            this.add(this.tablePanel, BorderLayout.CENTER);
            this.reloadTable();
            /*IProfession profession = (IProfession) ContactPanel.this.professionsCombo.getSelectedItem();
            CompanyContact company = (CompanyContact) ContactPanel.this.companiesCombo.getSelectedItem();

            boolean success = controller.createContact(firstName.getText(), lastName.getText(), pictureName, profession, company);
            if(success)
            {
                JOptionPane.showMessageDialog(null,"Contact created!","Contact",JOptionPane.INFORMATION_MESSAGE);
                ContactPanel.this.clearForm();
                ContactPanel.this.reloadTable();

            }
            else
            {
                JOptionPane.showMessageDialog(null,"Error creating contact!","Contact",JOptionPane.ERROR_MESSAGE);
            }*/
        });

        return searchButton;
    }
    
    /**
     * Create the panel with a JTable with all the contacts.
     * @return JPanel with all components needed
     */
    private JPanel createContactsTablePanel()
    {
        this.contactsTable = new JTable(this.createContactsTableData());
        this.contactsTable.setPreferredScrollableViewportSize(new Dimension(400, 150));
        this.contactsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.contactsTable.getSelectionModel().addListSelectionListener(e -> {

            int selectedRow = SearchContactsByTagsPanel.this.contactsTable.getSelectedRow();

            if(selectedRow != -1)
            {
                Long id = ((ContactsTableModel) contactsTable.getModel()).getSelectedContactId(selectedRow);
                //SearchContactsByTagsPanel.this.controller.saveContactToEditOrUpdate(SearchContactsByTagsPanel.this.controller.findContact(id));

                //We have selection so we can edit or delete a contact
                //SearchContactsByTagsPanel.this.editButton.setEnabled(true);
                //SearchContactsByTagsPanel.this.removeButton.setEnabled(true);
                //SearchContactsByTagsPanel.this.cancelButton.setEnabled(true);
                //SearchContactsByTagsPanel.this.tagsCombo.setEnabled(true);
                //SearchContactsByTagsPanel.this.addTagButton.setEnabled(true);
            }
        });


        JPanel tablePanel = new JPanel(new BorderLayout());

        JLabel title = new JLabel("CURRENT CONTACTS");
        title.setHorizontalAlignment(JLabel.CENTER);

        tablePanel.add(title,BorderLayout.NORTH);
        tablePanel.add(new JScrollPane(this.contactsTable),BorderLayout.CENTER);

        JPanel listPanel = new JPanel(new BorderLayout());
        listPanel.add(tablePanel,BorderLayout.CENTER);

        return listPanel;
    }
    
    /**
     * Create a new Table Model for contacts.
     *
     * @return ContactsTableModel
     */
    private ContactsTableModel createContactsTableData()
    {
        List<IContact> list = this.controller.getContacts(this.search.getText());

        return new ContactsTableModel(list);
    }
    
    /**
     * Remove and add a new contactsTable with updated contacts.
     */
    private void reloadTable()
    {
        this.remove(this.tablePanel);
        this.tablePanel = this.createContactsTablePanel();
        this.add(this.tablePanel, BorderLayout.CENTER);
    }
}
