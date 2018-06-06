/*
 * Copyright (c) 2005 Einar Pehrson <einar@pehrson.nu>.
 *
 * This file is part of
 * CleanSheets - a spreadsheet application for the Java platform.
 *
 * CleanSheets is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * CleanSheets is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CleanSheets; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package csheets.ui.ctrl;

import csheets.CleanSheets;
import csheets.core.Cell;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.enums.SortOption;
import csheets.ui.ext.CellRangeSort;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.*;

/**
 * A sorting operation.
 *
 * @author Einar Pehrson
 */
@SuppressWarnings("serial")
public class SortAction extends FocusOwnerAction {

    /**
     * Creates a new sorting action.
     */
    public SortAction() {
    }

    @Override
    protected String getName() {
        return "Sort...";
    }

    protected void defineProperties() {
        setEnabled(false);
        putValue(SMALL_ICON, new ImageIcon(CleanSheets.class.getResource("res/img/sort.gif")));
    }

    /**
     * Lets the user choose the criteria for sorting.
     *
     * @param event the event that was fired
     */
    public void actionPerformed(ActionEvent event) {
        if (focusOwner == null) {
            return;
        }

        SortOption option = showSortingOptions();

        Cell[][] selectedCells = this.focusOwner.getSelectedCells();
        
        CellRangeSort sorter = new CellRangeSort(selectedCells, option);
        sorter.sort();

        /*********/
        /*moved to CellRangeSort */
//        List<Cell> column;
//        Map<Cell, String> contents;
//
//        for (int k = 0; k < selectedCells[0].length; k++) {
//            column = new ArrayList<>();
//            contents = new HashMap<>();
//
//            for (int i = 0; i < selectedCells.length; i++) {
//                if (selectedCells[i][k].getContent() != null && !selectedCells[i][k].getContent().isEmpty()) {
//                    column.add(selectedCells[i][k]);
//                    contents.put(selectedCells[i][k], new String(selectedCells[i][k].getContent()));
//                }
//            }
//
//            int size = column.size();
//            Cell[] arrayToSort = new Cell[size];
//            arrayToSort = column.toArray(arrayToSort);
//            Arrays.parallelSort(arrayToSort, new SortOptionComparator(option));
//
//            int n;
//            for (n = 0; n < size; n++) {
//                try {
//                    selectedCells[n][k].setContent(contents.get(arrayToSort[n]));
//                } catch (FormulaCompilationException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            for (; n < selectedCells.length; n++) {
//                try {
//                    selectedCells[n][k].setContent("");
//                    selectedCells[n][k].clear();
//                } catch (FormulaCompilationException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }

    private SortOption showSortingOptions() {
        String[] options = new String[]{SortOption.ASCENDING.description(), SortOption.DESCENDING.description()};
        int response = JOptionPane.showOptionDialog(null, "Message", "Title",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[0]);

        switch (response) {
            case 0:
                return SortOption.ASCENDING;
            case 1:
                return SortOption.DESCENDING;
            default:
                return null;
        }
    }
}
