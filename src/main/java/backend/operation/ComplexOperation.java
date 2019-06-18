package backend.operation;

import backend.model.PhasorOperationException;

public abstract class ComplexOperation {

    public abstract ParameterReference getFirstParameterReference();
    public abstract ParameterReference getSecondParameterReference();
    public abstract ParameterReference getResultParameterReference();

    public abstract void operate() throws PhasorOperationException;

    public abstract String getName();
    public abstract char getOperatorChar();

    public String getFirstOperandName() {
        return this.getFirstParameterReference().getName();
    }
    public String getSecondOperandName() {
        return this.getSecondParameterReference().getName();
    }
}
