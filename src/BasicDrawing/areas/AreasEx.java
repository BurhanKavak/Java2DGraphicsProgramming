package BasicDrawing.areas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
class Surface extends JPanel {

    private final double points[][] = {
            { 20, 20 }, { 70, 0 }, { 120, 20 }

    };

    public void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);

        g2d.setPaint(Color.black);



//
//        Area a1 = new Area(new Rectangle2D.Double(20, 20, 100, 100));
//        Area a2 = new Area(new Rectangle2D.Double(35, 35, 25, 25));
//        Area a3 = new Area(new Rectangle2D.Double(85, 40, 25, 25));
//        Area a4 = new Area(new Rectangle2D.Double(100, 5, 15, 15));
//
//        GeneralPath star = new GeneralPath();
//        star.moveTo(points[0][0], points[0][1]);
//
//        for (int k = 1; k < points.length; k++)
//            star.lineTo(points[k][0], points[k][1]);
//
//        star.closePath();
//
//a1.subtract(a2);
//a1.subtract(a3);
//
//g2d.fill(a4);
//
//g2d.fill(a1);
//g2d.setPaint(Color.BLUE);
//g2d.fill(star);




        Area a1 = new Area(new Rectangle2D.Double(20, 20, 100, 100));
        Area a2 = new Area(new Ellipse2D.Double(0, 75, 50, 50));

        Area a3 = new Area(new Ellipse2D.Double(0, 0, 50, 50));
        Area a4 = new Area(new Ellipse2D.Double(70, 70, 75, 75));

        a1.add(a3);
        a1.add(a4);
        a1.subtract(a2);
        g2d.fill(a1);


        g2d.setPaint(Color.RED);
        g2d.fill(a3);
        g2d.fill(a4);



//      Area a3 = new Area(new Rectangle2D.Double(150, 20, 100, 100));
//        Area a4 = new Area(new Ellipse2D.Double(150, 20, 100, 100));
//
//        a3.subtract(a4);
//        g2d.fill(a3);
//
//       Area a5 = new Area(new Rectangle2D.Double(280, 20, 100, 100));
//       Area a6 = new Area(new Ellipse2D.Double(320, 40, 100, 100));
//
//        a5.add(a6);
//        g2d.fill(a5);
//        g2d.fill(a1);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

public class AreasEx extends JFrame {

    public AreasEx() {

        initUI();
    }

    private void initUI() {

        add(new Surface());

        setTitle("Areas");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                AreasEx ex = new AreasEx();
                ex.setVisible(true);
            }
        });
    }
}
