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
public class DigitalWatch implements Runnable {

    FrameNetwork exam;
    
    public DigitalWatch(FrameNetwork nwf) {
        exam = nwf;
    }

    @Override
    public void run() {
        int a, b, c, x, y, z, aFile = exam.getHourFile(), bFile = exam.getMinFile(), cFile = exam.getSecFile(), maximum;
        
        a = 0;
        b = 0;
        c = 0;


        x = aFile;
        y = bFile;
        z = cFile;


        maximum = aFile * 60 * 60 + bFile * 60 + cFile;
        exam.jProgressBar.setMaximum(maximum);
        int value = 0;
        while (true) {
            if (a <= 23 && a >= 0 && b <= 60 && b >= 0 && c <= 60 && c >= 0) {

                if (exam.changeTime) {
                    if (x < 10) {
                        exam.hour.setText("0" + x);
                    } else {
                        exam.hour.setText("" + x);
                    }

                    if (y < 10) {
                        exam.minute.setText("0" + y);
                    } else {
                        exam.minute.setText("" + y);
                    }

                    if (z < 10) {
                        exam.seconds.setText("0" + z);
                    } else {
                        exam.seconds.setText("" + z);
                    }
                } else {
                    if (a < 10) {
                        exam.hour.setText("0" + a);
                    } else {
                        exam.hour.setText("" + a);
                    }

                    if (b < 10) {
                        exam.minute.setText("0" + b);
                    } else {
                        exam.minute.setText("" + b);
                    }

                    if (c < 10) {
                        exam.seconds.setText("0" + c);
                    } else {
                        exam.seconds.setText("" + c);
                    }
                }



                exam.jProgressBar.setValue(value);
                exam.jProgressBar.setStringPainted(true);

                if (maximum - value <= 300) {
                    if ((maximum - value) % 2 == 0) {
                        exam.seconds.setForeground(Color.red);
                        exam.minute.setForeground(Color.red);
                        exam.hour.setForeground(Color.red);
                        exam.jLabel6.setForeground(Color.red);
                        exam.jLabel4.setForeground(Color.red);
                        exam.jProgressBar.setForeground(Color.red);
                    } else {
                        exam.seconds.setForeground(Color.BLACK);
                        exam.minute.setForeground(Color.BLACK);
                        exam.hour.setForeground(Color.BLACK);
                        exam.jLabel6.setForeground(Color.BLACK);
                        exam.jLabel4.setForeground(Color.BLACK);
                        exam.jProgressBar.setForeground(Color.BLUE);
                    }
                }

                value++;

                if (exam.getButtonTimer()) {
                    exam.setTimer(5);
                    break;
                }

                if (a == exam.getHourFile() && b == exam.getMinFile() && c == exam.getSecFile()) {
                    JOptionPane.showMessageDialog(null, "Time Over.");
                    exam.setTimer(5);
                    break;
                }

            }
            exam.repaint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                JOptionPane.showMessageDialog(null, "Erron in Watch! " + ex);
            }
            c++;
            if (c == 60) {
                b++;
                c = 0;
            }
            if (b == 60) {
                a++;
                b = 0;
            }
            if (a == 23) {
                a = 0;
            }

            z--;
            if (z < 0) {
                z = 59;
                y--;
            }
            if (y < 0) {
                y = 59;
                x--;
            }
            if (x < 0) {
                x = 0;
            }
        }
    }
    
}
