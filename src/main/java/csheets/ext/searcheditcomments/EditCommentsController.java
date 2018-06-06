/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.searcheditcomments;

import csheets.ext.comments.Comment;
import csheets.ext.comments.CommentableCell;
import csheets.ext.comments.CommentsExtension;
import csheets.ext.style.StylableCell;
import csheets.ext.style.StyleExtension;
import csheets.ui.ctrl.UIController;
import javax.swing.DefaultListModel;
import javax.swing.text.Style;

/**
 *
 * @author VitorMascarenhas1120035
 */
public class EditCommentsController {
    
    private UIController uiController;
    
    public EditCommentsController(UIController uiController) {
        this.uiController = uiController;
    }
    
    public void editComment(String commentText) {
        
        StylableCell scell = (StylableCell) uiController.getActiveCell().getExtension(StyleExtension.NAME);
        CommentableCell cell = (CommentableCell) uiController.getActiveCell().getExtension(CommentsExtension.NAME);
        
        
        cell.setUserComment(commentText, scell.getFont(), scell.getFormat());
    }
}
