/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.importExport;

import csheets.core.Cell;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.UIController;
import csheets.ui.sheet.SpreadsheetTable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * a Implementation of a Strategy for import and export data to/from Text Files
 * @author jvmvi
 */
public class ImportExportTextStrategy implements ImportExportStrategy {
    
    private String delimiter;
    private String dir;
    private String filename;
    private boolean header;

    
    public ImportExportTextStrategy() {
        this.delimiter = "";
        this.dir = "";
        this.filename = "";
        this.header = false;
    }
    
    /**
     * Constructor for ImportExportTextStrategy
     * @param delimiter special character used to separate columns
     * @param dir directory of the file
     * @param fileName name of the file
     * @param header true if the first line of the text file should be treated 
     *                  as containing the header of the columns
     */
    public ImportExportTextStrategy(String delimiter,String dir,String fileName,boolean header) {
        this.delimiter = delimiter;
        this.dir = dir;
        this.filename = fileName;
        this.header = header;
    }
    
    /**
     * Change a delimiter
     * @param delimiter special character used to separate columns
     */
    public void setDelimiter(String delimiter){
        this.delimiter = delimiter;
    }

    /**
     * Change the directory of the file
     * @param dir directory of the file
     */
    public void setDir(String dir){
        this.dir = dir;
    }

    /**
     * Change the name of the file
     * @param fileName name of the file
     */
    public void setFileName(String fileName){
        this.filename = fileName;
    }

    /**
     * Change the value of header
     * @param header true if the first line of the text file should be treated 
     *                  as containing the header of the columns
     */
    public void setHeader(boolean header){
        this.header = header;
    }

    /**
     * Retrieving the delimiter
     * @return special character used to separate columns
     */
    public String getDelimiter(){
        return this.delimiter;
    }
   
    /**
     * Retrieving the directory
     * @return directory of the file
     */
    public String getDir(){
        return this.dir;
    }
   
    /**
     * Retrieving the filename
     * @return name of the file
     */
    public String getFileName(){
       return this.filename;
    }

    /**
     * Export Selected Cells to The Text File
     * @param focusOwner SpreadsheetTable with the selected Cells
     */
    @Override
    public void exportToFile(SpreadsheetTable focusOwner){
        try {
            File dire = new File(dir);
            File file = new File(dire, filename);
            
            FileWriter writer = new FileWriter(file, false);
            int start=0;
            if(this.header)
                start++;
        
            Cell[][] selectedCells = focusOwner.getSelectedCells();

                for (int i = start; i < selectedCells.length ; i++) {
                    for (int j = 0; j < selectedCells[i].length; j++) {
                        if(j!=0)
                            writer.append(delimiter);
                        writer.append(selectedCells[i][j].getContent());
                    }
                    writer.append('\r');
                    writer.append('\n');
                }
                writer.flush();
            writer.close();
        } catch (IOException e) {
            //TODO
        }
    }
    
    /**
     * Import Data from a text File to the active Spreadsheet starting in selected cell
     * @param focusOwner SpreadsheetTable with a Selected Cell(s)
     * @param uiController controller of UI app to necessary refresh
     */
    @Override
    public void importFromFile(SpreadsheetTable focusOwner, UIController uiController){
        
        List<List<String>> listString = null;
        try {
            listString = readFile();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImportExportTextStrategy.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (listString.isEmpty()) {
                return;
        }
        
        int initrow=focusOwner.getSelectedRow();
        int initCol=focusOwner.getSelectedColumn();
        int start=0;
        if(this.header)
            start++;
        
        for(int i=start; i < listString.size(); i++, initrow++)
        {
            for(int j = 0; j < listString.get(i).size(); j++, initCol++){
                try {
                    uiController.getActiveSpreadsheet().getCell(initCol,initrow).setContent(listString.get(i).get(j));
                } catch (FormulaCompilationException ex) {
                    Logger.getLogger(ImportExportTextStrategy.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            initCol=focusOwner.getSelectedColumn();
        }
    }
    
    /**
     * Read a Text File and return it in a List<List<String>> separated with delimiter
     * @return List<List<String>> of imported data
     * @throws FileNotFoundException if the file do not exist
     */
    private List<List<String>> readFile() throws FileNotFoundException {
        
        List<List<String>> list = new ArrayList<>();
        
        File dire = new File(dir);
        File file = new File(dire, filename);

        try (Scanner in = new Scanner(file)) {
            
            while (in.hasNextLine()){
                String line = in.nextLine();
                list.add(Arrays.asList(line.split(delimiter)));
            }
            in.close();
        } catch (IOException e) {
            Logger.getLogger(ImportExportTextStrategy.class.getName()).log(Level.SEVERE, null, e);
        } 
	return list;
    }
    
    
}

