package csheets.ext.importExport;

import csheets.core.Cell;
import csheets.core.CellListener;
import csheets.ext.style.StylableCell;
import csheets.ext.style.StyleExtension;
import csheets.ui.sheet.SpreadsheetTable;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 *
 * @author André Oliveira
 */
public class ExportTextLinkListener implements CellListener {

    private ImportExportTextLinkStrategy importExport;
    private SpreadsheetTable focusOwner;

    /**
     *
     * Constructor o ExportTextLinkListener
     *
     * @param importExport ImportExportTextLinkStrategy Object for export
     * content
     * @param focusOwner Active SpreadsheetTable
     */
    public ExportTextLinkListener(ImportExportTextLinkStrategy importExport, SpreadsheetTable focusOwner) {

        this.importExport = importExport;
        this.focusOwner = focusOwner;

    }

    /**
     * Listener is the cells value is changed
     * When a modification occurs the border of linked cells is changed to red.
     *
     * @param cell Cell changed
     */
    @Override
    public void valueChanged(Cell cell) {

        if (cell != null) {
            Cell[][] listenedCells = this.importExport.getSelectedCells();
            int columns = listenedCells[0].length;
            int rows = listenedCells.length;

            Cell start = listenedCells[0][0];
            Cell end = listenedCells[rows - 1][columns - 1];
            this.focusOwner.changeSelection(start.getAddress().getRow(),
                    start.getAddress().getColumn(), false, false);

            this.focusOwner.changeSelection(end.getAddress().getRow(),
                    end.getAddress().getColumn(), false, true);
            this.importExport.exportToFile(focusOwner);

            for (int i = 0; i < listenedCells.length; i++) {
                for (int j = 0; j < listenedCells[0].length; j++) {
                    StylableCell stylableSource = (StylableCell) listenedCells[i][j].getExtension(
                            StyleExtension.NAME);

                    Border redLine = BorderFactory.createLineBorder(Color.RED);

                    stylableSource.setBorder(redLine);
                }
            }

        }
    }

    /**
     * Content Changed
     *
     * @param cell Cell changed
     */
    @Override
    public void contentChanged(Cell cell) {
        return;
    }

    /**
     * Dependets Changed
     *
     * @param cell Cell changed
     */
    @Override
    public void dependentsChanged(Cell cell) {
        return;
    }

    /**
     * Cell Cleared
     * Removes the listener of each cell and prevents to link this cells again
     * after removes
     *
     * @param cell Cell changed
     */
    @Override
    public void cellCleared(Cell cell) {
       
        Cell[][] listenedCells = this.importExport.getSelectedCells();
        for (int i = 0; i < listenedCells.length; i++) {
            for (int j = 0; j < listenedCells[0].length; j++) {
                
                listenedCells[i][j].removeCellListener(this);
                
                listenedCells[i][j].clear();
                
                StylableCell stylableSource = (StylableCell) listenedCells[i][j].getExtension(
                        StyleExtension.NAME);

                stylableSource.setBorder(null);
            }
        }
  
    }

    /**
     * Cell Copied
     *
     * @param cell Cell Copied
     * @param source Content of cells
     */
    @Override
    public void cellCopied(Cell cell, Cell source) {
        return;
    }


    public void styleChanged(Cell cell) {
        return;
    }
}
