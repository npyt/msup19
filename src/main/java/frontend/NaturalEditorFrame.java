package frontend;

import backend.operation.NaturalParameterReference;
import backend.operation.ParameterReference;

import javax.swing.*;
import java.awt.*;

public class NaturalEditorFrame extends EditorFrame {

    private static final int COLUMN_COUNT = 3;
    private final NaturalParameterReference parameterReference;
    private JTextField inputField = new JTextField();

    public NaturalEditorFrame(NaturalParameterReference parameterReference, JTextField modifyTarget, OperationFrame parentFrame) {
        super(modifyTarget, parentFrame);
        this.parameterReference = parameterReference;
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel northPanel = new JPanel();
        JLabel label = new JLabel(parameterReference.getLabelName());
        northPanel.add(label);
        this.inputField.setColumns(COLUMN_COUNT);
        northPanel.add(this.inputField);

        JPanel southPanel = new JPanel();
        southPanel.add(this.applyButton);

        contentPane.add(northPanel, BorderLayout.NORTH);
        contentPane.add(southPanel, BorderLayout.SOUTH);
        this.pack();
        this.setVisible(true);
    }

    public boolean validateInput() {
        try {
            int inputValue = Integer.parseInt(this.inputField.getText());
            if(!this.parameterReference.update(inputValue)) {
                this.promptError();
            }
        } catch (NumberFormatException e){
            this.promptError();
            return false;
        }

        return true;
    }

    private void promptError() {
        String errorMessage = "Ingresar un natural válido";
        JOptionPane.showMessageDialog(this, errorMessage);
    }

    @Override
    public ParameterReference getParameterReference() {
        return this.parameterReference;
    }
}
