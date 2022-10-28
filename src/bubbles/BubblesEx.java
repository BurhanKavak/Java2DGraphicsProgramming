package bubbles;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Random;


class Surface extends JPanel implements ActionListener {

    private ArrayList<Color> myColor = new ArrayList<>();
    private Ellipse2D.Float[] ellipses;
    private double esize[];
    private double maxSize = 0;
    private final int NUMBER_OF_ELLIPSES = 3;
    private final int DELAY = 40;
    private final int INITIAL_DELAY = 150;
    private Timer timer;

    public Surface() {
        initSurface();
        initEllipses();
        initTimer();
    }

    private void initSurface() {

        setBackground(Color.white);
        ellipses = new Ellipse2D.Float[NUMBER_OF_ELLIPSES];
        esize = new double[ellipses.length];

    }

    private void initEllipses() {

        int w = 350;
        int h = 250;

        maxSize = w / 5;

        for (int i = 0; i < ellipses.length; i++) {

            ellipses[i] = new Ellipse2D.Float();
            posRandEllipses(i, maxSize * Math.random(), w, h);
        }
    }

    private void initTimer() {

        timer = new Timer(DELAY, this);
        timer.setInitialDelay(INITIAL_DELAY);
        timer.start();
    }

    private void posRandEllipses(int i, double size, int w, int h) {

        esize[i] = size;
        double x = Math.random() * (w - (maxSize / 2));
        double y = Math.random() * (h - (maxSize / 2));
        ellipses[i].setFrame(x, y, size, size);
    }

    private void doStep(int w, int h) {

        for (int i = 0; i < ellipses.length; i++) {


            esize[i]++;

            if (esize[i] > maxSize) {
                myColor = new ArrayList<>();
                posRandEllipses(i, 45, w, h);

            } else {

                ellipses[i].setFrame(ellipses[i].getX(), ellipses[i].getY(),
                        esize[i], esize[i]);

            }
        }
    }

    private void drawEllipses(Graphics2D g2d) {
        Random random = new Random();

        for (int i = 0; i < ellipses.length; i++) {

            myColor.add(i, new Color(random.nextInt()));
            myColor.remove(i);

            myColor.add(i, new Color(random.nextInt()));
            myColor.remove(i);

            myColor.add(new Color(random.nextInt()));


            g2d.setColor(myColor.get(i));


            g2d.fill(ellipses[i]);
            g2d.draw(ellipses[i]);


        }

    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();

        RenderingHints rh
                = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        Dimension size = getSize();
        doStep(size.width, size.height);
        drawEllipses(g2d);


        g2d.dispose();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        repaint();
    }

}

public class BubblesEx extends JFrame {
    public BubblesEx() {

        initUI();
    }

    private void initUI() {

        add(new Surface());

        setTitle("Bubbles");
        setSize(720, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                BubblesEx ex = new BubblesEx();
                ex.setVisible(true);
            }
        });
    }

}
