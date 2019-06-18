package backend.form;


import backend.model.ComplexNumber;
import backend.model.PolarComplex;
import backend.operation.ComplexParameterReference;
import backend.operation.ParameterReference;
import frontend.ComplexEditorFrame;

public class PolarComplexForm implements ComplexForm {

    public void swap(ComplexEditorFrame operationFrame) {
        operationFrame.setActiveForm(new RectangularComplexForm());
    }

    public ComplexNumber parse(double modulus, double argument) {
        return new PolarComplex(modulus, argument);
    }

    public String getFirstOperandPrompt() {
        return "Módulo: ";
    }

    public String getSecondParameterPrompt() {
        return "Argumento: ";
    }

    public String getSwitchLabel() {
        return "Pasar a binómica";
    }

    @Override
    public Form getOpposite() {
        return new RectangularComplexForm();
    }

    @Override
    public String parse(ParameterReference resultParameterReference) {
        ComplexParameterReference parameterReference = (ComplexParameterReference) resultParameterReference;
        return parameterReference.getValue().toPolar().toString();
    }
}
