package backend.operation;

import backend.model.ComplexNumber;
import backend.model.RectangularComplex;

public class ParameterReference {
    protected String name;
    protected ComplexNumber value = new RectangularComplex(0, 0);

    public ParameterReference(String parameterName) {
        this.name = parameterName;
    }

    public ComplexNumber getValue() {
        return this.value;
    }

    public void setValue(ComplexNumber newValue) {
        this.value = newValue;
    }

    public String getName() {
        return this.name;
    }

    /**
     * Valida si es input es correcto para el parametro que representa. Necesita ser sobreescrito para operaciones
     * con restricciones de parámetros.
     */
    public boolean validate(ComplexNumber input) {
        return true;
    }
}
