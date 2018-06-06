package csheets.ext.importExport.controller;

import csheets.core.Cell;
import csheets.ext.importExport.ImportExportTextLinkStrategy;
import csheets.ext.importExport.ImportTextLinkListener;
import csheets.ui.ctrl.UIController;
import csheets.ui.sheet.SpreadsheetTable;
import java.io.File;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author André Oliveira
 */
public class ImportTextLinkController {

    private ImportExportTextLinkStrategy importExport;
    private SpreadsheetTable focusOwner;
    private UIController uiController;

    /**
     *
     * Constructor of Import Text Link
     * 
     * @param delimiter String with the delimiter
     * @param dir String with the path of the file
     * @param fileName String with the name of the file
     * @param header boolean if is selected
     * @param focusOwner Actual SpreadsheetTable
     * @param uiController Actual uiController
     */
    public ImportTextLinkController(String delimiter, String dir, String fileName,
            boolean header, SpreadsheetTable focusOwner, UIController uiController) {

        this.focusOwner = focusOwner;
        this.uiController = uiController;
        this.importExport = new ImportExportTextLinkStrategy(delimiter, dir, fileName, header);

    }

    /**
     * Method that run every 1 second and imports the changes of a file
     * if have changes. The data is imported by the listener.
     */
    public void runImport() {
        this.importExport.importFromFile(this.focusOwner, this.uiController);

        String dir = this.importExport.getDir();
        String fileName = this.importExport.getFilename();

        TimerTask task = new ImportTextLinkListener(new File(dir + "/" + fileName), this.importExport) {

            @Override
            public void onChange(File file) {
                    importExport.importFromFile(focusOwner, uiController);
                } 
        };

        Timer timer = new Timer();
        
        // repeat the check every second
        timer.schedule(task, new Date(), 1000);

    }

}
