/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.lang.files;

import csheets.core.*;
import java.io.File;

/**
 * Base class to all export types
 *
 * @author smoli
 */
public abstract class ExportStrategy {
    
    private final File exportFile;
    private final String workbookTagName;
    private final String spreadsheetTagName;
    private final String cellTagName;
    
    public ExportStrategy(File exportFile, String workbookTagName, String spreadsheetTagName, String cellTagName){
        this.exportFile = exportFile;
        this.workbookTagName = workbookTagName;
        this.spreadsheetTagName = spreadsheetTagName;
        this.cellTagName = cellTagName;
    }

    public abstract void exportWorkbook(Workbook workbook);

    public abstract void exportSpreadsheet(Spreadsheet spreadsheet);

    public abstract void exportCells(Cell[][] cells);

    /**
     * @return the exportFile
     */
    public File getExportFile() {
        return exportFile;
    }

    /**
     * @return the workbookTagName
     */
    public String getWorkbookTagName() {
        return workbookTagName;
    }

    /**
     * @return the spreadsheetTagName
     */
    public String getSpreadsheetTagName() {
        return spreadsheetTagName;
    }

    /**
     * @return the cellTagName
     */
    public String getCellTagName() {
        return cellTagName;
    }
}
