/**
 * Technical documentation regarding the work of the team member 1950689 Nuno Mota during week2. 
 * 
 * <p>
 * <b>-Note: this is a template/example of the individual documentation that each team member must produce each week/sprint. Suggestions on how to build this documentation will appear between '-' like this one. You should remove these suggestions in your own technical documentation-</b>
 * <p>
 * <b>Scrum Master: -(yes/no)- no</b>
 * 
 * <p>
 * <b>Area Leader: -(yes/no)- no</b>
 * 
 * <h2>1. Notes</h2>
 * 
 * -Notes about the week's work.-
 * <p>
 * -In this section you should register important notes regarding your work during the week.
 * For instance, if you spend significant time helping a colleague or if you work in more than a feature.-
 *
 * <h2>2. Use Case/Feature: IPC02.1- Find Workbooks</h2>
 * 
 * Issue in Jira: http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-54
 * <p>
 * Issue identification: LPFOURNA-54
 * The extension should add a new window (sidebar) to search for workbook files in the local file system.
 * The user should be able to enter the name of a directory of the file system to be used as the root of the search.
 * The search should include this directory and all its contents (including subdirectories).
 * The results of the search should appear in a list (as files are found).
 * It should be possible for the user to open a workbook from this list by double clicking in it.
 * The search can be based solely on the file name extension. For instance, find the files with .cls extension.
 * 
 * 
 * <h2>3. Requirement</h2>
 * Setup extension to serch for workbooks in the local file system.
 * The user should be able to enter the name of a local file system´s directory.
 * The output are the CleanSheets workbook files that belong to this search directory or any of its subdirectories.
 * This CleanSheets workbooks should appear in the output sidebar while they are found.
 * The user can double click on any CleanSheets Workbook files from the search output sidebar to open it.
 * 
 * <p>
 * <b>Use Case/Feature: IPC02.1- Find Workbooks:</b>
 * The user selects 'Search Workbook' from the extensions menu.
 * A window appear to select the search root directory.
 * The user double-click one CleanSheets workbook file from the side bar to open it.
 *  
 * <h2>4. Analysis</h2>
 * Since 'Find Workbooks' will be supported in a new extension to cleansheets we need add this extension in a special file.
 * There will be a class that implements the 'Observer' pattern and another one that implements the 'Observerable' pattern.
 * One is a thread that when it finds a file will comunicate sending the file.
 * Then the UI sidebar will be updated with that file.
 * 
 * <h3>System Sequence Diagram</h3>
 * <p>
 * <img src="doc-files/ipc02_1_analysis_find_workbook_SSD.png" alt="image"> 
 * 
 * <h3>'first' Class diagram</h3>
 * <p>
 * <img src="doc-files/ipc02_1_analysis_find_workbook_CD.png" alt="image"> 
 * 
 * <h3>'first' Sequence diagram</h3>
 * <p>
 * <img src="doc-files/ipc02_1_analysis_find_workbook_SD.png" alt="image"> 
 * 
 * 
 * <h3>Analysis of Core Technical Problem</h3>
 * We can see a class diagram of the domain model of the application <a href="../../../../overview-summary.html#modelo_de_dominio">here</a>
 * From the domain model we see that there is a Cell interface. This defines the interface of the cells. We also see that there is a class CellImpl that must implement the Cell interface.
 * If we open the {@link csheets.core.Cell} code we see that the interface is defined as: <code>public interface Cell extends Comparable &lt;Cell&gt;, Extensible&lt;Cell&gt;, Serializable</code>. Because of the <code>Extensible</code> it seams that a cell can be extended.
 * If we further investigate the hierarchy of {@link csheets.core.Cell} we see that it has a subclass {@link csheets.ext.CellExtension} which has a subclass {@link csheets.ext.style.StylableCell}. {@link csheets.ext.style.StylableCell} seems to be an example of how to extend cells.
 * Therefore, we will assume that it is possible to extend cells and start to implement tests for this use case. 
 * <p>
 * The <a href="http://en.wikipedia.org/wiki/Delegation_pattern">delegation design pattern</a> is used in the cell extension mechanism of cleansheets. The following class diagram depicts the relations between classes in the "Cell" hierarchy.
 * <p>
 * <img src="doc-files/core02_01_analysis_cell_delegate.png" alt="image"> 
 * 
 * <p>
 * One important aspect is how extensions are dynamically created and returned. The <code>Extensible</code> interface has only one method, <code>getExtension</code>. Any class, to be extensible, must return a specific extension by its name. The default (and base) implementation for the <code>Cell</code> interface, the class <code>CellImpl</code>, implements the method in the following manner:
 * <pre>
 * {@code 
 * 	public Cell getExtension(String name) {
 *		// Looks for an existing cell extension
 *		CellExtension extension = extensions.get(name);
 *		if (extension == null) {
 *			// Creates a new cell extension
 *			Extension x = ExtensionManager.getInstance().getExtension(name);
 *			if (x != null) {
 *				extension = x.extend(this);
 *				if (extension != null)
 *					extensions.put(name, extension);
 *			}
 *		}
 *		return extension;
 *	}
 * }
 * </pre>
 * As we can see from the code, if we are requesting a extension that is not already present in the cell, it is applied at the moment and then returned. The extension class (that implements the <code>Extension</code> interface) what will do is to create a new instance of its cell extension class (this will be the <b>delegator</b> in the pattern). The constructor receives the instance of the cell to extend (the <b>delegate</b> in the pattern). For instance, <code>StylableCell</code> (the delegator) will delegate to <code>CellImpl</code> all the method invocations regarding methods of the <code>Cell</code> interface. Obviously, methods specific to <code>StylableCell</code> must be implemented by it.
 * Therefore, to implement a cell that can have a associated comment we need to implement a class similar to <code>StylableCell</code>.
 * 
 * <h2>5. Design</h2>
 *
 * <h3>5.1. Functional Tests</h3>
 * Funcional Tests were done.
 * <p>
 * 
 * <h3>5.2. UC Realization</h3>
 * 
 * <h3>Sequence diagram</h3>
 * <p>
 * <img src="doc-files/ipc02_1_design_find_workbooks_SD.png" alt="image"> 
 * 
 * <h3>5.3. Classes</h3>
 * 
 * -Document the implementation with class diagrams illustrating the new and the modified classes-
 * 
 * <h3>5.4. Design Patterns and Best Practices</h3>
 * 
 * -Describe new or existing design patterns used in the issue-
 * Observer and Observerable patterns.
 * <p>
 * -You can also add other artifacts to document the design, for instance, database models or updates to the domain model-
 * 
 * <h2>6. Implementation</h2>
 * 
 * -Reference the code elements that where updated or added-
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
 * <b>Friday</b>
 * <p>
 * Yesterday was Presentation day.
 * <p>
 * Before the presentation I worked on:
 * <p>
 * 1. I did the implementation of the usecase/functionality core01_01.
 * <p>
 * 2. pair-programming with Eduardo and Carlos to correct extension manager menu.
 * <p>
 * After the presentation I worked on:
 * <p>
 * 3. pair-programming with Eduardo and Carlos to prevent the 'extension manager' to be loaded as an option to disable itself.
 * <p>
 * Today
 * <p>
 * 1. I am initializing sprint2 javadoc
 * <p>
 * 2. I am finishing sprint1 core01_01 sequence diagram (see chapter 'Attachment' at the end of this file)
 * <p>
 * 3. I am finishing sprint1 core01_01 class diagram (see chapter 'Attachment' at the end of this file)
 * <p>
 * <b>Monday</b>
 * <p>
 * Today
 * <p>
 * 1. I am doing sprint2 javadoc
 * <p>
 * 2. I am initializing IPC02.1 'first' class diagram
 * <p>
 * 3. I am initializing IPC02.1 'first' sequence diagram
 * <p>
 * 4. I am initializing IPC02.1 System Sequence Diagram
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 * <p>
 * <b>Tuesday</b>
 * <p>
 * Yesterday I worked on: 
 * <p>
 * 1. ...
 * <p>
 * Today
 * <p>
 * 1. I am doing sprint2 javadoc
 * <p>
 * 2. I've concluded analysis sub-task
 * <p>
 * 3. I am initializing design
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 * <p>
 * <b>Wednesday</b>
 * <p>
 * Today
 * <p>
 * 1. I am doing sprint2 javadoc
 * <p>
 * 2. I did design 
 * <p>
 * 3. I did Implementation
 * <p>
 * 4. I did Tests
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 * <p>
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
 * <h3>Attachment:</h3>
 * <p>
 * Conclusion of sprint1 core01_01 class diagram and sequence diagram on Friday(2016/06/03)
 * 
 * <h3>Class diagram</h3>
 * <p>
 * <img src="doc-files/core01_01_enable_disable_extensions_CD.png" alt="image"> 
 * 
 * <h3>Sequence diagram</h3>
 * <p>
 * <img src="doc-files/core01_01_enable_disable_extensions_SD.png" alt="image"> 
 * 
 * @author 1950689 Nuno Mota
 */

package csheets.worklog.n1950689.sprint2;

/**
 * This class is only here so that javadoc includes the documentation about this EMPTY package! Do not remove this class!
 * 
 * @author 1950689 Nuno Mota
 */

class _Dummy_ {}
