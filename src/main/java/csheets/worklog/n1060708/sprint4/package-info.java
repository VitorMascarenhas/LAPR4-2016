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
 * -Analysis, Design, Tests and Implementation of Core06.1 issue-
 * <p>
 * -In this section you should register important notes regarding your work during the week.
 * For instance, if you spend significant time helping a colleague or if you work in more than a feature.-
 *
 * <h2>2. Use Case/Feature: Core06.1</h2>
 * 
 * Issue in Jira: http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-15
 * <p>
 * Core06.1- Insert Image
 * 
 * <h2>3. Requirement</h2>
 * 
 *The extension should include an option to insert an image. 
 *The inserted image should become associated with the active/selected cell. 
 *It should also exist a new sidebar window to display the images that are associated with the current cell (in a manner similar to how comments work).
 *A cell can have several associated images.
 *The sidebar should have an option (button) to remove/delete images. 
 *The workbook should only save links to the files that contain the images.
 * 
 * <p>
 * <b>Use Case "Insert Image":</b> The extension should include an option to insert an image. The inserted image should become associated with the active/selected cell. It should also exist a new sidebar window to display the images that are associated with the current cell (in a manner similar to how comments work). A cell can have several associated images. The sidebar should have an option (button) to remove/delete images. The workbook should only save links to the files that contain the images.
 * 
 *  
 * <h2>4. Analysis</h2>
 * Need to know how to have images associated with a cell. How to call the sidebar. how to garantee that the image is saved when a document is saved
 *
 * 
 * 
 * <h3>First "analysis" diagram</h3>
 * <p>
 * <img src="doc-files/core06_01_analysis.png" alt="image"> 
 * <p>
 * 
 * <h3>Design of how to get the sidebar</h3>
 * 
 * <p>
 * In the next diagram we can see how it is implemented to get the sideBar
 * <p>
 * <img src="doc-files/core06_01_design_getSideBar.png" alt="image"/>
 * 
 * <p>In the next diagram we can see how its implemented to set an image</p>
 * <img src="doc-files/core06_01_design_setImage.png" alt="image"> 
 * <p>
 * In this sample of code its a sample of the process of adding an image
 * <pre>
 * {@code 
 *       public void setImage(ImageableCell cell){
 *       if (cell.hasImage()) {
 *           DefaultListModel<String> lstModel = new DefaultListModel<>();
 *           for(String s : cell.returnAllImages()){
 *               lstModel.addElement(s);
 *           }
 *           
 *           updateList(lstModel);
 *           
 *           if(cell.returnAllImages().size() != 0 ){
 *               updateImage(cell.returnAllImages().get(0).toString());
 *           }else{
 *               updateImage(ImagesPanel.DEFAULT_IMG);
 *           }
 *       
 *       } else {
 *           listModelImagesPath.removeAll();
 *           iconLabel.removeAll();
 *       }
 *   }
 * </pre>
 * <h2>5. Design</h2>
 *
 *
 * <h3>5.1. Functional Tests</h3>
 * Implented ImageableCell's testes.
 * <p>
 * see: <code>csheets.ext.images.ImageableCellTest</code>
 *
 * <h3>5.2. UC Realization</h3>
 * To realize this user story it's needed to implement an sidebar, that can save, display, and remove images.
 * <p>
 * <b>Note:</b> It is very important that in the final version of this technical documentation the elements depicted in these design diagrams exist in the code!
 * 
 * <h3>5.3. Classes</h3>
 *  - ImageableCellListener - CellListener that notifys an ImgeableCell change.
 *  - ImagesExtension - The extension.
 *  - ImagesController - The controller
 *  - ImagesPanel - The sidePanel that allows to insert/remove and display, one or more images
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
 * 1. -Analysis of the issue core_06_01-
 * <p>
 * Blocking:
 * <p>
 * 1. How to set an image
 * <p>
 * <b>Wednesday</b>
 * <p>
 * 
 * <p>
 * 1. -design of the issue core_06_01-
 * <p>
 * Blocking:
 * <p>
 * 1. -How to display the sideBar-
 * 2. - How to add an image.
 * 3. - How to display an image
 * <b>Thursday</b>
 * <p>
 * 
 * <p>
 * 1. -implementation of the issue core_06_01-
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
 * - https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/8466b89bf4e9bf761a4a697b8500f3362a798d47-
 * - https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/c6134d5ecf6e0cbf14ed5193cac00e90ddde671a-
 * - https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/747053b6587da90371fd0b4ff752cdead9b1f91a-
 * - https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/e6058be74d847e4792d838207b54ba4769b53b6c-
 * - https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/40bac1fdfb3aea6f8190cf3ffbe3a36cd97b53a6-
 * - https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/491402e7ffd5e97418d0d3e7e6d59aebcbe54b09-
 
 * <h3>10.2. Teamwork: </h3>
 * <h3>10.3. Technical Documentation: <img src="doc-files/ipc01_02_analysis_adding_cell_listeners.png" alt="image"> <img src="" alt="image"> </h3>
 * 
 * @author alexandrebraganca
 */

package csheets.worklog.n1060708.sprint4;

/**
 * This class is only here so that javadoc includes the documentation about this EMPTY package! Do not remove this class!
 * 
 * @author alexandrebraganca
 */
class _Dummy_ {}

