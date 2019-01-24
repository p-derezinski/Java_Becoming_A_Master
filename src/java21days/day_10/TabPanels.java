package java21days.day_10;      // Listing 10.6

import javax.swing.*;

public class TabPanels extends JFrame {

    public TabPanels() {
        super("Zakładki");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        setSize(480, 218);
        JPanel mainSettings = new JPanel();
        JPanel advancedSettings = new JPanel();
        JPanel privacySettings = new JPanel();
        JPanel emailSettings = new JPanel();
        JPanel securitySettings = new JPanel();
        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Główna", mainSettings);
        tabs.addTab("Zaawansowana", advancedSettings);
        tabs.addTab("Prywatna", privacySettings);
        tabs.addTab("E-mail", emailSettings);
        tabs.addTab("Bezpieczeństwo", securitySettings);
        add(tabs);
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
        TabPanels frame = new TabPanels();
    }

}
