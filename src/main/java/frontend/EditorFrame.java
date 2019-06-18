package frontend;

import backend.operation.ParameterReference;

import javax.swing.*;

public abstract class EditorFrame extends JFrame {

    JTextField modifyTarget;
    final JButton applyButton;

    public EditorFrame(JTextField modifyTarget, OperationFrame parentFrame) {
        super(Client.FRAME_TITLE);
        this.modifyTarget = modifyTarget;
        this.applyButton = new JButton("Aplicar");
        this.applyButton.addActionListener(new ApplyButtonListener(this, modifyTarget, parentFrame));
    }

    abstract boolean validateInput();

    public abstract ParameterReference getParameterReference();
}
