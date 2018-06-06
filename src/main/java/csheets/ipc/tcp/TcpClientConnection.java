/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ipc.tcp;

import csheets.ipc.Message;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents a connection from a client to a remote cleansheets instance
 *
 * @author smoli
 */
public class TcpClientConnection {

    private InetAddress serverAddress;
    private Socket socket;

    private ObjectOutputStream out;
    private ObjectInputStream in;

    /**
     * *
     * Represents a connection from a client to a remote cleansheets instance
     *
     * @param remoteAddress the remote cleansheets address
     * @param tcpPort the port number where the remote instance is accepting
     * connections
     * @throws UnknownHostException
     * @throws IOException
     */
    public TcpClientConnection(String remoteAddress, int tcpPort) throws UnknownHostException, IOException {

        this.serverAddress = InetAddress.getByName(remoteAddress);
        this.socket = new Socket(this.serverAddress, tcpPort);

    }

    /**
     * *
     * Gets the remote server InetAddress
     *
     * @return the remote instance address
     */
    public InetAddress getInetAddress() {
        return this.serverAddress;
    }

    /**
     * *
     *
     * @return
     */
    public Socket getSocket() {
        return this.socket;
    }

    /**
     * *
     * Sends a message to a remote cleansheets instance
     *
     * @param message the message to send to the remote address
     * @throws IOException
     */
    public void send(Message message) throws IOException {
        if (this.socket.isConnected()) {

            createObjectOutputStream();
            this.out.writeObject(message);
            this.out.flush();
            this.out.reset();

            System.out.println("enviou");
            System.out.flush();
        }
    }

    /**
     * *
     * Closes the connection
     *
     * @throws IOException
     */
    public void closeConnection() throws IOException {
        if (!this.socket.isClosed()) {
            this.socket.close();
        }

    }

    private void createObjectOutputStream() throws IOException {
        if (this.out == null) {
            this.out = new ObjectOutputStream(this.socket.getOutputStream());
        }
    }

    private void createObjectInputStream() throws IOException {
        if (this.in == null) {
            this.in = new ObjectInputStream(this.socket.getInputStream());
        }
    }
}
