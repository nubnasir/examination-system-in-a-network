/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package officecomunicator;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author TOSHIBA
 */
public class ThreadServer implements Runnable {

    public OfficeFrame frS;
    ServerSocket server;
    Socket socket;
    ObjectOutputStream os[] = new ObjectOutputStream[100];
    ObjectInputStream is[] = new ObjectInputStream[100];
    int port = 500;
    ChatRunner cr[] = new ChatRunner[100];
    public Thread thread[] = new Thread[100];
    ChatRunner chatRunner;
    SocketFile sockf[] = new SocketFile[100];
    public String friendName[] = new String[100];
    public String friendGroup[] = new String[100];
    public int sendCounter = 0;
    ServerFile sf[] = new ServerFile[100];
    //ProImSender pis[] = new ProImSender[100];
    //ProImReceiver pir[] = new ProImReceiver[100];
    public int busy[] = new int[100];
    public int gameText = 0;

    public String getIpaddress() {
        return Ipaddress;
    }

    public void setIpaddress(String Ipaddress) {
        this.Ipaddress = Ipaddress;
    }
    public String Ipaddress;

    public int getGroupCounter() {
        return groupCounter;
    }

    public void setGroupCounter(int groupCounter) {
        this.groupCounter = groupCounter;
    }
    public int groupCounter = 0;

    public int getJrecCount() {
        return jrecCount;
    }

    public void setJrecCount(int jrecCount) {
        this.jrecCount = jrecCount;
    }
    public int jrecCount = 0;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String msg;

    public int getLoopCounter() {
        return loopCounter;
    }

    public void setLoopCounter(int loopCounter) {
        this.loopCounter = loopCounter;
    }
    int loopCounter = 0;

    public int getCancle() {
        return cancle;
    }

    public void setCancle(int cancle) {
        this.cancle = cancle;
    }
    int cancle = 0;

    public String getGamePlayPlayer() {
        return gamePlayPlayer;
    }

    public void setGamePlayPlayer(String gamePlayPlayer) {
        this.gamePlayPlayer = gamePlayPlayer;
    }
    String gamePlayPlayer;

    public ThreadServer(OfficeFrame fn) {
        try {
            frS = fn;
            server = new ServerSocket(12345, port);
        } catch (IOException ex) {
            frS.designer("Prolem in constractor." + ex, "red");
        }
    }

    @Override
    public void run() {
        chatting();
    }

    public void accecptCoonection() throws UnknownHostException {

        //frS.output.setText(frS.output.getText() + "Waiting...To connect with student no." + (cancle + 1) + " " + new Date() + "\n");

        //frS.designer("Waiting...To connect with student no." + (cancle + 1) + " " + new Date(), "blue");


        try {
            socket = server.accept();
            //    os.flush();
            //cancle++;
            //frS.designer("Connect to: " + socket.getInetAddress().getHostName() + " " + new Date(), "green");
        } catch (Exception ex) {
            frS.designer("Connection ignored." + new Date(), "red");
            //terminateConnection();
            //frS.t1.stop();
        }
        try {
            os[cancle] = new ObjectOutputStream(socket.getOutputStream());
            is[cancle] = new ObjectInputStream(socket.getInputStream());
            //os[cancle].writeObject("CCChello welcome to the server " + new Date() + "\n");


            busy[cancle] = 4;
            sockf[cancle] = new SocketFile(socket, frS);
            sf[cancle] = new ServerFile(socket);
            //pis[cancle] = new ProImSender(socket);
            //pir[cancle] = new ProImReceiver(socket, frS);
            cr[cancle] = new ChatRunner(os[cancle], is[cancle], frS, cancle);
            thread[cancle] = new Thread(cr[cancle]);
            thread[cancle].start();
        } catch (Exception ex) {
            frS.designer("Problem!!!! in build stream. unable to connect with the server" + ex, "red");
        }

    }

    public void chatting() {
        //int i=0;
        while (true) {
            try {
                accecptCoonection();
            } catch (UnknownHostException ex) {
                frS.designer("Problem!!!! to connect. " + ex, "red");
            }

            //cancle++;
        }
    }

    public void terminateConnection() {
        try {
            server.close();
            socket.close();
            for (int i = 0; i < getCancle(); i++) {
                os[i].close();
                is[i].close();
            }
        } catch (Exception ex) {
            frS.designer("Problem!!!! to disconnect(TerminateConnection). " + ex, "red");
        }
    }

    public void writer() {
        for (int k = 0; k < getCancle(); k++) {
            try {
                if (busy[k] == 4) {
                    os[k].writeObject(getMsg());
                } else if (busy[k] == 3) {
                    frS.designer(friendName[k] + " is busy to receiving a file from you(unable to send message)", "red");
                } else if (busy[k] == 2) {
                    frS.designer(friendName[k] + " is busy to sending a file to you(unable to send message)", "red");
                } else if (busy[k] == 1) {
                    frS.designer(friendName[k] + " is busy (unable to send message)", "red");
                }
            } catch (Exception ex) {
                frS.designer("Problem!!!! in writer(). unable to connect with the server" + ex, "red");
            }
        }
    }

    public void removewriter() {
        for (int k = 0; k < getCancle(); k++) {
            try {
                if (busy[k] == 4) {
                    os[k].writeObject(getMsg());
                } else if (busy[k] == 3) {
                    frS.designer(friendName[k] + " is busy to receiving a file from you(unable to send message)", "red");
                } else if (busy[k] == 2) {
                    frS.designer(friendName[k] + " is busy to sending a file to you(unable to send message)", "red");
                } else if (busy[k] == 1) {
                    frS.designer(friendName[k] + " is busy (unable to send message)", "red");
                }
            } catch (Exception ex) {
                frS.designer("Problem!!!! in writer(). unable to connect with the server" + ex, "red");
            }
        }
        System.exit(0);
    }

    public void deleteFriend() {
        for (int k = 0; k < getCancle(); k++) {
            if (friendName[k].equals("" + frS.getDeleteFriend())) {
                for (int j = k; j < getCancle(); j++) {
                    if (getCancle() > 1) {
                        friendName[j] = friendName[j + 1];
                        os[j] = os[j + 1];
                        is[j] = is[j + 1];
                        cr[k] = cr[j + 1];
                        thread[j] = thread[j + 1];
                        busy[j] = busy[j + 1];
                        sockf[j] = sockf[j + 1];
                        sf[j] = sf[j + 1];
                        //pis[j] = pis[j + 1];
                        //pir[j] = pir[j + 1];
                    } else {
                        friendName[j] = null;
                    }
                }
                setCancle(getCancle() - 1);
                frS.ListManeger();
                thread[getCancle()].stop();
                break;
            }
        }
    }

    public void deleteMe() {
        for (int k = 0; k < getCancle(); k++) {
            if (friendName[k].equals("" + frS.getDeleteFriend())) {
                for (int j = k; j < getCancle(); j++) {
                    if (getCancle() > 1) {
                        friendName[j] = friendName[j + 1];
                        os[j] = os[j + 1];
                        is[j] = is[j + 1];
                        cr[j] = cr[j + 1];
                        thread[j] = thread[j + 1];
                        busy[j] = busy[j + 1];
                        sockf[j] = sockf[j + 1];
                        sf[j] = sf[j + 1];
                        //pis[j] = pis[j + 1];
                        //pir[j] = pir[j + 1];
                    } else {
                        friendName[j] = null;
                    }
                }
                setCancle(getCancle() - 1);
                frS.ListManeger();
                thread[getCancle()].stop();
                break;
            }
        }
    }

    /*public void addAfterRequest() {
        busy[getCancle()] = 4;
        sockf[getCancle()] = new SocketFile(frS.tsp.socket, frS);
        sf[getCancle()] = new ServerFile(frS.tsp.socket);
        pis[getCancle()] = new ProImSender(frS.tsp.socket);
        pir[getCancle()] = new ProImReceiver(frS.tsp.socket, frS);
        cr[getCancle()] = new ChatRunner(os[getCancle()], is[getCancle()], frS, getCancle());
        thread[getCancle()] = new Thread(cr[getCancle()]);
        thread[getCancle()].start();
        cancle++;
    }*/

    public void ejectAfterRequest() {
        cancle--;
        thread[getCancle() + 1].stop();
    }

    public void removeFriendFromGroup() {
        for (int k = 0; k < getGroupCounter(); k++) {
            if (friendGroup[k].equals("" + frS.getRemoveFriendGroup())) {
                for (int j = k; j < getGroupCounter(); j++) {
                    if (getGroupCounter() > 1) {
                        friendGroup[j] = friendGroup[j + 1];
                    } else {
                        friendGroup[j] = null;
                    }
                }
                setGroupCounter(getGroupCounter() - 1);
                frS.GroupListManeger();
                break;
            }
        }
    }

    public void GroupWriter() {
        for (int j = 0; j < getGroupCounter(); j++) {
            for (int k = 0; k < getCancle(); k++) {
                if (friendGroup[j].equals(friendName[k])) {
                    try {
                        if (busy[k] == 4) {
                            os[k].writeObject(getMsg());
                        } else if (busy[k] == 3) {
                            frS.designer(friendName[k] + " is busy to receiving a file to you(unable to send message)", "red");
                        } else if (busy[k] == 2) {
                            frS.designer(friendName[k] + " is busy to sending a file from you(unable to send message)", "red");
                        } else if (busy[k] == 1) {
                            frS.designer(friendName[k] + " is busy (unable to send message)", "red");
                        }
                    } catch (Exception ex) {
                        frS.designer("Problem!!!! in GroupWriter(). unable to connect with the server" + ex, "red");
                    }
                }
            }
        }
    }

    public void ChatAWriter() {
        for (int k = 0; k < getCancle(); k++) {
            if (friendName[k].equals(frS.getChatafriend())) {
                try {
                    if (busy[k] == 4) {
                        os[k].writeObject(getMsg());
                    } else if (busy[k] == 3) {
                        frS.designer(friendName[k] + " is busy to receiving a file to you(unable to send message)", "red");
                    } else if (busy[k] == 2) {
                        frS.designer(friendName[k] + " is busy to sending a file from you(unable to send message)", "red");
                    } else if (busy[k] == 1) {
                        frS.designer(friendName[k] + " is busy (unable to send message)", "red");
                    }
                    break;
                } catch (Exception ex) {
                    frS.designer("Problem!!!! in GroupWriter(). unable to connect with the server" + ex, "red");
                }
            }
        }
    }

    public void gamePlayerWriter() {
        for (int k = 0; k < getCancle(); k++) {
            if (friendName[k].equals(getGamePlayPlayer())) {
                try {
                    if (busy[k] == 4) {
                        os[k].writeObject(getMsg());
                    } else if (busy[k] == 3) {
                        JOptionPane.showMessageDialog(null, friendName[k] + " is busy to receiving a file to you\n(unable to Play)");
                    } else if (busy[k] == 2) {
                        JOptionPane.showMessageDialog(null, friendName[k] + " is busy to sending a file from you\n(unable to Play)");
                    } else if (busy[k] == 1) {
                        JOptionPane.showMessageDialog(null, friendName[k] + " is busy\n(unable to send message)");
                    }
                    break;
                } catch (Exception ex) {
                    frS.designer("Problem!!!! in gamePlayerWriter(). unable to connect with the server" + ex, "red");
                    JOptionPane.showMessageDialog(null, "Problem!!!! in gamePlayerWriter().\nunable to connect with the server\n" + ex);
                }
            }
        }
    }
    /*public void allSendFileWriter() {
    try {
    if (sendCounter < getCancle()) {
    os[sendCounter].writeObject("File");
    }
    } catch (Exception ex) {
    JOptionPane.showMessageDialog(null, "Error: " + ex);
    }
    }
    
    public void fileReceiver(int p) {
    try {
    String name = "" + is[p].readObject();
    int size = Integer.parseInt("" + is[p].readObject());
    frS.ts.sockf[p].receiveFile(size, name);
    } catch (Exception ex) {
    JOptionPane.showMessageDialog(null, "Error6: " + ex);
    }
    }*/
}
