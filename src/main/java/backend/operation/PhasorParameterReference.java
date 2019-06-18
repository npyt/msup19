package backend.operation;

import backend.model.Phasor;

public class PhasorParameterReference extends ParameterReference {

    private Phasor value = new Phasor(1, Phasor.TrigFun.COS, 0, 0);

    public PhasorParameterReference(String parameterName) {
        super(parameterName);
    }

    public void update(Phasor value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }

    public Phasor getValue() {
        return this.value;
    }

    public void setValue(Phasor phasor) {
        this.value = phasor;
    }
}
