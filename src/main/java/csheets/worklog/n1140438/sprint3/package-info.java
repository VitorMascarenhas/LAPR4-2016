/**
 * Technical documentation regarding the work of the team member (1140438) André Oliveira during week3. 
 * 
 * <p>
 * <b>Scrum Master: -(yes/no)- no</b>
 * 
 * <p>
 * <b>Area Leader: -(yes/no)- no</b>
 * 
 * <h2>1. Notes</h2>
 * 
 * -Notes about the week's work.-
 *
 * <h2>2. Use Case/Feature: IPC04.2 - Import/Export Text Link</h2>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-61">Issue in Jira</a>
 * <p>
 * -Include the identification and description of the feature-
 * 
 * <h2>3. Requirement</h2>
 * The process of creating a link is simular to the one described in IPC04.1 but the import or export should
 * be always active (until it is removed by the user). Being active means that the process will be repeated
 * automatically when the source of the data is updated. This should happen for imports and exports.
 * 
 * <p>
 * <b>Use Case "Import Text Link":</b> 
 * The user selects the Import Text Link File feature.
 * The System asks for delimiter character, the file information and if 1st line should be treated like a header.
 * The user enter the information.
 * The System shows all information and ask for confirmation.
 * The User confirm de Importation.
 * The System Import the Text File starting in the cell selected.
 * The User changes the imported text.
 * The System imports the text from file for each times that the text is changed.
 * 
 * <p>
 * <img src="doc-files/ssd_import.png" alt="image">
 * 
 * <p>
 * <b>Use Case "Export Text Link":</b> 
 * The user selects the Export Text Link File feature.
 * The System asks for delimiter character, the file information and if 1st line should be treated like a header.
 * The user enter the information.
 * The System shows all information and ask for confirmation.
 * The User confirm de Importation.
 * The System Exports the Text File starting in the cell selected.
 * The User changes the exported text.
 * The System exports the text to a file for each times that the text is changed.
 * 
 * <p>
 * <img src="doc-files/ssd_export.png" alt="image"> 
 *  
 * <h2>4. Analysis</h2>
 * 
 * <h3>First "analysis" sequence diagram</h3>
 * 
 * According the interpretation of the probleam, this feature is simular to the IPC04.1
 * but in this feature the import/export of text from/to text files, is always active
 * until the user removes the select text area. Will be necessary use listener of cells
 * to be possible the action of import/export stay active in every change.
 * The Gui interface will be equals to the existing in the IPC04.1 but will be 
 * needed two new menu options in Extesions Menu, to know:
 * 
 * <p>
 * 1.Import Text Link
 * <p>
 * <img src="doc-files/import_example.png" alt="image"> 
 * 
 * <p>
 * 2.Export Text Link
 * 
 * <p>
 * <img src="doc-files/export_example.png" alt="image"> 
 * 
 * <h2>5. Design</h2>
 *
 * <h3>5.1. UC Realization</h3>
 * 
 * <h3>Extension Manager Menu</h3>
 * The following diagram shows the loading of Extension Manager Menu (The same was used in the Issue IPC04.1)
 * <p>
 * <img src="doc-files/sequence_diagram_ui.png" alt="image">
 * 
 * <h3>GUI User Interaction Import</h3>
 * The following diagram shows the loading of the GUI for the Import Text Link
 * <p>
 * <img src="doc-files/sequence_diagram_user_interaction_gui_import.png" alt="image">
 * 
 * <h3>GUI User Interaction Export</h3>
 * The following diagram shows the loading of the GUI for the Export Text Link
 * <p>
 * <img src="doc-files/sequence_diagram_user_interaction_gui_export.png" alt="image">
 *
 * <h3>Import Text Link</h3>
 * The following diagram illustrates what happens when the text File is imported.
 * <p>
 * <img src="doc-files/sequence_diagram_import.png" alt="image">
 * 
 * <p>
 * <b>Import clear select cells</b>
 * The following diagram illustrates what happens when the text File is imported and cells are cleared.
 * <p>
 * <img src="doc-files/sequence_diagram_import_close_timer.png" alt="image">
 * 
 * <h3>Export Text Link</h3>
 * The following diagram illustrates what happens when the text File is exported.
 * <p>
 * <img src="doc-files/sequence_diagram_export.png" alt="image">
 * 
 * <p>
 * <b>Export clear select cells</b>
 * The following diagram illustrates what happens when the text File is exported and cells are cleared.
 * <p>
 * <img src="doc-files/sequence_diagram_export_clear_cell.png" alt="image">
 * 
 * <h2>6. Implementation</h2>
 * 
 * Code elements should be found in:
 * <p>
 * {@link csheets.ext.importExport.ui}
 * <p>
 * {@link csheets.ext.importExport}
 * <p>
 * {@link csheets.importExport.controller}
 * 
 * <h2>7. Integration/Demonstration</h2>
 * 
 * The tests can be found in the Test Packages folder's:
 * <p>
 * {@link csheets.ext.importExport}
 * 
 * <h2>8. Work Log</h2> 
 * 
 * <b>Sunday -  12 of June</b>
 * <p>
 * Analysis/Design of the feature.
 * <p>
 * Blocking: Jenkins build failure
 * <p>
 * <b>Monday -  13 of June</b>
 * <p>
 * Implementaion of the feature.
 * <p>
 * Blocking: Implementation of a timer with threads to import data from text files every time that its changed.
 * <p>
 * <b>Tuesday -  14 of June</b>
 * <p>
 * Implementaion of the feature / Unit Tests / Bug Fixing
 * <p>
 * Blocking: Problems with the cell listeners
 * <p>
 * <b>Wednesday -  15 of June</b>
 * <p>
 * Implementaion of the feature / Unit Tests / Bug Fixing. Creating border layout for imported/exported text link cells.
 * I have worked in bug fixing of feature CRM01.2- Company Contact
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/459d4759e9486c2e1be6f33a30fbd0e4bfc734bc">Resolution commit</a>
 * <p>
 * Blocking: nothing
 * 
 * <p>
 * <b>Evidences of Work:</b>
 * <p>
 * - url of commits: 
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/77eea4f8ccf806b49e3e4bc66a77766567d8b6f3">Commit Analysis</a>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/febd32ca2da25eac7ed39a76d1df0ac7954e2fa3">Commit Design 1</a>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/c6cd3d250b1b0e15c03aea092af055b3ddcce9df">Commit Design 2</a>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/0d78b42c5ab1bab612cd95e16e5ca0198558d1fb">Commit Implementation 1 </a>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/2068b6748bb0d1134a1f2dc2921c4a6681af2a97">Commit Implementation 2 </a>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/a6e95832e9ee2f775fdd0a0a8c9c396b593af17b">Commit Implementation 3 </a>
 *  * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/f25a4876531784ac2c45c4cad96562f27ca7057e">Commit Implementation 4 </a>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/56f11e5b2687cc0b9e0bad3ad76c72234d15e5d7">Commit Tests 1 </a>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/e1fad37e2d6f3747416e8bf8434a6b090c500fa3">Commit Tests 2 </a>
 * 
 * <h3>8.1. Teamwork: </h3>
 * Bernardo Meira (1140809) help me a lot with recurrents problems in the cells listeners
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-200">Issue for Bug Fixing</a>
 * 
 * @author André Oliveira
 */

package csheets.worklog.n1140438.sprint3;

/**
 * This class is only here so that javadoc includes the documentation about this EMPTY package! Do not remove this class!
 * 
 * @author alexandrebraganca
 */
class _Dummy_ {}

