/**
 * Technical documentation regarding the work of the team member (1120013) Carlos Lopes during week1. 
 * 
 * <p>
 * <b>- individual documentation -</b>
 * <p>
 * <b>Scrum Master: -(yes/no)- No</b>
 * 
 * <p>
 * <b>Area Leader: -(yes/no)- No</b>
 * 
 * <h2>1. Notes</h2>
 * 
 * -Notes about the week's work.- Analysis to implement the option to implement messenger servive
 * <p>
 * 
 *
 * <h2>2. Use Case/Feature: IPC05.2</h2>
 * 
 * Issue in Jira: LPFOURNA-64
 * <p>
 Chat messaging organized by nick-name od each user
 * 
 * <h2>3. Requirement</h2>
 * 
 * 
 * <p>
 * 
 *  
 * <h2>4. Analysis</h2>
 * Once an instance of clean sheets is started, it will anounce both it's ip adress and it's nick to the network
 * 
 * <h3>First "analysis" sequence diagram</h3>
 * The following diagram depicts a proposal for the realization of the previously described use case. We call this diagram an "analysis" use case realization because it functions like a draft that we can do during analysis or early design in order to get a previous approach to the design. For that reason we mark the elements of the diagram with the stereotype "analysis" that states that the element is not a design element and, therefore, does not exists as such in the code of the application (at least at the moment that this diagram was created).
 * <p>
 * <img src="doc-files/ipc05_02_analysis_chatParticipants_helloMessage.png" alt="image">
 * <h3>Second sequence diagram - analysis for the actions of the instance that receives the hello message</h3>.
 * <p>
 * <img src="doc-files/ipc05_02_analysis_chatParticipants_receive_helloMessage.png" alt="image">
 * <p>
 * <h3>Third sequence diagram - analysis for the actions of the instance that send a goodbye message</h3>.
 * <p>
 * <img src="doc-files/ipc05_02_analysis_chatParticipants_disconect_cli.png" alt="image">
 * <p>
 * <h3>Fourth sequence diagram - analysis for the actions of the instance that receibes a goodbye message</h3>.
 * <p>
 * <img src="doc-files/ipc05_02_analysis_chatParticipants_disconect_ser.png" alt="image">
 * <p>
 
 * <p>
 *
 * <p>
 * Chat Participants class diagram
 * <img src="doc-files/ipc05_02_classDiagram.png" alt="image"> 
 * 
 * <p>
 * One important aspect is how extensions are dynamically created and returned. The <code>Extensible</code> interface has only one method, <code>getExtension</code>. Any class, to be extensible, must return a specific extension by its name. The default (and base) implementation for the <code>Cell</code> interface, the class <code>CellImpl</code>, implements the method in the following manner:
 * <pre>
 * {@code 
 * 	 public class SendChatMessageController implements Observer, Serializable {

    private final UIController uiController;
    private final SendChatMessagePanel uiPanel;

    private final ConnectionManager conMgr;

    public SendChatMessageController(UIController uiController, SendChatMessagePanel uiPanel) {
        this.uiController = uiController;
        this.uiPanel = uiPanel;

        this.conMgr = ConnectionManager.getInstance();
        this.conMgr.addObserver(this);

        if (!this.conMgr.isConnected()) {
            this.conMgr.connect();
        }
    }

    @Override
    * //SendChatMessageController
    public void update(Observable o, Object arg) {
        if (arg != null && arg instanceof Integer) {
            int value = (int) arg;

            if (value == ConnectionManager.CONNECTED) {
                uiPanel.enableConnect();
                uiPanel.enableSend();
            }

            if (value == ConnectionManager.FOUNDSERVER) {
                uiPanel.addRemoteAddress(this.conMgr.foundRemoteInstances());
            }
        }

        if (arg != null && arg instanceof Message) {
            Message m = (Message) arg;
            if (m.getMessageType() == MessageType.CHATMESSAGE) {
                ChatMessage chat = (ChatMessage) m.getMessageContent();

                this.uiPanel.displayPopup(chat);
            }

        }
    }

    public void connectTo(String remoteAddress) throws IOException {
        this.conMgr.connectTo(remoteAddress);
    }

    public void disConnectFrom(String remoteAddress) throws IOException {
        this.conMgr.disconnectFrom(remoteAddress);
 * </pre>
 * 
 * <h2>5. Design</h2>
 * 
 * Design Sequence diagram 
 *  <img src="doc-files/ipc05_02_design.png" alt="image"> 
 * 
 *
 * <h3>5.1. Functional Tests</h3>
 * Basically, there is a test to check if the sent message is equal to the message 
 * that's received, 
 * <p>
 * see: <code>@Test
    public void testSendChatMessageToSelf() {
        sone = ConnectionManager.getInstance();
        if (!sone.isConnected()) {
            sone.connect();
        }
        try {
            localhost = sone.getLocalAddress();
            System.out.println("Test send chat message to self");
            chatMessage = new ChatMessage(0, "Hello", 0);
            Message m = new Message(MessageType.CHATMESSAGE, chatMessage, localhost);

            sone = ConnectionManager.getInstance();
            sone.addObserver(this);
            sone.connectTo(localhost.getHostAddress());
            sone.send(m);

            Thread.sleep(5000);
            sone.disconnectFrom(localhost.toString());
            assertEquals(chatMessage, receivedMessage);
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(ConnectionManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }</code>
 *
 * <h3>5.2. UC Realization</h3>
 * 
 * <p>
 * <b>Note:</b> 
 * 
 * <h3>Extension Setup</h3>
 * 
 * <p>
 *
 
 * 
 * <h3>5.3. Classes</h3>
 * 
 * -Document the implementation with class diagrams illustrating the new and the modified classes-
 * 
 * <h3>5.4. Design Patterns and Best Practices</h3>
 * 
 * -Describe new or existing design patterns used in the issue-
 * <p>
 * -You can also add other artifacts to document the design, for instance, database models or updates to the domain model-
 * 
 * <h2>6. Implementation</h2>
 * 
 * added-
 * csheets.ipc.sendChatMessage
 * <p>
 * We had to add a new line to the file -\lapr4-2016-2na\src\main\resources\csheets\res\extensions.props
 * refering the new option in the extensions menu
 * <p>
 * see:<p>
 * <a href="../../../../csheets/ext/comments/package-summary.html">csheets.ext.comments</a><p>
 * <a href="../../../../csheets/ext/comments/ui/package-summary.html">csheets.ext.comments.ui</a>
 * 
 * <h2>7. Integration/Demonstration</h2>
 * 
 * -In this section document your contribution and efforts to the integration of your work with the work of the other elements of the team and also your work regarding the demonstration (i.e., tests, updating of scripts, etc.)-
 * 
 * <h2>8. Final Remarks</h2>
 * 
 * -In this section present your views regarding alternatives, extra work and future work on the issue.-
 * <p>
 * As an extra this use case also implements a small cell visual decorator if the cell has a comment. This "feature" is not documented in this page.
 * 
 * 
 * <h2>9. Work Log</h2> 
 * 
 * -Insert here a log of you daily work. This is in essence the log of your daily standup meetings.-
 * <p>
 * Example
 * <p>
 * <b>Monday</b>
 * <p>
 * Yesterday I worked on: Analysing the issue. started designing the diagrams  
 * <p>
 * <p>
 * Today I finnished the design issue, with the 4 diagrams to implemment the
 * hello message (send and receive) and the disconnect message (send and receive).
 * <p>
 
 * <p>
 * Blocking:
 * Sending a message to only one instance. After the presentation I was told thar
 * it was not supose to send a message to all the users online.
 * (I was seeing this messenger service as the Ipchat where you send 
 * a message to everyone)
 * <p>
 
 * 2. 
 * <p>
 * <b>Thursday
 * After the presentation tried to change the issu acording to the feedback
 * but couldn't find out how to.
 * </b>
 * <p>
 
 * <p>
 * 
 * <p>
 * 
 * <p>
 * 1. ...
 * <p>
 * 
 * <p>
 * 1. ...
 * 
 * <h2>10. Self Assessment</h2> 
 * 
 * I feel that I didn't understant what was asked and lost a big amount of
 * time that couldn't get back.
 * * 
 * <h3>10.1. Design and Implementation:3</h3>
 * 
 * <p>
 * <b>Evidences:</b>
 * <p>
 
 * 
 * <h3>10.2. Teamwork: ...
 * Must say that my colleages all tryed to help everytime I asked for it
 * In special Sérgio that was also scrum master gave a big help.
 * </h3>
 * 
 * <h3>10.3. Technical Documentation: ...</h3>
 * 
 * @author Carlos Manuel Lopes
 */
package csheets.worklog.n1120013.sprint3;

class _Dummy_ {}