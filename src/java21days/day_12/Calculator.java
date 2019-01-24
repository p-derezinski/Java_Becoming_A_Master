package java21days.day_12;            // Listing 12.2

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Calculator extends JFrame implements FocusListener {

    JTextField value1, value2, sum;
    JLabel plus, equals;

    public Calculator() {
        super("Dodaj dwie liczby");
        setSize(350, 90);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        FlowLayout flow = new FlowLayout(FlowLayout.CENTER);
        setLayout(flow);

        // utwórz komponenty
        value1 = new JTextField("0", 5);
        plus = new JLabel("+");
        value2 = new JTextField("0", 5);
        equals = new JLabel("=");
        sum = new JTextField("0", 5);

        // dodaj nasłuchiwanie zdarzeń
        value1.addFocusListener(this);
        value2.addFocusListener(this);

        // skonfiguruj pole sumy
        sum.setEditable(false);

        // dodaj komponenty
        add(value1);
        add(plus);
        add(value2);
        add(equals);
        add(sum);

        setVisible(true);
    }

    @Override
    public void focusGained(FocusEvent event) {
        try {
            float total = Float.parseFloat(value1.getText()) + Float.parseFloat(value2.getText());
            sum.setText("" + total);
        } catch (NumberFormatException nfe) {
            value1.setText("0");
            value2.setText("0");
            sum.setText("0");
        }
    }

    @Override
    public void focusLost(FocusEvent event) {
        focusGained(event);
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
        Calculator frame = new Calculator();
    }

}
