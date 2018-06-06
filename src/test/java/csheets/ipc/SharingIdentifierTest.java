/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ipc;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author VitorMascarenhas1120035
 */
public class SharingIdentifierTest {
    
    public SharingIdentifierTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of returnIp method, of class SharingIdentifier.
     */
    @Test
    public void testReturnIp() {
        System.out.println("returnIp");
        SharingIdentifier instance1 = new SharingIdentifier("Connection1", "192.168.10.1");
        SharingIdentifier instance2 = new SharingIdentifier("Connection2", "192.168.10.2");
        SharingIdentifier instance3 = new SharingIdentifier("Connection3", "192.168.10.3");
        SharingIdentifier instance4 = new SharingIdentifier("Connection4", "192.168.10.4");
        SharingIdentifier instance5 = new SharingIdentifier("Connection5", "192.168.10.5");
        SharingIdentifier instance6 = new SharingIdentifier("Connection6", "192.168.10.6");
        SharingIdentifier instance7 = new SharingIdentifier("Connection7", "192.168.10.7");
        
        String result1 = "192.168.10.1";
        String result2 = "192.168.10.2";
        String result3 = "192.168.10.3";
        String result4 = "192.168.10.4";
        String result5 = "192.168.10.5";
        String result6 = "192.168.10.6";
        String result7 = "192.168.10.7";
        
        assertEquals(result1, instance1.returnIp());
        assertEquals(result2, instance2.returnIp());
        assertEquals(result3, instance3.returnIp());
        assertEquals(result4, instance4.returnIp());
        assertEquals(result5, instance5.returnIp());
        assertEquals(result6, instance6.returnIp());
        assertEquals(result7, instance7.returnIp());
    }
}