/**
 * Technical documentation regarding the work of the team member (1120035) Vitor Mascarenhas Doe during week3. 
 * 
 * <p>
 * <b>Nota:</b>
 * <p>
 * <b>Scrum Master: no</b>
 * 
 * <p>
 * <b>Area Leader: no</b>
 * 
 * <h2>1. Notes</h2>
 * 
 * This week is intended to create a commentaries history, for it will be registered to the author, the date and time, and text formatting styles in addition will be possible to edit a particular comment.
 * <p>
 * 
 *
 * <h2>2. Use Case/Feature: Core02.3 - Rich comments and history</h2>
 * 
 * Issue in Jira: http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-5
 * <p>
 * 
 * <h2>3. Requirement</h2>
 * Search of a piece of text in the existing comments.
 * To edit an existing comment (create new), retaining the original.
 * For each comment created you need to save the user (author) that created it.
 * Save the date and time of creation or editing the comment.
 * Save the style and formatting of comments.
 * 
 * <p>
 * <b>Use Case "Rich comments and history":</b>Interface should display the history of changes to a comment and allow the user to make a new version of a comment based on an old one. It also should have a search feature, allowing the user to search for comments based on text patterns (including the history in the search).
 * 
 * <h2>4. Analysis</h2>
 * To achieve this issue intend to create the following classes:
 * Comment: this class that contains the author attributes where you saved the user name system, the date that this comment will be created, the comment, the font and style.
 * CommentableCell the class existing, to allow storing a set of comments was changed.
 * ﻿SearchCommentController, this class is a controller that has the search function in the comments of a particular cell (selected) if there is a particular string, so is returns all comments that contain it.
 * ﻿EditComment Controller, this class allows you to edit a particular comment making the original is maintained and creating a new one with updated date and keeping the id of the original.
 * ﻿SerchEditCommentPanel this class is prepared for the user to enter text and where the search results are displayed in addition are shown the results (id and id's number of a particular comment).
 * ﻿EditCommentPanel, this class is a graphical interface that allows the user to view data for a comment and let you edit it.
 * 
 * <h3>Analysis of Core Technical Problem</h3>
 * 
 * <p></p>
 * <h2>The sequence diagrma for search comment.</h2>
 * <p></p>
 * 
 * <img src="doc-files/Rich_comments_and_history_SearchComment_Analysis_01.png" alt="Sequence Diagram for search comment for comment">
 * <p></p>
 * <p></p>
 * <h2>The sequence diagrma for edit comments.</h2>
 * 
 * <p></p>
 * <img src="doc-files/Rich_comments_and_history_EditComment_Analysis_01.png" alt="Sequence Diagram for add comments">
 * <p></p>
 * 
 * <p></p>
 * To see the classes diagram
 * <img src="doc-files/CORE02.3-Class_Diagram_final.png" alt="Sequence Diagram for create and search comments">
 * <p></p>
 * 
 * <h2>5. Design</h2>
 *
 * <p>
 * see: <code>csheets.ext.comments.CommentableCellTest</code>
 *
 * <h3>5.2. UC Realization</h3>
 * ﻿Was created Comment class where are included attributes, String comment, String author that is created with the username of the system, CommentDate the date of the comment is a Calendar object and is built with the system time, we also have the font attributes and format which are obtained alert by StylableCell object.
 * <p></p>
 * ﻿In commentableCell object was created a list of Comment objects (List <Comment>) where all comments are stored.
 * <p></p>
 * ﻿This feature was used the existing graphical user interface to implement the search and Commentaries editing, for that were created two "Add" button and "Search and edit", whose function is to add comments (improvement to the previous functionality), for the button " Search and edit "makes it displayed a new panel that will allow the user to search a comment. When you press this button are listed in jlist all comments found in this same panel can be viewed the id's of each comment and the number of comments with the same id.
 * <p></p>
 * ﻿If the user wants to edit a comment simply double click an item in the JList and will be shown a new qonde panel allows the user to see all the same information if you want to change simply enter the desired text and will create a new one with the same text and updated date.
 * <p></p>
 * <b>Note:</b> It is very important that in the final version of this technical documentation the elements depicted in these design diagrams exist in the code!
 * 
 * <h3>User Updates the Comment of a Cell</h3>
 * The following diagram illustrates what happens when the user updates the text of the comment of the current cell. To be noticed that this diagram does not depict the actual selection of a cell (that is illustrated in the previous diagram).
 * <p></p>
 * <p></p>
 * 
 * 
 * <p></p>
 * 
 * 
 * <h2>9. Work Log</h2> 
 * 
 * <p>
 * <b>Monday</b>
 * <p></p>
 * ﻿On Wednesday, I took a pull and sourcetree made a merge after that tried to commit but gave error. merge all mixed code and made it impossible to take something that made had to do it from the beginning.
 * ﻿That night and the next day before the presentation tried to develop the functionality, classes and methods were ready but the GUI was not ready demonstrating the time which meant you had zero in the presentation.
 * <p></p>
 * <b>Evidences:</b>
 * <p>
 * 
 * <h3>10.2. Teamwork: ...</h3>
 * 
 * <h3>10.3. Technical Documentation: ...</h3>
 * 
 * @author VitorMascarenhas
 */

package csheets.worklog.n1120035.sprint3;

/**
 * This class is only here so that javadoc includes the documentation about this EMPTY package! Do not remove this class!
 * 
 * @author Vitor Mascarenhas
 */
class _Dummy_ {}
