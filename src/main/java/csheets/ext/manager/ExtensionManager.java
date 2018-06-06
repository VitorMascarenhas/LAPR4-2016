package csheets.ext.manager;

import csheets.ext.Extension;
import csheets.ext.manager.ui.UIExtensionManager;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 * Extension Manager
 * @author 1950689 Nuno Mota
 */
public class ExtensionManager extends Extension {

	/** The name of the extension */
	public static final String NAME = "Extension Manager";

	/**
	 * Creates a new Example extension.
	 */
	public ExtensionManager() {
		super(NAME);
	}
	
	/**
	 * Returns the user interface extension of this extension (an instance of the class {@link  csheets.ext.manager.ui.UIExtensionManager}).
	 * In this extension example we are only extending the user interface.
	 * @param uiController the user interface controller
	 * @return a user interface extension, or null if none is provided
	 */
        @Override
	public UIExtension getUIExtension(UIController uiController) {
		return new UIExtensionManager(this, uiController);
	}
        
}
