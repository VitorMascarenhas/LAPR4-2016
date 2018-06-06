package csheets.ext.manager.ui;

import csheets.CleanSheets;
import csheets.ext.Extension;
import csheets.ext.ExtensionManager;
import java.awt.event.ActionEvent;


import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import java.awt.Component;
import java.awt.Container;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import static javax.swing.UIManager.get;

/**
 * An action of the Extension Manager
 * @author 1950689 Nuno Mota
 */
public class ExtensionManagerAction extends BaseAction {

	/** The user interface controller */
	protected UIController uiController;
        
	/**
	 * Creates a new action.
	 * @param uiController the user interface controller
	 */
	public ExtensionManagerAction(UIController uiController) {
//            this.jf = jf;
            this.uiController = uiController;
	}

        @Override
	protected String getName() {
		return "Managing";
	}

	protected void defineProperties() {
	}

	/**
	 * A simple action that presents a confirmation dialog.
	 * If the user confirms then the contents of the cell A1 of the current sheet are set to the string "Changed".
	 * @param event the event that was fired
	 */
        @Override
	public void actionPerformed(ActionEvent event) {

            JFrame frame = new JFrame();
            ExtensionManagerPanel extensionManagerPanel = new ExtensionManagerPanel(uiController,frame);
            frame.add(extensionManagerPanel);
            frame.pack();
            frame.setVisible(true);
            
	}
}
