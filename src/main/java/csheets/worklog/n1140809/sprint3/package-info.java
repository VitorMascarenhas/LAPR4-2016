/**
 * Technical documentation regarding the work of the team member (1140809) Bernardo Meira during week3.
 *
 * <b>Scrum Master: - no</b>
 * 
 * <p>
 * <b>Area Leader: - Yes</b>
 * 
 * <h2>1. Notes</h2>
 * 
 * -Notes about the week's work.-
 * <p>
 *     In this week some time was spent supporting:
 *     - Pedro Costa (1140806): Knowledge transfer on language modules and classes
 *     - André Oliveira (1140438): Event listening strategies. Assist with file change listening and cell listening
 *
 *     Some design changes where implemented on Core02.1 to include a more Java 8 friendly implementation.
 *
 * <h2>2. Use Case/Feature: Core02.2</h2>
 *
 * Issue in Jira: <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-55">LPFOURNA-55</a>
 * <p>
 *     IPC02.2- Advanced Workbook Search
 *
 *     - The sidebar window that displays the results of the search should now include an area to display a preview of the contents of a workbook when the user selects it (i.e., clicks on it).
 *     The preview should be based on the values of the first non-empty cells of the workbook.
 *     This preview should be produced without open the worksheet (at least without the worksheet been opened in the user interface).
 *     The search should now be based on a pattern and not only on the file name extension.
 *
 * <h2>3. Requirement</h2>
 *
 *     Adjust the implementation of the find mechanism to accept regular expressions instead of a file extension.
 *     Create a preview viewer that displays non-empty cells.
 * <p>
 *
 * <h2>4. Analysis</h2>
 *
 * <b>Use Case "Advanced Search":</b>
 *
 * In this functional increment there where two different target objectives.
 * <p>Firstly, the current code needs to be adjusted to accept regular expressions. Theoretically this doesn't require great changes, but some will be necessary to create a more standardized code style. (See 4.1)
 * <p>Secondly, a preview system needs to be fully implemented. This will be the core of this increment as file preview can involve great amounts of data. As such we must structure a function that minimizes file access and is responsive. (See 4.2)
 *
 * <p>
 *   <img src="doc-files/Regex_Search_Complete.png" alt="image">
 * <p>
 *
 * <h3>4.1 Regex Expressions</h3>
 *
 * <p>In terms of user interaction, the simplest way to increment the previous function, is to simply add a text field to the current user interface where the user can enter de desired regex expression. Upon clicking the search button the application should try to match the directories and files on the root directory to the expression.
 * <p>Focusing on the implementation details, while analysing the current implementation of the {@link csheets.ipc.findworkbooks.ui.FindWorkbooks} class, it was ascertained that the current model was not sustainable and strict implementation details.
 * <p>To be more precise the search algorithm implemented relied too much on the now considered more unreliable {@link java.io.File} class and string comparison methods. To comply to a more standard search algorithm a inner class was created ({@link csheets.ipc.findworkbooks.ui.FindWorkbooks.WorkbookFinder}) that follows the visitor design pattern.
 * This class, which extends the {@link java.nio.file.SimpleFileVisitor} class, makes use of the more reliable java.nio package (namely the {@link java.nio.file.Path}, {@link java.nio.file.FileSystem}, {@link java.nio.file.PathMatcher} and {@link java.nio.file.Files} classes) to recursively compare and match any file name with the inserted pattern.
 *
 *  <p>
 * <pre>
 * {@code
 *  void find(Path file) {
 *      Path name = file.getFileName();
 *      if (name != null && matcher.matches(name) && !Files.isDirectory(file)) {
 *          numMatches++;
 *          workbookFiles.add(file.toFile());
 *      }
 *  }
 * }
 * </pre>
 *
 * <p> Through this method we can see how the result list that is returned to the UI is built. Note that we removed directories from the result set, this is because during the search sub-directories are considered files in a directory by the system and as such their names would be matched against the pattern as well.
 * <p>
 *
 * <h3>4.2 File preview</h3>
 *
 * The main issue with the file preview is the performance aspect. To load a workbook on every single click the user makes is bad for the file system and will have a negative impact on the application.
 *
 * <p>
 *   <img src="doc-files/Find_Workbooks.png" alt="image">
 * <p>
 *
 * <p>The image displays the basic desired flow. To load a file only once, if it was not previewed before, and display the user the information.
 * <p> To accomplish this, instead of building something from the ground up, the best decision would be to take advantage of the previously implemented action system.
 * On the previous increment an open action was required to be executed on double clicking a file ({@link csheets.ui.ctrl.OpenWorkbookAction}), so by taking advantage of the mouse listener that triggers the open action, on a single click the @OpenWorkbookAction#createPreview(File) method is triggered.
 * <p> At this point  if the workbook was not previously loaded it should be loaded now. From observing this action and the {@link csheets.CleanSheets} class it was deduced that the load method was required in different areas of code are access to the {@link csheets.CleanSheets} instance was not always possible.
 * In order to avoid code duplication and give global application access to the workbook loading system, a decision was made to implement the singleton design pattern and create the {@link csheets.io.WorkbookLoader} class. The instance of which will be globally responsible for the execution of the load method.
 * <p> Finally the last analysed requirement is how to store built previews and create them. Since most transaction on a file system level within our application are done via the {@link java.io.File} class, then the most efficient collection would be a pair-value collection like a {@link java.util.HashMap}.
 * The file is already a tested hashed property and it has reusability within our design model, as for the preview a simple string can be constructed via the well received {@link java.lang.StringBuilder} class.
 * This analysis resulted in the following code fragments. Notice that one of the requirements was to ignore empty cells, further more only the initial cells where desired as such the first 50 where selected.
 * <p> The selection of the first 50 cells was not random in design. The team decided that the vague definition of "initial cell" would be well traduced as the selection of the cells in the first 5 rows and 10 columns, due to the statistical likelihood that these will contain information in most created notebooks.
 *
 * <p>
 * <pre>
 * {@code
 *  public String createPreview(File file) {
 *      String preview = this.previewMap.get(file);
 *      if (preview == null || preview.isEmpty())
 *          this.updatePreview(file);
 *      return preview;
 *  }
 *
 *  public String updatePreview(File file) {
 *      String preview;
 *      try {
 *          this.workbook = WorkbookLoader.getInstance().load(file);
 *          StringBuilder builder = new StringBuilder();
 *          if(this.workbook.getSpreadsheetCount() > 0) {
 *              Spreadsheet sheet = this.workbook.getSpreadsheet(0);
 *              for(Cell cell : sheet.getCells(new Address(0,0), new Address(5,10))) {
 *                  String content = cell.getContent();
 *                  if(content != null && !content.isEmpty()) {
 *                      builder.append(cell.getAddress().toString()).append(" -> ").append(content).append("\n");
 *                  }
 *              }
 *         }
 *         if(builder.length() == 0) {
 *          preview = "Empty workbook";
 *         } else {
 *          preview = builder.toString();
 *         }
 *     } catch (IOException | ClassNotFoundException e) {
 *      preview = "Not a valid workbook file";
 *     }
 *
 *     this.previewMap.put(file, preview);
 *     return preview;
 *  }
 *}
 * </pre>
 *
 * <h2>5. Design</h2>
 *
 * <h3>5.1. Functional Tests</h3>
 *  <p>There where no real new functions in this increment. The search was simply broaden to accept a pattern. But since this was done through previously test classes (such as the {@link java.nio.file.PathMatcher} and the {@link java.nio.file.FileSystem} classes. @see <a href="https://docs.oracle.com/javase/tutorial/essential/regex/matcher.html">here</a>) the only thing done was to fix and all the tests already extensively implemented in the FindWorkbooksTest class.
 *  <p>There should have been some basic tests for the preview method but time constraints did not allow for it, and it was more valuable to maintain the already implemented tests.
 * <p>
 * see: <code>csheets.ipc.findworkbooks.ui.FindWorkbooksTest</code>
 *
 * <h3>5.2. UC Realization</h3>
 * To realize this user story we had to reimplement the {@link csheets.ipc.findworkbooks.ui.FindWorkbooks}#run method (threadable search).
 * This will make use of a recursive search inner class ({@link csheets.ipc.findworkbooks.ui.FindWorkbooks.WorkbookFinder}) which will extend a class implementing the visitor design pattern.
 * A single click verification needs to be added to the listener in the find workbooks UI.
 * Finally a method needs to be constructed to load a workbook if it has not been previewed and to construct its preview string.
 *
 * <p>
 *   <img src="doc-files/Find_Workbooks.png" alt="image">
 * <p>Create_Preview.png
 *
 * <p>
 *   <img src="doc-files/Create_Preview.png" alt="image">
 * <p>
 *
 * <h3>5.4. Design Patterns and Best Practices</h3>
 *
 * Visitor ({@link csheets.ipc.findworkbooks.ui.FindWorkbooks.WorkbookFinder})
 * Observer ({@link csheets.ipc.findworkbooks.ui.FindWorkbooks})
 * Thread pool
 * Singleton ({@link csheets.io.WorkbookLoader})
 *
 * <h2>6. Implementation</h2>
 * <p>
 * see:<p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/f24cc6866b57a6a92373b3dc9e0e072df0dcfbda">Implementation of regex and preview UI</a><p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/5e1936df012ef5e126058db0004b50f7a813b5c2">Implementation of preview</a><p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/c6464fa02432f0152e6a049b02f54593da10dc1c">Documentation start</a><p>
 *
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/13deeb254dae10a7622e465b841a8ccc503cbfc8">Build problems fix</a><p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/ac49749393d5af78c45d00e58398d7358eb8b584">Build problems fix</a><p>
 *
 * <h2>7. Integration/Demonstration</h2>
 *
 * During this sprint the rest of the week2 sorting code that was not integrated in to the stable demo jar was migrated. Some build issues due to inconsistent tests where tended to and solved.
 * Aided the scrum master in generating a stable build.
 *
 * <h2>8. Final Remarks</h2>
 *
 * The preview should be listening to file changes to be updated (Note: the next functional increment deals with this improvement).
 *
 * @author 1140809
 */

package csheets.worklog.n1140809.sprint3;

/**
 * This class is only here so that javadoc includes the documentation about this EMPTY package! Do not remove this class!
 * 
 * @author 1140809
 */
class _Dummy_ {}

