package java21days.day_11;          // Listing 11.2
                                    //    Moje zmiany do listingu (bo działał źle):
                                    //    - dodałem linię "textPane.add(scrollPane);"
                                    //    - zmieniłem linię "add(scrollPane);" na "add(textPane);"
                                    //    - zmieniłem rozmiary ramki i JTextArea
                                    //    - i oczywiście zmieniłem funkcję setLookAndFeel()

import javax.swing.*;
import java.awt.*;

public class Stacker extends JFrame {

    public Stacker() {
        super("Stacker");
        setSize(430, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();

        // utwórz górny panel
        JPanel commandPane = new JPanel();
        BoxLayout horizontal = new BoxLayout(commandPane, BoxLayout.X_AXIS);
        commandPane.setLayout(horizontal);
        JButton subscribe = new JButton("Subskrybuj");
        JButton unsubscribe = new JButton("Anuluj subskrypcje");
        JButton refresh = new JButton("Odśwież");
        JButton save = new JButton("Zapisz");
        commandPane.add(subscribe);
        commandPane.add(unsubscribe);
        commandPane.add(refresh);
        commandPane.add(save);

        // utwórz dolny panel
        JPanel textPane = new JPanel();
        JTextArea text = new JTextArea(4, 35);
        JScrollPane scrollPane = new JScrollPane(text);
        textPane.add(scrollPane);

        // połącz je razem
        FlowLayout flow = new FlowLayout();
        setLayout(flow);
        add(commandPane);
        add(textPane);
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
        Stacker st = new Stacker();
    }

}
