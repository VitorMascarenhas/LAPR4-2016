/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.images.ui;

import csheets.core.Cell;
import csheets.ext.images.ImageableCell;
import csheets.ext.images.ImagesExtension;
import csheets.ui.ext.CellDecorator;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import static javafx.scene.text.Font.font;
import javax.swing.JComponent;

/**
 *
 * @author Eduardo Silva
 */
public class ImagedCellDecorator extends CellDecorator {

    private static final Font font = new Font("Dialog", Font.PLAIN, 10);
    
    @Override
    public void decorate(JComponent component, Graphics g, Cell cell, boolean selected, boolean hasFocus) {
        		if (enabled) {
			ImageableCell imageableCell = (ImageableCell)cell.getExtension(ImagesExtension.NAME);
			
                        if (imageableCell.hasImage()) 
			{
				// Stores current graphics context properties
				Graphics2D g2 = (Graphics2D)g;
				Color oldPaint = g2.getColor();
				Font oldFont = g2.getFont();

				// Prints 'A' using own font, then restores the old font
				g2.setColor(Color.red);
				g2.setFont(font);
				g2.drawString("+", 4, 12);

				// Restores graphics context properties
				g2.setColor(oldPaint);
				g2.setFont(oldFont);
			}
		}

    }
    
}
