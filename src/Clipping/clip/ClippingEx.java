package Clipping.clip;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

class Surface extends JPanel implements ActionListener {

    private int pos_x = 8;
    private int pos_y = 8;
    private final int RADIUS = 90;
    private final int DELAY = 35;

    private Timer timer;
    private Image image;

    private final double delta[] = { 3, 3 };
    
    public Surface () {
        loadImage();
        determineAndSetImageSize();
        initTimer();
    }

    private void determineAndSetImageSize() {
        int h = image.getHeight(this);
        int w = image.getWidth(this);
        setPreferredSize(new Dimension(w,h));
    }

    private void loadImage() {
        image = new ImageIcon("C:\\Users\\burha\\OneDrive\\Masaüstü\\java2d\\images\\mushrooms.jpg").getImage();
    }

    private void initTimer() {
        timer = new Timer(DELAY,this);
        timer.start();
    }

    private void doDrawing (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.clip(new Ellipse2D.Double(pos_x,pos_y,RADIUS,RADIUS));
        g2d.drawImage(image,0,0,null);

        g2d.dispose();


    }
    private void moveCircle () {
        int w = getWidth();
        int h = getHeight();

        if (pos_x < 0) {

            delta[0] = Math.random() % 4 + 5;
        } else if (pos_x > w - RADIUS) {

            delta[0] = -(Math.random() % 4 + 5);
        }

        if (pos_y < 0 ) {

            delta[1] = Math.random() % 4 + 5;
        } else if (pos_y > h - RADIUS) {

            delta[1] = -(Math.random() % 4 + 5);
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
    moveCircle();
    repaint();

    }
}

public class ClippingEx extends JFrame {

    public ClippingEx () {
        initUI();
    }


    private void initUI () {
        add(new Surface());

        setTitle("Clipping");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ClippingEx clippingEx = new ClippingEx();
                clippingEx.setVisible(true);
            }
        });
    }
}
