package frontend.form;

import backend.model.ComplexNumber;
import backend.model.RectangularComplex;
import frontend.EditorFrame;

public class RectangularForm implements Form {

    public void swap(EditorFrame operationFrame) {
        operationFrame.setActiveForm(new PolarForm());
    }

    public ComplexNumber parse(double realPart, double imaginaryPart) {
        return new RectangularComplex(realPart, imaginaryPart);
    }

    public String getFirstOperandPrompt() {
        return "Parte real: ";
    }

    public String getSecondParameterPrompt() {
        return "Parte imaginaria: ";
    }

    public String getSwitchLabel() {
        return "Pasar a polar";
    }
}
