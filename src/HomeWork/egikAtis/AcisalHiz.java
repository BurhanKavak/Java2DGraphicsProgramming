package HomeWork.egikAtis;

import javax.swing.*;
import java.awt.*;

public class AcisalHiz extends JFrame {

    public AcisalHiz() {
        initUI();
    }

    private void initUI() {
        add(new Surface());
        setSize(1080, 720);
        setTitle("Eğik atış");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                AcisalHiz acisalHiz = new AcisalHiz();
                acisalHiz.setVisible(true);
            }
        });
    }
    }

