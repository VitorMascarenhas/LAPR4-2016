/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ipc.findworkbooks.ui;

import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;

import java.awt.event.ActionEvent;
import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * @author 1950689 Nuno Mota
 */
public class FindWorkbooksController extends FocusOwnerAction implements Observer
{

    private FindWorkbooksSearchPanel uiPanel;
    private FindWorkbooks findWorkbooks;


    FindWorkbooksController(FindWorkbooksSearchPanel aThis)
    {
        this.uiPanel = aThis;
    }

    public void findWorkbooks(Path root, String pattern)
    {
        this.findWorkbooks = new FindWorkbooks(root, pattern);
        this.findWorkbooks.addObserver(this);
        Thread thread = new Thread(this.findWorkbooks);
        thread.start();
    }

    @Override
    public void update(Observable o, Object arg)
    {
        if(o != null){
            FindWorkbooks finder = (FindWorkbooks) o;
            List<File> resultList = finder.getWorkbookFiles();
            if(resultList != null && resultList.size() > 0)
                this.uiPanel.addFilesToList(resultList);
            this.uiPanel.revalidate();
            this.uiPanel.repaint();
        }

        this.uiPanel.refresh();
    }

    @Override
    protected String getName()
    {
        return "FindWorkbooks";
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }

}
