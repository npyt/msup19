package frontend;

import backend.operation.ComplexOperation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class OperationListener implements ActionListener {

    private ComplexOperation operation;
    private JFrame mainFrame;

    public OperationListener(ComplexOperation operation, JFrame mainFrame) {
        this.operation = operation;
        this.mainFrame = mainFrame;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        JFrame complexFrame = new OperationFrame(this.operation);
        complexFrame.setVisible(true);
        this.mainFrame.setVisible(false);
        complexFrame.setLocationRelativeTo(this.mainFrame);
    }
}

class EditorListener implements ActionListener {

    private OperationFrame operationFrame;
    private ParameterReference parameterReference;

    public EditorListener(OperationFrame operationFrame, ParameterReference parameterReference) {
        this.operationFrame = operationFrame;
        this.parameterReference = parameterReference;
    }

    public void actionPerformed(ActionEvent e) {
        JFrame editorFrame = new EditorFrame(this.operationFrame, this.parameterReference);
        editorFrame.setAlwaysOnTop(true);
        editorFrame.setLocationRelativeTo(this.operationFrame);
        this.operationFrame.setEnabled(false);
    }
}

class ToggleFormListener implements ActionListener {

    private EditorFrame editorFrame;

    public ToggleFormListener(EditorFrame editorFrame){
        this.editorFrame = editorFrame;
    }

    public void actionPerformed(ActionEvent e) {
        this.editorFrame.toggleForm();
    }
}

class ApplyButtonListener implements ActionListener {

    private EditorFrame editorFrame;

    public ApplyButtonListener(EditorFrame editorFrame) {
        this.editorFrame = editorFrame;
    }

    public void actionPerformed(ActionEvent e) {
        this.editorFrame.retrieveContent();
    }
}

class NComWindowListener extends Frame implements WindowListener {

    public void windowClosing(WindowEvent e) {
        setVisible(false);
        dispose();
        System.exit(0);
    }

    public void windowActivated(WindowEvent e) {}
    public void windowClosed(WindowEvent e){}
    public void windowDeactivated(WindowEvent e){}
    public void windowDeiconified(WindowEvent e){}
    public void windowIconified(WindowEvent e){}
    public void windowOpened(WindowEvent e){}

}

class EditorWindowListener extends Frame implements WindowListener {

    private OperationFrame parentFrame;

    public EditorWindowListener(OperationFrame parentFrame) {
        this.parentFrame = parentFrame;
    }

    public void windowClosing(WindowEvent e) {
        setVisible(false);
        dispose();
        this.parentFrame.setEnabled(true);
    }

    public void windowActivated(WindowEvent e) {}
    public void windowClosed(WindowEvent e){}
    public void windowDeactivated(WindowEvent e){}
    public void windowDeiconified(WindowEvent e){}
    public void windowIconified(WindowEvent e){}
    public void windowOpened(WindowEvent e){}

}
