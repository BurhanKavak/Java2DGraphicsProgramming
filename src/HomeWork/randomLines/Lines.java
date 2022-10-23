package HomeWork.randomLines;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

class Surface extends JPanel implements ActionListener {

    private final int DELAY = 1500;
    private Timer timer;

    public Surface() {

        initTimer();
    }

    private void initTimer() {

        timer = new Timer(DELAY, this);
        timer.start();
    }

    public Timer getTimer() {

        return timer;
    }

    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;


        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        g2d.setPaint(Color.black);

        int w = getWidth();
        int h = getHeight();
        int x1,y1,x2,y2;

        Random r = new Random();

        float a = r.nextFloat();
        float b = r.nextFloat();
        float c = r.nextFloat();

        float [] dash = {a,b,c};

        for (int i = 0; i < 7; i++) {

            BasicStroke basicStroke = new BasicStroke(r.nextFloat() * 10 ,BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_ROUND,10f,dash,10f);
            g2d.setStroke(basicStroke);


            x1 = Math.abs(r.nextInt()) % w;
            y1 = Math.abs(r.nextInt()) % h;
            x2 = Math.abs(r.nextInt()) % w;
            y2 = Math.abs(r.nextInt()) % h;

            GradientPaint gp1 = new GradientPaint(10, 10,
                    Color.blue, 20, 20, Color.black, true);


            g2d.setPaint(gp1);
            g2d.drawLine(x1, y1, x2, y2);
        }
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

public class Lines extends JFrame {

    public Lines() {

        initUI();
    }

    private void initUI() {

        final Surface surface = new Surface();
        add(surface);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Timer timer = surface.getTimer();
                timer.stop();
            }
        });

        setTitle("Random Lines");
        setSize(500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                Lines ex = new Lines();
                ex.setVisible(true);
            }
        });
    }
}
