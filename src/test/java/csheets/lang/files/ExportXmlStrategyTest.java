/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.lang.files;

import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author smoli
 */
public class ExportXmlStrategyTest {

    private String filePath;

    public ExportXmlStrategyTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.filePath = "src/test/resources/csheets/lang/files/test.xml";
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of exportWorkbook method, of class ExportXmlStrategy.
     */
    @Test
    @Ignore
    public void testExportWorkbook() {
        System.out.println("exportWorkbook");
        Workbook workbook = null;
        ExportXmlStrategy instance = null;
        instance.exportWorkbook(workbook);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exportSpreadsheet method, of class ExportXmlStrategy.
     */
    @Test
    @Ignore
    public void testExportSpreadsheet() {
        System.out.println("exportSpreadsheet");
        Spreadsheet spreadsheet = null;
        ExportXmlStrategy instance = null;
        instance.exportSpreadsheet(spreadsheet);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exportCells method, of class ExportXmlStrategy.
     */
    @Test
    @Ignore
    public void testExportCells() {
        System.out.println("exportCells");
        Cell[][] cells = null;
        ExportXmlStrategy instance = null;
        instance.exportCells(cells);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
