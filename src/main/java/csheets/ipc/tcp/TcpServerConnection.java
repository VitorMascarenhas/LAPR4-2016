/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ipc.tcp;

import java.io.*;
import java.io.IOException;
import java.net.*;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Representation of a server TCP connection
 *
 * @author smoli
 */
public class TcpServerConnection extends Observable implements Runnable {

    private final Socket clientSocket;

    private ObjectInputStream oInputStream;
    private ObjectOutputStream oOutputStream;

    private boolean isToRun;

    /***
     * Main constructor
     * @param clientSocket 
     * @throws IOException 
     */
    public TcpServerConnection(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;

        this.isToRun = true;
    }

    @Override
    public void run() {

        synchronized (this) {
            try {
                this.oInputStream = new ObjectInputStream(clientSocket.getInputStream());
                this.oOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
            } catch (IOException ex) {
                Logger.getLogger(TcpServerConnection.class.getName()).log(Level.SEVERE, null, ex);
                isToRun = false;
            }

            while (this.isToRun) {
                try {
                    if (this.clientSocket.isConnected()) {

                        //System.out.println("server connection: socket is connected");
                        Object clientMessage = this.oInputStream.readObject();

                        System.out.println("chegou");
                        System.out.flush();

                        setChanged();
                        notifyObservers(clientMessage);

                    } else {
                        this.isToRun = false; //socket is closed. no point in continue looping
                    }
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(TcpServerConnection.class.getName()).log(Level.SEVERE, null, ex);

                    try {
                        this.clientSocket.close();
                        this.isToRun = false;
                    } catch (IOException ex1) {
                        Logger.getLogger(TcpServerConnection.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }

            }

        }
    }

}
