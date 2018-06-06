package csheets.ext.importExport.controller;

import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ext.importExport.ImportExportExtension;
import csheets.ext.importExport.ui.ImportChooser;
import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.SMALL_ICON;
import javax.swing.ImageIcon;

/**
 * A import text action
 * @author José Vilela 1010500
 */
public class ImportAction extends FocusOwnerAction  {

	/** The user interface controller */
	protected UIController uiController;

	/**
	 * Creates a new action.
	 * @param uiController the user interface controller
	 */
	public ImportAction(UIController uiController) {
		this.uiController = uiController;
	}

        @Override
	protected String getName() {
		return "Import Text File...";
	}

        @Override
	protected void defineProperties() {
            putValue(MNEMONIC_KEY, KeyEvent.VK_I);
            putValue(SMALL_ICON, new ImageIcon(ImportExportExtension.class.getResource("res/img/open.gif")));
	}

	/**
	 * A import text action that presents a confirmation dialog.
         * The user choose the file, the delimiter character and confirm the 
         * cell focus.
         * When the user confirms the content of the file are imported to 
         * spreedcheet starting in cell focus.
	 * @param event the event that was fired
	 */
        @Override
	public void actionPerformed(ActionEvent event) {

            try {
                ImportChooser.showDialog(null,"Import from Text file",focusOwner, uiController);
            } catch (FileNotFoundException | FormulaCompilationException ex) {
                Logger.getLogger(ImportAction.class.getName()).log(Level.SEVERE, null, ex);
            }
            
	}
}
