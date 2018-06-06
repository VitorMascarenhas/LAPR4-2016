/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ipc.ui.chatParticipants;

import csheets.ipc.ChatParticipantsMessage;
import csheets.ipc.ConnectionManager;
import csheets.ipc.Message;
import csheets.ipc.MessageType;
import csheets.ipc.persistence.chatParticipantsMessage.ChatUser;
import csheets.ui.ctrl.UIController;
import java.io.IOException;
import java.io.Serializable;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class SendChatParticipantsController implements Observer, Serializable {

//    private final UIController uiController;
//    private final SendChatParticipantsPanel uiPanel;
//
//    private List<String> helloSent;
//
//    private final ConnectionManager conMgr;

    public SendChatParticipantsController(UIController uiController, SendChatParticipantsPanel uiPanel) {
//        this.uiController = uiController;
//        this.uiPanel = uiPanel;
//
//        this.conMgr = ConnectionManager.getInstance();
//        this.conMgr.addObserver(this);
//
//        this.helloSent = new ArrayList<>();
//
//        if (!this.conMgr.isConnected()) {
//            this.conMgr.connect();
//        }
    }

    @Override
    public void update(Observable o, Object arg) {
//        if (arg != null && arg instanceof Integer) {
//            int value = (int) arg;
//
//            if (value == ConnectionManager.CONNECTED) {
//                uiPanel.enableConnect();
//                uiPanel.enableSend();
//            }
//
//            if (value == ConnectionManager.FOUNDSERVER) {
//                for (String s : this.conMgr.foundRemoteInstances()) {
//                    try {
//                        //                    for (TcpClientConnection con : this.conMgr.getConnections()) {
////                        if (con.getInetAddress().toString().equals(s)) {
////                            continue;
////                        }
////                        try {
//                        connectTo(s);
////                        } catch (IOException ex) {
////                            Logger.getLogger(SendChatParticipantsController.class.getName()).log(Level.SEVERE, null, ex);
////                        }
////                    }
//                    } catch (IOException ex) {
//                        Logger.getLogger(SendChatParticipantsController.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//
//                }
//            }
//        }
//
//        if (arg != null && arg instanceof Message) {
//            Message m = (Message) arg;
//            if (m.getMessageType() == MessageType.CHATPARTICIPANTSMESSAGE) {
//                ChatParticipantsMessage chat = (ChatParticipantsMessage) m.getMessageContent();
//                String ss = chat.getnick();
//                this.uiPanel.displayPopup(chat);
//            }
//
//            if (m.getMessageType() == MessageType.HELLO) {
//                ChatUser u = (ChatUser) m.getMessageContent();
//                this.uiPanel.setUser(u);
//
//            }
//
//        }

    }

    public void connectTo(String remoteAddress) throws IOException {

//        Message m = new Message(MessageType.HELLO, new ChatUser(System.getProperty("user.name"), true), this.conMgr.getLocalAddress());
//
//        if (!this.helloSent.contains(remoteAddress)) {
//            this.conMgr.connectTo(remoteAddress);
//            this.conMgr.send(m);
//            this.helloSent.add(remoteAddress);
//        }
    }

    public void disConnectFrom() throws IOException {
//        for (String remoteAddress : this.helloSent) {
//            Message m = new Message(MessageType.GOODBYE, new ChatUser(System.getProperty("user.name"), false), this.conMgr.getLocalAddress());
//            this.conMgr.send(m);
//            this.conMgr.disconnectFrom(remoteAddress);
//        }
    }

    public void sendChatParticipantsMessage(String nick, String text) throws UnknownHostException, IOException {
//        ChatParticipantsMessage chat = new ChatParticipantsMessage(nick, text);
//
//        Message m = new Message(MessageType.CHATPARTICIPANTSMESSAGE, chat, this.conMgr.getLocalAddress());
//
//        this.conMgr.send(m);
//
//        this.uiPanel.addParticipantsMessage(chat);
    }
}
