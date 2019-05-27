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
