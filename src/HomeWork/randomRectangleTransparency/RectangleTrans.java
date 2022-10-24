package HomeWork.randomRectangleTransparency;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.util.Random;


class Surface extends JPanel{

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Random random = new Random();

        float[] dash2 = {8f, 8f, 4f};
        BasicStroke basicStroke = new BasicStroke(2, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 1.0f, dash2, 2f);


        for (int x = 0; x < 10; x++) {

            float alpha = (x+1) * 0.1f;
            AlphaComposite alcom = AlphaComposite.getInstance(
                    AlphaComposite.SRC_OVER, alpha);
            g2d.setComposite(alcom);

            for (int y= 0; y< 8; y++) {
                float red = random.nextFloat();
                float green = random.nextFloat();
                float blue = random.nextFloat();
                g2d.setPaint(Color.black);
                g2d.setStroke(basicStroke);


                Area area = new Area(new Rectangle(x * (getWidth() / 10), y * (getHeight() / 8), getWidth() / 10, getHeight() / 8));
                if (y <= getHeight() && x <= getWidth()) {
                    g2d.draw(area);
                    Color color = new Color(red,green,blue);
                    g2d.setPaint(color);
                    g2d.fill(area);

                }


            }

        }

        g2d.dispose();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

}

public class RectangleTrans extends JFrame {
    public RectangleTrans() {
        initUI();
    }

    private void initUI() {
        add(new Surface());
        Random r = new Random();


        int width = r.nextInt(401) + 400;
        int height = r.nextInt(521)  + 200;

        setTitle("Random Rectangle");
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public static void main(String[] args) {
        Random r = new Random();

        System.out.println(r.nextInt(401) + 400);
        System.out.println(r.nextInt(521) + 200);

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                RectangleTrans rectangleTrans = new RectangleTrans();
                rectangleTrans.setVisible(true);
            }
        });
    }
}
