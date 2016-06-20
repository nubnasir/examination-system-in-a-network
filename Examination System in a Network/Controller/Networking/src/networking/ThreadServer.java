/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package networking;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Formatter;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author TOSHIBA
 */
public class ThreadServer implements Runnable {
    
    public FrameNetwork frS;
    ServerSocket server;
    Socket socket;
    ObjectOutputStream os[] = new ObjectOutputStream[100];
    ObjectInputStream is[] = new ObjectInputStream[100];
    int port = 500;
    ChatRunner cr[] = new ChatRunner[100];
    public Thread thread[] = new Thread[100];
    ChatRunner chatRunner;
    public Formatter Result = null;
    public float marks[] = new float[100];
    public String stuResult[] = new String[100];
    public int jprogressCounter = 0;
    public int counter = 0;
    public FileWriter fw = null;
    SocketFile sockf[] = new SocketFile[100];
    public String stu[];
    
    public int getStuCounter() {
        return stuCounter;
    }
    
    public void setStuCounter(int stuCounter) {
        this.stuCounter = stuCounter;
    }
    public int stuCounter = 0;
    
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
    int resultCounter = 0;
    
    public int getCancle() {
        return cancle;
    }
    
    public void setCancle(int cancle) {
        this.cancle = cancle;
    }
    int cancle = 0;
    
    public ThreadServer(FrameNetwork fn) {
        try {
            frS = fn;
            openNewFile();
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

        frS.designer("Waiting...To connect with student no." + (cancle + 1) + " " + new Date(), "blue");
        
        
        try {
            socket = server.accept();
            //    os.flush();
            //cancle++;
            frS.designer("Connect to: " + socket.getInetAddress().getHostName() + " " + new Date(), "green");
        } catch (Exception ex) {
            frS.designer("Connection ignored." + new Date(), "red");
            //terminateConnection();
            //frS.t1.stop();
        }
        try {
            os[cancle] = new ObjectOutputStream(socket.getOutputStream());
            is[cancle] = new ObjectInputStream(socket.getInputStream());
            os[cancle].writeObject("CCChello welcome to the server " + new Date() + "\n");
            
            
            sockf[cancle] = new SocketFile(socket);
            
            cr[cancle] = new ChatRunner(is[cancle], frS, cancle);
            thread[cancle] = new Thread(cr[cancle]);
            thread[cancle].start();
        } catch (Exception ex) {
            //frS.designer("Problem!!!! in build stream. unable to connect with the server" + ex ,"red");
        }
        try {
            
            
            frS.jprog.setValue(0);
            frS.jprog.setMaximum(100);
            
            File f = new File("D://Exam Controller//time.doc");
            os[cancle].writeObject("time.doc");
            os[cancle].writeObject("" + f.length());
            ServerFile sf = new ServerFile("D://Exam Controller//time.doc", socket);
            sf.sendFile();
            //frS.output.setText(frS.output.getText() + "E://time.doc: Sent: " + new Date() + "\n");
            frS.jprog.setValue(10);
            
            f = new File(frS.getQuestionFilePath());
            os[cancle].writeObject(frS.getQuestionFileName());
            os[cancle].writeObject("" + f.length());
            sf = new ServerFile(frS.getQuestionFilePath(), socket);
            sf.sendFile();
            //frS.output.setText(frS.output.getText() + frS.getQuestionFilePath() + ": Sent: " + new Date() + "\n");
            frS.jprog.setValue(20);
            
            f = new File(frS.getAnswerFilePath());
            os[cancle].writeObject(frS.getAnswerFileName());
            os[cancle].writeObject("" + f.length());
            sf = new ServerFile(frS.getAnswerFilePath(), socket);
            sf.sendFile();
            frS.jprog.setValue(30);
            
            
            os[cancle].writeObject("Done");
            
            
            Scanner icon = new Scanner(new File("D://Exam Controller//Icon File.doc"));
            int i = 0;
            while (icon.hasNext()) {
                os[cancle].writeObject("Icon");
                String iconName = icon.nextLine();
                f = new File(iconName);
                os[cancle].writeObject(iconName);
                sf = new ServerFile(iconName, socket);
                os[cancle].writeObject("" + f.length());
                sf.sendFile();

                //frS.output.setText(frS.output.getText() + iconName + " " + ": Sent: " + new Date() + "\n");

                frS.jprog.setValue(30 + i * 2);
                i++;
            }
            if (icon != null) {
                icon.close();
            }
            
            
            
            frS.designer("All files : Sent: " + new Date(), "orange");
            frS.designer("----------------------------------------------------------------", "black");
            
            frS.jprog.setValue(70);



            /*f = new File("E://temp" + frS.getAnswerFileName());
            os[cancle].writeObject("temp" + frS.getAnswerFileName());
            os[cancle].writeObject("" + f.length());
            sf = new ServerFile("E://temp" + frS.getAnswerFileName(), server, socket);
            sf.sendFile();*/
            //frS.output.setText(frS.output.getText() + "E://temp" + frS.getAnswerFileName() + ": Sent: " + new Date() + "\n");
            frS.jprog.setValue(80);
            
            
            os[cancle].writeObject("Title");
            os[cancle].writeObject(frS.getSpon());
            
            os[cancle].writeObject("Neg");
            os[cancle].writeObject("" + frS.getNegMark());
            
            frS.jprog.setValue(90);

            /*os[cancle].writeObject("Icon");
            f = new File(frS.getIconFilePath());
            os[cancle].writeObject(frS.getIconFilePath());
            os[cancle].writeObject("" + f.length());
            sf = new ServerFile(frS.getIconFilePath(), server, socket);
            sf.sendFile();
            
            frS.jprog.setValue(0);
            frS.jprog.setMaximum((int) f.length());
            for (int i = 0; i < f.length()*2; i++) {
            frS.jprog.setValue(i);
            }
            
            
            frS.jprog.setMaximum(100);
            frS.jprog.setValue(frS.jprog.getMaximum());
            
            frS.output.setText(frS.output.getText() + frS.getIconFilePath() + ": Sent: " + new Date() + "\n");*/
            
            
            
            os[cancle].writeObject("Password");
            os[cancle].writeObject(frS.getPasswordRead());
            
            frS.jprog.setMaximum(100);
            frS.jprog.setValue(frS.jprog.getMaximum());

            /*f = new File("E://temp" + frS.getQuestionFileName());
            os[cancle].writeObject("temp" + frS.getQuestionFileName());
            os[cancle].writeObject("" + f.length());
            sf = new ServerFile("E://temp" + frS.getQuestionFileName(), server, socket);
            sf.sendFile();*/
            
            if (frS.getTimerHandel() == 1) {
                os[cancle].writeObject("start exam");
            }
            
            frS.setExamine(1);
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error to send file." + ex);
        }
    }
    
    public void chatting() {
        //int i=0;
        while (true) {
            try {
                accecptCoonection();
            } catch (UnknownHostException ex) {
                //frS.designer("Problem!!!! to connect. " + ex ,"red");
            }
            /*String m = null;
            try {
            try {
            m = "" + is[cancle].readObject();
            if (!m.equals("A")) {
            frS.output.setText(frS.output.getText() + m + "\n");
            os[cancle].flush();
            
            } else if (m.equals("A")) {
            break;
            }
            } catch (Exception ex) {
            frS.setDis(0);
            frS.output.setText(frS.output.getText() + "Problem!!!! to chat. " + ex + "\n");
            //frS.t2.stop();
            return;
            }
            frS.repaint();
            
            } catch (Exception ex) {
            frS.setDis(0);
            frS.output.setText(frS.output.getText() + "Problem!!!! to chat. " + ex + "\n");
            frS.t1.stop();
            return;
            }
            cancle++;
            } else {
            //readMsg();
            lisening();
             */
            frS.stuNumber.setText("Total Accepted Connections:" + (cancle + 1));
            cancle++;
            
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
            //frS.designer("Problem!!!! to disconnect(TerminateConnection). " + ex,"red");
        }
    }
    
    public void writer() {
        frS.jprog.setValue(0);
        frS.jprog.setMaximum(getCancle());
        
        frS.jprog.setString("Sending...");
        
        for (int k = 0; k < getCancle(); k++) {
            try {
                os[k].writeObject(getMsg());
                frS.jprog.setValue(k);
            } catch (Exception ex) {
                //frS.designer("Problem!!!! in writer(). unable to connect with the server" + ex,"red");
            }
        }
        
        frS.jprog.setMaximum(100);
        frS.jprog.setValue(100);
    }

    /*public void readMsg() {
    int i = 0;
    while (true) {
    try {
    try {
    String m = null;
    m = "" + is[i].readObject();
    if (!m.equals("A")) {
    frS.output.setText(frS.output.getText() + m + "\n");
    os[i].flush();
    }
    } catch (Exception ex) {
    frS.setDis(0);
    frS.output.setText(frS.output.getText() + "Problem!!!! to chat. " + ex + "\n");
    //frS.t2.stop();
    return;
    }
    frS.repaint();
    
    } catch (Exception ex) {
    frS.setDis(0);
    frS.output.setText(frS.output.getText() + "Problem!!!! to chat. " + ex + "\n");
    frS.t1.stop();
    return;
    }
    i++;
    if (i >= cancle) {
    i = 0;
    }
    }
    }
    
    public void lisening() {
    int i = 0;
    while (i < cancle) {
    //ObjectInputStream read = is[i];
    cr[i] = new ChatRunner(is[i], frS);
    new Thread(cr[i]).start();
    i++;
    }
    }*/
    public void openFile() {
        
        try {
            fw = new FileWriter(new File("D://Exam Controller//Exam Result.doc"), true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error to creat Student result file:(" + ex + ")");
        }
        
    }
    
    public void closeMyAnswer() {
        if (fw != null) {
            try {
                fw.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex);
            }
        }
    }
    
    public void openFloat() {
        try {
            Scanner f = new Scanner(new File("D://Exam Controller//Exam Result.doc"));
            int i = 0;
            String sl = "";
            while (f.hasNext()) {
                try {
                    if ("Marks:".equals(sl)) {
                        marks[i] = f.nextFloat();
                        i++;
                    } else {
                        sl = f.next();
                        continue;
                    }
                } catch (Exception ex) {
                    sl = f.next();
                    continue;
                }
                jprogressCounter++;
                frS.prog.setValue(jprogressCounter);
            }
            f.close();
        } catch (Exception ex) {
            System.out.println("Error to open Student result file:(" + ex + ")");
        }
    }
    
    public void openLine() {
        try {
            Scanner l = new Scanner(new File("D://Exam Controller//Exam Result.doc"));
            resultCounter = 0;
            while (l.hasNext()) {
                stuResult[resultCounter] = l.nextLine();
                resultCounter++;
                jprogressCounter++;
                frS.prog.setValue(jprogressCounter);
            }
            l.close();
        } catch (Exception ex) {
            System.out.println("Error to open Student result file:(" + ex + ")");
        }
    }
    
    public void marksSort() {
        for (int k = 0; k < resultCounter - 1; k++) {
            int ptr = 0;
            while (ptr < resultCounter - 1 - k) {
                if (marks[ptr] < marks[ptr + 1]) {
                    float t = marks[ptr];
                    marks[ptr] = marks[ptr + 1];
                    marks[ptr + 1] = t;
                }
                ptr++;
                jprogressCounter++;
                frS.prog.setValue(jprogressCounter);
            }
        }
    }
    
    public void openNewFile() {
        try {
            Result = new Formatter(new File("D://Exam Controller//Exam Result.doc"));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
        }
    }
    
    public void closeNewFile() {
        if (Result != null) {
            Result.close();
        }
    }
    
    public void checkAndWrite() {
        openNewFile();
        counter = 1;
        for (int i = 0; i < resultCounter; i++) {
            for (int j = 0; j < resultCounter; j++) {
                if (stuResult[j].endsWith("" + marks[i])) {
                    try {
                        Result.format("%s\n", stuResult[j]);
                        stuResult[j] = "OK";
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error: " + ex);
                    }
                }
            }
            counter++;
            jprogressCounter++;
            frS.prog.setValue(jprogressCounter);
        }
        closeNewFile();
    }
    
    public void ListManeger() {
        String friName[] = new String[getStuCounter()];
        int i = 0;
        for (i = 0; i < getStuCounter(); i++) {
            friName[i] = stu[i];
        }
        
        frS.controller.stuList.setListData(friName);
        frS.controller.conStu.setText("Total Connected Students: " + getStuCounter());
        
        if (stuCounter <= 0) {
            String a[] = new String[0];
            frS.controller.stuList.setListData(a);
        }
    }
}
