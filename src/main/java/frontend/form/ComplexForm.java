package frontend.form;

import backend.model.ComplexNumber;
import frontend.ComplexEditorFrame;

public interface ComplexForm {
    void swap(ComplexEditorFrame editorFrame);
    String getFirstOperandPrompt();
    String getSecondParameterPrompt();
    String getSwitchLabel();
    ComplexNumber parse(double firstParameter, double secondParameter);
}
