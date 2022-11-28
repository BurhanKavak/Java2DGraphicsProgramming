package HomeWork.donuts.donut3;

import javax.swing.*;
import java.awt.*;

public class DonutEx3 extends JFrame {

    public DonutEx3() {
        initUI();
    }

    private void initUI() {
        add(new Board3());

        setSize(750, 750);
        setTitle("Donut");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                DonutEx3 donutEx3 = new DonutEx3();
                donutEx3.setVisible(true);
            }
        });
    }
}
