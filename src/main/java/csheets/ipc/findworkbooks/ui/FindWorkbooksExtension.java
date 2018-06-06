/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ipc.findworkbooks.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 *
 * @author 1950689 Nuno Mota
 */
public class FindWorkbooksExtension extends Extension {
    
    public static final String NAME = "FindWorkbooksExtension";

    public FindWorkbooksExtension()
    {
        super(NAME);
    }
    
    /**
     * Return the find workbooks UI extension
     * @param uiController
     * @return 
     */
    @Override
    public UIExtension getUIExtension(UIController uiController)
    {
        return new UIExtensionFindWorkbooks(this, uiController);
    }
    
}
