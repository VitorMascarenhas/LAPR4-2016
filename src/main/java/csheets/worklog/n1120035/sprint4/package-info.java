/**
 * Technical documentation regarding the work of the team member (1120035) Vitor Mascarenhas Doe during week4. 
 * 
 * <p>
 * <b>Nota:</b>
 * <p>
 * <b>Scrum Master: no</b>
 * 
 * <p>
 * <b>Area Leader: no</b>
 * 
 * <h2>1. Notes</h2>
 * 
 * In this week it is required to create a feature that allows the sharing of cells with multiple users, so it will use the already implemented classes.
 * <p>
 * 
 *
 * <h2>2. Use Case/Feature: IPC01.3 - Multiple Sharing.</h2>
 * 
 * Issue in Jira: http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-53
 * <p>
 * 
 * <h2>3. Requirement</h2>
 * Find all instances of cleansheets on the local network.
 * Choose a selection of cells to send.
 * Choosing the name for sharing.
 * 
 * <p>
 * <b>Use Case "Multiple Sharing":</b>It should be possible to have multiple cell shares active at the same time. Each of the shares should have a unique name. The location (i.e., range address) of the share in each instance of Cleansheets may be different. It should be possible to share ranges that include cells with formulas.
 * 
 * <h2>4. Analysis</h2>
 * To achieve this issue intend to create the following classes:
 * For the creation of this feature I want to use some existing classes such as StartSharingController, AutomaticSharingListener, CellValueObject, ConfigurationManager, etc, beyond that will create a Sharing Identifier class that will contain the name of the share connection and the IP of the machine to which we are connected.
 * 
 * <h3>Analysis of Core Technical Problem</h3>
 * 
 * <p></p>
 * <h2>The sequence diagrma for multiple sharing.</h2>
 * <p></p>
 * <p></p>
 * 
 * <img src="doc-files/Multiple_Sharing_Analysis_01.png" alt="Sequence Diagram for multiple sharing">
 * <p></p>
 * <p></p>
 * 
 * <p></p>
 * -----------------------------
 * <p></p>
 * To see the classes diagram
 * <img src="doc-files/CORE02.3-Class_Diagram.png" alt="Sequence Diagram for create and search comments">
 * <p></p>
 * 
 * <p>
 * After approach to change it was created a new classes diagram.
 * 
 * <img src="doc-files/CORE02.3-Class_Diagram_final.png" alt="Sequence Diagram for create and search comments">
 * </p>
 * Pattern diagram used
 * 
 * <p>
 * <img src="doc-files/core02_01_analysis_cell_delegate.png" alt="image"> 
 * 
 * <p>
 * One important aspect is how extensions are dynamically created and returned. The <code>Extensible</code> interface has only one method, <code>getExtension</code>. Any class, to be extensible, must return a specific extension by its name. The default (and base) implementation for the <code>Cell</code> interface, the class <code>CellImpl</code>, implements the method in the following manner:
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
 * To do this UC I pretend to create a class where is going to be created the xml file, that class is composed the object witch is an inteface where there are another classes that implemented it. The interface name is FileExport and the class that implement this methods is ToXml.
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
 * 
 * <p>
 * -Also refer all other artifacts that are related to the implementation and where used in this issue. As far as possible you should use links to the commits of your work-
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
 * Yesterday I worked on:
 * <p>
 * 
 * <p>
 * Today
 * <p>
 * 1. Analysis of the...
 * <p>
 * Blocking:
 * <p>
 * 
 * <p>
 * <b>Tuesday</b>
 * <p>
 * Yesterday I worked on: 
 * <p>
 * 1. ...
 * <p>
 * Today
 * <p>
 * 1. ...
 * <p>
 * Blocking:
 * <p>
 * 1. ...
 * 
 * <h2>10. Self Assessment</h2> 
 * 
 * -Insert here your self-assessment of the work during this sprint.-
 * 
 * <h3>10.1. Design and Implementation:3</h3>
 * 
 * 3- bom: os testes cobrem uma parte significativa das funcionalidades (ex: mais de 50%) e apresentam código que para além de não ir contra a arquitetura do cleansheets segue ainda as boas práticas da área técnica (ex: sincronização, padrões de eapli, etc.)
 * <p>
 * <b>Evidences:</b>
 * <p>
 * - url of commit: ... - description: this commit is related to the implementation of the design pattern ...-
 * 
 * <h3>10.2. Teamwork: ...</h3>
 * 
 * <h3>10.3. Technical Documentation: ...</h3>
 * 
 * @author alexandrebraganca
 */

package csheets.worklog.n1120035.sprint4;

/**
 * This class is only here so that javadoc includes the documentation about this EMPTY package! Do not remove this class!
 * 
 * @author Vitor Mascarenhas
 */
class _Dummy_ {}

