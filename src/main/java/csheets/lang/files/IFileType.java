/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.lang.files;

import csheets.core.Cell;
import csheets.core.CellImpl;
import csheets.core.SpreadsheetImpl;
import csheets.core.Workbook;
import java.util.List;

/**
 *
 * @author vitoralexandremascarenhasmascarenhas
 */
public interface IFileType {
    
    /**
     * This method receives a workbook and
     * three strings, the first for tag workbook,
     * the second to the tag spreadsheet and the third
     * for tag cell, makes the separation of spreadsheets 
     * and cells and returns a String 
     * list to be stored in an xml file
     * @param workbook
     * @param wb
     * @param ss
     * @param c
     * @return 
     */
    public List<String> exportWorkbook(Workbook workbook, String wb, String ss, String c);
    
    /**
     * This method receives a spreadsheet and
     * three strings, the first for tag workbook,
     * the second to the tag spreadsheet and the third
     * for tag cell, makes the separation of spreadsheets 
     * and cells and returns a String 
     * list to be stored in an xml file
     * @param spreadSheets
     * @param wb
     * @param ss
     * @param c
     * 
     * @return List
     */
    public List<String> exportSpreadSheets(SpreadsheetImpl spreadSheets, String wb, String ss, String c);
    
    /**
     * This method receives a matrix of the cells and
     * three stings, the first for tag workbook,
     * the second to the tag spreadsheet and the third
     * for tag cell, makes the separation of spreadsheets 
     * and cells and returns a String 
     * list to be stored in an xml file
     * 
     + @param spreadsheet
     * @param minRow
     * @param minCol
     * @param maxRow
     * @param maxCol
     * @param wb
     * @param ss
     * @param c
     * @return List
     */
    public List<String> exportCells(Cell[][] cells, String wb, String ss, String c);
    
}
