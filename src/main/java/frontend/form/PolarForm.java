package frontend.form;


import backend.model.ComplexNumber;
import backend.model.PolarComplex;
import frontend.EditorFrame;

public class PolarForm implements Form {

    public void swap(EditorFrame operationFrame) {
        operationFrame.setActiveForm(new RectangularForm());
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
