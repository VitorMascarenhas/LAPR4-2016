package csheets.core.formula.lang;

import csheets.core.Value;
import csheets.core.formula.Expression;
import csheets.core.formula.FunctionParameter;
import csheets.core.formula.compiler.ExcelExpressionCompiler;
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
public class WhileDoTest {

    private WhileDo WhileDoInstance;
    private FunctionParameter[] parameters;

    public WhileDoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        this.WhileDoInstance = new WhileDo();
        this.parameters = new FunctionParameter[]{
            new FunctionParameter(Value.Type.UNDEFINED, "Iterations", false, "The iterators of expression."),
            new FunctionParameter(Value.Type.BOOLEAN, "Condition", false, "A condition to evaluate before proceeding")};
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getIdentifier method, of class WhileDo.
     */
    @Test
    public void testGetIdentifier() {
        System.out.println("getIdentifier");

        String expResult = "WHILEDO";
        String result = this.WhileDoInstance.getIdentifier();
        assertEquals(expResult, result);

    }

    /**
     * Test of getIdentifier method, of class WhileDo.
     */
    @Test
    public void testGetIdentifierError() {
        System.out.println("getIdentifier");

        String expResult = "";
        String result = this.WhileDoInstance.getIdentifier();
        assertNotEquals(expResult, result);

    }

    /**
     * Test of getParameters method, of class WhileDo.
     */
    @Test
    public void testGetParameters() {
        System.out.println("getParameters");
        WhileDo instance = new WhileDo();

        FunctionParameter[] result = instance.getParameters();

        assertEquals(this.WhileDoInstance.getParameters()[0].getName(), result[0].getName());
        assertEquals(this.WhileDoInstance.getParameters()[0].getValueType(), result[0].getValueType());
        assertEquals(this.WhileDoInstance.getParameters()[1].getName(), result[1].getName());
        assertEquals(this.WhileDoInstance.getParameters()[1].getValueType(), result[1].getValueType());

    }
    
    /**
     * Test of getParameters method, of class WhileDo.
     */
    @Test
    public void testGetParametersNotEquals() {
        System.out.println("getParameters Not Equals");

        FunctionParameter[] result = new FunctionParameter[]{
            new FunctionParameter(Value.Type.NUMERIC, "Test1", false, "The iterators of expression."),
            new FunctionParameter(Value.Type.TEXT, "Test2", false, "A condition to evaluate before proceeding")};

        assertNotEquals(this.WhileDoInstance.getParameters()[0].getName(), result[0].getName());
        assertNotEquals(this.WhileDoInstance.getParameters()[0].getValueType(), result[0].getValueType());
        assertNotEquals(this.WhileDoInstance.getParameters()[1].getName(), result[1].getName());
        assertNotEquals(this.WhileDoInstance.getParameters()[1].getValueType(), result[1].getValueType());

    }

    /**
     * Test of isVarArg method, of class WhileDo.
     */
    @Test
    public void testIsVarArg() {
        System.out.println("isVarArg");

        boolean expResult = true;
        boolean result = this.WhileDoInstance.isVarArg();
        assertEquals(expResult, result);

    }
    
    /**
     * Test of isVarArg method, of class WhileDo.
     */
    @Test
    public void testIsVarArgNotTrue() {
        System.out.println("isVarArg Not True");

        boolean expResult = false;
        boolean result = this.WhileDoInstance.isVarArg();
        assertNotEquals(expResult, result);

    }

}
