/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ipc;

/**
 *
 * @author VitorMascarenhas1120035
 */
public class SharingIdentifier {
    
    private String sharingName;
    
    private String ip;
    
    public SharingIdentifier(String sharingName, String ip) {
        this.sharingName = sharingName;
        this.ip = ip;
    }
    
    public String returnIp() {
        return this.ip;
    }
    
    public String toString() {
        return String.format("%s", this.sharingName);
    }
}
