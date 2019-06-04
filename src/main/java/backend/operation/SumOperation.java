package backend.operation;

import backend.model.ComplexNumber;

public class SumOperation implements ComplexOperation {

    public ComplexNumber operate(ComplexNumber z1, ComplexNumber z2) {
        return z1.add(z2);
    }

    public String getName() {
        return "Sumar complejos";
    }

    public char getOperatorChar() {
        return '+';
    }

    public String getFirstOperandName() {
        return "sumando";
    }

    public String getSecondOperandName() {
        return "sumando";
    }
}
