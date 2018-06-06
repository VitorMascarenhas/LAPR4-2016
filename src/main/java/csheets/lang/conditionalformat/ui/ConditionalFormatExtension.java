/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.lang.conditionalformat.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 *
 * @author 1950689 Nuno Mota
 */
public class ConditionalFormatExtension extends Extension {
    
    public static final String NAME = "ConditionalFormatExtension";
    public ConditionalFormatExtension() {
        super(NAME);
    }
    
    /**
     * Return the ConditionalFormat UI extension
     * @param uiController
     * @return 
     */
    @Override
    public UIExtension getUIExtension(UIController uiController){
        return new UIExtensionConditionalFormat(this, uiController);
    }
    
}
