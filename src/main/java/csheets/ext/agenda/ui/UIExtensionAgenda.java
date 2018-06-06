package csheets.ext.agenda.ui;

import csheets.ext.Extension;
import csheets.ext.agenda.AgendaExtension;
import csheets.ext.contacts.ContactsExtension;
import csheets.ext.contacts.ui.ContactMenu;
import csheets.ext.contacts.ui.ContactPanel;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

import javax.swing.*;

/**
 * This class implements the UI interface extension for the contacts edition extension.
 * A UI interface extension must extend the UIExtension abstract class.
 * @see UIExtension
 * @see Extension
 * @author Pedro Costa
 */
public class UIExtensionAgenda extends UIExtension {

    /** The sidebar of the extension */
    private JComponent sidebar;

    /** The menu of the extension */
    private AgendaMenu menu;

    /**
     * Creates a new user interface extension..
     *
     * @param extension    the extension for which components are provided
     * @param uiController the user interface controller
     */
    public UIExtensionAgenda(Extension extension, UIController uiController)
    {
        super(extension, uiController);
    }

    /**
     *  Creates the sidebar for agenda edition ui.
     *
     * @return a JComponent
     */
    @Override
    public JComponent getSideBar() {

        sidebar = new AgendaPanel(this.uiController);
        sidebar.setName(AgendaExtension.NAME);

        return sidebar;
    }

    /**
     * Returns an instance of a Agenda Edition Menu.
     * @return a JMenu component
     */
    @Override
    public JMenu getMenu() {
        if (menu == null)
            menu = new AgendaMenu(uiController);

        return menu;
    }
}
