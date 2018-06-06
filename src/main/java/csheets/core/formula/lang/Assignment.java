package csheets.core.formula.lang;

import csheets.core.formula.variables.Assignable;
import csheets.core.formula.variables.TempVariable;
import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.BinaryOperator;
import csheets.core.formula.Expression;
import csheets.core.formula.compiler.FormulaCompilationException;

/**
 * Created by berme on 6/2/2016.
 */
public class Assignment implements BinaryOperator{
    /** The unique version identifier used for serialization */
    private static final long serialVersionUID = 6022016835L;

    /**
     * Creates a new attribution operator.
     */
    public Assignment()
    {
        /**
         * Default constructor
         */
    }

    /**
     * applies attribution given a right and left operand
     * @param leftOperand   the operand on the left
     * @param rightOperand  the operand on the right
     * @return  returns the return of right operand evaluation
     * @throws IllegalValueTypeException
     */
    @Override
    public Value applyTo(Expression leftOperand, Expression rightOperand) throws IllegalValueTypeException
    {
        
        Value value = rightOperand.evaluate();
        Assignable assignee = (Assignable) leftOperand;

        assignee.assignValue(value);
        return value;
    }

    /**
     * returns identifier
     * @return identifier
     */
    @Override
    public String getIdentifier() {
        return ":=";
    }

    @Override
    public Value.Type getOperandValueType()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
