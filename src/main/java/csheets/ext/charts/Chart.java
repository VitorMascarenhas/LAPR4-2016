package csheets.ext.charts;

import csheets.core.Cell;
import java.util.Arrays;

/**
 * A chart, with name and a cells range.
 *
 * @author 1120013@isep.ipp.pt
 */
public class Chart {

    private final String chartName;
    private final Cell[][] cellsRange;
    private final boolean lineLabel;
    private final boolean rowLabel;

    /**
     * Create chart.
     *
     * @param chartName chart name.
     * @param cellsRange cells to be included in the chart.
     * @param lineLabel tells if first line is a Label.
     * @param rowLabel tells if first row is a Label.
     */
    public Chart(String chartName, Cell[][] cellsRange, boolean lineLabel, boolean rowLabel) {
        this.chartName = chartName;
        this.cellsRange = cellsRange;
        this.lineLabel = lineLabel;
        this.rowLabel = rowLabel;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + (this.chartName != null ? this.chartName.hashCode() : 0);
        hash = 13 * hash + Arrays.deepHashCode(this.cellsRange);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final Chart other = (Chart) obj;
        if ((this.chartName == null) ? (other.chartName != null) : !this.chartName.
                equals(other.chartName)) {
            return false;
        }
        if (!Arrays.deepEquals(this.cellsRange, other.cellsRange)) {
            return false;
        }
        
        if (this.lineLabel != other.lineLabel) {
            return false;
        } 
        
        if (this.rowLabel != other.rowLabel) {
            return false;
        } 
        
        return true;
    }

}
