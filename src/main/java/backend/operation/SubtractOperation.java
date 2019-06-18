package backend.operation;

import backend.form.Form;
import backend.form.RectangularComplexForm;
import backend.model.ComplexNumber;

public class SubtractOperation extends ComplexOperation {
    private ComplexParameterReference minuendReference = new ComplexParameterReference("minuendo");
    private ComplexParameterReference subtrahendReference = new ComplexParameterReference("sustraendo");
    private ComplexParameterReference resultParameterReference = new ComplexParameterReference("resultado");

    public SubtractOperation() {
        super(new RectangularComplexForm());
    }

    @Override
    public void operate() {
        ComplexNumber minuendValue = this.minuendReference.getValue();
        ComplexNumber subtrahendValue = this.subtrahendReference.getValue();
        this.resultParameterReference.setValue(minuendValue.subtract(subtrahendValue));
    }

    @Override
    public ParameterReference getFirstParameterReference() {
        return this.minuendReference;
    }

    @Override
    public ParameterReference getSecondParameterReference() {
        return this.subtrahendReference;
    }

    @Override
    public ParameterReference getResultParameterReference() {
        return this.resultParameterReference;
    }

    public String getName() {
        return "Restar complejos";
    }

    public char getOperatorChar() {
        return '-';
    }
}
