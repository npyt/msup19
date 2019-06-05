package backend.operation;

import backend.model.ComplexNumber;

public class MultiplyOperation extends ComplexOperation {

    private ParameterReference firstFactor = new ParameterReference("factor");
    private ParameterReference secondFactor = new ParameterReference("factor");

    @Override
    public ComplexNumber operate(ComplexNumber z1, ComplexNumber z2) {
        return z1.multiply(z2);
    }

    @Override
    public ParameterReference getFirstParameterReference() {
        return this.firstFactor;
    }

    @Override
    public ParameterReference getSecondParameterReference() {
        return this.secondFactor;
    }

    @Override
    public String getName() {
        return "Multiplicar complejos";
    }

    @Override
    public char getOperatorChar() {
        return '*';
    }
}
