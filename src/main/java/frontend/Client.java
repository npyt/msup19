package frontend;

import backend.operation.DivideOperation;
import backend.operation.MultiplyOperation;
import backend.operation.SubtractOperation;
import backend.operation.SumOperation;

import javax.swing.*;
import java.awt.*;

public class Client extends JFrame {

    public static final String FRAME_TITLE = "nCom";

    public Client() {
        super(FRAME_TITLE);
        this.createPanel();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.pack();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setVisible(true);
        this.addWindowListener(new NComWindowListener());
    }


    private void createPanel() {
        Container contentPane = this.getContentPane();
        JPanel jPanel = new JPanel();

        JButton sumButton = new OperationButton(new SumOperation(), this);
        JButton subtractButton = new OperationButton(new SubtractOperation(), this);
        JButton multiplyButton = new OperationButton(new MultiplyOperation(), this);
        JButton divideButton = new OperationButton(new DivideOperation(), this);
        jPanel.add(sumButton);
        jPanel.add(subtractButton);
        jPanel.add(multiplyButton);
        jPanel.add(divideButton);

        contentPane.add(jPanel);
    }

    public static void main(String[] args){
        new Client();
    }
}
