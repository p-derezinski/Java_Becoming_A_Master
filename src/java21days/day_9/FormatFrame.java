package java21days.day_9;             // Listing 9.5
                                      //    setLookAndFeel() skopiowane z Authenticator2
                                      //    dodałem więcej spacji w chooseLabel, żeby ramka wyświetlała się w takim układzie jak w książce

import javax.swing.*;

public class FormatFrame extends JFrame {

    JRadioButton[] teams = new JRadioButton[4];

    public FormatFrame() {
        super("Wybierz format wyjściowy");
        setSize(320, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        teams[0] = new JRadioButton("Atom");
        teams[1] = new JRadioButton("RSS 0.92");
        teams[2] = new JRadioButton("RSS 1.0");
        teams[3] = new JRadioButton("RSS 2.0", true);
        JPanel panel = new JPanel();
        JLabel chooseLabel = new JLabel("     Wybierz format wyjściowy dla wiadomości RSS.     ");
        panel.add(chooseLabel);
        ButtonGroup group = new ButtonGroup();
        for (JRadioButton team : teams) {
            group.add(team);
            panel.add(team);
        }
        add(panel);
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
        FormatFrame.setLookAndFeel();
        FormatFrame ff = new FormatFrame();
    }

}
