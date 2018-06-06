package csheets.ext.charts.ui.wizard;

import csheets.ext.charts.ChartableCell;
import csheets.ext.charts.ChartsExtension;
import csheets.ext.charts.ui.ChartController;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author 1120013@isep.ipp.pt
 */
public class Wizard extends JDialog implements ActionListener {

    WizardStateContext wizardContext = new WizardStateContext();

    /**
     * Wizard title formats.
     */
    public static final Font TITLE_FONT = new Font("Times New Roman", Font.BOLD, 20);

    /**
     * Wizard text formats.
     */
    public static final Font TEXT_FONT = new Font("Times New Roman", Font.PLAIN, 14);

    private final String title;
    private final ImageIcon logo;

    private final JButton backButton = new JButton("< Back");
    private final JButton nextButton = new JButton("Next >");
    private final JButton cancelButton = new JButton("Cancel");
    private final JButton selectCellsButton = new JButton("Select cells");

    private final JPanel contentPanel;

    private JLabel chartTitleLabel;
    private JLabel chartCellsLabel;
    private JCheckBox lineIsLabelCkBox;
    private JCheckBox rowIsLabelCkBox;
    private JTextField chartTitleText;
    private JTextField chartCellsText;

    private final Map wizardScreens = new HashMap();
    private final ChartController chartController;
    private int currentScreen = 0;
    private final Navigator navigator;

    private final Set listeners = new HashSet();

    /**
     * Creates a new Wizard with the specified title and application logo.
     *
     * @param title the wizard title.
     * @param chartController
     */
    public Wizard(String title, ChartController chartController) {
        this.title = title;
        this.chartController = chartController;
        this.logo = new ImageIcon(ChartsExtension.class.
                getResource("res/img/wizard.gif"));

        JPanel borderPanel = new JPanel(new BorderLayout());
        borderPanel.setBorder(BorderFactory.createEtchedBorder());

        JLabel iconLabel = new JLabel(logo);
        borderPanel.add(iconLabel, BorderLayout.WEST);

        contentPanel = new JPanel(new CardLayout());
        borderPanel.add(contentPanel);
        this.getContentPane().add(borderPanel);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(backButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(cancelButton);
        backButton.addActionListener(this);
        nextButton.addActionListener(this);
        cancelButton.addActionListener(this);
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(640, 480);
        this.setLocation(d.width / 2 - 320, d.height / 2 - 240);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                fireWizardCancelled();
            }
        });

        this.navigator = new NavigatorImpl();
        this.navigator.init(this);
    }

    /**
     * Returns a label that is consistent with the look-and-feel of the Wizard
     *
     * @param text Text component of the label
     * @param f The font of the label: TITLE_FONT, TEXT_FONT
     * @param alignment The alignment of the text (from JLabel constants)
     * @return
     */
    public JLabel getWizardLabel(String text, Font f, int alignment) {
        JLabel label = new JLabel(text, alignment);
        label.setFont(f);
        label.setBackground(Color.white);
        label.setForeground(Color.black);
        label.setOpaque(true);
        return label;
    }

    /**
     * Returns a text area that is consistent with the look-and-feel of the
     * Wizard; it will be read only but look normal
     *
     * @param text Text component of the text area
     * @return
     */
    public JTextArea getWizardTextArea(String text) {
        JTextArea textArea = new JTextArea(text);
        textArea.setEnabled(false);
        textArea.setDisabledTextColor(Color.black);
        textArea.setAlignmentX(JTextArea.CENTER_ALIGNMENT);
        return textArea;
    }

    /**
     *
     * @param component
     * @return
     */
    public JPanel getBufferedBodyPanel(JComponent component) {
        JPanel panel = new JPanel(new BorderLayout());

        panel.setBorder(BorderFactory.
                createMatteBorder(20, 20, 20, 20, Color.white));
        panel.add(component, BorderLayout.CENTER);
        return panel;
    }

    /**
     *
     * @param component
     * @return
     */
    public JPanel getBufferedBottomPanel(JComponent component) {
        JPanel panel = new JPanel(new BorderLayout());

        panel.setBorder(BorderFactory.
                createMatteBorder(10, 20, 20, 20, Color.white));
        panel.add(component, BorderLayout.CENTER);
        return panel;
    }

    /**
     *
     * @param component
     * @return
     */
    public JPanel getBufferedTopPanel(JComponent component) {
        JPanel panel = new JPanel(new BorderLayout());

        panel.setBorder(BorderFactory.
                createMatteBorder(20, 20, 20, 20, Color.white));
        panel.add(component, BorderLayout.CENTER);
        return panel;
    }

    /**
     * Creates a Welcome Panel to display to the user
     *
     * @param title The title of the Wizard
     * @param message The body of the welcome message
     */
    public void addWelcomePanel(String title,
            String message) {
        // Create the Panel
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEtchedBorder());

        // Setup the fields
        panel.
                add(getBufferedTopPanel(getWizardLabel(title, this.TITLE_FONT, JLabel.CENTER)), BorderLayout.NORTH);
        panel.
                add(getBufferedBodyPanel(getWizardTextArea(message)), BorderLayout.CENTER);
        panel.
                add(getBufferedBottomPanel(getWizardTextArea("To contine, click \"Next\".")), BorderLayout.SOUTH);

        // Add the panel to the content panel
        addPanel(panel, "Welcome");

        // Ensure that the panel is shown first
        showPanel("Welcome");
    }

    /**
     * Adds a summary panel of events that the system is about to perform
     *
     * @param steps A list of all of the steps
     */
    public void addSummaryPanel(String[] steps) {
        // Create the Panel
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEtchedBorder());

        // Setup the fields
        panel.
                add(getBufferedTopPanel(getWizardLabel("Summary", this.TITLE_FONT, JLabel.CENTER)), BorderLayout.NORTH);

        StringBuffer message = new StringBuffer("This wizard will guide you to create a chart:\n\n");
        for (int i = 0; i < steps.length; i++) {
            message.append("\t- " + steps[i] + "\n");
        }

        panel.
                add(getBufferedBodyPanel(getWizardTextArea(message.toString())), BorderLayout.CENTER);
        panel.
                add(getBufferedBottomPanel(getWizardTextArea("To continue, click \"Next\".")), BorderLayout.SOUTH);

        // Add the panel to the content panel
        addPanel(panel, "Summary");
    }

    /**
     * Adds a Finished (or ThankYou) panel that provides information after the
     * wizard has completed
     *
     * @param message The message to report to the user
     */
    public void addFinishedPanel(String message) {
        // Create the Panel
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEtchedBorder());

        // Setup the fields
        panel.
                add(getBufferedTopPanel(getWizardLabel("Finished", this.TITLE_FONT, JLabel.CENTER)), BorderLayout.NORTH);
        panel.
                add(getBufferedBodyPanel(getWizardTextArea(message)), BorderLayout.CENTER);
        panel.
                add(getBufferedBottomPanel(getWizardTextArea("To exit, click \"Finish\".")), BorderLayout.SOUTH);

        // Add the panel to the content panel
        addPanel(panel, "Finished");
    }

    /**
     * Adds a panel to the wizard
     *
     * @param title
     * @param name
     * @param customPanel
     */
    public void addCustomPanel(String title, String name, JPanel customPanel) {
        // Create the Panel
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEtchedBorder());

        // Setup the fields
        panel.
                add(getBufferedTopPanel(getWizardLabel(title, this.TITLE_FONT, JLabel.CENTER)), BorderLayout.NORTH);
        panel.add(getBufferedBodyPanel(customPanel), BorderLayout.CENTER);
        panel.
                add(getBufferedBottomPanel(getWizardTextArea("To continue, click \"Next\"")), BorderLayout.SOUTH);

        // Add the panel to the content panel
        addPanel(panel, name);
    }

    /**
     *
     * @param title
     * @param name
     * @param customPanel
     */
    public void addChartCreationPanel(String title, String name,
            JPanel customPanel) {
        // Create the Panel
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEtchedBorder());

        JPanel chartPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        chartTitleLabel = new JLabel("Chart title:");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(2, 4, 0, 0);  //top padding
        c.gridx = 0;
        c.gridy = 0;
        chartPanel.add(chartTitleLabel, c);

        chartTitleText = new JTextField(20);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 0;
        chartPanel.add(chartTitleText, c);

        chartCellsLabel = new JLabel("Cells range:");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        chartPanel.add(chartCellsLabel, c);
        
        setLineIsLabelCkBox(new JCheckBox("Consider first line is a label"));
        c.fill =GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 4;
        chartPanel.add(lineIsLabelCkBox, c);

        rowIsLabelCkBox = new JCheckBox("Consider first row is a label");
        c.fill =GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.gridx = 1;
        c.gridy = 5;
        chartPanel.add(rowIsLabelCkBox, c);
        
        chartCellsText = new JTextField(10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 1;
        chartCellsText.setEditable(false);
        chartPanel.add(chartCellsText, c);
        System.out.println(chartCellsText.getHeight());

        selectCellsButton.setPreferredSize(new Dimension(10, 20));
        selectCellsButton.addActionListener(this);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 1;
        c.gridx = 2;
        c.gridy = 1;
        chartPanel.add(selectCellsButton, c);

        customPanel.add(chartPanel);

        panel.
                add(getBufferedTopPanel(getWizardLabel(title, Wizard.TITLE_FONT, JLabel.CENTER)), BorderLayout.NORTH);
        panel.add(getBufferedBodyPanel(customPanel), BorderLayout.CENTER);
        panel.
                add(getBufferedBottomPanel(getWizardTextArea("To continue, click \"Next\"")), BorderLayout.SOUTH);

        addPanel(panel, name);
    }

    /**
     * Adds a panel to the wizard; for the panel to be shown it must be
     * added via this method
     *
     * @param panel
     * @param name
     */
    public void addPanel(JPanel panel, String name) {
        // Add the panel to the content panel
        this.contentPanel.add(panel, name);

        // Keep track of a the 0-based numerical index of each panel name
        int size = this.wizardScreens.size();
        this.wizardScreens.put(new Integer(size), name);
    }

    /**
     * Displays panel with the specified name
     *
     * @param name
     */
    public void showPanel(String name) {
        CardLayout cl = (CardLayout) this.contentPanel.getLayout();
        cl.show(this.contentPanel, name);
        this.contentPanel.repaint();
    }

    /**
     * Displays the wizard
     */
    public void showWizard() {
        this.updateWizardState();
        this.setVisible(true);
    }

    /**
     * Helper method that controls the state and text of the wizard buttons
     */
    private void updateWizardState() {
        if (this.currentScreen == 0) {
            wizardContext.setStateStart();
        } else if (this.currentScreen == this.wizardScreens.size() - 1) {
            wizardContext.setStateFinish();
        } else {
            wizardContext.setStateRunning();
        }
        wizardContext.action(this);
    }

    /**
     * Returns the map of zero-based Integer indexed keys to Screen Names
     *
     * @return
     */
    public Map getWizardScreens() {
        return this.wizardScreens;
    }

    /**
     * Returns the index of the currently displayed screen
     *
     * @return
     */
    public int getCurrentScreenIndex() {
        return this.currentScreen;
    }

    /**
     * Sets the index of the currently displayed screen
     *
     * @param currentScreen
     */
    public void setCurrentScreenIndex(int currentScreen) {
        this.currentScreen = currentScreen;
    }

    /**
     * Event handling.
     *
     * @param ae event
     */
    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == this.backButton) {// The user pressed back
            String currentName = (String) this.wizardScreens.
                    get(new Integer(this.currentScreen));
            String name = this.navigator.
                    getNextScreen(currentName, Navigator.BACK);
            this.showPanel(name);
            this.fireWizardScreenChanged();
        } else if (ae.getSource() == this.nextButton) {// The user pressed next
            if (this.currentScreen == this.wizardScreens.size() - 1) {// Last screen, we are done!
                this.setVisible(false);
                this.fireWizardComplete();
            } else {// Advance to the next screen
                String currentName = (String) this.wizardScreens.
                        get(new Integer(this.currentScreen));
                String name = this.navigator.
                        getNextScreen(currentName, Navigator.NEXT);
                this.showPanel(name);
                this.fireWizardScreenChanged();
            }
        } else if (ae.getSource() == this.cancelButton) {// The user cancelled the wizard
            this.setVisible(false);
            this.fireWizardCancelled();
        }

        if (ae.getSource() == this.selectCellsButton) {
            this.toBack();
            this.repaint();
            WizardSelectCellsFrame wizardSelectCellsFrame = new WizardSelectCellsFrame("Select cells range", this.chartController, this);

        }

        if (ae.getSource() == this.nextButton
                && this.nextButton.getText().equals("Finish")) {
            this.chartController.createChart(title, chartController.
                    getSelectedCells(), chartController.getlineLabel(), chartController.getrowLabel());

            chartController.chartableCell().getExtension(title);
            ChartableCell cc = (ChartableCell) chartController.chartableCell().
                    getExtension(ChartsExtension.NAME);
            this.chartController.setChart(cc, this.chartController.getChart(), chartController.getlineLabel(), chartController.getrowLabel());
            System.out.println("Has chart(" + cc.getAddress() + "): " + cc.
                    hasChart());
        }

        this.updateWizardState();
    }

    /**
     * Adds a WizardListener to the Wizard that will be notified when specific
     * events occur
     *
     * @param l listener
     */
    public void addWizardListener(WizardListener l) {
        this.listeners.add(l);
    }

    /**
     * Removes a WizardListener from the Wizard
     *
     * @param l listener
     */
    public void removeWizardListener(WizardListener l) {
        this.listeners.remove(l);
    }

    /**
     * Notifies that the Wizard was cancelled.
     */
    protected void fireWizardCancelled() {
        WizardEvent we = new WizardEvent(this);
        for (Iterator i = this.listeners.iterator(); i.hasNext();) {
            WizardListener wl = (WizardListener) i.next();
            wl.wizardCancelled(we);
        }
    }

    /**
     * Notifies that the Wizard was completed.
     */
    protected void fireWizardComplete() {
        WizardEvent we = new WizardEvent(this);
        for (Iterator i = this.listeners.iterator(); i.hasNext();) {
            WizardListener wl = (WizardListener) i.next();
            wl.wizardComplete(we);
        }
    }

    /**
     * Notifies that the Wizard panel was changed.
     */
    protected void fireWizardScreenChanged() {
        WizardEvent we = new WizardEvent(this);
        for (Iterator i = this.listeners.iterator(); i.hasNext();) {
            WizardListener wl = (WizardListener) i.next();
            wl.wizardScreenChanged(we);
        }
    }

    /**
     * enables the back button.
     */
    public void enableBackButton() {
        this.backButton.setEnabled(true);
        this.nextButton.setEnabled(true);
        this.nextButton.setText("Next >");
    }

    /**
     * enables the next button.
     */
    public void enableNextButton() {
        this.backButton.setEnabled(false);
        this.nextButton.setEnabled(true);
    }

    /**
     * enables the finish button.
     */
    public void enableFinishButton() {
        this.backButton.setEnabled(true);
        this.nextButton.setText("Finish");
    }

    /**
     * Updates the range cells text.
     *
     * @param range the cells range to be showned to the user.
     */
    public void updateChartCellsText(String range) {
        this.chartCellsText.setText(range);
    }

    /**
     * @return the lineIsLabelCkBox
     */
    public boolean getLineIsLabelCkBox() {
        return lineIsLabelCkBox.isSelected();
    }

    /**
     * @return the rowIsLabelCkBox
     */
    public boolean getrowIsLabelCkBox() {
        return rowIsLabelCkBox.isSelected();
    }
    
    /**
     * @param lineIsLabelCkBox the lineIsLabelCkBox to set
     */
    public void setLineIsLabelCkBox(JCheckBox lineIsLabelCkBox) {
        this.lineIsLabelCkBox = lineIsLabelCkBox;
    }

}
