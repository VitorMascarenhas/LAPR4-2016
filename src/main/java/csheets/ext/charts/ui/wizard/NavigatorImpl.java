package csheets.ext.charts.ui.wizard;

import java.util.Map;

/**
 * Implementação da interface navigator.
 *
 * @author 1120013@isep.ipp.pt
 */
public class NavigatorImpl implements Navigator {

	/**
	 * The Wizard that owns the navigator.
	 */
	protected Wizard parent;

	/**
	 * Initializes the screen navigator
	 *
	 * @param parent The Wizard that owns the navigator
	 */
	@Override
	public void init(Wizard parent) {
		this.parent = parent;
	}

	/**
	 * Returns the name of the next screen to display\
	 *
	 * @param currentName The name of the current screen
	 * @param direction The direction that the user is requesting to go: BACK or
	 * NEXT
	 * @return
	 */
	@Override
	public String getNextScreen(String currentName, int direction) {
		Map wizardScreens = this.parent.getWizardScreens();
		int currentIndex = this.parent.getCurrentScreenIndex();
		if (direction == NavigatorImpl.BACK) {
			this.parent.setCurrentScreenIndex(--currentIndex);
			return (String) wizardScreens.get(new Integer(currentIndex));
		} else if (direction == NavigatorImpl.NEXT) {
			this.parent.setCurrentScreenIndex(++currentIndex);
			return (String) wizardScreens.get(new Integer(currentIndex));
		}
		return "Unknown";
	}
}
