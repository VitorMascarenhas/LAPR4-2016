package csheets.ext.importExport.controller;

import csheets.ext.importExport.ImportExportExtension;
import csheets.ext.importExport.ui.ExportChooser;
import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 * A export text action
 * @author José Vilela 1010500
 */
public class ExportAction extends FocusOwnerAction {

	/** The user interface controller */
	protected UIController uiController;

	/**
	 * Creates a new action.
	 * @param uiController the user interface controller
	 */
	public ExportAction(UIController uiController) {
		this.uiController = uiController;
	}

        @Override
	protected String getName() {
		return "Export Text File...";
	}

        @Override
	protected void defineProperties() {
            putValue(MNEMONIC_KEY, KeyEvent.VK_E);
            putValue(SMALL_ICON, new ImageIcon(ImportExportExtension.class.getResource("res/img/save.gif")));
	}

	/**
	 * A export text action that presents a confirmation dialog.
         * The user choose the file, the delimiter character and confirm the 
         * cell focus.
         * When the user confirms the content of cells selected are exported 
         * to the file selected.
	 * @param event the event that was fired
	 */
        @Override
	public void actionPerformed(ActionEvent event) {

            ExportChooser.showDialog(null,"Export to Text File",focusOwner);
	}
        
}

