/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.importExport.ui;

import csheets.ext.importExport.controller.ImportAction;
import csheets.ext.importExport.controller.ExportAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;


/**
 * Representes the UI extension menu of the import / Export extension.
 * @author José Vilela 1010500
 */
public class ImportExportMenu extends JMenu {

	/**
	 * Creates a new import and export menu.
	 * This constructor creates and adds the menu options. 
	 * Two menu options are created.
	 * 1 - menu option for Import Data from a Text file
         * 2 - menu option for Export Data to a Text file
	 * @param uiController the user interface controller
	 */
	public ImportExportMenu(UIController uiController) {
		super("Import / Export");
		setMnemonic(KeyEvent.VK_I);

		// Adds Import and Export actions
                add(new ImportAction(uiController));
                add(new ExportAction(uiController));
                add(new ImportTextLinkAction(uiController));
                add(new ExportTextLinkAction(uiController));
	}	
}
