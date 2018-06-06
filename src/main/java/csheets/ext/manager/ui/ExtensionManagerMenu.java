package csheets.ext.manager.ui;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;

import csheets.ui.ctrl.UIController;

/**
 * Representes the UI extension menu of the Extension Manager
 * @author 1950689 Nuno Mota
 */
public class ExtensionManagerMenu extends JMenu {

	/**
	 * Creates a new simple menu.
	 * This constructor creates and adds the menu options. 
	 * In this simple example only one menu option is created.
	 * A menu option is an action (in this case {@link csheets.ext.manager.ui.ExtensionManagerAction})
	 * @param uiController the user interface controller
	 */
	public ExtensionManagerMenu(UIController uiController) {
		super("Extension Manager");
		setMnemonic(KeyEvent.VK_E);

		// Adds font actions
		add(new ExtensionManagerAction(uiController));
	}	
}
