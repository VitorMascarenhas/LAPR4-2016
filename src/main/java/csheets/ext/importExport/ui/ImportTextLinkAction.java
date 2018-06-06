package csheets.ext.importExport.ui;

import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ext.importExport.ImportExportExtension;
import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.SMALL_ICON;
import javax.swing.ImageIcon;

/**
 *
 * @author André Oliveira
 */
public class ImportTextLinkAction extends FocusOwnerAction {

    /**
     * The user interface controller
     */
    protected UIController uiController;
    /**
     * UIImportTextLink
     */
    private UIImportTextLink uitextLink;

    /**
     * Consctructor of ImportTextLinkAction
     * @param uiController Active UIController
     */
    public ImportTextLinkAction(UIController uiController) {
        this.uiController = uiController;
        this.uitextLink = new UIImportTextLink();
    }

    /**
     * Returns the name of the Button
     * @return
     */
    @Override
    protected String getName() {
        return "Import Text Link File...";
    }

    /**
     * Action Perform of ImportTextLinkAction
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.uitextLink.showDialog(null, "Import from Text Link file", focusOwner, uiController);
        } catch (FileNotFoundException | FormulaCompilationException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Properties of ImportTextLinkAction
     */
    @Override
    protected void defineProperties() {
        putValue(MNEMONIC_KEY, KeyEvent.VK_I);
        putValue(SMALL_ICON, new ImageIcon(ImportExportExtension.class.getResource("res/img/open.gif")));
    }

}
