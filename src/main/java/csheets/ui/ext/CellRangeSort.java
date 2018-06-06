/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ui.ext;

import csheets.core.*;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.SortOptionComparator;
import csheets.ui.enums.SortOption;
import java.util.*;

/**
 * A sorting algorithm to sort a range of cells
 *
 * @author smoli
 */
public class CellRangeSort {

    private final Cell[][] selectedCells;
    private final SortOption sortDirection;

    public CellRangeSort(Cell[][] selectedCells, SortOption sortDirection) {
        this.sortDirection = sortDirection;
        this.selectedCells = selectedCells;

    }

    /**
     * Sorts a range of cells
     *
     * From SortAction implemented by 1140809
     */
    public void sort() {
        List<Cell> column;
        Map<Cell, String> contents;

        for (int k = 0; k < selectedCells[0].length; k++) {
            column = new ArrayList<>();
            contents = new HashMap<>();

            for (int i = 0; i < selectedCells.length; i++) {
                if (selectedCells[i][k].getContent() != null && !selectedCells[i][k].getContent().isEmpty()) {
                    column.add(selectedCells[i][k]);
                    contents.put(selectedCells[i][k], new String(selectedCells[i][k].getContent()));
                }
            }

            int size = column.size();
            Cell[] arrayToSort = new Cell[size];
            arrayToSort = column.toArray(arrayToSort);
            Arrays.parallelSort(arrayToSort, new SortOptionComparator(sortDirection));

            int n;
            for (n = 0; n < size; n++) {
                try {
                    selectedCells[n][k].setContent(contents.get(arrayToSort[n]));
                } catch (FormulaCompilationException e) {
                    e.printStackTrace();
                }
            }

            for (; n < selectedCells.length; n++) {
                try {
                    selectedCells[n][k].setContent("");
                    selectedCells[n][k].clear();
                } catch (FormulaCompilationException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * *
     * Sorts a range of cells based on a column
     *
     * @param columnIndex the column index
     * @return The sorted values of the selected cells
     */
    public Value[][] sort(int columnIndex) {
        Value[][] values = new Value[selectedCells.length][selectedCells[0].length];

        for (int i = 0; i < selectedCells.length; i++) {
            for (int j = 0; j < selectedCells[i].length; j++) {
                values[i][j] = new Value(selectedCells[i][j].getContent());
            }
        }

        Arrays.sort(values, new Comparator<Value[]>() {
            @Override
            public int compare(Value[] o1, Value[] o2) {

                if (sortDirection == SortOption.ASCENDING) {
                    return o1[columnIndex].compareTo(o2[columnIndex]);
                } else {
                    return o2[columnIndex].compareTo(o1[columnIndex]);
                }

            }
        });

        return values;
    }
}
