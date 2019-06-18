package frontend;

import backend.operation.ParameterReference;
import backend.operation.ComplexOperation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class OperationListener implements ActionListener {

    private ComplexOperation operation;
    private JFrame mainFrame;

    OperationListener(ComplexOperation operation, JFrame mainFrame) {
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

    private final ParameterReference parameterReference;
    private final JTextField modifyTarget;
    private final OperationFrame parentFrame;

    EditorListener(ParameterReference parameterReference, JTextField modifyTarget, OperationFrame operationFrame) {
        this.parameterReference = parameterReference;
        this.modifyTarget = modifyTarget;
        this.parentFrame = operationFrame;
    }

    public void actionPerformed(ActionEvent e) {
        JFrame editorFrame = EditorFrameFactory.buildEditorFrame(this.parameterReference, this.modifyTarget, this.parentFrame);
        editorFrame.setAlwaysOnTop(true);
        editorFrame.setLocationRelativeTo(this.parentFrame);
        this.parentFrame.setEnabled(false);
    }
}

class ToggleFormListener implements ActionListener {

    private ComplexEditorFrame editorFrame;

    ToggleFormListener(ComplexEditorFrame editorFrame){
        this.editorFrame = editorFrame;
    }

    public void actionPerformed(ActionEvent e) {
        this.editorFrame.toggleForm();
    }
}

class OperationFormListener implements ActionListener {

    private final OperationFrame operationFrame;

    OperationFormListener(OperationFrame operationFrame) {
        this.operationFrame = operationFrame;
    }

    public void actionPerformed(ActionEvent e) {
        this.operationFrame.toggleForm();
    }
}

class ApplyButtonListener implements ActionListener {

    private final JTextField modifyTarget;
    private final OperationFrame parentFrame;
    private EditorFrame editorFrame;

    ApplyButtonListener(EditorFrame editorFrame, JTextField modifyTarget, OperationFrame parentFrame) {
        this.editorFrame = editorFrame;
        this.modifyTarget = modifyTarget;
        this.parentFrame = parentFrame;
    }

    public void actionPerformed(ActionEvent e) {
        if(this.editorFrame.validateInput()) {
            String str = this.editorFrame.getParameterReference().toString();
            this.modifyTarget.setText(str);
            this.parentFrame.updateResult();
            this.parentFrame.setVisible(true);
            this.parentFrame.setEnabled(true);
            this.editorFrame.dispose();
        }
    }
}

class BackButtonListener implements ActionListener {

    private JFrame previousFrame;
    private JFrame currentFrame;

    BackButtonListener(JFrame previousFrame, JFrame currentFrame) {
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

    ChildWindowListener(JFrame parentFrame) {
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
