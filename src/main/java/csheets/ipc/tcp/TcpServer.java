/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ipc.tcp;

import csheets.ipc.ConnectionManager;
import java.io.IOException;
import java.net.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Handles TCP connections from remote instances
 *
 * @author smoli
 */
public class TcpServer implements Runnable {

    private final int tcpPort;
    private final ServerSocket serverSocket;
    private boolean isToRunServer;
    private final Map<InetAddress, Socket> connectedInstances;

    /**
     * *
     * Handles TCP connections from remote instances
     *
     * @param tcpPort TCP port to listen to incoming requests
     * @throws IOException
     */
    public TcpServer(int tcpPort) throws IOException {
        this.tcpPort = tcpPort;

        this.serverSocket = new ServerSocket(tcpPort);

        this.isToRunServer = true;

        this.connectedInstances = new HashMap<>();
    }

    /**
     * *
     * Starts listening to incoming requests
     *
     * @throws java.io.IOException
     */
    public synchronized void startServer() throws IOException {
        while (isToRunServer) {

            Socket clientSocket = this.serverSocket.accept();
            System.out.println("nova ligação");
            System.out.flush();
            TcpServerConnection serverConnection = new TcpServerConnection(clientSocket);
            serverConnection.addObserver(ConnectionManager.getInstance());

            new Thread(serverConnection).start();

            this.connectedInstances.put(clientSocket.getInetAddress(), clientSocket);
        }
    }

    /**
     * *
     * Stops listening to incoming requests
     *
     */
    public synchronized void stopServer() {
        this.isToRunServer = false;

        if (!this.serverSocket.isClosed()) {
            try {
                this.serverSocket.close();
            } catch (IOException ex) {
                Logger.getLogger(TcpServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * *
     * Get the clients connected to this cleansheets instance
     *
     * @return the connected clients
     */
    public synchronized Map<InetAddress, Socket> getConnectedInstances() {
        return this.connectedInstances;
    }

    @Override
    public void run() {
        try {
            System.out.println("start server");
            startServer();
        } catch (IOException ex) {
            Logger.getLogger(TcpServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
