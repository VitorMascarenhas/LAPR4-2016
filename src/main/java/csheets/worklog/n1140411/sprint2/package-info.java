/**
 * Technical documentation regarding the work of the team member (1140411) Sara Ramos during week2. 
 * 
 * <p>
 * <b>Scrum Master: -(yes/no)- no</b>
 * 
 * <p>
 * <b>Area Leader: -(yes/no)- no</b>
 * 
 * <h2>1. Notes</h2>
 * 
 * <h2>2. Use Case/Feature: Core02.2</h2>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-4">Issue in Jira</a>
 *
 * <h2>3. Requirement</h2>
 * The name of the user that creates comments should be registered at the comment. 
 * Cells should support several comments.
 * When the mouse pointer is hovering above a cell, if it has comments, the comments should be displayed.
 * It is required to persist comments with the workbook.
 *
 * <p>
 * <b>Use Case "Tooltip and user associated to comment":</b> 
 * The user selects the cell where he/she wants to enter a comment. 
 * The system displays all the existing comments on cell. 
 * The user enters the text of the comment and automatically his/ her
 * username is associated with the comment. The submitted comment should be displayed with previous comments.
 * The system saves comments of the cell.
 * The user puts the mouse pointer hovering above a specific cell and if it has comments, they are displayed.
 * 
 *  
 * <h2>4. Analysis</h2>
 * When the user selects the cell where he/she wantes to enter the comment, the sidebar for the
 * comments should appear. It should be divided in two text areas, onde for the 
 * comment user wants to write and the other to show the existing comments on the selected cell.
 * When the user writes a comment, his/ her name should appear associated with it. 
 * A display example of that is: <i> "@saramramos: user's comment."</i>.
 * When the mouse pointer is hovering above a cell which has comments then these 
 * comments should be displayed in a form similar to a "tooltip".
 * 
 * <h3>First "analysis" sequence diagram</h3>
 * The use case was divided in two parts as we can see in the following diagram.
 * <p>
 * 
 * <img src="doc-files/Core02.2.png" alt="UseCases"> 
 * 
 * <p> 
 * The following diagrams depicts a proposal for the realization of the previously described use case. 
 * 
 * <p><b>User name associated to comment</b></p>
 * <p>
 * <img src="doc-files/Core02.2_UserAssociatedToComment.png" alt="User associated to comment"> 
 *
 * 
 * <p><b>Tooltip</b></p>
 * <p>
 * <img src="doc-files/Core02.2_Tooltip.png" alt="Tooltip"> 
 *  
 * <h3>Analysis of Core Technical Problem</h3>
 * Analysing the existing code, a text area is available for user write comments. 
 * To clean up the implementation of the solution, two text areas should be created - 
 * one to the actual user comment, and other to display all the existing comments on 
 * the selected cell. 
 * <p>
 * Using this tool, every time a cell is selected to write an associated comment, 
 * in the area of all comments the previous comments should be concatenated with the name of the user.
 * Once there is no user account associated with the application run, to ensure that 
 * the name of the user is registered in the comment, is necessary to get the user name
 * in the system using the code <code>System.getProperty("user.name")</code>.
 * It´s necessary to make the necessary adjustments in the method <code>cellSelected(CommentableCell cell)</code> 
 * of the class {@link csheets.ext.comments.ui.CommentController} and in the method
 * <code>setCommentText</code> of the class {@link csheets.ext.comments.ui.CommentPanel}.
 * <p>
 * The layout of the aplication concerning the comments of a cell should be changed to.
 * <p>
 * To implement the tooltip, is necessary to activate the tooltip text at the cells that have comments.
 * The class {@link csheets.ui.sheet.CellRenderer} has the method <code>getTableCellRendererComponent</code>, in which 
 * the command setToolTipText(null) should be changed. 
 * <p>
 * Important to refer that <code>CommentableCell</code> extends <code>CellExtension</code> and this class implements <code>Cell</code>.
 * Only the commentable cell have the user's comments.
 *
 * <h2>5. Design</h2>
 *
 * <h3>5.1. Functional Tests</h3>
 * Basically, from requirements and also analysis, we see that the core functionalities 
 * of this use case are to display the name of the user in his/ her comment and the
 * existing comments on the cell in which the mouse pointer is hovering above are displayed.
 * <p> The most important method related to the user name associated with his/ her comment
 * is <code>focusLost</code> of the classe {@link csheets.ext.comments.ui.CommentPanel}. 
 * This method is inside an inner class, so I felt difficulties to test it.
 * A functional test was done at the method <code>getTableCellRendererComponent</code> of 
 * {@link csheets.ui.sheet.CellRenderer} class. The test is passing and shows that tooltip 
 * is well formated.
 * <p>
 * Due to lack of time and simultaneous because the major changes were due to UI no more 
 * tests were implemented. One thought was to use mock up the unit test 
 * environment to create alternate realities, but to accomplish the deadline it was not possible.
 * The efforts were focused on the analysis, design and development.
 * <p>
 * Following this approach, besides the implemented functional test, only manual tests were developed, 
 * and some pictures were taken has showed below.
 * Between the elements Bernardo Meira, Pedro Costa and André Oliveira, multiple manual 
 * tests were implemented in order to catch existing bugs. The team work was always promoted.
 *
 * <h3>5.2. UC Realization</h3>
 * 
 * <h3>User name associated to comment</h3>
 * To realize this user story it was necessary to change the classes 
 * {@link csheets.ext.comments.ui.CommentController} and {@link csheets.ext.comments.ui.CommentPanel}.
 * <p>In those, is considered that when the cell is selected, if it has comments, all 
 * of them will be displayed at the text area of all comments.
 * <p>
 * Every time time the user writes a comment, it's username is concactenated with 
 * the comment and this new comment is added to cell comments.
 * 
 * <h3>Tooltip</h3>
 * To realize this user story it's necessary to change the method <code>getTableCellRendererComponent</code>, 
 * in the class {@link csheets.ui.sheet.CellRenderer}. This should only be activated in cells which have comments.
 * 
 * <p>Because of lack of time the diagram illustrating the core aspects of the solution 
 * for this part of the use case only existed in a draft. So, only the sequence diagram of
 * the method <code>getTableCellRendererComponent</code> of 
 * {@link csheets.ui.sheet.CellRenderer} class was included on this technical documentation.
 * 
 * <p>
 *  * <img src="doc-files/Core02.2_ToolTip.jpg" alt="Sequence diagram ToolTip"> 
 * 
 * <h3>5.3. Classes</h3>
 * The classes {@link csheets.ui.sheet.CellRenderer}, {@link csheets.ext.comments.ui.CommentPanel}  
 * and {@link csheets.ext.comments.ui.CommentController} were modified to implement this feature.
 * <p> The structure of them was mantained and only the necessary methods in each were improved in order to achieve the expected results.
 * 
 * 
 * <h3>5.4. Design Patterns and Best Practices</h3>
 * String builder was used in order to append strings either to change the text of the tooltip as the text 
 * to show in the JTextArea in which are the comments of the cell.

 * <h2>6. Implementation</h2>
 * The layout of the comment box was changed. As we can see from the image below, 
 * currently there are two text areas. The above can be write by the user, and the the comment
 * can be submitted to the area of all existing comments. When the comment is submitted, 
 * the name of the user is added to the comment.
 * <p> It was considered thar the comment ate this point, could not be changed by the user after submitted. 
 * <p> All the implemented code can be consulted ate the constructor of the class {@link csheets.ext.comments.ui.CommentPanel}. 
 * <p>
 * <img src="doc-files/comentario1.png" alt="Comments Layout"> 
 * <p>
 * The class {@link csheets.ext.comments.ui.CommentController} has the method 
 * <code>cellSelected</code> that invokes the method <code>setCommentText</code>
 * of the class {@link csheets.ext.comments.ui.CommentPanel}. With these methods, 
 * if the cell has previous comments the text area of all comments of the selected
 * cell is updated with all of the cell comments.
 * In order to appear the name of the user, the method <code>focusLost</code> of the class 
 * {@link csheets.ext.comments.ui.CommentPanel} was adjusted in order to upadte the 
 * text areas according to the selected cell.
 * 
 * <p> In order to the name of the user appear in the current comment, the method 
 * <code>focusLost</code> from the class {@link csheets.ext.comments.ui.CommentPanel}
 * was changed. This methos is invoked when the selected cell is no longer selected. 
 * When the cell is no longer selected, the area of all comments are cleaned.
 * The code below shows the necessary changes implemented at the mentioned method.
 * 
 * <pre>
 * {@code 
 *      public void focusLost(FocusEvent e)
        {
            // TODO Auto-generated method stub
            if (cell != null && !commentField.getText().isEmpty()) {
                StringBuilder str = new StringBuilder();
                if(cell.hasComment()){
                    str.append(cell.getUserComment()).append("\n");
                }
                str.append("@").append(System.getProperty("user.name")).append(": "). append(commentField.getText());
               controller.setComment(cell, str.toString());
               commentField.setText(null);
            }
        }
 * }
 * </pre>
 * 
 * The class {@link csheets.ui.sheet.CellRenderer} has the method <code>getTableCellRendererComponent</code>, in which 
 * the the tooltip was adjusted as showed in the below code:
 * 
 <pre>
 * {@code 
 * 	// Applies tool tip
            if (value.getType() == Value.Type.ERROR) {
                try {
                    setToolTipText(value.toError().getMessage());
                } catch (IllegalValueTypeException e) {
                }
            } else {
                setToolTipText(null);
                for (CellListener cellListner : this.cell.getCellListeners()) {
                    if (cellListner instanceof CommentableCell) {
                        CommentableCell commentableCell = (CommentableCell) cellListner;
                        if (commentableCell.hasComment()) {
                            StringBuilder str = new StringBuilder();
                            str.append("<html>").append(commentableCell.getUserComment().replace("\n", "<br>")).append("</html>");
                            setToolTipText(str.toString());
                        }
                    }
                }
            }
 * }
 * </pre>
 * 
 * Because the toolTip was displayed with no multiline, in order to adjust its display mode, the tooltip
 * was wrapped in <code>&lt;html&gt; and &lt;/html&gt;</code> tags. The lines were breaked with <code>&lt;br&gt;</code>.
 * This changed was only applied if the cell that has comments. So, the commentable cells has associated a 
 * toolTip in which is diplayed the comments existing on it.
 * <p> This change improved the layout of the tooltip, as we can see in the below image.
 *
 * <p>
 * <img src="doc-files/comentario2.png" alt="Tooltip layout"> 
 * 
 * 
 * <h2>7. Integration/Demonstration</h2>
 * - 
 * 
 * <h2>8. Final Remarks</h2>
 * 
 * I suggest for future work to implement a scroll pane to improve comments areas layout.
 * Aditionally, the comments could be changed by the user who wrote them.
 * 
 * 
 * <h2>9. Work Log</h2> 
 *
 * <b>Monday</b>
 * <p>
 * Yesterday I worked on: 
 * <p>
 * 1. -nothing-
 * <p>
 * Today
 * <p>
 * 1. Analysis of the use case Core 02.2, specifically adding the name of the user in the comment.
 * <p>
 * Blocking: - nothing -
 * <p>
 * 
 * <b>Tuesday</b>
 * <p>
 * Yesterday I worked on: 
 * <p>
 * 1. Analysis of the use case Core 02.2, specifically adding the name of the user in the comment.
 * <p>
 * Today
 * <p>1. Analysis of the use case Core 02.2, specificaly adding the tooltip to the commentable cells. This task was ended.
 * <p>2. Design the use case Core 02.2. - must be upload the sequence diagram.
 * <p>3. Inicialized the implementation of the use case.
 * <p>
 * Blocking: - nothing -
 * <p>
 * <b>Wednesday</b>
 * <p>
 * Yesterday I worked on: 
 * <p>1. Analysis of the use case Core 02.2, specificaly adding the tooltip to the commentable cells. This task was ended.
 * <p>2. Design the use case Core 02.2.
 * <p>3. Inicialized the implementation of the use case.
 * <p>
 * Today
 * <p> 1. Implemented significant changes in the code previously implemented, specially 
 * concerning layout. With the changes, once comment is submitted, it can't be removed 
 * but simultanously it is garantee that the username cannot be changed by anyone at this time.
 * <p> 2. Some adjusts int the technical documentation.
 * Blocking: Tryed to implement scroll pane to the text area with all comments, but it wasn't working well.
 * Once the time wasn't enough, I preferred not to spend more time with that subtask. It is mentioned as an improvement to the feature.
 *
 * 
 * <h2>10. Self Assessment</h2> 
 * The real challenge was to know well all the classes involved in this feature. 
 * I spent significant time studing them and working on the solution model. Besides that, 
 * I think that the job was well done.
 * 
 * <h3>10.1. Design and Implementation:3</h3>
 * 
 * <p>
 * <b>Evidences:</b>
 * <p>
 * - url of commits: 
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/changeset/11f81ada1b5ecb99e0b6bdb30c66c404b6ca6b1f">Commit Design</a>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/changeset/8448291088c150e4f22d7286158d71395376e094">Commit 1 implementation</a>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/changeset/cd03c785e823cf401afd14f29a01db225e5de176">Commit 2 implementation</a>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/changeset/36771298672e1c8856536299d01e36ae65da9351">Commit 3 implementation</a>
 * 
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/6047b230a3bcb2294e25c18da510f88a55bb2667">Commit 4 Unit Test implementation and sequence diagram</a>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/972fea8c0dd90916675913a0ffe6eb6d11bf76e2">Commit 5 Forgotten classes in previous commit - Unit Test implementation and sequence diagram</a>
 *
 * <h3>10.2. Teamwork: </h3>
 * Everytime there was a doubt, parterns helped. Ideas and knowledge were shared. 
 * 
 * <h3>10.3. Technical Documentation: </h3>
 *  -
 * @author 1140411
 */

package csheets.worklog.n1140411.sprint2;

/**
 * This class is only here so that javadoc includes the documentation about this EMPTY package! Do not remove this class!
 * 
 * @author 1140411
 */
class _Dummy_ {}

