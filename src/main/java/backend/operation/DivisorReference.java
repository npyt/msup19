package backend.operation;

import backend.model.ComplexNumber;
import backend.model.PolarComplex;

public class DivisorReference extends ParameterReference {

    private static final String PARAMETER_NAME = "divisor";

    public DivisorReference() {
        super(PARAMETER_NAME);
        this.value = new PolarComplex(1, 0);
    }

    @Override
    public boolean validate(ComplexNumber input) {
        return !input.isNullComplex();
    }
}
