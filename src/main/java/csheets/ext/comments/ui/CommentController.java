package csheets.ext.comments.ui;

import csheets.ext.comments.CommentableCell;
import csheets.ext.style.StylableCell;
import csheets.ui.ctrl.UIController;

/**
 * A controller for updating the user-specified comment of a cell.
 * @author Alexandre Braganca
 * @author Einar Pehrson
 */
public class CommentController {

	/** The user interface controller */
	private UIController uiController;
        
        /** User interface panel **/
        private CommentPanel uiPanel;
        
	/**
	 * Creates a new comment controller.
	 * @param uiController the user interface controller
         * @param uiPanel the user interface panel
	 */
	public CommentController(UIController uiController, CommentPanel uiPanel) {
		this.uiController = uiController;
                this.uiPanel = uiPanel;
	}

	/**
	 * Attempts to create a new comment from the given string.
	 * If successful, adds the comment to the given cell.
	 * If the input string is empty or null, the comment is set to null.
	 * @param cell the cell for which the comment should be set
	 * @param comment the comment, as entered by the user
         * @param scell
	 * @return true if the cell's comment was changed
	 */
	public boolean setComment(CommentableCell cell, String comment, StylableCell scell) {
		// Clears comment, if insufficient input
		/*if (comment == null || comment.equals("")) {
			cell.setUserComment(comment, scell.getFont(), scell.getFormat());
			return true;
		}*/

		// Stores the comment
                cell.setUserComment(comment, scell.getFont(), scell.getFormat());
		uiController.setWorkbookModified(cell.getSpreadsheet().getWorkbook());

		return true;
	}
        
        /**
	 * A cell is selected. If the selected cell has comments, they will be displayed 
         * at the box of all comments.
	 * @param cell the cell whose comments changed
	 */
	public void cellSelected(CommentableCell cell) {
            // Updates the text field of all comments and validates the comment, if any
            uiPanel.setCommentText(cell.getUserComment());
	}
}
