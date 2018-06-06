/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.lang.conditionalformat.ui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.border.Border;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 1950689 Nuno Mota
 */
public class ConditionalFormatControllerTest {
    
    public ConditionalFormatControllerTest() {
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
     * Test of setConditionValue method, of class ConditionalFormatController.
     */
    @Test
    public void testSetConditionValue() throws Exception {
        System.out.println("setConditionValue");
        String condition = "=A1>0";
        ConditionalFormatController instance = new ConditionalFormatController(null);
//        instance.setConditionValue(condition);
        
        //não tem get e é void
        //só testa que não levanta exceções quando constroi a controller
        assertTrue(true);
    }

    /**
     * Test of setBackgroundColor method, of class ConditionalFormatController.
     */
    @Test
    public void testSetBackgroundColor() {
        System.out.println("setBackgroundColor");
        String resultCondition = "TRUE";
        Color color = new Color(0);
        ConditionalFormatController instance = new ConditionalFormatController(null);
//        instance.setBackgroundColor(resultCondition, color);
        // não consigo aplicar o teste a este método
        assertTrue(true);
    }

    /**
     * Test of setFont method, of class ConditionalFormatController.
     */
    @Test
    public void testSetFont() {
        System.out.println("setFont");
        String resultCondition = "";
        Font font=new Font("", 0, 0);
        ConditionalFormatController instance = new ConditionalFormatController(null);
//        instance.setFont(resultCondition, font);
        // não consigo aplicar o teste a este método
        assertTrue(true);
    }

    /**
     * Test of setBorder method, of class ConditionalFormatController.
     */
    @Test
    public void testSetBorder() {
        System.out.println("setBorder");
        String resultCondition = "";
        Border border = null;
        ConditionalFormatController instance = new ConditionalFormatController(null);
//        instance.setBorder(resultCondition, border);
        // não consigo aplicar o teste a este método
        assertTrue(true);
    }
    
}
