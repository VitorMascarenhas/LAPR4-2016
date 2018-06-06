/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.images;

import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import static org.junit.Assert.assertTrue;
import org.junit.Ignore;
import org.junit.Test;
//import static sun.invoke.util.ValueConversions.ignore;

/**
 *
 * @author Miguel Ferrão
 */
public class ImageableCellTest {
    	private boolean isNotified=false;

	/**
	 * A method that tests the property hasComment.
	 */
	@Test 
        @Ignore
        public void testHasImage() {
		
		// create a workbook with 2 sheets
		Workbook wb=new Workbook(2);
		Spreadsheet s=wb.getSpreadsheet(0);
		// get the first cell
		Cell c=s.getCell(0,0);
		
		// activate the comments on the first cell
		ImageableCell cc=new ImageableCell(c);

		boolean hasImage=cc.hasImage();
		
		assertTrue(hasImage==false);		
		
		cc.setImage("user.jpg");

		hasImage = cc.hasImage();
		
		assertTrue(hasImage);		
	}

	/**
	 * A method that tests the setter and getter of the user comment.
	 */
	@Test public void testSetGetImage() {
		
		// create a workbook with 2 sheets
		Workbook wb=new Workbook(2);
		Spreadsheet s=wb.getSpreadsheet(0);
		// get the first cell
		Cell c=s.getCell(0,0);
		
		// activate the comments on the first cell
		ImageableCell cc = new ImageableCell(c);

		cc.setImage("user.jpg");
		
		assertTrue("user.jpg".compareTo(cc.returnAllImages().get(0))==0);		
	}
	
	/**
	 * A method that tests the notifications for commented cell listeners.
	 * @see CommentableCellListener
	 */	
	@Test public void testImageableCellListener() {
		
		// create a workbook with 2 sheets
		Workbook wb=new Workbook(2);
		Spreadsheet s=wb.getSpreadsheet(0);
		// get the first cell
		Cell c=s.getCell(0,0);
		
		// activate the comments on the first cell
		ImageableCell cc=new ImageableCell(c);
		
		ImageableCellListener listener = new ImageableCellListenerImpl();
		
		cc.addImageableCellListener(listener);

		// modify the cell... this should create an event
		cc.setImage("user.jpg");
		
		assertTrue(isNotified);		
	}

	/**
	 * A inner utility class used by the method testCommentableCellListenner.
	 */	
	class ImageableCellListenerImpl implements ImageableCellListener {

		@Override
		public void imagesChanged(ImageableCell cell) {
			isNotified=true;
		}
		
	}
}
