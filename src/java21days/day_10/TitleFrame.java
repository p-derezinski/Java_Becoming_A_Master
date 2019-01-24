/* Rozwiązanie dla rozdział 10., ćwiczenie 1. */

package java21days.day_10;

import javax.swing.*;

public class TitleFrame extends JFrame {
    public TitleFrame() {
        super("Ramka z tytułem");
        setLookAndFeel();
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        String response = JOptionPane.showInputDialog(null,
            "Wpisz tytuł ramki:");
        setTitle(response);
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
    
    public static void main(String[] arguments) {
        JFrame frame = new TitleFrame();
    }
}
