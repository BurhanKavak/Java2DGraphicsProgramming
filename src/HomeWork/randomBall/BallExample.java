package HomeWork.randomBall;

import javax.swing.*;
import java.awt.*;

public class BallExample extends JFrame {

    public BallExample () {
        initUI();
    }

    private void initUI() {
        add(new Surface());
        setTitle("Çerçeveye çarpıp dönen top");
        setSize(900, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                BallExample ballExample = new BallExample();
                ballExample.setVisible(true);
            }
        });
    }
}
