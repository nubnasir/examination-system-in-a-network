/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package networking;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author TOSHIBA
 */
public class ThreadSocket implements Runnable {

    public FrameNetwork frS;
    ServerSocket server;
    Socket socket;
    ObjectOutputStream os;
    ObjectInputStream is;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }
    public String fileName;
    public long fileSize;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    public String filePath;

    public ThreadSocket(FrameNetwork fn) {
        frS = fn;
    }

    @Override
    public void run() {
        chatting();
    }

    public void searchConnection() {

        String uname = JOptionPane.showInputDialog(null, "Enter your name: ");
        String room = JOptionPane.showInputDialog(null, "Enter Room number: ");
        frS.setU_name(uname);
        frS.setRoomId(room);
        String Ipaddress = JOptionPane.showInputDialog(null, "Insert The IP Address");

        frS.designer("Wait Connecting to Head Controller......", "BlUE");
        frS.designer("Using Your Name: " + uname + " and Room Number: " + room, "BLUE");

        try {

            socket = new Socket(Ipaddress, 12345);

            //frS.designer("Connected to : " + socket.getInetAddress().getHostName(), "BLUE");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Incorrect IP Address.");
            //frS.output.setText(frS.output.getText() + "Problem!!!! Searching faild..... " + ex + "\n");
            //terminateConnection();
            frS.setConnectionAgain(1);
            //frS.th.stop();
        }

        try {
            os = new ObjectOutputStream(socket.getOutputStream());
            is = new ObjectInputStream(socket.getInputStream());

            os.writeObject("ID");
            os.writeObject("Name: " + uname + " and Room Number: " + room);
        } catch (Exception ex) {
            //frS.output.setText(frS.output.getText() + "Problem!!!! in build stream. unable to connect with the server" + ex + "\n");
        }
    }

    public void chatting() {
        try {
            searchConnection();
        } catch (Exception ex) {
            frS.output.setText(frS.output.getText() + "Problem!!!! to connect. " + ex + "\n");
        }
        String m = null;
        try {
            do {
                try {
                    m = "" + is.readObject();
                    if ("YES".equals(m)) {
                        frS.designer("Connection is Completed with Head Controller...", "GREEN");
                        frS.setConnectionAgain(1);
                    } else if ("NO".equals(m)) {
                        frS.designer("Head Controller ignored your connection. Try Letter...", "red");
                        socket.close();
                        os.close();
                        is.close();
                        frS.setConnectionAgain(0);
                    } else if ("Send".equals(m)) {
                        
                            frS.tsp.os.writeObject(getFileName());
                            frS.tsp.os.writeObject("" + getFileSize());
                            ServerFile sf = new ServerFile(getFilePath(), socket);
                            sf.sendFile();
                        
                    } else if ("LogOut".equals(m)) {
                        socket.close();
                        os.close();
                        is.close();
                        frS.setConnectionAgain(0);
                        frS.designer("Head Controller is logged Out...", "RED");
                    } else if (m.startsWith("HHH")) {
                        frS.designer(m.substring(3), "BLACK");
                    }
                    os.flush();
                } catch (Exception ex) {
                    frS.setDis(0);
                    frS.output.setText(frS.output.getText() + "Problem!!!! to receive message from Head Controller. " + ex + "\n");
                    return;
                }
                frS.repaint();
            } while (!("" + InetAddress.getLocalHost() + ">>> " + "TERMINATE").equals(m));
        } catch (Exception ex) {
            frS.setHeadC(0);
            frS.setDis(0);
            frS.output.setText(frS.output.getText() + "Problem!!!! to receive message from Head Controller. " + ex + "\n");
            frS.t2.stop();
            return;
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
