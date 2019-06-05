package frontend;

import backend.operation.ParameterReference;

import javax.swing.*;

public class OperationField extends JTextField {

    private static final int COLUMN_COUNT = 9;
    private final ParameterReference boundParameter;

    public OperationField(ParameterReference boundParameter) {
        this.boundParameter = boundParameter;
        this.setColumns(COLUMN_COUNT);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setEditable(false);
    }

    public void updateContent() {
        this.setText(this.boundParameter.getValue().toString());
    }
}
