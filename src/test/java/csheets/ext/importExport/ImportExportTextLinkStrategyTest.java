package csheets.ext.importExport;

import csheets.CleanSheets;
import csheets.core.Cell;
import csheets.core.Value;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ipc.MockCell;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author André Oliveira
 */
public class ImportExportTextLinkStrategyTest {

    ImportExportTextLinkStrategy importExport;
    String delimiter;
    String dir;
    String fileName;
    boolean header;
    Cell[][] cells;

    public ImportExportTextLinkStrategyTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.delimiter = "\\.";
        this.dir = "src/test/resources/csheets/ext/importExport/";
        this.fileName = "file.txt";
        this.header = false;
        this.importExport = new ImportExportTextLinkStrategy(delimiter, dir, fileName, header);
        this.cells = new Cell[2][2];

        Cell cell1 = new MockCell(new Value(1)), cell2 = new MockCell(new Value(1)), cell3 = new MockCell(new Value(1)),
                cell4 = new MockCell(new Value(1));
        try {
            cell1.setContent("1");
            cell2.setContent("2");
            cell3.setContent("3");
            cell4.setContent("4");
        } catch (FormulaCompilationException ex) {
            Logger.getLogger(ImportExportTextLinkStrategyTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.cells[0][0] = cell1;
        this.cells[0][1] = cell2;
        this.cells[1][0] = cell3;
        this.cells[1][1] = cell4;

        this.importExport.setSelectedCells(this.cells);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getDir method, of class ImportExportTextLinkStrategy.
     */
    @Test
    public void testGetDir() {
        System.out.println("getDir");

        String expResult = "src/test/resources/csheets/ext/importExport/";
        String result = this.importExport.getDir();
        assertEquals(expResult, result);

    }

    /**
     * Test of getDir method, of class ImportExportTextLinkStrategy.
     */
    @Test
    public void testGetDirNotEquals() {
        System.out.println("getDir Not Equals");

        String expResult = "C:/Teste2";
        String result = this.importExport.getDir();
        assertNotEquals(expResult, result);

    }

    /**
     * Test of getFilename method, of class ImportExportTextLinkStrategy.
     */
    @Test
    public void testGetFilename() {
        System.out.println("getFilename");

        String expResult = "file.txt";
        String result = this.importExport.getFilename();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFilename method, of class ImportExportTextLinkStrategy.
     */
    @Test
    public void testGetFilenameNotEquals() {
        System.out.println("getFilename Not Equals");

        String expResult = "file2.txt";
        String result = this.importExport.getFilename();
        assertNotEquals(expResult, result);

    }

    /**
     * Test of getSelectedCells method, of class ImportExportTextLinkStrategy.
     */
    @Test
    public void testGetSelectedCells() {
        System.out.println("getSelectedCells");
        
        Cell[][] result = this.importExport.getSelectedCells();
        assertArrayEquals(this.cells, result);

    }

    /**
     * Test of getSelectedCells method, of class ImportExportTextLinkStrategy.
     */
    @Test
    public void testGetSelectedCellsNotEquals() {
        
        System.out.println("getSelectedCells Not Equals");
        
        Cell[][] cells2 = new Cell[2][2];

        Cell cell1 = new MockCell(new Value(1)), cell2 = new MockCell(new Value(1)), cell3 = new MockCell(new Value(1)),
                cell4 = new MockCell(new Value(1));
        try {
            cell1.setContent("1");
            cell2.setContent("2");
            cell3.setContent("3");
            cell4.setContent("5");
        } catch (FormulaCompilationException ex) {
            Logger.getLogger(ImportExportTextLinkStrategyTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        cells2[0][0] = cell1;
        cells2[0][1] = cell2;
        cells2[1][0] = cell3;
        cells2[1][1] = cell4;

        this.importExport.setSelectedCells(this.cells);

        Cell[][] result = this.importExport.getSelectedCells();

        assertNotEquals(cells2, result);

    }

    /**
     * Test of setSelectedCells method, of class ImportExportTextLinkStrategy.
     */
    @Test
    public void testSetSelectedCells() {
        System.out.println("setSelectedCells");

        this.importExport.setSelectedCells(this.cells);
        
        Cell[][] otherCells = this.importExport.getSelectedCells();
        
        assertArrayEquals(this.cells, otherCells);

    }

    /**
     * Test of readFile method, of class ImportExportTextLinkStrategy.
     */
    @Test
    public void testReadFile() throws Exception {
        System.out.println("readFile");
        
        List<List<String>> expResult = new ArrayList<>();
        
        List<String> list1 = new ArrayList<>();
        
        list1.add("2");
        list1.add("s");
        
        List<String> list2 = new ArrayList<>();
        
        list2.add("1");
        list2.add("a");
        
        List<String> list3 = new ArrayList<>();
        
        list3.add("a");
        list3.add("a");
        
        expResult.add(list1);
        expResult.add(list2);
        expResult.add(list3);
        
        List<List<String>> result = this.importExport.readFile();
        assertEquals(expResult, result);

    }

}
