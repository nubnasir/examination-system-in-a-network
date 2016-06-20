/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package examtest;

import java.awt.Color;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Formatter;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author TOSHIBA
 */
public class ThreadSocket implements Runnable {

    public Exam frS;
    ServerSocket server;
    Socket socket;
    ObjectOutputStream os;
    ObjectInputStream is;
    InputStream isf;
    FileOutputStream fos;
    BufferedOutputStream bos;

    public int getNumFile() {
        return numFile;
    }

    public void setNumFile(int numFile) {
        this.numFile = numFile;
    }
    public int numFile = 0;
    public String file[] = new String[5];

    public int getComplete() {
        return Complete;
    }

    public void setComplete(int Complete) {
        this.Complete = Complete;
    }
    public int Complete = 0;

    public ThreadSocket(Exam fn) {
        frS = fn;
    }

    @Override
    public void run() {
        chatting();
    }

    public void searchConnection() {
        while (true) {
            String Ipaddress = JOptionPane.showInputDialog(null, "Insert The IP Address");
            if ("jnucse02-exit".equals(Ipaddress)) {
                System.exit(0);
            }
            frS.output.setText(frS.output.getText() + "Connecting.....\n");
            try {

                socket = new Socket(Ipaddress, 12345);

                frS.output.setText(frS.output.getText() + "Connected to : " + socket.getInetAddress().getHostName() + "\n");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Incorrect IP Address.");
                //frS.output.setText(frS.output.getText() + "Problem!!!! Searching faild..... " + ex + "\n");
                //terminateConnection();
                frS.setConnectAgain(1);
                //frS.th.stop();
                continue;
            }

            try {
                os = new ObjectOutputStream(socket.getOutputStream());
                is = new ObjectInputStream(socket.getInputStream());
                os.writeObject("hello welcome to the server\n");
                os.writeObject("A");
                frS.setCheckC(0);
            } catch (Exception ex) {
                //frS.output.setText(frS.output.getText() + "Problem!!!! in build stream. unable to connect with the server" + ex + "\n");
                continue;
            }
            break;
        }
    }

    public void chatting() {
        try {
            searchConnection();
        } catch (Exception ex) {
            //frS.output.setText(frS.output.getText() + "Problem!!!! to connect. " + ex + "\n");
        }
        String m = null;
        try {
            do {
                try {
                    m = "" + is.readObject();
                    if (m.endsWith(".doc")) {
                        try {
                            file[numFile] = m;
                            SocketFile sf = new SocketFile(socket, m);
                            int size = Integer.parseInt("" + is.readObject());
                            sf.receiveFile(size);
                            numFile++;
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "You did not get important files...\n" + ex);
                        }
                    } else if ("Info".equals(m)) {
                        frS.ts.os.writeObject("TakeInfo");
                        frS.ts.os.writeObject(frS.getExameenName() + "/" + frS.getExameenRoll());
                    } else if (m.startsWith(frS.getExameenName() + "/" + frS.getExameenRoll())) {
                        String s = m.substring((frS.getExameenName() + "/" + frS.getExameenRoll()).length(), (frS.getExameenName() + "/" + frS.getExameenRoll()).length() + 3);
                        if ("Inc".equals(s)) {
                            int ioq = Integer.parseInt(m.substring((frS.getExameenName() + "/" + frS.getExameenRoll()).length() + 3));
                            frS.dw.b -= ioq;
                            frS.dw.y += ioq;
                            frS.dw.value -= ioq * 60;
                            frS.output.setText(frS.output.getText() + "Time increased " + ioq + " minute\n");
                        } else if ("Dec".equals(s)) {
                            int doq = Integer.parseInt(m.substring((frS.getExameenName() + "/" + frS.getExameenRoll()).length() + 3));
                            frS.dw.b += doq;
                            frS.dw.y -= doq;
                            frS.dw.value += doq * 60;
                            frS.output.setText(frS.output.getText() + "Time decreased " + doq + " minute\n");
                        }
                    } else if (m.startsWith("All")) {
                        String s = m.substring(("All").length(), ("All").length() + 3);
                        if ("Inc".equals(s)) {
                            int ioq = Integer.parseInt(m.substring(("All").length() + 3));
                            frS.dw.b -= ioq;
                            frS.dw.y += ioq;
                            frS.dw.value -= ioq * 60;
                            frS.output.setText(frS.output.getText() + "Time increased " + ioq + " minute\n");
                        } else if ("Dec".equals(s)) {
                            int doq = Integer.parseInt(m.substring(("All").length() + 3));
                            frS.dw.b += doq;
                            frS.dw.y -= doq;
                            frS.dw.value += doq * 60;
                            frS.output.setText(frS.output.getText() + "Time decreased " + doq + " minute\n");
                        }
                    } else if (m.equals("Expel" + frS.getExameenName() + "/" + frS.getExameenRoll())) {
                        if (getComplete() == 0) {
                            frS.setButtonTimer(true);
                            frS.setQues_no(frS.getFinishCount() + 1);
                            frS.setTimer(5);
                            setComplete(1);
                            try {
                                frS.ts.os.writeObject("EEEName: " + frS.getExameenName() + "  Roll no: " + frS.getExameenRoll() + " Expeled");
                                frS.ts.os.writeObject("Marks" + " " + new Date() + "\n");
                                frS.ts.os.writeObject("Name: " + frS.getExameenName() + "  Roll no: " + frS.getExameenRoll() + "  Marks: " + frS.getCount());

                                os.writeObject("Expeled");
                            } catch (IOException ex) {
                                JOptionPane.showMessageDialog(null, "Problem to send your result to the controller\nInform him directly.\nThank you");
                            }
                            frS.closeMyAnswer();
                            MsgViewer mv = new MsgViewer();
                            mv.picLebel.setIcon(new ImageIcon(getClass().getResource("lightflash_b.gif")));
                            mv.msgLebel.setText("You are Exapled.");
                            mv.setTitle("Expel Message");
                            mv.col.setBackground(Color.red);
                            mv.setVisible(true);
                            frS.output.setText(frS.output.getText() + "You are expeled\n");
                        } else {
                            os.writeObject("Name: " + frS.getExameenName() + " Roll no.:" + frS.getExameenRoll() + " is already expled" + new Date());
                        }
                    } else if ("Title".equals(m)) {
                        frS.ed.setTitle("" + is.readObject());
                    } else if ("Neg".equals(m)) {
                        frS.setNegMarking(Float.parseFloat("" + is.readObject()));
                    } else if (m.equals("start exam")) {
                        frS.setTimeLocker(1);
                        frS.output.setText(frS.output.getText() + "Exam is Started by controller.\nMade sure That you have inserted your Name and Roll no. correctly.\nThen Press Start Exam button.\n");
                        MsgViewer mv = new MsgViewer();
                        mv.picLebel.setIcon(new ImageIcon(getClass().getResource("3DCOIN.GIF")));
                        mv.msgLebel.setText("Exam is started by the controller. Read your Inbox carefully");
                        mv.setTitle("Exam Started.");
                        mv.col.setBackground(Color.green);
                        mv.setVisible(true);

                    } else if ("Password".equals(m)) {
                        String pass = "" + is.readObject();
                        while (true) {
                            String myPass = JOptionPane.showInputDialog(null, "Enter password.");
                            if (pass.equals(myPass)) {
                                break;
                            } else if (myPass.equals("jnucse02-exit")) {
                                System.exit(0);
                            } else {
                                JOptionPane.showMessageDialog(null, "Invalid password.\nContact to the controller");
                            }
                        }
                        frS.output.setText(frS.output.getText() + "Done.\n");
                    } else if ("Icon".equals(m)) {
                        String icon = "" + is.readObject();
                        SocketFile sf = new SocketFile(socket, icon.substring(icon.lastIndexOf("\\") + 1));
                        int size = Integer.parseInt("" + is.readObject());
                        sf.receiveFile(size);

                    } else if ("Done".equals(m)) {
                        frS.openFile("D:\\" + file[0], "D:\\" + file[1], "D:\\" + file[2]);
                        frS.setQuestion("D:\\" + file[1], "D:\\" + file[2]);
                        frS.output.setText(frS.output.getText() + "Wait....\n");
                    } else if ("Finish".equals(m) && getComplete() == 0) {
                        frS.setButtonTimer(true);
                        frS.setQues_no(frS.getFinishCount() + 1);
                        frS.setTimer(5);
                        try {
                            frS.ts.os.writeObject("Marks" + " " + new Date() + "\n");
                            frS.ts.os.writeObject("Name: " + frS.getExameenName() + "  Roll no: " + frS.getExameenRoll() + "  Marks: " + frS.getCount());
                            frS.closeMyAnswer();

                            os.writeObject("Rcv");
                            File f = new File("D:\\" + frS.getExameenName() + "_" + frS.getExameenRoll() + ".doc");
                            os.writeObject(frS.getExameenName() + "_" + frS.getExameenRoll() + ".doc");
                            os.writeObject("" + f.length());
                            ServerFile sf = new ServerFile("D://" + frS.getExameenName() + "_" + frS.getExameenRoll() + ".doc", server, socket);
                            sf.sendFile();
                            setComplete(1);


                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, "Problem to send your result to the controller\nInform him directly.\nThank you");
                        }
                        frS.output.setText(frS.output.getText() + "Exam Finished\n" + "Name: " + frS.getExameenName() + "  Roll no: " + frS.getExameenRoll() + "  Marks: " + frS.getCount() + "\n");
                        frS.output.setText(frS.output.getText() + "Press Details Result button, to see your result question by question.\n");
                        JOptionPane.showMessageDialog(null, "Exam Finished.\nYour Result is: " + frS.getCount(), "Exam Finished", 1);
                        frS.setLock(1);

                    } else if ("Finish".equals(m)
                            && getComplete() == 1) {
                        os.writeObject("Rcv");
                        File f = new File("D:\\" + frS.getExameenName() + "_" + frS.getExameenRoll() + ".doc");
                        os.writeObject(frS.getExameenName() + "_" + frS.getExameenRoll() + ".doc");
                        os.writeObject("" + f.length());
                        ServerFile sf = new ServerFile("D://" + frS.getExameenName() + "_" + frS.getExameenRoll() + ".doc", server, socket);
                        sf.sendFile();
                        frS.setLock(1);
                        frS.output.setText(frS.output.getText() + "Exam Finished\n");
                        frS.output.setText(frS.output.getText() + "Press Details Result button, to see your result question by question.\n");
                    } else if (("Stop" + frS.getExameenRoll()).equals(m)) {
                        if (getComplete() == 0) {
                            String text = m.substring(4);
                            if (text.equals("" + frS.getExameenRoll())) {
                                frS.setButtonTimer(true);
                                frS.setQues_no(frS.getFinishCount() + 1);
                                frS.setTimer(5);
                                setComplete(1);
                                try {
                                    frS.ts.os.writeObject("EEEName: " + frS.getExameenName() + "  Roll no: " + frS.getExameenRoll() + " Expeled");
                                    frS.ts.os.writeObject("Marks" + " " + new Date() + "\n");
                                    frS.ts.os.writeObject("Name: " + frS.getExameenName() + "  Roll no: " + frS.getExameenRoll() + "  Marks: " + frS.getCount());

                                    os.writeObject("Expeled");
                                } catch (IOException ex) {
                                    JOptionPane.showMessageDialog(null, "Problem to send your result to the controller\nInform him directly.\nThank you");
                                }
                                frS.closeMyAnswer();
                                MsgViewer mv = new MsgViewer();
                                mv.picLebel.setIcon(new ImageIcon(getClass().getResource("lightflash_b.gif")));
                                mv.msgLebel.setText("You are Exapled.");
                                mv.setTitle("Expel Message");
                                mv.col.setBackground(Color.red);
                                mv.setVisible(true);
                                frS.output.setText(frS.output.getText() + "You are expeled\n");
                            } else {
                            }
                        } else {
                            os.writeObject("Name: " + frS.getExameenName() + " Roll no.:" + frS.getExameenRoll() + " is already expled" + new Date());
                        }
                    } else if ("Close".equals(m)) {
                        try {
                            File fori = new File("D://" + frS.getExameenName() + "_" + frS.getExameenRoll() + ".doc");
                            fori.delete();
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Error: " + ex);
                        }
                        os.writeObject("ClosedName: " + frS.getExameenName() + " Roll no. " + frS.getExameenRoll() + " Frame Closed.");
                        System.exit(0);
                    } else if (m.startsWith(
                            "CCC")) {
                        frS.output.setText(frS.output.getText() + "Controller: " + m.substring(3) + "\n");
                    }

                    frS.ed.setServerMsg(
                            1);
                    os.flush();
                } catch (Exception ex) {
                    //frS.setDis(0);
                    //frS.output.setText(frS.output.getText() + "Problem!!!! to receive message from controller. " + ex + "\n");
                    //frS.th.stop();
                    //return;
                }
                frS.repaint();
            } while (!("" + socket.getInetAddress().getHostName() + ">>> " + "TERMINATE").equals(m));
        } catch (Exception ex) {
            //frS.setDis(0);
            //frS.output.setText(frS.output.getText() + "Problem!!!! to receive message from controller. " + ex + "\n");
            //frS.th.stop();
            //return;
        }
    }

    public void terminateConnection() {
        try {
            server.close();
            socket.close();
            os.close();
            is.close();
        } catch (Exception ex) {
            frS.output.setText(frS.output.getText() + "Problem!!!! to disconnect(TerminateConnection). " + ex + "\n");
        }
    }
}
