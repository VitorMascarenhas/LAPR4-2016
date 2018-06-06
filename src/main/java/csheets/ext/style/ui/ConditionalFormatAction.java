/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.style.ui;

import csheets.core.Cell;
import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.Formula;
import csheets.ext.style.StylableCell;
import csheets.ext.style.StyleExtension;
import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.SelectionEvent;
import csheets.ui.ctrl.SelectionListener;
import csheets.ui.ctrl.UIController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.Format;
import java.text.NumberFormat;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.SMALL_ICON;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.paint.Color.color;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;

/**
 * A format changing operation.
 *
 * @author Einar Pehrson
 */
@SuppressWarnings("serial")
public class ConditionalFormatAction extends FocusOwnerAction implements SelectionListener {

    /**
     * The user interface controller
     */
    private UIController uiController;

    /**
     * The cell being styled
     */
    private StylableCell cell;

    /**
     * Creates a new format action.
     *
     * @param uiController the user interface controller
     */
    public ConditionalFormatAction(UIController uiController) {
        this.uiController = uiController;
        uiController.addSelectionListener(this);
    }

    @Override
    protected String getName() {
        return "Conditional Format";
    }

    protected void defineProperties() {
        putValue(MNEMONIC_KEY, KeyEvent.VK_D);
        putValue(SMALL_ICON, new ImageIcon(StyleExtension.class.getResource("res/img/cond_format.gif")));
    }

    /**
     * Updates the state of the action when a new cell is selected.
     *
     * @param event the selection event that was fired
     */
    public void selectionChanged(SelectionEvent event) {
        Cell c = event.getCell();
        cell = c == null ? null : (StylableCell) c.getExtension(StyleExtension.NAME);
//        setEnabled(c == null ? false : cell.isFormattable());
    }

    /**
     * Lets the user select a Conditional format. The format is applied if the
     * cell has a formula that returns a boolean value. User can choose from picker's
     * the background format both for TRUE and FALSE values 
     *
     * @param event the event that was fired
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        if (focusOwner == null) {
            return;
        }

        // Lets user select color for True Values
        Color color_t = JColorChooser.showDialog(
                null,
                "Choose Background Color for TRUE values",
                ((StylableCell) focusOwner.getSelectedCell().
                getExtension(StyleExtension.NAME)).getBackgroundColor());

        // Lets user select color for False Values
        Color color_f = JColorChooser.showDialog(
                null,
                "Choose Background Color for FALSE values",
                ((StylableCell) focusOwner.getSelectedCell().
                getExtension(StyleExtension.NAME)).getBackgroundColor());

        if (color_t != null || color_f != null) {
            // Colors each true selected cell
            for (Cell[] row : focusOwner.getSelectedCells()) {
                for (Cell cell : row) {
                    StylableCell stylableCell = (StylableCell) cell.getExtension(
                            StyleExtension.NAME);

                    try {
                        if (cell.getFormula().evaluate().toBoolean()) {
                            stylableCell.setBackgroundColor(color_t);
                        } else {
                            stylableCell.setBackgroundColor(color_f);
                        }
                    } catch (IllegalValueTypeException ex) {
                    }
                }
                uiController.setWorkbookModified(focusOwner.getSpreadsheet().getWorkbook());
                focusOwner.repaint();
            }
        }
    }
}
