package csheets.ext.agenda.ui;

import csheets.ui.ctrl.UIController;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * Represents the UI extension menu of the agenda edition extension.
 * @author Pedro Costa
 */
public class AgendaMenu extends JMenu {

    public final static String MENU_NAME = "Agenda";

    public AgendaMenu(UIController uiController)
    {
        super(MENU_NAME);
        setMnemonic(KeyEvent.VK_S);
    }
}
