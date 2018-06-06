/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ui.ctrl;

import csheets.CleanSheets;
import csheets.core.Address;
import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import csheets.io.WorkbookLoader;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 1950689 Nuno Mota
 */
public class OpenWorkbookAction extends BaseAction {

    /**
     * The CleanSheets application
     */
    private CleanSheets app;
    private UIController uiController;
    public File file;
    public Workbook workbook;

    private Map<File, String> previewMap;

    /**
     * Creates a open workbook action.
     *
     * @param app          the CleanSheets application
     * @param uiController
     */
    public OpenWorkbookAction(CleanSheets app, UIController uiController)
    {
        // Stores members
        this.app = app;
        this.uiController = uiController;
        this.previewMap = new HashMap<>();
    }

    protected String getName()
    {
        return "OpenWorkbookAction";
    }

    @Override
    protected void defineProperties()
    {
//		putValue(MNEMONIC_KEY, KeyEvent.VK_N);
//		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
//		putValue(SMALL_ICON, new ImageIcon(CleanSheets.class.getResource("res/img/new.gif")));
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        try {
            this.app.load(this.file);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(OpenWorkbookAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.workbook = this.app.getWorkbook(this.file);
        uiController.setActiveWorkbook(this.workbook);
    }

    public void setFile(File file)
    {
        this.file = file;
    }

    public void setWorkbook(Workbook w)
    {
        this.workbook = w;
    }

    public Workbook getWorkbook()
    {
        return workbook;
    }

    public String createPreview(File file)
    {
        String preview = this.previewMap.get(file);

        if (preview == null || preview.isEmpty())
            this.updatePreview(file);

        return preview;
    }

    /**
     *
     * @param file
     * @return
     */
    public String updatePreview(File file)
    {
        String preview;

        try {
            this.workbook = WorkbookLoader.getInstance().load(file);
            StringBuilder builder = new StringBuilder();
            if(this.workbook.getSpreadsheetCount() > 0) {
                Spreadsheet sheet = this.workbook.getSpreadsheet(0);
                for(Cell cell : sheet.getCells(new Address(0,0), new Address(5,10))) {
                    String content = cell.getContent();
                    if(content != null && !content.isEmpty()) {
                        builder.append(cell.getAddress().toString()).append(" -> ").append(content).append("\n");
                    }
                }
            }

            if(builder.length() == 0) {
                preview = "Empty workbook";
            } else {
                preview = builder.toString();
            }

        } catch (IOException | ClassNotFoundException e) {
            preview = "Not a valid workbook file";
        }
        this.previewMap.put(file, preview);

        return preview;
    }

}
