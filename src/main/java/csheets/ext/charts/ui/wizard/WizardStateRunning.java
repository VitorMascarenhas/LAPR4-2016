package csheets.ext.charts.ui.wizard;

/**
 * Running Wizard state.
 *
 * @author 1120013@isep.ipp.pt
 */
public class WizardStateRunning implements WizardState {

	/**
	 * Action to be done when the Wizard changes his state to Running.
	 *
	 * @param wizard the Wizard whose state is changing
	 */
	@Override
	public void enableButton(Wizard wizard) {
		wizard.enableBackButton();
	}

}
