package frontend;

import backend.operation.ComplexOperation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class OperationButton extends JButton {

    private static final Dimension PREFERRED_SIZE = new Dimension(160, 26);

    public OperationButton(ComplexOperation operation, JFrame mainFrame) {
        super(operation.getName());
        this.setPreferredSize(PREFERRED_SIZE);
        ActionListener listener = new OperationListener(operation, mainFrame);
        this.addActionListener(listener);
    }
}