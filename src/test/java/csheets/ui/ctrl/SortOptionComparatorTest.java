package csheets.ui.ctrl;

import csheets.core.Cell;
import csheets.core.Value;
import csheets.ui.enums.SortOption;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by berme on 6/13/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class SortOptionComparatorTest {
    @InjectMocks
    private SortOptionComparator instanceAsc = new SortOptionComparator(SortOption.ASCENDING);
    @InjectMocks
    private SortOptionComparator instanceDes = new SortOptionComparator(SortOption.DESCENDING);

    @Mock
    private Cell cell;

    @Mock
    private Cell otherCell;

    @Test
    public void compareNumbersAsc() throws Exception {
        when(cell.getValue()).thenReturn(new Value(new Double(2.5)));
        when(otherCell.getValue()).thenReturn(new Value(new Double(2.7)));

        assertTrue(this.instanceAsc.compare(cell, otherCell) == -1);
    }

    @Test
    public void compareStringsAsc() throws Exception {
        when(cell.getValue()).thenReturn(new Value(new String("A")));
        when(otherCell.getValue()).thenReturn(new Value(new String("B")));

        assertTrue(this.instanceAsc.compare(cell, otherCell) == -1);
    }

    @Test
    public void compareDatesAsc() throws Exception {
        Calendar calendar = Calendar.getInstance();

        calendar.set(2016, 01, 01);
        when(cell.getValue()).thenReturn(new Value(new Date(calendar.getTimeInMillis())));

        calendar.set(2016, 01, 02);
        when(otherCell.getValue()).thenReturn(new Value(new Date(calendar.getTimeInMillis())));

        assertTrue(this.instanceAsc.compare(cell, otherCell) == -1);
    }

    @Test
    public void compareNumberStringAsc() throws Exception {
        when(cell.getValue()).thenReturn(new Value(new Double(2.5)));
        when(otherCell.getValue()).thenReturn(new Value(new String("A")));

        assertTrue(this.instanceAsc.compare(cell, otherCell) == -1);
    }

    @Test
    public void compareNumberDateAsc() throws Exception {
        when(cell.getValue()).thenReturn(new Value(new Double(2.7)));

        Calendar calendar = Calendar.getInstance();

        calendar.set(2016, 01, 01);
        when(otherCell.getValue()).thenReturn(new Value(new Date(calendar.getTimeInMillis())));

        assertTrue(this.instanceAsc.compare(cell, otherCell) == -1);
    }

    @Test
    public void compareStringDateAsc() throws Exception {
        when(cell.getValue()).thenReturn(new Value(new String("A")));

        Calendar calendar = Calendar.getInstance();

        calendar.set(2016, 01, 01);
        when(otherCell.getValue()).thenReturn(new Value(new Date(calendar.getTimeInMillis())));

        assertTrue(this.instanceAsc.compare(cell, otherCell) == -1);
    }

    @Test
    public void compareNumbersDesc() throws Exception {
        when(cell.getValue()).thenReturn(new Value(new Double(2.5)));
        when(otherCell.getValue()).thenReturn(new Value(new Double(2.7)));

        assertTrue(this.instanceDes.compare(cell, otherCell) == 1);
    }

    @Test
    public void compareStringsDesc() throws Exception {
        when(cell.getValue()).thenReturn(new Value(new String("A")));
        when(otherCell.getValue()).thenReturn(new Value(new String("B")));

        assertTrue(this.instanceDes.compare(cell, otherCell) == 1);
    }

    @Test
    public void compareDatesDesc() throws Exception {
        Calendar calendar = Calendar.getInstance();

        calendar.set(2016, 01, 01);
        when(cell.getValue()).thenReturn(new Value(new Date(calendar.getTimeInMillis())));

        calendar.set(2016, 01, 02);
        when(otherCell.getValue()).thenReturn(new Value(new Date(calendar.getTimeInMillis())));

        assertTrue(this.instanceDes.compare(cell, otherCell) == 1);
    }

    @Test
    public void compareNumberStringDesc() throws Exception {
        when(cell.getValue()).thenReturn(new Value(new Double(2.5)));
        when(otherCell.getValue()).thenReturn(new Value(new String("A")));

        assertTrue(this.instanceDes.compare(cell, otherCell) == -1);
    }

    @Test
    public void compareNumberDateDesc() throws Exception {
        when(cell.getValue()).thenReturn(new Value(new Double(2.7)));

        Calendar calendar = Calendar.getInstance();

        calendar.set(2016, 01, 01);
        when(otherCell.getValue()).thenReturn(new Value(new Date(calendar.getTimeInMillis())));

        assertTrue(this.instanceDes.compare(cell, otherCell) == -1);
    }

    @Test
    public void compareStringDateDesc() throws Exception {
        when(cell.getValue()).thenReturn(new Value(new String("A")));

        Calendar calendar = Calendar.getInstance();

        calendar.set(2016, 01, 01);
        when(otherCell.getValue()).thenReturn(new Value(new Date(calendar.getTimeInMillis())));

        assertTrue(this.instanceDes.compare(cell, otherCell) == -1);
    }
}