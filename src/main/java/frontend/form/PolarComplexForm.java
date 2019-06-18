package frontend.form;


import backend.model.ComplexNumber;
import backend.model.PolarComplex;
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
}
