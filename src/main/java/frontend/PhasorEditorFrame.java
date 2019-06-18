package frontend;

import backend.model.Phasor;
import backend.model.Phasor.TrigFun;
import backend.operation.ParameterReference;
import backend.operation.PhasorParameterReference;

import javax.swing.*;
import java.awt.*;

public class PhasorEditorFrame extends EditorFrame {

    private static final String[] TRIG_FUNCTIONS = {"sen", "cos"};
    private static final int COLUMN_COUNT = 3;

    private JTextField amplitudeField = new JTextField();
    private JComboBox functionCombo = new JComboBox(TRIG_FUNCTIONS);
    private JTextField frequencyField = new JTextField();
    private JTextField phaseField = new JTextField();
    private PhasorParameterReference parameterReference;

    public PhasorEditorFrame(PhasorParameterReference parameterReference, JTextField modifyTarget, OperationFrame parentFrame) {
        super(modifyTarget, parentFrame);
        this.parameterReference = parameterReference;
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel northPanel = new JPanel();
        JLabel amplitudeLabel = new JLabel("Amplitud:");
        JLabel functionLabel = new JLabel("Funcion:");
        JLabel frequencyLabel = new JLabel("Frecuencia:");
        JLabel phaseLabel = new JLabel("Fase inicial:");
        northPanel.add(amplitudeLabel);
        this.amplitudeField.setColumns(COLUMN_COUNT);
        northPanel.add(this.amplitudeField);
        northPanel.add(functionLabel);
        northPanel.add(this.functionCombo);
        northPanel.add(frequencyLabel);
        this.frequencyField.setColumns(COLUMN_COUNT);
        northPanel.add(this.frequencyField);
        northPanel.add(phaseLabel);
        this.phaseField.setColumns(COLUMN_COUNT);
        northPanel.add(this.phaseField);

        JPanel southPanel = new JPanel();
        southPanel.add(this.applyButton);

        contentPane.add(northPanel, BorderLayout.NORTH);
        contentPane.add(southPanel, BorderLayout.SOUTH);
        this.pack();
        this.setVisible(true);
    }

    @Override
    boolean validateInput() {
        double amplitudeValue;
        double frequencyValue;
        double phaseValue;

        try {
            amplitudeValue = Double.parseDouble(this.amplitudeField.getText());
        } catch (NumberFormatException e) {
            this.promptError("Ingresar una amplitud valida");
            return false;
        }

        try {
            frequencyValue = Double.parseDouble(this.frequencyField.getText());
        } catch (NumberFormatException e) {
            this.promptError("Ingresar una frecuencia valida");
            return false;
        }

        try {
            phaseValue = Double.parseDouble(this.phaseField.getText());
        } catch (NumberFormatException e) {
            this.promptError("Ingresar una fase inicial valida");
            return false;
        }

        String selectedFunctionStr = "sen";
        try {
            selectedFunctionStr = (String) this.functionCombo.getSelectedItem();
        } catch (NullPointerException e) {
            this.promptError("Selecionar una funcion trigonometrica");
        }

        if(selectedFunctionStr.equals("sen")) {
            this.parameterReference.update(new Phasor(amplitudeValue, TrigFun.SIN, frequencyValue, phaseValue));
        } else {
            this.parameterReference.update(new Phasor(amplitudeValue, TrigFun.COS, frequencyValue, phaseValue));
        }
        return true;
    }

    public void promptError(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

    @Override
    public ParameterReference getParameterReference() {
        return this.parameterReference;
    }
}
