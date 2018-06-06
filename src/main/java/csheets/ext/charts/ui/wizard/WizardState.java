package csheets.ext.charts.ui.wizard;

/**
 * Interface to define a action when the state is changed.
 *
 * @author 1120013@isep.ipp.pt
 */
public interface WizardState {

	/**
	 * Action to preform when the state is changed.
	 *
	 * @param wizard the wizard with the different states
	 */
	public void enableButton(Wizard wizard);
}
