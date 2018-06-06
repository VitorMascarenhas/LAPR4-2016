package csheets.ext.charts.ui.wizard;

/**
 * Finish Wizard state.
 *
 * @author 1120013@isep.ipp.pt
 */
public class WizardStateFinish implements WizardState {

	/**
	 * Action to be done when the Wizard changes his state to Finish.
	 *
	 * @param wizard the Wizard whose state is changing
	 */
	@Override
	public void enableButton(Wizard wizard) {
		wizard.enableFinishButton();
	}

}
