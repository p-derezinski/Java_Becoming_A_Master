package java21days.day_11;           // Listing 11.1

import javax.swing.*;
import java.awt.*;

public class Alphabet extends JFrame {

    public Alphabet() {
        super("Alphabet");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        setSize(360, 120);
        FlowLayout lm = new FlowLayout(FlowLayout.LEFT);
        setLayout(lm);
        JButton a = new JButton("Alibi");
        JButton b = new JButton("Biurko");
        JButton c = new JButton("Ciało");
        JButton d = new JButton("Dowód");
        JButton e = new JButton("Ekran");
        JButton f = new JButton("Fasada");
        add(a);
        add(b);
        add(c);
        add(d);
        add(e);
        add(f);
        setVisible(true);
    }

    private void setLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    SwingUtilities.updateComponentTreeUI(this);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Nie mogłem użyć systemowego wyglądu: " + e);
        }
    }

    public static void main(String[] args) {
        Alphabet frame = new Alphabet();
    }

}
