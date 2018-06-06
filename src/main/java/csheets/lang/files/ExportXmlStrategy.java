/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.lang.files;

import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import csheets.ext.comments.Comment;
import csheets.ext.comments.CommentableCell;
import csheets.ext.comments.CommentsExtension;
import csheets.ext.style.StylableCell;
import csheets.ext.style.StyleExtension;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Concrete strategy to export to XML
 * @author smoli
 */
public class ExportXmlStrategy extends ExportStrategy {

    private final String fileHeader;

    public ExportXmlStrategy(File exportFile, String workbookTagName, String spreadsheetTagName, String cellTagName) {
        super(exportFile, workbookTagName, spreadsheetTagName, cellTagName);

        this.fileHeader = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";

    }

    /**
     * Exports a workbook to an xml file
     *
     * @param workbook workbook to export to a xml file
     */
    @Override
    public void exportWorkbook(Workbook workbook) {
        StringBuilder sb = new StringBuilder(this.fileHeader);
        sb.append("<").append(getWorkbookTagName()).append(">\n"); //workbook tag name

        for (int i = 0; i < workbook.getSpreadsheetCount(); i++) {
            sb.append("\t<").append(getSpreadsheetTagName()).append(" id=\"").append(i).append("\" " + "title=\"").append(workbook.getSpreadsheet(i).getTitle()).append("\">\n"); //spreadsheet tag

            Cell[][] allCells = new Cell[workbook.getSpreadsheet(i).getRowCount()][workbook.getSpreadsheet(i).getColumnCount()];

            for (int j = 0; j < workbook.getSpreadsheet(i).getRowCount(); j++) {
                for (int k = 0; k < workbook.getSpreadsheet(i).getColumnCount(); k++) {
                    allCells[j][k] = workbook.getSpreadsheet(i).getCell(k, j);
                    
                    sb.append(generateCellXml(allCells));
                }
            }

            sb.append("</").append(getSpreadsheetTagName()).append(">\n"); // close spreadsheet tag
        }

        sb.append("</").append(getWorkbookTagName()).append(">\n"); //close workbook tag

        try {
            saveToFile(sb);
        } catch (IOException ex) {
            Logger.getLogger(ExportXmlStrategy.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Exports a spreadsheet to an xml file
     *
     * @param spreadsheet spreadsheet to export
     */
    @Override
    public void exportSpreadsheet(Spreadsheet spreadsheet) {
        StringBuilder sb = new StringBuilder(this.fileHeader);
        sb.append("<").append(getWorkbookTagName()).append(">\n"); //workbook tag name
        sb.append("\t<").append(getSpreadsheetTagName()).append("title=\"").append(spreadsheet.getTitle()).append("\" >\n");

        Cell[][] allCells = new Cell[spreadsheet.getRowCount()][spreadsheet.getColumnCount()];

        sb.append(generateCellXml(allCells));

        sb.append("</").append(getSpreadsheetTagName()).append(">\n"); // close spreadsheet tag
        sb.append("</").append(getWorkbookTagName()).append(">\n"); //close workbook tag     

        try {
            saveToFile(sb);
        } catch (IOException ex) {
            Logger.getLogger(ExportXmlStrategy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Exports a range of cells to an xml file
     *
     * @param cells the cell range to export
     */
    @Override
    public void exportCells(Cell[][] cells) {
        StringBuilder sb = new StringBuilder(this.fileHeader);
        sb.append("<").append(getWorkbookTagName()).append(">\n"); //workbook tag name

        sb.append("\t<").append(getSpreadsheetTagName()).append("\">\n"); //spreadsheet tag

        sb.append(generateCellXml(cells));

        sb.append("</").append(getSpreadsheetTagName()).append(">\n"); // close spreadsheet tag

        sb.append("</").append(getWorkbookTagName()).append(">\n"); //close workbook tag

        try {
            saveToFile(sb);
        } catch (IOException ex) {
            Logger.getLogger(ExportXmlStrategy.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void saveToFile(StringBuilder result) throws FileNotFoundException, IOException {
        FileOutputStream fileOutput = new FileOutputStream(getExportFile());

        
        String x = result.toString();
        fileOutput.write(result.toString().getBytes());
    }

    private StringBuilder generateCellXml(Cell[][] cells) {
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < cells.length; j++) {
            for (int k = 0; k < cells[j].length; k++) {
                Cell c = cells[j][k];
                if(c == null) break;
                if (c.getValue() != null) {
                    builder.append("\t\t<").append(getCellTagName()).append("column=\"").append(j).append("\" row=\"").append(k);
                    builder.append("\" ").append("formula=\"");
                    try {
                        if (c.getFormula() != null) {
                            builder.append(c.getFormula().toString());
                        }
                    } catch (NullPointerException ex) {

                    }

                    builder.append("\" ");

                    try {
                        StylableCell st = (StylableCell) c.getExtension(StyleExtension.NAME);

                        if (st != null) {
                            builder.append("backgroundColor=\"rgb(");
                            builder.append(st.getBackgroundColor().getRed()).append(",");
                            builder.append(st.getBackgroundColor().getGreen()).append(",");
                            builder.append(st.getBackgroundColor().getBlue()).append(")\" ");

                            builder.append("font=\"").append(st.getFont().toString()).append("\" ");

                            builder.append("foregroundColor=\"rgb(");
                            builder.append(st.getForegroundColor().getRed()).append(",");
                            builder.append(st.getForegroundColor().getGreen()).append(",");
                            builder.append(st.getForegroundColor().getBlue()).append(")\" ");

                            builder.append("hAlignment=\"").append(st.getHorizontalAlignment()).append("\" ");
                            builder.append("vAlignment=\"").append(st.getVerticalAlignment()).append("\" ");

                            builder.append("format=\"");
                            if (st.getFormat() != null) {
                                builder.append(st.getFormat().toString()).append("\"");
                            }
                            builder.append("\"");

                        }
                    } catch (NullPointerException ex) {
                        builder.append("backgroundColor=\"rgb(");
                        builder.append("0,0,0)");

                        builder.append("font=\"\" ");

                        builder.append("foregroundColor=\"rgb(");
                        builder.append("0,0,0)");

                        builder.append("hAlignment=\"").append("\" ");
                        builder.append("vAlignment=\"").append("\" ");

                        builder.append("format=\"");

                        builder.append("\"");
                    }

                    builder.append(">\n");
                    builder.append("\t\t\t<value>\n");

                    builder.append(c.getContent());
                    builder.append("\t\t\t</value>\n");

                    builder.append("\t\t\t\t<comments>\n");
                    CommentableCell com = (CommentableCell) c.getExtension(CommentsExtension.NAME);
                    if (com != null && com.hasComment()) {
                        for (Comment comment : com.returnAllComments()) {
                            builder.append("\t\t\t\t\t<comment id=\"").append(comment.returnCommentId()).append("\" date=\"").
                                    append(comment.returnCommentDate()).append("\" author=\"").
                                    append(comment.returnAuthor()).append("\">").
                                    append(comment.returnComment()).
                                    append("\t\t\t\t\t</comment>\n");
                        }
                    }

                    builder.append("\t\t\t\t</comments>\n");
                }

            }
        }

        return builder;
    }
    
    @Override
    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }
        
        return !(obj == null || obj.getClass() != this.getClass());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.fileHeader);
        return hash;
    }

}
