package backend.operation;

import backend.model.ComplexNumber;

public class SubtractOperation extends ComplexOperation {
    private ParameterReference minuendReference = new ParameterReference("minuendo");
    private ParameterReference subtrahendReference = new ParameterReference("sustraendo");

    public ComplexNumber operate(ComplexNumber z1, ComplexNumber z2) {
        return z1.subtract(z2);
    }

    @Override
    public ParameterReference getFirstParameterReference() {
        return this.minuendReference;
    }

    @Override
    public ParameterReference getSecondParameterReference() {
        return this.subtrahendReference;
    }

    public String getName() {
        return "Restar complejos";
    }

    public char getOperatorChar() {
        return '-';
    }
}
