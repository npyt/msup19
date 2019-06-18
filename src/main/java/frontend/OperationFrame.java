package frontend;

import backend.model.PhasorOperationException;
import backend.operation.ComplexOperation;
import javax.swing.*;
import java.awt.*;

public class OperationFrame extends JFrame {

    private ComplexOperation operation;

    private final JFrame parentFrame;
    private JTextField firstOperandField;
    private JTextField secondOperandField;
    private JTextField resultField = new JTextField();

    private static final int COLUMN_COUNT = 15;

    public OperationFrame(ComplexOperation operation, JFrame parentFrame) {
        super(Client.FRAME_TITLE);
        Container contentPane = this.getContentPane();
        this.setVisible(true);
        JPanel mainPanel = new JPanel(new BorderLayout());

        this.operation = operation;
        this.parentFrame = parentFrame;

        JPanel operationPanel = this.operationPanel();
        JPanel actionPanel = this.actionPanel();
        JPanel editorPanel = this.editorPanel();

        mainPanel.add(operationPanel, BorderLayout.NORTH);
        mainPanel.add(editorPanel, BorderLayout.CENTER);
        mainPanel.add(actionPanel, BorderLayout.SOUTH);

        contentPane.add(mainPanel);
        this.pack();
        this.addWindowListener(new NComWindowListener());
    }

    private JPanel operationPanel() {
        char operatorChar = this.operation.getOperatorChar();
        JLabel operatorLabel = new JLabel(Character.toString(operatorChar));
        JLabel equalsLabel = new JLabel("=");

        JPanel operationPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.firstOperandField = new JTextField(COLUMN_COUNT);
        this.firstOperandField.setHorizontalAlignment(JLabel.CENTER);
        this.firstOperandField.setEditable(false);
        this.secondOperandField = new JTextField(COLUMN_COUNT);
        this.secondOperandField.setHorizontalAlignment(JLabel.CENTER);
        this.secondOperandField.setEditable(false);
        operationPanel.add(this.firstOperandField);
        operationPanel.add(operatorLabel);
        operationPanel.add(this.secondOperandField);
        operationPanel.add(equalsLabel);

        this.resultField.setColumns(COLUMN_COUNT * 2);
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

    private JPanel editorPanel() {
        String firstOperandName = this.operation.getFirstOperandName();
        JButton firstEditButton = new JButton(firstOperandName);
        firstEditButton.setText("Editar " + firstOperandName);
        firstEditButton.addActionListener(new EditorListener(this.operation.getFirstParameterReference(), this.firstOperandField, this));

        String secondOperandName = this.operation.getSecondOperandName();
        JButton secondEditButton = new JButton(secondOperandName);
        secondEditButton.setText("Editar " + secondOperandName);
        secondEditButton.addActionListener(new EditorListener(this.operation.getSecondParameterReference(), this.secondOperandField, this));

        JPanel editorPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        editorPanel.add(firstEditButton);
        editorPanel.add(secondEditButton);
        return editorPanel;
    }

    public void toggleForm() {
        this.operation.toggleForm();
        String resultString = this.operation.getResultString();
        this.resultField.setText(resultString);
    }

    public void updateResult() {
        try {
            this.operation.operate();
            this.resultField.setText(this.operation.getResultString());
        } catch (PhasorOperationException e) {
            this.resultField.setText("Error!");
        }
    }

    public ComplexOperation getOperation() {
        return this.operation;
    }
}
