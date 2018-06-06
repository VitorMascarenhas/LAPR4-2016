package csheets.ui.ctrl;

import csheets.core.Cell;
import csheets.core.Value;
import csheets.ui.enums.SortOption;

import java.util.Comparator;

/**
 * Created by berme on 6/9/2016.
 */
public class SortOptionComparator implements Comparator<Cell> {
    private SortOption option;

    public SortOptionComparator(SortOption option) {
        this.option = option;
    }

    @Override
    public int compare(Cell cell, Cell otherCell) {
        Value cellValue = cell.getValue();
        Value otherCellValue = otherCell.getValue();

        boolean cellNumber = cellValue.isOfType(Value.Type.NUMERIC);
        boolean otherCellNumber = otherCellValue.isOfType(Value.Type.NUMERIC);

        boolean cellDate = cellValue.isOfType(Value.Type.DATE);
        boolean otherCellDate = otherCellValue.isOfType(Value.Type.DATE);

        switch (option) {
            case ASCENDING:
                if (cellNumber) {
                    if (!otherCellNumber) {
                        return -1;
                    }

                    return cellValue.compareTo(otherCellValue);
                } else {
                    if (otherCellNumber) {
                        return 1;
                    }
                }

                if (cellDate) {
                    if (!otherCellDate) {
                        return -1;
                    }
                    return cellValue.compareTo(otherCellValue);
                } else {
                    if (otherCellDate) {
                        return -1;
                    }
                }

                return cellValue.compareTo(otherCellValue);

            case DESCENDING:
                if (cellNumber) {
                    if (!otherCellNumber) {
                        return -1;
                    }

                    return otherCellValue.compareTo(cellValue);
                } else {
                    if (otherCellNumber) {
                        return 1;
                    }
                }

                if (cellDate) {
                    if (!otherCellDate) {
                        return 1;
                    }

                    return otherCellValue.compareTo(cellValue);
                } else {
                    if (otherCellDate) {
                        return -1;
                    }
                }

                return otherCellValue.compareTo(cellValue);

            default:
                return 0;
        }
    }
}
