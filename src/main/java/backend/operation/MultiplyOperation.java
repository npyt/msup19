package backend.operation;

import backend.model.ComplexNumber;

public class MultiplyOperation extends ComplexOperation {

    private ComplexParameterReference firstFactorReference = new ComplexParameterReference("factor");
    private ComplexParameterReference secondFactorReference = new ComplexParameterReference("factor");
    private ComplexParameterReference resultParameterReference = new ComplexParameterReference("resultado");

    @Override
    public void operate() {
        ComplexNumber firstFactorValue = this.firstFactorReference.getValue();
        ComplexNumber secondFactorValue = this.secondFactorReference.getValue();
        this.resultParameterReference.setValue(firstFactorValue.multiply(secondFactorValue));
    }

    @Override
    public ParameterReference getFirstParameterReference() {
        return this.firstFactorReference;
    }

    @Override
    public ParameterReference getSecondParameterReference() {
        return this.secondFactorReference;
    }

    @Override
    public ParameterReference getResultParameterReference() {
        return this.resultParameterReference;
    }

    @Override
    public String getName() {
        return "Multiplicar complejos";
    }

    @Override
    public char getOperatorChar() {
        return '*';
    }
}
