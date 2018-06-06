/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ipc.ui;

import csheets.core.Cell;
import csheets.core.CellImpl;
import csheets.core.CellListener;
import csheets.ext.comments.CommentableCell;
import csheets.ipc.AutomaticSharingListener;
import csheets.ipc.CellValueObject;
import csheets.ipc.ConnectionManager;
import csheets.ipc.Message;
import csheets.ipc.MessageType;
import csheets.ipc.SharingIdentifier;
import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.Serializable;
import java.net.UnknownHostException;
import java.util.*;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author smoli
 */
public class StartSharingController extends FocusOwnerAction implements Observer, Serializable {

    private UIController uiController;
    private StartSharingPanel uiPanel;

    private ConnectionManager conMgr;
    private List<Cell> cellsListening;
    private List<Object> cells;

    private int tcpPort;
    private int udpPort;

    public StartSharingController(UIController uiController, StartSharingPanel uiPanel) {
        this.uiController = uiController;
        this.uiPanel = uiPanel;

        this.cells = new ArrayList<>();
        this.cellsListening = new ArrayList<Cell>();
        

        this.conMgr = ConnectionManager.getInstance();
        this.conMgr.addObserver(this);

        if (!this.conMgr.isConnected()) {
            this.conMgr.connect();
        }
    }
    
    public StartSharingController(){
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
                uiPanel.enableSend();
            }

            if (value == ConnectionManager.FOUNDSERVER) {
                uiPanel.addRemoteAddress(this.conMgr.foundRemoteInstances());
            }
        }

        if (arg != null && arg instanceof Message) {
            Message m = (Message) arg;

            switch (m.getMessageType()) {
                case CELLS:
                    uiPanel.handleCells((List<CellValueObject>) m.getMessageContent());
                    break;
                case GOODBYE:
                //uiPanel.handleCells();
                default:
                    break;
            }
        }
    }

    public void connectTo(String remoteAddress) throws IOException {
        this.conMgr.connectTo(remoteAddress);
    }

    public void disConnectFrom(String remoteAddress) throws IOException {
        this.conMgr.disconnectFrom(remoteAddress);
    }

    public void send() throws UnknownHostException, IOException {

        Cell[][] selectedCells = focusOwner.getSelectedCells();

        for (int i = 0; i < selectedCells.length; i++) {
            for (int j = 0; j < selectedCells[i].length; j++) {
                addCell(selectedCells[i][j]);
            }
        }

        Message m = new Message(MessageType.CELLS, this.cells, this.conMgr.getLocalAddress());
        this.conMgr.send(m);

        this.cells.clear();
    }
    
    /**
     * Send changed cellValue and cellstyleObject to other instance of csheets
     * @param cell
     * @throws UnknownHostException
     * @throws IOException 
     */
    public void liveSend(Cell cell, String ip) throws UnknownHostException, IOException{
        
        
        
        if(this.conMgr.isConnected()){
            
            addCell(cell);
            
           try{
            Message valueMessage = new Message(MessageType.CELLS, this.cells, this.conMgr.getLocalAddress());
            
            this.conMgr.sendMessageTo(valueMessage, ip);

           }catch(Exception e){
               System.out.println("Exception on liveSend method of Start Sharing Controller Class");
           }
           
            this.cells.clear();
        }
    }

    
    
    private void addCell(Cell cell) {
        
        CellValueObject v = new CellValueObject(cell);
        if (!this.cells.contains(v)) {
            this.cells.add(v);
        }

    }

    @Override
    protected String getName() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return "Start sharing";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Add cell Listener
     */
    public void addCellListeners(){
        Cell[][] selectedCells = focusOwner.getSelectedCells();
        
        for (int i = 0; i < selectedCells.length; i++) {
            for (int j = 0; j < selectedCells[i].length; j++) {
                cellsListening.add(selectedCells[i][j]);
            }
        }
        for(int i = 0; i < uiPanel.getLstModel().size(); i++){
            String si = uiPanel.getLstModel().getElementAt(i);
            for(Cell cell : cellsListening){
                ((CellImpl)cell).addCellListener(new AutomaticSharingListener(this, si));
            }
        }
    }
    
    /**
     * Removes cell listeners
     */
    public void removeCellListener(){
        for(Cell cell : cellsListening){
            CellListener[] cellListeners = ((CellImpl)cell).getCellListeners();
            for(int i = 0; i < cellListeners.length; i++){
                
                if(cellListeners[i] instanceof AutomaticSharingListener){
                    ((CellImpl)cell).removeCellListener(cellListeners[i]);
                }
            }
        }
    }
    
    
    
}
