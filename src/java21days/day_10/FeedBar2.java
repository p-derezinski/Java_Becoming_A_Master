package java21days.day_10;          // Listing 10.5

import javax.swing.*;
import java.awt.*;

public class FeedBar2 extends JFrame {

    public FeedBar2() {
        super("Pasek narzędziowy 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();

        // utworzenie ikon
        ImageIcon loadIcon = new ImageIcon("load.gif");
        ImageIcon saveIcon = new ImageIcon("save.gif");
        ImageIcon subIcon = new ImageIcon("subscribe.gif");
        ImageIcon unsubIcon = new ImageIcon("unsubscribe.gif");

        // utworzenie przycisków
        JButton load = new JButton("Wczytaj", loadIcon);
        JButton save = new JButton("Zapisz", saveIcon);
        JButton sub = new JButton("Zarejestruj", subIcon);
        JButton unsub = new JButton("Wyrejestruj", unsubIcon);

        // dodanie przycisków do paska narzędziowego
        JToolBar bar = new JToolBar();
        bar.add(load);
        bar.add(save);
        bar.add(sub);
        bar.add(unsub);

        // utwórz menu
        JMenuItem j1 = new JMenuItem("Wczytaj");
        JMenuItem j2 = new JMenuItem("Zapisz");
        JMenuItem j3 = new JMenuItem("Zarejestruj");
        JMenuItem j4 = new JMenuItem("Wyrejestruj");
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Źródla danych");
        menu.add(j1);
        menu.add(j2);
        menu.addSeparator();
        menu.add(j3);
        menu.add(j4);
        menuBar.add(menu);

        // przygotuj interfejs użytkownika
        JTextArea edit = new JTextArea(8, 40);
        JScrollPane scroll = new JScrollPane(edit);
        BorderLayout bord = new BorderLayout();
        setLayout(bord);
        add("North", bar);
        add("Center", scroll);
        setJMenuBar(menuBar);
        pack();
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
        FeedBar2 frame = new FeedBar2();
    }

}
