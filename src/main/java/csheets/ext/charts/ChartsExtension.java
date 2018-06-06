package csheets.ext.charts;

import csheets.core.Cell;
import csheets.ext.Extension;
import csheets.ext.charts.ui.UIExtensionCharts;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 * An extension to support the creation of charts. An extension must extend the
 * Extension abstract class. The class that implements the Extension is the
 * "bootstrap" of the extension.
 *
 * @see Extension
 * @author 1120013@isep.ipp.pt
 */
public class ChartsExtension extends Extension {
    
        private UIExtensionCharts uiExtension = null;

	/**
	 * The name of the extension.
	 */
	public static final String NAME = "Charts";

	/**
	 * Creates a new extension.
	 */
	public ChartsExtension() {
		super(NAME);
	}

	/**
	 * Makes the given cell Chartable.
	 *
	 * @param cell the cell to add a chart
	 * @return a chartable cell
	 */
	public ChartableCell extend(Cell cell) {
		return new ChartableCell(cell);
	}

	/**
	 * Returns the user interface extension of this extension.
	 *
	 * @param uiController the user interface controller
	 * @return a user interface extension, or null if none is provided
	 */
	@Override
	public UIExtension getUIExtension(UIController uiController) {
		if (this.uiExtension == null) {
			this.uiExtension = new UIExtensionCharts(this, uiController);
		}
		return this.uiExtension;
	}

}
