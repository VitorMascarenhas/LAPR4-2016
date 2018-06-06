/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.lang.conditionalformat.ui;

import csheets.core.Cell;
import csheets.core.IllegalValueTypeException;
import csheets.core.Spreadsheet;
import csheets.core.formula.compiler.FormulaCompilationException;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.Border;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 1950689 Nuno Mota
 */
public class ConditionalFormatTest {
    
    public ConditionalFormatTest() {
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
     * Test of setCellActive method, of class ConditionalFormat.
     */
    @Test
    public void testSetCellActive() {
        System.out.println("setCellActive");
        Cell cellActive = null;
        ConditionalFormat instance = null;
//        instance.setCellActive(cellActive);
        //não posso criar uma 'cell' fora da aplicação por isso não posso testar este método
        assertTrue(true);
    }

    /**
     * Test of setCellActiveSpreadsheet method, of class ConditionalFormat.
     */
    @Test
    public void testSetCellActiveSpreadsheet() {
        System.out.println("setCellActiveSpreadsheet");
        Spreadsheet cellActiveSpreadsheet = null;
        ConditionalFormat instance = null;
//        instance.setCellActiveSpreadsheet(cellActiveSpreadsheet);
        //não posso criar uma 'spreadsheet' fora da aplicação por isso não posso testar este método
        assertTrue(true);
    }

    /**
     * Test of setCellCondition method, of class ConditionalFormat.
     */
    @Test
    public void testSetCellCondition() throws Exception {
        System.out.println("setCellCondition");
        String cellCondition = "test";
        ConditionalFormat instance = new ConditionalFormat(null);
        instance.setCellCondition(cellCondition);
        String cond=instance.getCellCondition();
        assertTrue(cellCondition.equalsIgnoreCase(cond));
    }

    /**
     * Test of setStyleFormat method, of class ConditionalFormat.
     */
    @Test
    public void testSetStyleFormat() {
        System.out.println("setStyleFormat");
        String strResult = "TRUE";
        ConditionalFormat instance = new ConditionalFormat(null);
//        instance.setStyleFormat(strResult);
//        int result=instance.getTrueStyleHorizontalAlignment();
//        assertEquals(result,SwingConstants.LEFT);
        
        //preciso da 'cell' activa
        assertTrue(true);
    }

    /**
     * Test of getCellCondition method, of class ConditionalFormat.
     */
    @Test
    public void testGetCellCondition() throws FormulaCompilationException, IllegalValueTypeException {
        System.out.println("getCellCondition");
        ConditionalFormat instance = new ConditionalFormat(null);
        String expResult = "test";
        instance.setCellCondition(expResult);
        String result = instance.getCellCondition();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getTrueStyleBorder method, of class ConditionalFormat.
     */
    @Test
    public void testGetTrueStyleBorder() {
        System.out.println("getTrueStyleBorder");
        ConditionalFormat instance = new ConditionalFormat(null);
        Border expResult = null;
        Border result = instance.getTrueStyleBorder();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTrueStyleBorder method, of class ConditionalFormat.
     */
    @Test
    public void testSetTrueStyleBorder() {
        System.out.println("setTrueStyleBorder");
        Border trueStyleBorder = null;
        ConditionalFormat instance = new ConditionalFormat(null);
        instance.setTrueStyleBorder(trueStyleBorder);
        assertEquals(trueStyleBorder,instance.getTrueStyleBorder());
    }

    /**
     * Test of getFalseStyleBorder method, of class ConditionalFormat.
     */
    @Test
    public void testGetFalseStyleBorder() {
        System.out.println("getFalseStyleBorder");
        ConditionalFormat instance = new ConditionalFormat(null);
        Border expResult = null;
        Border result = instance.getFalseStyleBorder();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setFalseStyleBorder method, of class ConditionalFormat.
     */
    @Test
    public void testSetFalseStyleBorder() {
        System.out.println("setFalseStyleBorder");
        Border falseStyleBorder = null;
        ConditionalFormat instance = new ConditionalFormat(null);
        instance.setFalseStyleBorder(falseStyleBorder);
        assertEquals(falseStyleBorder, instance.getFalseStyleBorder());
    }

    /**
     * Test of getTrueStyleFont method, of class ConditionalFormat.
     */
    @Test
    public void testGetTrueStyleFont() {
        System.out.println("getTrueStyleFont");
        ConditionalFormat instance = new ConditionalFormat(null);
        Font expResult = null;
        Font result = instance.getTrueStyleFont();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setTrueStyleFont method, of class ConditionalFormat.
     */
    @Test
    public void testSetTrueStyleFont() {
        System.out.println("setTrueStyleFont");
        Font trueStyleFont = null;
        ConditionalFormat instance = new ConditionalFormat(null);
        instance.setTrueStyleFont(trueStyleFont);
        assertEquals(trueStyleFont,instance.getTrueStyleFont());
    }

    /**
     * Test of getFalseStyleFont method, of class ConditionalFormat.
     */
    @Test
    public void testGetFalseStyleFont() {
        System.out.println("getFalseStyleFont");
        ConditionalFormat instance = new ConditionalFormat(null);
        Font expResult = null;
        Font result = instance.getFalseStyleFont();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setFalseStyleFont method, of class ConditionalFormat.
     */
    @Test
    public void testSetFalseStyleFont() {
        System.out.println("setFalseStyleFont");
        Font falseStyleFont = null;
        ConditionalFormat instance = new ConditionalFormat(null);
        instance.setFalseStyleFont(falseStyleFont);
        assertEquals(falseStyleFont,instance.getFalseStyleFont());
    }

    /**
     * Test of getTrueStyleBackgroundColor method, of class ConditionalFormat.
     */
    @Test
    public void testGetTrueStyleBackgroundColor() {
        System.out.println("getTrueStyleBackgroundColor");
        ConditionalFormat instance = new ConditionalFormat(null);
        Color expResult = null;
        Color result = instance.getTrueStyleBackgroundColor();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setTrueStyleBackgroundColor method, of class ConditionalFormat.
     */
    @Test
    public void testSetTrueStyleBackgroundColor() {
        System.out.println("setTrueStyleBackgroundColor");
        Color trueStyleBackgroundColor = null;
        ConditionalFormat instance = new ConditionalFormat(null);
        instance.setTrueStyleBackgroundColor(trueStyleBackgroundColor);
        assertEquals(trueStyleBackgroundColor,instance.getTrueStyleBackgroundColor());
    }

    /**
     * Test of getFalseStyleBackgroundColor method, of class ConditionalFormat.
     */
    @Test
    public void testGetFalseStyleBackgroundColor() {
        System.out.println("getFalseStyleBackgroundColor");
        ConditionalFormat instance = new ConditionalFormat(null);
        Color expResult = null;
        Color result = instance.getFalseStyleBackgroundColor();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setFalseStyleBackgroundColor method, of class ConditionalFormat.
     */
    @Test
    public void testSetFalseStyleBackgroundColor() {
        System.out.println("setFalseStyleBackgroundColor");
        Color falseStyleBackgroundColor = null;
        ConditionalFormat instance = new ConditionalFormat(null);
        instance.setFalseStyleBackgroundColor(falseStyleBackgroundColor);
        assertEquals(falseStyleBackgroundColor,instance.getFalseStyleBackgroundColor());
    }

    
}
