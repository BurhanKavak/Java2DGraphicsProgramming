package HomeWork.donuts.donut1;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;


public class Board extends JPanel {


    private void drawDonut(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh
                = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        Dimension size = getSize();
        double w = size.getWidth();
        double h = size.getHeight();


        Ellipse2D e = new Ellipse2D.Double(0, 0, 80, 130);
        g2d.setStroke(new BasicStroke(2));


        for (double deg = 0; deg < 360; deg += 5) {
            AffineTransform at
                    = AffineTransform.getTranslateInstance(w/2, h/2);
            at.rotate(Math.toRadians(deg));
            g2d.draw(at.createTransformedShape(e));
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawDonut(g);
    }


}
