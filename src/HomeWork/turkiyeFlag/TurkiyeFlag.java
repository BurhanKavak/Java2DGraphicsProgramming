package HomeWork.turkiyeFlag;

import javax.swing.*;
import java.awt.*;

class Surface extends JPanel {
    private int G = getHeight(); // 600
    private double L = getWidth(); // 900
    private int M; //Uçkurluk genişliği
    private int A; // Normalde G / 2 almamız gerekiyor ama yarı çapın 2 katını hesaba katıyoruz
    private int B;
    private int C;
    private double D;
    Color colorRed = new Color(227,10,23); // Renk belirliyoruz (Kırmızı)
    Color colorWhite = new Color(255,255,255); // Renk belirliyoruz (Beyaz)

    private void doDrawing (Graphics g) {
        G = getHeight(); // Yükseklik
        L = getWidth(); // Genişlik
        M = G / 30; // Uçkurluk genişliği 20
        A = G /2; // Dış ay merkezinin uçkurluktan mesafesi 300
        B = G /2; // Dış ayın çapı 300
        C = G /16; // Ayın iç ve dış merkezleri arası 37.5
        D = G * 0.4; // İç ay çapı 240

        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);

        g2d.setColor(colorRed); // Bayrağın rengini veriyoruz
        g2d.fillRect(M,0, (int) (L),G); // uçkurluk çiziyoruz

        moon(g2d); // Hilali çağırıyoruz
        star(g);   // Yıldızı çağırıyoruz
    }

    private void moon (Graphics2D g2d) {
        g2d.setColor(colorWhite);
        g2d.fillOval(((A) / 2),(G/4) ,B,B);

        g2d.setColor(colorRed);
        g2d.fillOval((int) ((B) + C - (G * 0.2)), (int) (G*0.30), (int) D, (int) D);


    }

    private void star (Graphics g) {
        g.setColor(colorWhite);

        int i,faz,aci,icfaz,xm,ym,dr,ir;

        int koordx[] = new int[10];
        int koordy[] = new int[10];
        faz = 36;
        aci = 360 / 5;
        icfaz = aci / 2;
        xm = (int) (G * 0.87);
        ym = (int) (G * 0.5);
        dr =  (G * 1/8);
        ir =  (G * 1/20);

        for (i = 0; i < koordx.length; i += 2) {
            koordx[i] = xm + (int)  (dr * Math.cos(Math.PI *  faz / 180));
            koordx[i + 1] = xm + (int)  (ir * Math.cos(Math.PI * (icfaz+ faz) / 180));
            koordy[i] = (int) (ym + (dr * Math.sin(Math.PI *  faz / 180)));
            koordy[i + 1] = (int) (ym + (ir * Math.sin(Math.PI *  (icfaz+faz) / 180)));
            faz +=aci;

        }
        g.fillPolygon(koordx,koordy,koordx.length);

    }




    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}
public class TurkiyeFlag extends JFrame {

    public TurkiyeFlag() {
        initUI();
    }

    private void initUI () {
        add(new Surface());

        int G = 600; // Bayrak uzunluğu
        double L = G * 1.5; // Bayrak genişliği

        setTitle("Türkiye Bayrağı");
        setSize((int) L   ,G);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TurkiyeFlag flag = new TurkiyeFlag();
                flag.setVisible(true);
            }
        });
    }
}
