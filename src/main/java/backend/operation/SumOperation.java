package backend.operation;

import backend.form.RectangularComplexForm;
import backend.model.ComplexNumber;

public class SumOperation extends ComplexOperation {

    private ComplexParameterReference firstAddend = new ComplexParameterReference("sumando");
    private ComplexParameterReference secondAddend = new ComplexParameterReference("sumando");
    private ComplexParameterReference resultParameterReference = new ComplexParameterReference("resultado");

    public SumOperation() {
        super(new RectangularComplexForm());
    }

    @Override
    public void operate() {
        ComplexNumber firstAddendValue = this.firstAddend.getValue();
        ComplexNumber secondAddendValue = this.secondAddend.getValue();
        this.resultParameterReference.setValue(firstAddendValue.add(secondAddendValue));
    }

    @Override
    public ParameterReference getFirstParameterReference() {
        return this.firstAddend;
    }

    @Override
    public ParameterReference getSecondParameterReference() {
        return this.secondAddend;
    }

    @Override
    public ParameterReference getResultParameterReference() {
        return this.resultParameterReference;
    }

    public String getName() {
        return "Sumar complejos";
    }

    public char getOperatorChar() {
        return '+';
    }
}
