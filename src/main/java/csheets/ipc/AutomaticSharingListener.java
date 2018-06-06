/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ipc;

import csheets.core.Cell;
import csheets.core.CellListener;
import csheets.ipc.ui.StartSharingController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eduardo Silva
 */
public class AutomaticSharingListener implements CellListener{
    StartSharingController controller;
    private String ip;
    
    public AutomaticSharingListener(StartSharingController controller, String ip){
        this.controller = controller;
        this.ip = ip;
    }
    

    @Override
    public void valueChanged(Cell cell) {
        if(cell != null){
            try {
                notify(cell);
            } catch (IOException ex) {
                Logger.getLogger(AutomaticSharingListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }

    @Override
    public void contentChanged(Cell cell) {
        if(cell != null){
            try {
                notify(cell);
            } catch (IOException ex) {
                Logger.getLogger(AutomaticSharingListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }

    public void dependentsChanged(Cell cell) {
        
    }

    @Override
    public void cellCleared(Cell cell) {
        if(cell != null){
            try {
                notify(cell);
            } catch (IOException ex) {
                Logger.getLogger(AutomaticSharingListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }

    @Override
    public void cellCopied(Cell cell, Cell source) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void notify(Cell cell) throws IOException{
        controller.liveSend(cell, ip);
    }

    @Override
    public void styleChanged(Cell cell) {
        if(cell != null){
            try {
                notify(cell);
            } catch (IOException ex) {
                Logger.getLogger(AutomaticSharingListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
}
