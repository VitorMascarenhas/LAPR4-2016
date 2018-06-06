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
 *
 * @author André Oliveira
 */
public class ImportExportTextLinkStrategy implements ImportExportStrategy {

    private String delimiter;
    private String dir;
    private String filename;
    private boolean header;
    private Cell[][] selectedCells;

    public ImportExportTextLinkStrategy() {
        this.delimiter = "";
        this.dir = "";
        this.filename = "";
        this.header = false;
        this.selectedCells = null;
    }

    /**
     * Constructor for ImportExportTextStrategy
     *
     * @param delimiter special character used to separate columns
     * @param dir directory of the file
     * @param fileName name of the file
     * @param header true if the first line of the text file should be treated
     * as containing the header of the columns
     */
    public ImportExportTextLinkStrategy(String delimiter, String dir, String fileName, boolean header) {
        this.delimiter = delimiter;
        this.dir = dir;
        this.filename = fileName;
        this.header = header;
    }

    /**
     * Export Selected Cells to The Text File
     *
     * @param focusOwner SpreadsheetTable with the selected Cells
     */
    @Override
    public void exportToFile(SpreadsheetTable focusOwner) {
        try {
            File dire = new File(dir);
            File file = new File(dire, filename);

            FileWriter writer = new FileWriter(file, false);
            int start = 0;
            if (this.header) {
                start++;
            }

            this.selectedCells = focusOwner.getSelectedCells();

            for (int i = start; i < selectedCells.length; i++) {
                for (int j = 0; j < selectedCells[i].length; j++) {
                    if (j != 0) {
                        writer.append(delimiter);
                    }
                    writer.append(selectedCells[i][j].getContent());
                }
                writer.append('\r');
                writer.append('\n');
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Error exporting file!");
        }
    }

    /**
     * Import Data from a text File to the active Spreadsheet starting in
     * selected cell
     *
     * @param focusOwner SpreadsheetTable with a Selected Cell(s)
     * @param uiController controller of UI app to necessary refresh
     */
    @Override
    public void importFromFile(SpreadsheetTable focusOwner, UIController uiController) {

        List<List<String>> listString = null;
        try {
            listString = readFile();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImportExportTextLinkStrategy.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (listString.isEmpty()) {
            return;
        }

        int initrow = focusOwner.getSelectedRow();
        int initCol = focusOwner.getSelectedColumn();
        int start = 0;
        if (this.header) {
            start++;
        }
        
        this.selectedCells = new Cell[listString.size()][listString.get(0).size()];
        
        for (int i = start; i < listString.size(); i++, initrow++) {
            for (int j = 0; j < listString.get(i).size(); j++, initCol++) {
                try {
                    uiController.getActiveSpreadsheet().getCell(initCol, initrow).setContent(listString.get(i).get(j));
                    
                    this.selectedCells[i][j] = uiController.getActiveSpreadsheet().getCell(initCol, initrow);
                    
                } catch (FormulaCompilationException ex) {
                    Logger.getLogger(ImportExportTextLinkStrategy.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            initCol = focusOwner.getSelectedColumn();
        }
    }

    /**
     * Read a Text File and return it in a List<List<String>> separated with
     * delimiter
     *
     * @return List<List<String>> of imported data
     * @throws FileNotFoundException if the file do not exist
     */
    protected List<List<String>> readFile() throws FileNotFoundException {

        List<List<String>> list = new ArrayList<>();

        File dire = new File(dir);
        File file = new File(dire, filename);

        try (Scanner in = new Scanner(file)) {

            while (in.hasNextLine()) {
                
                String line = in.nextLine();
                
                String temp[] = line.split(delimiter);
                
                list.add(Arrays.asList(temp));
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Error reading file!");
        }
        return list;
    }

    /**
     * Returns the dir path
     * @return String with the path
     */
    public String getDir() {
        return this.dir;
    }

    /**
     * Returns the filename
     * 
     * @return String with the filename
     */
    public String getFilename() {
        return this.filename;
    }

    /**
     * Returns selected cells
     * @return Array with selected cells
     */
    public Cell[][] getSelectedCells() {
        return this.selectedCells;
    }
    
    /**
     * Set a range of Cells
     * @param selectedCells Array with cells
     */
    protected void setSelectedCells(Cell[][] selectedCells) {
        this.selectedCells = selectedCells;
    } 

}
