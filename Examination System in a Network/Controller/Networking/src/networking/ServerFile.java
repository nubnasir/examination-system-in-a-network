/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package networking;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TOSHIBA
 */
public class ServerFile {

    /**
     * @param args the command line arguments
     */
    public String fileName;
    //ServerSocket servsock;
    Socket sock;
    OutputStream os = null;

    public ServerFile(String msg, Socket s) {
        fileName = msg;
        //servsock = ss;
        sock = s;
    }

    public void sendFile() {
        // TODO code application logic here

        File myFile = new File(fileName);
        try {
            byte[] mybytearray = new byte[(int) myFile.length()];
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(myFile));
            bis.read(mybytearray, 0, mybytearray.length);
            for (int i = 0; i < mybytearray.length; i++) {
                byte my[] = new byte[1];
                my[0] = mybytearray[i];
                bis.read(my);
                os = sock.getOutputStream();
                os.write(my);
            }
            //os.flush();
            bis.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerFile.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}
