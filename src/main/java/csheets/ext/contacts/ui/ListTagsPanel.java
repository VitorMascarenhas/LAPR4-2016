package csheets.ext.contacts.ui;

import csheets.ext.contacts.ListTagsExtension;
import csheets.ext.contacts.controller.TagsController;
import csheets.ext.contacts.domain.IContact;
import csheets.ext.contacts.domain.tags.ITag;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

/**
 * UI class with a List of Tags sorted by frequency
 * @author José Vilela - 1010500
 */
public class ListTagsPanel extends JPanel{
    
    private JPanel tablePanel;
    private JTable tagsTable;
    private JButton addButton;
    private static TagsController controller;
    private JTextField tagName;
    
    /** The Tags list */
    private JList tagsList;
        
    public ListTagsPanel(){
        // Configures panel
        super(new BorderLayout());
        setName(ListTagsExtension.NAME);

        // Creates controller
        this.controller = new TagsController();

        //Add panels
        this.setLayout(new BorderLayout());
        
        this.tablePanel = this.createTagsTablePanel();
        this.add(tablePanel, BorderLayout.NORTH);
        
        this.add(this.createAddTagPanel(), BorderLayout.SOUTH);

        //Set borders
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
    }
    
    /**
     * Create a panel with a TagsTableModel
     * @return a panel created
     */
    private JPanel createTagsTablePanel()
    {
        this.tagsTable = new JTable(this.createTagsTableData());
        this.tagsTable.setPreferredScrollableViewportSize(new Dimension(400, 200));
        this.tagsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.tagsTable.getSelectionModel().addListSelectionListener(e -> {

            int selectedRow = ListTagsPanel.this.tagsTable.getSelectedRow();

            if(selectedRow != -1)
            {
                Long id = ((TagsTableModel) tagsTable.getModel()).getSelectedTagId(selectedRow);
                ListTagsPanel.this.controller.saveTagToEditOrUpdate(ListTagsPanel.this.controller.findTag(id));
            }
        });


        JPanel tablePanel = new JPanel(new BorderLayout());

        JLabel title = new JLabel("CURRENT TAGS");
        title.setHorizontalAlignment(JLabel.CENTER);

        tablePanel.add(title,BorderLayout.NORTH);
        tablePanel.add(new JScrollPane(this.tagsTable),BorderLayout.CENTER);

        JPanel listPanel = new JPanel(new BorderLayout());
        listPanel.add(tablePanel,BorderLayout.CENTER);

        return listPanel;
    }
    
    /**
     * Create a TagsTableModel
     * @return a TagsTableModel
     */
    private TagsTableModel createTagsTableData()
    {
        Set<ITag> list = this.controller.getAllTags();
        List<IContact> listContact= this.controller.getAllContacts();
        
        return new TagsTableModel(list, listContact);
    }
    
    /**
     * Refresh the TagsTableModel
     */
    public void reloadTable()
    {
        this.remove(this.tablePanel);
        this.tablePanel = this.createTagsTablePanel();
        this.add(this.tablePanel, BorderLayout.CENTER);
        this.tablePanel.doLayout();
    }
    
    /**
     * Create a panel to add Tags 
     * @return a panel created
     */
    public JPanel createAddTagPanel(){
        JPanel root = new JPanel(new BorderLayout());

        //Title
        JLabel title = new JLabel("ADD TAGS");
        title.setHorizontalAlignment(JLabel.CENTER);

        //Fields
        JPanel fieldsPanel = new JPanel(new GridLayout(1,2));
        
        fieldsPanel.add(new JLabel("TagName:"));
        this.tagName = new JTextField();
        fieldsPanel.add(this.tagName);
        fieldsPanel.add(this.createAddButton());
        
        //Add to root
        root.add(title,BorderLayout.NORTH);
        root.add(fieldsPanel,BorderLayout.CENTER);


        return root;
    }
    
    /**
     * Create the button and listener used to add new tag.
     * @return a Button created
     */
    private JButton createAddButton()
    {
        this.addButton = new JButton("Add Tag");

        addButton.addActionListener(e -> {

            String tag = ListTagsPanel.this.tagName.getText();

            boolean success = controller.createTag(tag);
            if(success)
            {
                JOptionPane.showMessageDialog(null,"Tag added to Contact!","Contact",JOptionPane.INFORMATION_MESSAGE);
                //ContactPanel.this.clearForm();
                ListTagsPanel.this.reloadTable();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Error creating contact!","Contact",JOptionPane.ERROR_MESSAGE);
            }
        });

        return addButton;
    }
}