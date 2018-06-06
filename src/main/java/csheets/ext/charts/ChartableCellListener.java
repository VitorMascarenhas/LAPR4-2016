package csheets.ext.charts;

import java.util.EventListener;

/**
 * A listener interface for receiving notification on events occurring in an
 * chartable cell.
 *
 * @author @author 1120013@isep.ipp.pt
 */
interface ChartableCellListener extends EventListener {

	/**
	 * Invoked when a chart is added to a cell.
	 *
	 * @param cell the cell that was modified.
	 */
	public void chartAdded(ChartableCell cell);

}
