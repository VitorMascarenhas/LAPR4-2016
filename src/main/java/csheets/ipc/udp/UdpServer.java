/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ipc.udp;

import java.io.IOException;
import java.net.*;
import java.util.*;

import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Listens to discover requests from other cleansheets instances
 * @author smoli
 */
public class UdpServer implements Runnable {

    private DatagramSocket udpSocket;
    private boolean isToRun = false;

    private final String DISCOVERMESSAGE = "DISC2NA";
    private final String DISCOVERRESPONSE = "DISCACK2NA";

    private byte[] data;

    /**
     * Listens to "discover requests" from other cleansheets instances
     * @param udpPort the UDP port number
     * @throws java.net.SocketException
     */
    public UdpServer(int udpPort) throws SocketException {
        this.udpSocket = new DatagramSocket(udpPort);
        this.udpSocket.setBroadcast(true);

        this.data = new byte[this.DISCOVERMESSAGE.length()];
    }

    @Override
    public void run() {
        while (true) {
            try {

                DatagramPacket request = new DatagramPacket(data, data.length);
                this.udpSocket.receive(request);

                InetAddress clientIP = request.getAddress();
                int clientPort = request.getPort();

                String msgFromClient = new String(request.getData(), 0, request.getLength());

                if (msgFromClient.equalsIgnoreCase(this.DISCOVERMESSAGE)) {

                    DatagramPacket response = new DatagramPacket(
                            this.DISCOVERRESPONSE.getBytes(),
                            this.DISCOVERRESPONSE.getBytes().length,
                            clientIP,
                            clientPort);
                    this.udpSocket.send(response);
                }

            } catch (IOException ex) {
                //Logger.getLogger(UdpServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //this.udpSocket.close();
        }
    }

}
