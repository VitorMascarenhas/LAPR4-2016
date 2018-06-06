package csheets.ext.charts;

import csheets.core.Cell;
import csheets.ext.CellExtension;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * An extension of a cell in a spreadsheet, with support for charts.
 *
 * @author 1120013@isep.ipp.pt
 */
public class ChartableCell extends CellExtension {

	/**
	 * The unique version identifier used for serialization.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The cell's user-specified chart.
	 */
	private Chart userChart;

	/**
	 * The listeners registered to receive events from the comentable cell
	 */
	private transient List<ChartableCellListener> listeners = new ArrayList<ChartableCellListener>();

	/**
	 * Creates a chartable cell extension for the given cell.
	 *
	 * @param cell the cell to extend
	 */
	ChartableCell(Cell cell) {
		super(cell, ChartsExtension.NAME);
	}

	/**
	 * Get the cell's chart.
	 *
	 * @return the user supplied chart for the cell or <code>null</code> if no
	 * user supplied chart exists.
	 */
	public Chart getCellChart() {
		return this.userChart;
	}

	/**
	 * Returns whether the cell has a chart.
	 *
	 * @return true if the cell has a chart
	 */
	public boolean hasChart() {
		return this.userChart != null;
	}

	/**
	 * Sets the user-specified chart for the cell.
	 *
	 * @param chart the user-specified chart
	 */
	public void setChart(Chart chart) {
		this.userChart = chart;
		this.fireChartAdded();
	}

	/**
	 * Registers the given listener on the cell.
	 *
	 * @param listener the listener to be added
	 */
	public void addChartableCellListener(ChartableCellListener listener) {
		listeners.add(listener);
	}

	/**
	 * Removes the given listener from the cell.
	 *
	 * @param listener the listener to be removed
	 */
	public void removeChartableCellListener(ChartableCellListener listener) {
		listeners.remove(listener);
	}

	/**
	 * Notifies all registered listeners that a chart was added to the cell.
	 */
	protected void fireChartAdded() {
		for (ChartableCellListener listener : listeners) {
			listener.chartAdded(this);
		}
	}

	/**
	 * Customizes serialization, by recreating the listener list.
	 *
	 * @param stream the object input stream from which the object is to be read
	 * @throws IOException If any of the usual Input/Output related exceptions
	 * occur
	 * @throws ClassNotFoundException If the class of a serialized object cannot
	 * be found.
	 */
	private void readObject(java.io.ObjectInputStream stream) throws java.io.IOException, ClassNotFoundException {
		stream.defaultReadObject();
		listeners = new ArrayList<ChartableCellListener>();
	}

    @Override
    public void styleChanged(Cell cell) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
