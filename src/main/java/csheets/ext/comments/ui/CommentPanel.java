package csheets.ext.comments.ui;

/*
 * Copyright (c) 2013 Alexandre Braganca, Einar Pehrson
 *
 * This file is part of
 * CleanSheets Extension for Comments
 *
 * CleanSheets Extension for Assertions is free software; you can
 * redistribute it and/or modify it under the terms of the GNU General Public
 * License as published by the Free Software Foundation; either version 2 of
 * the License, or (at your option) any later version.
 *
 * CleanSheets Extension for Assertions is distributed in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CleanSheets Extension for Assertions; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA  02111-1307  USA
 */
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import csheets.core.Cell;
import csheets.ext.comments.Comment;
import csheets.ext.comments.CommentableCell;
import csheets.ext.comments.CommentableCellListener;
import csheets.ext.comments.CommentsExtension;
import csheets.ext.searcheditcomments.EditCommentsController;
import csheets.ext.searcheditcomments.SearchCommentsController;
import csheets.ext.searcheditcomments.SearchEditCommentPanel;
import csheets.ext.style.StylableCell;
import csheets.ext.style.StyleExtension;
import csheets.ui.ctrl.SelectionEvent;
import csheets.ui.ctrl.SelectionListener;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * A panel for adding or editing a comment for a cell
 *
 * @author Alexandre Braganca
 * @author Einar Pehrson
 */
@SuppressWarnings("serial")
public class CommentPanel extends JPanel implements SelectionListener,
        CommentableCellListener, ActionListener {

    /**
     * The assertion controller
     */
    private CommentController controller;

    private UIController uiController;

    /**
     * The commentable cell currently being displayed in the panel
     */
    private CommentableCell cell;

    /**
     * The text field in which the user comment for the selected cell is displayed.
     */
    private JTextArea commentField = new JTextArea();
    /**
     * The text field in which all comments of the selected cell are displayed.
     */
    private JTextArea allComments = new JTextArea();
    
    private JButton btnAdd;
    
    private JButton btnSE;

    private JDialog jDialog;

    /**
     * Creates a new comment panel.
     *
     * @param uiController the user interface controller
     */
    public CommentPanel(UIController uiController) {
        // Configures panel
        super(new BorderLayout());
        setName(CommentsExtension.NAME);

        // Creates controller
        controller = new CommentController(uiController, this);
        
        this.uiController = uiController;
        
        uiController.addSelectionListener(this);

        // Creates comment components
        ApplyAction applyAction = new ApplyAction();
        
        btnAdd = new JButton("Add");
         btnSE = new JButton("Search and edit");
         
         btnAdd.addActionListener(this);
         btnSE.addActionListener(this);
         
        commentField.setPreferredSize(new Dimension(120, 100));		// width, height
        commentField.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));		// width, height
        commentField.addFocusListener(applyAction);
        commentField.setAlignmentX(Component.CENTER_ALIGNMENT);

        allComments.setPreferredSize(new Dimension(120, 140));		// width, height
        allComments.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        allComments.setAlignmentX(Component.CENTER_ALIGNMENT);
        allComments.setEditable(false);

        // Lays out comment components - Panel of comment field
        JPanel commentPanel = new JPanel();
        commentPanel.setLayout(new BoxLayout(commentPanel, BoxLayout.PAGE_AXIS));
        commentPanel.setPreferredSize(new Dimension(130, 120));
        commentPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));		// width, height
        commentPanel.add(commentField);
        commentPanel.add(btnAdd);
        commentPanel.add(btnSE);
        
        // Adds borders to user comment box
        TitledBorder border = BorderFactory.createTitledBorder("Comment");
        border.setTitleJustification(TitledBorder.CENTER);
        commentPanel.setBorder(border);
        
        //Panel of all comments field
        JPanel allCommentsPanel = new JPanel();
        allCommentsPanel.setLayout(new BoxLayout(allCommentsPanel, BoxLayout.PAGE_AXIS));
        allCommentsPanel.setPreferredSize(new Dimension(130, 150));
        allCommentsPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));		// width, height
        allCommentsPanel.add(allComments);
        
        // Adds borders to all comments box
        TitledBorder allCommentsBorder = BorderFactory.createTitledBorder("All Comments");
        allCommentsBorder.setTitleJustification(TitledBorder.CENTER);
        allCommentsPanel.setBorder(allCommentsBorder);

        // Adds panels
        JPanel northPanel = new JPanel(new BorderLayout());
        northPanel.add(commentPanel, BorderLayout.NORTH);
        northPanel.add(allCommentsPanel, BorderLayout.SOUTH);
        add(northPanel, BorderLayout.NORTH);
    }

    /**
     * Creates a comment panel for testing purpose.
     */
    CommentPanel() {
    }

    /**
     * Updates the comments field
     *
     * @param event the selection event that was fired
     */
    @Override
    public void selectionChanged(SelectionEvent event) {
        Cell cell = event.getCell();
        if (cell != null) {
            CommentableCell activeCell
                    = (CommentableCell) cell.getExtension(CommentsExtension.NAME);
            activeCell.addCommentableCellListener(this);

            commentChanged(activeCell);
        } else {
            commentField.setText("");
        }

        // Stops listening to previous active cell
        if (event.getPreviousCell() != null) {
            ((CommentableCell) event.getPreviousCell().getExtension(CommentsExtension.NAME))
                    .removeCommentableCellListener(this);
        }
    }
    
    /**
     * Updates the comment field when the comments of the active cell is
     * changed.
     *
     * @param cell the cell whose comments changed
     */
    @Override
    public void commentChanged(CommentableCell cell) {
        // Stores the cell for use when applying comments
        this.cell = cell;

        // The controller must decide what to do...
        controller.cellSelected(cell);
    }

    /**
     * Changes all comments displayed of selected cell
     *
     * @param text
     */
    public void setCommentText(String text) {
        if (cell.hasComment()) {
            allComments.setText(text);
        } else {
            allComments.setText(null);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSE) {
            SearchCommentsController scc = new SearchCommentsController(uiController);
            EditCommentsController ecc = new EditCommentsController(uiController);
            jDialog = new JDialog();
            SearchEditCommentPanel sep = new SearchEditCommentPanel(uiController, jDialog);
            jDialog.add(sep);
            jDialog.pack();
            jDialog.setVisible(true);
        }
        if(e.getSource() == btnAdd) {
            StylableCell sc = (StylableCell)uiController.getActiveCell().getExtension(StyleExtension.NAME);
            CommentableCell cc = (CommentableCell)uiController.getActiveCell().getExtension(CommentsExtension.NAME);
            boolean bool = false;
            if(commentField.getText() != null) {
                bool = controller.setComment(cc, commentField.getText(), sc);
                commentField.setText("");
            }
                        
            System.out.println("tamanho" + cc.commentSize());
            
            //List<Comment> list = cell.returnAllComments();
            
            if(!bool) {
                JOptionPane.showMessageDialog(null, "The comment does not inserted!");
            }
        }
    }
    
    protected class ApplyAction implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
            // TODO Auto-generated method stub

        }

        /**
         * Implements action when a cell is no longer selected. If the user
         * wrote a comment, then it will be concatenated with his/ her name to
         * all the existing comments of that cell. The comment field is cleaned
         * up.
         *
         * @param e
         */
        @Override
        public void focusLost(FocusEvent e) {
            // TODO Auto-generated method stub
        /*    if (cell.returnAllComments() != null) {
                StringBuilder str = new StringBuilder();
                for (Comment c : cell.returnAllComments()) {
                    str.append(c.returnComment()).append("\n");
                    System.out.println("" + str);
                }

                StylableCell scell = (StylableCell) uiController.getActiveCell().getExtension(StyleExtension.NAME);

                //str.append("@").append(System.getProperty("user.name")).append(": "). append(commentField.getText());
                controller.setComment(cell, str.toString(), scell);
                commentField.setText(null);
            }*/
        }
    }
}
