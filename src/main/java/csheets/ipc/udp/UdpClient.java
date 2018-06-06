/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ipc.udp;

import java.io.IOException;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author smoli
 */
public class UdpClient extends Observable implements Runnable {

    private final DatagramSocket udpSocket;
    private final int udpPort;
    private final int timeout;

    private final Set<String> remoteInstances;

    private final String DISCOVERMESSAGE = "DISC2NA";
    private final String DISCOVERRESPONSE = "DISCACK2NA";

    /**
     * Searches for remote cleansheets instances
     *
     * @param udpPort UDP port
     * @param timeout UDP socket response timeout
     * @throws SocketException
     */
    public UdpClient(int udpPort, int timeout) throws SocketException {
        this.udpPort = udpPort;
        this.timeout = timeout;

        this.remoteInstances = new HashSet<>();

        this.udpSocket = new DatagramSocket();
        this.udpSocket.setBroadcast(true);
        this.udpSocket.setSoTimeout(timeout);
    }

    @Override
    public void run() {

        synchronized (this) {

            while (true) {
                try {
                    HashSet<InetAddress> listOfBroadcasts = new HashSet<>();

                    Enumeration interfaces = NetworkInterface.getNetworkInterfaces();
                    while (interfaces.hasMoreElements()) {
                        NetworkInterface networkInterface = (NetworkInterface) interfaces.nextElement();

                        if (networkInterface.isLoopback() || !networkInterface.isUp()) {
                            continue; //ignora o loopback
                        }

                        for (InterfaceAddress interfaceAddress : networkInterface.
                                getInterfaceAddresses()) {
                            InetAddress broadcast = interfaceAddress.getBroadcast();
                            if (broadcast == null) {
                                continue;
                            }
                            listOfBroadcasts.add(broadcast);
                        }
                    }

                    byte[] data = new byte[this.DISCOVERMESSAGE.length()];
                    data = this.DISCOVERMESSAGE.getBytes();

                    for (InetAddress iNetAddress : listOfBroadcasts) {

                        DatagramPacket request = new DatagramPacket(data, data.length, iNetAddress, this.udpPort);

                        this.udpSocket.send(request);

                        boolean isToContinue = true;

                        while (isToContinue) {
                            try {
                                byte[] receiveBuffer = new byte[this.DISCOVERRESPONSE.length()];

                                DatagramPacket response = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                                this.udpSocket.receive(response);

                                String messageFromServer = new String(response.getData()).trim();

                                if (messageFromServer.equalsIgnoreCase(this.DISCOVERRESPONSE)) { //yey!!! 
                                    this.remoteInstances.add(response.getAddress().getHostAddress());

                                    setChanged();
                                    notifyObservers();
                                }
                            } catch (SocketTimeoutException ex) {
                                isToContinue = false;
                                //Logger.getLogger(UdpClient.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }
                    }

                } catch (IOException ex) {
                    Logger.getLogger(UdpClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }

    public Set<String> foundRemoteInstances() {
        return this.remoteInstances;
    }
}
