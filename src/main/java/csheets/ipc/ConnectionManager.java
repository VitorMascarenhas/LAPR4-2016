/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ipc;

import csheets.ipc.tcp.TcpClientConnection;
import csheets.ipc.tcp.TcpServerConnection;
import csheets.ipc.tcp.TcpServer;
import csheets.ipc.udp.UdpClient;
import csheets.ipc.udp.UdpServer;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.*;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author smoli
 */
public class ConnectionManager extends Observable implements Observer {

    private static ConnectionManager instance = null;

    private final ConfigurationManager cfg = new ConfigurationManager();

    private UdpClient udpClient;
    private UdpServer udpServer;
    private TcpServer tcpServer;

    boolean isConnected = false;

    private Set<String> foundRemoteInstances;

    //private List<TcpClientConnection> connections;
    private Map<String, TcpClientConnection> connections;

    /**
     * Indicates that the server is initialized
     */
    public static final int CONNECTED = 1;

    /**
     * Used to indicate observers that there were remote instances found
     */
    public static final int FOUNDSERVER = 2;

    protected ConnectionManager() {

    }

    /**
     * Returns the unique instance (Singleton pattern)
     *
     * <a href="http://www.javaworld.com/article/2073352/core-java/simply-singleton.html">
     * source </a>
     *
     * @return the unique instance
     */
    public static synchronized ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }

        return instance;
    }

    /**
     * *
     * Indicates if a connection is established
     *
     * @return boolean
     */
    public synchronized boolean isConnected() {
        return this.isConnected;
    }

    /**
     * *
     * A Set with the string representation of the InetAddress of the found
     * remote instances
     *
     * @return a collection with the remote instances found
     */
    public Set<String> foundRemoteInstances() {
        return this.foundRemoteInstances;
    }

    /**
     * *
     * Starts the UDP and TCP servers Starts the UDP client
     */
    public synchronized void connect() {

        try {
            this.udpClient = new UdpClient(cfg.serverUdpPort(), cfg.timeout());
            this.udpClient.addObserver(this);

            this.udpServer = new UdpServer(cfg.serverUdpPort());

            this.tcpServer = new TcpServer(cfg.serverTcpPort());

            new Thread(this.udpServer).start();
            new Thread(this.udpClient).start();
            new Thread(this.tcpServer).start();

            this.connections = new HashMap<>();

            this.isConnected = true;

            setChanged();
            notifyObservers(ConnectionManager.CONNECTED);

        } catch (SocketException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * *
     * Establishes a TCP connections to the remote cleansheets instance
     *
     * @param remoteAddress string representation of the InetAddress
     * @throws IOException the exception
     */
    public synchronized void connectTo(String remoteAddress) throws IOException {
        if (!this.connections.containsKey(remoteAddress)) {
            TcpClientConnection clientConnection = new TcpClientConnection(remoteAddress, cfg.serverTcpPort());

            //new Thread(clientConnection).start();
////        this.getConnections().add(clientConnection);
            this.connections.put(remoteAddress, clientConnection);
        }

//        Message m = new Message(MessageType.GOODBYE, "batatas", null);
//        clientConnection.send(m);
    }

    /**
     * *
     * Closes the TCP connection with a remote cleansheets instance
     *
     * @param remoteAddress string representation of the InetAddress
     * @throws IOException the exception
     */
    public synchronized void disconnectFrom(String remoteAddress) throws IOException {
        for (Map.Entry<String, TcpClientConnection> con : this.getConnections().entrySet()) {
            if (con.getKey().equalsIgnoreCase(remoteAddress)) {
                con.getValue().closeConnection();
                //this.getConnections().remove(con);
                this.connections.remove(remoteAddress);
            }
        }
    }

    /**
     * *
     * Sends a message to the connected remote cleansheets instances
     *
     * @param message the message to send
     * @throws IOException the exception
     */
    public synchronized void send(Message message) throws IOException {

        for (Map.Entry<String, TcpClientConnection> con : this.connections.entrySet()) {
            try {
                con.getValue().send(message);
            } catch (IOException ex) {
                //this.getConnections().remove(con);
                this.connections.remove(con.getKey());
                Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
     /**
     * added by 1140411
     * Sends a message to one especific connected remote cleansheets instances
     *
     * @param message the message to send
     * @param remoteAddress the address to send the message
     * @throws IOException the exception
     */
    public synchronized void sendMessageTo(Message message, String remoteAddress) throws IOException {

        for (Map.Entry<String, TcpClientConnection> con : this.connections.entrySet()) {
            if(con.getKey().equals(remoteAddress)){
               try {
                con.getValue().send(message);
            } catch (IOException ex) {
                //this.getConnections().remove(con);
                this.connections.remove(con.getKey());
                Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
            } 
            }
            
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof UdpClient) {
            this.foundRemoteInstances = this.udpClient.foundRemoteInstances();

            setChanged();
            notifyObservers(ConnectionManager.FOUNDSERVER);
        }

        if (o instanceof TcpServerConnection && arg instanceof Message) {

            setChanged();
            notifyObservers(arg);

        }

    }

    /**
     * *
     * The address of the localhost
     *
     * @return the address of localhost
     * @throws UnknownHostException the exception
     */
    public InetAddress getLocalAddress() throws UnknownHostException {
        return InetAddress.getLocalHost();
    }

    /**
     * @return the connections
     */
    public synchronized Map<String, TcpClientConnection> getConnections() {
        return connections;
    }
}
