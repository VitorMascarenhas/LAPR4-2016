package csheets.core.formula.variables.managers;

import csheets.core.Value;
import csheets.core.formula.variables.GlobalVariable;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by berme on 6/21/2016.
 */
public class GlobalVariableManager extends AbstractVariableManager<GlobalVariable> implements Serializable, Observer{
    private Map<String, GlobalVariable> globalVariableMap = new HashMap<>();

    public GlobalVariable addVariable(String name){
        GlobalVariable result = this.globalVariableMap.get(name);

        if (result == null) {
            result = new GlobalVariable(name);
            this.globalVariableMap.put(name, result);
        }

        result.addObserver(this);

        return result;
    }

    @Override
    public void update(Observable o, Object arg) {
        Value value = (Value) arg;
        GlobalVariable variable = this.globalVariableMap.get(((GlobalVariable) o).id());

        variable.setValue(value);
    }
}
