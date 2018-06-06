package csheets.ext.agenda;

import csheets.ext.Extension;
import csheets.ext.agenda.ui.UIExtensionAgenda;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 * An extension to support agenda edition in sidebar window.
 * An extension must extend the Extension abstract class.
 * The class that implements the Extension is the "bootstrap" of the extension.
 * @see Extension
 * @author Pedro Costa
 */
public class AgendaExtension extends Extension
{
    /** The name of the extension */
    public static final String NAME = "Agenda";

    /**
     * Creates a new extension.
     */
    public AgendaExtension()
    {
        super(AgendaExtension.NAME);
    }

    /**
     * Returns the user interface extension of this agenda
     * @param uiController the user interface controller
     * @return a user interface extension, or null if none is provided
     */
    @Override
    public UIExtension getUIExtension(UIController uiController)
    {
        return new UIExtensionAgenda(this, uiController);
    }
}
