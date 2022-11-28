package HomeWork.donuts.donut4;

import javax.swing.*;
import java.awt.*;

public class DonutEx4 extends JFrame {

    public DonutEx4 () {
        initUI();
    }

    private void initUI() {
        add(new Board4());

        setSize(750, 750);
        setTitle("Donut");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                DonutEx4 donutEx4 = new DonutEx4();
                donutEx4.setVisible(true);
            }
        });
    }
}
