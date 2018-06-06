/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.lang.export;

import csheets.lang.files.ToXML;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import csheets.CleanSheets;
import csheets.core.Address;
import csheets.core.CellImpl;
import csheets.core.CellListener;
import csheets.core.Spreadsheet;
import csheets.core.SpreadsheetImpl;
import csheets.core.Workbook;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.lang.files.ui.ExportFilePanel;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import org.eclipse.persistence.expressions.ExpressionOperator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vitoralexandremascarenhasmascarenhas
 */
public class ToXMLTest {
    
    public ToXMLTest() {
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
     * Test of exportWorkbook method, of class ToXML.
     */
    @Test
    public void testExportWorkbook() throws FormulaCompilationException {
        System.out.println("exportWorkbook");
        Workbook workbook = new Workbook(1);
        
        Spreadsheet s1 = workbook.getSpreadsheet(0);
        s1.getCell(new Address(1, 1));
        s1.getCell(new Address(1, 2));
        s1.getCell(new Address(1, 3));
        s1.getCell(new Address(2, 1));
        s1.getCell(new Address(2, 2));
        s1.getCell(new Address(2, 3));
        s1.setTitle("Titulo da spreadsheet");
       
        s1.getCell(0, 0).setContent("Lapr4");
        s1.getCell(0, 1).setContent("Eapli");
        s1.getCell(0, 2).setContent("Scomp");
        s1.getCell(1, 0).setContent("Rcomp");
        s1.getCell(1, 1).setContent("Lprog");
        s1.getCell(1, 2).setContent("Esinf");
        
        ToXML instance = new ToXML();
        List<String> result = instance.exportWorkbook(workbook, "workbook", "spreadsheet", "cell");
        
        List<String> expect = new ArrayList<>();
        expect.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        expect.add("<workbook>\n");
        expect.add("\t<spreadsheet id=\"0\" title=\"Titulo da spreadsheet\">\n");
        expect.add("\t\t<cell column=\"0\" row=\"0\">Lapr4</cell>\n");
        expect.add("\t\t<cell column=\"0\" row=\"1\">Eapli</cell>\n");
        expect.add("\t\t<cell column=\"0\" row=\"2\">Scomp</cell>\n");
        expect.add("\t\t<cell column=\"1\" row=\"0\">Rcomp</cell>\n");
        expect.add("\t\t<cell column=\"1\" row=\"1\">Lprog</cell>\n");
        expect.add("\t\t<cell column=\"1\" row=\"2\">Esinf</cell>\n");
        expect.add("\t</spreadsheet>\n");
        expect.add("</workbook>\n");
        
        assertEquals(expect.get(0), result.get(0));
        assertEquals(expect.get(1), result.get(1));
        assertEquals(expect.get(2), result.get(2));
        assertEquals(expect.get(3), result.get(3));
        assertEquals(expect.get(4), result.get(4));
        assertEquals(expect.get(5), result.get(5));
        assertEquals(expect.get(6), result.get(6));
        assertEquals(expect.get(7), result.get(7));
        assertEquals(expect.get(8), result.get(8));
        assertEquals(expect.get(9), result.get(9));
        assertEquals(expect.get(10), result.get(10));
                
        //fail("The test case is a prototype.");
    }

    /**
     * Test of exportSpreadSheets method, of class ToXML.
     */
    @Test
    public void testExportSpreadSheets() throws FormulaCompilationException {
        System.out.println("exportSpreadSheets");
        /*UIController uic = new UIController(new CleanSheets());
        
        Workbook workbook = new Workbook(1);
        uic.setWorkbookModified(workbook);
        Spreadsheet s1 = workbook.getSpreadsheet(0);
        s1.getCell(new Address(1, 1));
        s1.getCell(new Address(1, 2));
        s1.getCell(new Address(1, 3));
        s1.getCell(new Address(2, 1));
        s1.getCell(new Address(2, 2));
        s1.getCell(new Address(2, 3));
        s1.setTitle("Titulo da spreadsheet");
       
        s1.getCell(0, 0).setContent("Lapr4");
        s1.getCell(0, 1).setContent("Eapli");
        s1.getCell(0, 2).setContent("Scomp");
        s1.getCell(1, 0).setContent("Rcomp");
        s1.getCell(1, 1).setContent("Lprog");
        s1.getCell(1, 2).setContent("Esinf");
        
        ExportFileController fc = new ExportFileController(uic, new ExportFilePanel(uic, new JFrame()));
        
        String w = "workbook";
        String s = "spreadsheet";
        String c = "cell";
        
        List<String> result = fc.createXmlWithSpreadsheet((SpreadsheetImpl)s1, w, s, c);
        
        List<String> expect = new ArrayList<>();
        expect.add("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        expect.add("<workbook>\n");
        expect.add("\t<spreadsheet id=\"0\" title=\"Titulo da spreadsheet\">\n");
        expect.add("\t\t<cell column=\"0\" row=\"0\">Lapr4</cell>\n");
        expect.add("\t\t<cell column=\"0\" row=\"1\">Eapli</cell>\n");
        expect.add("\t\t<cell column=\"0\" row=\"2\">Scomp</cell>\n");
        expect.add("\t\t<cell column=\"1\" row=\"0\">Rcomp</cell>\n");
        expect.add("\t\t<cell column=\"1\" row=\"1\">Lprog</cell>\n");
        expect.add("\t\t<cell column=\"1\" row=\"2\">Esinf</cell>\n");
        expect.add("\t</spreadsheet>\n");
        expect.add("</workbook>\n");
        System.out.println("-------||||||||||||---------");
        */
        //assertEquals(expect.get(0), result.get(0));
        //assertEquals(expect.get(1), result.get(1));
        //assertEquals(expect.get(2), result.get(2));
        //assertEquals(expect.get(3), result.get(3));
        //assertEquals(expect.get(4), result.get(4));
        //assertEquals(expect.get(5), result.get(5));
        //assertEquals(expect.get(6), result.get(6));
        //assertEquals(expect.get(7), result.get(7));
        //assertEquals(expect.get(8), result.get(8));
        //assertEquals(expect.get(9), result.get(9));
        //assertEquals(expect.get(10), result.get(10));
        
    }

    /**
     * Test of exportCells method, of class ToXML.
     */
    @Test
    public void testExportCells() {
        /*System.out.println("exportCells");
        List<CellImpl> cells = null;
        ToXML instance = new ToXML();
        List<String> expResult = null;
        List<String> result = instance.exportCells(cells);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }
    
}
