/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ui.ctrl;

import csheets.CleanSheets;
import csheets.ui.enums.SortOption;
import csheets.ui.ext.CellRangeSort;
import java.awt.event.ActionEvent;
import static javax.swing.Action.SMALL_ICON;
import javax.swing.ImageIcon;

/**
 * Action to sort a selection of cells in ascending order
 * @author smoli
 */
@SuppressWarnings("serial")
public class SortAscendingAction extends FocusOwnerAction {

    @Override
    protected String getName() {
        return "Sort selection ascending";
    }

    @Override
    protected void defineProperties() {
        setEnabled(true);
        putValue(SMALL_ICON, new ImageIcon(CleanSheets.class.getResource("res/img/sort.gif")));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CellRangeSort sorter = new CellRangeSort(focusOwner.getSelectedCells(), SortOption.ASCENDING);

        sorter.sort();
    }

}
