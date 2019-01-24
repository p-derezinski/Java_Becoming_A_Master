package java21days.day_11;              // moje rozwiązanie ćw. 1

import javax.swing.*;
import java.awt.*;

public class Calendar extends JFrame {

    public Calendar() {
        super("Kalendarz");
        setSize(600, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();

        JPanel panel1 = new JPanel();
        GridLayout grid1 = new GridLayout(1, 1, 10, 10);
        panel1.setLayout(grid1);
        //panel1.setSize(600, 20);
        JLabel nameOfMonth = new JLabel("Styczeń");
        panel1.add(nameOfMonth);

        JPanel panel2 = new JPanel();
        GridLayout namesOfDays = new GridLayout(1, 7, 10, 10);
        panel2.setLayout(namesOfDays);
        JLabel pon = new JLabel("poniedziałek");
        JLabel wto = new JLabel("wtorek");
        JLabel sro = new JLabel("środa");
        JLabel czw = new JLabel("czwartek");
        JLabel pt = new JLabel("piątek");
        JLabel sob = new JLabel("sobota");
        JLabel nie = new JLabel("niedziela");
        panel2.add(pon);
        panel2.add(wto);
        panel2.add(sro);
        panel2.add(czw);
        panel2.add(pt);
        panel2.add(sob);
        panel2.add(nie);

        JPanel panel3 = new JPanel();
        GridLayout month = new GridLayout(5, 7, 10, 10);
        panel3.setLayout(month);
        JButton[] days = new JButton[31];
        for (int i = 1; i <= days.length; i++) {
            JButton button = new JButton(Integer.valueOf(i).toString());
            //days[i - 1] = button;
            panel3.add(button);
        }

        //GridLayout cal = new GridLayout(3, 1);
        JPanel mainPanel = new JPanel();
        //Insets whitespace = new Insets(20, 20, 20, 20);
        BoxLayout cal = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
        mainPanel.setLayout(cal);
        mainPanel.add(panel1);
        mainPanel.add(panel2);
        mainPanel.add(panel3);
        //mainPanel.getInsets(whitespace);
        add(mainPanel);

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
        Calendar calendar = new Calendar();
    }

}
