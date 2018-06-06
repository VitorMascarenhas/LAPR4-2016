/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ui;

import csheets.core.Cell;
import csheets.core.CellListener;
import csheets.core.Spreadsheet;
import csheets.core.Value;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.enums.SortOption;
import csheets.ui.ext.CellRangeSort;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1950689 Nuno Mota
 */
public class AutomaticSortListener implements CellListener {

    private Cell cell;
    private int column;
    private Cell[][] selectedCells;
    private SortOption sortOption;
    private Spreadsheet sheet;

    public AutomaticSortListener(Cell cell) {
        this.cell = cell;
        this.column = -1;
        this.selectedCells=null;
        this.sortOption=null;
        this.sheet=null;
    }
    public boolean resetAutomaticSortListener() {
        this.column = -1;
        this.selectedCells=null;
        this.sortOption=null;
        this.sheet=null;
        return true;
    }
    public boolean setAutomaticSort(int col, Cell[][] selCls,SortOption sortOpt, Spreadsheet sht){
        this.column = col;
        this.selectedCells=selCls;
        this.sortOption=sortOpt;
        this.sheet=sht;
        return true;
    }
    private void doSort() {
        if(selectedCells == null || column == -1) return;
        CellRangeSort sorter = new CellRangeSort(selectedCells, sortOption);
        Value[][] sortedValues = sorter.sort(column);
        
        for (int i = 0; i < selectedCells.length; i++) {
            for (int j = 0; j < selectedCells[i].length; j++) {
                Cell cell = sheet.getCell(selectedCells[i][j].getAddress());
                try {
                    cell.setContent(sortedValues[i][j].toString());
                } catch (FormulaCompilationException ex) {
                    Logger.getLogger(CustomSortDialog.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    @Override
    public void valueChanged(Cell cell) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        doSort();
    }

    @Override
    public void contentChanged(Cell cell) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        doSort();
    }

    @Override
    public void dependentsChanged(Cell cell) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cellCleared(Cell cell) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cellCopied(Cell cell, Cell source) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void styleChanged(Cell cell) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean setSortColumn(int column) {
        if((selectedCells==null) ||(sheet==null) ) return false;
        for (int i = 0; i < selectedCells.length; i++) {
            for (int j = 0; j < selectedCells[i].length; j++) {
                Cell cell = sheet.getCell(selectedCells[i][j].getAddress());
                for(CellListener cl : cell.getCellListeners()){
                    if(cl instanceof AutomaticSortListener){
                        AutomaticSortListener asl = (AutomaticSortListener) cl;
                        if(asl.getColumn()!=-1){
                            asl.setColumn(-1);
                        }
                        if(cell.getAddress().getColumn()==column){
                            asl.setColumn(column);
                        }
                        
                    }
                }
            }
        }

        doSort();
        return true;
    }

}
