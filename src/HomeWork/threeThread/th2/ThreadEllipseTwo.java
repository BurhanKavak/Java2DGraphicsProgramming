package HomeWork.threeThread.th2;


import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

class Surface extends JPanel implements Runnable {

    private Ellipse2D ellipse;

    private Thread thread;

    private int pos_x = 450;

    private int pos_y = 0;

    private final int RADIUS = 90;



    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setPaint(new Color(64, 0, 64));


        ellipse = new Ellipse2D.Double(pos_x,pos_y,RADIUS,RADIUS);

        g2d.fill(ellipse);
        thread = new Thread(this);
        thread.start();

        g2d.dispose();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }



    @Override
    public void run() {


        if (pos_y < getHeight()-RADIUS){
            pos_y++;
        }

            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
            repaint();

        }



    }

public class ThreadEllipseTwo extends JFrame {

    public ThreadEllipseTwo() {
        initUI();
    }


    private void initUI () {
        add(new Surface());

        setTitle("Thread 2");
        setSize(900,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ThreadEllipseTwo th = new ThreadEllipseTwo();
                th.setVisible(true);
            }
        });
    }
}
