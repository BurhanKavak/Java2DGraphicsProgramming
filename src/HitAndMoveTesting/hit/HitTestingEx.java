package HitAndMoveTesting.hit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

class Surface extends JPanel {

    private Rectangle2D rect;
    private Ellipse2D ellipse;
    private float alpha_rectangle;
    private float alpha_ellipse;


    public Surface() {
        initSurface();
    }

    private void initSurface() {

        addMouseListener(new HitTestAdapter());

        rect = new Rectangle2D.Double(20f, 20f, 80f, 50f);
        ellipse = new Ellipse2D.Double(120f, 30f, 60f, 60f);

        alpha_rectangle = 1f;
        alpha_ellipse = 1f;
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(new Color(50, 50, 50));

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha_rectangle));
        g2d.fill(rect);

        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha_ellipse));
        g2d.fill(ellipse);

        g2d.dispose();

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    class RectRunnable implements Runnable {

        private Thread thread;

        public RectRunnable() {
            initThread();
        }

        private void initThread() {

            thread = new Thread(this);
            thread.start();
        }


        @Override
        public void run() {

            while (alpha_rectangle >= 0) {

                repaint();
                alpha_rectangle -= 0.01f;

                if (alpha_rectangle <= 0) {
                    alpha_rectangle = 0;
                }

                try {

                    Thread.sleep(50);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e.getMessage());
                }
            }

        }
    }


    class HitTestAdapter extends MouseAdapter implements Runnable {

        private RectRunnable rectAnimator;
        private Thread ellipseAnimator;

        @Override
        public void mousePressed(MouseEvent e) {

            int x = e.getX();
            int y = e.getY();

            if (rect.contains(x,y)) {
                rectAnimator = new RectRunnable();
            }

            if (ellipse.contains(x,y)){
                ellipseAnimator = new Thread(this);
                ellipseAnimator.start();
            }
        }

        @Override
        public void run() {

            while (alpha_ellipse >= 0) {

                repaint();
                alpha_ellipse -= 0.01f;

                if (alpha_ellipse < 0) {
                    alpha_ellipse = 0;
                }

                try {

                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e.getMessage());
                }
            }

        }
    }

}


public class HitTestingEx extends JFrame {

    public HitTestingEx() {
        initUI();
    }


    private void initUI() {
        add(new Surface());

        setTitle("Hit Testing");
        setSize(250, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                HitTestingEx hitTestingEx = new HitTestingEx();
                hitTestingEx.setVisible(true);
            }
        });
    }
}
