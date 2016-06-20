/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package officecomunicator;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author TOSHIBA
 */
public class ServerFile implements Runnable {

    /**
     * @param args the command line arguments
     */
    public String fileName;
    ServerSocket servsock;
    Socket sock;
    OutputStream os = null;
    FileSenderFrame fsf;

    public ServerFile(Socket s) {

        sock = s;
    }

    @Override
    public void run() {
        File myFile = new File(fileName);
        fsf.prog.setValue(0);
        try {
            byte[] mybytearray = new byte[(int) myFile.length()];
            fsf.prog.setMaximum(mybytearray.length);
            //System.out.println("" + mybytearray.length);
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(myFile));
            bis.read(mybytearray, 0, mybytearray.length);
            for (int i = 0; i < mybytearray.length; i++) {
                byte my[] = new byte[1];
                my[0] = mybytearray[i];
                bis.read(my);
                os = sock.getOutputStream();
                os.write(my);
                fsf.prog.setValue(i + 1);
            }
            //os.flush();
            bis.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error2: " + ex);
        }

    }

    public void sendFile(String msg, FileSenderFrame fs) {
        // TODO code application logic here
        fileName = msg;
        fsf = fs;
    }
}
