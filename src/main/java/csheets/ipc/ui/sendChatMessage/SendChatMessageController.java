/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ipc.ui.sendChatMessage;

import csheets.ipc.ChatMessage;
import csheets.ipc.ConnectionManager;
import csheets.ipc.Message;
import csheets.ipc.MessageType;
import csheets.ui.ctrl.UIController;
import java.io.IOException;
import java.io.Serializable;
import java.net.UnknownHostException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author smoli
 */

public class SendChatMessageController implements Observer, Serializable {

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
    public void update(Observable o, Object arg) {
        
        if (arg != null && arg instanceof Integer) {
            int value = (int) arg;

            if (value == ConnectionManager.CONNECTED) {
                //uiPanel.enableConnect(); //1140411
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
            //added by 1140411
            if(m.getMessageType() == MessageType.HELLO){
                try {
                    if(this.uiPanel.userProfile() == null){
                        this.uiPanel.createUserPanel();
                    }
                    //sendUserChatProfile(this.uiPanel.userProfile(), this.conMgr.getLocalAddress());
                    sendUserChatProfile(this.uiPanel.userProfile());
                } catch (IOException ex) {
                    Logger.getLogger(SendChatMessageController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //added by 1140411
            if(m.getMessageType() == MessageType.PROFILE){
                UserChatProfile user = (UserChatProfile) m.getMessageContent();
                this.uiPanel.addUser(user, m.geAddress().getHostAddress());
            }
            //addedd by 1140411
            if(m.getMessageType() == MessageType.GOODBYE){
                UserChatProfile user = (UserChatProfile) m.getMessageContent();
                //disconnectFrom(m.geAddress().getHostAddress());
                //this.uiPanel.disconnectFrom(m.getAddress().getHostAdress);
            }
        }
    }

    public void connectTo(String remoteAddress) throws IOException {
        this.conMgr.connectTo(remoteAddress);
    }

    public void disConnectFrom(String remoteAddress) throws IOException {
        this.conMgr.disconnectFrom(remoteAddress);
    }

//    public void sendChatMessage(String text, int parentId) throws UnknownHostException, IOException {
//        ChatMessage chat = new ChatMessage(0, text, parentId);
//
//        Message m = new Message(MessageType.CHATMESSAGE, chat, this.conMgr.getLocalAddress());
//
//        this.conMgr.send(m);
//    }

    public void sendChatMessage(int id, String text, int parentId) throws UnknownHostException, IOException {
        ChatMessage chat = new ChatMessage(id + 1, text, parentId);

        Message m = new Message(MessageType.CHATMESSAGE, chat, this.conMgr.getLocalAddress());

        this.conMgr.send(m);
        
        this.uiPanel.addMessage(chat);
    }
    /**
     * 1140411
     * @param id
     * @param text
     * @param parentId
     * @param remoteAddress
     * @throws UnknownHostException
     * @throws IOException 
     */
    public void sendChatMessageTo(int id, String text, int parentId, String remoteAddress) throws UnknownHostException, IOException {
        ChatMessage chat = new ChatMessage(id + 1, text, parentId);

        Message m = new Message(MessageType.CHATMESSAGE, chat, this.conMgr.getLocalAddress());

        this.conMgr.sendMessageTo(m, remoteAddress);
        
        this.uiPanel.addMessage(chat);
    }
    /**
     * added by 1140411 - need to adjust the parameter remoteAdress to adequate the method to sendo for one user
     * @param userProfile
     * @param remoteAddress
     * @throws IOException 
     */
    public void sendUserChatProfile(UserChatProfile userProfile) throws IOException{
              
        Message m = new Message(MessageType.PROFILE, userProfile, this.conMgr.getLocalAddress());
        this.conMgr.send(m);
        //this.conMgr.sendMessageTo(m, remoteAddress);
    }
    /**
     * added by 1140411
     * @param remoteAddress
     * @throws IOException 
     */
    public void sendHello(String remoteAddress) throws IOException{
        connectTo(remoteAddress);
        Message m = new Message(MessageType.HELLO, "HELLO", this.conMgr.getLocalAddress());
        this.conMgr.send(m);
        //this.conMgr.sendMessageTo(m, remoteAddress);
    }
}
