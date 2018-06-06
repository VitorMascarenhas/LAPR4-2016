package csheets.ext.charts.ui.wizard;

/**
 * Defines the state Wizard state context
 *
 * @author 1120013@isep.ipp.pt
 */
public class WizardStateContext {

    private WizardState state = null;

    /**
     * Set the Wizard state to Start.
     *
     */
    public void setStateStart() {
        this.state = new WizardStateStart();
    }

    /**
     * Set the Wizard state to Running.
     *
     */
    public void setStateRunning() {
        this.state = new WizardStateRunning();
    }

    /**
     * Set the Wizard state to Finish.
     *
     */
    public void setStateFinish() {
        this.state = new WizardStateFinish();
    }

    /**
     * Returns the currrent state
     *
     * @return the current State
     */
    public WizardState currentState() {
        return state;
    }

    /**
     * Do the defined action in the wizard interface implementation.
     *
     * @param wizard the Wizard
     */
    public void action(Wizard wizard) {
        state.enableButton(wizard);
    }

}
