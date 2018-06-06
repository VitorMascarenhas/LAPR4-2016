/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ipc.ui.chatParticipants;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 *
 * @author ASUS
 */
public class SendChatParticipantsExtension extends Extension{
    public static final String NAME = "Messenger";
    
    public SendChatParticipantsExtension(){
        super(NAME);
    }
    
    /**
     * Returns the user interface extension of this extension
     *
     * @param uiController the user interface controller
     * @return a user interface extension, or null if none is provided
     */
    @Override
    public UIExtension getUIExtension(UIController uiController) {
        return new UIExtensionSendChatParticipants(this, uiController);
    }
}

