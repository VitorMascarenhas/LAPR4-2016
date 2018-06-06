package csheets.ext.comments;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import csheets.core.Cell;
import csheets.ext.CellExtension;
import java.awt.Font;
import java.text.Format;

/**
 * An extension of a cell in a spreadsheet, with support for comments.
 * @author Alexandre Braganca
 * @author Einar Pehrson
 */
public class CommentableCell extends CellExtension {

	/** The unique version identifier used for serialization */
	private static final long serialVersionUID = 1L;

	/** The cell's user-specified comment */
        //private String userComment;
        
        /** The list of Comments */
        private List<Comment> comments;
        
	/** The listeners registered to receive events from the comentable cell */
	private transient List<CommentableCellListener> listeners
		= new ArrayList<CommentableCellListener>();
        
	/**
	 * Creates a comentable cell extension for the given cell.
	 * @param cell the cell to extend
	 */
	CommentableCell(Cell cell) {
		super(cell, CommentsExtension.NAME);
                comments = new ArrayList<>();
	}


/*
 * DATA UPDATES
 */


//	public void contentChanged(Cell cell) {
//	}


/*
 * COMMENT ACCESSORS
 */

	/**
	 * Get the cell's user comment.
	 * @return The user supplied comment for the cell or <code>null</code> if no user
	 supplied comment exists.
	*/
	public String getUserComment() {
		String res = "";
                int size = 0;
                size = this.comments.size();
                for(int i = 0; i < size; i++) {
                    res+=this.comments.get(i).toString() + "\n";
                }
                return res;
        }
        
	/**
	 * Returns whether the cell has a comment.
	 * @return true if the cell has a comment
	 */
	public boolean hasComment() {
		return this.comments != null;
	}

/*
 * COMMENT MODIFIERS
 */

	/**
	 * Sets the user-specified comment for the cell.
	 * @param comment the user-specified comment
         * @param font
         * @param format
	 */
	public void setUserComment(String comment, Font font, Format format) {
		Comment c = new Comment(comment, font, format);
                c.setCommentId(this.maxId()+1);
                this.comments.add(c);
                // Notifies listeners
		fireCommentsChanged();
	}
        
        public void setEditUserComment(int id, String commentStr, Font font, Format format) {
            Comment comment = new Comment(id, commentStr, font, format);
            this.comments.add(comment);
            // Notifies listeners
            //fireCommentsChanged();
	}
        
        public int maxId() {
            int max = 0;
            for(Comment c : comments) {
                if(c.returnCommentId() > max) {
                    max = c.returnCommentId();
                }
            }
            return max;
        }
        
        public int commentSize() {
            return comments.size();
        }

/*
 * EVENT LISTENING SUPPORT
 */

	/**
	 * Registers the given listener on the cell.
	 * @param listener the listener to be added
	 */
	public void addCommentableCellListener(CommentableCellListener listener) {
		listeners.add(listener);
	}

	/**
	 * Removes the given listener from the cell.
	 * @param listener the listener to be removed
	 */
	public void removeCommentableCellListener(CommentableCellListener listener) {
		listeners.remove(listener);
	}

	/**
	 * Notifies all registered listeners that the cell's comments changed.
	 */
	protected void fireCommentsChanged() {
		for (CommentableCellListener listener : listeners)
			listener.commentChanged(this);
	}

	/**
	 * Customizes serialization, by recreating the listener list.
	 * @param stream the object input stream from which the object is to be read
	 * @throws IOException If any of the usual Input/Output related exceptions occur
	 * @throws ClassNotFoundException If the class of a serialized object cannot be found.
	 */
	private void readObject(java.io.ObjectInputStream stream)
			throws java.io.IOException, ClassNotFoundException {
	    stream.defaultReadObject();
		listeners = new ArrayList<CommentableCellListener>();
	}

    @Override
    public void styleChanged(Cell cell) {}
    
    public List<Comment> returnAllComments() {
        return this.comments;
    }
    
    
    public int returnNumberOfId(int id) {
        
        int number = 0;
        
        int length = this.comments.size();
        
        for(int i = 0; i < length; i++) {
            if(comments.get(i).returnCommentId() == id) {
                number++;
            }
        }
        return number;
    }
}
