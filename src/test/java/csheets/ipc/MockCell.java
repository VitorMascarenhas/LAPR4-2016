/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ipc;

import csheets.core.Address;
import csheets.core.Cell;
import csheets.core.CellListener;
import csheets.core.Spreadsheet;
import csheets.core.Value;
import csheets.core.formula.Formula;
import csheets.core.formula.compiler.FormulaCompilationException;
import java.util.SortedSet;

/**
 *
 * @author smoli
 */
public class MockCell implements Cell{

    private Value value;
    
    public MockCell(Value value){
        this.value = value;
    }
    
    @Override
    public Spreadsheet getSpreadsheet() {
        return null;
    }

    @Override
    public Address getAddress() {
       return new Address(0, 0);
    }

    @Override
    public Value getValue() {
        return this.value;
    }

    @Override
    public String getContent() {
        return this.value.toString();
    }

    @Override
    public Formula getFormula() {
        return null;
    }

    @Override
    public void setContent(String content) throws FormulaCompilationException {
        
    }

    @Override
    public void clear() {
        
    }

    @Override
    public SortedSet<Cell> getPrecedents() {
        return null;
    }

    @Override
    public SortedSet<Cell> getDependents() {
        return null;
    }

    @Override
    public void copyFrom(Cell source) {
        
    }

    @Override
    public void moveFrom(Cell source) {
        
    }

    @Override
    public void addCellListener(CellListener listener) {
        
    }

    @Override
    public void removeCellListener(CellListener listener) {
        
    }

    @Override
    public CellListener[] getCellListeners() {
        return null;
    }

    @Override
    public int compareTo(Cell o) {
        return this.value.compareTo(o.getValue());
    }

    @Override
    public Cell getExtension(String name) {
        return null;
    }
    
    @Override
    public boolean equals(Object obj ){
        if (this == obj) {
            return true;
        }
        
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        
        MockCell m = (MockCell) obj;
        
        return this.value.equals(m.getValue());
    }
    
}
