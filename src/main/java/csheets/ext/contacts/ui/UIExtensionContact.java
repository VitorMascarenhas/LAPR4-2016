package csheets.ext.contacts.ui;

import csheets.ext.Extension;
import csheets.ext.contacts.ContactsExtension;
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
public class UIExtensionContact extends UIExtension {

    /** The sidebar of the extension */
    private JComponent sidebar;

    /** The menu of the extension */
    private ContactMenu menu;

    /**
     * Creates a new user interface extension..
     *
     * @param extension    the extension for which components are provided
     * @param uiController the user interface controller
     */
    public UIExtensionContact(Extension extension, UIController uiController)
    {
        super(extension, uiController);
    }

    /**
     *  Creates the sidebar for contacts edition ui.
     *
     * @return a JComponent
     */
    @Override
    public JComponent getSideBar() {

        sidebar = new ContactPanel();
        sidebar.setName(ContactsExtension.NAME);

        return sidebar;
    }

    /**
     * Returns an instance of a Contact Edition Menu.
     * @return a JMenu component
     */
    @Override
    public JMenu getMenu() {
        if (menu == null)
            menu = new ContactMenu(uiController);

        return menu;
    }
}
