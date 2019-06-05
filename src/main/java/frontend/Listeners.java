package frontend;

import backend.operation.ParameterReference;
import backend.operation.ComplexOperation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class OperationListener implements ActionListener {

    private ComplexOperation operation;
    private JFrame mainFrame;

    public OperationListener(ComplexOperation operation, JFrame mainFrame) {
        this.operation = operation;
        this.mainFrame = mainFrame;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        JFrame complexFrame = new OperationFrame(this.operation, this.mainFrame);
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

class EditorFormListener implements ActionListener {

    private EditorFrame editorFrame;

    public EditorFormListener(EditorFrame editorFrame){
        this.editorFrame = editorFrame;
    }

    public void actionPerformed(ActionEvent e) {
        this.editorFrame.toggleForm();
    }
}

class OperationFormListener implements ActionListener {

    private final OperationFrame operationFrame;

    public OperationFormListener(OperationFrame operationFrame) {
        this.operationFrame = operationFrame;
    }

    public void actionPerformed(ActionEvent e) {
        this.operationFrame.toggleForm();
    }
}

class ApplyButtonListener implements ActionListener {

    private EditorFrame editorFrame;

    public ApplyButtonListener(EditorFrame editorFrame) {
        this.editorFrame = editorFrame;
    }

    public void actionPerformed(ActionEvent e) {
        if(this.editorFrame.validateInput()) {
            this.editorFrame.retrieveContent();
        }
    }
}

class BackButtonListener implements ActionListener {

    private JFrame previousFrame;
    private JFrame currentFrame;

    public BackButtonListener(JFrame previousFrame, JFrame currentFrame) {
        this.previousFrame = previousFrame;
        this.currentFrame = currentFrame;
    }

    public void actionPerformed(ActionEvent e) {
        this.previousFrame.setVisible(true);
        this.previousFrame.setEnabled(true);
        this.currentFrame.setVisible(false);
        this.currentFrame.dispose();
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

class ChildWindowListener extends Frame implements WindowListener {

    private JFrame parentFrame;

    public ChildWindowListener(JFrame parentFrame) {
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
