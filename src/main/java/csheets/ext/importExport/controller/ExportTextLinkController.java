package csheets.ext.importExport.controller;

import csheets.core.Cell;
import csheets.ext.importExport.ExportTextLinkListener;
import csheets.ext.importExport.ImportExportTextLinkStrategy;
import csheets.ui.sheet.SpreadsheetTable;

/**
 *
 * @author André Oliveira
 */
public class ExportTextLinkController {

    private ImportExportTextLinkStrategy importExport;
    private SpreadsheetTable focusOwner;

    /**
     *
     * Constructor of Export Link Text
     *
     * @param delimiter String with the delimiter
     * @param dir String with the path of the file
     * @param fileName String with the name of the file
     * @param header boolean if is selected
     * @param focusOwner Actual SpreadsheetTable
     */
    public ExportTextLinkController(String delimiter, String dir, String fileName,
            boolean header, SpreadsheetTable focusOwner) {

        this.focusOwner = focusOwner;
        this.importExport = new ImportExportTextLinkStrategy(delimiter, dir, fileName, header);

    }

    /**
     * Method to exports the selects cells changes every time that occurs a
     * modification. The exportation is made by CellListener.
     */
    public void runExport() {

        this.importExport.exportToFile(this.focusOwner);
        Cell[][] selectedCells = focusOwner.getSelectedCells();

        for (int i = 0; i < selectedCells.length; i++) {
            for (int j = 0; j < selectedCells[i].length; j++) {
                selectedCells[i][j].addCellListener(new ExportTextLinkListener
                (this.importExport, this.focusOwner));
            }
        }  
    }

}
