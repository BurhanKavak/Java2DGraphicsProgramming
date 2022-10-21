package BasicDrawing.basicStroke;

import javax.swing.*;
import java.awt.*;

class Surface extends JPanel {


    private void doDrawing (Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        float[] dash1 = {10f, 5f, 10f};
        float[] dash2 = {1f, 1f, 1f};
        float[] dash3 = {4f, 0f, 2f};
        float[] dash4 = {4f, 4f, 1f};

        g2d.drawLine(20,40,250,40);

        BasicStroke bs1 = new BasicStroke(2,BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND,10.0f,dash1,5.0f);

        BasicStroke bs2 = new BasicStroke(2, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 1.0f, dash2, 2f);

        BasicStroke bs3 = new BasicStroke(2, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 1.0f, dash3, 2f);

        BasicStroke bs4 = new BasicStroke(2, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 1.0f, dash4, 2f);

        g2d.setStroke(bs1);
        g2d.drawLine(20,80,250,80);

        g2d.setStroke(bs2);
        g2d.drawLine(20, 120, 250, 120);

        g2d.setStroke(bs3);
        g2d.drawLine(20, 160, 250, 160);

        g2d.setStroke(bs4);
        g2d.drawLine(20, 200, 250, 200);


        g2d.dispose();

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}

public class BasicStrokeEx extends JFrame {

    public BasicStrokeEx () {
        initIU();
    }


    private void initIU() {
        add(new Surface());

        setTitle("Basic Stroke");
        setSize(280,270);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                BasicStrokeEx basicStrokeEx = new BasicStrokeEx();
                basicStrokeEx.setVisible(true);
            }
        });

    }
}
