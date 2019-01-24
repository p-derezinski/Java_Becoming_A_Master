package java21days.day_12;            // Listing 12.5

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyChecker extends JFrame {

    JLabel keyLabel = new JLabel("Naciśnij dowolny klawisz");

    public KeyChecker() {
        super("Naciśnij klawisz");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        KeyMonitor monitor = new KeyMonitor(this);
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
        KeyChecker.setLookAndFeel();
        new KeyChecker();
    }
}


class KeyMonitor extends KeyAdapter {

    KeyChecker display;

    KeyMonitor(KeyChecker display) {
        this.display = display;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        display.keyLabel.setText("" + e.getKeyChar());
        display.repaint();
    }
}
