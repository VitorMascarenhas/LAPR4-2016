package csheets.ext.contacts.ui;

import csheets.ext.contacts.domain.CompanyContact;
import csheets.ext.contacts.domain.Contact;
import csheets.ext.contacts.ContactsExtension;
import csheets.ext.contacts.controller.ContactEditionController;
import csheets.ext.contacts.domain.IContact;
import csheets.ext.contacts.domain.Professions.IProfession;
import csheets.ext.contacts.domain.tags.ITag;
import csheets.ext.contacts.domain.tags.Tag;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * A panel for adding or editing a contact.
 * @author Pedro Costa.
 */
public class ContactPanel extends JPanel{

    private static final String IMG_FOLDER = "./contactsPictures/";
    private static final String DEFAULT_IMG = "src/main/resources/csheets/res/img/user.jpg";
    private static ContactEditionController controller;

    private JTextField firstName;
    private JTextField lastName;
    private String pictureName;
    private JPanel picturePanel;
    private JPanel tablePanel;
    private JTable contactsTable;

    private JButton addButton;
    private JButton addTagButton;
    private JButton editButton;
    private JButton removeButton;
    private JButton cancelButton;
    private JButton confirmUpdateButton;
    private JComboBox professionsCombo;
    private JComboBox companiesCombo;
    private JComboBox tagsCombo;

    /**
     * Creates the panel for the contacts extension.
     *
     */
    public ContactPanel()
    {
        // Configures panel
        super(new BorderLayout());
        setName(ContactsExtension.NAME);

        // Creates controller
        this.controller = new ContactEditionController();

        //Add panels
        this.setLayout(new BorderLayout());
        this.add(this.createNewContactPanel(), BorderLayout.NORTH);
        this.tablePanel = this.createContactsTablePanel();

        //Add contactsTable
        this.add(this.tablePanel, BorderLayout.CENTER);

        //Set borders
        this.setBorder(new EmptyBorder(10, 10, 10, 10));
    }

    /**
     * Create the panel with the fields needed to insert
     * new contact.
     *
     * @return JPanel with all components needed
     */
    private JPanel createNewContactPanel()
    {
        JPanel root = new JPanel(new BorderLayout());

        //Title
        JLabel title = new JLabel("NEW CONTACT");
        title.setHorizontalAlignment(JLabel.CENTER);

        //Fields
        JPanel fieldsPanel = new JPanel(new GridLayout(5,2));

        fieldsPanel.add(new JLabel("[First] Name"));
        this.firstName = new JTextField();
        fieldsPanel.add(this.firstName);

        fieldsPanel.add(new JLabel("Last Name"));
        this.lastName = new JTextField();
        fieldsPanel.add(this.lastName);
        fieldsPanel.add(new JLabel("Profession"));
        fieldsPanel.add(this.createProfessionsCombo());

        fieldsPanel.add(new JLabel("Company"));
        fieldsPanel.add(this.createCompaniesCombo());

        //Buttons and picture
        JPanel buttonsPanel = new JPanel(new BorderLayout());
        this.picturePanel = this.createPicturePanel(ContactPanel.DEFAULT_IMG);

        JPanel panel = new JPanel(new GridLayout(10,1));
        panel.add(this.createPictureSelectButton());
        panel.add(createAddButton());
        panel.add(createAddCompanyButton());
        panel.add(this.createEditButton());
        panel.add(this.createConfirmUpdateButton());
        panel.add(this.createRemoveButton());
        panel.add(this.createCancelButton());
        panel.add(this.createAddTagButton());
        panel.add(this.createRemoveTagButton());
        panel.add(this.createTagsCombo());
        
        buttonsPanel.add(this.picturePanel,BorderLayout.CENTER);
        buttonsPanel.add(panel,BorderLayout.SOUTH);

        //Add to root
        root.add(title,BorderLayout.NORTH);
        root.add(fieldsPanel,BorderLayout.CENTER);
        root.add(buttonsPanel,BorderLayout.SOUTH);

        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        return root;
    }

    /**
     * Create a picture panel used to show images.
     *
     * @param picture name of the picture to show.
     *
     * @return JPanel with the picture loaded.
     */
    private JPanel createPicturePanel(String picture)
    {
        JPanel picturePanel = new JPanel(new BorderLayout());
        picturePanel.setPreferredSize(new Dimension(150,160));

        picturePanel.add(createImageView(picture));

        return picturePanel;
    }

    /**
     * Create a label with a image inside.
     *
     * @param picture String with path and name of picture
     */
    private JLabel createImageView(String picture)
    {
        ImageIcon icon = new ImageIcon(picture);
        JLabel label = new JLabel(icon);
        label.setMaximumSize(new Dimension(150,160));
        return label;
    }

    /**
     * Create the button and listener used to add new contact with tag.
     * @return a AddButton created
     */
    private JButton createAddTagButton()
    {
        this.addTagButton = new JButton("Add Tag");
        this.addTagButton.setEnabled(false);
        
        addTagButton.addActionListener(e -> {

            ITag tag = (ITag) ContactPanel.this.tagsCombo.getSelectedItem();

            ITag newTag = new Tag(tag.tagName());
            boolean success = controller.addTagToContact(newTag);
            if(success)
            {
                JOptionPane.showMessageDialog(null,"Tag added to Contact!","Contact",JOptionPane.INFORMATION_MESSAGE);
                ContactPanel.this.clearForm();
                ContactPanel.this.reloadTable();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Error creating contact!","Contact",JOptionPane.ERROR_MESSAGE);
            }
        });

        return addTagButton;
    }
    /**
     * Create the button and listener used to add new contact.
     *
     * @return JButton
     */
    private JButton createAddButton()
    {
        this.addButton = new JButton("Add");

        addButton.addActionListener(e -> {

            IProfession profession = (IProfession) ContactPanel.this.professionsCombo.getSelectedItem();
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
            }
        });

        return addButton;
    }

    /**
     * Create the button and listener used to add new company contact.
     *
     * @return JButton
     */
    private JButton createAddCompanyButton()
    {
        this.addButton = new JButton("Add Company");

        addButton.addActionListener(e -> {

            boolean success = controller.createCompanyContact(firstName.getText());
            if(success)
            {
                JOptionPane.showMessageDialog(null,"Company Contact created!","Contact",JOptionPane.INFORMATION_MESSAGE);
                ContactPanel.this.clearForm();
                ContactPanel.this.reloadTable();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Error creating company contact!","Contact",JOptionPane.ERROR_MESSAGE);
            }
        });

        return addButton;
    }

    /**
     * Create the button and the listener to fire a update contact event.
     *
     * @return JButton
     */
    private JButton createEditButton()
    {
        this.editButton = new JButton("Edit");
        this.editButton.setEnabled(false);
        editButton.addActionListener((ActionEvent e) -> {

            IContact icontact = ContactPanel.this.controller.getSelectedContact();
            if(icontact != null)
            {
                Contact contact = (Contact)icontact;
                ContactPanel.this.firstName.setText(contact.getFirstName());
                ContactPanel.this.lastName.setText(contact.getLastName());
                ContactPanel.this.pictureName = contact.getPictureName();
                ContactPanel.this.professionsCombo.getModel().setSelectedItem(contact.profession());
                ContactPanel.this.updatePicture(IMG_FOLDER + contact.getPictureName());

                //Disable other buttons and enable the confirm update
                ContactPanel.this.removeButton.setEnabled(false);
                ContactPanel.this.addButton.setEnabled(false);
                ContactPanel.this.confirmUpdateButton.setEnabled(true);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Error updating contact!","Contact",JOptionPane.ERROR_MESSAGE);
            }
        });

        return this.editButton;
    }

    /**
     * Create the button and the listener to fire a update contact event.
     *
     * @return JButton
     */
    private JButton createCancelButton()
    {
        this.cancelButton = new JButton("Cancel");
        this.cancelButton.setEnabled(false);
        cancelButton.addActionListener(e -> ContactPanel.this.resetForm());

        return this.cancelButton;
    }

    /**
     * Creates the button and the listener used to remove a contact.
     *
     * @return JButton
     */
    private JButton createRemoveTagButton()
    {
        this.removeButton = new JButton("Remove Tag");
        this.removeButton.setEnabled(false);
        
        this.removeButton.addActionListener(e -> {
            ITag tag = (ITag) ContactPanel.this.tagsCombo.getSelectedItem();
            if(ContactPanel.this.controller.removeTag(tag))
            {
                JOptionPane.showMessageDialog(null,"Tag removed from contact!","Contact",JOptionPane.INFORMATION_MESSAGE);
                ContactPanel.this.reloadTable();
                ContactPanel.this.resetForm();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Error removing tag from contact!","Contact",JOptionPane.ERROR_MESSAGE);
            }
        });
        return this.removeButton;
    }
    
    /**
     * Creates the button and the listener used to remove a contact.
     *
     * @return JButton
     */
    private JButton createRemoveButton()
    {
        this.removeButton = new JButton("Remove");
        this.removeButton.setEnabled(false);
        this.removeButton.addActionListener(e -> {
            if(ContactPanel.this.controller.removeContact())
            {
                JOptionPane.showMessageDialog(null,"Contact removed!","Contact",JOptionPane.INFORMATION_MESSAGE);
                ContactPanel.this.reloadTable();
                ContactPanel.this.resetForm();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Error removing contact!","Contact",JOptionPane.ERROR_MESSAGE);
            }
        });
        return this.removeButton;
    }

    /**
     * Creates the button and the listener used to select a picture.
     *
     * @return JButton
     */
    private JButton createPictureSelectButton()
    {
        JFileChooser fileChooser = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
        fileChooser.setFileFilter(filter);

        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        JButton button = new JButton("Select picture");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = fileChooser.showOpenDialog(getParent());

                if (result == JFileChooser.APPROVE_OPTION) {

                    File folder = new File(IMG_FOLDER);

                    // if the directory does not exist, create it
                    if (!folder.exists()) {
                        folder.mkdir();
                    }
                    File file = fileChooser.getSelectedFile();
                    file.renameTo(new File(IMG_FOLDER + file.getName()));
                    ContactPanel.this.pictureName = file.getName();

                    ContactPanel.this.picturePanel.removeAll();
                    ContactPanel.this.updatePicture(IMG_FOLDER + file.getName());
                }
            }
        });

        return button;
    }

    /**
     * Create the panel with a JTable with all the contacts.
     *
     * @return JPanel with all components needed
     */
    private JPanel createContactsTablePanel()
    {
        this.contactsTable = new JTable(this.createContactsTableData());
        this.contactsTable.setPreferredScrollableViewportSize(new Dimension(400, 70));
        this.contactsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.contactsTable.getSelectionModel().addListSelectionListener(e -> {

            int selectedRow = ContactPanel.this.contactsTable.getSelectedRow();

            if(selectedRow != -1)
            {
                Long id = ((ContactsTableModel) contactsTable.getModel()).getSelectedContactId(selectedRow);
                ContactPanel.this.controller.saveContactToEditOrUpdate(ContactPanel.this.controller.findContact(id));

                //We have selection so we can edit or delete a contact
                ContactPanel.this.editButton.setEnabled(true);
                ContactPanel.this.removeButton.setEnabled(true);
                ContactPanel.this.cancelButton.setEnabled(true);
                ContactPanel.this.tagsCombo.setEnabled(true);
                ContactPanel.this.addTagButton.setEnabled(true);
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
        List<IContact> list = this.controller.getAllContacts();

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
        this.companiesCombo.setModel(new DefaultComboBoxModel(this.controller.getAllCompaniesContacts().toArray()));
    }

    /**
     * Clean the forms used in creating of a user.
     */
    private void clearForm()
    {
        this.firstName.setText("");
        this.lastName.setText("");
        this.companiesCombo.setSelectedIndex(-1);
        this.professionsCombo.setSelectedIndex(-1);
        this.updatePicture(DEFAULT_IMG);
    }

    /**
     * Update the picture of panel.
     *
     * @param picture String with the name to update
     */
    private void updatePicture(String picture)
    {
        ContactPanel.this.picturePanel.removeAll();
        ContactPanel.this.picturePanel.add(ContactPanel.this.createImageView(picture));
        ContactPanel.this.picturePanel.doLayout();
    }

    /**
     * Reset the panel to the born state.
     */
    private void resetForm()
    {
        this.clearForm();
        this.controller.saveContactToEditOrUpdate(null);
        this.addButton.setEnabled(true);
        this.removeButton.setEnabled(false);
        this.editButton.setEnabled(false);
        this.cancelButton.setEnabled(false);
        this.confirmUpdateButton.setEnabled(false);
        this.addTagButton.setEnabled(false);
        this.tagsCombo.setEnabled(false);
        this.contactsTable.clearSelection();
    }

    /**
     * Create a button used to confirm the update of contact properties.
     *
     * @return JButton
     */
    private JButton createConfirmUpdateButton()
    {
        this.confirmUpdateButton = new JButton("Confirm update");
        this.confirmUpdateButton.setEnabled(false);
        this.confirmUpdateButton.addActionListener(e -> {
            IProfession selectedProfession = (IProfession)professionsCombo.getSelectedItem();
            CompanyContact companyContact = (CompanyContact) companiesCombo.getSelectedItem();
            ITag tag = (ITag)tagsCombo.getSelectedItem();
            if(ContactPanel.this.controller.editContact(firstName.getText(),lastName.getText(),pictureName,selectedProfession,companyContact, tag))
            {
                JOptionPane.showMessageDialog(null,"Contact updated!","Contact",JOptionPane.INFORMATION_MESSAGE);
                ContactPanel.this.resetForm();
                ContactPanel.this.reloadTable();
            } else {
                JOptionPane.showMessageDialog(null,"Error updating contact!","Contact",JOptionPane.ERROR_MESSAGE);
            }


        });

        return this.confirmUpdateButton;
    }

    /**
     * Creates the combo for the profession selection.
     *
     * @return JComboBox
     */
    private JComboBox createProfessionsCombo()
    {
        Object[] professions = this.controller.getProfessionsList().toArray();
        this.professionsCombo = new JComboBox(professions);
        this.professionsCombo.setSelectedIndex(-1);

        return this.professionsCombo;
    }

    /**
     * Creates the combo for the company contacts selection.
     *
     * @return JComboBox
     */
    private JComboBox createCompaniesCombo()
    {
        Object[] companies = this.controller.getAllCompaniesContacts().toArray();
        this.companiesCombo = new JComboBox(companies);
        this.companiesCombo.setSelectedIndex(-1);

        return this.companiesCombo;
    }
    
    /**
     * Creates the combo for the tag selection.
     *
     * @return JComboBox
     */
    private JComboBox createTagsCombo()
    {
        //Object[] tags = this.controller.getTagsList().toArray();
        
        Object[] tags = this.controller.getAllTags().toArray();
        this.tagsCombo = new JComboBox(tags);
        this.tagsCombo.setSelectedIndex(-1);
        this.tagsCombo.setEnabled(false);
        return this.tagsCombo;
    }
}
