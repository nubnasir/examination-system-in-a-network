/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package networking;

import java.io.ObjectInputStream;
import java.util.Date;
import javax.swing.text.html.HTMLDocument;

/**
 *
 * @author TOSHIBA
 */
public class ChatRunner implements Runnable {

    ObjectInputStream is;
    public FrameNetwork frS;
    public int i = 0;
    public int addr;

    public ChatRunner(ObjectInputStream ist, FrameNetwork frSt, int num) {
        is = ist;
        frS = frSt;
        addr = num;
    }

    @Override
    public void run() {
        while (true) {
            try {
                try {
                    String m = null;

                    m = "" + is.readObject();

                    if (m.startsWith("Marks")) {
                        m = "" + is.readObject();
                        frS.ts.Result.format("%s\n", m);
                        designer(m + " " + new Date(), "green");
                        i++;
                    } else if ("TakeInfo".equals(m)) {
                        frS.ts.stu[frS.ts.stuCounter] = "" + is.readObject();
                        frS.ts.stuCounter++;
                        frS.ts.ListManeger();
                    } else if (m.startsWith("Closed")) {
                        frS.designer(m.substring(6), "Lime");
                        is.close();
                        frS.ts.thread[addr].stop();
                    } else if ("Expeled".equals(m)) {
                        frS.increaseExpel();
                    } else if ("Rcv".equals(m)) {
                        String name = "" + is.readObject();
                        int size = Integer.parseInt("" + is.readObject());
                        frS.ts.sockf[addr].receiveFile(size, name);
                        frS.ts.setJrecCount(frS.ts.getJrecCount() + 1);
                        frS.jrec.setValue(frS.ts.getJrecCount());
                    } else if (m.startsWith("EEE")) {
                        if (m.endsWith("Expeled")) {
                            frS.designer(m.substring(3), "RED");
                        } else {
                            frS.designer(m.substring(3), "Purple");
                        }
                    }

                } catch (Exception ex) {
                    frS.setDis(0);
                    frS.designer("Problem!!!! to receive message from student. " + ex, "red");
                    //frS.t2.stop();
                    return;
                }
                frS.repaint();

            } catch (Exception ex) {
                frS.setDis(0);
                frS.designer("Problem!!!! to receive message from student. " + ex, "red");
                //frS.t1.stop();
                return;
            }
        }
    }

    public void designer(String line, String col) {
        try {
            frS.text_panel_html_kit.insertHTML((HTMLDocument) frS.output.getDocument(), frS.output.getDocument().getLength(), "<font size=8 color=" + col + "><u><B>" + line + "</B></u></font><font size=8 color=" + col + ">" + "</font>", 0, 0, null);
            frS.sR.recode.setText(frS.sR.recode.getText() + line + "\n");
        } catch (Exception ex) {
        }
    }
}
