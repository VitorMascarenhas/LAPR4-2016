/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.importExport;


import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import csheets.ext.importExport.ui.UIExtensionImportExport;

/**
 * An extension to support comments on cells.
 * An extension must extend the Extension abstract class.
 * The class that implements the Extension is the "bootstrap" of the extension.
 * @see Extension
 * @author José Vilela 1010500
 * @author Einar Pehrson
 */
public class ImportExportExtension extends Extension{

	/** The name of the extension */
	public static final String NAME = "Import Export";

	/**
	 * Creates a new Example extension.
	 */
	public ImportExportExtension() {
		super(NAME);
	}
	
	
	/**
	 * Returns the user interface extension of this extension 
	 * @param uiController the user interface controller
	 * @return a user interface extension, or null if none is provided
	 */
        @Override
	public UIExtension getUIExtension(UIController uiController) {
		return new UIExtensionImportExport(this, uiController);
	}

}
