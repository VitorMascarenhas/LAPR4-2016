package csheets.core.formula.variables;

import csheets.core.Value;
import csheets.core.formula.util.ExpressionVisitor;
import csheets.core.formula.variables.managers.GlobalVariableManager;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

/**
 * Created by berme on 6/21/2016.
 */
public class GlobalVariableTest {
    GlobalVariable testVar = new GlobalVariable("testID");

    @Test
    public void evaluateNumberTest()  {
        Value val = new Value(new Integer(13));
        GlobalVariable var = new GlobalVariable("test", val);

        Value result = var.evaluate();

        assertTrue(result.equals(val));
    }

    @Test
    public void evaluateStringTest()  {
        Value val = new Value(new String("test global"));
        GlobalVariable var = new GlobalVariable("test", val);

        Value result = var.evaluate();

        assertTrue(result.equals(val));
    }

    @Test
    public void evaluateBooleanTest()  {
        Value val = new Value(true);
        GlobalVariable var = new GlobalVariable("test", val);

        Value result = var.evaluate();

        assertTrue(result.equals(val));
    }

    @Test
    public void setValue() {
        Value val = new Value("TestVal");
        this.testVar.setValue(val);

        assertTrue(val.equals(this.testVar.evaluate()));
    }

    @Test
    public void accept()  {
        ExpressionVisitor visitor = mock(ExpressionVisitor.class);
        when(visitor.visitGlobal(this.testVar)).thenReturn(new GlobalVariable("testID"));

        GlobalVariable result = (GlobalVariable) this.testVar.accept(visitor);

        assertTrue(this.testVar.equals(result));
    }

    @Test
    public void id() {
        String expected = "test";
        this.testVar = new GlobalVariable(expected);
        String result = this.testVar.id();

        assertTrue(result.equals(expected));
    }

    @Test
    public void hashCodeTestSuccess()  {
        GlobalVariable var = new GlobalVariable("testID");

        assertTrue(this.testVar.hashCode() == var.hashCode());
    }

    @Test
    public void hashCodeTestDifID()  {
        GlobalVariable var2 = new GlobalVariable("testID2");

        assertFalse(this.testVar.hashCode() == var2.hashCode());
    }

    @Test
    public void equalsTestSuccess() {
        GlobalVariable other = new GlobalVariable("testID");

        assertTrue(this.testVar.equals(other));
    }

    @Test
    public void equalsTestSuccessSameRef()  {
        assertTrue(this.testVar.equals(this.testVar));
    }

    @Test
    public void equalsTestDiffID()  {
        GlobalVariable other = new GlobalVariable("testID2");

        assertFalse(this.testVar.equals(other));
    }

    @Test
    public void equalsTestDiffClass()  {
        Value other = new Value("testID");

        assertFalse(this.testVar.equals(other));
    }

    @Test
    public void equalsTestNull()  {
        assertFalse(this.testVar.equals(null));
    }

    @Test
    public void assignValue()  {
        GlobalVariableManager manager = new GlobalVariableManager();
        GlobalVariable resultVar = manager.addVariable(this.testVar.id());

        this.testVar.addObserver(manager);

        Value val = new Value("Test value");
        this.testVar.assignValue(val);

        assertTrue(val.equals(resultVar.evaluate()));
    }

}