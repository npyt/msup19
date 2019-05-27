package backend.operation;

import backend.model.ComplexNumber;

public class SubtractOperation implements ComplexOperation {
    public ComplexNumber operate(ComplexNumber z1, ComplexNumber z2) {
        return z1.subtract(z2);
    }

    public String getName() {
        return "Restar complejos";
    }

    public char getOperatorChar() {
        return '-';
    }
}
