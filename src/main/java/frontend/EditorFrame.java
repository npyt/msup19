package frontend;

import backend.model.ComplexNumber;
import frontend.form.Form;
import frontend.form.RectangularForm;

import javax.swing.*;
import java.awt.*;

public class EditorFrame extends JFrame {

    private static final int COLUMN_COUNT = 5;
    private Form activeForm = new RectangularForm();
    private final OperationFrame parentFrame;
    private final ParameterReference parameterReference;

    private JTextField firstParameterField = new JTextField();
    private JTextField secondParameterField = new JTextField();
    private JLabel firstOperandLabel = new JLabel();
    private JLabel secondOperandLabel = new JLabel();
    private JButton toggleFormButton = new JButton();

    public EditorFrame(OperationFrame parentFrame, ParameterReference parameterReference) {
        super(Client.FRAME_TITLE);
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
        this.addWindowListener(new EditorWindowListener(this.parentFrame));
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
        applyButton.addActionListener(new ApplyButtonListener(this));

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

    public void setActiveForm(Form form) {
        this.activeForm = form;
    }

    /**
     * Envia el complejo ingresado al <code>OperationFrame</code> que lo invocó
     */
    public void retrieveContent() {
        String firstOperandString = this.firstParameterField.getText();
        String secondOperandString = this.secondParameterField.getText();
        double firstParameter = Double.parseDouble(firstOperandString);
        double secondParameter = Double.parseDouble(secondOperandString);

        ComplexNumber newValue = this.activeForm.parse(firstParameter, secondParameter);
        this.parameterReference.update(newValue);
        this.parentFrame.updateResult();

        this.setVisible(false);
        this.parentFrame.setEnabled(true);
        this.parentFrame.setAlwaysOnTop(true);
        this.dispose();
    }
}
