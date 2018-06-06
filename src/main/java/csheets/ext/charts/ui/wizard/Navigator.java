package csheets.ext.charts.ui.wizard;

/**
 * Interface to define a common base to the navigator implementation of the
 * wizard.
 *
 * @author 1120013@isep.ipp.pt
 */
public interface Navigator {

	/**
	 * Constant representing the "Back" button.
	 */
	public static final int BACK = 1;

	/**
	 * Constant representing the "Next" button.
	 */
	public static final int NEXT = 2;

	/**
	 * Initializes the Screen navigator.
	 *
	 * @param parent The Wizard that owns the navigator.
	 */
	public void init(Wizard parent);

	/**
	 * Returns the name of the next screen to display.
	 *
	 * @param currentName The name of the current screen;
	 * @param direction The direction that the user is requesting to go: BACK or
	 * NEXT.
	 * @return the name of the next screen to display.
	 */
	public String getNextScreen(String currentName, int direction);

}
