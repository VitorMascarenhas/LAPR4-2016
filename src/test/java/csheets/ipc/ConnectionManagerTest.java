/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ipc;

import csheets.core.Value;
import csheets.ipc.tcp.TcpClientConnection;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.*;

import static org.junit.Assert.*;

/**
 *
 * @author smoli
 */
public class ConnectionManagerTest implements Observer {

    private ConnectionManager sone = null, stwo = null;
    private InetAddress localhost;

    private ChatMessage receivedMessage = null;
    private ChatMessage chatMessage;
    
    private List<CellValueObject> cells = null;
    private List<CellValueObject> receivedCells;
    private Object ChatParticipantsMessage;

    public ConnectionManagerTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testUnique() {
        sone = ConnectionManager.getInstance();
        stwo = ConnectionManager.getInstance();

        assertEquals(sone, stwo);
    }

    /**
     * *
     * IPC01.1- Start Sharing
     */
    @Test
    @Ignore
    public void testSendCellsToSelf() {
        try {
            sone = ConnectionManager.getInstance();
            if (!sone.isConnected()) {
                sone.connect();
            }
            localhost = sone.getLocalAddress();
            System.out.println("Test send a list of CellValueObject to self");
            sone.addObserver(this);
            
            cells = new ArrayList<>();
            cells.add(new CellValueObject(new MockCell(new Value(2))));
            
            sone.connectTo(localhost.getHostAddress());
            
            Message m = new Message(MessageType.CELLS, cells, localhost);
            sone.send(m);
            
            Thread.sleep(5000);
            sone.disconnectFrom(localhost.toString());
            
            assertEquals(receivedCells, cells);
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(ConnectionManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(ConnectionManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * *
     * IPC05.1- Chat Send Message
     */
    @Test
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

    }
    
     @Test
     @Ignore
    public void testChatParticipantsMessageToSelf() {
         //TODO Unexpected result
        sone = ConnectionManager.getInstance();
        if (!sone.isConnected()) {
            sone.connect();
        }
        try {
            localhost = sone.getLocalAddress();
            System.out.println("Test send chat Participants message to self");
            ChatParticipantsMessage = new ChatParticipantsMessage("Hello", "0");
            Message m = new Message(MessageType.CHATPARTICIPANTSMESSAGE, ChatParticipantsMessage, localhost);

            sone = ConnectionManager.getInstance();
            sone.addObserver(this);
            sone.connectTo(localhost.getHostAddress());
            sone.send(m);

            Thread.sleep(5000);
            sone.disconnectFrom(localhost.toString());
            assertEquals(ChatParticipantsMessage, receivedMessage);
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(ConnectionManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg != null && arg instanceof Message) {
            Message r = (Message) arg;

            //IPC05.1- Chat Send Message
            if (r.getMessageType() == MessageType.CHATMESSAGE) {
                receivedMessage = (ChatMessage) r.getMessageContent();
            }
            
            //IPC05.2- Chat Send ParticipantsMessage
            if (r.getMessageType() == MessageType.CHATPARTICIPANTSMESSAGE) {
                ChatParticipantsMessage receivedCh;
                receivedCh = (ChatParticipantsMessage) r.getMessageContent();
            }
            
            //IPC01.1- Start Sharing
            if(r.getMessageType() == MessageType.CELLS){
                receivedCells = (List<CellValueObject>)r.getMessageContent();
            }
        }
    }
}
