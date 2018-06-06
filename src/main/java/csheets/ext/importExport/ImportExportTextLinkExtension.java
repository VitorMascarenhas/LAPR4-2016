package csheets.ext.importExport;

import csheets.ext.Extension;
import csheets.ext.importExport.ui.UIExtensionImportExport;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 *
 * @author André Oliveira
 */
public class ImportExportTextLinkExtension extends Extension {

    /**
     * The name of the extension
     */
    public static final String NAME = "Import Export Text Link";

    public ImportExportTextLinkExtension() {
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
        return new UIExtensionImportExport(this, uiController);
    }

}
