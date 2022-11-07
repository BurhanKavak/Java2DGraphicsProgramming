package HomeWork.stickMan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Surface extends JPanel implements ActionListener   {

    Timer t = new Timer(40,this);
    int kafaX = 40,
            kafaIcX = 45,
            govdeX = 75,
            kol1x = 120,
            kol2x = 30,
            bacak1x = 30,
            bacak2x = 120,
            velX = 2,
            adım1X = 8,
            adım2X = -4;


    private void doDrawing (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        Color c = new Color(255,255,255);
        g2d.setBackground(c);
        setBackground(UIManager.getColor("window"));
        g2d.setColor(Color.BLACK);
        BasicStroke bs1 = new BasicStroke(5,BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND);
        g2d.setStroke(bs1);

        g2d.fillOval(kafaX,40,70,70);
        g2d.setColor(Color.WHITE);
        g2d.fillOval(kafaIcX,45,60,60);
        g2d.setColor(Color.BLACK);
        g2d.drawLine(govdeX,110, govdeX,210);

        g2d.drawLine(govdeX,130, kol1x,150);
        g2d.drawLine(govdeX,130, kol2x,150);


        g2d.drawLine(govdeX,210,bacak1x,270);
        g2d.drawLine(govdeX,210,bacak2x,270);

        t.start();


    }

    private void action () {
        if (kol1x >= 600) {
            t.stop();
            return;

        }

        if (govdeX - bacak1x < 6) {
            adım1X = -4;
        }
        if (bacak2x - govdeX < 6) {
            adım2X = 8;
        }

        if (bacak2x < govdeX ) {
            adım2X = 8;
            adım1X = 4;
        } if (bacak2x - govdeX > 45) {
            adım2X = -4;
            adım1X = 8;

        }


        kafaX +=velX;
        kafaIcX +=velX;
        govdeX +=velX;
        kol1x += velX;
        kol2x += velX;
        bacak1x += adım1X;
        bacak2x += adım2X;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        action();
        repaint();


    }
}

public class StickMan extends JFrame {

    public StickMan () {
        initUI();
    }

    private void initUI () {
        Surface surface = new Surface();
        add(surface);

        setTitle("Stick Man");
        setSize(600,400);

        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                StickMan deneme = new StickMan();
                deneme.setVisible(true);
            }
        });
    }
}