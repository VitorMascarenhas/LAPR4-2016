/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.searcheditcomments;

import csheets.ext.comments.Comment;
import csheets.ext.comments.CommentableCell;
import csheets.ext.comments.CommentsExtension;
import csheets.ui.ctrl.UIController;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author VitorMascarenhas1120035
 */
public class SearchCommentsController {
    
    private UIController uiController;
    
    /**
     * 
     * @param uiController
     * @param searchEditCommentPanel 
     */
    public SearchCommentsController(UIController uiController) {
        this.uiController = uiController;
    }
    
    public DefaultListModel searchForExpression(String text) {
        CommentableCell cell = (CommentableCell)uiController.getActiveCell().getExtension(CommentsExtension.NAME);
        
        DefaultListModel dlm = new DefaultListModel();
        
        if(cell.returnAllComments() == null) {
            JOptionPane.showMessageDialog(null, "This cell don't hava comments!");
        } else {
            int length = cell.returnAllComments().size();
            for(int i = 0; i < length; i++) {
                if(cell.returnAllComments().get(i).returnComment().contains(text)) {
                    dlm.addElement(cell.returnAllComments().get(i));
                }
            }
        }
        return dlm;
    }
}
