/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package networking;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author TOSHIBA
 */
public class HelpDesign implements Runnable {

    public HelpA help;
    public String examName;
    public String examDetails;

    public HelpDesign(HelpA h) {
        help = h;
        examName = "Exam System(Controller)";
        examDetails = "Contact nubnasir@yahoo.com";
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            help.megaTitle.setText(help.megaTitle.getText() + examName.toCharArray()[i]);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(null, "Error to design cradits." + ex);
            }
            i++;
            if (i == examName.length()) {
                break;
            }
        }
        help.JnU.setText("Jagannth University");

        int j = 0, k = 0;
        while (true) {
            if (j % 2 == 0) {
                help.myName.setForeground(Color.red);

            } else if (j % 3 == 0) {
                help.myName.setForeground(Color.BLUE);

            } else {
                help.myName.setForeground(Color.BLACK);

            }
            if (k <= examDetails.length()) {
                help.details.setText(help.details.getText() + examDetails.toCharArray()[k]);
                k++;
            }
            if (k == examDetails.length()) {
                k = 0;
                help.details.setText("");
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(null, "Error to design cradits." + ex);
            }
            j++;
        }
    }
}
