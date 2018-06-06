package csheets.ext.contacts.ui;

import csheets.ui.ctrl.UIController;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * Represents the UI extension menu of the contacts edition extension.
 * @author Pedro Costa
 */
public class ContactMenu extends JMenu {

    public final static String MENU_NAME = "Contacts";

    public ContactMenu(UIController uiController) {
        super(MENU_NAME);
        setMnemonic(KeyEvent.VK_S);
    }
}
