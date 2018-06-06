/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ipc.findworkbooks.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.OpenWorkbookAction;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

import javax.swing.*;

/**
 *
 * @author 1950689 Nuno Mota
 */
public class UIExtensionFindWorkbooks extends UIExtension {

    private JComponent sideBar;
    private OpenWorkbookAction action;

    /**
     * Creates a new find workbooks extension
     *
     * @param extension
     * @param uiController
     */
    public UIExtensionFindWorkbooks(Extension extension, UIController uiController)
    {
        super(extension, uiController);
    }

    public void setAction(OpenWorkbookAction openAction)
    {
        this.action = openAction;
        FindWorkbooksPanel findPanel = (FindWorkbooksPanel) this.sideBar;
        findPanel.setOpenAction(openAction);
        if(findPanel.numberOfSearchPanels()==0)
            findPanel.addNewSearchTab();
    }

    public OpenWorkbookAction getAction()
    {
        return this.action;
    }

    /**
     * Get the side bar
     *
     * @return the side bar
     */
    @Override
    public JComponent getSideBar()
    {
        if (sideBar == null)
        {
            sideBar = new FindWorkbooksPanel(this.action);
        }
        return sideBar;
    }
}
