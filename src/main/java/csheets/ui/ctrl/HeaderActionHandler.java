package csheets.ui.ctrl;

import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.ui.FileChooser;
import csheets.ui.enums.SortOption;
import csheets.ui.sheet.SpreadsheetTable;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by berme on 6/7/2016.
 */
public class HeaderActionHandler extends MouseAdapter {
    private SpreadsheetTable table;

    private static int STARTING_ROW = 0;

    public HeaderActionHandler(SpreadsheetTable sheetTable) {
        this.table = sheetTable;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 2) {
            int index = this.table.getTableHeader().columnAtPoint(e.getPoint());
            table.changeSelection(STARTING_ROW, index, false, false);
            table.changeSelection(table.getRowCount(), index, false, true);
        }
    }
}
