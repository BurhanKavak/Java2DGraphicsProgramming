package PongGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Board extends JPanel implements ActionListener {

    static final int WINDOW_WIDTH = 640;
    static final int WINDOW_HEIGHT = 480;
    static final int DELAY = 33;

    private int userScoreOne, userScoreTwo;
    private Timer timer;

    private Ball gameBall;


    private Paddles userPaddleOne, userPaddleTwo;


    public Board() {
        initTimer();
        initBoard();
    }

    public void initTimer() {
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void initBoard() {
        addKeyListener(new TAdapter());
        setFocusable(true);

        gameBall = new Ball(300, 200, 3, 3, 10, 3, Color.YELLOW);
        userPaddleOne = new Paddles(10, 200, 75, 3, Color.BLUE);
        userPaddleTwo = new Paddles(610, 200, 75, 3, Color.RED);

        userScoreOne = 0;
        userScoreTwo = 0;


    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        g2d.setColor(Color.white);
        g2d.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
        gameBall.paint(g);
        userPaddleOne.paint(g);
        userPaddleTwo.paint(g);
        g2d.setColor(Color.GREEN);
        g2d.drawString("Skor -> USER_X [ " + userScoreOne + "]        USER_Y [ " + userScoreTwo + " ]"
                , 200, 20);

        if (userScoreOne == 3) {
            winToUser1(g);
            timer.stop();
        } else if (userScoreTwo == 3) {
            winToUser2(g);
            timer.stop();
        }

    }

    public void scoreCheck() {

        if (gameBall.getX() < 0) {
            userScoreTwo++;
            reset();
        } else if (gameBall.getX() > WINDOW_WIDTH) {
            userScoreOne++;
            reset();
        }
    }

    public void reset() {

        gameBall.setX(300);
        gameBall.setY(200);
        gameBall.setPos_x(3);
        gameBall.setPos_y(3);
        gameBall.setSpeed(3);

    }

    private void messageFont(String msg, Graphics g) {
        Font small = new Font("Helvetica", Font.BOLD, 18);
        FontMetrics metr = getFontMetrics(small);
        g.setFont(small);
        g.drawString(msg, (WINDOW_WIDTH - metr.stringWidth(msg)) / 2, WINDOW_HEIGHT / 2);
    }

    private void winToUser1(Graphics g) {
        messageFont("USER_X  KAZANDI", g);
    }

    private void winToUser2(Graphics g) {
        messageFont("USER_Y  KAZANDI", g);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
        Toolkit.getDefaultToolkit().sync();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gameBall.moveBall();
        gameBall.bounceOffEdges(0, WINDOW_HEIGHT - 25);

        if (userPaddleOne.checkCollision(gameBall) || userPaddleTwo.checkCollision(gameBall)) {
            gameBall.reverseX();

        }

        scoreCheck();
        repaint();
    }


    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            userPaddleOne.keyPressedToUser1(e);
            userPaddleTwo.keyPressedToUser2(e);
        }

    }
}
