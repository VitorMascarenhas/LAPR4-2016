/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ipc;

import java.io.Serializable;
import java.util.Objects;

/**
 * Represents a chat message sent and received by ckeansheets instances
 *
 * @author smoli
 */
public class ChatMessage implements Serializable {

    private final int id;
    private final String text;
    private final int parentId;

    /**
     * *
     * Main constructor
     *
     * @param id The id of the message
     * @param text the text of the message
     * @param parentId the id of message being replied (zero means parent
     * message)
     */
    public ChatMessage(int id, String text, int parentId) {
        this.id = id;
        this.text = text;
        this.parentId = parentId;
    }

    /**
     * Gets the message id
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the message text
     *
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * Gets the id of the message being replied. (zero means a parent message)
     *
     * @return the parentId
     */
    public int getParentId() {
        return parentId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.text);
        hash = 59 * hash + this.parentId;
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

        ChatMessage c = (ChatMessage) obj;

        return this.id == c.getId() && this.text.equalsIgnoreCase(c.getText()) && this.parentId == c.getParentId();
    }
    
    @Override
    public String toString(){
        return this.text;
    }
}
