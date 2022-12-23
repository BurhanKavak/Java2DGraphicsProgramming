package PongGame;

import javax.swing.*;
import java.awt.*;

public class PongGameEx extends JFrame {

    public PongGameEx() {
        initUI();
    }

    private void initUI() {
        add(new Board());
        setTitle("Pong Game");
        setSize(650, 495);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            PongGameEx pongGameEx = new PongGameEx();
            pongGameEx.setVisible(true);
        });
    }
}
