package frontend.form;

import backend.model.ComplexNumber;
import backend.model.RectangularComplex;
import frontend.ComplexEditorFrame;

public class RectangularComplexForm implements ComplexForm {

    public void swap(ComplexEditorFrame operationFrame) {
        operationFrame.setActiveForm(new PolarComplexForm());
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
