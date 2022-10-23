package HomeWork.randomRectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.util.Random;


class Surface extends JPanel {

    private void doDrawing (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;


        Random random = new Random();




        for (int x = 0; x < getWidth() - (getWidth() / 10); x += getWidth() / 10) {
            for (int y = 0; y < getHeight() - (getHeight() / 8); y += getHeight() / 8) {

                float red = random.nextFloat();
                float green = random.nextFloat();
                float blue = random.nextFloat();
                g2d.setPaint(Color.black);


                Area area = new Area(new java.awt.Rectangle(x, y, getWidth() / 10, getHeight() / 8));
                if (y < getHeight() && x < getWidth()) {

                    Color color = new Color(red, green, blue);
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

public class Rectangle extends JFrame {

    public Rectangle () {
        initUI();
    }

    private void initUI () {
        add(new Surface());
        Random r = new Random();


        int width = (r.nextInt(2) + 1) * 400;
        int height = (r.nextInt(2) + 1) * 360;



        setTitle("Random Rectangle");
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }




    public static void main(String[] args) {
        Random r = new Random();

        System.out.println((r.nextInt(2) + 1)*400);
        System.out.println((r.nextInt(2) + 1) * 360);


        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Rectangle rectangle = new Rectangle();

                rectangle.setVisible(true);

            }
        });
    }
}
