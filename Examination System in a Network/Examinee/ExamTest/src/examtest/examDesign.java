/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package examtest;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author TOSHIBA
 */
public class examDesign implements Runnable {

    public Exam exam;
    public String msg;
    public int serverMsg = 0;

    public int getServerMsg() {
        return serverMsg;
    }

    public void setServerMsg(int serverMsg) {
        this.serverMsg = serverMsg;
    }

    public void setTitle(String t) {
        msg = t;
    }

    public examDesign(Exam e) {
        exam = e;
        msg = "Exam System";
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            if (serverMsg == 3) {
                exam.ms.setBackground(Color.blue);
                setServerMsg(0);
            } else if (serverMsg == 2) {
                exam.ms.setBackground(Color.GREEN);
                serverMsg++;
            } else if (serverMsg == 1) {
                exam.ms.setBackground(Color.red);
                serverMsg++;
            }

            if (i >= msg.length()) {
                try {
                    exam.massege.setForeground(Color.RED);
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    JOptionPane.showMessageDialog(null, "Error in exam design. " + ex);
                }
                try {
                    exam.massege.setForeground(Color.blue);
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    JOptionPane.showMessageDialog(null, "Error in exam design. " + ex);
                }
                try {
                    exam.massege.setForeground(Color.GREEN);
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    JOptionPane.showMessageDialog(null, "Error in exam design. " + ex);
                }
                try {
                    exam.massege.setForeground(Color.BLACK);
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    JOptionPane.showMessageDialog(null, "Error in exam design. " + ex);
                }
                exam.massege.setText("");
                i = 0;
            }
            if (i < msg.length()) {
                exam.massege.setText(exam.massege.getText() + msg.toCharArray()[i]);
                i++;
            }

            exam.repaint();
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(null, "Error in exam design. " + ex);
            }
        }
    }
}
