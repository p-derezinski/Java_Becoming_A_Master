package java21days.day_12;           // Listing 12.1

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitleBar extends JFrame implements ActionListener {

    JButton b1;
    JButton b2;

    public TitleBar() {
        super("Pasek tytułu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        b1 = new JButton("Rosenkrantz");
        b2 = new JButton("Guildenstern");
        b1.addActionListener(this);
        b2.addActionListener(this);
        FlowLayout flow = new FlowLayout();
        setLayout(flow);
        add(b1);
        add(b2);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();
        if (source == b1) {
            setTitle("Rosenkrantz");
        } else if (source == b2) {
            setTitle("Guildenstern");
        }
        repaint();
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
        TitleBar frame = new TitleBar();
    }

}
