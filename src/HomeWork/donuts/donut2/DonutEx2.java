package HomeWork.donuts.donut2;




import javax.swing.*;
import java.awt.*;

public class DonutEx2 extends JFrame {

    public DonutEx2() {
        initUI();
    }

    private void initUI() {
        add(new Board2());

        setSize(750, 750);

        setTitle("Donut");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                DonutEx2 donutEx = new DonutEx2();
                donutEx.setVisible(true);
            }
        });
    }
}
