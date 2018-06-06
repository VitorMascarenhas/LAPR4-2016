/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.lang.files;

import csheets.core.Cell;
import csheets.core.CellImpl;
import csheets.core.IllegalValueTypeException;
import csheets.core.SpreadsheetImpl;
import csheets.core.Workbook;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vitorMascarenhas1120035
 */
public class ToXML implements IFileType {

    @Override
    public List<String> exportWorkbook(Workbook workbook, String w, String s, String c) {
        
        List<String> content = new ArrayList<>();
        
        String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
        content.add(header);
        String wb = "<" + w + ">\n";
        content.add(wb);
        
        for(int i = 0; i < workbook.getSpreadsheetCount();i++) {
            String ss = "\t<" + s + " id=\"" + i + "\" " + "title=\"" + workbook.getSpreadsheet(i).getTitle() + "\">\n";
            content.add(ss);
            for(int j = 0; j < workbook.getSpreadsheet(i).getColumnCount();j++) {
                for(int k = 0; k < workbook.getSpreadsheet(i).getRowCount();k++) {
                    try {
                        if(workbook.getSpreadsheet(i).getCell(j, k).getValue().toText().isEmpty()) {
                        } else {
                            try {
                                String cell = "\t\t<" + c + " column=\"" + j + "\" " + "row=\"" + k + "\">" + workbook.getSpreadsheet(i).getCell(j, k).getValue().toText() + "</" + c + ">\n";
                                content.add(cell);
                            } catch (IllegalValueTypeException ex) {
                                Logger.getLogger(ToXML.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } catch (IllegalValueTypeException ex) {
                        Logger.getLogger(ToXML.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            ss = "\t</" + s + ">\n";
            content.add(ss);
        }
        
        wb = "</" + w + ">\n";
        content.add(wb);
        return content;
    }

    @Override
    public List<String> exportSpreadSheets(SpreadsheetImpl spreadSheet, String w, String s, String c) {
        
        List<String> content = new ArrayList<>();
        
        String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
        content.add(header);
        
        String tagWb = "<" + w + ">\n";
        content.add(tagWb);
        
        String ss = "\t<" + s + " title=\"" + spreadSheet.getTitle() + "\">\n";
        content.add(ss);
        
        for(int i = 0; i < spreadSheet.getColumnCount();i++) {
            for(int j = 0; j < spreadSheet.getRowCount();j++) {
                try {
                    if(spreadSheet.getCell(i, j).getValue().toText().isEmpty()) {
                    } else {
                        String cell = "";
                        try {
                            cell = "\t\t<" + c + " column=\"" + i + "\" " + "row=\"" + j + "\">" + spreadSheet.getCell(i, j).getValue().toText() + "</" + c + ">\n";
                        } catch (IllegalValueTypeException ex) {
                            Logger.getLogger(ToXML.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        content.add(cell);
                    }
                } catch (IllegalValueTypeException ex) {
                    Logger.getLogger(ToXML.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        ss = "\t</" + s + ">\n";
        content.add(ss);
        tagWb = "</" + w + ">\n";
        content.add(tagWb);
        
        return content;
    }

    @Override
    public List<String> exportCells(Cell[][] cells, String w, String s, String c) {
        
        List<String> content = new ArrayList<>();
        
        String header = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
        content.add(header);
        
        String tagWb = "<" + w + ">\n";
        content.add(tagWb);
        
        String ss = "\t<" + s + ">\n";
        content.add(ss);
        
        for(int i = 0; i < cells.length;i++) {
            for(int j = 0; j < cells[i].length;j++) {
                try {
                    if(cells[i][j].getValue().toText().isEmpty()) {
                    } else {
                        String cell = "";
                        try {
                            cell = "\t\t<" + c + " column=\"" + i + "\" " + "row=\"" + j + "\">" + cells[i][j].getValue().toText() + "</" + c + ">\n";
                        } catch (IllegalValueTypeException ex) {
                            Logger.getLogger(ToXML.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        content.add(cell);
                    }
                } catch (IllegalValueTypeException ex) {
                    Logger.getLogger(ToXML.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        ss = "\t</" + s + ">\n";
        content.add(ss);
        tagWb = "</" + w + ">\n";
        content.add(tagWb);
        
        return content;
        
    }
}