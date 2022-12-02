package HomeWork.movingBall;


import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;


public class SpaceBall {

    private Ellipse2D ellipse2D;

    private int inc;
    private int incR;
    private int posx = 360;
    private int posy = 260;
    private int radius = 90;
    private int speed = 3;
    private boolean moveX = true;
    private boolean moveY = true;

    private int width = 884;
    private int height = 661;

    public SpaceBall() {

        loadBall();

    }

    private void loadBall() {

        ellipse2D = new Ellipse2D.Double(posx, posy, radius, radius);

    }

    public void move() {

        radius += incR;
        loadBall();

    }

    public void moveCircle() {

        if (posx > width - radius)
            moveX = false;
        if (posx < 0)
            moveX = true;
        if (posy > height - radius)
            moveY = false;
        if (posy < 0)
            moveY = true;
        if (moveX)
            posx += speed;
        else
            posx -= speed;
        if (moveY)
            posy += speed;
        else
            posy -= speed;

    }

    public Ellipse2D getEllipse2D() {

        return ellipse2D;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            if (inc == 0) {
                inc += 1;
            }
            if (speed > 0)
                speed -= inc;
        }

        if (key == KeyEvent.VK_RIGHT) {
            if (inc == 0) {
                inc += 1;
            }
            if (speed < 50)
                speed += inc;
        }

        if (key == KeyEvent.VK_UP) {
            incR = 1;
            if (radius > 498) {
                incR = 0;
            }
        }

        if (key == KeyEvent.VK_DOWN) {
            incR = -1;
            if (radius < 10) {
                incR = 0;
            }

        }


    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            inc = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            inc = 0;
        }

        if (key == KeyEvent.VK_UP) {
            incR = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            incR = 0;
        }
    }
}