package csheets.core.formula.lang;

import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.Expression;
import csheets.core.formula.Function;
import csheets.core.formula.FunctionParameter;

/**
 * Created by berme on 6/2/2016.
 */
public class Block implements Function {
    
    private boolean BLOCK = false;

    /**
     * The unique version identifier used for serialization
     */
    private static final long serialVersionUID = 6022016750L;
    /**
     * The only (but repeatable) parameter: a numeric term
     */
    private static final FunctionParameter[] parameters = new FunctionParameter[]{
            new FunctionParameter(Value.Type.NUMERIC, "Term", false,
                    "A statement which results in a number")
    };

    /**
     * Creates a new block statement.
     */
    public Block() {
        /**
         * Default constructor
         */
    }

    @Override
    public String getIdentifier() {
        return "{";
    }

    @Override
    public Value applyTo(Expression[] args) throws IllegalValueTypeException {
        Value result = null;
        
        if(isRunning()){
            return new Value("");
        }
        
        switchBlock();

        for (Expression expression : args) {
            result = expression.evaluate();
        }
        
        switchBlock();
        
        return result;
    }

    @Override
    public FunctionParameter[] getParameters() {
        return parameters;
    }

    @Override
    public boolean isVarArg() {
        return true;
    }

    @Override
    public String toString() {
        return getIdentifier();
    }
    
    /**
     * Switch DoWhile instruction
     */
    private void switchBlock() {
        BLOCK = !BLOCK;
    }
    
    /**
     * Check if is runnig
     * @return True or False value
     */
    private boolean isRunning() {
        return BLOCK;
    }
}