package HomeWork.movingBall;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {


    private Timer timer;
    private SpaceBall spaceBall;
    private final int DELAY = 10;


    public int getW(){
        return getWidth();
    }

    public int getH(){
        return getHeight();
    }

    public Board() {

        initBoard();
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);

        spaceBall = new SpaceBall();

        timer = new Timer(DELAY, this);
        timer.start();
    }



    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setPaint(Color.red);
        g2d.fill(spaceBall.getEllipse2D());
    }

    private void step() {

        spaceBall.move();
        spaceBall.moveCircle();


        repaint();
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        step();
    }



    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            spaceBall.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            spaceBall.keyPressed(e);
        }
    }
}
