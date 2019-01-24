package java21days.day_10;            // Listing 10.4 - rozszerzony o moje rozwiązanie ćw. 2

import javax.swing.*;
import java.awt.*;

public class ProgressMonitor extends JFrame {

    JProgressBar current;
    JTextArea out;
    JButton find;
    int num = 0;

    public ProgressMonitor() {
        super("Monitorowanie postępu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        setSize(150, 150);
        setLayout(new FlowLayout());
        current = new JProgressBar(0, 2000);
        current.setValue(0);
        current.setStringPainted(true);
        add(current);
        out = new JTextArea(Integer.valueOf(num).toString(), 1, 20);
        add(out);
    }

    public void iterate() {
        while (num < 2000) {
            current.setValue(num);
            out.setText(Integer.valueOf(num).toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            num += 95;
        }
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
        ProgressMonitor frame = new ProgressMonitor();
        frame.setVisible(true);
        frame.iterate();
    }

}
