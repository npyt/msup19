package backend.operation;

import backend.model.ComplexNumber;

public abstract class ComplexOperation {

    public abstract ComplexNumber operate(ComplexNumber z1, ComplexNumber z2);

    public abstract ParameterReference getFirstParameterReference();
    public abstract ParameterReference getSecondParameterReference();

    public abstract String getName();
    public abstract char getOperatorChar();

    public String getFirstParameterName() {
        return this.getFirstParameterReference().getName();
    }
    public String getSecondParameterName() {
        return this.getSecondParameterReference().getName();
    }

}
