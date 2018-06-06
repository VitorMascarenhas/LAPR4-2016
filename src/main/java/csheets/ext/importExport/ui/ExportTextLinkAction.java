package csheets.ext.importExport.ui;

import csheets.ext.importExport.ImportExportExtension;
import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.SMALL_ICON;
import javax.swing.ImageIcon;

/**
 *
 * @author André Oliveira
 */
public class ExportTextLinkAction extends FocusOwnerAction {

    /**
     * The user interface controller
     */
    protected UIController uiController;
    /**
     * UIExportTextLink
     */
    private UIExportTextLink uitextLink;
    
    /**
     * Constructor of ExportTextLinkAction
     * @param uiController Active UIController
     */
    public ExportTextLinkAction(UIController uiController) {
        this.uitextLink = new UIExportTextLink();
        this.uiController = uiController;
    }
    
    /**
     * Return the Name of Button
     * @return 
     */
   
    @Override
    protected String getName() {
        return "Export Text Link File...";
    }
    
    /**
     * Action perform to show the UI to the user
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.uitextLink.showDialog(null, "Export Text Link File", focusOwner);
    }
    
    /**
     * Properties of UI of Export Text Link File
     */
    @Override
    protected void defineProperties() {
        putValue(MNEMONIC_KEY, KeyEvent.VK_E);
        putValue(SMALL_ICON, new ImageIcon(ImportExportExtension.class.getResource("res/img/save.gif")));
    }

}
