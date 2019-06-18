package backend.operation;

import backend.model.ComplexNumber;

public class RootOperation extends ComplexOperation {
    private ComplexParameterReference argumentReference = new ComplexParameterReference("argumento");
    private NaturalParameterReference indexReference = new NaturalParameterReference("indice");
    private RootsParameterReference resultParameterReference = new RootsParameterReference("resultado");

    @Override
    public ParameterReference getFirstParameterReference() {
        return this.argumentReference;
    }

    @Override
    public ParameterReference getSecondParameterReference() {
        return this.indexReference;
    }

    @Override
    public ParameterReference getResultParameterReference() {
        return this.resultParameterReference;
    }

    @Override
    public void operate() {
        ComplexNumber argument = this.argumentReference.getValue();
        int index = this.indexReference.getValue();
        this.resultParameterReference.setRoots(argument.roots(index));
    }

    @Override
    public String getName() {
        return "Raíces del complejo";
    }

    @Override
    public char getOperatorChar() {
        return '√';
    }
}
