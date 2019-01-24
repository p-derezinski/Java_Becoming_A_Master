package java21days.day_9;     // Listing 9.1

import javax.swing.*;

public class SimpleFrame extends JFrame {

    public SimpleFrame() {
        super("Tytuł ramki");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();  // nie wiem, dlaczego to jest potrzebne w konstruktorze; bez tego chyba też działa...
        setVisible(true);
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception exc) {
            // zignoruj błąd
        }
    }

    public static void main(String[] args) {
        setLookAndFeel();
        SimpleFrame sf = new SimpleFrame();
    }

}
