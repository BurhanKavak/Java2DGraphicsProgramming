package PongGame;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddles {
    private int x, y, height, speed;
    private Color color;
    private static final int PADDLE_WIDTH = 15;

    public Paddles(int x, int y, int height, int speed, Color color) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.speed = speed;
        this.color = color;
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(color);
        g2d.fillRect(x, y, PADDLE_WIDTH, height);

    }


    public boolean checkCollision(Ball ball) {

        int rightX = x + PADDLE_WIDTH;
        int bottomY = y + height;

        if (ball.getX() > (x - ball.getSize()) && ball.getX() < rightX) {
            //check if Ball is between the y values
            if (ball.getY() > y && ball.getY() < bottomY) {
                //if we get here, we know the ball and the paddle have collided
                return true;
            }
        }
        return false;
    }


    public void keyPressedToUser1(KeyEvent e) {

        int key = e.getKeyCode();
        int centerY = y + height / 2;


        if (centerY > 35) {
            if (key == KeyEvent.VK_W) {
                y -= speed * 2;
            }
        }

        if (centerY < 420) {
            if (key == KeyEvent.VK_S) {
                y += speed * 2;
            }
        }

    }


    public void keyPressedToUser2(KeyEvent e) {

        int key = e.getKeyCode();
        int centerY = y + height / 2;

        if (centerY > 35) {
            if (key == KeyEvent.VK_UP) {
                y -= speed * 2;
            }
        }

        if (centerY < 420) {
            if (key == KeyEvent.VK_DOWN) {
                y += speed * 2;
            }
        }
    }
}
