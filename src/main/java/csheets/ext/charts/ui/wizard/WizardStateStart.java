package csheets.ext.charts.ui.wizard;

/**
 * Start Wizard state.
 *
 * @@author 1120013@isep.ipp.pt
 */
public class WizardStateStart implements WizardState {

	/**
	 * Action to be done when the Wizard changes his state to Start.
	 *
	 * @param wizard the Wizard whose state is changing
	 */
	@Override
	public void enableButton(Wizard wizard) {
		wizard.enableNextButton();
	}

}
