/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ipc;

/**
 * The type of message being sent and received by cleansheets instances 
 * @author smoli
 */
public enum MessageType {
    CELLS, //Share cell content IPC01.1- Start Sharing
    GOODBYE, //Close connection
    CHATMESSAGE, //Chat message IPC05.1- Chat Send Message
    HELLO, //message to ask to another instance it's user profile//message to send nick and start connection with other instances
    CHATPARTICIPANTSMESSAGE, //Message for chat participants
    PROFILE, //message to send the profile from an instance 
    OFFLINE // to indicate that the user is offline
}
