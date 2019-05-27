package frontend;

import backend.operation.SubtractOperation;
import backend.operation.SumOperation;

import javax.swing.*;
import java.awt.*;

public class Client extends JFrame {

    private static final String SUM_OPERATION_NAME = "Sumar complejos";

    public Client() {
        super("nCom");
        this.createPanel();

        this.pack();
        this.setVisible(true);
        this.addWindowListener(new NComWindowListener());
    }


    private void createPanel() {
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        JPanel jPanel = new JPanel();

        JButton sumButton = new OperationButton(new SumOperation(), this);
        JButton subtractButton = new OperationButton(new SubtractOperation(), this);
        jPanel.add(sumButton);
        jPanel.add(subtractButton);

        contentPane.add(jPanel);
    }

    public static void main(String[] args){
        new Client();
    }
}