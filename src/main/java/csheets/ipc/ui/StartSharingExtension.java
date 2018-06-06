/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ipc.ui;

import csheets.core.Spreadsheet;
import csheets.ext.Extension;
import csheets.ipc.ui.UIExtensionStartSharing;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 *
 * @author smoli
 */
public class StartSharingExtension extends Extension {

    public static final String NAME = "Start Sharing";

    public StartSharingExtension() {
        super(NAME);
    }
    

    /**
     * Returns the user interface extension of this extension
     *
     * @param uiController the user interface controller
     * @return a user interface extension, or null if none is provided
     */
    @Override
    public UIExtension getUIExtension(UIController uiController) {
        return new UIExtensionStartSharing(this, uiController);
    }
}
