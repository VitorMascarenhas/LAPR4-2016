package csheets.core.formula.variables;

import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import org.h2.value.ValueLob;

/**
 * Created by berme on 6/21/2016.
 */
public interface Assignable {
//    /**
//     * Returns the value of the cell.
//     * @return the value of the cell
//     */
//    public Value getValue();

    public void assignValue(Value newValue) throws IllegalValueTypeException;
}
