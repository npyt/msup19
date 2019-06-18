package frontend;

import backend.operation.ComplexParameterReference;
import backend.operation.NaturalParameterReference;
import backend.operation.ParameterReference;
import backend.operation.PhasorParameterReference;

import javax.swing.*;

public class EditorFrameFactory {

    public static EditorFrame buildEditorFrame(ParameterReference parameterReference, JTextField modifyTarget, OperationFrame parentFrame) {
        if(parameterReference instanceof ComplexParameterReference) {
            ComplexParameterReference complexParameterReference = (ComplexParameterReference) parameterReference;
            return new ComplexEditorFrame(complexParameterReference, modifyTarget, parentFrame);
        }

        if(parameterReference instanceof PhasorParameterReference) {
            PhasorParameterReference phasorParameterReference = (PhasorParameterReference) parameterReference;
            return new PhasorEditorFrame(phasorParameterReference, modifyTarget, parentFrame);
        }

        NaturalParameterReference naturalParameterReference = (NaturalParameterReference) parameterReference;
        return new NaturalEditorFrame(naturalParameterReference, modifyTarget, parentFrame);
    }
}
