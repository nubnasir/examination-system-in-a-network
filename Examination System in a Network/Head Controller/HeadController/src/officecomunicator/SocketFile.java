/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package officecomunicator;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author TOSHIBA
 */
public class SocketFile implements Runnable {

    /**
     * @param args the command line arguments
     */
    Socket sock;
    String fileName;
    OfficeFrame frS;
    int size;

    public SocketFile(Socket s, OfficeFrame of) {
        sock = s;
        frS = of;
    }

    @Override
    public void run() {
        try {
            /*byte[] mybytearray = new byte[size];
            InputStream is = sock.getInputStream();
            FileOutputStream fos = new FileOutputStream(frS.rcvDesText.getText()+"/" + fileName);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            frS.rcvProgress.setValue(0);
            frS.rcvProgress.setMaximum(size);
            for (int i = 0; i < mybytearray.length; i++) {
                byte my[] = new byte[1];
                my[0] = mybytearray[i];
                int bytesRead = is.read(my);
                bos.write(my);
                int a = ((i + 1) * 100) / size;
                frS.rcvProgress.setValue(i + 1);
                frS.rcvProgress.setString("Rceiving a file: " + a + "%");
            }
            bos.close();*/
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex);
        }
    }

    public void receiveFile(int s, String f) {
        // TODO code application logic here
        fileName = f;
        size = s;
    }
}
