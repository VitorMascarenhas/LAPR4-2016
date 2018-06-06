/**
 * Technical documentation regarding the work of the team member (1140411) Sara Ramos during week4. 
 * 
 * <p>
 * <b>Scrum Master: -(yes/no)- no</b>
 * 
 * <p>
 * <b>Area Leader: -(yes/no)- no</b>
 * 
 * <h2>1. Notes</h2>
 * 
 * <h2>2. Use Case/Feature: IPC 05.2 - Chat Participants</h2>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-49">Issue in Jira</a>
 *
 * <h2>3. Requirement</h2>
 * Cleansheets should now use the user name of the system as the basis for the user profile of the chat.
 * The end user should be able to add an icon or a photo to its profile as well as a nickname. Each user
 * should have have a status (i.e., online or offline). Cleansheets should automatically discover all users in
 * the local network. The sidebar window should now have the conversations organized by user. The window
 * should also display the status of the users and their icon and nickname. When a user state is offline it will
 * not receive any messages from other instances of Cleansheets. Profile configuration and message history
 * should be persistent.
 *
 * <p>
 * <b>Use Case "Chat Participants":</b> 
 * The user selects to enter on chat. He can change his/ her nickname, status and icon related to him or her on chat.
 * Messages should be organized on tree by user. When the cleansheet run all users should automatically discover 
 * all users in the local network. When the user wants to be connected with other a message Hello should be send 
 * and the other user should answer sending his/ her user chat profile. With the user profile received, the information 
 * of user displayed in the connected instances should refresh and display thechanges.
 * <p>
 * 
 * 
 * <h2>4. Analysis</h2>
 * In previous UC - IPC 05.1 it was implemented connections between all users in the netwok. Now, messages should be send
 * to a specific user, selected in the implemented Jtree.
 * <p> The user could adjust his/her information to be diaplayed in other instances of cleansheet. If he/ she doesn't 
 * update that, only the username in system will be displayed.
 * <p> It is necessary to create a GUI window that will allow the user to update his/ her profile and the Jtree should be 
 * ajusted in order to have the conversations organized by user.
 * 

 * <h3>First "analysis" sequence diagram</h3>
 * Analysing this use case, user can:
 * <p> Create/ change it's profile (icon, nickname and status);
 * <p> Send a message hello, to ask other user it's information in order to start a conversation. The other user will send a chat profile 
 * with it's nick, username, icon, and status. If it's status is offline, no other messages should be sent to this user;
 * <p> Send a chat message to a selected user in other instance of cleansheet.
 * <p> Update his/ her status. If his/ her status is offline, a message with type "Offline" should 
 * be send and the instance which receive this should update it's list of connected instances. 
 * No messages will be send to offline instances.
 *
 * <h3>Analysis of Core Technical Problem</h3>
 * Previous code exists, and it should be adapted to this new feature. The IP of the users should no longer be 
 * printed in the window and instance of this, his/ her status and nickname should be displayed. 
 *
 * <h2>5. Design</h2>
 *
 * <h3>5.1. Functional Tests</h3>
 * Functional tests were implemented at <code>UserChatProfile</code> class. 
 * Due to lack of time only basic tests were implemented.
 * 
 * <h3>5.2. UC Realization</h3>
 * 
 * <p>Below we can see the diagrams created illustrating the core aspects of the solution 
 * for this use case. 
 * 
 * <p>
 * <img src="doc-files/diagram1.jpg" alt="Diagram1"> 
 * <p>When the user click connect to an instance, a hello message should be send, using the method <code>conncectTo(remoteAddress)</code>.
 * <p>
 * <img src="doc-files/diagram2.jpg" alt="Diagram2"> 
 * <p> When the cleansheet run all users should automatically discover 
 * all users in the local network. In this diagram we can see how the method <code>conncet()</code> is implemented. 
 * A map with all the Tcp client connections are saved connected with the corresponding IP.
 * <img src="doc-files/diagram3.jpg" alt="Diagram3"> 
 * <p> When the user select an instance to send a message, it should be checked if the selected instance is online. 
 * If it is, then a chat message should be created with the type CHATMESSSAGE, and sent to the selected instance.
 * <p> The created message should be add to the JTree, associated with the respectively instance.
 * <img src="doc-files/diagram4.jpg" alt="Diagram4"> 
 * <p> In this diagram we can see the response when a type message is received. When a HELLO message is received, 
 * then, if the user profile doesn't exist, a popup menu appear to the user in order to create it's profile. 
 * If it exists, it should be send to the instance who sent the HELLO message.
 * <p> When a PROFILE message is received, it means that a user profile was sent, and the information related to him/her should be 
 * updated. The user should be added to the JTREE.
 * <p> When a OFFLINE message is received, it should disconnect the instance who sent the message, in order not to
 * send more messages to it until new change in its status. 
 * <p> When a GOODBYE message is received, the instance shoud be disconnected from the instance who sent the message 
 * and it should be removed from the list of connected instances.
 * <p> When a ONLINE message is received it means that the user updated its status and it should be updated too at the 
 * list displayed of connected instances.
 * <img src="doc-files/diagram5.jpg" alt="Diagram5"> 
 * <p> In this diagram is showed the behaviour of application when a user create its profile. 
 * A PROFILE type message should be send to all the connected instances in order to they 
 * update their connceted instances list.
 * 
 * <img src="doc-files/diagram6.jpg" alt="Diagram6"> 
 * <p> In this diagram we can see what happens when the popup for a message is created and showed to the user. 
 * The message will be "attached" to the message to which it is responding or to the r
 * espectively user if it is the first message.
 * 
 * <h3>5.3. Classes</h3>
 * To realize this user story it was necessary to create methods in classes {@link csheets.ipc.ui.sendChatMessage.SendChatMessageController}; 
 * {@link csheets.ipc.ConnectionManager}; {@link csheets.ipc.MessageType}:
 * <p> <b>update</b> (Some adjustments in method)
 * <p> <b>sendChatMessageTo</b>
 * <p> <b>sendUserChatProfile</b>
 * <p> <b>sendHello</b>
 * <p> <b>sendMessageTo</b>
 *
 * <p>
 * and create the class {@link csheets.ipc.ui.sendChatMessage.UserChatProfile} and 
 * the JPanelForm {@link csheets.ipc.ui.sendChatMessage.ChatProfile}. In class 
 * {@link csheets.ipc.ui.sendChatMessage.SendChatMessagePanel} some adjustments were implemented.
 * 
 * <h3>5.4. Design Patterns and Best Practices</h3>
 * <p> All code implemented tryed to reuse previous code and interate new functinalities in it. 
 * <p> Observer pattern was implemented.
 * <h2>6. Implementation</h2>
 * The GUI was developed as we can in the above figures.
 * <p>
 * <img src="doc-files/gui1.png" alt="GUI 1"> 
 * <p> If it is the first time that the user select to create its profile, 
 * it was already predefined with its username.
 * <p>
 * <img src="doc-files/gui2.png" alt="GUI 2"> 
 * <p>
 * <img src="doc-files/gui3.png" alt="GUI 3"> 
 * 
 * 
 * <h2>7. Integration/Demonstration</h2>
 * The code developed was integrated in previously code. Demonstration was not a full demonstration because 
 * integration was not totally done. It was very difficult to test in real context due to network.  
 * 
 * <h2>8. Final Remarks</h2>
 * 
 * The feature was assigned to me only on monday, so, I had no sufficient time to implement all the functionalities. 
 * <p> I felt many difficulties due to eduroam and isepLan network. I could only test at ISEP and sometimes it was very difficult.
 * <p> The UC implementation should continue in order to accomplish plain functionality.
 * 
 * <h2>9. Work Log</h2> 
 *
 * <b>Monday</b>
 * <p> 
 * Yesterday I worked on: - nothing -
 *
 * <p>
 * Today: Helped Vitor Mascarenhas at it's previously UC (Core 02.3). He was continuing my 
 * previous one (Core 02.2). Started the analysis and design of this new UC.
 * <p>
 * 
 * Blocking: - the complexity of UC, specially understanding all the existing code. -
 * <p>
 * 
 * <b>Tuesday</b>
 * <p>
 * Yesterday I worked on: Helped at the UC Core 02.3. Start analysis and design of this new UC.
 *
 * <p>
 * Today: Create the sequence diagrams for the UC. Do some technical documentation. Do manual tests at UC Lang 01.3 
 * from André Oliveira.
 * <p>
 * Blocking: - the complexity of UC -
 * <p>
 * <b>Wednesday</b>
 * <p>
 * Yesterday I worked on: Design of this use case. 
 * <p>
 * Today: Implementation. All structure is implemented. Methods to connect to a specific user were created.
 * <p> JTree was adjusted and UI to user profile created. 
 * <p>Blocking: Eduroam and ISEPLan Network at DEI.
 * <p>
 * <b>Thursday</b>
 * <p>
 * Yesterday I worked on: Implementation of the necessary methods and UI.
 * <p>
 * Today: Adjustments to technical documentation and some refinements at implementation. Test implementation.
 * <p>Blocking: Due to time and problems with conncetion tests not all necessary methods were implemented.
 * 
 * <h2>10. Self Assessment</h2> 
 * One of the challenges was to know well all the classes involved in this feature. 
 * I spent significant time studing them and working on the solution model. I had no sufficient time to this UC. 
 * Three nights were not enough to put this feature completly working.
 * The rithm imposed to LAPR4 is not adjusted to students/workers. Unfortunately all effort from all team is not 
 * being recognised. 
 * 
 * <h3>10.1. Design and Implementation:</h3>
 * 
 * <p>
 * <b>Evidences:</b>
 * <p>
 * - url of commits: 
 * 
 * <p> <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/54f9fbdf275575e74d8fb89b7d374ea756353aca">Implementation</a>
 * <p> <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/50c67cdbe1e0ad726661ca2d9110fe55c4005f77">Implementation</a>
 * <p> <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/df71bd03f43b7d82c0c473ffa179de1044f467c3">Implementation</a>
 * <p> <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/109dbf409778e902c39bec426f0351305c04a6b6">Implementation</a>
 * <p> <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/e4f44486bfd091d14f281c91a92138cda5af19e8">Design</a>
 * <p> <a href="https://bitbucket.org/lei-isep/lapr4-2016-2na/commits/0e15937cbb15c19b3275bd98afbd899b42c68891">Tests</a>
 * 
 * <h3>10.2. Teamwork: </h3>
 * Everytime there was a doubt, parterns helped, specially Bernardo Meira, Pedro Costa and André Oliveira. Ideas and knowledge were shared. Me and Vitor Mascarenhas 
 * worked sometimes together. Sérgio Oliveira helped me to understand the UC IPC05.1. 
 * I have done some manual tests in order to help team elements.
 * <p> <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-254">Manual Tests</a> 
 * <p> <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURNA-205">Manual Tests</a> 
 * 
 * 
 * <h3>10.3. Technical Documentation: </h3>
 *  -
 * @author 1140411
 */

package csheets.worklog.n1140411.sprint4;

/**
 * This class is only here so that javadoc includes the documentation about this EMPTY package! Do not remove this class!
 * 
 * @author 1140411
 */
class _Dummy_ {}

