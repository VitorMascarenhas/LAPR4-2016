package csheets.ext.charts.ui;

import csheets.ui.ctrl.UIController;
import java.awt.event.KeyEvent;
import javax.swing.JMenuItem;

/**
 * Charts extension sub-menu.
 *
 * @author 1120013@isep.ipp.pt
 */
class ChartsSubMenu extends JMenuItem {

	private final ChartSubMenuAction chartSubMenuAction;

	/**
	 * Creates a menu item under extensions.
	 *
	 * @param uiController ui controller
	 * @param chartsController charts controller
	 */
	public ChartsSubMenu(UIController uiController,
						 ChartController chartsController) {
		super("Chart Wizard");
		setMnemonic(KeyEvent.VK_C);
		chartSubMenuAction = new ChartSubMenuAction(uiController);
		addActionListener(chartSubMenuAction);
	}

}
