/**
 * Technical documentation regarding the work of the team member (1121060) Sérgio Oliveira during week1.
 *
 * <p>
 *
 * <p>
 * <b>Scrum Master: -(yes/no)- no</b>
 *
 * <p>
 * <b>Area Leader: -(yes/no)- yes</b>
 *
 * <h2>1. Notes</h2>
 *
 *
 *
 *
 *
 *
 * <h2>2. Use Case/Feature: IPC01.1</h2>
 *
 * Issue in Jira:
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-51" >IPC01.1</a>
 * It should be possible to establish a connection with other instance of
 * Cleansheets in the local network. It should be possible to send the contents
 * of a range of cells to another instance of Cleansheets. The other instance
 * should display the received contents in the same cell address as the original
 * cells. It should be possible to configure the port to be used for network
 * connections. It should be possible to find other instances of Cleansheets
 * available in e local network. These instances should be listed in a new
 * window (sidebar window). The user should be able to select one of the
 * discovered instances to connect to when establishing the connection to send
 * the contents of the range of cells. At the moment it is only required to send
 * the value of the cells.
 *
 *
 * <h2>3. Requirement</h2>
 * Setup extension for start sharing cells with other instance of Cleansheets in
 * the local network. The user should be able to activate and deactivate
 * sharing. When activated, a sidebar with avaliable servers appear.The sidebar
 * should be composed of a JList of RemoteInstances and two buttons,
 * connect/disconnect button to connect or disconnect to the RemoteInstance
 * selected and send button to send a cell value to the RemoteInstance
 * connected. At the moment it is only required to send the value of the cells.
 * <p>
 * <b>Use Case "Start Sharing":</b> The user activate startSharing. The system
 * display the sidebar with avaliable RemoteInstances. The User selects the
 * RemoteInstance where he/she wants to send a value of cell(s) and click
 * connect. If the connection is sucessful the system show the send button. The
 * User selects the cell(s) that he/she wants to send to RemoteInstance and
 * click the send button. The RemoteInstance receive the value of cell(s) and
 * update his owns cell(s).
 *
 * <h2>4. Analysis</h2>
 *
 *
 * <h3>First "analysis" sequence diagrams</h3>
 * The following diagrams depicts a proposal for the realization of the
 * previously described use case. We call this diagram an "analysis" use case
 * realization because it functions like a draft that we can do during analysis
 * or early design in order to get a previous approach to the design. For that
 * reason we mark the elements of the diagram with the stereotype "analysis"
 * that states that the element is not a design element and, therefore, does not
 * exists as such in the code of the application (at least at the moment that
 * this diagram was created).
 * <p>
 * <h2>StartSharing</h2>
 * <img src="doc-files/StartSharing_Analysis_01.png" alt="image1">
 * <p>
 * <h2>Send Cells</h2>
 * <img src="doc-files/StartSharing_Analysis_02.png" alt="image2">
 * <p>
 * <h2>Receive Cells</h2>
 * <img src="doc-files/StartSharing_Analysis_03.png" alt="image3">
 * <p>
 *
 * <h3>Analysis of Core Technical Problem</h3>
 * All the network communications will be handled by the
 * {@link csheets.ipc.ConnectionManager}. This
 * <a href="https://en.wikipedia.org/wiki/Singleton_pattern">singleton</a>
 * manages the discovery of remote cleansheets instances and provides the all
 * the mechanisms to connect, send and receive messages through the network by
 * <a href="https://en.wikipedia.org/wiki/Observer_pattern">
 * observing</a> instances of {@link csheets.ipc.tcp.TcpServerConnection}
 *
 * <h2>5. Design</h2>
 *
 * <h3>5.1. Functional Tests</h3>
 * From the requirements and also from analysis , we see that the core
 * functionality of this use case is to be able to send a selection of cells to
 * a remote cleansheets instance. We need to be able to send and receive cells.
 * Following this approach we can start by coding a unit test that uses
 * {@link csheets.ipc.ConfigurationManager} to send and receive a cells
 * (testSendCellsToSelf()).
 *
 * <p>
 * see: <code>csheets.ipc.ConnectionManagerTest</code>
 * </p>
 *
 * <h3>5.2. UC Realization</h3>
 * To realize this user story we will need to create a subclass of Extension. We
 * will also need to create a subclass of UIExtension. For the sidebar we need
 * to implement a JPanel. The following diagrams illustrate core aspects of the
 * design of the solution for this use case.
 * <p>
 *
 * <h3>Extension Setup</h3>
 * The following diagram shows the setup of the "StartSharing" extension when
 * cleansheets is run.
 * <p>
 * <img src="doc-files/ipc01_01_design_01.png" alt="image4">
 *
 * <h3>User Activate StartSharing and send cells to a remote instance</h3>
 * The following diagram illustrates what happens when the user Activate the
 * StartSharing Menu. The idea is that when this happens the extension must
 * display in the sidebar the list of avaliable servers (if they exist). This
 * diagram also illustrates what happens when the user sends cells to a remote
 * cleansheets instance.
 * <p>
 * <img src="doc-files/ipc01_01_design_02.png" alt="image5">
 *
 * <h3>User receives cells</h3>
 * The following diagram illustrates the process of receiving cells from a
 * remote cleansheets instance.
 * <p>
 * <img src="doc-files/ipc01_01_design_03.png" alt="image6">
 *
 * <h3>5.3. Classes</h3>
 *

 * <p>
 * <img src="doc-files/ipc01_01_ClassDiagram.png" alt="image8">
 *
 * <h3>5.4. Design Patterns and Best Practices</h3>
 *
 * In this implementation the Singleton and the Observer patterns where used.
 * {@link csheets.ipc.ConnectionManager} is a singleton which handles all the network communication part.
 * {@link csheets.ipc.ConnectionManager} is an Observer that observes changes on instances of {@link csheets.ipc.tcp.TcpServerConnection} and {@link csheets.ipc.udp.UdpClient}
 * with the intent of handling those updates and passing information to the use case controller.
 * {@link csheets.ipc.ConnectionManager} is also Observable and is observed by {@link csheets.ipc.ui.sendChatMessage.SendChatMessageController} 
 * This approach was followed to maintain low coupling between the classes.

 *
 * <h2>6. Implementation</h2>
 *
 * <p>
 * see:
 * <p>
 * <a href="../../../../csheets/ipc/package-summary.html">csheets.ipc</a><p>
 * <a href="../../../../csheets/ipc/ui/package-summary.html">csheets.ipc.ui</a><p>
 * <a href="../../../../csheets/ipc/ui/package-summary.html">csheets.ipc.tcp</a><p>
 * <a href="../../../../csheets/ipc/ui/package-summary.html">csheets.ipc.udp</a><p>
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
 *
 *
 * <h2>9. Work Log</h2>
 *
 * -Insert here a log of you daily work. This is in essence the log of your
 * daily standup meetings.-
 * <p>
 * Example
 * <p>
 * <b>Monday</b>
 * <p>
 * Yesterday we plan the work for the rest of the week
 * <p>
 * Today
 * <p>
 * 1. Analysis of the start sharing issue, IPC01.1
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 * <p>
 * <b>Tuesday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. Analysys of the start sharing issue, IPC01.1
 * <p>
 * Today
 * <p>
 * 1. Design and Unit Tests of the start sharing issue, IPC01.1
 * <p>
 * Blocking:
 * <p>
 * 1. nothing
 *
 * <h2>10. Self Assessment</h2>
 *
 * -Insert here your self-assessment of the work during this sprint.-
 *
 * <h3>10.1. Design and Implementation:3</h3>
 *
 * 3- bom: os testes cobrem uma parte significativa das funcionalidades (ex:
 * mais de 50%) e apresentam código que para além de não ir contra a arquitetura
 * do cleansheets segue ainda as boas práticas da área técnica (ex:
 * sincronização, padrões de eapli, etc.)
 * <p>
 * <b>Evidences:</b>
 * <p>
 * - url of commit: ... - description: this commit is related to the
 * implementation of the design pattern ...-
 *
 * <h3>10.2. Teamwork: ...</h3>
 *
 * <h3>10.3. Technical Documentation: ...</h3>
 *
 * @author Sérgio Oliveira
 */
package csheets.worklog.n1121060.sprint1;

class _Dummy_ {
}
