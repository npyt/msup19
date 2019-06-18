package backend.operation;

import backend.form.PhasorSineForm;
import backend.model.Phasor;
import backend.model.PhasorOperationException;

public class PhasorOperation extends ComplexOperation {

    private PhasorParameterReference firstParameterReference = new PhasorParameterReference("fasor", this);
    private PhasorParameterReference secondParameterReference = new PhasorParameterReference("fasor", this);
    private PhasorParameterReference resultParameterReference = new PhasorParameterReference("resultado", this);

    public PhasorOperation() {
        super(new PhasorSineForm());
    }

    @Override
    public ParameterReference getFirstParameterReference() {
        return this.firstParameterReference;
    }

    @Override
    public ParameterReference getSecondParameterReference() {
        return this.secondParameterReference;
    }

    @Override
    public ParameterReference getResultParameterReference() {
        return this.resultParameterReference;
    }

    @Override
    public void operate() throws PhasorOperationException {
        Phasor firstPhasor = this.firstParameterReference.getValue();
        Phasor secondPhasor = this.secondParameterReference.getValue();
        this.resultParameterReference.setValue(firstPhasor.add(secondPhasor));
    }

    @Override
    public String getName() {
        return "Suma de fasores";
    }

    @Override
    public char getOperatorChar() {
        return '+';
    }
}
