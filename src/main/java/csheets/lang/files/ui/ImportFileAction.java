/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.lang.files.ui;

import csheets.CleanSheets;
import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import javax.swing.JDialog;

/**
 *
 * @author Sara Ramos
 */
@SuppressWarnings("serial")
public class ImportFileAction extends BaseAction
{
    private CleanSheets app;
    private UIController uiController;
    private JDialog jDialog;
    private ImportFilePanel panel;

    
    public ImportFileAction(CleanSheets app, UIController uiController)
    {
        this.app = app;
        this.uiController = uiController;
    }
            
            
    
    
    @Override
    protected String getName()
    {
        return "Import from file";
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        jDialog = new JDialog();
        this.panel = new ImportFilePanel(uiController, jDialog);
        jDialog.add(panel);
        jDialog.pack();
        jDialog.setVisible(true); 
        jDialog.setLocationRelativeTo(null);
    
    }
}
