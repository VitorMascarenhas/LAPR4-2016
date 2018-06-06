package csheets.core.formula.lang;

import csheets.core.Cell;
import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.Expression;
import csheets.core.formula.FunctionParameter;
import csheets.core.formula.compiler.ExcelExpressionCompiler;
import csheets.core.formula.compiler.ExpressionCompiler;
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
public class EvalTest {
    
    private Eval evalInstance;
    private FunctionParameter[] parameters;
    
    public EvalTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.evalInstance = new Eval();
        this.parameters = new FunctionParameter[]{new FunctionParameter(
        Value.Type.UNDEFINED, "Expression", false, "Expression to evaluated in eval function")};
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getIdentifier method, of class Eval.
     */
    @Test
    public void testGetIdentifier() {
        System.out.println("getIdentifier");

        String expResult = "EVAL";
        String result = this.evalInstance.getIdentifier();
        assertEquals(expResult, result);

    }
    
    /**
     * Test of getIdentifier method, of class Eval.
     */
    @Test
    public void testGetIdentifier_error() {
        System.out.println("getIdentifier");

        String expResult = "";
        String result = this.evalInstance.getIdentifier();
        assertNotEquals(expResult, result);

    }

    /**
     * Test of applyTo method, of class Eval.
     * @throws java.lang.Exception Exception
     */
    @Test
    public void testApplyTo() throws Exception {
        System.out.println("applyTo");
        Expression[] args = new Expression[1];
        
        ExcelExpressionCompiler compiler = new ExcelExpressionCompiler();
        
        args[0] = compiler.compile(null, "=2+3");
        
        Value expResult = new Value(5);
        try{
            Value result = this.evalInstance.applyTo(args);
        }catch(IllegalValueTypeException e){
            return;
        }
        
        assertTrue(false);

    }
    
    /**
     * Test of getParameters method, of class Eval.
     */
    @Test
    public void testGetParameters() {
        System.out.println("getParameters");
        Eval instance = new Eval();

        FunctionParameter[] result = instance.getParameters();
        
        assertEquals(this.parameters[0].getValueType(), result[0].getValueType());
        assertEquals(this.parameters[0].getName(), result[0].getName());

    }
    
    /**
     * Test of getParameters method, of class Eval.
     */
    @Test
    public void testGetParametersNotEquals() {
        System.out.println("getParameters Not Equals");

        FunctionParameter[] result = new FunctionParameter[]{new FunctionParameter(
        Value.Type.BOOLEAN, "Test", false, "Expression to evaluated in eval function")};
        
        assertNotEquals(this.parameters[0].getValueType(), result[0].getValueType());
        assertNotEquals(this.parameters[0].getName(), result[0].getName());

    }

    /**
     * Test of isVarArg method, of class Eval.
     */
    @Test
    public void testIsVarArg() {
        System.out.println("isVarArg");

        boolean expResult = true;
        boolean result = this.evalInstance.isVarArg();
        assertEquals(expResult, result);

    }   
    
    /**
     * Test of isVarArg method, of class Eval.
     */
    @Test
    public void testIsVarArgNotTrue() {
        System.out.println("isVarArg Not True");

        boolean expResult = false;
        boolean result = this.evalInstance.isVarArg();
        assertNotEquals(expResult, result);

    }   
}
