package csheets.ext.contacts;

import csheets.ext.Extension;
import csheets.ext.contacts.ui.UIExtensionContact;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 * An extension to support contact edition in sidebar window.
 * An extension must extend the Extension abstract class.
 * The class that implements the Extension is the "bootstrap" of the extension.
 * @see Extension
 * @author Pedro Costa
 */
public class ContactsExtension extends Extension{

    /** The name of the extension */
    public static final String NAME = "Contact Edition";

    /**
     * Creates a new extension.
     */
    public ContactsExtension()
    {
        super(ContactsExtension.NAME);
    }

    /**
     * Returns the user interface extension of this contact edition
     * @param uiController the user interface controller
     * @return a user interface extension, or null if none is provided
     */
    @Override
    public UIExtension getUIExtension(UIController uiController) {
        return new UIExtensionContact(this, uiController);
    }
}
