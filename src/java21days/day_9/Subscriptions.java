package java21days.day_9;         // Listing 9.7
                                  //    nie wyświetla się poprawnie (okno jest zbyt szerokie)

import javax.swing.*;

public class Subscriptions extends JFrame {

    String[] subs = { "Burningbird", "Freedom Goodness", "Ideoplex", "Inessential", "Intertwingly",
                        "Now This", "Rasterweb", "RC3", "Whole Lotta Nothing", "Workbench" };
    JList<String> sublist = new JList<>(subs);

    public Subscriptions() {
        super("Subskrypcje");
        setSize(150, 335);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JLabel subLabel = new JLabel("Subskrypcje RSS:");
        panel.add(subLabel);
        sublist.setVisibleRowCount(8);
        JScrollPane scroller = new JScrollPane(sublist);
        panel.add(scroller);
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
        Subscriptions.setLookAndFeel();
        Subscriptions app = new Subscriptions();
    }

}
