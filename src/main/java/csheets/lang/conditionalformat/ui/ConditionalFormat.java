/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.lang.conditionalformat.ui;

import csheets.core.Cell;
import csheets.core.CellListener;
import csheets.core.IllegalValueTypeException;
import csheets.core.Spreadsheet;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ext.style.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.Border;

/**
 *
 * @author 1950689 Nuno Mota
 */
public class ConditionalFormat {

    private Font trueStyleFont;
    private Color trueStyleBackgroundColor;
    private Border trueStyleBorder;
    private Font falseStyleFont;
    private Color falseStyleBackgroundColor;
    private Border falseStyleBorder;
    private String cellCondition;
    private StylableCell cellStyle;
    private Cell cellActive;
    private Spreadsheet cellActiveSpreadsheet;

    /**
     * create a conditional format object
     *
     * @param cell
     */
    public ConditionalFormat(Cell cell) {
        this.cellActive = cell;
        this.cellCondition = "";
        this.cellStyle = null;
        this.trueStyleFont = null;
        this.trueStyleBackgroundColor = null;
        this.trueStyleBorder = null;
        this.falseStyleFont = null;
        this.falseStyleBackgroundColor = null;
        this.falseStyleBorder = null;
    }

    /**
     * get border style for 'true' condition
     *
     * @return
     */
    public Border getTrueStyleBorder() {
        return trueStyleBorder;
    }

    /**
     * set border style for 'true' condition
     *
     * @param trueStyleBorder
     */
    public void setTrueStyleBorder(Border trueStyleBorder) {
        this.trueStyleBorder = trueStyleBorder;
    }

    /**
     * get border style for 'false' condition
     *
     * @return
     */
    public Border getFalseStyleBorder() {
        return falseStyleBorder;
    }

    /**
     * set border style for 'false' condition
     *
     * @param falseStyleBorder
     */
    public void setFalseStyleBorder(Border falseStyleBorder) {
        this.falseStyleBorder = falseStyleBorder;
    }

    /**
     * get Font style for 'true' condition
     *
     * @return
     */
    public Font getTrueStyleFont() {
        return trueStyleFont;
    }

    /**
     * set Font style for 'true' condition
     *
     * @param trueStyleFont
     */
    public void setTrueStyleFont(Font trueStyleFont) {
        this.trueStyleFont = trueStyleFont;
    }

    /**
     * get Font style for 'false' condition
     *
     * @return
     */
    public Font getFalseStyleFont() {
        return falseStyleFont;
    }

    /**
     * set Font style for 'false' condition
     *
     * @param falseStyleFont
     */
    public void setFalseStyleFont(Font falseStyleFont) {
        this.falseStyleFont = falseStyleFont;
    }

    /**
     * get Background color style for 'true' condition
     *
     * @return
     */
    public Color getTrueStyleBackgroundColor() {
        return trueStyleBackgroundColor;
    }

    /**
     * set Background color style for 'true' condition
     *
     * @param trueStyleBackgroundColor
     */
    public void setTrueStyleBackgroundColor(Color trueStyleBackgroundColor) {
        this.trueStyleBackgroundColor = trueStyleBackgroundColor;
    }

    /**
     * get Background color style for 'false' condition
     *
     * @return
     */
    public Color getFalseStyleBackgroundColor() {
        return falseStyleBackgroundColor;
    }

    /**
     * set Background color style for 'false' condition
     *
     * @param falseStyleBackgroundColor
     */
    public void setFalseStyleBackgroundColor(Color falseStyleBackgroundColor) {
        this.falseStyleBackgroundColor = falseStyleBackgroundColor;
    }

    /**
     * set active cell in conditional format object
     *
     * @param cellActive
     */
    public void setCellActive(Cell cellActive) {
        this.cellActive = cellActive;
    }

    /**
     * set active spreadsheet in conditional format object
     *
     * @param cellActiveSpreadsheet
     */
    public void setCellActiveSpreadsheet(Spreadsheet cellActiveSpreadsheet) {
        this.cellActiveSpreadsheet = cellActiveSpreadsheet;
    }

    /**
     * set condition in conditional format object
     *
     * @param cellCondition
     * @throws FormulaCompilationException
     * @throws IllegalValueTypeException
     */
    protected void setCellCondition(String cellCondition) throws FormulaCompilationException, IllegalValueTypeException {
        this.cellCondition = cellCondition;

    }

    /**
     * apply style to cell
     *
     * @param strResult
     */
    protected void setStyleFormat(String strResult) {
        StylableCell sc = (StylableCell) this.cellActive.getExtension(
                StyleExtension.NAME);
        sc.resetStyle();
        if (strResult.equalsIgnoreCase("true")) {
            sc.setBackgroundColor(this.getTrueStyleBackgroundColor());
            sc.setFont(this.getTrueStyleFont());
            sc.setBorder(this.getTrueStyleBorder());

        } else {
            sc.setBackgroundColor(this.getFalseStyleBackgroundColor());
            sc.setFont(this.getFalseStyleFont());
            sc.setBorder(this.getFalseStyleBorder());

        }
        for (CellListener listener : sc.getCellListeners()) {
            listener.valueChanged(sc);
            listener.styleChanged(this.cellActive);

        }
        sc.styleChanged(cellActive);
        sc.notifyStyleChanged(cellActive);
    }

    /**
     * get cell condition
     *
     * @return
     */
    public String getCellCondition() {
        return cellCondition;
    }

}
