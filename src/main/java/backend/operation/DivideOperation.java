package backend.operation;

import backend.model.ComplexNumber;

public class DivideOperation extends ComplexOperation {

    private ComplexParameterReference dividendParameterReference = new ComplexParameterReference("dividendo");
    private ComplexParameterReference divisorParameterReference = new DivisorReference();
    private ComplexParameterReference resultParameterReference = new ComplexParameterReference("resultado");

    @Override
    public void operate() {
        ComplexNumber dividendValue = this.dividendParameterReference.getValue();
        ComplexNumber divisorValue = this.divisorParameterReference.getValue();
        this.resultParameterReference.setValue(dividendValue.divideBy(divisorValue));
    }

    @Override
    public ParameterReference getFirstParameterReference() {
        return this.dividendParameterReference;
    }

    @Override
    public ParameterReference getSecondParameterReference() {
        return this.divisorParameterReference;
    }

    @Override
    public ParameterReference getResultParameterReference() {
        return null;
    }

    @Override
    public String getName() {
        return "Dividir complejos";
    }

    @Override
    public char getOperatorChar() {
        return '/';
    }
}
