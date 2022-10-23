package Transparency;

import javax.swing.*;
import java.awt.*;

class Surface extends JPanel {


    private void doDrawing (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(Color.blue);

        for (int i = 0; i <= 10; i++) {
            float alpha = i * 0.1f;
            AlphaComposite alcom = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,alpha);
            g2d.setComposite(alcom);
            g2d.fillRect(50*i,20,40,40);
        }
        g2d.dispose();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }


}

public class TransparentRectanglesEx extends JFrame {

    public TransparentRectanglesEx  () {
        initUI();
    }

    private void initUI () {
        add(new Surface());

        setTitle("Opaklık");
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TransparentRectanglesEx transparentRectanglesEx = new TransparentRectanglesEx();
                transparentRectanglesEx.setVisible(true);
            }
        });
    }
}
