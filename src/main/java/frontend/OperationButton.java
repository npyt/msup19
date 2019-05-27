package frontend;

import backend.operation.ComplexOperation;

import javax.swing.*;
import java.awt.event.ActionListener;

public class OperationButton extends JButton {

    public OperationButton(ComplexOperation operation, JFrame mainFrame) {
        super(operation.getName());
        ActionListener listener = new OperationListener(operation, mainFrame);
        this.addActionListener(listener);
    }
}
