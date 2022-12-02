package HomeWork.randomBall;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;


public class Surface extends JPanel implements ActionListener {
    private Ellipse2D ellipse;
    private int pos_x = 360;
    private int pos_y = 260;
    private  int RADIUS = 90;
    private final int DELAY = 15;

    private Timer timer;

    private final double delta[] = {3, 3};

    public Surface() {
        initTimer();
    }


    private void initTimer() {
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);


        g2d.setPaint(new Color(64, 0, 64));

        ellipse = new Ellipse2D.Double(pos_x, pos_y, RADIUS, RADIUS);

        g2d.fill(ellipse);

        g2d.dispose();
    }

    private void moveCircle() {
        int w = getWidth();
        int h = getHeight();


        if (pos_x < 0) {

            delta[0]++;
        } else if (pos_x > w - RADIUS) {

            delta[0]--;
        }

        if (pos_y < 0) {

            delta[1]++;
        } else if (pos_y > h - RADIUS) {

            delta[1]--;
        }

        pos_x += delta[0];
        pos_y += delta[1];

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        moveCircle();
        repaint();
    }
}
