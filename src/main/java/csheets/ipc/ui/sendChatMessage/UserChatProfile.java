/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ipc.ui.sendChatMessage;

import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author Sara Ramos
 */
public class UserChatProfile implements Serializable
{

    private Long id;
    private int parentId;
    private String nick;
    private boolean isOnline;
    private String username;
    private ImageIcon icon;

    public UserChatProfile(Long id, String nick, boolean isOnline, int parentId, ImageIcon icon)
    {
        this.id = id;
        this.nick = nick;
        this.isOnline = isOnline;
        this.parentId = parentId;
        this.username = System.getProperty("user.name");
        this.icon = icon;
    }

    public Long getId()
    {
        return id;
    }

    public String getNick()
    {
        return nick;
    }

    public boolean isOnline()
    {
        return isOnline;
    }

    public int getParentId()
    {
        return parentId;
    }

    public String getUsername()
    {
        return username;
    }

    protected void setParentId(int parentId)
    {
        this.parentId = parentId;
    }

    public ImageIcon getIcon()
    {
        return icon;
    }
    
    

    @Override
    public String toString()
    {
        String status = "Online";
        if (!isOnline) {
            status = "Offline";
        }
        return nick + " Status: " + status;
    }

}
