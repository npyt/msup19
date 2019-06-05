package backend.operation;

import backend.model.ComplexNumber;

public class DivideOperation extends ComplexOperation {

    private ParameterReference dividend = new ParameterReference("dividendo");
    private ParameterReference divisorReference = new DivisorReference();

    @Override
    public ComplexNumber operate(ComplexNumber z1, ComplexNumber z2) {
        return z1.divideBy(z2);
    }

    @Override
    public ParameterReference getFirstParameterReference() {
        return this.dividend;
    }

    @Override
    public ParameterReference getSecondParameterReference() {
        return this.divisorReference;
    }

    @Override
    public String getName() {
        return "Dividir complejos";
    }

    @Override
    public char getOperatorChar() {
        return '/';
    }
}
