/**
 * Technical documentation regarding the work of the team member (1121060) Sérgio Oliveira during week4.
 *
 * <b>Scrum Master: -(yes/no)- no</b>
 *
 * <p>
 * <b>Area Leader: -(yes/no)- no</b>
 *
 * <h2>1. Notes</h2>
 *
 * <p>
 * On Monday I helped a colleague with IPC05.02 and on Tuesday I helped a
 * colleague with IPC01.3
 *
 * <h2>2. Use Case/Feature: Lang08.3</h2>
 *
 * Issue in Jira:
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-50">Lang08.3- Full
 * XML Import/Export</a>
 * <p>
 * The previous options should now include all the persisting elements of
 * Cleansheets (i.e., all the contents that are normally persisted with the
 * workbook, such as macros, formatting styles, comments, etc.). The import
 * should now ask the user if the file contents should replace or append the
 * existing workbook contents.
 *
 * <h2>3. Requirement</h2>
 * The user should now be able to import and export all the persisting elements
 * that are normally persisted with the workbook. The import should now ask the
 * user if the file contents should replace or append the existing workbook
 * contents. Because we did not work with any issue regarding macro
 * implementation, this implementation will not handle anything related to
 * macros.
 *
 *
 * <h2>4. Analysis</h2>
 * Since the FI to import and export are already implemented, and there are no
 * use cases thar implement macros, this FI will implement all other persistent
 * elements and will do some refactoring where needed.
 *
 * The XML file that will be the result of this FI is:
 *
 * <pre>
 * {@code
 * <?xml version="1.0" encoding="UTF-8"?>
 * <workbook>
 *  <spreadsheet id ="0" title="Titulo1">
 *      <cell column="0" row="0" font="cellFont" bgColor="rgb(255,255,255)" border="(1,1,1,1)" vAlignment="0" hAlignment="0" format="string">
 *		<value>=2+3</value>
 *			<comments>
 *				<comment id="1" date="01-01-2016" author="user" font="commentFont" format="string" >
 *					the comment
 *				</comment>
 *				<comment id="2" date="01-01-2016" author="user" font="commentFont" format="string" >
 *					other comment
 * 				</comment>
 *			</comments>
 *		</cell>
 *   </spreadsheet>
 * </workbook>
 *
 * }
 * </pre>
 *
 * <h3>Export to XML analysis</h3>
 * The following diagram depicts a proposal for the realization of the export
 * portion of the use case.
 *
 * <p>
 * <img src="doc-files/lang08_3_analysis_export.png" alt="image">
 * <p>
 *
 * <h3>Import from XML analysis</h3>
 * The following diagram depicts a proposal for the realization of the import
 * portion of the use case. 
 * 
 * 
 * <p>
 * <img src="doc-files/lang08_3_analysis_import.png" alt="image">
 * <p>
 * 
 * <h2>5. Design</h2>
 *
 * <h3>5.1. Functional Tests</h3>
 
 * <p>
 * see: <code>csheets.lang.files.ExportFactoryTest</code>
 * see: <code>csheets.lang.files.ExportXmlStrategyTest</code> (not implemented)
 *
 * <h3>5.2. UC Realization</h3>
 *
 * <h3>Export to XML</h3>
 * <p>
 * <img src="doc-files/lang08_3_design_export.png" alt="image">
 *
 *
 * <h3>Import to XML</h3>
 * There was no work done on this part of the issue
 *
 * <h3>5.3. Classes</h3>
 *
 * <h4>Export to XML</h4>
 * 
 * <p>
 * <img src="doc-files/lang08_3_classdiagram_export.png" alt="image">
 * 
 * <p>
 * <b>Modified classes: </b>
 * <p>
 * IFileType
 * <p>
 * ExportFileController
 * <p>
 * ExportFileAction
 * <p>
 * ImportFileAction
 * <p>
 * ExportFilePanel
 * <p>
 * MenuBar
 * <p>
 *
 * <h3>5.4. Design Patterns and Best Practices</h3>
 *
 * With the work done on this issue, I did some refactoring on classes and implemented the strategy pattern
 * to allow future extensions of the export to file mechanism.
 * Also, I've implemented a factory to build the concrete strategy to export to file.
 * 
 * <h2>6. Implementation</h2>
 *
 * <p>
 *
 * commits: see subtasks of <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-50">Lang08.3- Full XML Import/Export</a>
 * <p>
 * see:
 * <p>
 * <a href="../../../../csheets/lang/files/package-summary.html">csheets.lang.files</a><p>
 * <a href="../../../../csheets/lang/files/ui/package-summary.html">csheets.lang.files.ui</a>
 *
 * <h2>7. Integration/Demonstration</h2>
 *
  *
 * <h2>8. Final Remarks</h2>
 *
 *
 * <h2>9. Work Log</h2>
 *
 * <p>
 * <b>Monday</b>
 * <p>
 * Yesterday I worked on: Finished the implementation of core03.2
 * <p>
 * Today
 * <p>
 * 1. Helped the analysis and design of IPC05.2
 * 2. Helped the analysis and design of IPC01.3
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 * <p>
 * <b>Tuesday</b>
 * <p>
 * Yesterday I worked on:
 * Helped with analysis and design of IPC issues
 * <p>
 * <p>
 * Today
 * <p>
 * 1. Starting the analysis of lang08.3
 * 2. Extra help on IPC01.3
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 * <p>
 * <b>Wednesday</b>
 * <p>
 * Yesterday I worked on: analysis of lang08.3, helped on ipc01.3
 * <p>
 * Today
 * <p>
 * Health condition prevented me from doing any work
 * <p>
 * <b>Thursday</b>
 * <p>
 * Today I've stared the design and implementation of lang08.3
 * 
 * <h2>10. Self Assessment</h2>
 *
 * -Insert here your self-assessment of the work during this sprint.-
 *
 * <h3>10.1. Design and Implementation:3</h3>
 *
 * <p>
 * <b>Evidences:</b>
 * <p>

 * <h3>10.2. Teamwork: ...</h3>
 *
 * <h3>10.3. Technical Documentation: ...</h3>
 *
 * @author Sérgio Oliveira
 */
package csheets.worklog.n1121060.sprint4;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author alexandrebraganca
 */
//class _Dummy_ {}

