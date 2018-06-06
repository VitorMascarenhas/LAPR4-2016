package csheets.ext.importExport;

import csheets.core.Cell;
import csheets.ext.style.StylableCell;
import csheets.ext.style.StyleExtension;
import java.awt.Color;
import java.io.File;
import java.util.TimerTask;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 *
 * @author André Oliveira
 */
public abstract class ImportTextLinkListener extends TimerTask {

    private long timeStamp;
    private File file;
    private ImportExportTextLinkStrategy importExport;

    /**
     *
     * Consctuctor of ImportTextLinkListener
     *
     * @param file Object for file where data will be modified
     * @param importExport Object ImportExportTextLinkStrategy for import data
     */
    public ImportTextLinkListener(File file, ImportExportTextLinkStrategy importExport) {

        this.importExport = importExport;
        this.file = file;
        this.timeStamp = file.lastModified();

    }

    /**
     * Run method that check if that file has a modification. Its called by the
     * timer.
     */
    @Override
    public final void run() {
        long localTimeStamp = file.lastModified();

        //if a modification occurs
        if (this.timeStamp != localTimeStamp) {
            this.timeStamp = localTimeStamp;
            onChange(file);
            setListenerBorder();
        }
    }

    /**
     * Abstract methos to be overwrited.
     *
     * @param file
     */
    public abstract void onChange(File file);

    /**
     * Get Last Modification File
     *
     * @return long with timeStamp
     */
    protected long getTimeStamp() {
        return timeStamp;
    }

    /**
     * Changes the border color for each linked cell that is modified
     */
    public void setListenerBorder() {
        Cell[][] listenedCells = this.importExport.getSelectedCells();

        for (int i = 0; i < listenedCells.length; i++) {
            for (int j = 0; j < listenedCells[0].length; j++) {

                if (!listenedCells[i][j].getContent().isEmpty() || listenedCells[i][j] != null) {
                    StylableCell stylableSource = (StylableCell) listenedCells[i][j].getExtension(
                            StyleExtension.NAME);

                    Border greenLine = BorderFactory.createLineBorder(Color.GREEN);

                    stylableSource.setBorder(greenLine);
                }
            }
        }
    }

}
