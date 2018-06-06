package csheets.ext.charts.ui.wizard;

import csheets.ext.charts.ui.ChartController;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Frame to allow the user to select a cells range to create the graph.
 *
 * @author 1120013@isep.ipp.pt
 */
public class WizardSelectCellsFrame extends JFrame implements ActionListener {

	private final JLabel statusLabel = new JLabel("Select a range of cells");
	private final JButton confirmButton = new JButton("Confirm");
	private final ChartController chartController;
	private final Wizard wizard;

	/**
	 * Creates the frame to allow the user to select the range cells to be part
	 * of the chart.
	 *
	 * @param title the frame title
	 * @param chartController the chart controller
	 * @param wizard the wizard owner of this frame
	 */
	public WizardSelectCellsFrame(String title, ChartController chartController,
								  Wizard wizard) {
		super(title);
		this.chartController = chartController;
		this.wizard = wizard;

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		gc.fill = GridBagConstraints.NONE;

		gc.gridx = 0;
		gc.gridy = 0;
		add(statusLabel, gc);

		gc.gridx = 0;
		gc.gridy = 1;
		gc.insets = new Insets(10, 0, 0, 0);
		confirmButton.setPreferredSize(new Dimension(100, 19));
		confirmButton.addActionListener(this);
		add(confirmButton, gc);

		setSize(250, 100);
		setLocationRelativeTo(null);
		setVisible(true);
		setAlwaysOnTop(true);
		setLocation(wizard.getWidth() + 50, wizard.getHeight() + 25);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.chartController.getSelectedCells();
		this.wizard.
			updateChartCellsText(this.chartController.getSelectedRange());
		this.dispose();
		this.wizard.toFront();
	}

}
