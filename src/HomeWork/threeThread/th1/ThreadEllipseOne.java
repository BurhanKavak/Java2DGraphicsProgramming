package HomeWork.threeThread.th1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

class Surface extends JPanel implements ActionListener {
    private Ellipse2D ellipse;
    private int pos_y;
    private int pos_x;
    private final int RADIUS = 90;
    private final int DELAY = 30;
    private final double delta[] = {0,6};
    private Timer timer;

    public Surface() {

        initTimer();

    }

    private void initTimer() {

        timer = new Timer(DELAY, this);
        timer.start();

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

        pos_x = (w - RADIUS) / 2;

        if (pos_y > h - RADIUS) {
            delta[1] = 0;
            timer.stop();
        }

        pos_y += delta[1];

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

public class ThreadEllipseOne extends JFrame {

    public ThreadEllipseOne() {

        initUI();

    }

    private void initUI() {

        add(new Surface());

        setTitle("Thread Örnek 1");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ThreadEllipseOne t = new ThreadEllipseOne();
                t.setVisible(true);
            }
        });

    }

}
