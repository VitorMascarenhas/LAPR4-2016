package csheets.core.formula.lang;

import csheets.core.Cell;
import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.Expression;
import csheets.core.formula.Formula;
import csheets.core.formula.Function;
import csheets.core.formula.FunctionParameter;
import csheets.core.formula.compiler.ExpressionCompiler;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.core.formula.compiler.FormulaCompiler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author André Oliveira
 */
public class Eval implements Function {
    
    /**
     * 
     */
    private Cell cell;
    
    /**
     * Parameters of Eval function
     */
    public static final FunctionParameter[] parameters = new FunctionParameter[]{new FunctionParameter(
        Value.Type.UNDEFINED, "Expression", false, "Expression to evaluated in eval function")};

    /**
     * Creates a new instance of Eval
     */
    public Eval() {};

    /**
     * Return the String with the Identifier
     *
     * @return String with the Identifier
     */
    @Override
    public String getIdentifier() {
        return "EVAL";
    }

    /**
     * Applys the Eval value. 
     * The compiler replaces the quotation mark of args[0] parameter by ""
     * 
     * @param args Expression fo eval
     * @return A Value with the correct operation
     * @throws IllegalValueTypeException Exception if occurs
     */
    @Override
    public Value applyTo(Expression[] args) throws IllegalValueTypeException {

        Formula formula = null;
        Value value = args[0].evaluate();
        try {   
            if(!value.isOfType(Value.Type.TEXT)){
                throw new IllegalValueTypeException(value, Value.Type.TEXT);
            }
            //compile the string between () without quotation mark (replace("\"", ""))
            formula = FormulaCompiler.getInstance().compile(this.cell, "=" + value.toString().replace("\"", ""));
        } catch (FormulaCompilationException ex) {
            try {
                Logger.getLogger(Eval.class.getName()).log(Level.SEVERE, null, ex);
                
                formula = FormulaCompiler.getInstance().compile(this.cell, "#" + value.toString().replace("\"", ""));
            } catch (FormulaCompilationException ex1) {
                throw new IllegalValueTypeException(value, Value.Type.ERROR);
            }
        }
        if(formula == null){
            throw new IllegalValueTypeException(value, Value.Type.ERROR);
        }

        return formula.evaluate();
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
     * Sets a Cell
     * @param cell new Cell
     */
    public void setCell(Cell cell) {
        this.cell = cell;
    }
}
