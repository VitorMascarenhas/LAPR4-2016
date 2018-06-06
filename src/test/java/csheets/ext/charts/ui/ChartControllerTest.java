package csheets.ext.charts.ui;

import csheets.core.Cell;
import csheets.ext.charts.Chart;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author 1120013@isep.ipp.pt
 */
public class ChartControllerTest {

    public ChartControllerTest() {
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

    /**
     * Test of createChart method, of class ChartController.
     */
    @Test
    public void testCreateChart() {
        System.out.println("createChart");

        String name = "Test Chart";
        Cell[][] cells = new Cell[5][5];

        ChartController instance = new ChartController(null);

        Chart expResult = new Chart(name, cells, false, false);
        Chart result = instance.createChart(name, cells, false, false);
        assertEquals(expResult, result);
    }

}
