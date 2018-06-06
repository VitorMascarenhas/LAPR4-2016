package csheets.core.formula.lang;

import csheets.core.IllegalValueTypeException;
import csheets.core.SpreadsheetImpl;
import csheets.core.Value;
import csheets.core.formula.Expression;
import csheets.core.formula.Function;
import csheets.core.formula.FunctionParameter;
import csheets.ui.sheet.SpreadsheetTable;

import java.util.Iterator;

/**
 * Created by berme on 6/2/2016.
 */
public class For implements Function {
    private static boolean FOR_RUNNING = false;

    /** Parameters: function, function range, condition and condition range */
    public static final FunctionParameter[] parameters = new FunctionParameter[] {
            new FunctionParameter(Value.Type.UNDEFINED, "Initialize", false,
                    "An attribuition to the cell with the starting value"),
            new FunctionParameter(Value.Type.BOOLEAN, "Condition", false,
                    "A condition to evaluate before proceeding"),
            new FunctionParameter(Value.Type.UNDEFINED, "Step", false,
                    "The increment to the starting value"),
            new FunctionParameter(Value.Type.UNDEFINED, "Statement", true,
                    "A statement to execute")
    };

    public For(){};

    @Override
    public String getIdentifier() {
        return "FOR";
    }

    @Override
    public Value applyTo(Expression[] args) throws IllegalValueTypeException {

        if(isRunning()) return new Value("");

        

        Value init = args[0].evaluate();

        switchFor();
        while (args[1].evaluate().toBoolean()) {
            for (int i = 3; i < args.length; i++) {
                args[i].evaluate();
            }

            args[2].evaluate();
        }

        switchFor();

        return new Value("");
    }

    private void switchFor() {
        FOR_RUNNING = !FOR_RUNNING;
    }

    private boolean isRunning() {
        return FOR_RUNNING;
    }

    @Override
    public FunctionParameter[] getParameters() {
        return parameters;
    }

    @Override
    public boolean isVarArg() {
        return true;
    }
}
