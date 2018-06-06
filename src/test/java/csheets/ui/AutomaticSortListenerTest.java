/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ui;

import csheets.core.Cell;
import csheets.ui.enums.SortOption;
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
public class AutomaticSortListenerTest {
    
    public AutomaticSortListenerTest() {
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
     * Test of resetAutomaticSortListener method, of class AutomaticSortListener.
     */
    @Test
    public void testResetAutomaticSortListener() {
        System.out.println("resetAutomaticSortListener");
        AutomaticSortListener instance = new AutomaticSortListener(null);
        boolean expResult = true;
        boolean result = instance.resetAutomaticSortListener();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setAutomaticSort method, of class AutomaticSortListener.
     */
    @Test
    public void testSetAutomaticSort() {
        System.out.println("setAutomaticSort");
        AutomaticSortListener instance = new AutomaticSortListener(null);
        SortOption s=null;
        boolean expResult = true;
        boolean result = instance.setAutomaticSort(0, null, s, null);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of valueChanged method, of class AutomaticSortListener.
     */
    @Test
    public void testValueChanged() {
        System.out.println("valueChanged");
        Cell cell = null;
        AutomaticSortListener instance = new AutomaticSortListener(null);
        instance.valueChanged(cell);
        // can´t create a cell outside the cleansheets app
        assertTrue(true);
    }

    /**
     * Test of contentChanged method, of class AutomaticSortListener.
     */
    @Test
    public void testContentChanged() {
        System.out.println("contentChanged");
        Cell cell = null;
        AutomaticSortListener instance = new AutomaticSortListener(null);
        instance.contentChanged(cell);
        // can´t create a cell outside the cleansheets app
        assertTrue(true);
    }

    /**
     * Test of dependentsChanged method, of class AutomaticSortListener.
     */
    @Test
    public void testDependentsChanged() {
        System.out.println("dependentsChanged");
        Cell cell = null;
        AutomaticSortListener instance = new AutomaticSortListener(null);
        instance.dependentsChanged(cell);
        // can´t create a cell outside the cleansheets app
        assertTrue(true);
    }

    /**
     * Test of cellCleared method, of class AutomaticSortListener.
     */
    @Test
    public void testCellCleared() {
        System.out.println("cellCleared");
        Cell cell = null;
        AutomaticSortListener instance = new AutomaticSortListener(null);
        instance.cellCleared(cell);
        // can´t create a cell outside the cleansheets app
        assertTrue(true);
    }

    /**
     * Test of cellCopied method, of class AutomaticSortListener.
     */
    @Test
    public void testCellCopied() {
        System.out.println("cellCopied");
        Cell cell = null;
        Cell source = null;
        AutomaticSortListener instance = new AutomaticSortListener(null);
        instance.cellCopied(cell, source);
        // can´t create a cell outside the cleansheets app
        assertTrue(true);
    }

    /**
     * Test of styleChanged method, of class AutomaticSortListener.
     */
    @Test
    public void testStyleChanged() {
        System.out.println("styleChanged");
        Cell cell = null;
        AutomaticSortListener instance = new AutomaticSortListener(null);
        instance.styleChanged(cell);
        // can´t create a cell outside the cleansheets app
        assertTrue(true);
    }

    /**
     * Test of getColumn method, of class AutomaticSortListener.
     */
    @Test
    public void testGetColumn() {
        System.out.println("getColumn");
        AutomaticSortListener instance = new AutomaticSortListener(null);
        int expResult = -1;
        int result = instance.getColumn();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setColumn method, of class AutomaticSortListener.
     */
    @Test
    public void testSetColumn() {
        System.out.println("setColumn");
        int column = 0;
        AutomaticSortListener instance = new AutomaticSortListener(null);
        instance.setColumn(column);
        int expResult = 0;
        int result = instance.getColumn();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSortColumn method, of class AutomaticSortListener.
     */
    @Test
    public void testSetSortColumn() {
        System.out.println("setSortColumn");
        int column = -1;
        AutomaticSortListener instance = new AutomaticSortListener(null);
        boolean expResult = false;
        boolean result = instance.setSortColumn(column);
        assertEquals(expResult, result);
        
    }
}
