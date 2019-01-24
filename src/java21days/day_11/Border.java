package java21days.day_11;        // Listing 11.4

import javax.swing.*;
import java.awt.*;

public class Border extends JFrame {

    public Border() {
        super("Border");
        setSize(240, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        setLayout(new BorderLayout());
        JButton nButton = new JButton("Północ");
        JButton sButton = new JButton("Południe");
        JButton eButton = new JButton("Wschód");
        JButton wButton = new JButton("Zachód");
        JButton cButton = new JButton("Srodek");
        add(nButton, BorderLayout.NORTH);
        add(sButton, BorderLayout.SOUTH);
        add(eButton, BorderLayout.EAST);
        add(wButton, BorderLayout.WEST);
        add(cButton, BorderLayout.CENTER);
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
        Border frame = new Border();
    }

}
