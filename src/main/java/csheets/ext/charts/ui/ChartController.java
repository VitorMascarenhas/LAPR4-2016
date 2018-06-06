package csheets.ext.charts.ui;

import csheets.core.Cell;
import csheets.ext.charts.Chart;
import csheets.ext.charts.ChartableCell;
import csheets.ext.charts.ui.wizard.Wizard;
import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

/**
 * A controller to manage the creation of a chart, and its association to a
 * specific cell.
 *
 * @author 1120013@isep.ipp.pt
 */
public class ChartController extends FocusOwnerAction {

    private final UIController uiController;
    private Cell[][] currentCells;
    private Chart chart;
    private Wizard wizard;

    /**
     * Creates a new chart controller.
     *
     * @param uiController the user interface controller
     */
    public ChartController(UIController uiController) {
        this.uiController = uiController;
    }

    /**
     * Starts the user interface.
     *
     * @param name the wizard name
     */
    public void startWizard(String name) {
        Wizard wizard = new Wizard(name, this);
        this.initialize(wizard);
    }

    /**
     * Starts the chart wizard.
     *
     * @param wizard the chart wizard
     */
    public void initialize(Wizard wizard) {
        wizard.addWelcomePanel("Welcome ",
                "This wizard will guide you through setting up a Chart\n\nEnjoy!");
        wizard.addChartCreationPanel("Chart Data", "Data", new JPanel());
        wizard.addCustomPanel("Chart Preview", "Preview", new JPanel());
        wizard.addFinishedPanel("Thank you.");
        this.wizard = wizard;
        wizard.showWizard();
    }

    /**
     * Returns the user selected cells.
     *
     * @return the selected cells
     */
    public Cell[][] getSelectedCells() {
        this.currentCells = focusOwner.getSelectedCells();
        return focusOwner.getSelectedCells();
    }

    /**
     * Returns the selected range.
     *
     * @return the cells selected range
     */
    public String getSelectedRange() {
        Cell[][] cellsRange = new Cell[1][2];
        cellsRange[0][0] = this.currentCells[0][0];
        cellsRange[0][1] = this.currentCells[this.currentCells.length - 1][this.currentCells[0].length - 1];
        return cellsRange[0][0].getAddress() + ":" + cellsRange[0][1].
                getAddress();
    }

    /**
     * Returns the boolean value to tell if fisrt line is a label.
     *
     * @return is a label/is not a label
     */
    public boolean getlineLabel() {
        
        boolean lineLabel = wizard.getLineIsLabelCkBox();
        if (lineLabel) {
            return true;
        } else {
            return false;
        }
    }
    
     /**
     * Returns the boolean value to tell if fisrt row is a label.
     *
     * @return is a label/is not a label
     */
    public boolean getrowLabel() {
        boolean rowLabel = wizard.getrowIsLabelCkBox();
        if (rowLabel) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the cell that will have the chart associated.
     *
     * @return the cell to associate the cell
     */
    public Cell chartableCell() {
        return this.currentCells[0][0];
    }

    /**
     * Creates the chart with the given name and cells range.
     *
     * @param name the chart name
     * @param cells the cells range
     * @return the created chart
     */
    public Chart createChart(String name, Cell[][] cells, boolean lineLabel, boolean rowLabel) {
        return chart = new Chart(name, cells, lineLabel, rowLabel);
    }

    /**
     * returns the created chart.
     *
     * @return the created chart
     */
    public Chart getChart() {
        return this.chart;
    }

    /**
     * Associate given the chart to given cell.
     *
     * @param cell the cell to associate the chart
     * @param chart the chart to be associated to the cell
     * @param lineLable tells if first line is a lable
     * @param rowLabel tells if first row is a lable
     * @return true if the chart is successfully associated to the cell
     */
    public boolean setChart(ChartableCell cell, Chart chart, boolean lineLable, boolean rowLabel) {
        if (chart == null) {
            cell.setChart(null);
            return true;
        }
        cell.setChart(chart);
        uiController.setWorkbookModified(cell.getSpreadsheet().getWorkbook());
        return true;
    }

    @Override
    protected String getName() {
        return "";
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
