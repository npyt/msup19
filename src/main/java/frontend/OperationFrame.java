package frontend;

import backend.model.ComplexNumber;
import backend.operation.ComplexOperation;

import javax.swing.*;
import java.awt.*;

public class OperationFrame extends JFrame {

    private JTextField firstOperandField = new OperationField();
    private JTextField secondOperandField = new OperationField();
    private JTextField resultField = new OperationField();
    private JButton firstEditButton = new JButton();
    private JButton secondEditButton = new JButton();

    private ComplexOperation operation;
    private ParameterReference firstOperand = new ParameterReference(this.firstOperandField);
    private ParameterReference secondOperand = new ParameterReference(this.secondOperandField);
    private ComplexNumber result;

    private static final int COLUMN_COUNT = 9;

    public OperationFrame(ComplexOperation operation) {
        super(Client.FRAME_TITLE);
        Container contentPane = this.getContentPane();
        this.setVisible(true);
        JPanel mainPanel = new JPanel(new BorderLayout());

        this.operation = operation;
        char operatorChar = operation.getOperatorChar();
        String firstOperandName = operation.getFirstOperandName();
        this.firstEditButton.setText("Editar " + firstOperandName);
        this.firstEditButton.addActionListener(new EditorListener(this, this.firstOperand));
        String secondOperandName = operation.getSecondOperandName();
        this.secondEditButton.setText("Editar " + secondOperandName);
        this.secondEditButton.addActionListener(new EditorListener(this, this.secondOperand));

        JPanel operationPanel = this.operationPanel(operatorChar);
        JPanel actionPanel = this.actionPanel();
        JPanel editorPanel = this.editorPanel();

        mainPanel.add(operationPanel, BorderLayout.NORTH);
        mainPanel.add(editorPanel, BorderLayout.CENTER);
        mainPanel.add(actionPanel, BorderLayout.SOUTH);

        contentPane.add(mainPanel);
        this.pack();
        this.addWindowListener(new NComWindowListener());
    }

    private JPanel editorPanel() {
        JPanel editorPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        editorPanel.add(this.firstEditButton);
        editorPanel.add(this.secondEditButton);
        return editorPanel;
    }

    private JPanel operationPanel(char operatorChar) {

        JLabel operatorLabel = new JLabel(Character.toString(operatorChar));
        JLabel equalsLabel = new JLabel("=");

        JPanel operationPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        operationPanel.add(this.firstOperandField);
        operationPanel.add(operatorLabel);
        operationPanel.add(this.secondOperandField);
        operationPanel.add(equalsLabel);
        operationPanel.add(this.resultField);
        return operationPanel;
    }

    private JPanel actionPanel() {
        JButton backButton = new JButton("Volver");
        JButton operateButton = new JButton("Cambiar forma");

        JPanel actionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        actionPanel.add(backButton);
        actionPanel.add(operateButton);
        return actionPanel;
    }

    public void updateResult() {
        ComplexNumber z1 = this.firstOperand.getValue();
        ComplexNumber z2 = this.secondOperand.getValue();
        this.result = this.operation.operate(z1, z2);

        this.resultField.setText(result.toString());
    }
}
