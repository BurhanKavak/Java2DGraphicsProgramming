package MovingSprites;

import javax.swing.*;
import java.awt.*;

public class MovingSpriteEx extends JFrame {

    public MovingSpriteEx() {
        initUI();
    }

    private void initUI() {
        add(new Board());
        setTitle("Moving Sprite");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MovingSpriteEx movingSpriteEx = new MovingSpriteEx();
                movingSpriteEx.setVisible(true);
            }
        });
    }
}
