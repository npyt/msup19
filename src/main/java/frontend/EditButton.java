package frontend;

import javax.swing.*;

public class EditButton extends JButton {

    private final String operandName;

    public EditButton(String operandName) {
        this.operandName = operandName;
    }

    public String getOperandName() {
        return this.operandName;
    }
}
