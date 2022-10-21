package BasicDrawing.points;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;


class Surface extends JPanel implements ActionListener {
    private final int DELAY  = 150;

    private  Timer timer;

    public Surface () {
        initTimer();
    }


    private void initTimer () {
        timer = new Timer(DELAY,this);
        timer.start();

    }

    private void doDrawing (Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(Color.black);

        int w = getWidth();
        int h = getHeight();

        Random random = new Random();

        for (int i = 0; i<2000; i++){
            int x = Math.abs(random.nextInt()) % w;
            int y = Math.abs(random.nextInt()) % h;
            g2d.drawLine(x,y,x,y);

        }

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public Timer getTimer() {
        return timer;
    }
}

public class PointsEx extends JFrame {

    public PointsEx () {
        initUI();
    }

    private void initUI(){

        final Surface surface = new Surface();
        add(surface);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Timer timer = surface.getTimer();
                timer.stop();
            }
        });

        setTitle("Points");
        setSize(350,250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                PointsEx pointsEx = new PointsEx();
                pointsEx.setVisible(true);
            }
        });
    }
}