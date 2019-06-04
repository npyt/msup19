package frontend;

import javax.swing.*;

public class OperationField extends JTextField {

    private static final int COLUMN_COUNT = 9;

    public OperationField() {
        this.setColumns(COLUMN_COUNT);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setEditable(false);
    }
}
