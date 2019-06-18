package frontend;

import backend.model.ComplexNumber;
import backend.operation.ComplexParameterReference;
import backend.operation.ParameterReference;
import frontend.form.ComplexForm;
import frontend.form.RectangularComplexForm;

import javax.swing.*;
import java.awt.*;

public class ComplexEditorFrame extends EditorFrame {

    private static final int COLUMN_COUNT = 5;
    private final OperationFrame parentFrame;
    private ComplexForm activeForm = new RectangularComplexForm();
    private final ComplexParameterReference parameterReference;

    private JTextField firstParameterField = new JTextField();
    private JTextField secondParameterField = new JTextField();
    private JLabel firstOperandLabel = new JLabel();
    private JLabel secondOperandLabel = new JLabel();
    private JButton toggleFormButton = new JButton();

    public ComplexEditorFrame(ComplexParameterReference parameterReference, JTextField modifyTarget, OperationFrame parentFrame) {
        super(modifyTarget, parentFrame);

        this.parentFrame = parentFrame;
        this.parameterReference = parameterReference;

        String firstPrompt = this.activeForm.getFirstOperandPrompt();
        String secondPrompt = this.activeForm.getSecondParameterPrompt();

        JPanel northPanel = this.inputPanel(this.firstOperandLabel, this.firstParameterField, firstPrompt);
        JPanel centerPanel = this.inputPanel(this.secondOperandLabel, this.secondParameterField, secondPrompt);
        JPanel southPanel = this.southPanel();

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(northPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(southPanel, BorderLayout.SOUTH);
        Container contentPane = this.getContentPane();
        contentPane.add(mainPanel);
        this.setVisible(true);
        this.pack();
        this.addWindowListener(new ChildWindowListener(parentFrame));
    }

    private JPanel inputPanel(JLabel label, JTextField field, String labelText) {
        label.setText(labelText);
        field.setColumns(COLUMN_COUNT);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.add(label);
        panel.add(field);

        return panel;
    }

    private JPanel southPanel() {
        String switchLabel = this.activeForm.getSwitchLabel();
        this.toggleFormButton.setText(switchLabel);
        this.toggleFormButton.addActionListener(new ToggleFormListener(this));
        JButton applyButton = new JButton("Aplicar");
        applyButton.addActionListener(new ApplyButtonListener(this, this.modifyTarget, this.parentFrame));

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(this.toggleFormButton, BorderLayout.NORTH);
        panel.add(applyButton, BorderLayout.CENTER);

        return panel;
    }

    public void toggleForm() {
        this.activeForm.swap(this);

        String newFirstOperandText = this.activeForm.getFirstOperandPrompt();
        this.firstOperandLabel.setText(newFirstOperandText);

        String newSecondOperandText = this.activeForm.getSecondParameterPrompt();
        this.secondOperandLabel.setText(newSecondOperandText);

        String switchLabel = this.activeForm.getSwitchLabel();
        this.toggleFormButton.setText(switchLabel);
    }

    public void setActiveForm(ComplexForm form) {
        this.activeForm = form;
    }

    public boolean validateInput() {
        String firstInputString = this.firstParameterField.getText();
        String secondInputString = this.secondParameterField.getText();

        double firstInputValue;
        double secondInputValue;

        try {
            firstInputValue = Double.parseDouble(firstInputString);
            secondInputValue = Double.parseDouble(secondInputString);
        } catch (NumberFormatException e) {
            this.promptError();
            return false;
        }

        ComplexNumber input = this.activeForm.parse(firstInputValue, secondInputValue);

        if(!parameterReference.update(input)) {
            this.promptError();
            return false;
        }

        return true;
    }

    public void promptError() {
        String errorMessage = "Ingresar un " + this.parameterReference.getName() + " válido";
        JOptionPane.showMessageDialog(this, errorMessage);
    }

    @Override
    public ParameterReference getParameterReference() {
        return this.parameterReference;
    }
}
