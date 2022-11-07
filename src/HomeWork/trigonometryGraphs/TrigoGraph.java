package HomeWork.trigonometryGraphs;

import javax.swing.*;
import java.awt.*;

class Surface extends JPanel {

    private int boundaryNegative,boundaryPositive,amplituda;
    private Polygon polygonSin,polygonCos,polygonTan,polygonCot;
    public Surface () {
        message();
    }
    private void message() {
        JOptionPane.showMessageDialog(null,"Sinüs ve Kosinüs dalgaları -360 derece den başlayıp en fazla + 360 derece ye kadar çizdirilebilir","Warning",JOptionPane.WARNING_MESSAGE);

        String input = JOptionPane.showInputDialog(null,"-360 ile 0 arasında negatif bir değer giriniz");
        boundaryNegative = Integer.valueOf(input);
        if (boundaryNegative < -360 ) {
            JOptionPane.showMessageDialog(null, "Hatalı giriş yaptınız..! Eksi sınır değeri -360 yapılıyor","ERROR",JOptionPane.ERROR_MESSAGE);
            boundaryNegative = -360;
        } else if (boundaryNegative > 0) {
            JOptionPane.showMessageDialog(null, "Hatalı giriş yaptınız..! Eksi sınır değeri 0 yapılıyor","ERROR",JOptionPane.ERROR_MESSAGE);
            boundaryNegative = 0;
        }
        System.out.println("Eksi sinir deger : " + boundaryNegative);


        String input2 = JOptionPane.showInputDialog(null,"0 ile 360 arasında pozitif bir değer giriniz");
        boundaryPositive = Integer.valueOf(input2);
        if (boundaryPositive > 360) {
            JOptionPane.showMessageDialog(null, "Hatalı giriş yaptınız..! Eksi sınır değeri +360 yapılıyor","ERROR",JOptionPane.ERROR_MESSAGE);
            boundaryPositive = 360;
        } else if (boundaryPositive < 0) {
            JOptionPane.showMessageDialog(null, "Hatalı giriş yaptınız..! Eksi sınır değeri 0 yapılıyor","ERROR",JOptionPane.ERROR_MESSAGE);
            boundaryPositive = 0;
        }

        System.out.println("Arti sinir deger : " + boundaryPositive);



        String input3 = JOptionPane.showInputDialog(null, "Genlik değerini giriniz:");
        amplituda = Integer.valueOf(input3);

        if (amplituda < 10) {
            JOptionPane.showMessageDialog(null, "Genlik değeri minimum 10 olmalıdır. Otomatik olarak genlik 10 yapıldı");
            amplituda = 10; // Minumum 10 şekilde kontrol sağlıyoruz
        }
        System.out.println("Genlik Degeri: " + amplituda);
    }


    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        int w = getWidth();
        int h = getHeight();
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        BasicStroke basicStroke = new BasicStroke(2, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_ROUND, 1.0f);
        g2d.setStroke(basicStroke);


        g2d.setColor(Color.BLACK);
        g2d.drawLine(w / 10, h / 2, (int) (w * 0.9), h / 2);  // X çizgisi

        g2d.drawLine((w / 10) + 20, (h / 2) + 20, w / 10, h / 2);  // -X aşağı yöndeki oku
        g2d.drawLine((w / 10) + 20, (h / 2) - 20, w / 10, h / 2); // -X yukarı yöndeki oku

        g2d.drawLine((int) (w * 0.9), h / 2, (int) (w * 0.9) - 20, (h / 2) + 20);  // +X yukarı yöndeki oku
        g2d.drawLine((int) (w * 0.9), h / 2, (int) (w * 0.9) - 20, (h / 2) - 20);  // +X aşağı yöndeki oku


        g2d.drawLine(w / 2, h / 10, w / 2, (int) (h * 0.9));  // Y çizgisi

        g2d.drawLine(w / 2, h / 10, (w / 2) - 20, (h / 10) + 20); // +Y sol aşağo oku
        g2d.drawLine(w / 2, h / 10, (w / 2) + 20, (h / 10) + 20);// +Y sağ aşağı oku

        g2d.drawLine(w / 2, (int) (h * 0.9), (w / 2) - 20, (int) ((h * 0.9) - 20)); // -Y sol üst oku
        g2d.drawLine(w / 2, (int) (h * 0.9), (w / 2) + 20, (int) ((h * 0.9) - 20)); // -Y sağ üst oku


        g2d.drawString("-2π", (w / 10) + 30, (h / 2) + 20);
        g2d.drawString("2π", (int) ((w * 0.9) - 40), (h / 2) + 20);
        g2d.drawString("0", (w / 2) + 10, (h / 2) + 20);
        g2d.drawString("-π", (3*w / 10) + 10 , (h / 2) + 20);
        g2d.drawString("+π", (int) ((w/2 + w * 0.2)), (h / 2) + 20);
        g2d.drawString("Y",  w/2 + 10, (h / 10) -5);
        g2d.drawString("X", (int) ((w*0.9) + 10), (h / 2) );

        functionGraph(g2d);


    }


    private void functionGraph(Graphics2D g2d) {
        polygonSin = new Polygon();
        polygonCos = new Polygon();
        polygonTan = new Polygon();
        polygonCot = new Polygon();

        for (int x = boundaryNegative; x<=boundaryPositive; x++) {
            g2d.setColor(Color.blue);
            polygonSin.addPoint(x+getWidth()/2, (int) (getHeight()/2-(amplituda*Math.sin(x * Math.PI / 180))));

        }
        g2d.drawPolyline(polygonSin.xpoints,polygonSin.ypoints,polygonSin.npoints);



        for (int x = boundaryNegative; x<=boundaryPositive; x++) {

            g2d.setColor(Color.red);
            polygonCos.addPoint(x+getWidth()/2, (int) (getHeight()/2-(amplituda*Math.cos(x * Math.PI / 180))));

        }
        g2d.drawPolyline(polygonCos.xpoints,polygonCos.ypoints,polygonCos.npoints);


        for (int x = boundaryNegative; x<=boundaryPositive; x++) {

            g2d.setColor(Color.yellow);
            polygonTan.addPoint(x+getWidth()/2, (int) (getHeight()/2-(2*Math.tan(x * Math.PI / 180))));

        }
        g2d.drawPolyline(polygonTan.xpoints,polygonTan.ypoints,polygonTan.npoints);

        for (int x = boundaryNegative; x<=boundaryPositive; x++) {

            g2d.setColor(new Color(95,0,160));
            polygonCot.addPoint(x+getWidth()/2, (int) (getHeight()/2-(2/Math.tan(x * Math.PI / 180))));

        }
        g2d.drawPolyline(polygonCot.xpoints,polygonCot.ypoints,polygonCot.npoints);


    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}

public class TrigoGraph extends JFrame {

    public TrigoGraph() {
        initUI();
    }

    private void initUI() {
        add(new Surface());

        setTitle("Trigonometri Grafiği");
        setSize(1040,720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TrigoGraph trigoDemo = new TrigoGraph();
                trigoDemo.setVisible(true);

            }
        });
    }
}