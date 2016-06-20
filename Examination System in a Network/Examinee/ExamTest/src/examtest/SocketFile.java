/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package examtest;

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

    public SocketFile(Socket s, String f) {
        sock = s;
        fileName=f;
    }

    public void receiveFile(int size) {
        // TODO code application logic here

        try {
            byte[] mybytearray = new byte[size];
            InputStream is = sock.getInputStream();

            FileOutputStream fos = new FileOutputStream("D:\\" + fileName);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            for (int i = 0; i < mybytearray.length; i++) {
                byte my[] = new byte[1];
                my[0] = mybytearray[i];
                int bytesRead = is.read(my);
                bos.write(my);
            }
            bos.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error"+ex);
        }

    }
}
