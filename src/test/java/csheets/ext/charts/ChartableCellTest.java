package csheets.ext.charts;

import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * A Unit Test class to test ChartableCell.

 * @author 1120013@isep.ipp.pt
 */
public class ChartableCellTest {

    public ChartableCellTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    private boolean isNotified = false;

    /**
     * A method that tests the property hasChart.
     */
    @Test
    public void testHasChart() {
        // create a workbook with 3 sheets
        Workbook wb = new Workbook(3);
        Spreadsheet s = wb.getSpreadsheet(0);

        // get the first cell
        Cell c = s.getCell(0, 0);

        // activate charts on the first cell
        ChartableCell cc = new ChartableCell(c);

        boolean hasChart = cc.hasChart();
        assertFalse(hasChart);

        Chart ch = new Chart("testChart", null, false, false);

        cc.setChart(ch);
        hasChart = cc.hasChart();

        assertTrue(hasChart);
    }

    /**
     * A method that tests the setter and getter of the user chart.
     */
    @Test
    public void testSetGetUserChart() {
        // create a workbook with 3 sheets
        Workbook wb = new Workbook(3);
        Spreadsheet s = wb.getSpreadsheet(0);
        Chart ch = new Chart("testChart", null, false, false);

        // get the first cell
        Cell c = s.getCell(0, 0);

        // activate charts on the first cell
        ChartableCell cc = new ChartableCell(c);
        cc.setChart(ch);

        Chart result = cc.getCellChart();

        assertTrue(ch == result);
    }

    /**
     * A method that tests the notifications for charted cell listeners.
     *
     */
    @Test
    public void testChartabletableCellListenner() {
        // create a workbook with 3 sheets
        Workbook wb = new Workbook(3);
        Spreadsheet s = wb.getSpreadsheet(0);
        Chart ch = new Chart("testChart", null, false, false);

        // get the first cell
        Cell c = s.getCell(0, 0);

        // activate charts on the first cell
        ChartableCell cc = new ChartableCell(c);
        ChartableCellListener listener = new ChartableCellListenerImpl();
        cc.addChartableCellListener(listener);

        // modify the cell... this should create an event
        cc.setChart(ch);
    }

    /**
     * A inner utility class used by the method testChartabletableCellListenner.
     */
    class ChartableCellListenerImpl implements ChartableCellListener {

        @Override
        public void chartAdded(ChartableCell cell) {
            isNotified = true;
        }
    }

}
