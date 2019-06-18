package backend.operation;

import backend.form.Form;
import backend.form.PolarComplexForm;
import backend.model.ComplexNumber;

public class PowerOperation extends ComplexOperation {

    private ComplexParameterReference baseReference = new ComplexParameterReference("base");
    private NaturalParameterReference exponentReference = new NaturalParameterReference("exponente");
    private ComplexParameterReference resultParameterReference = new ComplexParameterReference("resultado");

    public PowerOperation() {
        super(new PolarComplexForm());
    }

    @Override
    public void operate() {
        int exponent = this.exponentReference.getValue();
        ComplexNumber base = this.baseReference.getValue();
        this.resultParameterReference.setValue(base.power(exponent));
    }

    @Override
    public ParameterReference getFirstParameterReference() {
        return this.baseReference;
    }

    @Override
    public ParameterReference getSecondParameterReference() {
        return this.exponentReference;
    }

    @Override
    public ParameterReference getResultParameterReference() {
        return this.resultParameterReference;
    }

    @Override
    public String getName() {
        return "Elevar complejo";
    }

    @Override
    public char getOperatorChar() {
        return '^';
    }

}
