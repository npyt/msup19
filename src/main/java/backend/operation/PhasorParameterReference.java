package backend.operation;

import backend.form.PhasorSineForm;
import backend.model.Phasor;

public class PhasorParameterReference extends ParameterReference {

    private final PhasorOperation parentOperation;
    private Phasor value = new Phasor(1, Phasor.TrigFun.COS, 0, 0);

    public PhasorParameterReference(String parameterName, PhasorOperation parentOperation) {
        super(parameterName);
        this.parentOperation = parentOperation;
    }

    public void update(Phasor value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public Phasor getValue() {
        return this.value;
    }

    public void setValue(Phasor phasor) {
        this.value = phasor;
        this.parentOperation.form = new PhasorSineForm();
    }
}
