package backend.form;

import backend.model.Phasor;
import backend.operation.ParameterReference;
import backend.operation.PhasorParameterReference;

public class PhasorSineForm implements Form {

    @Override
    public Form getOpposite() {
        return new PhasorCosineForm();
    }

    @Override
    public String parse(ParameterReference parameterReference) {
        PhasorParameterReference phasorParameterReference = (PhasorParameterReference) parameterReference;
        Phasor value = phasorParameterReference.getValue();
        if(value.getFuncion().equals(Phasor.TrigFun.SIN)) {
            return value.toString();
        } else {
            value.toSIN();
            return value.toString();
        }
    }
}
