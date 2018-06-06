/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ui.ctrl;

import csheets.CleanSheets;
import csheets.core.Cell;
import csheets.ui.CustomSortDialog;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.Action.SMALL_ICON;
import javax.swing.ImageIcon;

/**
 * Action that presents the user with options to sort a range of cells
 *
 * @author smoli
 */
public class CustomSortAction extends FocusOwnerAction {

    @Override
    protected String getName() {
        return "Custom sort";
    }

    @Override
    protected void defineProperties() {
        setEnabled(true);
        putValue(SMALL_ICON, new ImageIcon(CleanSheets.class.getResource("res/img/custsort.gif")));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        CustomSortDialog customSortDialog = new CustomSortDialog(null, true, focusOwner.getSelectedCells(), getSelectedColumnNames(), focusOwner.getSpreadsheet());
        customSortDialog.setLocationRelativeTo(null);
        customSortDialog.setVisible(true);
    }

    private List<String> getSelectedColumnNames() {
        Cell selectedCells[][] = focusOwner.getSelectedCells();
        Cell cellRow[] = selectedCells[0];
        List<String> columnNames = new ArrayList<>();
        for (Cell cellRow1 : cellRow) {
            int column = cellRow1.getAddress().getColumn();
            columnNames.add(focusOwner.getColumnName(column));
        }
        return columnNames;
    }

}
