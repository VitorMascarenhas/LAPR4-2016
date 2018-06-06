/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.lang.files;

import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author smoli
 */
public class ExportFactoryTest {
    
    public ExportFactoryTest() {
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
     * Test of getStategy method, of class ExportFactory.
     */
    @Test
    public void testGetStategy() {
        System.out.println("Export factory getStrategy");
        FileType fileType = FileType.XML;
        File exportFile = new File("c:\\file.xml");
        String workbookTagName = "workbook";
        String spreadsheetTagName = "spreadsheet";
        String cellTagName = "cell";
        
        ExportFactory instance = ExportFactory.getInstance();
        ExportStrategy expResult = new ExportXmlStrategy(exportFile, workbookTagName, spreadsheetTagName, cellTagName);
        ExportStrategy result = instance.getStategy(fileType, exportFile, workbookTagName, spreadsheetTagName, cellTagName);
       
        assertEquals(expResult, result);
        
    }
    
}
