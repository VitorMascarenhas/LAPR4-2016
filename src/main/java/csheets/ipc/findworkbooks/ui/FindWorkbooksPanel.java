/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ipc.findworkbooks.ui;

import csheets.ui.ctrl.OpenWorkbookAction;
import csheets.ui.ctrl.UIController;

import java.awt.*;
import javax.swing.JPanel;
import javax.swing.*;

/**
 * @author 1950689 Nuno Mota and 1140806 Pedro Costa
 */
public class FindWorkbooksPanel extends JPanel
{

    private JTabbedPane tabPanel;
    private JButton newSearchButton;
    private static int searchPanelsCount =0;
    private OpenWorkbookAction openAction;

    /**
     * Creates new form FindWorkbooksPanel.
     *
     * @param action Action to open workbook
     */
    FindWorkbooksPanel(OpenWorkbookAction action)
    {
        this.openAction = action;
        setName(FindWorkbooksExtension.NAME);
        createNewSearchButton(action);
        createTabPanel();
        createLayout(action);
    }

    private void createLayout(OpenWorkbookAction action)
    {
        this.initComponents(action);

        //Create panel to make layout
        this.setLayout(new BorderLayout());

        //Add new Search Button
        this.add(this.newSearchButton, BorderLayout.NORTH);

        //Add tab panel
        this.add(this.tabPanel, BorderLayout.CENTER);

    }

    private void createTabPanel()
    {
        this.tabPanel = new JTabbedPane();
    }

    private void createNewSearchButton(OpenWorkbookAction action)
    {
        this.newSearchButton = new JButton("New search");
        this.newSearchButton.addActionListener(e -> FindWorkbooksPanel.this.addNewSearchTab());
        this.openAction = action;
    }

    private void initComponents(OpenWorkbookAction action)
    {
        createNewSearchButton(action);
        createTabPanel();
    }

    /**
     * Add a new tab to Find WorkBooks Extension Panel to let user make another search.
     */
    public void addNewSearchTab()
    {
        this.searchPanelsCount++;
        this.tabPanel.add("Search " + this.searchPanelsCount, new FindWorkbooksSearchPanel(this.openAction));
    }

    /**
     * Set an action to open workbook from extension.
     *
     * @param action Action responsible to open workbook.
     */
    public void setOpenAction(OpenWorkbookAction action)
    {
        this.openAction = action;
    }

    /**
     * Return the number of search panels in extension.
     *
     * @return int with the number of search panels.
     */
    public int numberOfSearchPanels()
    {
        return this.searchPanelsCount;
    }
}