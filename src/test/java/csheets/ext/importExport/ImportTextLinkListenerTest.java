/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.importExport;

import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author André Oliveira
 */
public class ImportTextLinkListenerTest {
    
    private ImportTextLinkListener listener;
    private File file;
    private ImportExportTextLinkStrategy importExport;
    
    public ImportTextLinkListenerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        this.file = new File("ext/importExport/file.txt");
        
        this.listener = new ImportTextLinkListener(this.file, this.importExport) {
            @Override
            public void onChange(File file) {
                System.out.println("Just for test");
            }
        };
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of run method, of class ImportTextLinkListener.
     */
    @Test
    public void testRun() {
        System.out.println("run");

        this.listener.run();
        
        long timeStamp = this.listener.getTimeStamp();
        
        //Not modified file
        assertEquals(timeStamp, 0);

    }
   
}
