package csheets.ext.charts.ui;

import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

/**
 *
 * @author 1120013@isep.ipp.pt
 */
class ChartSubMenuAction extends BaseAction {

	private final UIController uiController;
	private ChartController chartController;

	public ChartSubMenuAction(UIController uiController) {
		this.uiController = uiController;
	}

	@Override
	protected String getName() {
		return "Chart Wizard";
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		chartController = new ChartController(uiController);
		chartController.startWizard(this.getName());
	}

}
