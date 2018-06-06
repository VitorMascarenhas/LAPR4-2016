/**
 * Technical documentation regarding the work of the team member (1140809) Bernardo Meira during week2.
 *
 * <b>Scrum Master: - no</b>
 * 
 * <p>
 * <b>Area Leader: - no</b>
 * 
 * <h2>1. Notes</h2>
 * 
 * -Notes about the week's work.-
 * <p>
 *     In this week some time was spent supporting:
 *     - Pedro Costa (1140806): debugging issues with data base procedures,
 *     - André Oliveira (1140438):  Externalizing property files so that the user would have a personalized property,
 *     but the system maintains the default file included in the jar.
 *
 *     Sometime was given for knowledge transfer of Language issue 01.1.
 *
 *     Work done on Core issue 03.1 this week greatly moved towards completion Core issue 03.2 (requires only date testing
 *     and UI immprovements).
 *
 * <h2>2. Use Case/Feature: Core03.1</h2>
 *
 * Issue in Jira: <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-6">LPFOURNA-6</a>
 * <p>
 *     Core03.1- Column Sort
 *
 *     - Sort the contents of a column of cells. It should be possible to select the order: ascending or descending.
 *     The interaction with the user can be based solely on menu options. It should be possible to sort columns with
 *     numeric and/or text contents.
 *
 * <h2>3. Requirement</h2>
 *
 *     Implement a method to select a column. Include a menu to select sorting preferences. Sort cells with numeric and
 *     text content.
 * <p>
 *
 *
 * <h2>4. Analysis</h2>
 *
 * <b>Use Case "Sort Column":</b>
 *
 * Free range was given on how to implement user interaction, but since menus where suggested and would help further along the feature then a study of the action/menu system was required.
 * The analysis, design and implementation of this feature increment should be divided into two different objectives.
 *  1. The selection of a column
 *  2. The sorting of a group of cells
 *
 *
 * <h3>4.1 Selection of a Column</h3>
 * <p>
 *   <img src="doc-files/Select_Column.png" alt="image">
 * <p>
 *
 *  The purpose of the image above is to illustrate the idea of the simplicity that this part should have. The user should not be required to go to any great lengths to select a column.
 *  As such the preferred method should be the traditional double click on the desired column. To answer this request the cell selection process was analysed.
 *
 *  From the analysis of the {@link csheets.ui.sheet.SpreadsheetTable} class it was concluded that a new mouse event should be implemented on {@link csheets.ui.grid.RowHeader}.
 *  For this purpose and to centralize the row header events a new class should be added {@link csheets.ui.ctrl.HeaderActionHandler}. Within this new handler a double left click mouse event which takes advantage of SpreadsheetTable#changeSelection(int, int, boolean, boolean) should be implemented.
 *
 * <p>
 * <pre>
 * {@code
 * public void changeSelection(int row, int column, boolean toggle, boolean extend) {
 *  super.changeSelection(row, column, toggle, extend);
 *  if (!extend)
 *      uiController.setActiveCell(getSelectedCell());
 * }
 * </pre>
 *
 * <h3>4.2 Sorting a group of cells</h3>
 *
 *  In this part two issues arise. Firstly, how to generalize implementation as to be flexible enough to be used in different scenarios and future increments. And lastly which sorting algorithm to use as to not impact performance.
 *
 * <p>
 *   <img src="doc-files/Sort_Action.png" alt="image">
 * <p>
 *
 *  The image displays the basic intended sequence of events. A right click event on the {@link csheets.ui.sheet.SpreadsheetTable} area should show a popup menu. This way we have access to the action system directly from our selection area.
 *  After the sort action is chosen the user should be presented with the available sorting options (ascending and descending in this increment).
 *
 *  Since no right-click menu exists currently, a new class would be needed to represent this menu. Although this make sense, this class was not explicitly created.
 *  The popup menu should be triggered and controlled by mouse events. No only this but it can have varying implementations on these events depending on the selection area. As well as different activated actions.
 *  For these reason a inner class SubMenu was planned within {@link csheets.ui.PopupHandler}. The latter in turn would act as a base abstract handler class to control the basic right-click menu options and create the menu itself.
 *
 *  Upon analysing {@link csheets.core.Value} class, it is observable that the comparison of different types is already implemented. As such all the is required is a comparator which takes into account the user preferred sorting option.
 *  To fully represent the sorting options an enumerator {@link csheets.ui.enums.SortOption} was added, which includes a description to be used throughout the application. To answer the comparator issue a {@link csheets.ui.ctrl.SortOptionComparator} was added which will deal with sorting priorities within the user option.
 *
 *  Lastly the performance issue. Several sorting algorithms were considered, and the three best choice were: the merge sort, a variation on the radix sort, and the java pre defined sort within the {@link java.util.Arrays} class.
 *  The radix sort initially seems as the best option given it's low complexity of O(nk) in the best and worst case scenarios. But, it needed to be redesigned to function with different cell contents and threading should be included for performance.
 *  Since we are time constrained this option lost validity. As such the best choice would be the pre implemented sort withing the {@link java.util.Arrays} class. This class has the Arrays#parallelSort(T[], Comparator<T>) which internally handles threading and efficient concurrent sorting.
 * <p>
 *
 * <h2>5. Design</h2>
 *
 * <h3>5.1. Functional Tests</h3>
 *  From the previous analysis the minimum required tests should reflect on the column selection and sorting result. To this end the {@link csheets.ui.ctrl.SortOptionComparator}, {@link csheets.ui.ctrl.HeaderActionHandler } and {@link csheets.ui.ctrl.SortAction} classes should be tested.
 *
 * <p>
 * see: <code>csheets.ui.ctrl.SortOptionComparatorTest</code>
 * <p>
 *   <img src="doc-files/SortOptionComparatorCoverage.png" alt="image">
 * <p>
 *
 * <p>
 * see: <code>csheets.ui.ctrl.HeadearActionHandlerTest</code> (Incomplete)

 * <p>
 * see: <code>csheets.ui.ctrl.SortActionTest</code> (Incomplete)
 *
 * <h3>5.2. UC Realization</h3>
 * To realize this user story we will need to create a handler for the row header which extends MouseAdapter for the column selection.
 * We will also need to implement the SortAction, a new SortOption enumerator and a SortOptionComparator for the cell sorting.
 * Lastly a PopupHandler which extends MouseAdapter is needed to control the basic implementation and actions of the right-click menu.
 * The following diagrams illustrate core aspects of the design of the solution for this use case.
 *
 * <h3>Column Selection</h3>
 * The following diagram shows the collumn selection process implemented in the row header.
 * <p>
 * <img src="doc-files/Column_Selection.png" alt="image">
 *
 * <h3>User Selects Sort Action</h3>
 * The following diagram illustrates hoe the user selects the sorting action.
 * <p>
 * <img src="doc-files/Sort.png" alt="image">
 *
 * <h3>5.3. Classes</h3>
 *
 * -Document the implementation with class diagrams illustrating the new and the modified classes-
 *
 * <h3>5.4. Design Patterns and Best Practices</h3>
 *
 * Thread pool: in the parallel sort algorithm.
 * Adapter: The PopupHandler and HeaderActionHandler are meant as adapters (extension of the mouse adapter) of the behaviour of mouse events.
 * Strategy: The strategy pattern was considered in the design of the PopupHandler class and it resulted in the SpreadSheetPopupHandler class. This pattern was not fully implemented
 * as it was not deemed necessary by the core team at the time. All was prepared in case of future implementation as the only thing missing is the strategy interface.
 *
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
 * As to not risk the stable version close to the demonstrations, this increment was not included. But it was considered complete and integrated immediately after the demonstration.
 * In terms of active integration contributions, I assisted in the correction of tests that where preventing the build completion.
 *
 * <h2>8. Final Remarks</h2>
 *
 * The implemented solution fully implements the basic requirements to solve the following increment: Core 03.2. The only thing missing is and improvement on the sort options menu and running exploratory tests on the date sort.
 * The only improvement that could be considered is the study of the sorting algorithm chosen and implement our own for better efficiency.
 *
 * <h2>9. Work Log</h2>
 *
 * -Insert here a log of you daily work. This is in essence the log of your daily standup meetings.-
 * <p>
 * Example
 * <p>
 * <b>Monday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. -nothing-
 * <p>
 * Today
 * <p>
 * 1. Analysis of the cell selection process.
 * 2. Analysis of the action system.
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 * <p>
 * <b>Tuesday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. Identified all required methods for column selection.
 * 2. Studied the action system, in particular the existing sort action.
 * <p>
 * Today
 * <p>
 * 1. Design of the cell selection process.
 * 2. Design of the sort action.
 * <p>
 * Blocking:
 * <p>
 * 1. ...
 * <b>Wednesday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. Designed the column selection
 * <p>
 * Today
 * <p>
 * 1. Design of the sort action.
 * <p>
 * Blocking:
 * <p>
 * 1. How to fully generalize the system as too be reusable in future increments.
 * <p>
 * <b>Thursday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. Designed a fully adaptable right-click menu.
 * 2. Completed the sort action design,
 * <p>
 * Today
 * <p>
 * 1. Implement column selection.
 * 2. Implement sort action.
 * <p>
 *
 * <b>Friday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. Full increment implementation
 * <p>
 * Today
 * <p>
 * 1. Testing
 * 2. Documentation
 * <p>
 * <b>Tuesday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. Testing
 * <p>
 * Today
 * <p>
 * 1. Documentation
 * <p>
 * Blocking:
 * <p>
 * 1. UI unit testing
 * 
 * @author 1140809
 */

package csheets.worklog.n1140809.sprint2;

/**
 * This class is only here so that javadoc includes the documentation about this EMPTY package! Do not remove this class!
 * 
 * @author 1140809
 */
class _Dummy_ {}

