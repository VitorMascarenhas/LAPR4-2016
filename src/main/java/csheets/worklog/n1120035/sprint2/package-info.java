/**
 * Technical documentation regarding the work of the team member (1120035) Vitor Mascarenhas Doe during week1. 
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
 * This week I pretend to create an exportation function to xml file. I pretend to accomplish the analysis until saturday night, after that the implementation and design take begin to end with unit test.
 * <p>
 * 
  *
 * <h2>2. Use Case/Feature: Lang08.1- Export XML</h2>
 * 
 * Issue in Jira: http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-113
 * <p>
 * 
 * <h2>3. Requirement</h2>
 * The goal is to do a workbook, spreadsheet or a group of cells exportation to a xml file.
 * 
 * <p>
 * <b>Use Case "Export XML":</b> When the user pretends to make a xml file exportation insert file menu > export it opens a windows where user choses one of the three options of workbook, spreadsheet or cells export useng a radiobutton. If the user choses a workbook export could also chose a tag name for workbook, spreadsheet and cell and choses a path folder. Conserning to spreadsheet exportation could also chose the tags name and the path folder but he also has to select the spreadsheet that has to be exported. At the end to make the cells exportation the user has to nomeate the index of the first and last and aplication export the information.
 * 
 * <h2>4. Analysis</h2>
 * To develop the functionality I have to do a study the GUI and classes already implemented
 * The first sequence diagrma
 * <img src="doc-files/ExportXML_Analysis_01.png" alt="Sequence Diagram for export xml">
 * <p>
 * 
 * It was addictid to the first diagrma
 * 
 * <h3>Analysis of Core Technical Problem</h3>
 * To see the classes diagram
 * <img src="doc-files/lang08.1_Class_Diagram.png" alt="Sequence Diagram for export xml">
 * 
 * <p>
 * The last sequence diagrma
 * 
 * <img src="doc-files/lang08.1_ExportXml_sequence_diagram_final.png" alt="Sequence Diagram for export xml">
 * <p>
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
 *
 * <h3>User Selects a Cell</h3>
 * <h3>User Updates the Comment of a Cell</h3>
 * 
 * <h3>5.3. Classes</h3>
 * 
 * 
 * <h3>5.4. Design Patterns and Best Practices</h3>
 * 
 * <h2>6. Implementation</h2>
 * 
 * 
 * 
 * <h2>7. Integration/Demonstration</h2>
 * 
 * <h2>8. Final Remarks</h2>
 * 
 * <h2>9. Work Log</h2> 
 * <h3>10.1. Design and Implementation:3</h3>
 * 
 * <h3>10.2. Teamwork: ...</h3>
 * 
 * <h3>10.3. Technical Documentation: ...</h3>
 * 
 * @author VitorMascarenhas1120035
 */

package csheets.worklog.n1120035.sprint2;

/**
 * This class is only here so that javadoc includes the documentation about this EMPTY package! Do not remove this class!
 * 
 * @author Vitor Mascarenhas
 */
class _Dummy_ {}

