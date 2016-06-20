/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package examtest;

import java.awt.Color;
import java.io.IOException;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author TOSHIBA
 */
public class DigitalWatch implements Runnable {

    Exam exam;
    int a;
    int b;
    int c;
    int x;
    int y;
    int z;
    int value = 0;

    public DigitalWatch(Exam nwf) {
        exam = nwf;
    }

    @Override
    public void run() {
        int aFile = exam.getHourFile(), bFile = exam.getMinFile(), cFile = exam.getSecFile(), maximum;

        a = 0;
        b = 0;
        c = 0;


        x = aFile;
        y = bFile;
        z = cFile;


        maximum = aFile * 60 * 60 + bFile * 60 + cFile;
        exam.jProgressBar.setMaximum(maximum);
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

                if (a >= exam.getHourFile() && b >= exam.getMinFile() && c >= exam.getSecFile()) {
                    try {
                        exam.ts.os.writeObject("Marks" + " " + new Date() + "\n");
                        exam.ts.os.writeObject("Name: " + exam.getExameenName() + "  Roll no: " + exam.getExameenRoll() + "  Marks: " + exam.getCount());

                        exam.output.setText(exam.output.getText() + "Time Over!\nName: " + exam.getExameenName() + "  Roll no: " + exam.getExameenRoll() + "  Marks: " + exam.getCount() + "\n");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Problem to send your result to the controller\nInform him directly.\nThank you");
                    }
                    exam.ts.setComplete(1);
                    MsgViewer mv = new MsgViewer();
                    mv.picLebel.setIcon(new ImageIcon(getClass().getResource("3DCOIN.GIF")));
                    mv.msgLebel.setText("Time over. Your Result: " + exam.getCount());
                    mv.setTitle("Time Over");
                    mv.col.setBackground(Color.blue);
                    mv.setVisible(true);
                    exam.setTimer(5);
                    exam.closeMyAnswer();
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
