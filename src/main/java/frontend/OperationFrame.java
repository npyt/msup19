package frontend;

import backend.model.ComplexNumber;
import backend.operation.ParameterReference;
import backend.operation.ComplexOperation;

import javax.swing.*;
import java.awt.*;

public class OperationFrame extends JFrame {

    private ComplexOperation operation;
    private ParameterReference firstParameterReference;
    private ParameterReference secondParameterReference;
    private ComplexNumber result;

    private final JFrame parentFrame;
    private OperationField firstOperandField;
    private OperationField secondOperandField;
    private JTextField resultField = new JTextField();
    private JButton firstEditButton;
    private JButton secondEditButton;

    private static final int COLUMN_COUNT = 9;

    public OperationFrame(ComplexOperation operation, JFrame parentFrame) {
        super(Client.FRAME_TITLE);
        Container contentPane = this.getContentPane();
        this.setVisible(true);
        JPanel mainPanel = new JPanel(new BorderLayout());

        this.operation = operation;
        this.firstParameterReference = operation.getFirstParameterReference();
        this.secondParameterReference = operation.getSecondParameterReference();
        this.parentFrame = parentFrame;
        char operatorChar = operation.getOperatorChar();
        String firstOperandName = operation.getFirstParameterName();
        this.firstEditButton = new EditButton(firstOperandName);
        this.firstEditButton.setText("Editar " + firstOperandName);
        this.firstEditButton.addActionListener(
                new EditorListener(this, this.firstParameterReference));
        String secondOperandName = operation.getSecondParameterName();
        this.secondEditButton = new EditButton(secondOperandName);
        this.secondEditButton.setText("Editar " + secondOperandName);
        this.secondEditButton.addActionListener(
                new EditorListener(this, this.secondParameterReference));

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
        this.firstOperandField = new OperationField(this.firstParameterReference);
        this.secondOperandField = new OperationField(this.secondParameterReference);
        operationPanel.add(this.firstOperandField);
        operationPanel.add(operatorLabel);
        operationPanel.add(this.secondOperandField);
        operationPanel.add(equalsLabel);

        this.resultField.setColumns(COLUMN_COUNT);
        this.resultField.setHorizontalAlignment(JLabel.CENTER);
        this.resultField.setEditable(false);
        operationPanel.add(this.resultField);
        return operationPanel;
    }

    private JPanel actionPanel() {
        JButton backButton = new JButton("Volver");
        JButton toggleFormButton = new JButton("Cambiar forma");
        backButton.addActionListener(new BackButtonListener(this.parentFrame, this));
        toggleFormButton.addActionListener(new OperationFormListener(this));

        JPanel actionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        actionPanel.add(backButton);
        actionPanel.add(toggleFormButton);
        return actionPanel;
    }

    public void updateContent() {
        this.updateResult();
        this.updateComponents();
    }

    private void updateResult() {
        ComplexNumber z1 = this.firstParameterReference.getValue();
        ComplexNumber z2 = this.secondParameterReference.getValue();
        this.result = this.operation.operate(z1, z2);
    }

    private void updateComponents() {
        this.firstOperandField.updateContent();
        this.secondOperandField.updateContent();
        this.resultField.setText(this.result.toString());
    }

    public void toggleForm() {
        String text = this.resultField.getText();
        if(text.isEmpty()){
            return;
        }
        this.result = this.result.toggleForm();
        this.updateComponents();
    }

    public ComplexOperation getOperation() {
        return this.operation;
    }
}
