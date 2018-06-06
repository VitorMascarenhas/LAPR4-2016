package csheets.ext.importExport;

import csheets.ui.ctrl.UIController;
import csheets.ui.sheet.SpreadsheetTable;

/**
 * The interface for the strategies of import and export data
 * @author José Vilela
 */
public interface ImportExportStrategy {

    /**
     * Method to export a SpreadsheetTable to a file
     * @param focusOwner SpreadsheetTable to Export
     */
    public void exportToFile(SpreadsheetTable focusOwner);
    
    /**
     * Method to import from a file to SpreadsheetTable
     * @param focusOwner SpreadsheetTable imported
     * @param uiController crotroller of app to refresh the activeSpreadsgeet
     */
    public void importFromFile(SpreadsheetTable focusOwner, UIController uiController);
    
    
}
