package backend.operation;

import backend.model.ComplexNumber;

public class SumOperation extends ComplexOperation {

    private ParameterReference firstAddend = new ParameterReference("sumando");
    private ParameterReference secondAddend = new ParameterReference("sumando");

    public ComplexNumber operate(ComplexNumber z1, ComplexNumber z2) {
        return z1.add(z2);
    }

    @Override
    public ParameterReference getFirstParameterReference() {
        return this.firstAddend;
    }

    @Override
    public ParameterReference getSecondParameterReference() {
        return this.secondAddend;
    }

    public String getName() {
        return "Sumar complejos";
    }

    public char getOperatorChar() {
        return '+';
    }
}
