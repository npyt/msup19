package backend.form;

import backend.model.ComplexNumber;
import backend.model.RectangularComplex;
import backend.operation.ComplexParameterReference;
import backend.operation.ParameterReference;
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

    @Override
    public Form getOpposite() {
        return new PolarComplexForm();
    }

    @Override
    public String parse(ParameterReference resultParameterReference) {
        ComplexParameterReference complexParameterReference = (ComplexParameterReference) resultParameterReference;
        return complexParameterReference.getValue().toRectangular().toString();
    }
}
