/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.formula;

import csheets.core.CellImpl;
import csheets.core.Spreadsheet;
import csheets.core.Value;
import csheets.core.Workbook;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.core.formula.variables.TempVariable;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test Class of TempVariable
 * @author José Vilela 1010500
 */
public class TempVariableTest {

    /**
     * Test of evaluate method, of class TempVariable.
     */
    @Test
    public void testEvaluate() throws Exception {
        // create a workbook with 2 sheets
        Workbook wb=new Workbook(2);
        Spreadsheet s=wb.getSpreadsheet(0);
        // get the first cell
        CellImpl cellTest=(CellImpl)s.getCell(0,0);
        cellTest.setContent("={_temp:=10;10;10}");
     
        TempVariable instance = new TempVariable("_temp",cellTest);
        Value expResult = new Value("10");
        Value result = instance.evaluate();
        assertEquals(expResult.toString(), result.toString());
    }

    /**
     * Test of setValue method, of class TempVariable.
     */
    @Test
    public void testSetValue() throws FormulaCompilationException {
        System.out.println("setValue");
        // create a workbook with 2 sheets
        Workbook wb=new Workbook(2);
        Spreadsheet s=wb.getSpreadsheet(0);
        // get the first cell
        CellImpl c=(CellImpl)s.getCell(0,0);
        c.setContent("={_test:=4;1+2;3}");
        
        TempVariable instance = new TempVariable("_test",c);
        instance.setValue(c.getValue());
        assertEquals(c.getTempVariablesList().get("_test").toString(), "3");
    }

    /**
     * tests if the second assignment to a temporary 
     * variable replace the first assignment
     * @throws Exception 
     */
    @Test
    public void ensureSecondAssignReplaceFirstAssign() throws Exception {
        // create a workbook with 2 sheets
        Workbook wb=new Workbook(2);
        Spreadsheet s=wb.getSpreadsheet(0);
        // get the first cell
        CellImpl cellTest=(CellImpl)s.getCell(0,0);
        cellTest.setContent("={_temp:=10;_temp:=50;10}");
     
        TempVariable instance = new TempVariable("_temp",cellTest);
        Value expResult = new Value("50");
        Value result = instance.evaluate();
        assertEquals(expResult.toString(), result.toString());
    }
    
}
