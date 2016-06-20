/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package officecomunicator;

import java.awt.Color;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.util.Date;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.text.html.HTMLDocument;

/**
 *
 * @author TOSHIBA
 */
public class ChatRunner implements Runnable {

    ObjectInputStream is;
    public OfficeFrame frS;
    public int i = 0;
    public int addr;
    public ObjectOutputStream os;
    SocketFile sockf;
    public mgs mg;

    public ChatRunner(ObjectOutputStream ost, ObjectInputStream ist, OfficeFrame frSt, int num) {
        os = ost;
        is = ist;
        frS = frSt;
        addr = num;
    }

    @Override
    public void run() {
        while (true) {
            //try {
            try {
                String m = null;

                m = "" + is.readObject();
                if ("ID".equals(m)) {
                     m = "" + is.readObject();
                    if (JOptionPane.showConfirmDialog(null, m + " Wants to connect with you\n Accept?") < 1) {
                        frS.ts.friendName[frS.ts.getCancle()] = m;
                        //frS.ListManeger();
                        os.writeObject("YES");

                        frS.ts.os[frS.ts.getCancle()] = os;
                        frS.ts.is[frS.ts.getCancle()] = is;
                        //frS.ts.addAfterRequest();
                        frS.ts.cancle++;
                        designer("You are now connected with " + m, "Green");
                        frS.ListManeger();
                        //frS.ts.cancle++;
                    } else {
                        frS.ts.friendName[frS.ts.getCancle()] = m;
                        os.writeObject("NO");
                        frS.setDeleteFriend(m);
                        frS.ts.os[frS.ts.getCancle()] = os;
                        frS.ts.is[frS.ts.getCancle()] = is;
                        frS.ts.cancle++;

                        frS.ListManeger();
                        /*frS.ts.setMsg(frS.getDeleteFriend());
                        frS.ts.writer();*/
                    }
                } else if ("Send".equals(m)) {
                    try {
                        File f = new File(frS.getFilePath());
                        frS.ts.os[addr].writeObject("" + frS.getFileName());
                        frS.ts.os[addr].writeObject("" + f.length());
                        //sf = new ServerFile(frS.getFilePath(), frS.ts.server, frS.ts.socket);
                        frS.ts.busy[addr] = 3;
                        frS.ts.sf[addr].sendFile(frS.getFilePath(), frS.fsf);
                        //new Thread(frS.ts.sf[addr]).start();
                        frS.ts.sf[addr].run();
                        frS.ts.busy[addr] = 4;
                    } catch (Exception ex) {
                    }
                } else if ("Rcv".equals(m)) {
                    os.writeObject("Send");
                    String name = "" + is.readObject();
                    int size = Integer.parseInt("" + is.readObject());
                    frS.ts.busy[addr] = 2;
                    frS.ts.sockf[addr].receiveFile(size, name);
                    //new Thread(frS.ts.sockf[addr]).start();
                    frS.ts.sockf[addr].run();
                    frS.ts.busy[addr] = 4;
                    frS.designer("You have just received a file from " + frS.ts.friendName[addr], "Green");
                } else if ("Remove".equals(m)) {
                    frS.setDeleteFriend(frS.ts.friendName[addr]);
                    frS.ts.deleteMe();
                
                } else if ("Req".equals(m)) {
                    m = "" + is.readObject();
                    if (JOptionPane.showConfirmDialog(null, m + "\nWants to connect you\n Accept?") < 1) {
                        frS.ts.friendName[frS.ts.getCancle()] = m;
                        //frS.ListManeger();
                        os.writeObject("YES");

                        //os.writeObject(frS.name + " Is accepted your request.");
                        frS.ts.os[frS.ts.getCancle()] = os;
                        frS.ts.is[frS.ts.getCancle()] = is;
                        //frS.ts.addAfterRequest();
                        frS.ts.cancle++;
                        designer("You are now connected with " + m, "Green");
                        frS.ListManeger();
                        //frS.ts.cancle++;
                    } else {
                        frS.ts.friendName[frS.ts.getCancle()] = m;
                        os.writeObject("NO");
                        frS.setDeleteFriend(m);
                        frS.ts.os[frS.ts.getCancle()] = os;
                        frS.ts.is[frS.ts.getCancle()] = is;
                        frS.ts.cancle++;

                        frS.ListManeger();
                        frS.ts.setMsg(frS.getDeleteFriend());
                        frS.ts.writer();
                    }
                } else if (m.startsWith("SSS")) {
                    if (frS.jCheckBox1.isSelected()) {
                        try {
                            mg.setVisible(false);
                        } catch (Exception ex) {
                        }
                        mg = new mgs();
                        mg.setVisible(true);
                        designer(m.substring(3), "Black");
                    } else {
                        designer(m.substring(3), "Black");
                    }
                }

                /*} catch (Exception ex) {
                //frS.setDis(0);
                frS.designer("Problem!!!! to receive message from student. " + ex, "red");
                //frS.t2.stop();
                return;
                }*/
                frS.repaint();

            } catch (Exception ex) {
                //frS.setDis(0);
                //frS.designer("Problem!!!! to receive message from student. 1" + ex, "red");
                frS.setDeleteFriend(frS.ts.friendName[addr]);
                frS.setRemoveFriendGroup(frS.getDeleteFriend());
                frS.ts.removeFriendFromGroup();
                frS.ts.deleteMe();
                //frS.t1.stop();
                return;
            }
        }
    }

    public void designer(String line, String col) {
        try {
            frS.text_panel_html_kit.insertHTML((HTMLDocument) frS.output.getDocument(), frS.output.getDocument().getLength(), "<font size=8 color=" + col + ">" + line + "</font><font size=8 color=" + col + ">" + "</font>", 0, 0, null);
            //frS.sR.recode.setText(frS.sR.recode.getText() + line + "\n");
        } catch (Exception ex) {
        }
    }
}
