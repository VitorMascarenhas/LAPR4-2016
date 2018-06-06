/**
 * Technical documentation regarding the work of the team member (1121060) Sérgio Oliveira during week2.
 * <p>
 * <b>Scrum Master: -(yes/no)- no</b>
 * </p>
 * <p>
 * <b>Area Leader: -(yes/no)- yes</b>
 * </p>
 * <h2>1. Notes</h2>
 *
 * -Notes about the week's work.-
 * <h2>2. Use Case/Feature: IPC05.1</h2>
 *
 * Issue in Jira:
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-63">IPC05.1- Chat
 * Send Message</a>
 * <p>
 * Add an option that can be used to send text messages to another instance of
 * Cleansheets. The message should be displayed in a popup window in the other
 * instance of Cleansheets. The popup should disappear after some short period
 * (for instance 5 seconds). Cleansheets should have have a new sidebar window
 * to display all the messages. The sidebar should be based on a tree control
 * that shows the messages grouped by thread of conversation (i.e., each reply
 * will be a child of the parent message). It should be possible to reply to a
 * message by double clicking on it in the tree.
 *
 * </p>
 * <h2>3. Requirement</h2>
 * The user should be able to send text messages to another instance of
 * cleansheets and the message should be displayed as a popup windows. The
 * messages should be displayed on a tree control that shows messages grouped by
 * thread of conversation. It should be possible to reply to a message by
 * clicking on it in the tree.
 *
 * <p>
 * <b>Use Case "Enter Comment on Cell":</b> The user selects the cell where
 * he/she wants to enter a comment. The system displays the current comment of
 * that cell. The user enter the text of the comment (or alters the existing
 * one). The system saves the comment of the cell.
 * </p>
 *
 * <h2>4. Analysis</h2>
 * Sending chat messages will be supported in a new extension to cleansheets.
 * we need to study how extensions are loaded by cleansheets and how they work.
 * The first sequence diagram in the section
 * <a href="../../../../overview-summary.html#arranque_da_aplicacao">Application
 * Startup</a> tells us that extensions must be subclasses of the Extension
 * abstract class and need to be registered in special files. The Extension
 * class has a method called getUIExtension that should be implemented and
 * return an instance of a class that is a subclass of UIExtension. In this
 * subclass of UIExtension there is a method (getSideBar) that returns the
 * sidebar for the extension. A sidebar is a JPanel.
 *
 *
 * <h3>Analysis sequence diagram - Send Chat Message</h3>
 * The following diagram depicts a proposal for the realization of the
 * send chat message use case
 * <p>
 * <img src="doc-files/ipc05_01_analysis_send_message.png" alt="image">
 * </p>
 *
 * <h3>Analysis sequence diagram - Receive Chat Message</h3>
 * The following diagram depicts a proposal for the realization of the
 * send chat message use case
 * <p>
 * <img src="doc-files/ipc05_01_analysis_receive_message.png" alt="image">
 * </p>
 * 
 * <h3>Analysis of Core Technical Problem</h3>
 * In the same manner of the issue <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-51">IPC01.1- Start Sharing</a>
 * all the network communications will be handled by the {@link csheets.ipc.ConnectionManager}.
 * This <a href="https://en.wikipedia.org/wiki/Singleton_pattern">singleton</a> manages the discovery of remote cleansheets instances 
 * and provides the all the mechanisms to connect, send and receive messages through the network by <a href="https://en.wikipedia.org/wiki/Observer_pattern">
 * observing</a> instances of {@link csheets.ipc.tcp.TcpServerConnection}
 * </p>
 * <p>
 * We are going to add a new constant to the {@link csheets.ipc.MessageType} enum and use the attribute Content of the {@link csheets.ipc.Message} to send the chat message 
 *
 * <h2>5. Design</h2>
 *
 * <h3>5.1. Functional Tests</h3>
 * Basically, from requirements and also analysis, we see that the core
 * functionality of this use case is to be able to send a message to a remote cleansheets instance.
 * We need to be able to send and receive messages.
 * Following this approach we can start by coding a unit test that uses {@link csheets.ipc.ConfigurationManager}
 * to send and receive a message.
 * 
 * <p>
 * see: <code>csheets.ipc.ConnectionManagerTest</code>
 * </p>
 * <h3>5.2. UC Realization</h3>
 * To realize this user story we will need to create a subclass of Extension. We
 * will also need to create a subclass of UIExtension. For the sidebar we need
 * to implement a JPanel. The following diagrams illustrate
 * core aspects of the design of the solution for this use case.
 * 
 * <h3>Extension Setup</h3>
 * The following diagram shows the setup of the "Send chat message" extension when
 * cleansheets is run.
 * <p>
 * <img src="doc-files/ipc05_01_design_01.png" alt="image">
 * </p>
 *
 * <h3>User sends a message</h3>
 * The following diagram illustrates what happens when the user connects to a remote
 * cleansheets instance
 * <p>
 * <img src="doc-files/ipc05_01_design_02.png" alt="image">
 * </p>
 * <h3>User receives a message</h3>
 * The following diagram illustrates what happens when the user receives a 
 * chat message from a remote cleansheets instance
 * <p>
 * <img src="doc-files/ipc05_01_design_03.png" alt="image">
 * </p>
 * <h3>5.3. Classes</h3>
 *
 * 
 * <p>
 * <img src="doc-files/ipc05_01_classDiagram.png" alt="image">
 * </p>
 * 
 * <h3>5.4. Design Patterns and Best Practices</h3>
 *
 * In this implementation the Singleton and the Observer patterns where used.
 * {@link csheets.ipc.ConnectionManager} is a singleton which handles all the network communication part.
 * {@link csheets.ipc.ConnectionManager} is an Observer that observes changes on instances of {@link csheets.ipc.tcp.TcpServerConnection} and {@link csheets.ipc.udp.UdpClient}
 * with the intent of handling those updates and passing information to the use case controller.
 * {@link csheets.ipc.ConnectionManager} is also Observable and is observed by {@link csheets.ipc.ui.sendChatMessage.SendChatMessageController} 
 * This approach was followed to maintain low coupling between the classes.
 
 * <h2>6. Implementation</h2>
 *
 * </p>
 * <p>
 * see:
 * </p>
 * <p>
 * <a href="../../../../csheets/ipc/package-summary.html">csheets.ipc</a>
 * </p>
 * <p>
 * <a href="../../../../csheets/ipc/tcp/package-summary.html">csheets.ipc.tcp</a>
 * </p>
 * <p>
 * <a href="../../../../csheets/ipc/udp/package-summary.html">csheets.ipc.udp</a>
 * </p>
 * <p>
 * <a href="../../../../csheets/ipc/ui/SendChatMessage/package-summary.html">csheets.ipc.ui.sendChatMessage</a>
 * </p>
 * 
 * <h2>7. Integration/Demonstration</h2>
 *
 * -In this section document your contribution and efforts to the integration of
 * your work with the work of the other elements of the team and also your work
 * regarding the demonstration (i.e., tests, updating of scripts, etc.)-
 *
 * <h2>8. Final Remarks</h2>
 *
 * -In this section present your views regarding alternatives, extra work and
 * future work on the issue.-
 * <p>
 * As an extra this use case also implements a small cell visual decorator if
 * the cell has a comment. This "feature" is not documented in this page.
 * </p>
 *
 * <h2>9. Work Log</h2>
 *
 * <p>
 * Example
 * </p>
 * <p>
 * <b>Monday</b>
 * </p>
 * <p>
 * Yesterday I worked on: Implementation of the issue from sprint 1
 * </p>
  * <p>
 * Today
 * </p>
 * <p>
 * 1. Implementation of the issue from sprint 1
 * </p>
 * <p>
 * Blocking: How to get all selected cells (issue from sprint 1)
 * </p>

 * <p>
 * <b>Tuesday</b>
 * </p>
 * <p>
 * Yesterday I worked on: Finished the implementation os the issue from sprint1
 * </p>
 * <p>
 * Today
 * </p>
 * <p>
 * 1. Analysis of Send chat Message 
 * </p>
 * <p>
 * Blocking: Nothing
 * </p>
 * <p>
 * 
 * </p>
 * <b>Wednesday</b>
 * </p>
 * <p>
 * Yesterday I worked on: Analysis of the issue and implementation of the UI
 * </p>
 * <p>
 * Today
 * </p>
 * <p>
 * 1. Design and unit testing
 * </p>
 * <p>
 * Blocking: Nothing
 * </p>
 * <p>
 * 
 * </p>
 * <b>Thursday</b>
 * </p>
 * <p>
 * Yesterday I worked on: Desing, unit testing and some implementation
 * </p>
 * <p>
 * Today
 * </p>
 * <p>
 * 1. Implementation
 * </p>
 * <p>
 * Blocking: How to insert nodes on JTree
 * </p>
 * <p>
 * 
 * </p>
 * <h2>10. Self Assessment</h2>
 *
 * -Insert here your self-assessment of the work during this sprint.-
 *
 * <h3>10.1. Design and Implementation:3</h3>
 *
 * <p>
 * <b>Evidences:</b>
 * </p>
 * <p>
 * - url of commit: ... - description: this commit is related to the
 * implementation of the design pattern ...-
 * </p>
 * <h3>10.2. Teamwork: ...</h3>
 *
 * <h3>10.3. Technical Documentation: ...</h3>
 *
 * @author Sérgio Oliveira
 */
package csheets.worklog.n1121060.sprint2;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author alexandrebraganca
 */
class _Dummy_ {
}
