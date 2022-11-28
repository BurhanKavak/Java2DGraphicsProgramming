package HomeWork.egikAtis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class Surface extends JPanel implements ActionListener {

    private Ellipse2D ellipse;
    private Timer timer;
    private final int DELAY = 40;
    private final int RADIUS = 60;
    private final int SHADOWRADIUS = 30;
    private final double GRAVITY = 9.81;
    private final float ALPHA = 0.2f;
    private double speed;
    private double t;
    private double posx = 0;
    private double posy = 620;
    private int angle;
    private int width;
    private int height;
    private double movx;
    private double movy;
    public ArrayList<Ellipse2D> shadow = new ArrayList<Ellipse2D>();

    public Surface() {
        user();
        initTimer();
    }

    private void initTimer() {

        timer = new Timer(DELAY, this);
        timer.start();

    }

    private void user() {

        JOptionPane.showMessageDialog(null, "İlk hız değeri 10 - 20 arası ideal hız değerleridir");
        String hiz = JOptionPane.showInputDialog(null, "İlk Hız değerini giriniz:");
        speed = Integer.valueOf(hiz);
        JOptionPane.showMessageDialog(null, "Açı değeri minimum 0 maksimum 90 olmalıdır");
        String aci = JOptionPane.showInputDialog(null, "Açıyı giriniz:");
        angle = Integer.valueOf(aci);
        if (angle < 0) {
            JOptionPane.showMessageDialog(null, "Açı 0 dan küçük olamaz. Açı değeri 0 yapılıyor");
            angle = 0;
        } else if (angle > 90) {
            JOptionPane.showMessageDialog(null, "Açı 90 dan büyük olamaz. Açı değeri 90 yapılıyor");
            angle = 90;
        }


    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        width = getWidth();
        height = getHeight();

        g2d.setColor(Color.red);
        ellipse = new Ellipse2D.Double(posx, posy, RADIUS, RADIUS);
        g2d.fill(ellipse);

        AlphaComposite alcom = AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, ALPHA);
        g2d.setComposite(alcom);
        for (int i = 0; i < shadow.size(); i++) {
            g2d.fill(shadow.get(i));
        }

        g2d.dispose();

    }

    private void movCircle() {

        movx = speed * Math.cos(Math.toRadians(angle));
        movy = Math.sin(Math.toRadians(angle)) * speed - GRAVITY * t;
        shadow.add(new Ellipse2D.Double(ellipse.getX() + 15, ellipse.getY() + 15, SHADOWRADIUS, SHADOWRADIUS));

        posx += movx;
        posy -= movy;

        if (posy > 620) {
            timer.stop();
        }

        t += 0.02;

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        movCircle();
        repaint();

    }
}
