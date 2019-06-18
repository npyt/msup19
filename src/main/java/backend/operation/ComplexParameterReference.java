package backend.operation;

import backend.model.ComplexNumber;
import backend.model.RectangularComplex;

public class ComplexParameterReference extends ParameterReference {
    private ComplexNumber value = new RectangularComplex(0, 0);

    public ComplexParameterReference(String parameterName) {
        super(parameterName);
    }

    public boolean update(ComplexNumber input) {
        this.value = input;

        return true;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public ComplexNumber getValue() {
        return this.value;
    }

    public void setValue(ComplexNumber z) {
        this.value = z;
    }
}
