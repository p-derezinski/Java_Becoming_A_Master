package java21days.day_9;                   // Listing 9.6

import javax.swing.*;

public class FormatFrame2 extends JFrame {

    String[] formats = { "Atom", "RSS 0.92", "RSS 1.0", "RSS 2.0" };
    JComboBox formatBox = new JComboBox(formats);

    public FormatFrame2() {
        super("Wybierz format");
        setSize(220, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane = new JPanel();
        JLabel formatLabel = new JLabel("Formaty wyjściowe");
        pane.add(formatLabel);
        pane.add(formatBox);
        add(pane);
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
        FormatFrame2.setLookAndFeel();
        FormatFrame2 ff = new FormatFrame2();
    }

}
