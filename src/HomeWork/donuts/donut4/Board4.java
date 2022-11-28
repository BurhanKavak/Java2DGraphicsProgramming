package HomeWork.donuts.donut4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

public class Board4 extends JPanel implements ActionListener {

    private AffineTransform at;
    private Timer timer;
    private final int DELAY = 100;
    private int deg = 0;
    private int move = 15;
    private Ellipse2D ellipse;

    public Board4() {

        initTimer();

    }
    private void initTimer() {

        timer = new Timer(DELAY, this);
        timer.start();

    }

    private void doDrawing(Graphics g){
        double w = getWidth();
        double h = getHeight();

        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh
                = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        ellipse = new Ellipse2D.Double(0, 0, 80, 130);
        g2d.setStroke(new BasicStroke(1));
        at = AffineTransform.getTranslateInstance(w / 2, h / 2);
        at.rotate(Math.toRadians(deg));
        g2d.draw(at.createTransformedShape(ellipse));
    }



    private void doDonat(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;


        double w = getWidth();
        double h = getHeight();


        doDrawing(g);

        for (double deg = 0; deg < 360; deg += 15) {
            AffineTransform at
                    = AffineTransform.getTranslateInstance(w / 2, h / 2);
            at.rotate(Math.toRadians(deg));
            g2d.draw(at.createTransformedShape(ellipse));
        }
    }

    private void moveCircle() {

        if (deg == 360) {
            move = 0;
            timer.stop();
        }
        System.out.println(deg);

        deg += move;

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (deg == 360) {
            doDonat(g);
        } else {
            doDrawing(g);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        moveCircle();
        repaint();
    }
}
