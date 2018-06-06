/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ui.sheet;

import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import csheets.ext.comments.CommentableCell;
import csheets.ext.comments.CommentableCellListener;
import csheets.ext.comments.CommentsExtension;
import javax.swing.JLabel;
import javax.swing.JTable;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sara Ramos
 */
public class CellRendererTest
{
    private boolean isNotified;
    

    /**
     * Test of getTableCellRendererComponent method, of class CellRenderer.
     * Tests the tooltip at a cell
     */
/*    @Test
    public void testGetTableCellRendererComponent()
    {
        System.out.println("getTableCellRendererComponent");
        // create a workbook with 2 sheets
        Workbook workbook=new Workbook(2);
        Spreadsheet spreadsheet=workbook.getSpreadsheet(0);
   
        // get the first cell
        Cell cell=spreadsheet.getCell(0,0);
        
        // activate the comments on the first cell
        CommentsExtension extension= new CommentsExtension();
        CommentableCell commentableCell=extension.extend(cell);

        CommentableCellListener listener=new CellRendererTest.CommentableCellListenerImpl();
		
        commentableCell.addCommentableCellListener(listener);
        commentableCell.setUserComment("comentário \n com mudança de linha");
          
        JTable table = new JTable();
        JLabel label = new JLabel();
        table.add(label);
        boolean selected = true;
        boolean hasFocus = true;
        int row = 0;
        int column = 0;
        CellRenderer instance = new CellRenderer();
        String expResult = "<html>comentário <br> com mudança de linha</html>";

        JLabel component = (JLabel)instance.getTableCellRendererComponent(table, commentableCell, selected, hasFocus, row, column);
        String result = component.getToolTipText();
        assertEquals(expResult, result);
    
    }*/
    /**
	 * A inner utility class used by the method getTableCellRendererComponent.
	 */	
	class CommentableCellListenerImpl implements CommentableCellListener {

		@Override
		public void commentChanged(CommentableCell cell) {
			isNotified=true;
		}
		
	}

    
    
}
