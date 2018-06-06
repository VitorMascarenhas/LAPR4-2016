/**
 * Technical documentation regarding the work of the team member (1140411) Sara Ramos during week3. 
 * 
 * <p>
 * <b>Scrum Master: -(yes/no)- no</b>
 * 
 * <p>
 * <b>Area Leader: -(yes/no)- no</b>
 * 
 * <h2>1. Notes</h2>
 * 
 * <h2>2. Use Case/Feature: Lang08.2 - Import XML</h2>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-49">Issue in Jira</a>
 *
 * <h2>3. Requirement</h2>
 * It should be possible to import data from an XML file (this operation is the 'inverse' 
 * of the previous FI). Depending on the contents of the XML file, the data from the 
 * file can replace the contents of a workbook, a worksheet or a range of a worksheet. 
 * This option should appear in the File menu.
 *
 * <p>
 * <b>Use Case "Import XML":</b> 
 * The user selects to import a file. Its content is showed in order to the user 
 * selects the option he/she wants: to import the workbook, a specific spreadsheet or
 * a range of cells in a specific spreadsheet.
 * <p>
 * If the user selects the workbook, all the actual workbook will be replaced by the new one, 
 * created with all the data from the file.
 * <p>
 * If the user select spreadsheet, then he chooses which one he wants to import. 
 * In the actual workbook, only the selected spreadsheet will be replaced by the data from the file.
 * All other data will still the same.
 * <p>
 * If the user select a range of cells, in the choosen spreadsheet, only that cells will be replaced.
 * All the other cells still be the same.
 * <p> If the file imported has formating problems, the system will send a message to the user and
 * no imports the file.
 *  
 * 
 * <h2>4. Analysis</h2>
 * In order to import the data from the file, to parsing the document it was used the DOM parser. 
 * DOM parses an entire XML document and constructs a complete in-memory representation of the document.
 * <p> The XML related packages should be imported and a document builder created. 
 * The document builder create a document from a file. 
 * <p> It is necessary to create a GUI window that will allow the user to select
 * the desired file to import. 
 * <p> All the tags are choosen by the user, so the cleansheets should be able to 
 * detect the XML tags used. To extract the tags from the XML file, the root element
 * is extracted from the previous created document, then the sub-elements of it.
 * <p>The format of the files created by the previous feature (Lang 08.1) were mantained, 
 * as we can see from the example:
 * <pre>
 * {@code 
 *      <?xml version="1.0" encoding="UTF-8"?>
            <workbook>
                <spreadsheet id ="0" title="Titulo1">
                    <cell column="0" row="0">=2+3</cell>
                    <cell column="1" row="0">palavra</cell>
                    <cell column="2" row="3">=sum(3;4)</cell>
                    <cell column="2" row="4">teste</cell>
                </spreadsheet>
                <spreadsheet id ="2" title="Titulo2">
                    <cell column="0" row="0">2</cell>
                    <cell column="1" row="0">=</cell>
                    <cell column="2" row="3">2</cell>
                    <cell column="2" row="4">2</cell>
                    </spreadsheet>
                <spreadsheet id ="3" title="Titulo3">
                    <cell column="0" row="0">4</cell>
                    <cell column="1" row="0">teste</cell>
                    <cell column="2" row="3">4</cell>
                    <cell column="2" row="4">4</cell>
                </spreadsheet>
                <spreadsheet id ="4" title="Titulo4">
                    <cell column="0" row="0">=8-2</cell>
                    <cell column="1" row="0">10</cell>
                    <cell column="2" row="3">12</cell>
                    <cell column="2" row="4">palavra para teste</cell>
                </spreadsheet>
            </workbook>
 * }
 * </pre>
 * 
 * The id of the spreadsheets will be used to indicate the position of the spreadsheet in the workbook, 
 * such us in the previous implementation of Lang 08.1.
 * So, the user can choose in which position he/she wants the specific spreadsheet.

 * <h3>First "analysis" sequence diagram</h3>
 * Despite the use case was to import xml file, the analysis of it show that to improve implementation and 
 * future points of variation, it must be coded to import any kind of files. After user selects the file
 * he/ she wants to import, the proper strategy should run.
 * <p>
 * <img src="doc-files/Lang08.2.png" alt="UseCases"> 
 * 
 * <p> 
 * The following diagrams depicts a proposal for the realization of the previously described use case. 
 * 
 * <p>
 * <img src="doc-files/Lang08.2_importXMLFile.png" alt="ImportXMLFile"> 
 *
 * <h3>Analysis of Core Technical Problem</h3>
 * No previous code exists, so this use case must be implemented from the scratch.
 * 
 * To clean up the implementation of the solution, it must be considered if the user wants
 * to import all data from the file or parts of it (spreadsheet or a range of cells). 
 * To be consistent with the previous approach used in formats of xml files in use case Lang08.1, 
 * the user can choose any tag in xml file, but the xml structur must be the already declared above.
 * Is is needed three elements with refered attributes in order to the success of the file reading.
 * <p>
 * A validation of the file, using xsd should have been done, but due to the dinamic 
 * names used in tags, I will not be able to accomplish that (needs to adjust time in order to have 
 * the product ready to the delivery). So, to minimize this problem, try and catch in the java code 
 * will be implemented.
 * 

 * <h2>5. Design</h2>
 *
 * <h3>5.1. Functional Tests</h3>
 * Basically, from requirements and also analysis, we see that the core functionalities 
 * of this use case are to replace the content of mentioned cells in the xml file and send 
 * a success message to the user.
 * <p> Tests in some functionalities were implemented, as we can see in the classes 
 * <code>csheets.lang.files.ImportFactoryTest</code> and <code>csheets.lang.files.ParseXMLFileTest</code>.
 * <p> Two files for tests were created. One is well formated and the other is not. An exception will be throw 
 * and catched in the unit test.
 * 
 * 
 * <h3>5.2. UC Realization</h3>
 * 
 * To realize this user story it is necessary to create the classes {@link csheets.lang.files.ImportFactory}; 
 * {@link csheets.lang.files.ImportFileController}; {@link csheets.lang.files.ImportXMLStrategy}; 
 * {@link csheets.lang.files.ParseXMLFile}; {@link csheets.lang.files.ui.ImportFileMenu};
 * the interface {@link csheets.lang.files.ImportStrategy} and the JFrameForm {@link csheets.lang.files.ui.ImportFilePanel}.
 * 
 * The class {@link csheets.lang.files.ImportXMLStrategy} implements {@link csheets.lang.files.ImportStrategy}.
 * If in the future, if files which aren't xml file are to be imported, the apllication can easily receive them and 
 * continuous de implementation of file import.
 * 
 * <p>Below we can see the the diagram illustrating the core aspects of the solution 
 * for this use case. 
 * 
 * <p>
 * <img src="doc-files/Lang08.2_importXMLFile_SSD.png" alt="ImportXMLFile"> 
 * 
 * According to the user choice, one of the three methods is invoked. For more details 
 * of that we can see the below diagrams.
 *
 * <p>
 * <img src="doc-files/Lang08.2_importXMLReplaceWorkbook_SSD.png" alt="ImportXMLFile"> 
 * 
 * <p> It was considered that when the user selects to import the all data from the file, 
 * the previou workbook is replaced with the new one with all the data from the file.
 * <p> This method, for each spreadsheet to import calls the method 
 * <code>importXMLReplaceSpreadsheet(int ssOption)</code>. This way, code is reused and there is no duplicated.
 *
 * <p>
 * <img src="doc-files/Lang08.2_importXMLReplaceSpreadsheet_SSD.png" alt="ImportXMLFile"> 
 * <p> It was considered that when the user selects to import the data from a specific 
 * spreadsheet from the file, only the spreadsheet ate the workbook in the same position
 * of the id in the atribute of the selected spreadsheet is replaced. All data presented 
 * in the existing spreadsheet is replaced in this case for the new one. If the spreadsheet 
 * selected doesn't exist in the workbook, it is created in the index refered in it's 
 * id. 
 * 
 * <p>
 * <img src="doc-files/Lang08.2_importXMLReplaceRange_SSD.png" alt="ImportXMLFile"> 
 * <p> It was considered that when the user selects to import a range cells from a specific 
 * spreadsheet inside the file, only the that range in the spreadsheet will be replaced. 
 * The other cells will mantain there content and value. If the selected spreadsheet doesn't exist, 
 * just like in the previous case, it will be created in the index refered in it's id.
 * 
 * 
 * <h3>5.3. Classes</h3>
 * The classes {@link csheets.lang.files.ImportFactory}; 
 * {@link csheets.lang.files.ImportFileController}; {@link csheets.lang.files.ImportXMLStrategy}; 
 * {@link csheets.lang.files.ParseXMLFile}; {@link csheets.lang.files.ui.ImportFileMenu};
 * the interface {@link csheets.lang.files.ImportStrategy} and the JFrameForm {@link csheets.lang.files.ui.ImportFilePanel} 
 * were created to implemet this use case.
 * 
 * 
 * <h3>5.4. Design Patterns and Best Practices</h3>
 * Fatory pattern was implemented (see {@link csheets.lang.files.ImportFactory}). It was intend to deal with the problem of creating an object
 * (ImportXMLStrategy) without having to specify the exact class of the object that will be created. 
 * <p>
 * A strategy pattern was used to enable the algorithms behavior. To accomplish that 
 * it was used the interface ImportStrategy (see {@link csheets.lang.files.ImportStrategy} and {@link csheets.lang.files.ImportXMLStrategy} and ).
 * <p>
 * To deal with problems with the file to import, try and catchs were implemented.
 * 
 * <h2>6. Implementation</h2>
 * The GUI was developed as we can in the above figure.
 * <p>
 * <img src="doc-files/gui_LANG08_02.png" alt="GUI"> 
 * 
 * <p>
 * The classe {@link csheets.lang.files.ParseXMLFile} is the responsible to extract 
 * all the necessary information from the file to accomplish the success import of the file.
 * In this one were implemented some important methods.
 * <p> The method <code>parseXML()</code> is the first one in order to parse the file using 
 * DOM and constructs a complete in-memory representation of the document.This document will 
 * be accessed everytime information of the data is needed. Once user can use any name in tags, 
 * it was necessary to implement the method <code>extractTagNames(Document doc)</code> to extract the tag 
 * names according to the hierarquie of the file.to the GUI the id of the existing spreadsheets 
 * in the imported file was developed the method <code>extractIdsSpreadsheets()</code>. This information 
 * will appear in a JComboBox.
 * 
 * <p> To obtain the maximum number of rows and columns between the exiting data in the 
 * selected spreadsheet and the new data to import it was created the method 
 * <code>getMaxRowColumn(NodeList cellsList, Spreadsheet spreadsheet)</code>. With it, it's accomplish to create 
 * an array of array of cells (<code>Cell[][]</code>) with all the new data to store in the right position.
 
 * <p> The methods <code>importXMLReplaceWorkbook()</code>;  
 * <code>importXMLReplaceSpreadsheet(int ssOption)</code>; <code>importXMLReplaceRange(int ssOption)</code> 
 * are responsible to parse the XML file and obtain all the specific information according to the 
 * option, in order to fill the cells.
 * 
 * <p>The method <code>spreadsheetById(int ssOption)</code> selects a spreadsheet 
 * according to its id (index in the workbook)in the file.
 * <p> The method <code>fillCells(Spreadsheet selectedSpreadsheet, Element spreadsheet)</code> 
 * fills the cells in the spreadsheet sent as a parameter and Element spreadsheet 
 * contains all the data from the file to put in the spreadsheet.
 * 
 * 
 * <h2>7. Integration/Demonstration</h2>
 * The demonstration to the costumer led to improvements in the implementation that will be presented nex tuesday.
 * 
 * 
 * <h2>8. Final Remarks</h2>
 * 
 * I suggest for future work to implement a validator to xml file.
 * 
 * 
 * <h2>9. Work Log</h2> 
 *
 * <b>Monday</b>
 * <p>
 * Yesterday I worked on: - nothing -
 *
 * <p>
 * Today
 * <p>
 * 1. Implemented unit tests to the previous use case Core 02.2.
 * <p>2. Start the analysis and the design of this use case.
 * <p>3. Technical documentation. 
 * <p>
 * Blocking: - nothing -
 * <p>
 * 
 * <b>Tuesday</b>
 * <p>
 * Yesterday I worked on: the conclusion of unit tests to the previous use case: Core 02.2. 
 * Started the analysis and the design of this use case.
 *
 * <p>
 * Today
 * <p>1. Design (finalize the factory and import strategy) and implementation (UI)of this use case.
 * <p>2. Technical documentation
 * <p>
 * Blocking: - nothing -
 * <p>
 * <b>Wednesday</b>
 * <p>
 * Yesterday I worked on: Design and implementation of this use case. All structure is implemented. 
 * Only the methods to extract information to the UI are missing.
 * <p>
 * Today
 * <p> 1. Implemented significant changes in the code previously implemented. Only 
 * the method to the range cells was not implemented yet.
 * <p> 2. Some adjusts int the technical documentation.
 * Blocking: Tryed to implement a validator to the file, mas no time to do that. It 
 * is mentioned as an improvement to the feature.
 * <p>
 * <b>Thursday</b>
 * <p>
 * Yesterday I worked on: implementation of the necessary methods to put necessary 
 * data into cells. Tryed to implement a validator to the file, but with no success.
 * <p>
 * Today
 * <p> 1. Some tests implemented and adjustments to technical documentation.
 *
 * 
 * <h2>10. Self Assessment</h2> 
 * The real challenge was to know well all the classes involved in this feature. 
 * I spent significant time studing them and working on the solution model. Besides that, 
 * I think that the job was well done.
 * 
 * <h3>10.1. Design and Implementation:</h3>
 * 
 * <p>
 * <b>Evidences:</b>
 * <p>
 * - url of commits: 
 * 

 * <p> <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/316ac1014922d8a58ceae782dcd2c2294515e987">Commit Implementation 1</a>
 * <p> <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/9e0375b867fe1580cb95bcbb4401625cc99c5fd9">Commit Implementation 2</a>
 * <p> <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/8a944074f5efbc300855aac890a0a008fd9a9af0">Commit Implementation 3</a>
 * <p> <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/52aef4fbdfba87bba2bcf3a98430daf8c29aeb1b">Commit Implementation 4</a>
 * <p> <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/337148b6af9b7f6084ec324788f1ed2a43531ca3">Commit Implementation 5</a>
 * <p> <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/921083295d06e9929fe3a0752fdf0e03626df71e">Commit Implementation 6</a>
 * <p> <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/5baadf2f4e909c2dbf53e08e2d09daae3f199fa2">Commit Implementation 7</a>
 * <p> <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/09abb432d2fd453de3dd0e6919dd1201c6a097f5">Commit Design 1</a>
 * <p> <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/4e2444d6b85a05b951283a865da2c69864a2d736">Commit Design 2</a>
 * <p> <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/ec4e7844f18d96bdede48692fb901ce0aa08f212">Commit Design 3</a>
 * <p> <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/8cb9bbed94470b560ee57337c0c6459e6634551c">Commit Tests 1</a>
 * <p> <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/0ad2a55370075efd6afc9e935635a31d902dc2be">Commit Tests 2</a>
 * 
 * 
 * <h3>10.2. Teamwork: </h3>
 * Everytime there was a doubt, parterns helped. Ideas and knowledge were shared. Me and Vitor Mascarenhas 
 * worked sometimes together in order to pass knowledge from previous use cases. I am responsible to continuing it's previous use case and
 * he is reponsible to continuing my previous one.
 * 
 * <h3>10.3. Technical Documentation: </h3>
 *  -
 * @author 1140411
 */

package csheets.worklog.n1140411.sprint3;

/**
 * This class is only here so that javadoc includes the documentation about this EMPTY package! Do not remove this class!
 * 
 * @author 1140411
 */
class _Dummy_ {}

