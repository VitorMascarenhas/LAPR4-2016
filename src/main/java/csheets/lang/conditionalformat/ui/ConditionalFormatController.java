/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.lang.conditionalformat.ui;

import csheets.core.CellListener;
import csheets.core.IllegalValueTypeException;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.UIController;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.Border;

/**
 * The controller for conditional formating
 *
 * @author 1950689 Nuno Mota
 */
public class ConditionalFormatController {

    private UIController uiController;
    private ConditionalFormat conditionalFormat;

    /**
     * creates the conditional format controller
     * @param uiC 
     */
    public ConditionalFormatController(UIController uiC) {
        this.uiController = uiC;
        this.conditionalFormat = null;

    }

    /**
     * set condition value
     * @param condition
     * @throws FormulaCompilationException
     * @throws IllegalValueTypeException 
     */
    protected void setConditionValue(String condition) throws FormulaCompilationException, IllegalValueTypeException {

        for (CellListener cl : this.uiController.getActiveCell().getCellListeners()) {
            if (cl instanceof CondFrmtEscuta) {
                CondFrmtEscuta cfl = (CondFrmtEscuta) cl;
                if (cfl.getConditionalFormat() == null) {
                    ConditionalFormat cf = new ConditionalFormat(this.uiController.getActiveCell());
                    cfl.setConditionalFormat(cf);
                }
                cfl.setCondition(condition);
            }
        }
    }

    /**
     * set backgroud color
     * @param resultCondition
     * @param color 
     */
    protected void setBackgroundColor(String resultCondition, Color color) {
        ConditionalFormat cf;
        for (CellListener cl : this.uiController.getActiveCell().getCellListeners()) {
            if (cl instanceof CondFrmtEscuta) {
                CondFrmtEscuta cfl = (CondFrmtEscuta) cl;
                if (cfl.getConditionalFormat() == null) {
                    cf = new ConditionalFormat(this.uiController.getActiveCell());
                } else {
                    cf = cfl.getConditionalFormat();
                }
                if (resultCondition.equalsIgnoreCase("TRUE")) {
                    cf.setTrueStyleBackgroundColor(color);
                } else {
                    cf.setFalseStyleBackgroundColor(color);
                }
                cfl.setConditionalFormat(cf);
            }
        }

    }

    /**
     * set font style
     * @param resultCondition
     * @param font 
     */
    protected void setFont(String resultCondition, Font font) {
        ConditionalFormat cf;
        for (CellListener cl : this.uiController.getActiveCell().getCellListeners()) {
            if (cl instanceof CondFrmtEscuta) {
                CondFrmtEscuta cfl = (CondFrmtEscuta) cl;
                if (cfl.getConditionalFormat() == null) {
                    cf = new ConditionalFormat(this.uiController.getActiveCell());
                } else {
                    cf = cfl.getConditionalFormat();
                }
                if (resultCondition.equalsIgnoreCase("TRUE")) {
                    cf.setTrueStyleFont(font);
                } else {
                    cf.setFalseStyleFont(font);
                }
                cfl.setConditionalFormat(cf);
            }
        }
    }

    /**
     * set border style
     * @param resultCondition
     * @param border 
     */
    void setBorder(String resultCondition, Border border) {
        ConditionalFormat cf;
        for (CellListener cl : this.uiController.getActiveCell().getCellListeners()) {
            if (cl instanceof CondFrmtEscuta) {
                CondFrmtEscuta cfl = (CondFrmtEscuta) cl;
                if (cfl.getConditionalFormat() == null) {
                    cf = new ConditionalFormat(this.uiController.getActiveCell());
                } else {
                    cf = cfl.getConditionalFormat();
                }
                if (resultCondition.equalsIgnoreCase("TRUE")) {
                    cf.setTrueStyleBorder(border);
                } else {
                    cf.setFalseStyleBorder(border);
                }
                cfl.setConditionalFormat(cf);
            }
        }
    }
}
