package csheets.ext.agenda.ui;

import csheets.ext.agenda.domain.EventsState;
import csheets.ext.agenda.domain.IEvent;
import csheets.persistence.AggregateRoot;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * A Table model used to show and edit contacts.
 * @author Pedro Costa.
 */
public class EventsTableModel extends AbstractTableModel {

    private static final String[] COLUMNS = {"Due date", "description", "State"};
    private final String[][] data;
    private List<IEvent> events;

    /**
     * Make the table model using a list of contacts.
     */
    public EventsTableModel(List<IEvent> events)
    {
        this.events = events;
        this.data = new String[events.size()][COLUMNS.length+1];
        int i=0;

        for(IEvent c: events)
        {
            this.data[i][0] = c.dueDate().toString();
            this.data[i][1] = c.description();
            this.data[i][2] = EventsState.eventStateFromTimeStamp(c.dueDate()).toString();
            this.data[i][3] = ((AggregateRoot) c).id().toString();
            i++;
        }
    }

    /**
     * Retrieve columns number.
     *
     * @return int
     */
    @Override
    public int getColumnCount() {
        return COLUMNS.length;
    }

    /**
     * Retrieve rows number.
     *
     * @return int
     */
    @Override
    public int getRowCount() {
        return data.length;
    }

    /**
     * Get the column number
     *
     * @param col int of the column position
     *
     * @return String
     */
    @Override
    public String getColumnName(int col) {
        return COLUMNS[col];
    }

    /**
     * Get the value at certain position of the table.
     *
     * @param row int of row
     * @param col int of column
     *
     * @return object at position received
     */
    @Override
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    /**
     * Get the class of the column indicated.
     *
     * @param c int of the column
     *
     * @return Class String
     */
    @Override
    public Class getColumnClass(int c)
    {
        return String.class;
    }

    /**
     * Controls the editable cells.
     *
     * @param row int of row number
     * @param col int of column number
     *
     * @return boolean true if editable, false otherwise.
     */
    @Override
    public boolean isCellEditable(int row, int col)
    {
        return false;
    }

    /*
     * Update a value of table cell.
     */
    @Override
    public void setValueAt(Object value, int row, int col)
    {
        data[row][col] = (String)value;
        fireTableCellUpdated(row, col);
    }

    /**
     * Get the event id according the row number received.
     *
     * @param row int of the row
     *
     * @return Long of the id
     */
    public Long getSelectedEventId(int row)
    {
        return Long.parseLong(data[row][3]);
    }

    /**
     * Get the event id according the row number received.
     *
     * @param row int of the row
     *
     * @return Event associated with the received row
     */
    public IEvent getSelectedEvent(int row)
    {
        return this.events.get(row);
    }

}


