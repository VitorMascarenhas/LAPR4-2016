package csheets.core.formula.variables.managers;

import csheets.core.Value;
import csheets.core.formula.variables.GlobalVariable;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by berme on 6/21/2016.
 */
public class GlobalVariableManagerTest {
    private String varName = "TestVar";
    @Test
    public void addVariable() throws Exception {
        GlobalVariableManager manager = new GlobalVariableManager();

        GlobalVariable newVariable = new GlobalVariable(varName);

        GlobalVariable result = manager.addVariable(newVariable.id());
        assertTrue(result.equals(newVariable));
        assertTrue(result.countObservers() == 1);
        assertFalse(newVariable == result);
    }

    @Test
    public void addVariableRepeated() throws Exception {
        GlobalVariableManager manager = new GlobalVariableManager();

        GlobalVariable expected = manager.addVariable(varName);
        GlobalVariable result = manager.addVariable(varName);

        assertTrue(result == expected);
    }

    @Test
    public void update() throws Exception {
        GlobalVariableManager manager = new GlobalVariableManager();

        Value initial = new Value("Start");
        Value result = new Value("Final");

        GlobalVariable newVar = manager.addVariable(varName);
        newVar.setValue(initial);

        manager.update(newVar, result);

        assertTrue(newVar.evaluate().equals(result));
    }

    @Test(expected = NullPointerException.class)
    public void updateNonExist() throws Exception {
        GlobalVariableManager manager = new GlobalVariableManager();

        Value result = new Value("Final");
        GlobalVariable newVar = new GlobalVariable(varName);

        manager.update(newVar, result);

        assertFalse(newVar.evaluate().equals(result));
    }

}