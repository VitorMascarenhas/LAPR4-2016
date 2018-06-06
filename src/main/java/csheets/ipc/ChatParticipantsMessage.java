/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ipc;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author ASUS
 */
public class ChatParticipantsMessage implements Serializable {

    private final String nick;
    private final String text;

    /**
     * *
     * Main constructor
     *
     * @param nick The nick of the instance's machine
     * @param text the text of the message
     */
    public ChatParticipantsMessage(String text, String nick) {
        this.text = text;
        this.nick = nick;
    }


    /**
     * Gets the message text
     *
     * @return the text
     */
    public String getText() {
        return text;
    }

    
     public String getnick() {
        return nick;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.text);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        ChatParticipantsMessage c = (ChatParticipantsMessage) obj;

        return this.text.equalsIgnoreCase(c.getText()) && this.nick.equalsIgnoreCase(c.getnick());
    }
    
    @Override
    public String toString(){
        return this.text;
    }
}