package java21days.day_11;                 // Listing 11.6

import javax.swing.*;

public class SurveyFrame extends JFrame {

    public SurveyFrame() {
        super("Ankieta");
        setSize(290, 170);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        SurveyWizard wiz = new SurveyWizard();
        add(wiz);
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
        SurveyFrame surv = new SurveyFrame();
    }

}
