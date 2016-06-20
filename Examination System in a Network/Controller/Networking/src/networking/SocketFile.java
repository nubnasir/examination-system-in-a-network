/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package networking;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author TOSHIBA
 */
public class SocketFile {

    /**
     * @param args the command line arguments
     */
    Socket sock;
    String fileName;

    public SocketFile(Socket s) {
        sock = s;
    }

    public void receiveFile(int size, String f) {
        // TODO code application logic here
        fileName = f;
        try {
            byte[] mybytearray = new byte[size];
            InputStream is = sock.getInputStream();
            if (fileName.startsWith("temp")) {
                fileName = fileName.substring(4);
            }
            FileOutputStream fos = new FileOutputStream("D://Exam Controller/Students answer file/" + fileName);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            for (int i = 0; i < mybytearray.length; i++) {
                byte my[] = new byte[1];
                my[0] = mybytearray[i];
                int bytesRead = is.read(my);
                bos.write(my);
            }
            bos.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex);
        }

    }
}
