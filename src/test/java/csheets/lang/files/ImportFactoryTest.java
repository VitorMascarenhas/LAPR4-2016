/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.lang.files;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sara Ramos
 */
public class ImportFactoryTest
{
    
    
    /**
     * Test of importFactory method, of class ImportFactory.
     * Factory creates the class ImporXMLStrategy, instance of ImportStrategy
     */
    @Test
    public void testImportStrategyXML()
    {
        System.out.println("importFactory creates ImportXMLStrategy");
      
        ImportFactory factory = new ImportFactory();
        ImportStrategy result = factory.importStrategy("xml");
        
        assertTrue(result instanceof ImportXMLStrategy);
    }

    /**
     * Test of importStrategy method, of class ImportFactory.
     * ImportFactory doesn't create the class because the method parameter is null
     */
    @Test (expected=IllegalArgumentException.class)
    public void testImportStrategyNULL()
    {
        System.out.println("importFactory doesn't create the class");
      
        ImportFactory factory = new ImportFactory();
        ImportStrategy result = factory.importStrategy("null");
        
        assertTrue(result == null);
    }
    
}
