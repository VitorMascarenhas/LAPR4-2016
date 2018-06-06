/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ipc;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Reads configuration values from config.xml
 *
 * @author smoli
 */
public class ConfigurationManager {

    private File xmlFile;
    private Document doc;

    private int tcpPort;
    private int udpPort;
    private int refreshRate; //milliseconds
    private int timeout; //milliseconds

    protected ConfigurationManager() {
        //tenta ler da configuração a porta a utilizar para falar com outros servidores
        xmlFile = new File("config.xml");

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;

        try {
            dBuilder = dbFactory.newDocumentBuilder();

            doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            readValuesFromConfig();

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(ConfigurationManager.class.getName()).log(Level.SEVERE, null, ex);

            //coloca valores por ommissão
            this.udpPort = 9001;
            this.tcpPort = 9002;
            this.refreshRate = 2000;
            this.timeout = 2000;
        }
    }

    /**
     * *
     * *
     * Returns the TCP Port number where the cleansheets instance will be
     * listening to TCP requests
     *
     * @return the TCP port number
     */
    protected int serverTcpPort() {
        return this.tcpPort;
    }

    /**
     * *
     *
     *
     * Returns the UDP Port number where the cleansheets instance will be
     * listening to UDP requests
     *
     * @return the UDP port number
     */
    protected int serverUdpPort() {
        return this.udpPort;
    }

    /**
     * *
     * Used to define the rate used to search for cleansheets instances on the
     * network
     *
     * @return the refresh rate in milliseconds
     */
    protected int searchRefreshRate() {
        return this.refreshRate;
    }

    /**
     * *
     * Used to define the maximum wait time for UDP responses
     *
     * @return the timeout in milliseconds
     */
    protected int timeout() {
        return this.timeout;
    }

    private void readValuesFromConfig() {
        //udp
        NodeList nList = doc.getElementsByTagName("udpPort");
        Element node = (Element) nList.item(0);
        this.udpPort = Integer.parseInt(node.getAttribute("port"));

        //tcp
        nList = doc.getElementsByTagName("tcpPort");
        node = (Element) nList.item(0);
        this.tcpPort = Integer.parseInt(node.getAttribute("port"));

        //refreshRate
        nList = doc.getElementsByTagName("server");
        node = (Element) nList.item(0);
        this.refreshRate = Integer.parseInt(node.getAttribute("refreshRate"));

        //timeout
        nList = doc.getElementsByTagName("server");
        node = (Element) nList.item(0);
        this.timeout = Integer.parseInt(node.getAttribute("timeout"));
    }
}
