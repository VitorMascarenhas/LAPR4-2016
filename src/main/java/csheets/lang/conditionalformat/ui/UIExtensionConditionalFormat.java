/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.lang.conditionalformat.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.JComponent;

/**
 *
 * @author 1950689 Nuno Mota
 */
public class UIExtensionConditionalFormat extends UIExtension {

    private JComponent sideBar;

    /**
     * Creates a new conditional format extension
     *
     * @param extension
     * @param uiController
     */
    public UIExtensionConditionalFormat(Extension extension, UIController uiController) {
        super(extension, uiController);
    }


    /**
     * Get the side bar
     *
     * @return the side bar
     */
    @Override
    public JComponent getSideBar() {
        if (sideBar == null) {
            sideBar = new ConditionalFormatPanel(uiController);

        }
        return sideBar;
    }
}
