package frontend;

import backend.model.ComplexNumber;
import backend.model.RectangularComplex;

import javax.swing.*;

public class ParameterReference {
    private ComplexNumber value = new RectangularComplex(0, 0);
    private JTextField operandField;

    public ParameterReference(JTextField operandField) {
        this.operandField = operandField;
    }

    public void update(ComplexNumber newValue) {
        this.value = newValue;
        this.operandField.setText(newValue.toString());
    }

    public ComplexNumber getValue() {
        return this.value;
    }
}
