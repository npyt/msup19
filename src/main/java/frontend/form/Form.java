package frontend.form;

import backend.model.ComplexNumber;
import frontend.EditorFrame;

public interface Form {
    void swap(EditorFrame editorFrame);
    String getFirstOperandPrompt();
    String getSecondParameterPrompt();
    String getSwitchLabel();
    ComplexNumber parse(double firstParameter, double secondParameter);
}
