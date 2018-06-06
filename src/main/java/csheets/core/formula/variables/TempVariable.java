package csheets.core.formula.variables;

import csheets.core.CellImpl;
import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.Expression;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.core.formula.util.ExpressionVisitor;

/**
 * A temporary variable in a cell
 * @author José Vilela 1010500
 * @author Eduardo Silva
 */
public class TempVariable implements Assignable, Expression {
    //name of the variable
    private final String name;
    //cell of the variable
    private final CellImpl cell;
    
    /**
     * constructor with a name of a variable and her value 
     * @param name a name of a temporary variable
     * @param cell a cell of a temporary variable
     */
    public TempVariable(String name,CellImpl cell){
        this.name = name;
        this.cell = cell;
    } 
    
    /**
     * evaluate the temporary variable
     * @return a value of this temporary variable
     * @throws IllegalValueTypeException if a variable is not valid
     */
    @Override
    public Value evaluate() throws IllegalValueTypeException {
        
        Value value = null;
        if (cell.getTempVariablesList().containsKey(this.name)) {
            value =cell.getTempVariablesList().get(this.name);

        }
        else
            return new Value(new FormulaCompilationException("Invalid variable"));
        return value;
    }
    
    /**
     * Create a new temporary variable in a cell or change her value if exists
     * @param v  value of this temporrary variable
     */
    public void setValue(Value v) {
        cell.setVarValue(this.name, v);
    }

    @Override
    public Object accept(ExpressionVisitor visitor) {
        return null;
    }

    @Override
    public void assignValue(Value newValue) {
        setValue(newValue);
    }
}
