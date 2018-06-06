package csheets.ext.charts.ui;

import csheets.ext.Extension;
import csheets.ext.charts.ChartsExtension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.CellDecorator;
import csheets.ui.ext.TableDecorator;
import csheets.ui.ext.UIExtension;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JToolBar;

/**
 * This class implements the UI interface extension for the charts extension. A
 * UI interface extension must extend the UIExtension abstract class.
 *
 * @see UIExtension
 * @author 1120013@isep.ipp.pt
 */
public class UIExtensionCharts extends UIExtension {

	private ChartController chartsController;

	/**
	 * A cell decorator that visualizes charts on cells
	 */
	private CellDecorator cellDecorator;

	/**
	 * The menu of the extension
	 */
	private ChartsMenu menu;

	/**
	 * The submenu of the extension
	 */
	private ChartsSubMenu submenu;

	/**
	 * The icon to display with the extension's name
	 */
	private Icon icon;

	public UIExtensionCharts(Extension extension, UIController uiController) {
		super(extension, uiController);
	}

	/**
	 * Returns an icon to display with the extension's name.
	 *
	 * @return an icon with style
	 */
	@Override
	public Icon getIcon() {
//		if (icon == null) {
//			icon = new ImageIcon(
//				ChartsExtension.class.getResource("res/img/logo.gif"));
//		}
		return null;
	}

	/**
	 * Returns a cell decorator that visualizes charts on cells.
	 *
	 * @return decorator for cells with charts
	 */
	@Override
	public CellDecorator getCellDecorator() {
		if (cellDecorator == null) {
			cellDecorator = new ChartedCellDecorator();
		}
		return cellDecorator;
	}

	/**
	 * Returns an instance of a class that implements JMenu. In this simple case
	 * this class only supplies one menu option.
	 *
	 * @return a JMenu component
	 */
	@Override
	public JMenu getMenu() {

		this.submenu = new ChartsSubMenu(this.uiController, this.chartsController);

		if (menu == null) {
			menu = new ChartsMenu(this.uiController);
			menu.add(submenu);
		}

		return menu;
	}

	/**
	 * Returns a table decorator that visualizes the data added by the
	 * extension.
	 *
	 * @return a table decorator, or null if the extension does not provide one
	 */
	@Override
	public TableDecorator getTableDecorator() {
		return null;
	}

	/**
	 * Returns a toolbar that gives access to extension-specific functionality.
	 *
	 * @return a JToolBar component, or null if the extension does not provide
	 * one
	 */
	@Override
	public JToolBar getToolBar() {
		return null;
	}

	/**
	 * Returns a side bar that provides editing of comments.
	 *
	 * @return a side bar
	 */
	@Override
	public JComponent getSideBar() {
		return null;
	}

}
