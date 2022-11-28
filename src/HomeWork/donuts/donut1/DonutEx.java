package HomeWork.donuts.donut1;

import javax.swing.*;
import java.awt.*;

public class DonutEx extends JFrame {

    public DonutEx() {
        initUI();
    }

    private void initUI() {
        add(new Board());

        setSize(330, 330);

        setTitle("Donut");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                DonutEx donutEx = new DonutEx();
                donutEx.setVisible(true);
            }
        });
    }
}
