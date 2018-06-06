package csheets.core.formula.variables;

import csheets.core.Value;
import csheets.core.formula.Expression;
import csheets.core.formula.util.ExpressionVisitor;

import java.io.Serializable;
import java.util.Observable;

/**
 * Created by berme on 6/21/2016.
 */
public class GlobalVariable extends Observable implements Assignable, Expression, Serializable {

    /** The unique version identifier used for serialization */
    private static final long serialVersionUID = 62120161150L;

    private String name;

    private Value varValue;

    public GlobalVariable(String name) {
        this.name = name;
        this.varValue = new Value();
    }

    public GlobalVariable(String name, Value value) {
        this.name = name;
        this.varValue = value;
    }

    public void setValue(Value value) {
        this.varValue = value;
    }

    @Override
    public Value evaluate() {
        return this.varValue;
    }

    @Override
    public Object accept(ExpressionVisitor visitor) {
        return visitor.visitGlobal(this);
    }

    public String id(){return this.name;}

    @Override
    public int hashCode() {
        int result = 8;

        return result * 11 + id().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;

        if(obj == null || this.getClass() != obj.getClass()) return false;

        GlobalVariable otherVar = (GlobalVariable) obj;

        return this.id() == otherVar.id();
    }

    @Override
    public void assignValue(Value newValue) {
        setChanged();
        notifyObservers(newValue);
    }
}
