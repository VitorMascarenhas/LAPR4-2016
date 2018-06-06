/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.lang.conditionalformat.ui;

import csheets.core.Cell;
import csheets.core.CellListener;
import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.Expression;
import csheets.core.formula.compiler.ExcelExpressionCompiler;
import csheets.core.formula.compiler.FormulaCompilationException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1950689 Nuno Mota
 */
public class CondFrmtEscuta implements CellListener {

    private Cell cell;
    private String condition;
    private ConditionalFormat conditionalFormat;
    private String content;

    /**
     * creates a conditional formating listener
     *
     * @param cell
     * @throws FormulaCompilationException
     */
    public CondFrmtEscuta(Cell cell) throws FormulaCompilationException {
        this.cell = cell;
        this.conditionalFormat = null;
        this.condition = "";
        this.content = null;
    }

    /**
     * set conditional format object to the listener
     *
     * @param conditionalFormat
     */
    public void setConditionalFormat(ConditionalFormat conditionalFormat) {
        this.conditionalFormat = conditionalFormat;
    }

    /**
     * set condition in conditional formating listener
     *
     * @param condition
     * @throws FormulaCompilationException
     * @throws IllegalValueTypeException
     */
    protected void setCondition(String condition) throws FormulaCompilationException, IllegalValueTypeException {

        if (null == condition || condition.isEmpty()) {
            return;
        }
        this.condition = condition;

        Value v = evaluate();
        style(v);
    }

    /**
     * action when the cell value has changed
     *
     * @param cell
     */
    @Override
    public void valueChanged(Cell cell) {
        if (null == cell) {
            return;
        }
        if (null == this.cell.getContent()) {
            return;
        }
        String content = new String(this.cell.getContent());
        if ((content != null) && (!content.isEmpty())) {
            if ((this.content == null) || (this.content.isEmpty())) {
                this.content = content;
                evaluateContent();
            } else {
                this.content = null;
            }

        }
    }

    /**
     * updates dependents
     *
     * @param cell
     */
    @Override
    public void dependentsChanged(Cell cell) {
        if (null == cell) {
            return;
        }
        if (null == this.cell.getContent()) {
            return;
        }
        String content = new String(this.cell.getContent());
        if ((content != null) && (!content.isEmpty())) {
            evaluateContent();
        }
    }

    /**
     * cell cleared action
     *
     * @param cell
     */
    @Override
    public void cellCleared(Cell cell) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * cell copied action
     *
     * @param cell
     * @param source
     */
    @Override
    public void cellCopied(Cell cell, Cell source) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * action when cell's content has changed
     *
     * @param cell
     */
    @Override
    public void contentChanged(Cell cell) {
        if (null == cell) {
            return;
        }
        if (null == this.cell.getContent()) {
            return;
        }
        String content = new String(this.cell.getContent());
        if ((content != null) && (!content.isEmpty())) {
            evaluateContent();
        }
    }

    /**
     * evaluation method to evaluate the condition
     *
     * @return
     * @throws FormulaCompilationException
     * @throws IllegalValueTypeException
     */
    private Value evaluate() throws FormulaCompilationException, IllegalValueTypeException {
        ExcelExpressionCompiler excelEC = new ExcelExpressionCompiler();
        Expression expr;
        if ((this.condition != null)
                && (!this.condition.isEmpty())) {
            expr = excelEC.compile(cell, this.condition);
            return expr.evaluate();
        }
        return null;

    }

    /**
     * method to apply style to cell
     *
     * @param value
     * @throws IllegalValueTypeException
     */
    private void style(Value value) throws IllegalValueTypeException {
        if (value == null) {
            return;
        }
        if (value.isOfType(Value.Type.BOOLEAN)) {
            boolean b = value.toBoolean();
            if (b) {
                this.conditionalFormat.setStyleFormat("TRUE");
            } else {
                this.conditionalFormat.setStyleFormat("FALSE");
            }
        }

    }

    /**
     * method to evaluate cell's content
     */
    private void evaluateContent() {
        try {
            String s = new String(condition);
            setCondition(s);
        } catch (FormulaCompilationException ex) {
            Logger.getLogger(CondFrmtEscuta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalValueTypeException ex) {
            Logger.getLogger(CondFrmtEscuta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * get conditional formating listener cell
     *
     * @return
     */
    protected Cell getCell() {
        return cell;
    }

    /**
     * get conditional formating object
     *
     * @return
     */
    public ConditionalFormat getConditionalFormat() {
        return conditionalFormat;
    }

    /**
     * get conditional formating listener's condition
     *
     * @return
     */
    public String getCondition() {
        return condition;
    }

    /**
     * get conditional formating listener's content
     *
     * @return
     */
    public String getContent() {
        return content;
    }

    /**
     * action when cell's style has changed
     *
     * @param cell
     */
    @Override
    public void styleChanged(Cell cell) {

    }

}
