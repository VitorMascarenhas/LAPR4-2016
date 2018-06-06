package csheets.ext.charts.ui;

import csheets.core.Cell;
import csheets.ext.charts.ChartableCell;
import csheets.ext.charts.ChartsExtension;
import csheets.ui.ext.CellDecorator;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 * A decorator for charted cells.
 *
 * @author 1120013@isep.ipp.pt
 */
public class ChartedCellDecorator extends CellDecorator {

	/**
	 * The font used to render the '©'
	 */
	private static final Font font = new Font("Dialog", Font.PLAIN, 10);

	/**
	 * Creates a new cell decorator.
	 */
	public ChartedCellDecorator() {
	}

	/**
	 * Decorates the given graphics context if the cell being rendered has a
	 * chart.
	 *
	 * @param component the cell renderer component
	 * @param g the graphics context on which drawing should be done
	 * @param cell the cell being rendered
	 * @param selected whether the cell is selected
	 * @param hasFocus whether the cell has focus
	 */
	@Override
	public void decorate(JComponent component, Graphics g, Cell cell,
						 boolean selected, boolean hasFocus) {
		if (enabled) {
			ChartableCell chartableCell = (ChartableCell) cell.
				getExtension(ChartsExtension.NAME);
			if (chartableCell.hasChart()) {
				// Stores current graphics context properties
				Graphics2D g2 = (Graphics2D) g;
				Color oldPaint = g2.getColor();
				Font oldFont = g2.getFont();

				// Prints 'A' using own font, then restores the old font
				g2.setColor(Color.blue);
				g2.setFont(font);
				g2.drawString("©", 4, 12);

				// Restores graphics context properties
				g2.setColor(oldPaint);
				g2.setFont(oldFont);
			}
		}
	}
}
