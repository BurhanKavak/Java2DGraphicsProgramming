package BasicDrawing.lines;

import javax.swing.*;
import java.awt.*;

class Surface extends  JPanel {

    private void doDrawing (Graphics g) {
        Color c = new Color(11,22,63);
        //  setBackground(c);
        // setBackground(UIManager.getColor("info"));//window,desktop,info,menu,text,scrollbar...
        Graphics2D g2d = (Graphics2D) g;
//        g2d.setPaint(Color.YELLOW);
//        g2d.drawLine(50,50,100,50);
//        g2d.drawLine(100,50,100,100);
//        g2d.drawLine(100,100,50,100);
//        g2d.drawLine(100,100,100,150);
//        g2d.drawLine(100,150,50,150);
//        g2d.drawLine(150,50,150,150);
//        g2d.drawLine(150,50,125,80);

        // Büyük kare
//        g2d.drawLine(50,50,50,100);
//        g2d.drawLine(50,100,100,100);
//        g2d.drawLine(100,100,100,50);
//        g2d.drawLine(50,50,100,50);

        //üçgen
//        g2d.drawLine(50,50,75,0);
//        g2d.drawLine(75,0,100,50);

        //kapı
//        g2d.drawLine(60,75,85,75);
//        g2d.drawLine(85,75,85,100);
//        g2d.drawLine(85,100,60,100);
//        g2d.drawLine(60,100,60,75);


        //kare(ev)
        g2d.drawLine(70,70,200,70);
        g2d.drawLine(200,70,200,200);
        g2d.drawLine(200,200,70,200);
        g2d.drawLine(70,200,70,70);


        //üçgen(çatı)
        g2d.drawLine(70,70,135,20);
        g2d.drawLine(135,20,200,70);

        //Kapı(dikdörtgen)
        g2d.drawLine(70,200,125,200);
        g2d.drawLine(125,200,125,150);
        g2d.drawLine(125,150,150,150);
        g2d.drawLine(150,150,150,200);








    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}

public class LinesEx extends JFrame {

    public LinesEx (){
        initUI();
    }



    private void initUI () {

        add(new Surface());

        setTitle("Lines");
        setSize(350,450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                LinesEx linesEx = new LinesEx();
                linesEx.setVisible(true);
            }
        });
    }
}
