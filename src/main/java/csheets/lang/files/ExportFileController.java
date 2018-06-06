/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.lang.files;

import csheets.core.Cell;
import csheets.core.SpreadsheetImpl;
import csheets.lang.files.ExportFile;
import csheets.lang.files.ui.ExportFilePanel;
import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author VitorMascarenhas1120035
 */
public class ExportFileController extends FocusOwnerAction {
    
    private final UIController uiController;
    private IFileType fileType = new ToXML();
    private ExportFilePanel exportFilePanel;
    
    private ExportFactory factory;
    private ExportStrategy strategy;
    
    
    public ExportFileController(UIController uiController, ExportFilePanel exportFilePanel) {
        this.uiController = uiController;
        this.exportFilePanel = exportFilePanel;
        
        factory = ExportFactory.getInstance();
        
    }

    public void exportWorkbook(String workbook, String spreadsheet, String cell, File exportFile){
        strategy = factory.getStategy(FileType.XML, exportFile, workbook, spreadsheet, cell);
        strategy.exportWorkbook(uiController.getActiveWorkbook());
        
    }
    
    public void exportCells(String workbook, String spreadsheet, String cell, File exportFile, Cell[][] cells){
        strategy = factory.getStategy(FileType.XML, exportFile, workbook, spreadsheet, cell);
        strategy.exportCells(cells);        
    }
    
    public List<String> createXmlWithWorkbook(String workbook, String spreadsheet, String cell) {
        List<String> list = fileType.exportWorkbook(uiController.getActiveWorkbook(), workbook, spreadsheet, cell);
        return list;

        
    }
    
    public List<String> createXmlWithSpreadsheet(SpreadsheetImpl spread, String workbook, String spreadsheet, String cell) {
        List<String> list = fileType.exportSpreadSheets(spread, workbook, spreadsheet, cell);
        return list;
    }
    
    public List<String> createXmlWithCells(Cell[][] cells, String workbook, String spreadsheet, String cell) {
        List<String> content = fileType.exportCells(cells, workbook, spreadsheet, cell);
        return content;
    }
    
    public Cell[][] getCells() {
        return focusOwner.getSelectedCells();
    }
    
/*    public List<String> createXmlWithCells(String workbook, String spreadsheet, String cell) {
        List<String> list = fileType.exportCells(uiController.getActiveWorkbook(), workbook, spreadsheet, cell);
        return list;
    }*/

    @Override
    protected String getName() {
        return "Export file";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}