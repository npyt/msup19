package backend.form;

import backend.model.ComplexNumber;
import frontend.ComplexEditorFrame;

public interface ComplexForm extends Form {
    void swap(ComplexEditorFrame editorFrame);
    String getFirstOperandPrompt();
    String getSecondParameterPrompt();
    String getSwitchLabel();
    ComplexNumber parse(double firstParameter, double secondParameter);
}
