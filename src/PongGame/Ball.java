package PongGame;

import java.awt.*;

public class Ball {
    private int x, y, pos_x, pos_y, size, speed;
    private Color color;

    public Ball(int x, int y, int pos_x, int pos_y, int size, int speed, Color color) {
        this.x = x;
        this.y = y;
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.size = size;
        this.speed = speed;
        this.color = color;
    }

    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh
                = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);
        g2d.setColor(color);
        g2d.fillOval(x, y, size, size);
    }


    public void moveBall() {
        x += pos_x;
        y += pos_y;
    }

    public void bounceOffEdges(int top, int bottom) {


        if (y > bottom - size)
            reverseY();

        else if (y < top)
            reverseY();


    }

    public void reverseX() {
        pos_x *= -1;
    }

    public void reverseY() {
        pos_y *= -1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }

    public void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
