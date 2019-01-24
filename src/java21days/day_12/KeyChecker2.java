package java21days.day_12;               // Listing 12.6

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyChecker2 extends JFrame {

    JLabel keyLabel = new JLabel("Naciśnij dowolny klawisz");

    public KeyChecker2() {
        super("Naciśnij klawisz");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        KeyAdapter monitor = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                keyLabel.setText("" + e.getKeyChar());
                repaint();
            }
        };
        setFocusable(true);
        addKeyListener(monitor);
        add(keyLabel);
        setVisible(true);
    }

    private static void setLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Nie mogłem użyć systemowego wyglądu: " + e);
        }
    }

    public static void main(String[] args) {
        KeyChecker2.setLookAndFeel();
        new KeyChecker2();
    }

}
