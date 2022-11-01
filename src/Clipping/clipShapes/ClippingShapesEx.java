package Clipping.clipShapes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;

class Surface extends JPanel implements ActionListener {

    private Timer timer;

    private double rotate = 1;

    private int pos_x = 8;

    private int pos_y = 8;

    private final double delta[] = {1,1};

    private final int RADIUS = 60;


    public Surface() {
        initTimer();
    }


    private void initTimer() {
        timer = new Timer(10,this);
        timer.start();
    }





    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        Shape oldClip = g2d.getClip();

        int w = getWidth();
        int h = getHeight();

        Rectangle rectangle = new Rectangle(0,0,200,80);

        AffineTransform affineTransform = new AffineTransform();
        affineTransform.rotate(Math.toRadians(rotate),w/2,h/2);
        affineTransform.translate(w/2-100,h/2-40);

        Ellipse2D circle = new Ellipse2D.Double(pos_x,pos_y,RADIUS,RADIUS);

        GeneralPath generalPath = new GeneralPath();
        generalPath.append(affineTransform.createTransformedShape(rectangle),false);

        g2d.clip(circle);
        g2d.clip(generalPath);

        g2d.setPaint(new Color(110,110,110));
        g2d.fill(circle);

        g2d.setClip(oldClip);

        g2d.draw(circle);
        g2d.draw(generalPath);


    }
    public void step() {

        int w = getWidth();
        int h = getHeight();

        rotate += 1;

        if (pos_x < 0) {

            delta[0] = 1;
        } else if (pos_x > w - RADIUS) {

            delta[0] = -1;
        }

        if (pos_y < 0) {

            delta[1] = 1;
        } else if (pos_y > h - RADIUS) {

            delta[1] = -1;
        }

        pos_x += delta[0];
        pos_y += delta[1];
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        step();
        repaint();
    }
}

public class ClippingShapesEx extends JFrame {


    public ClippingShapesEx() {
        initUI();
    }



    private void initUI () {
        add(new Surface());

        setTitle("Clipping Shapes");
        setSize(350,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ClippingShapesEx clippingShapesEx = new ClippingShapesEx();
                clippingShapesEx.setVisible(true);
            }
        });
    }
}
