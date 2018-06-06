/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.lang.files;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;

/**
 *
 * @author Sara Ramos
 */
public class ParseXMLFileTest
{
    private String filePath;
    private String filePathNullDoc;
    private Document doc;
    private String spreadsheetName;
    
    public ParseXMLFileTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp() throws ParserConfigurationException, SAXException, IOException
    {
        this.filePath = "src/test/resources/csheets/lang/files/ficheiroTeste.xml";
        this.filePathNullDoc = "src/test/resources/csheets/lang/files/fileTest_nullDoc.xml";

    }
    
    @After
    public void tearDown()
    {
    }


    /**
     * Test of parseXML method, of class ParseXMLFile.
     * @throws java.lang.Exception
     */
    @Test
    public void testParseXML() throws Exception
    {
        System.out.println("parseXML");
        ParseXMLFile instance = new ParseXMLFile(null, filePath);
        instance.parseXML();
                     
        //---- Test of extractTagNames method, of class ParseXMLFile.
        assertEquals(instance.getCellName(), "cell");
        assertEquals(instance.getSpreadsheetName(), "spreadsheet");
        //---- Test the document created with the file reading
        assertNotNull(instance.getDoc());
    }
    
    /**
     * Test of parseXML method, of class ParseXMLFile with a error in parser
     * @throws java.lang.Exception
     */
    @Test (expected = IllegalArgumentException.class)
    public void testParseXMLNullDoc() throws Exception
    {
        System.out.println("parseXML");
        ParseXMLFile instance = new ParseXMLFile(null, this.filePathNullDoc);
        instance.parseXML();
                     
        //---- Test of extractTagNames method, of class ParseXMLFile.
        assertEquals(instance.getCellName(), "cell");
        assertEquals(instance.getSpreadsheetName(), "spreadsheet");
        //---- Test the document created with the file reading
        assertNotNull(instance.getDoc());
    }

    /**
     * Test of extractIdsSpreadsheets method, of class ParseXMLFile.
     * @throws javax.xml.parsers.ParserConfigurationException
     * @throws org.xml.sax.SAXException
     * @throws java.io.IOException
     */
    @Test
    public void testExtractIdsSpreadsheets() throws ParserConfigurationException, SAXException, IOException
    {
        System.out.println("extractIdsSpreadsheets");
            
        ParseXMLFile instance = new ParseXMLFile(null, this.filePath);
        instance.parseXML();
        //previous tested
        instance.parseXML();
        
        List<Integer> result = instance.extractIdsSpreadsheets();
        
         List<Integer> expResult = new ArrayList<>();
        expResult.add(0);
        expResult.add(2);
        expResult.add(4);
        expResult.add(5);
         
        assertEquals(expResult, result);
        
    }
    
}
