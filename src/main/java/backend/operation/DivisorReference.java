package backend.operation;

import backend.model.ComplexNumber;
import backend.model.PolarComplex;

public class DivisorReference extends ComplexParameterReference {

    private static final String PARAMETER_NAME = "divisor";

    public DivisorReference() {
        super(PARAMETER_NAME);
        this.setValue(new PolarComplex(1, 0));
    }

    @Override
    public boolean update(ComplexNumber input) {
        if(!input.isNullComplex()) {
            this.setValue(input);
            return true;
        }
        return false;
    }
}
