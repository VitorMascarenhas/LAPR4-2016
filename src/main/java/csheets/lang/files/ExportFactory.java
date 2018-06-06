/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.lang.files;

import java.io.File;

/**
 * Factory to build file export strategies
 * @author smoli
 */
public class ExportFactory {

    private static final ExportFactory instance = null;

    protected ExportFactory() {
    }

    /***
     * Returns the factory instance
     * @return The factory instance
     */
    public static ExportFactory getInstance() {
        if (instance == null) {
            return new ExportFactory();
        }

        return instance;
    }
    
    /***
     * Returns the strategy to export the chosen file type
     * @param fileType file type to export
     * @param exportFile the file to save the results to
     * @param workbookTagName the chosen workbook tag name
     * @param spreadsheetTagName the chosen spreadsheet tag name
     * @param cellTagName the chosen cell tag name
     * @return the export startegy
     */
    public ExportStrategy getStategy(FileType fileType, 
            File exportFile, 
            String workbookTagName, 
            String spreadsheetTagName, 
            String cellTagName){
        
        switch(fileType){
            case XML:
                return new ExportXmlStrategy(exportFile, workbookTagName, spreadsheetTagName, cellTagName);
                default:
                    return null;
        }
    }
}
