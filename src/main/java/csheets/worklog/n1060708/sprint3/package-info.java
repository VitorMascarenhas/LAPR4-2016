/**
 * Technical documentation regarding the work of the team member (1060708) Eduardo Silva during week1. 
 * 
 * <p>
 * 
 * <p>
 * <b>Scrum Master: -(yes/no)- no</b>
 * 
 * <p>
 * <b>Area Leader: -(yes/no)- no</b>
 * 
 * <h2>1. Notes</h2>
 * 
 * -Analysis, Design, Tests and Implementation of ipc01.02 issue-
 * <p>
 * -In this section you should register important notes regarding your work during the week.
 * For instance, if you spend significant time helping a colleague or if you work in more than a feature.-
 *
 * <h2>2. Use Case/Feature: ipc02.1</h2>
 * 
 * Issue in Jira: http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-52
 * <p>
 * Ipc02.1- Sharing's Automatic Update
 * 
 * <h2>3. Requirement</h2>
 * 
 *Add support for automatic sharing.
 *It's necessary to connect and then select the cells that will be able to automatic share. Then press Start Automatic Sharing
 *When one of this cells is changed, it will informe the CellListener that the value/content/style was changed.
 *The AutomaticSharingListener will send a message to the connected instanc, with the cell parameters to be changed.
 *When received it will automatically update, by getting the cell(with the cell adress), and then update the value/style.
 * 
 * <p>
 * <b>Use Case "Sharing's Automatic Update":</b> Once a connection is stablished between two instances of Cleansheets updates made in one side must be automatically sent to the other side. The data shared must include now also the style of the cells. At the moment It is not necessary to support the sharing of cells with formulas.
 * 
 *  
 * <h2>4. Analysis</h2>
 * Need to study how style is implemented, anjd how to get the values of the style.
 * It's aldo needed to understand how can be notifyed that the style changed.
 * 
 * 
 * <h3>First "analysis" diagram</h3>
 * <p>
 * <img src="doc-files/ipc01_02_analysis_adding_cell_listeners.png" alt="image"> 
 * <p>
 * 
 * <h3>Design of the setting listeners to the selected cells</h3>
 * 
 * <p>
 * In the next image we can see how it is implemented to addCellsOn Automatic Sharing
 * <p>
 * <img src="doc-files/ipc01_02_analysis_adding_cell_listeners.png" alt="image"/>
 * 
 * <p>In the next image we can see how the event is fired after a a Cell change</p>
 * <img src="doc-files/ipc01_02_design_firecelllistener_to_livesend.png" alt="image"> 
 * <p>
 * In this sample of code we can see how was the listeners added to the cell
 * <pre>
 * {@code 
 *   public void addCellListeners(){
 *      Cell[][] selectedCells = focusOwner.getSelectedCells();
 *       
 *       for (int i = 0; i < selectedCells.length; i++) {
 *           for (int j = 0; j < selectedCells[i].length; j++) {
 *               cellsListening.add(selectedCells[i][j]);
 *           }
 *       }
 *       
 *       for(Cell cell : cellsListening){
 *           ((CellImpl)cell).addCellListener(new AutomaticSharingListener(this));
 *       }
 *   }
 * </pre>
 * <h2>5. Design</h2>
 *
 * * 
 * <h3>Design of the setting listeners to the selected cells</h3>
 * 
 * <p>
 * In the next image we can see how it is implemented to addCellsOn Automatic Sharing
 * <p>
 * <img src="doc-files/ipc01_02_analysis_adding_cell_listeners.png" alt="image"/>
 * 
 * <p>In the next image we can see how the event is fired after a a Cell change</p>
 * <img src="doc-files/ipc01_02_design_firecelllistener_to_livesend.png" alt="image"> 
 * <p>
 * In this sample of code we can see how was the listeners added to the cell
 * <pre>
 * {@code 
 *   public void addCellListeners(){
 *      Cell[][] selectedCells = focusOwner.getSelectedCells();
 *       
 *       for (int i = 0; i < selectedCells.length; i++) {
 *           for (int j = 0; j < selectedCells[i].length; j++) {
 *               cellsListening.add(selectedCells[i][j]);
 *           }
 *       }
 *       
 *       for(Cell cell : cellsListening){
 *           ((CellImpl)cell).addCellListener(new AutomaticSharingListener(this));
 *       }
 *   }
 * </pre>
 *
 * <h3>5.1. Functional Tests</h3>
 * In order to make the test it is needed get the extention, that is the main problem to make the test.
 * <p>
 * see: <code>csheets.ipc.ConnectionManagerTest</code>
 *
 * <h3>5.2. UC Realization</h3>
 * To realize this user story will need to be implemente a fireStyleEvent in CellImpl class. Its also needed to create a specific cellListener(AutomaticSharingListener), in order to be notifyed and send the changes to the other instance.
 * <p>
 * <b>Note:</b> It is very important that in the final version of this technical documentation the elements depicted in these design diagrams exist in the code!
 * 
 * <h3>5.3. Classes</h3>
 *  - AutomaticSharingListener - CellListener that send the message with the changed values
 * 
 * <h2>7. Integration/Demonstration</h2>
 * 
 * -All the functionalitys were developed. Sergio Oliveira helped to understantand the ipc basic funcionality-
 * 
 * <h2>8. Final Remarks</h2>
 * 
 * <p>
 * 
 * 
 * <h2>9. Work Log</h2> 
 * 
 * -Insert here a log of you daily work. This is in essence the log of your daily standup meetings.-
 * <p>
 * <p>
 * <b>Tuesday</b>
 * <p>
 * <p>
 * Today
 * <p>
 * 1. -Analysis of the issue ipc01_02-
 * <p>
 * Blocking:
 * <p>
 * 1. How to get style Changes
 * <p>
 * <b>Wednesday</b>
 * <p>
 * 
 * <p>
 * 1. -design of the issue ipc_01_02-
 * <p>
 * Blocking:
 * <p>
 * 1. -how to add listeners in a range of cells-
 * <b>Thursday</b>
 * <p>
 * 
 * <p>
 * 1. -im+plementation of the issue ipc_01_02-
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
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
 * - https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/cb9ff19db15b56efb522d79cd9d6ae776e42617b-
 * - https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/9028dd20e92dfa82e6b2c90a2856a47942d5f597-
 * - https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/3c124c03c1fb01ef91f1b23ef8585a3b0757843a-
 * 
 * <h3>10.2. Teamwork: </h3>
 * 
 * <h3>10.3. Technical Documentation: <img src="doc-files/ipc01_02_analysis_adding_cell_listeners.png" alt="image"> <img src="doc-files/ipc01_02_design_firecelllistener_to_livesend.png" alt="image"> </h3>
 * 
 * @author alexandrebraganca
 */

package csheets.worklog.n1060708.sprint3;

/**
 * This class is only here so that javadoc includes the documentation about this EMPTY package! Do not remove this class!
 * 
 * @author alexandrebraganca
 */
class _Dummy_ {}

