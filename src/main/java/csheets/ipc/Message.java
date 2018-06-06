/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ipc;

import java.io.Serializable;
import java.net.InetAddress;

/**
 * The message sent and received by cleansheets instances
 * @author smoli
 */
public class Message implements Serializable {

    private final MessageType messageType;

    private final Object content;
    
    private InetAddress address;

    /***
     * The message sent and received by cleansheets instances
     * @param messageType The type of the message (used to cast content to the correct type)
     * @param content The object with the message content
     * @param address The address from were the message has originated
     */
    public Message(MessageType messageType, Object content, InetAddress address) {
        this.messageType = messageType;
        this.content = content;
        this.address = address;
    }
    /***
     * Gets the message type
     * @return message type
     */
    public MessageType getMessageType() {
        return this.messageType;
    }
    
    /***
     * Gets the message content
     * @return message content
     */
    public Object getMessageContent(){
        return this.content;
    }

    /**
     * Gets the address from were the message has originated
     * @return The address from were the message has originated
     */
    public InetAddress geAddress() {
        return this.address;
    }
}
