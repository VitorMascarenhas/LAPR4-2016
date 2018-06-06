/**
 * Technical documentation regarding the work of the team member (1121060) Sérgio Oliveira during week3.
 *
 * <p>
 * <p>
 * <b>Scrum Master: -(yes/no)- yes</b>
 *
 * <p>
 * <b>Area Leader: -(yes/no)- yes</b>
 *
 * <h2>1. Notes</h2>
 *
 *
 * <p>
 *
 * This week I spent most of my time helping my colleagues on Core02.3, IPC05.2
 * and IPC01.2
 *
 * <h2>2. Use Case/Feature: Core03.2- Sort Range of Cells</h2>
 *
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-7">Core03.2- Sort
 * Range of Cells</a>
 * <p>
 * Sort a range of cells. A range of cells is a rectangular area delimited by an
 * upper left corner and a lower right corner. The sorting is based on a column
 * of the range. It should be possible to select the order: ascending or
 * descending. Interaction with the user should be based on a popup menu. It
 * should be possible to sort data of the following types: numeric, text or
 * date.
 *
 * <h2>3. Requirement</h2>
 *
 * The user should be able to select a range of cells. After the selection the
 * user should invoke a popup menu with the sort actions. One of this actions
 * should be a "Sort range" option. When selected, a dialog should be shown to
 * ask the user which column should the sort be based on. The user should select
 * the sorting direction.
 *
 *
 * <h2>4. Analysis</h2>
 *
 * <h3>Select a range of cells and sort</h3>
 * The following diagram depicts a proposal for the realization of the
 * previously described use case. The user selects a range of cells and then
 * select the action for custom sorting from the popup menu.
 * <p>
 * <img src="doc-files/core03_02_analysis_sort_range_cells.png" alt="image">
 * <p>
 *
 *
 * <h2>5. Design</h2>
 *
 * <h3>5.1. Functional Tests</h3>
 * From the requirements we see that the core functionality of this use case is
 * to sort a range of cells based on the values of the selected column.
 *
 * <p>
 * see: <code>csheets.ui.ext.CellRangeSortTest</code>
 *
 * <h3>5.2. UC Realization</h3>
 *
 * <img src="doc-files/core03_02_design_01.png" alt="image">
 *
 * <h3>5.3. Classes</h3>
 *
 * <img src="doc-files/core03_2_classDiagram.png" alt="image">
 *
 *
 * <h2>6. Implementation</h2>
 *
 * -Reference the code elements that where updated or added-
 * <p>
 * -Also refer all other artifacts that are related to the implementation and
 * where used in this issue. As far as possible you should use links to the
 * commits of your work-
 * <p>
 * see:
 * <p>
 * <a href="../../../../csheets/ui/package-summary.html">csheets.ui</a><p>
 * <a href="../../../../csheets/ui/ctrl/package-summary.html">csheets.ui.ctrl</a><p>
 * <a href="../../../../csheets/ui/ext/package-summary.html">csheets.ui.ext</a><p>
 *
 * Commits see the section Development in all subtasks of
 * <a href ="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-7">Core03.2- Sort
 * Range of Cells</a>
 *
 * <h2>7. Integration/Demonstration</h2>
 *
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
 * Yesterday I worked on:
 * <p>
 * 1. -nothing-
 * <p>
 * Today
 * <p>
 * 1. Help on IPC05.2
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 * <p>
 * <b>Tuesday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. Helped on ICP05.2
 * <p>
 * Today
 * <p>
 * 1. Help on Core02.3
 * 2. Help on IPC05.2
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 * <p>
 * <b>Wednesday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. Helped on Core02.3
 * <p>
 * Today
 * <p>
 * 1. Help on IPC01.2 2. Analysis and implementation of Core03.2
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 *
 * <h2>10. Self Assessment</h2>
 *
 *
 * <h3>10.1. Design and Implementation:3</h3>
 *
 *
 * <p>
 * <b>Evidences:</b>
 * <p>
 * I assumed the implementation of core03.1 also handled all the necessary
 * requirements of core03.2. With that thought in mind, I've dedicated most of
 * my time helping my colleagues. On the day of the presentation, I realized
 * that there was work missing to complete the features for core03.2 I've
 * implemented that work on Sunday to be reevaluated on the next Tuesday.
 *
 * see subtasks of <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-7">Core03.2- Sort Range of Cells</a>
 *
 * <h3>10.2. Teamwork: ...</h3>
 *
 * <h3>10.3. Technical Documentation: ...</h3>
 *
 * @author Sérgio Oliveira
 */
package csheets.worklog.n1121060.sprint3;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author alexandrebraganca
 */
//class _Dummy_ {}

