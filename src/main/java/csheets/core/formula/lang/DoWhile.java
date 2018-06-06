/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.formula.lang;

import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.Expression;
import csheets.core.formula.Function;
import csheets.core.formula.FunctionParameter;

/**
 *
 * @author André Oliveira
 */
public class DoWhile implements Function {

    private boolean DOWHILE_RUNNING = false;

    /**
     * Parameters of DoWhile function
     */
    public static final FunctionParameter[] parameters = new FunctionParameter[]{
        new FunctionParameter(Value.Type.UNDEFINED, "Statement", false, "A statement to execute"),
        new FunctionParameter(Value.Type.BOOLEAN, "Condition", false, "A condition to evaluate before proceeding")};

    /**
     * Creates a new instance of DoWhile.
     */
    public DoWhile() {};
    
    /**
     * Return the String with the Identifier
     *
     * @return String with the Identifier
     */
    @Override
    public String getIdentifier() {
        return "DOWHILE";
    }

    /**
     * Applys the DoWhile value. 
     * 
     * @param args Expression arguments
     * @return empty value
     * @throws IllegalValueTypeException
     */
    @Override
    public Value applyTo(Expression[] args) throws IllegalValueTypeException {

        if (isRunning()) {
            return new Value("");
        }
        
        Value value = new Value();
        
        switchDoWhile();
        
        do {
            for (int i = 0; i < args.length - 1; i++) {
                value = args[i].evaluate();
            }
        } while (args[args.length - 1].evaluate().toBoolean());

        switchDoWhile();
        
        return new Value("");
    }

    /**
     * Return the funcions parameters
     * @return Parameter array
     */
    @Override
    public FunctionParameter[] getParameters() {
        return parameters;
    }

    /**
     * Check is Arg exists
     * @return boolean value
     */
    @Override
    public boolean isVarArg() {
        return true;
    }
    
    /**
     * Switch DoWhile instruction
     */
    private void switchDoWhile() {
        DOWHILE_RUNNING = !DOWHILE_RUNNING;
    }
    
    /**
     * Check if is runnig
     * @return True or False value
     */
    private boolean isRunning() {
        return DOWHILE_RUNNING;
    }

}
