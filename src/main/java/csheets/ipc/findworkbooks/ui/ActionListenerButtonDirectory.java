/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ipc.findworkbooks.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author 1950689 Nuno Mota
 */
public class ActionListenerButtonDirectory implements ActionListener {

    private FindWorkbooksController controller;

    private JTextField rootPath;
    private JTextField pattern;
    private JList resultList;

    public ActionListenerButtonDirectory(FindWorkbooksController controller, JTextField pathFld, JTextField patternFld, JList list)
    {
        this.controller = controller;
        this.rootPath = pathFld;
        this.pattern = patternFld;
        this.resultList = list;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        ((DefaultListModel<String>) this.resultList.getModel()).clear();

        Path root = Paths.get(this.rootPath.getText());
        if (!Files.isDirectory(root)) {
            JOptionPane.showMessageDialog(null, "Selected directory is invalid");
            return;
        }

        String pattern = this.pattern.getText();

        this.controller.findWorkbooks(root, pattern);
    }
}
