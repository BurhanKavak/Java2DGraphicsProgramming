package HomeWork.donuts.donut3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;


public class Board3 extends JPanel implements ActionListener {

    private AffineTransform at;
    private Timer timer;
    private final int DELAY = 1;
    private int deg = 0;
    private int move = 30;
    private Ellipse2D ellipse;

    public Board3() {

        initTimer();

    }

    private void initTimer() {

        timer = new Timer(DELAY, this);
        timer.start();

    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh
                = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        double w = getWidth();
        double h = getHeight();

        ellipse = new Ellipse2D.Double(0, 0, 80, 130);
        g2d.setStroke(new BasicStroke(1));

        at = AffineTransform.getTranslateInstance(w / 2, h / 2);
        at.rotate(Math.toRadians(deg));
        g2d.draw(at.createTransformedShape(ellipse));

    }

    private void moveCircle() {

        if (deg == 360) {
            deg = 0;
        }

        deg += move;

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        moveCircle();
        repaint();
    }
}
