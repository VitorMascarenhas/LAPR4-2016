/**
 * Technical documentation regarding the work of the team member (1120013) Carlos Lopes during week1. 
 * 
 * <p>
 * <b>-Note: this is a template/example of the individual documentation that each team member must produce each week/sprint. Suggestions on how to build this documentation will appear between '-' like this one. You should remove these suggestions in your own technical documentation-</b>
 * <p>
 * <b>Scrum Master: -(yes/no)- No</b>
 * 
 * <p>
 * <b>Area Leader: -(yes/no)- No</b>
 * 
 * <h2>1. Notes</h2>
 * 
 * -Notes about the week's work.- Analysis to implement the option Extensions manager to enable and disable extensions
 * <p>
 * -All tree members studied the use case to find the best solution.-
 *
 * <h2>2. Use Case/Feature: Core01.1</h2>
 * 
 * Issue in Jira: LPFOURNA-97
 * <p>
 Enable and disable extensions
 * 
 * <h2>3. Requirement</h2>
 * Setup extension for comments on cells. The user should be able to activate and deactivate comments on cells. When activated, a sidebar for the comments should appear. The sidebar should be composed of a simple textbox to display and edit a comment. At the moment it is not required to save comments to disk.
 * 
 * <p>
 * <b>Use Case "Enter Comment on Cell":</b> The user selects the cell where he/she wants to enter a comment. The system displays the current comment of that cell. The user enter the text of the comment (or alters the existing one). The system saves the comment of the cell.
 * 
 *  
 * <h2>4. Analysis</h2>
 * Since comments on cells will be supported in a new extension to cleansheets we need to study how extensions are loaded by cleansheets and how they work.
 * The first sequence diagram in the section <a href="../../../../overview-summary.html#arranque_da_aplicacao">Application Startup</a> tells us that extensions must be subclasses of the Extension abstract class and need to be registered in special files.
 * The Extension class has a method called getUIExtension that should be implemented and return an instance of a class that is a subclass of UIExtension.
 * In this subclass of UIExtension there is a method (getSideBar) that returns the sidebar for the extension. A sidebar is a JPanel.
 * 
 * 
 * <h3>First "analysis" sequence diagram</h3>
 * The following diagram depicts a proposal for the realization of the previously described use case. We call this diagram an "analysis" use case realization because it functions like a draft that we can do during analysis or early design in order to get a previous approach to the design. For that reason we mark the elements of the diagram with the stereotype "analysis" that states that the element is not a design element and, therefore, does not exists as such in the code of the application (at least at the moment that this diagram was created).
 * <p>
 * <img src="doc-files/cell_conditional_format.png" alt="image">
 * <h3>Second sequence diagram - design</h3>
 * The following diagram depicts a proposal for the realization of the previously described use case. We call this diagram an "analysis" use case realization because it functions like a draft that we can do during analysis or early design in order to get a previous approach to the design. For that reason we mark the elements of the diagram with the stereotype "analysis" that states that the element is not a design element and, therefore, does not exists as such in the code of the application (at least at the moment that this diagram was created).
 * <p>
 * <img src="doc-files/cell_conditional_format2.png" alt="image">
 * * <p>
 * 
 * From the previous diagram we see that we need to add a new "attribute" to a cell: "comment".
 * <p>
 * The <a href="http://en.wikipedia.org/wiki/Delegation_pattern">delegation design pattern</a> is used in the cell extension mechanism of cleansheets. The following class diagram depicts the relations between classes in the "Cell" hierarchy.
 * <p>
 * <img src="doc-files/core02_01_analysis_cell_delegate.png" alt="image"> 
 * 
 * <p>
 * One important aspect is how extensions are dynamically created and returned. The <code>Extensible</code> interface has only one method, <code>getExtension</code>. Any class, to be extensible, must return a specific extension by its name. The default (and base) implementation for the <code>Cell</code> interface, the class <code>CellImpl</code>, implements the method in the following manner:
 * <pre>
 * {@code 
 * 	 // Lets user select color for True Values
        Color color_t = JColorChooser.showDialog(
                null,
                "Choose Background Color for TRUE values",
                ((StylableCell) focusOwner.getSelectedCell().
                getExtension(StyleExtension.NAME)).getBackgroundColor());

        Color color_f = JColorChooser.showDialog(
                null,
                "Choose Background Color for FALSE values",
                ((StylableCell) focusOwner.getSelectedCell().
                getExtension(StyleExtension.NAME)).getBackgroundColor());

        if (color_t != null || color_f != null) {
            // Colors each true selected cell
            for (Cell[] row : focusOwner.getSelectedCells()) {
                for (Cell cell : row) {
                    StylableCell stylableCell = (StylableCell) cell.getExtension(
                            StyleExtension.NAME);

                    try {
                        if (cell.getFormula().evaluate().toBoolean()) {
                            stylableCell.setBackgroundColor(color_t);
                        } else {
                            stylableCell.setBackgroundColor(color_f);
                        }
                    } catch (IllegalValueTypeException ex) {
                    }
                }
                uiController.setWorkbookModified(focusOwner.getSpreadsheet().getWorkbook());
                focusOwner.repaint();
                * }
 * </pre>
 * As we can see from the code, if we are requesting a extension that is not already present in the cell, it is applied at the moment and then returned. The extension class (that implements the <code>Extension</code> interface) what will do is to create a new instance of its cell extension class (this will be the <b>delegator</b> in the pattern). The constructor receives the instance of the cell to extend (the <b>delegate</b> in the pattern). For instance, <code>StylableCell</code> (the delegator) will delegate to <code>CellImpl</code> all the method invocations regarding methods of the <code>Cell</code> interface. Obviously, methods specific to <code>StylableCell</code> must be implemented by it.
 * Therefore, to implement a cell that can have a associated comment we need to implement a class similar to <code>StylableCell</code>.
 * 
 * <h2>5. Design</h2>
 *
 * <h3>5.1. Functional Tests</h3>
 * Basically, from requirements and also analysis, we see that the core functionality of this use case is to be able to add an attribute to cells to be used to store a comment/text. We need to be able to set and get its value.
 * Following this approach we can start by coding a unit test that uses a subclass of <code>CellExtension</code> with a new attribute for user comments with the corresponding method accessors (set and get). A simple test can be to set this attribute with a simple string and to verify if the get method returns the same string.
 * As usual, in a test driven development approach tests normally fail in the beginning. The idea is that the tests will pass in the end. 
 * <p>
 * see: <code>csheets.ext.comments.CommentableCellTest</code>
 *
 * <h3>5.2. UC Realization</h3>
 * To realize this user story we will need to create a subclass of Extension. We will also need to create a subclass of UIExtension. For the sidebar we need to implement a JPanel. In the code of the extension <code>csheets.ext.style</code> we can find examples that illustrate how to implement these technical requirements.
 * The following diagrams illustrate core aspects of the design of the solution for this use case.
 * <p>
 * <b>Note:</b> It is very important that in the final version of this technical documentation the elements depicted in these design diagrams exist in the code!
 * 
 * <h3>Extension Setup</h3>
 * The following diagram shows the setup of the "comments" extension when cleansheets is run.
 * <p>
 * <img src="doc-files/core02_01_design.png" alt="image">
 * 
 *
 * <h3>User Selects a Cell</h3>
 * The following diagram illustrates what happens when the user selects a cell. The idea is that when this happens the extension must display in the sidebar the comment of that cell (if it exists).
 * <p>
 * <img src="doc-files/core02_01_design2.png" alt="image">
 * 
 * <h3>User Updates the Comment of a Cell</h3>
 * The following diagram illustrates what happens when the user updates the text of the comment of the current cell. To be noticed that this diagram does not depict the actual selection of a cell (that is illustrated in the previous diagram).
 * <p>
 * <img src="doc-files/core02_01_design3.png" alt="image">
 * 
 * <h3>5.3. Classes</h3>
 * 
 * -Document the implementation with class diagrams illustrating the new and the modified classes-
 * 
 * <h3>5.4. Design Patterns and Best Practices</h3>
 * 
 * -Describe new or existing design patterns used in the issue-
 * <p>
 * -You can also add other artifacts to document the design, for instance, database models or updates to the domain model-
 * 
 * <h2>6. Implementation</h2>
 * 
 * added-
 * csheets.ext.manager.ui
 * csheets.ext.manager
 * <p>
 * We had to add a new line to the file -\lapr4-2016-2na\src\main\resources\csheets\res\extensions.props
 * refering the new option in the extensions menu
 * <p>
 * see:<p>
 * <a href="../../../../csheets/ext/comments/package-summary.html">csheets.ext.comments</a><p>
 * <a href="../../../../csheets/ext/comments/ui/package-summary.html">csheets.ext.comments.ui</a>
 * 
 * <h2>7. Integration/Demonstration</h2>
 * 
 * -In this section document your contribution and efforts to the integration of your work with the work of the other elements of the team and also your work regarding the demonstration (i.e., tests, updating of scripts, etc.)-
 * 
 * <h2>8. Final Remarks</h2>
 * 
 * -In this section present your views regarding alternatives, extra work and future work on the issue.-
 * <p>
 * As an extra this use case also implements a small cell visual decorator if the cell has a comment. This "feature" is not documented in this page.
 * 
 * 
 * <h2>9. Work Log</h2> 
 * 
 * -Insert here a log of you daily work. This is in essence the log of your daily standup meetings.-
 * <p>
 * Example
 * <p>
 * <b>Monday</b>
 * <p>
 * Yesterday I worked on: Understanding how to make diferent formats work depending on 
 * the cell's value.
 * <p>
 * 1. -nothing-
 * <p>
 * Today
 * <p>
 * 1. Implemented background choosing from picking a color on a chooser to both
 * true and false values
 * Also drew an sequence diagram to represent the actions performed 
 * <p>
 * Blocking:
 * <p>
 * 1. Building a side bar window ?? 
 * 2. 
 * <p>
 * <b>Thursday
 * I'll try to implement other styles such as BOLD, ITALIC, UNDERLINE... 
 * I'll also try to create a side bar to make the choice's about the style pretended
 * </b>
 * <p>
 * Didn't implement other styles such as BOLD, ITALIC, UNDERLINE... nor the
 * side bar to make the choice's about the style pretended
 * 
 * The cell's conditional formating is restricted to setting the background color 
 * as the user wishes both for True and False values using two Jchooser to make the choice 
 * of the color for each background
 * <p>
 * 
 * <p>
 * 
 * <p>
 * 1. ...
 * <p>
 * 
 * <p>
 * 1. ...
 * 
 * <h2>10. Self Assessment</h2> 
 * 
 * -Developed part of what I intended.
 * The code commited is both functioning and tested
 * The function of formating the cell's based on a boolean value is also functioning
 * JUnit tests are donne. testing the true or false condition of the formula in the cell
 * 
 * * 
 * <h3>10.1. Design and Implementation:3</h3>
 * Created a new sequence diagram maching the functions used in the code
 * 
 * <p>
 * <b>Evidences:</b>
 * <p>
 * - url of commit: ... - description: this commit is related to the implementation of the design pattern ...-
 * 
 * <h3>10.2. Teamwork: ...</h3>
 * 
 * <h3>10.3. Technical Documentation: ...</h3>
 * 
 * @author Carlos Manuel Lopes
 */
package csheets.worklog.n1120013.sprint2;

class _Dummy_ {}