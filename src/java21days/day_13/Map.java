package java21days.day_13;           // Listing 13.2
                                     //    - zmieniłem wartości w setSie() i w rysowaniu fal, żeby lepiej wyglądało
                                     //    - zmieniłem tytuł ramki

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;

public class Map extends JFrame {

    public Map() {
        super("Florida");
        setSize(365, 370);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MapPane map = new MapPane();
        add(map);
        setVisible(true);
    }

    public static void main(String[] args) {
        Map frame = new Map();
    }
}

class MapPane extends JPanel {

    public void paintComponent(Graphics comp) {
        Graphics2D comp2D = (Graphics2D) comp;
        comp2D.setColor(Color.blue);
        comp2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Rectangle2D.Float background = new Rectangle2D.Float(0F, 0F, getSize().width, getSize().height);
        comp2D.fill(background);

        // rysowanie fal
        comp2D.setColor(Color.white);
        BasicStroke pen = new BasicStroke(2F, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND);
        comp2D.setStroke(pen);
        for (int ax = 0; ax < 350; ax += 10) {
            for (int ay = 0; ay < 340; ay += 10) {
                Arc2D.Float wave = new Arc2D.Float(ax, ay, 10, 10, 0, -180, Arc2D.OPEN);
                comp2D.draw(wave);
            }
        }

        // rysowanie Florydy
        GradientPaint gp = new GradientPaint(0F, 0F, Color.green,50F, 50F, Color.orange, true);
        comp2D.setPaint(gp);
        GeneralPath fl = new GeneralPath();
        fl.moveTo(10F, 12F);
        fl.lineTo(234F, 15F);
        fl.lineTo(253F, 25F);
        fl.lineTo(261F, 71F);
        fl.lineTo(344F, 209F);
        fl.lineTo(336F, 278F);
        fl.lineTo(295F, 310F);
        fl.lineTo(259F, 274F);
        fl.lineTo(205F, 188F);
        fl.lineTo(211F, 171F);
        fl.lineTo(195F, 174F);
        fl.lineTo(191F, 118F);
        fl.lineTo(120F, 56F);
        fl.lineTo(94F, 68F);
        fl.lineTo(81F, 49F);
        fl.lineTo(12F, 37F);
        fl.closePath();
        comp2D.fill(fl);

        // rysowanie owalów
        comp2D.setColor(Color.black);
        BasicStroke pen2 = new BasicStroke();
        comp2D.setStroke(pen2);
        Ellipse2D.Float e1 = new Ellipse2D.Float(235, 140, 15, 15);
        Ellipse2D.Float e2 = new Ellipse2D.Float(225, 130, 15, 15);
        Ellipse2D.Float e3 = new Ellipse2D.Float(245, 130, 15, 15);
        comp2D.fill(e1);
        comp2D.fill(e2);
        comp2D.fill(e3);
    }
}
