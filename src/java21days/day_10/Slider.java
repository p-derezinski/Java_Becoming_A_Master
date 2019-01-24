package java21days.day_10;             // Listing 10.2

import javax.swing.*;

public class Slider extends JFrame {

    public Slider() {
        super("Suwak");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        JSlider pick = new JSlider(JSlider.HORIZONTAL, 0, 30, 5);
        pick.setMajorTickSpacing(10);
        pick.setMinorTickSpacing(1);
        pick.setPaintTicks(true);
        pick.setPaintLabels(true);
        add(pick);
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
        Slider frame = new Slider();
    }

}
