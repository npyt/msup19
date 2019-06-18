package backend.form;

import backend.model.Phasor;
import backend.operation.ParameterReference;
import backend.operation.PhasorParameterReference;

public class PhasorCosineForm implements Form {

    @Override
    public Form getOpposite() {
        return new PhasorSineForm();
    }

    @Override
    public String parse(ParameterReference parameterReference) {
        PhasorParameterReference phasorParameterReference = (PhasorParameterReference) parameterReference;
        Phasor value = phasorParameterReference.getValue();
        if(value.getFuncion().equals(Phasor.TrigFun.COS)) {
            return value.toString();
        } else {
            value.toCOS();
            return value.toString();
        }
    }
}
