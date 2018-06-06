package csheets.ext.agenda.ui;

import csheets.ext.agenda.controller.AgendaController;
import csheets.ext.agenda.domain.IEvent;
import csheets.ext.agenda.domain.ISchedulable;
import csheets.ext.contacts.ContactsExtension;
import csheets.ext.contacts.domain.Contact;
import csheets.ext.contacts.domain.IContact;
import csheets.ext.contacts.ui.ContactPanel;
import csheets.ext.contacts.ui.ContactsTableModel;
import csheets.ui.ctrl.UIController;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * A panel for adding or editing a contact.
 * @author Pedro Costa.
 */
public class AgendaPanel extends JPanel
{
    private static AgendaController controller;

    private JTextField description;
    private JTextField dueDate;

    private JButton addButton;
    private JButton editButton;
    private JButton removeButton;
    private JButton cancelButton;
    private JButton confirmUpdateButton;

    private JPanel tablePanel;
    private JTable agendaTable;
    private JComboBox contactsCombo;

    /**
     * Creates the panel for the contacts extension.
     *
     * @param uiController
     */
    public AgendaPanel(UIController uiController)
    {
        // Configures panel
        super(new BorderLayout());
        setName(ContactsExtension.NAME);

        // Creates controller
        this.controller = new AgendaController();

        //Set borders
        this.setBorder(new EmptyBorder(10, 10, 10, 10));

        //Add comboBox to select contact
        this.add(this.createContactsCombo(),BorderLayout.SOUTH);

        //Add new event form
        this.add(this.createNewEventPanel(),BorderLayout.NORTH);

        this.tablePanel = this.createEventsTablePanel();
        this.add(this.tablePanel,BorderLayout.CENTER);

    }

    /**
     * Create the panel with the fields needed to insert
     * new contact.
     *
     * @return JPanel with all components needed
     */
    private JPanel createNewEventPanel()
    {
        JPanel root = new JPanel(new BorderLayout());

        //Title
        JLabel title = new JLabel("NEW Event");
        title.setHorizontalAlignment(JLabel.CENTER);

        //Fields
        JPanel fieldsPanel = new JPanel(new GridLayout(2,2));

        fieldsPanel.add(new JLabel("Due Date (yyyy-MM-dd ex: 2016-05-25)"));
        this.dueDate = new JTextField();
        fieldsPanel.add(this.dueDate);

        fieldsPanel.add(new JLabel("Description"));
        this.description = new JTextField();
        fieldsPanel.add(this.description);


        JPanel panel = new JPanel(new GridLayout(5,1));
        panel.add(createAddButton());
        panel.add(this.createEditButton());
        panel.add(this.createConfirmUpdateButton());
        panel.add(this.createRemoveButton());
        panel.add(this.createCancelButton());

        JPanel buttonsPanel = new JPanel(new BorderLayout());
        buttonsPanel.add(panel,BorderLayout.SOUTH);

        //Add to root
        root.add(title,BorderLayout.NORTH);
        root.add(fieldsPanel,BorderLayout.CENTER);
        root.add(buttonsPanel,BorderLayout.SOUTH);

        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        return root;
    }

    /**
     * Create the button and listener used to add new event.
     *
     * @return JButton
     */
    private JButton createAddButton()
    {
        this.addButton = new JButton("Add");

        addButton.addActionListener(e -> {
            boolean success = AgendaPanel.this.controller.createEvent(dueDate.getText(),description.getText());
            if(success)
            {
                JOptionPane.showMessageDialog(null,"Event created!","Event",JOptionPane.INFORMATION_MESSAGE);
                AgendaPanel.this.clearForm();
                AgendaPanel.this.reloadTable();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Error creating event!","Event",JOptionPane.ERROR_MESSAGE);
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
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                IEvent event = AgendaPanel.this.controller.getSelectedEvent();
                if(event != null)
                {
                    AgendaPanel.this.dueDate.setText(event.dueDate().toString());
                    AgendaPanel.this.description.setText(event.description());

                    //Disable other buttons and enable the confirm update
                    AgendaPanel.this.removeButton.setEnabled(false);
                    AgendaPanel.this.addButton.setEnabled(false);
                    AgendaPanel.this.confirmUpdateButton.setEnabled(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Error updating contact!","Contact",JOptionPane.ERROR_MESSAGE);
                }
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
        cancelButton.addActionListener(e -> AgendaPanel.this.resetForm());

        return this.cancelButton;
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
            if(AgendaPanel.this.controller.removeEvent())
            {
                JOptionPane.showMessageDialog(null,"Event removed!","Event",JOptionPane.INFORMATION_MESSAGE);
                AgendaPanel.this.reloadTable();
                AgendaPanel.this.resetForm();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Error removing event!","Event",JOptionPane.ERROR_MESSAGE);
            }
        });
        return this.removeButton;
    }

    /**
     * Creates the combo for the contact selection.
     *
     * @return JComboBox
     */
    private JComboBox createContactsCombo()
    {

        Object[] contacts = this.controller.getAllSchedulables().toArray();
        this.contactsCombo = new JComboBox(contacts);

        contactsCombo.addActionListener(e -> {
            ISchedulable schedulable = (ISchedulable) AgendaPanel.this.contactsCombo.getSelectedItem();
            AgendaPanel.this.controller.saveSelectedSchedulable(schedulable);
            if(AgendaPanel.this.tablePanel != null)
                AgendaPanel.this.reloadTable();
        });

        return contactsCombo;
    }

    /**
     *  Create a table with all events of contact.
     *
     * @return JTable
     */
    private JPanel createEventsTablePanel()
    {
        this.agendaTable = new JTable(this.createEventsTableData());
        this.agendaTable.setPreferredScrollableViewportSize(new Dimension(400, 70));
        this.agendaTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.agendaTable.getSelectionModel().addListSelectionListener(e -> {

            int selectedRow = AgendaPanel.this.agendaTable.getSelectedRow();

            if(selectedRow != -1)
            {
                Long id = ((EventsTableModel) agendaTable.getModel()).getSelectedEventId(selectedRow);
                AgendaPanel.this.controller.saveSelectedSchedulable((ISchedulable)AgendaPanel.this.contactsCombo.getSelectedItem());
                AgendaPanel.this.controller.saveSelectedEvent(AgendaPanel.this.controller.findEventById(id));

                //We have selection so we can edit or delete a event
                AgendaPanel.this.editButton.setEnabled(true);
                AgendaPanel.this.removeButton.setEnabled(true);
                AgendaPanel.this.cancelButton.setEnabled(true);
            }
        });


        JPanel tablePanel = new JPanel(new BorderLayout());

        JLabel title = new JLabel("CURRENT EVENTS");
        title.setHorizontalAlignment(JLabel.CENTER);

        tablePanel.add(title,BorderLayout.NORTH);
        tablePanel.add(new JScrollPane(this.agendaTable),BorderLayout.CENTER);

        JPanel listPanel = new JPanel(new BorderLayout());
        listPanel.add(tablePanel,BorderLayout.CENTER);

        return listPanel;
    }

    /**
     * Create a new Table Model for events.
     *
     * @return EventsTableModel
     */
    private EventsTableModel createEventsTableData()
    {
        ISchedulable schedulable = (ISchedulable) this.contactsCombo.getSelectedItem();

        List<IEvent> list = new ArrayList<>();

        if(schedulable != null)
            list.addAll(this.controller.eventsOfSelectedSchedulable(schedulable));

        return new EventsTableModel(list);
    }

    /**
     * Reload the table of events with the modifications done in the session.
     */
    private void reloadTable()
    {
        this.remove(this.tablePanel);
        this.tablePanel = this.createEventsTablePanel();
        this.add(this.tablePanel, BorderLayout.CENTER);
        this.tablePanel.updateUI();
    }

    /**
     * Reset the panel to the born state.
     */
    private void resetForm()
    {
        this.clearForm();
        this.controller.saveSelectedSchedulable(null);
        this.addButton.setEnabled(true);
        this.removeButton.setEnabled(false);
        this.editButton.setEnabled(false);
        this.cancelButton.setEnabled(false);
        this.confirmUpdateButton.setEnabled(false);
        this.agendaTable.clearSelection();
    }

    /**
     * Clean the forms used in creating of a event.
     */
    private void clearForm()
    {
        this.dueDate.setText("");
        this.description.setText("");
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
        this.confirmUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(AgendaPanel.this.controller.editEvent(dueDate.getText(),description.getText()))
                {
                    JOptionPane.showMessageDialog(null,"Event updated!","Event",JOptionPane.INFORMATION_MESSAGE);
                    AgendaPanel.this.resetForm();
                    AgendaPanel.this.reloadTable();
                } else {
                    JOptionPane.showMessageDialog(null,"Error updating contact!","Event",JOptionPane.ERROR_MESSAGE);
                }


            }
        });

        return this.confirmUpdateButton;
    }

}
