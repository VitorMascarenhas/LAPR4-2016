package csheets.core.formula.variables.managers;

import csheets.core.Cell;

import java.io.Serializable;

/**
 * Created by berme on 6/21/2016.
 */
public interface VariableManager<T> extends Serializable {
    public T addVariable(String name);
}
