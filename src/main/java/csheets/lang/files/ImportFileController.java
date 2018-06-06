/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.lang.files;

import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Sara Ramos
 */
public class ImportFileController extends FocusOwnerAction
{
    private final UIController uiController;
    private ImportStrategy strategy;
    private ParseXMLFile parseXMLFile;
    
    
    public ImportFileController(UIController uiController){
        this.uiController = uiController;
    }
        
   /**
    * The file selected by the user is imported and workbook, spreadsheet or a 
    * range of cells specified are modified.
    * @param fileName 
    * @return true if the import of the file is successfully and false otherwise
    */
    public boolean importFile(String fileName){
        
        boolean success = false;
        String extension="";
       
        int index = fileName.lastIndexOf(".");
        if(index >0){
            extension = fileName.substring(index+1);
        }
        
        ImportFactory factory = new ImportFactory();
        try{
            this.strategy = factory.importStrategy(extension);
        } catch(IllegalArgumentException ex){
            throw new IllegalArgumentException("The extension of the selected file is not implemented! \nTry another file.");
        }
        if(strategy != null){
            try{
                this.parseXMLFile = this.strategy.importFile(fileName, this.uiController);
                return true;
            }catch(IllegalArgumentException ex){
                throw new IllegalArgumentException("File is not well formated!");
            }
        }
       return success;
    }
   
    /**
     * Extract the ids of spreadsheets that are in the file
     * @return a list with all the id's
     */
    public List<Integer> extractIdsSpreadsheets(){

        return this.parseXMLFile.extractIdsSpreadsheets();
    }
    
    /**
     * Replace data from a spreadsheet or a range of cells
     * @param option Spreadsheet - "Spreadsheet" or a range of cells - "Range"
     * @param idSpreadsheet id of the spreadsheet in which the change is to be implemented
     * @return true if success and false otherwise
     */
    public boolean replaceData(String option, int idSpreadsheet) {
        
        switch(option){
            case "Spreadsheet":
        {
            try {
                return this.parseXMLFile.importXMLReplaceSpreadsheet(idSpreadsheet);
            } catch (ParserConfigurationException | SAXException | IOException | FormulaCompilationException  ex) {
                throw new IllegalArgumentException("Erro na importação");
            }
        }
            
            case "Range":
        {
            try {
                return this.parseXMLFile.importXMLReplaceRange(idSpreadsheet);
            } catch (FormulaCompilationException ex) {
                throw new IllegalArgumentException("Erro na importação");
            }
        }
            
        }
        return false;
    }
    /**
     * Replace all workbook with all the information inside the file
     * @return true if success and false otherwise
     */
    public boolean replaceData(){
        try{    
            return this.parseXMLFile.importXMLReplaceWorkbook();
        } catch (ParserConfigurationException | SAXException | IOException | FormulaCompilationException ex) {
             throw new IllegalArgumentException("Erro na importação");
        }
    }
    
    @Override
    protected String getName()
    {
        return "Import file";
    }

    public ParseXMLFile parser(){
        return this.parseXMLFile;
    }

    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
    
            
    
