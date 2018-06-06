package csheets.ext.charts.ui.wizard;

import java.util.EventListener;

/**
 * Wizard interface listeners.
 *
 * @author 1120013@isep.ipp.pt
 */
public interface WizardListener extends EventListener {

	/**
	 * Wizard cancelled listener.
	 *
	 * @param we Wizard event
	 */
	public void wizardCancelled(WizardEvent we);

	/**
	 * Wizard completed listener.
	 *
	 * @param we Wizard event
	 */
	public void wizardComplete(WizardEvent we);

	/**
	 * Wizard screen changed listener.
	 *
	 * @param we Wizard event
	 */
	public void wizardScreenChanged(WizardEvent we);
}
