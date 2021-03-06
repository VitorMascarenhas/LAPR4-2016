/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.style.ui;

import csheets.core.Address;
import csheets.core.CellImpl;
import csheets.core.IllegalValueTypeException;
import csheets.core.Spreadsheet;
import csheets.core.SpreadsheetImpl;
import csheets.core.Workbook;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ext.style.StylableCell;
import csheets.ui.ctrl.SelectionEvent;
import java.awt.event.ActionEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ASUS
 */
public class ConditionalFormatActionTest {

    public ConditionalFormatActionTest() {
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
     * Test of actionPerformed method, of class ConditionalFormatAction.
     */
    @Test
    public void testActionPerformed() throws FormulaCompilationException, IllegalValueTypeException {
        System.out.println("actionPerformed");
        Workbook workbook = new Workbook(1);

        Spreadsheet s1 = workbook.getSpreadsheet(0);
        s1.getCell(new Address(0, 0));
        s1.getCell(new Address(1, 0));
        s1.getCell(new Address(2, 0));
        s1.getCell(new Address(2, 1));
        s1.getCell(new Address(2, 2));
        s1.getCell(new Address(2, 3));
        s1.setTitle("Titulo da SpreadSheet");

        //test for true values
        s1.getCell(0, 0).setContent("2");
        s1.getCell(1, 0).setContent("2");
        s1.getCell(2, 0).setContent("=(A1=B1)");
        
        Boolean result = s1.getCell(2, 0).getFormula().evaluate().toBoolean();
        assertTrue("Result is TRUE", result == true);
    }

     @Test
    public void testActionPerformed2() throws FormulaCompilationException, IllegalValueTypeException {
        System.out.println("actionPerformed");
        Workbook workbook = new Workbook(1);

        Spreadsheet s1 = workbook.getSpreadsheet(0);
        s1.getCell(new Address(0, 0));
        s1.getCell(new Address(1, 0));
        s1.getCell(new Address(2, 0));
        s1.getCell(new Address(2, 1));
        s1.getCell(new Address(2, 2));
        s1.getCell(new Address(2, 3));
        s1.setTitle("Titulo da SpreadSheet");

        //test for false values
        s1.getCell(0, 0).setContent("2");
        s1.getCell(1, 0).setContent("1");
        s1.getCell(2, 0).setContent("=(A1=B1)");
        
        Boolean result = s1.getCell(2, 0).getFormula().evaluate().toBoolean();
        assertTrue("Result is FALSE", result == false);
    }
}
