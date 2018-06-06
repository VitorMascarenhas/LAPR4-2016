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
public class WhileDo implements Function {

    private boolean WHILEDO = false;

    /**
     * Parameters of WhileDo function
     */
    public static final FunctionParameter[] parameters = new FunctionParameter[]{
        new FunctionParameter(Value.Type.UNDEFINED, "Statement", false, "A statement to execute"),
        new FunctionParameter(Value.Type.BOOLEAN, "Condition", false, "A condition to evaluate before proceeding")};

    /**
     * Creates a new instance of WhileDo.
     */
    public WhileDo() {};
    
    /**
     * Return the String with the Identifier
     *
     * @return String with the Identifier
     */
    @Override
    public String getIdentifier() {
        return "WHILEDO";
    }

    /**
     * Applys the WhileDo value. 
     * 
     * @param args Expression arguments
     * @return empty value
     * @throws IllegalValueTypeException
     */
    @Override
    public Value applyTo(Expression[] args) throws IllegalValueTypeException {
        
        Value value = new Value();
        
        if(isRunning()){
            return new Value("");
        }

        switchWhileDo();

        while (args[0].evaluate().toBoolean()) {
            for (int i = 1; i < args.length; i++) {
                value = args[i].evaluate();
            }
        }
        
        switchWhileDo();
        
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
    private void switchWhileDo() {
        WHILEDO = !WHILEDO;
    }
    
    /**
     * Check if is runnig
     * @return True or False value
     */
    private boolean isRunning() {
        return WHILEDO;
    }

}
