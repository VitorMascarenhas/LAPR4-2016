package csheets.ext.importExport;

import csheets.ui.sheet.SpreadsheetTable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author José Vilela
 */
public class ImportExportTextStrategyTest {
    
    private final ImportExportTextStrategy instance;
    
    public ImportExportTextStrategyTest() {
        instance = new ImportExportTextStrategy();
    }


    /**
     * Test of setDelimiter method, of class ImportExportTextStrategy.
     */
    @Test
    public void testSetDelimiter() {
        System.out.println("setDelimiter");
        String delimiter = "";
        instance.setDelimiter(delimiter);
    }

    /**
     * Test of setDir method, of class ImportExportTextStrategy.
     */
    @Test
    public void testSetDir() {
        System.out.println("setDir");
        String dir = "";
        instance.setDir(dir);
    }

    /**
     * Test of setFileName method, of class ImportExportTextStrategy.
     */
    @Test
    public void testSetFileName() {
        System.out.println("setFileName");
        String fileName = "";
        instance.setFileName(fileName);
    }

    /**
     * Test of setHeader method, of class ImportExportTextStrategy.
     */
    @Test
    public void testSetHeader() {
        System.out.println("setHeader");
        boolean header = false;
        instance.setHeader(header);
    }

    /**
     * Test of getDelimiter method, of class ImportExportTextStrategy.
     */
    @Test
    public void testGetDelimiter() {
        System.out.println("getDelimiter");
        String expResult = "";
        String result = instance.getDelimiter();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDir method, of class ImportExportTextStrategy.
     */
    @Test
    public void testGetDir() {
        System.out.println("getDir");
        String expResult = "";
        String result = instance.getDir();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFileName method, of class ImportExportTextStrategy.
     */
    @Test
    public void testGetFileName() {
        System.out.println("getFileName");
        String expResult = "";
        String result = instance.getFileName();
        assertEquals(expResult, result);
    }

    /**
     * Test of exportToFile method, of class ImportExportTextStrategy
     * not implemented because we need controller in runtime.
     */
    @Test
    public void testExportToFile() {
    }

    /**
     * Test of importFromFile method, of class ImportExportTextStrategy
     * not implemented because we need controller in runtime.
     */
    @Test
    public void testImportFromFile() {
        
    }
    
}
