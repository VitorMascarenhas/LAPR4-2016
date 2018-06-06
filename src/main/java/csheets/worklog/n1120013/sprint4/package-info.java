/**
 * Technical documentation regarding the work of the team member (1120013) Carlos Lopes during week4. 
 * 
 * <p>
 * <b>- individual documentation -</b>
 * <p>
 * <b>Scrum Master: -(yes/no)- No</b>
 * 
 * <p>
 * <b>Area Leader: -(yes/no)- No</b>
 * 
 * <h2>1. Notes</h2>
 * 
 * -Notes about the week's work.- Analysis to implement the option to implement Simple graph wizard
 * <p>
 * 
 *
 * <h2>2. Use Case/Feature: Core09.1</h2>
 * 
 * Issue in Jira: LPFOURNA-24
 * <p>
 menu option to launch a wizard to help the user create a bar chart.
 * 
 * <h2>3. Requirement</h2>
 * 
 * 
 * <p>
 * 
 *  
 * <h2>4. Analysis</h2>
 * LPFOURNA-215
 * 
 * <h3>First "analysis" sequence diagram</h3>
 * The following diagram is a proposal for the present use case. 
 * <p>
 * <img src="doc-files/core09_01_analysis_associate_chart_to_cell.png" alt="image">
 * <p>
 * This sequence diagram represents the actions of the diferent classes as well as the called methods.
 * <img src="doc-files/core09_01_analysis_wizard.png" alt="image"> 
 * <p>
 * The <code>Extensible</code> wizard, <code>getExtension</code>, implements the method in the following manner:
 * <pre>
 * {@code 
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
 * </pre>
 * As we can see from the code, we are creating a Wizard using a panel.
 * Also using cardlayout to navigate.
 * <h2>5. Design</h2>
 * LPFOURNA-216
 * <p>
 * Class Diagram 
 * <p>
 * <img src="doc-files/core09_01_Class_design.png" alt="image"> 
 * <p>
 * Sequence diagram for associating a chart and cell 
 * <p>
 * <img src="doc-files/core09_01_associate_chart_and_cell.png" alt="image"> 
 * <p>
 * 
 * Extensions Setup Sequence Diagram
 * <p>
 * <img src="doc-files/core09_01_extension_setup.png" alt="image"> 
 * <p> 
 * 
 * Wizard Sequence Diagram
 * <p>
 * <img src="doc-files/core09_01_design_SD_wizard.png" alt="image"> 
 * <p> 
 * 
 *
 * Wizard Sequence Diagram from/to User
 * <p>
 * <img src="doc-files/core09_01_design_SD_wizard_user.png" alt="image"> 
 * <p> 
 * <h3>5.1. Functional Tests</h3>
 * csheets.ext.charts
 *  ChartableCellTest
 * <p>
 * csheets.ext.charts.ui
 *  ChartControllerTest
 * <p>
 * <h2>6. Implementation</h2>
 * <p>
 * LPFOURNA-217
 * added-
 * csheets.ext.charts
 * csheets.ext.charts.ui
 * csheets.ext.charts.ui.wizard
 * <p>
 * We had to add a new line to the file -\lapr4-2016-2na\src\main\resources\csheets\res\extensions.props
 * refering the new option in the extensions menu that is CHART->WIZARD
 * <p>
 * <h2>7. Integration/Demonstration</h2>
 * 
 * -It's possible to see the wizard working, except for the creation of the chart image.
 * 
 * <h2>8. Final Remarks</h2>
 * 
 * It's missing to create an option to refer the next button befor the previewing of the chart...
 * 
 * 
 * <h2>9. Work Log</h2> 
 * 
 * <b>Monday<b>
 * <p>
 * Analysing the issue. Two analysis diagrams were uploaded.
 * Started designing the diagrams  
 * <p>
 * <b>Tuesday<b>
 * Design of the sequence diagrams. (Wizard, User, associate chart to a cell) 
 * Also a class diagram
 * <p>
 * Today I started and finished the tests sub-task. Some tests that were running, after starting the implementation 
 * had problemns 'cause stoped running.. but those problems where solved with the help of my colleagues (Bernardo Meira, in thise case)
 * <p>
 * <p>
 * Blocking: Found it very hard to generate the Wizard option, and I think I spent a lot of time 
 * on the wizard and little time remained to the creation of the chart
 * 
 * 2. 
 * <p>
 * <b>Thursday<b>
 * <p>
 * Thursday can't work on this project. Even thought some things are not ready (in this project), I have work reasons that make it impossible for me 
 * to even be at ISEP on this thursday
 * <p>
 * <b>Evidences:<b>
 * The wizard is working, excep fot the chart previewing
 * <p>
 * 
 * <h3>10.2. Teamwork: ...</h3>
 * 
 * About team work I must say that this was the best group/class that I ever had
 * in ISEP. Everyone helped everyone else. 
 * THIS CLASS REALLY WORKED AS A TEAM!!
 * 
 * <h3>10.3. Technical Documentation: ...</h3>
 * 
 * @author Carlos Manuel Lopes
 */
package csheets.worklog.n1120013.sprint4;

class _Dummy_ {}