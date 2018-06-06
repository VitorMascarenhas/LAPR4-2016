/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.lang.files;


import csheets.ui.ctrl.UIController;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Sara Ramos
 */
public class ImportXMLStrategy implements ImportStrategy
{

    private UIController uiController;
    
    /**
     * Defines the strategy to import a XML file
     * @param fileName name of the file to import
     * @param uiController
     * @return an object ParseXMLFile 
     */
    @Override
    public ParseXMLFile importFile(String fileName, UIController uiController)
    {
        this.uiController = uiController;
        
        ParseXMLFile parseXMLfile = new ParseXMLFile(this.uiController, fileName);
        try {
            
            parseXMLfile.parseXML();
            return parseXMLfile;
            
        } catch (SAXException | IOException | ParserConfigurationException ex) {
            throw new IllegalArgumentException("File is not well formated!");
        }

    }
 
}
  
