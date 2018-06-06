/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.lang.files.ui;

import csheets.CleanSheets;
import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.OpenAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author VitorMascarenhas1120035
 */
@SuppressWarnings("serial")
public class ExportFileAction extends BaseAction {

    /**
     * The CleanSheets application
     */
    private CleanSheets app;
    
    private ExportFilePanel efp;
    
    /**
     * The user interface controller
     */
    private UIController uiController;
    private JDialog jDialog;
    
    /**
     * Creates a reopen menu, and creates items using the given properties (if
     * available).
     *
     * @param app the CleanSheets application
     * @param uiController the user interface controller
     */
    public ExportFileAction(CleanSheets app, UIController uiController) {
//        super("Export");

        // Stores members
        this.app = app;
        this.uiController = uiController;

        //setMnemonic(KeyEvent.VK_R);
        //setIcon(new ImageIcon(CleanSheets.class.getResource("res/img/reopen.gif")));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        jDialog = new JDialog();
        ExportFilePanel efp = new ExportFilePanel(uiController, jDialog);
        jDialog.add(efp);
        jDialog.pack();
        jDialog.setVisible(true);
    }

    @Override
    protected String getName() {
        return "Export";
    }
}