package java21days.day_12;              // Listing 12.3

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class FormatChooser extends JFrame implements ItemListener {

    String[] formats = { "(wybierz format)", "Atom", "RSS 0.92", "RSS 1.0", "RSS 2.0" };
    String[] descriptions = {
            "Format Atom dla blogów",
            "Format RSS 0.92 (Netscape)",
            "Format RSS/RDF 1.0 (RSS/RDF)",
            "Format RSS 2.0 (UserLand)"
    };
    JComboBox formatBox = new JComboBox();
    JLabel descriptionLabel = new JLabel("");

    public FormatChooser() {
        super("Format kanału informacyjnego");
        setSize(420, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        for (int i = 0; i < formats.length; i++) {
            formatBox.addItem(formats[i]);
        }
        formatBox.addItemListener(this);
        add(BorderLayout.NORTH, formatBox);
        add(BorderLayout.CENTER, descriptionLabel);
        setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent event) {
        int choice = formatBox.getSelectedIndex();
        if (choice > 0) {
            descriptionLabel.setText(descriptions[choice - 1]);
        }
    }

    public Insets getInsets() {
        return new Insets(50, 10, 10, 10);
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
        FormatChooser.setLookAndFeel();
        FormatChooser fc = new FormatChooser();
    }
}
