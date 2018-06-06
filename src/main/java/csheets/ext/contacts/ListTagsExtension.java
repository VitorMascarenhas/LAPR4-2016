package csheets.ext.contacts;


import csheets.ext.Extension;
import csheets.ext.contacts.ui.UIExtensionListTags;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 * An extension to support tags on contacts.
 * An extension must extend the Extension abstract class.
 * The class that implements the Extension is the "bootstrap" of the extension.
 * @see Extension
 * @author José Vilela 1010500
 * @author Einar Pehrson
 */
public class ListTagsExtension extends Extension{

	/** The name of the extension */
	public static final String NAME = "ListTags";

	/**
	 * Creates a new Tags extension.
	 */
	public ListTagsExtension() {
		super(NAME);
	}
	
	
	/**
	 * Returns the user interface extension of this extension 
	 * @param uiController the user interface controller
	 * @return a user interface extension, or null if none is provided
	 */
        @Override
	public UIExtension getUIExtension(UIController uiController) {
		return new UIExtensionListTags(this, uiController);
	}

}
