
/**
 * Technical documentation regarding the work of the team member (1010500) José Vilela during week1. 
 * 
 * <p>
 * <p>
 * <b>Scrum Master: - no</b>
 * 
 * <p>
 * <b>Area Leader: - no</b>
 * 
 * <h2>1. Notes</h2>
 * 
 * 
 * 
 * 
 * 
 *
 * <h2>2. Use Case/Feature: IPC04.1</h2>
 * 
 * Issue in Jira: 
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-60" >IPC04.1</a>

 * 
 * <h2>3. Requirement</h2>
 * <p>
 * It should be possible to export and import data to/from a text file. Each line in the text file represents
 * a row of data. In each line a special character is used to separate columns. The user should be able to
 * configure this character and also define if the first line of the text file should be treated as containing the
 * header of the columns or as regular row. The user should also enter a range of cells to be used as source
 * (export) or destination (import) for the operation.
 * </p>
 * 
 * <b>Use Case "Import Text File":</b> 
 * <p>1.The user selects the Import Text File feature.</p>
 * <p>2.The System asks for delimiter character, file information and if 1st line should be treated like a header.</p>
 * <p>3.The user enter information.</p>
 * <p>4.The System shows all information and ask for confirmation</p>
 * <p>5.The User confirm de Importation.</p>
 * <p>6.The System Import the Text File starting in the cell selected.</p>
 * 
 * <p><b>SSD UC "Import Text File"</b></p>
 * 
 * <img src="doc-files/ipc04_01_ssd_01.png" alt="ssd 1">
 * <p>
 * <b>Use Case "Export Text File":</b> 
 * <p>1.The user selects the Export Text File feature.</p>
 * <p>2.The System asks for delimiter character, file information and if 1st line should be treated like a header.</p>
 * <p>3.The user enter information.</p>
 * <p>4.The System shows all information and ask for confirmation</p>
 * <p>5.The User confirm de Importation.</p>
 * <p>6.The System Export selected cells to the Text File.</p>
 * 
 * <p><b>SSD UC "Export Text File"</b></p>
 * 
 * <img src="doc-files/ipc04_01_ssd_02.png" alt="ssd 2">
 * 
 * <h2>4. Analysis</h2>
 * 
 * 
 * <h3>First "analysis" sequence diagrams</h3>
 * The following diagrams depicts a proposal for the realization of the previously described use case. We call this diagram an "analysis" use case realization because it functions like a draft that we can do during analysis or early design in order to get a previous approach to the design. For that reason we mark the elements of the diagram with the stereotype "analysis" that states that the element is not a design element and, therefore, does not exists as such in the code of the application (at least at the moment that this diagram was created).
 * 
 * <h3>Import Text File"</h3>
 * 
 * <img src="doc-files/ipc04_01_Analysis_01.png" alt="analysis 1">
 * 
 * <h3>Export Text File"</h3>
 * 
 * <img src="doc-files/ipc04_01_Analysis_02.png" alt="analysis 2">
 * 
 * <h3>Analysis of Core Technical Problem</h3>
 *
 * <h2>5. Design</h2>
 * 
 * <h3>5.1. Functional Tests</h3>
 * Basically, from requirements and also analysis, we see that the core functionality of this use case is to be able to export data to/from Text Files.
 * <p>
 * see: <code>csheets.ext.importExport.ImportExportTextStrategyTest</code>
 * 
 * <h3>5.2. UC Realization</h3>
 * To realize this user story we will need to create a subclass of Extension. 
 * We will also need to create a subclass of UIExtension. 
 * We will also need two JComponents for the user choose the information.
 * In the code of the extension csheets.ext.style we can find examples that 
 * illustrate how to implement these technical requirements. 
 * The following diagrams illustrate core aspects of the design of the solution 
 * for this use case. 
 * 
 * <h3>Extension Setup</h3>
 * The following diagram shows the setup of the "Import Export" extension when cleansheets is run.
 * <p>
 * <img src="doc-files/ipc04_01_design_01.png" alt="design 1">
 *
 * <h3>UCR - Import from Text File</h3>
 * 
 * <img src="doc-files/ipc04_01_design_02.png" alt="design 2">
 * 
 * <h3>UCR - Export to Text File</h3>
 * 
 * <img src="doc-files/ipc04_01_design_03.png" alt="design 3">
 * 
 * <h3>5.3. Classes</h3>
 * 
 * -Document the implementation with class diagrams illustrating the new and the modified classes
 * <p>
 * <img src="doc-files/ipc04_01_Design_CD.png" alt="Class Diagram">
 * 
 * <h3>5.4. Design Patterns and Best Practices</h3>
 * 
 * To facilitate integration of new features for import or export of data to
 * diferent file formats (txt, xml, csv, etc) i  used the 
 * <a href="https://en.wikipedia.org/wiki/Strategy_pattern">Strategy Design Pattern</a> 
 * Since the behavior of exportToFile and importToFile varies by the strategy 
 * (or algorithm), we can create multiple ImportExportStrategy classes, wich with
 * a polymorphic exportToFile and importFromFile methods each exportToFile and 
 * importFromFile methods takes the SpreadsheetTable as a parameter, so that the 
 * ImportExport Strategy object can find the Cells selected by the user and 
 * then apply the parser algorithm and save to correct file for that Strategy.
 * The implementation of each exportToFile and importFromFile methods will be 
 * different: ImportExportTextStrategy will export and import for Text files, 
 * and so on. 
 * <p>
 * <img src="doc-files/ipc04_01_Strategy.png" alt="Strategy Design Pattern">
 * <p>
 * 
 * <h2>6. Implementation</h2>
 * 
 * -Reference the code elements that where updated or added-
 * <p>
 * commits of my work:<p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/bba5819b8b120665d9e31225e0d4d3dae6edf9bf">bba5819</a><p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/1381d1a70a982206c67b272ad9cd20da35d7a23e">1381d1a</a><p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/b683607d72db8a2ae702043265d1cb513ac2af20">b683607</a><p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/fa5b1bec545bc4dcef5c793b82b242a9e00e02a4">fa5b1be</a><p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/cf96cb34d0634e865822d2bf6373bc3b0b92c1d9">cf96cb3</a><p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/abfdc97e986112e647361125e540b8e901101d3c">abfdc97</a><p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/15a86e4f335dd25c46ea028727469e5c76ee1b49">15a86e4</a><p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/7ec5e4a358312f2e621f33fb46334bb693c8c591">7ec5e4a</a><p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/a7a4f6969790470a49a96e3244691e0c69b1d903">a7a4f69</a><p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/85d119a13302167041a15d3a5b30b2e0d317bd54">85d119a</a><p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/c4c56271c90ced947ed5a0c8bf8c82b7e769035d">c4c5627</a><p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/cb37e556cc83b9db20c09a2255c7f631122794e7">cb37e55</a><p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/4e8f7dcb32075f4de8c6ba3731688c1582df0e62">4e8f7dc</a><p>
 * <p>
 * see:<p>
 * <a href="../../../../csheets/ext/importExport/package-summary.html">csheets.ext.importExport</a><p>
 * 
 * <a href="../../../../csheets/ext/importExport/ui/package-summary.html">csheets.ext.importExport.ui</a><p>
 * 
 * <a href="../../../../csheets/ext/importExport/controller/package-summary.html">csheets.ext.importExport.controller</a><p>
 * 
 * <h2>7. Integration/Demonstration</h2>
 * 
 * I tried to integrate the new code into existing software as smooth as possible.<p>
 * I used / reused the maximum of elements that could , including classes, interfaces and icons.
 * 
 * <h2>8. Final Remarks</h2>
 * 
 * For other types of Files we need to implement the diffent strategys for each kind of File.<p>
 * Others Design Patterns can be used in this feature, like Adaptar or Facade.
 * <p>
 * 
 * <h2>9. Work Log</h2> 
 * 
 * <p>
 * <b>Monday</b>
 * <p>
 * Yesterday we plan the work for the rest of the week and start the analysis
 * 
 * <p>
 * Today
 * <p>
 * 1. Analysis of the import and Export from/to Text File issue, IPC04.1
 * 2. Start of the implementation of the UI.
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 * <p>
 * <b>Tuesday</b>
 * <p>
 * Yesterday I worked on: 
 * <p>
 * 1. Analysys of the import and Export from/to Text File issue, IPC04.1
 * 2. starting implementation of IPC04.1 Import Export Fle Text
 * <p>
 * Today
 * <p>
 * 1. conclusion of the UI implementation
 * 2. design of the Solution
 * <p>
 * Blocking:
 * <p>
 * 1. nothing
 * <p>
 * <b>Wednesday</b>
 * <p>
 * Yesterday I worked on: 
 * <p>
 * 1. conclusion of the implementation
 * <p>
 * Today
 * <p>
 * 1. implementing Tests<p>
 * 2. design of the Solution<p>
 * 3. conclusion of Technical Documentation<p>
 * <p>
 * Blocking:
 * <p>
 * 1. nothing
 * <p>
 * <b>Thursday</b>
 * <p>
 * Yesterday I worked on: 
 * <p>
 * 1. Unit Tests<p>
 * 2. technical documentation<p>
 * 3. implementation - minor fixes<p>
 * <p>
 * Today
 * <p>
 * 1. fix bugs <p>
 * 2. try find a better design solution for easy future reutilization<p>
 * 3. improve unit test<p>
 * 4. conclusion of technical documentation<p>
 * <p>
 * Blocking:
 * <p>
 * 1. 
 * <p>
 * <b>Friday</b>
 * <p>
 * Yesterday I worked on: 
 * <p>
 * 1. fix all bugs<p>
 * 2. implementation of Strategy Design Pattern<p>
 * 3. improve tests<p>
 * 4. refine technical documentation<p> 
 * <p>
 * Today
 * <p>
 * 1. Nothing
 * <p>
 * Blocking:
 * <p>
 * 1. 
 * 
 * @author jose Vilela 1010500
 */


package csheets.worklog.n1010500.sprint2;
class _Dummy_ {}