/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ipc.findworkbooks.ui;

import csheets.ui.ctrl.UIController;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Observer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author 1950689 Nuno Mota
 */
public class FindWorkbooksTest {

    private final String allPattern = ".*";
    private final Path testPath = Paths.get("c:");

    public FindWorkbooksTest() {
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
     * Test of countObservers method, of class FindWorkbooks.
     */
    @Test
    public void testCountObservers() {
        System.out.println("countObservers");
        FindWorkbooks instance = new FindWorkbooks(this.testPath, this.allPattern);
        FindWorkbooksController o = new FindWorkbooksController(null);
        instance.addObserver(o);
        int expResult = 1;
        int result = instance.countObservers();
        assertEquals(expResult, result);

    }

    /**
     * Test of hasChanged method, of class FindWorkbooks.
     */
    @Test
    public void testHasChanged() {
        System.out.println("hasChanged");
        FindWorkbooks instance = new FindWorkbooks(this.testPath, this.allPattern);
        instance.setChanged();
        assertTrue(instance.hasChanged());
    }

    /**
     * Test of clearChanged method, of class FindWorkbooks.
     */
    @Test
    public void testClearChanged() {
        System.out.println("clearChanged");
        FindWorkbooks instance = new FindWorkbooks(this.testPath, this.allPattern);
        instance.clearChanged();
        assertFalse(instance.hasChanged());
    }

    /**
     * Test of setChanged method, of class FindWorkbooks.
     */
    @Test
    public void testSetChanged() {
        System.out.println("setChanged");
        FindWorkbooks instance = new FindWorkbooks(this.testPath, this.allPattern);
        instance.setChanged();
        assertTrue(instance.hasChanged());
    }

    /**
     * Test of deleteObservers method, of class FindWorkbooks.
     */
    @Test
    public void testDeleteObservers() {
        System.out.println("deleteObservers");
        FindWorkbooks instance = new FindWorkbooks(this.testPath, this.allPattern);
        FindWorkbooksController o = new FindWorkbooksController(null);
        instance.addObserver(o);
        int expResult = instance.countObservers();
        instance.deleteObservers();
        int result = instance.countObservers();
        assertEquals(expResult, result + 1);

    }

    /**
     * Test of notifyObservers method, of class FindWorkbooks.
     */
    @Test
    public void testNotifyObservers_Object() throws InterruptedException {
        System.out.println("notifyObservers");
        FindWorkbooks instance = new FindWorkbooks(this.testPath, this.allPattern);
        FindWorkbooksController o = new FindWorkbooksController(null);
        instance.addObserver(o);
        instance.notifyObservers(o);
        assertTrue(true);
    }

    /**
     * Test of notifyObservers method, of class FindWorkbooks.
     */
    @Test
    public void testNotifyObservers_0args() {
        System.out.println("notifyObservers");
        FindWorkbooks instance = new FindWorkbooks(this.testPath, this.allPattern);
        FindWorkbooksController o = new FindWorkbooksController(null);
        instance.addObserver(o);
        instance.notifyObservers();
        assertTrue(true);
    }

    /**
     * Test of deleteObserver method, of class FindWorkbooks.
     */
    @Test
    public void testDeleteObserver() {
        System.out.println("deleteObserver");
        FindWorkbooks instance = new FindWorkbooks(this.testPath, this.allPattern);
        FindWorkbooksController o = new FindWorkbooksController(null);
        instance.addObserver(o);
        int expResult = 1;
        instance.deleteObserver(o);
        int result = instance.countObservers();
        assertEquals(expResult, result + 1);

    }

    /**
     * Test of addObserver method, of class FindWorkbooks.
     */
    @Test
    public void testAddObserver() {
        System.out.println("addObserver");
        FindWorkbooks instance = new FindWorkbooks(this.testPath, this.allPattern);
        FindWorkbooksController o = new FindWorkbooksController(null);
        instance.addObserver(o);
        int expResult = 1;
        int result = instance.countObservers();
        assertEquals(expResult, result);

    }

    /**
     * Test of run method, of class FindWorkbooks.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        FindWorkbooks instance = new FindWorkbooks(Paths.get(""), this.allPattern);
        instance.run();
        assertTrue(true);
    }

    /**
     * Test of getWorkbookFiles method, of class FindWorkbooks.
     */
    @Test
    public void testGetWorkbookFiles() {
        System.out.println("getWorkbookFiles");
        FindWorkbooks instance = new FindWorkbooks(Paths.get(""), this.allPattern);
        List<File> expResult = null;
        List<File> result = instance.getWorkbookFiles();
        assertEquals(expResult, result);
    }
}