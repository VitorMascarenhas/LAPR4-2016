package csheets.core.formula.variables.managers;

import csheets.core.Cell;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by berme on 6/21/2016.
 */
public abstract class AbstractVariableManager<T> implements VariableManager<T>, Serializable{
    protected Set<T> variableSet = new HashSet<>();

    public abstract T addVariable(String name);
}
