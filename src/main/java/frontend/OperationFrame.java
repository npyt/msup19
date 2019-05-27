package frontend;

import backend.operation.ComplexOperation;

import javax.swing.*;
import java.awt.*;

public class OperationFrame extends JFrame {

    private static final int COLUMN_COUNT = 3;

    public OperationFrame(ComplexOperation operation) {
        super(operation.getName());
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        this.setVisible(true);
        JPanel jPanel = new JPanel();

        char operatorChar = operation.getOperatorChar();

        JTextField firstOperandField = new JTextField();
        firstOperandField.setColumns(COLUMN_COUNT);
        JLabel operatorLabel = new JLabel(Character.toString(operatorChar));
        JTextField secondOperandField = new JTextField();
        firstOperandField.setColumns(COLUMN_COUNT);

        jPanel.add(firstOperandField);
        jPanel.add(operatorLabel);
        jPanel.add(secondOperandField);
        contentPane.add(jPanel);
    }
}
