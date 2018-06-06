package csheets.ext.charts.ui;

import csheets.ui.ctrl.UIController;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;

/**
 * Charts extension menu.
 *
 * @author 1120013@isep.ipp.pt
 */
class ChartsMenu extends JMenu {

	/**
	 * Creates a new menu. This constructor creates and adds the menu options.
	 * In this example only one menu option is created. A menu option is an
	 * action
	 *
	 * @param uiController the user interface controller
	 */
	public ChartsMenu(UIController uiController) {
		super("Charts");
		setMnemonic(KeyEvent.VK_C);
	}

}
