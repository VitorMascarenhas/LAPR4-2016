/**
 * Technical documentation regarding the work of the team member (1010500) José Vilela during week4. 
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
 * <h2>2. Use Case/Feature: CRM01.03</h2>
 * 
 * Issue in Jira: 
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-77" >CRM01.3- Contacts with Tags</a>
 * 
 * <h2>3. Requirement</h2>
 * <p>
 * It should be possible to associated tags to contacts (individual or company contacts). 
 * A tag is simple an alphanumeric word. Cleansheets should have a window to search 
 * contacts based on tags. The search should be based on regular expressions related to tags. 
 * Cleansheets should display the search results in a list. The user may click 
 * on an item of the list to edit the corresponding contact. There should also 
 * be a window with a list of tags that is automatically sorted (descending) based 
 * on the frequency of the tag utilization. The list should display in each 
 * line the tag and its frequency.
 * </p>
 * 
 * <b>Use Case "Search contacts based on tags":</b> 
 * <p>1.The User select searchContatcTags in view->sidebars.</p>
 * <p>2.The User enters a expression to search in tags</p>
 * <p>3.The system displays a list of contacts that match the user search.</p>
 * <p>4.The User select a contact to edit</p>
 * <p>5.The System displays the current contact data</p>
 * <p>6.The User enter new data and confirm</p>
 * <p>7.The System inform about the operation sucess</p>
 * <p>The User repeats 4-7 until indicates done</p>
 * 
 * <img src="doc-files/crm01_03_req1.png" alt="SSD_Req1"> 
 * <p>
 * 
 * <b>Use Case "Add Tag":</b> 
 * <p>1.The User select ListTags in view->sidebars.</p>
 * <p>2.The system displays a list of tags sorted by frequency.</p>
 * <p>3.The User enter a new tag and select a "create tag" button</p>
 * <p>4.The System inform about the operation sucess</p>
 * <p>The User repeats 3-4 until indicates done</p>
 * 
 * <img src="doc-files/crm01_03_req2.png" alt="SSD_Req2"> 
 * <p>
 * 
 * <b>Refine Use Case "Create contact" from CRM01_01:</b> 
 * <p>1.The User open new contact window.</p>
 * <p>2.The User insert firt and last name.</p>
 * <b><p>3.The System list all tags avaliable</p>
 * <p>4.The User associate tag</p>
 * <p>The User repeats 3-4 until indicates done</p></b>
 * <p>5.The System list all profession avaliable</p>
 * <p>6.The User select profession</p>
 * <p>7.The System list all company contacts</p>
 * <p>8.The User select company contact</p>
 * <p>9.The User Confirm creation of contact</p>
 * <p>10.The System inform User about success of operation</p>
 * 
 * <img src="doc-files/crm01_03_req3.png" alt="SSD_Req3"> 
 * <p>
 * 
 * <h2>4. Analysis</h2>
 * 
 * 
 * <h3>Analysis of Core Technical Problem</h3>
 * 
 * 
 * 
 * 
 * <h2>5. Design</h2>
 * 
 * <h3>5.1. Functional Tests</h3>
 *
 * <p>Other manual tests were implemented.</p> 
 * 
 * <p>Unit Texts:</p>
 * see: <code>csheets.ext.contacts.domain.tags.TagTest</code>
 * 
 * <h3>5.. Sequence Diagram</h3>
 * 
 * <h3>UCR - Add Tag to Repository</h3>
 * 
 * <img src="doc-files/crm01_03_design01.png" alt="design 1">
 * 
 * <h3>UCR - Search Contacts By Tags</h3>
 * 
 * <img src="doc-files/crm01_03_design02.png" alt="design 2">
 * 
 * <h3>5.4. Classes</h3>
 * 
* <img src="doc-files/crm01_03_classDiagram.png" alt="SSD_ClassDiagram"> 
 * 
 * <h2>6. Implementation</h2>
 * commits of my work:<p>
 
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/dc73f8936c9bbca50410d88d2d415f9f341c207c">implementation start</a><p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/77192d56cf6f2d5170d4417d2706bfb4668baa7f">implementation - add/remove tags from contacts</a><p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/5fca9a6f21cbca29777ceca02f7fa10aa4a8a440">implementation - add sidebar with list of tags</a><p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/8ab25c52820ab0fc3c2642172228e9fc3070f5d5">minor fix</a><p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/61259ded01d936dbd7025f928bba2dec2c5106de">implementation - ListTags Sorted by frequency</a><p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/cc332af43de9613be3b1f81231d7c308e97290df">implementation - Search Contacts by Tags</a><p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/1e9716a2f4c2378cb0685e2437e23d507815e59a">technical documentation</a><p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/2d131c20b63d56429eeac104716111efd10e1260">design - class diagram and technical documentation</a><p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/7dd312ca91ce32c8bea8cfde9d9e5a7a43ba1782">design - sequence diagram</a><p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/b16a6935145d9d63366eb4d13612df10a4324918">design - sequence diagram</a><p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/ae88d9222f10e87963fbdd76001002eb1db8aaab">Unit tests</a><p>
 * 
 *  * see:<p>
 * <a href="../../../../csheets/persistence/jpa/tags/JpaTagsRepository.java">csheets.persistence.jpa.tags</a><p>
 * 
 * <a href="../../../../csheets/ext/contacts/package-summary.html">csheets.ext.contacts</a><p>
 * 
 * <a href="../../../../csheets/ext/contacts/controller/package-summary.html">csheets.ext.contacts.controller</a><p>
 * 
 * <a href="../../../../csheets/ext/contacts/domain/tags/package-summary.html">csheets.ext.contacts.domain.tags</a><p>
 * 
 * <a href="../../../../csheets/ext/contacts/ui/package-summary.html">csheets.ext.contacts.ui</a><p>
 * 
 * <p>
 * <h2>7. Integration/Demonstration</h2>
 * 
 * I tried to integrate the new code into existing software as smooth as possible.<p>
 * I used / reused the maximum of elements that could , including classes, interfaces and icons.
 * 
 * <h2>8. Final Remarks</h2>
 * 
 * <p>
 * 
 * <h2>9. Work Log</h2> 
 * 
 * <b>Tuesday</b>
 * <p>
 * Yesterday I worked on: 
 * <p>
 * <p>1. Nothing</p>
 * <p>
 * Today
 * <p>
 * <p>1. plan the work for the rest of the week</p>
 * <p>2. complete analysys</p>
 * <p>3. start design</p>
 * 3.
 * <p>
 * Blocking:
 * <p>
 * 1. nothing
 * <p>
 * <b>Wednesday</b>
 * <p>
 * Yesterday I worked on: 
 * <p>
 * <p>1. plan the work for the rest of the week</p>
 * <p>2. complete analysys</p>
 * <p>
 * Today
 * <p>
 * 1. implementation - add/remove tags from contacts<p>
 * 2. implementation - add sidebar with list of tags<p>
 * 3. implementation - ListTags Sorted by frequency<p>
 * 4. implementation - Search Contacts by Tags<p>
 * <p>
 * Blocking:
 * <p>
 * 1. can´t edit companyContact (problem of requirement CRM01_02)
 * because of late identification of that problem i couldn't add tags to companyContacts
 * 2. despite getting persist the data , I could not update the UI automatically, i don't know why yet.
 * <p>
 * <b>Thursday</b>
 * <p>
 * Yesterday I worked on: 
 * <p>
 * 1.implementation - add/remove tags from contacts<p>
 * 2.implementation - add sidebar with list of tags<p>
 * 3.implementation - ListTags Sorted by frequency <p>
 * 4.implementation - Search Contacts by Tags  <p>
 * <p>
 * Today
 * <p>
 * 1. design of solution<p>
 * 2. complete implementation<p>
 * 3. unit testing<p>
 * 4. technical documentation<p>
 * <p>
 * Blocking:
 * <p>
 * 1. 
 * <p>
 * <b>Friday</b>
 * <p>
 * Yesterday I worked on: 
 * <p>
 * 1. <p>
 * 2. <p>
 * 3. <p>
 * 4. <p> 
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

package csheets.worklog.n1010500.sprint4;
class _Dummy_ {}