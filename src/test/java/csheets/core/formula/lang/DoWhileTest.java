/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.formula.lang;

import csheets.core.Value;
import csheets.core.formula.Expression;
import csheets.core.formula.FunctionParameter;
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
public class DoWhileTest {
    
    private DoWhile doWhileInstance;
    private FunctionParameter[] parameters;
    
    public DoWhileTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.doWhileInstance = new DoWhile();
        this.parameters =  new FunctionParameter[]{
        new FunctionParameter(Value.Type.UNDEFINED, "Iterations", false, "The iterators of expression."),
        new FunctionParameter(Value.Type.BOOLEAN, "Condition", false, "A condition to evaluate before proceeding")};
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getIdentifier method, of class DoWhile.
     */
    @Test
    public void testGetIdentifier() {
        System.out.println("getIdentifier");

        String expResult = "DOWHILE";
        String result = this.doWhileInstance.getIdentifier();
        assertEquals(expResult, result);
    }
    
        /**
     * Test of getIdentifier method, of class DoWhile.
     */
    @Test
    public void testGetIdentifierError() {
        System.out.println("getIdentifier");

        String expResult = "";
        String result = this.doWhileInstance.getIdentifier();
        assertNotEquals(expResult, result);

    }

    /**
     * Test of getParameters method, of class DoWhile.
     */
    @Test
    public void testGetParameters() {
        System.out.println("getParameters");
        DoWhile instance = new DoWhile();

        FunctionParameter[] result = instance.getParameters();
        
        assertEquals(this.doWhileInstance.getParameters()[0].getName(), result[0].getName());
        assertEquals(this.doWhileInstance.getParameters()[0].getValueType(), result[0].getValueType());
        assertEquals(this.doWhileInstance.getParameters()[1].getName(), result[1].getName());
        assertEquals(this.doWhileInstance.getParameters()[1].getValueType(), result[1].getValueType());

    }
    
    /**
     * Test of getParameters method, of class DoWhile.
     */
    @Test
    public void testGetParametersNotEquals() {
        System.out.println("getParameters Not Equals");

        FunctionParameter[] result = new FunctionParameter[]{
        new FunctionParameter(Value.Type.NUMERIC, "Test1", false, "The iterators of expression."),
        new FunctionParameter(Value.Type.TEXT, "Test2", false, "A condition to evaluate before proceeding")};
        
        assertNotEquals(this.doWhileInstance.getParameters()[0].getName(), result[0].getName());
        assertNotEquals(this.doWhileInstance.getParameters()[0].getValueType(), result[0].getValueType());
        assertNotEquals(this.doWhileInstance.getParameters()[1].getName(), result[1].getName());
        assertNotEquals(this.doWhileInstance.getParameters()[1].getValueType(), result[1].getValueType());

    }

    /**
     * Test of isVarArg method, of class DoWhile.
     */
    @Test
    public void testIsVarArg() {
        System.out.println("isVarArg");

        boolean expResult = true;
        boolean result = this.doWhileInstance.isVarArg();
        assertEquals(expResult, result);

    }
    
    /**
     * Test of isVarArg method, of class DoWhile.
     */
    @Test
    public void testIsVarArgNotTrue() {
        System.out.println("isVarArg Not True");

        boolean expResult = false;
        boolean result = this.doWhileInstance.isVarArg();
        assertNotEquals(expResult, result);

    }
}
