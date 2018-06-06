/**
 * Technical documentation regarding the work of the team member (1140806) Pedro Costa during week4.
 *
 * <p>
 * <b>Scrum Master: no</b>
 * </p>
 * <p>
 * <b>Area Leader: no</b>
 * <p>
 *
 * <h2>IPC02.3) Multiple Realtime Workbook Searc</h2>
 *
 * <p>
 * Issue in JIRA: <a>http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-56</a>
 * </p>
 *
 * <h2>3. Requirements</h2>
 *
 * <b>Support for several search windows at same time. A panel with many tabs can be implemented to show all searches.</b>
 *  <ul>
 *      <li>Each search window should have an option, for instance a check button, to indicate if the search is an active search;</li>
 *      <li>An active search will be a search that keeps updating the contents of the list that displays the results;</li>
 *      <li>The preview for each file should now be cached so that Cleansheets only produces the preview the first time the user request it or when the contents of the file change.</li>
 *  </ul>
 * </br></br>
 * <b>Uses Cases</b></br>
 *
 * </br><b>A) User makes a search</b></br>
 *
 * </br>
 * 1. The user click in "new search" button from Find WorkBooks Extension Panel.</br>
 * 2. The user writes path and regular expression of the files to find.</br>
 * 3. The system makes the search and display results.</br>
 * 4. The user click in one of the results.</br>
 * 5. The system display preview.</br>
 * 6. The user set the active option to true.</br>
 * 7. The system keeps updating preview if detect a change on files.</br>
 * </br>
 * </br><img src="doc-files/ssd.png" alt="SSD Use case"></br>
 * </br>
 *
 * <h2>4. Analysis</h2>
 *
 * <p>To accomplish the requirements we need to add an option that let user start many searches at same time.
 * The user should be capable to do that in same window extension.</p>
 * <p>Each search should run in new thread due to performance issues.</p>
 * <p>To activate and deactivate preview updating is necessary to add a checkbox.</p>
 *
 * <h2>5. Design</h2>
 *
 * <h3>New Search Panel</h3>
 * <p>Creation of New Search Panel: Each search panel lives in Extension Window and let user make a search.
 * User can have as many searches running and active as pretend.</p>
 * </br><img src="doc-files/NewSearchPanel.png" alt="new search panel"></br></br></br>
 *
 * <h3>New Search</h3>
 * <p>When user click in find workbooks button we start the search.</p>
 * </br><img src="doc-files/newSearch.png" alt="new search"></br></br></br>
 *
 * <h3>Start watching files</h3>
 * <p>When user set the checkbox "Active" to true the app start watching the file.</p>
 * </br><img src="doc-files/startWatch.png" alt="startWatch"></br></br></br>
 *
 * <h2>6. Test Packages</h2>
 * <p>
 * {@link csheets.ipc.findworkbooks.ui} </br>
 * {@link csheets.ui.ctrl}
 * </p>
 *
 * <p>
 * </p>
 * <h2>7. Work Log</h2>
 *
 *  IMPORTANT NOTES:
 *          </br>- Daily scrum has been made at last class of each day.
 *          </br>- A part of the time of this sprint was spent refractoring code of this feature.
 *
 * <p>
 * <b>Friday - 17 of June</b></br>
 * Requirements Analysis;</br>
 * knowledge transfer from previous IPC developer: Bernardo Meira (1140809);
 * <p>
 * <b>Saturday - 18 of June</b></br>
 * Current code check and analysis;</br>
 * <p>
 * <b>Sunday -  19 of June</b></br>
 * Design;</br>
 * <p>
 * <b>Monday -  20 of June</b></br>
 * Tests and Implementation;</br>
 * Daily Scrum;</br>
 * <p>
 * <b>Tuesday -  21 of June</b></br>
 * Tests and implementation;</br>
 * Daily Scrum;</br>
 * <p>
 * <b>Wednesday - 22 of June</b></br>
 * Finished of implementation;</br>
 * Daily Scrum;</br>
 * <p>
 *
 * <h2>8. Team work</h2></br>
 * <ul>
 *  <li>
 *  Description: Transmission of knowledge to José Vilela (1010500)</br>
 *  Task name: CRM01.3- Contacts with Tags - knowledge transmission</br>
 *  Link to task: <a>http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-258</a></br>
 *  </li>
 *  </br>
 *  <li>
 *  Description: ANTLRWORKS Support to André Oliveira (1140438)</br>
 *  Task name: ANTLRWORKS Support</br>
 *  Link to task: <a>http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-253</a></br>
 *  </li>
 * </ul>
 * <p>
 * <h2>9. Evidences of Work</h2></br>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/0031043b7a780941e562338da8c20d5639bdfcf0">Commit Analysis 1</a>
 * <p>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/578dd35186f078b79defcd3400a09973dc811eba">Commit Analysis 2</a>
 * <p>
 *
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/64393c0ce5503f6c6299a6d6547824a6b2b20ef8">Commit implementation 1</a>
 * <p>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/f8fb59f6f52e0e9ca8dd57f0c3a46af56e120bc9">Commit implementation 2</a>
 * <p>
 *
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/44fe57b8cb070574c10682f8857f5ae0d0615e6c">Commit implementation 3</a>
 * <p>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/abcc0f1c7cf63c965d31d5901b4b88605e86fa01">Commit Tests 1</a>
 * <p>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/7544baf5a2f6c9041d25e650a2c313c31eff20d0">Commit Tests 2</a>
 * <p>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/3e40fca2288a5b8eb7fb457492717ef429ad3587">Commit Tests 3</a>
 * <p>
 * <div>
 * <h3>10. Screen shoots of the results</h3>
 * <h4>Before</h4>
 * </br>
 * <img src="doc-files/before.png" alt="Screen shoot before 1">
 * <img src="doc-files/before2.png" alt="Screen shoot before 2">
 * </br>
 * <h4>
 *     After
 * </h4>
 * </br>
 * <img src="doc-files/after.png" alt="Screen shoot after 1">
 * <img src="doc-files/after2.png" alt="Screen shoot after 2">
 * </br>
 * </div>
 *
 * <h2>Identified Bugs</h2>
 *
 * <i>Nothing to report</i>
 *
 * @author Pedro Costa
 */

package csheets.worklog.n1140806.sprint4;

/**
 * This class is only here so that javadoc includes the documentation about this EMPTY package! Do not remove this class!
 *
 * @author alexandrebraganca
 */
class _Dummy_ {}
