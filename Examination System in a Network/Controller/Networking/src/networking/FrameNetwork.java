/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrameNetwork.java
 *
 * Created on Nov 14, 2012, 9:29:03 PM
 */
package networking;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.InetAddress;
import java.util.Date;
import java.util.Formatter;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

/**
 *
 * @author TOSHIBA
 */
public class FrameNetwork extends javax.swing.JFrame {

    ThreadServer ts;
    ThreadSocket tsp;
    Thread t1;
    Thread t2;
    Thread a1;
    int take = 0;
    int dis = 0;
    public boolean changeTime = false;
    public Scanner time;
    public DigitalWatch dw;
    Formatter Doc;
    Scanner inp;
    public int questionCheck = 0;
    public int answerCheck = 0;
    Formatter icon;
    public int closingFrame = 0;
    HTMLEditorKit text_panel_html_kit;
    StatusRecoder sR = new StatusRecoder();
    Controller controller;

    public String getU_name() {
        return U_name;
    }

    public void setU_name(String U_name) {
        this.U_name = U_name;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
    String roomId;
    String U_name;

    public int getConnectionAgain() {
        return connectionAgain;
    }

    public void setConnectionAgain(int connectionAgain) {
        this.connectionAgain = connectionAgain;
    }
    public int connectionAgain = 0;

    public String getTempQfile() {
        return tempQfile;
    }

    public void setTempQfile(String tempQfile) {
        this.tempQfile = tempQfile;
    }
    public String tempQfile;

    public String getIconFilePath() {
        return iconFilePath;
    }

    public void setIconFilePath(String iconFilePath) {
        this.iconFilePath = iconFilePath;
    }
    public String iconFilePath;

    public int getStratAcc() {
        return stratAcc;
    }

    public void setStratAcc(int stratAcc) {
        this.stratAcc = stratAcc;
    }
    public int stratAcc = 0;

    public int getEndC() {
        return endC;
    }

    public void setEndC(int endC) {
        this.endC = endC;
    }
    public int endC = 0;

    public String getTempFileName() {
        return tempFileName;
    }

    public void setTempFileName(String tempFileName) {
        this.tempFileName = tempFileName;
    }
    public String tempFileName;

    public String getAnswerFileName() {
        return answerFileName;
    }

    public void setAnswerFileName(String answerFileName) {
        this.answerFileName = answerFileName;
    }

    public String getQuestionFileName() {
        return questionFileName;
    }

    public void setQuestionFileName(String questionFileName) {
        this.questionFileName = questionFileName;
    }
    public String answerFileName;
    public String questionFileName;

    public int getExamine() {
        return examine;
    }

    public void setExamine(int examine) {
        this.examine = examine;
    }
    public int examine = 0;

    public int getEndExam() {
        return endExam;
    }

    public void setEndExam(int endExam) {
        this.endExam = endExam;
    }
    public int endExam = 0;

    public int getHeadC() {
        return headC;
    }

    public void setHeadC(int headC) {
        this.headC = headC;
    }
    public int headC = 0;

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public String getAnswerFilePath() {
        return answerFilePath;
    }

    public void setAnswerFilePath(String answerFilePath) {
        this.answerFilePath = answerFilePath;
    }

    public float getNegMark() {
        return negMark;
    }

    public void setNegMark(float negMark) {
        this.negMark = negMark;
    }

    public String getPasswordRead() {
        return passwordRead;
    }

    public void setPasswordRead(String passwordRead) {
        this.passwordRead = passwordRead;
    }

    public String getQuestionFilePath() {
        return questionFilePath;
    }

    public void setQuestionFilePath(String questionFilePath) {
        this.questionFilePath = questionFilePath;
    }

    public String getSpon() {
        return spon;
    }

    public void setSpon(String spon) {
        this.spon = spon;
    }
    public String spon;
    public String Time;
    public float negMark = 0;
    public String questionFilePath;
    public String answerFilePath;
    public String passwordRead;

    public int getPrimaryStep() {
        return primaryStep;
    }

    public void setPrimaryStep(int primaryStep) {
        this.primaryStep = primaryStep;
    }
    public int primaryStep = 0;

    public int getExpel() {
        return expel;
    }

    public void setExpel(int expel) {
        this.expel = expel;
    }
    public int expel = 0;

    public void increaseExpel() {
        expel++;
    }

    public boolean getButtonTimer() {
        return buttonTimer;
    }

    public void setButtonTimer(boolean buttonTimer) {
        this.buttonTimer = buttonTimer;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public int getTimerHandel() {
        return timerHandel;
    }

    public void setTimerHandel(int timerHandel) {
        this.timerHandel = timerHandel;
    }
    public int timer = 0;
    public int timerHandel = 0;
    public boolean buttonTimer = false;
    public int minFile = 10;
    public int secFile = 0;
    public int hourFile = 0;

    public int getHourFile() {
        return hourFile;
    }

    public void setHourFile(int hourFile) {
        this.hourFile = hourFile;
    }

    public int getMinFile() {
        return minFile;
    }

    public void setMinFile(int minFile) {
        this.minFile = minFile;
    }

    public int getSecFile() {
        return secFile;
    }

    public void setSecFile(int secFile) {
        this.secFile = secFile;
    }

    public int getDis() {
        return dis;
    }

    public void setDis(int dis) {
        this.dis = dis;
    }

    /** Creates new form FrameNetwork */
    public FrameNetwork() {
        initComponents();
        makingDir();
        setLocationRelativeTo(null);
        openIconFile();
        text_panel_html_kit = new HTMLEditorKit();
        output.setEditorKit(text_panel_html_kit);
        output.setDocument(new HTMLDocument());
        //openFile();
        //setTime();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        message = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pTitle = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        pTime = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        pNegative = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        pathQuestion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        pathAnswer = new javax.swing.JTextField();
        choose1 = new javax.swing.JButton();
        choose2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        choose3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        iconArea = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        headMessage = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        timeChange = new javax.swing.JButton();
        jProgressBar = new javax.swing.JProgressBar();
        jPanel3 = new javax.swing.JPanel();
        seconds = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        minute = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        hour = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        seconds1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        minute1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        hour1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        document = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        accept = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        disconnect = new javax.swing.JButton();
        hcConnect = new javax.swing.JButton();
        stopAcc = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        prog = new javax.swing.JProgressBar();
        jprog = new javax.swing.JProgressBar();
        stuNumber = new javax.swing.JLabel();
        jrec = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        output = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Controller"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        message.setFont(new java.awt.Font("Times New Roman", 0, 12));
        message.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "To Examinee", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 9))); // NOI18N
        message.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(153, 153, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Primary Step", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        jPanel5.setForeground(new java.awt.Color(51, 153, 0));

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Must be filled up"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12));
        jLabel1.setText("Title/Sponsor: "); // NOI18N

        pTitle.setFont(new java.awt.Font("Times New Roman", 0, 12));
        pTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pTitleActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12));
        jLabel2.setText("Time(Hour(00) Min(00) Sec(00)):"); // NOI18N

        pTime.setFont(new java.awt.Font("Times New Roman", 0, 12));
        pTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pTimeActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12));
        jLabel8.setText("Negative Mark(per incorrect answer):"); // NOI18N

        pNegative.setFont(new java.awt.Font("Times New Roman", 0, 12));
        pNegative.setText("0"); // NOI18N
        pNegative.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pNegativeActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(153, 153, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Files", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 12));
        jLabel10.setText("Question File Path(.doc):"); // NOI18N

        pathQuestion.setFont(new java.awt.Font("Times New Roman", 0, 11));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 12));
        jLabel12.setText("Answer File Path(.doc):"); // NOI18N

        pathAnswer.setFont(new java.awt.Font("Times New Roman", 0, 11));

        choose1.setText("...."); // NOI18N
        choose1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choose1ActionPerformed(evt);
            }
        });

        choose2.setText("...."); // NOI18N
        choose2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choose2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12));
        jLabel5.setText("Image/Icon(Path):"); // NOI18N

        choose3.setText("...."); // NOI18N
        choose3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choose3ActionPerformed(evt);
            }
        });

        iconArea.setColumns(20);
        iconArea.setFont(new java.awt.Font("Times New Roman", 0, 12));
        iconArea.setRows(5);
        jScrollPane2.setViewportView(iconArea);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                    .addComponent(pathQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                    .addComponent(pathAnswer, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
                                .addGap(6, 6, 6))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(choose1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE)
                                .addComponent(choose2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE))
                            .addComponent(choose3, 0, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(choose1)
                    .addComponent(pathQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(choose2)
                    .addComponent(pathAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(choose3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 12));
        jLabel14.setText("Passward for Student:"); // NOI18N

        password.setFont(new java.awt.Font("Times New Roman", 0, 12));

        jButton2.setText("OK"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 12));
        jLabel9.setText("After filling up all information press"); // NOI18N

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 12));
        jLabel15.setText("\"OK\" Button"); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pTitle))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pTime))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pNegative))
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(password, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pNegative, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );

        headMessage.setFont(new java.awt.Font("Times New Roman", 0, 12));
        headMessage.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "To Head Controller", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 9))); // NOI18N
        headMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                headMessageActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controller Option", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        jPanel4.setBackground(new java.awt.Color(153, 153, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Time", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        timeChange.setFont(new java.awt.Font("Times New Roman", 0, 12));
        timeChange.setText("Time Remains"); // NOI18N
        timeChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeChangeActionPerformed(evt);
            }
        });

        jProgressBar.setBackground(new java.awt.Color(204, 204, 255));
        jProgressBar.setForeground(new java.awt.Color(0, 51, 255));

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        seconds.setFont(new java.awt.Font("Tahoma", 0, 18));
        seconds.setText("00"); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel4.setText(":"); // NOI18N

        minute.setFont(new java.awt.Font("Tahoma", 0, 18));
        minute.setText("00"); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel6.setText(":"); // NOI18N

        hour.setFont(new java.awt.Font("Tahoma", 0, 18));
        hour.setText("00"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(hour)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(minute)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seconds)
                .addGap(22, 22, 22))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(seconds, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(minute, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(hour, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(timeChange, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(timeChange, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(153, 153, 255));

        seconds1.setFont(new java.awt.Font("Tahoma", 0, 12));
        seconds1.setForeground(new java.awt.Color(51, 102, 255));
        seconds1.setText("00"); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel11.setForeground(new java.awt.Color(51, 102, 255));
        jLabel11.setText(":"); // NOI18N

        minute1.setFont(new java.awt.Font("Tahoma", 0, 12));
        minute1.setForeground(new java.awt.Color(51, 102, 255));
        minute1.setText("00"); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel13.setForeground(new java.awt.Color(51, 102, 255));
        jLabel13.setText(":"); // NOI18N

        hour1.setFont(new java.awt.Font("Tahoma", 0, 12));
        hour1.setForeground(new java.awt.Color(51, 102, 255));
        hour1.setText("00"); // NOI18N

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Exam Time:"); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(hour1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(minute1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seconds1))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel7)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seconds1, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                    .addComponent(minute1, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                    .addComponent(jLabel13)
                    .addComponent(hour1, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(102, 153, 255));

        document.setFont(new java.awt.Font("Times New Roman", 0, 12));
        document.setText("Make a Document of Status"); // NOI18N
        document.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                documentActionPerformed(evt);
            }
        });

        cancel.setFont(new java.awt.Font("Times New Roman", 0, 12));
        cancel.setText("Expel"); // NOI18N
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        accept.setFont(new java.awt.Font("Times New Roman", 0, 12));
        accept.setText("Let's Start"); // NOI18N
        accept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 12));
        jButton1.setText("Start Exam"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        disconnect.setFont(new java.awt.Font("Times New Roman", 0, 12));
        disconnect.setText("Disconnect"); // NOI18N
        disconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectActionPerformed(evt);
            }
        });

        hcConnect.setFont(new java.awt.Font("Times New Roman", 0, 12));
        hcConnect.setText("HC Connect"); // NOI18N
        hcConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hcConnectActionPerformed(evt);
            }
        });

        stopAcc.setFont(new java.awt.Font("Times New Roman", 0, 12));
        stopAcc.setText("End Exam"); // NOI18N
        stopAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopAccActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 12));
        jButton3.setText("View Result"); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 12));
        jButton4.setText("Close all Students Frame"); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(stopAcc, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(accept, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hcConnect, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                    .addComponent(document, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(cancel, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(disconnect, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(stopAcc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accept)
                    .addComponent(hcConnect))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel)
                    .addComponent(disconnect))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(document)
                .addContainerGap())
        );

        prog.setFont(new java.awt.Font("Times New Roman", 0, 12));
        prog.setStringPainted(true);

        jprog.setFont(new java.awt.Font("Times New Roman", 0, 12));
        jprog.setStringPainted(true);

        stuNumber.setFont(new java.awt.Font("Times New Roman", 1, 12));
        stuNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jrec.setFont(new java.awt.Font("Times New Roman", 0, 12));
        jrec.setRequestFocusEnabled(false);
        jrec.setStringPainted(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jrec, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stuNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prog, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                    .addComponent(jprog, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(stuNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jrec, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jprog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        output.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Status", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        output.setContentType("text/html"); // NOI18N
        output.setEditable(false);
        output.setFont(new java.awt.Font("Times New Roman", 0, 6));
        jScrollPane1.setViewportView(output);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(headMessage)
                    .addComponent(message)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(headMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jMenu1.setText("File"); // NOI18N

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/networking/sortR.PNG"))); // NOI18N
        jMenuItem10.setText("Sort Result"); // NOI18N
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem10);

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/networking/Nq.PNG"))); // NOI18N
        jMenuItem11.setText("N.doc Question Creator"); // NOI18N
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem11);

        jMenuItem1.setText("Exit"); // NOI18N
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Tools"); // NOI18N
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/networking/start.png"))); // NOI18N
        jMenuItem8.setText("Start Exam"); // NOI18N
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/networking/letsStart.png"))); // NOI18N
        jMenuItem2.setText("Let's Start"); // NOI18N
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/networking/endExam.PNG"))); // NOI18N
        jMenuItem6.setText("End Exam"); // NOI18N
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/networking/expel.PNG"))); // NOI18N
        jMenuItem7.setText("Expel"); // NOI18N
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/networking/ex.png"))); // NOI18N
        jMenuItem3.setText("Extra Controls");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/networking/connect_1.PNG"))); // NOI18N
        jMenuItem4.setText("Disconnect"); // NOI18N
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/networking/closeFrame.PNG"))); // NOI18N
        jMenuItem13.setText("Close All Students Frame"); // NOI18N
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem13);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/networking/doc.PNG"))); // NOI18N
        jMenuItem9.setText("Make a Document of status"); // NOI18N
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem9);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Head Controller");

        jMenuItem14.setText("Connect");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem14);

        jMenuBar1.add(jMenu4);

        jMenu3.setText("Help"); // NOI18N

        jMenuItem5.setText("Cradits"); // NOI18N
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem12.setText("Hints"); // NOI18N
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem12);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void acceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptActionPerformed
        // TODO add your handling code here:

        if (primaryStep == 1) {
            if (getStratAcc() == 0) {
                setStratAcc(1);
                dis = 1;
                ts = new ThreadServer(this);
                t1 = new Thread(ts);
                t1.start();
                take = 1;
            } else {
                JOptionPane.showMessageDialog(null, "Accepting connection is already running.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Fill up Primary step.");
        }
    }//GEN-LAST:event_acceptActionPerformed

    private void messageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageActionPerformed
        // TODO add your handling code here:
        if (take == 1) {
            try {
                ts.setMsg("CCC" + message.getText());
                ts.writer();
                //output.setText(output.getText() + "Controller: " + message.getText() + "\n");

                designer("Controller: " + message.getText(), "Fuchsia");

            } catch (Exception ex) {
                designer("Problem!!!! in chatting()Frame. unable to chat with the server " + ex, "red");
            }
            message.setText("");
        } else if (take == 2) {

            try {
                tsp.os.writeObject(message.getText());
                output.setText(output.getText() + InetAddress.getLocalHost() + ">>> " + message.getText() + "\n");
            } catch (Exception ex) {
                output.setText(output.getText() + "Problem!!!! in chatting()Frame. unable to chat with the server" + ex + "\n");
            }
            message.setText("");
        }
    }//GEN-LAST:event_messageActionPerformed

    private void disconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectActionPerformed
        // TODO add your handling code here:
        if (primaryStep == 1) {
            if (dis == 1) {
                ts.terminateConnection();
                t1.stop();
                designer("Disconnected.", "blue");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Fill up Primary step.");
        }
    }//GEN-LAST:event_disconnectActionPerformed

    private void hcConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hcConnectActionPerformed
        // TODO add your handling code here:
        if (primaryStep >= 0) {
            if (getConnectionAgain() == 0) {
                dis = 1;
                take = 2;
                tsp = new ThreadSocket(this);
                t2 = new Thread(tsp);
                t2.start();
            } else {
                JOptionPane.showMessageDialog(null, "Already Connected to Head Controller...");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Fill up Primary step.");
        }
    }//GEN-LAST:event_hcConnectActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        acceptActionPerformed(evt);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        disconnectActionPerformed(evt);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        HelpA hp = new HelpA();
        hp.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void timeChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeChangeActionPerformed
        // TODO add your handling code here:
        if (changeTime) {
            changeTime = false;
            timeChange.setText("Time Remains");
        } else {
            changeTime = true;
            timeChange.setText("    Total Time    ");
        }
    }//GEN-LAST:event_timeChangeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (primaryStep == 1) {
            if (getTimerHandel() == 0) {
                ts.setMsg("start exam");
                ts.writer();
                dw = new DigitalWatch(this);
                new Thread(dw).start();
                setTimerHandel(1);
                designer("Exam Started " + new Date(), "blue");
            } else {
                JOptionPane.showMessageDialog(null, "Exam already started.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Fill up Primary step.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
        if (primaryStep == 1) {
            if (endC == 0) {
                if (getExamine() == 1) {
                    try {
                        String Roll = JOptionPane.showInputDialog(null, "Enter the Student Roll no.", "Expel a Student", NORMAL);
                        ts.setMsg("Stop" + Roll);
                        ts.writer();
                    } catch (Exception ex) {
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "There is no examinee.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Exam is finished.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Fill up Primary step.");
        }
    }//GEN-LAST:event_cancelActionPerformed

    private void stopAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopAccActionPerformed
        // TODO add your handling code here:
        if (primaryStep == 1) {
            if (getExamine() == 1) {
                if (getEndC() == 0) {
                    if (JOptionPane.showConfirmDialog(null, "Do you really want to End Exam?") < 1) {
                        //ts.setCancle(5);
                        setButtonTimer(true);
                        prog.setMaximum(ts.getCancle() + ts.getCancle() + ts.getCancle() - 2);
                        prog.setValue(0);
                        jrec.setString("Receiving Students Answer files...");
                        jrec.setMaximum(ts.getCancle());
                        jrec.setValue(0);
                        setEndExam(1);
                        ts.setMsg("Finish");
                        ts.writer();
                        JOptionPane.showMessageDialog(null, "Exam Finished.\nWait and Do not press OK button\nuntil seding bar is completed.");

                        jprog.setMaximum(100);
                        jprog.setValue(100);
                        ts.closeNewFile();
                        ts.openFloat();
                        ts.marksSort();
                        ts.openLine();
                        ts.checkAndWrite();
                        prog.setValue(prog.getMaximum());
                        setEndC(1);
                        //output.setText(output.getText() + "Exam Ended." + new Date() + "\n");
                        designer("Exam Ended." + new Date(), "blue");
                        DetailResult dr = new DetailResult(this);
                        dr.setVisible(true);
                        File af = new File("D://Exam Controller/temp" + getAnswerFileName());
                        af.delete();
                        File qf = new File("D://Exam Controller/temp" + getQuestionFileName());
                        qf.delete();
                        File icf = new File("D://Exam Controller/Icon File.doc");
                        icf.delete();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Exam is already end.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Exam is not started yet, thus,\nyou can not end exam.\n\tThank you.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Fill up Primary step.");
        }
    }//GEN-LAST:event_stopAccActionPerformed

    private void documentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_documentActionPerformed
        // TODO add your handling code here:
        if (primaryStep == 1) {
            if (getEndExam() == 1) {
                docFile();
                Doc.format("Total Student %d\n", ts.getCancle());
                Doc.format("Expeled: %d Student\n", getExpel());
                Doc.format("---------------------------------------------------------------\n");
                Doc.format("Result\n");
                Doc.format("---------------------------------------------------------------\n");
                resultFile();
                int i = 1;
                while (inp.hasNext()) {
                    Doc.format("%d. %s\n", i, inp.nextLine());
                    Doc.format("---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- \n");
                    i++;
                }
                closeinp();
                Doc.format("---------------------------------------------------------------\n");
                Doc.format("---------------------------------------------------------------\n");

                Doc.format("---------------------------------------------------------------\n");
                Doc.format("Status....\n %s", sR.recode.getText());
                Doc.format("---------------------------------------------------------------\n");
                Doc.format("Exam Controller Signature:\n");
                Doc.format("\n\n%s\n\n\n\n", new Date());
                //Doc.format("---------------------------------------------------------------\n");
                //Doc.format("---------------------------------------------------------------\n");
                //Doc.format("Created by Md. Nasir Uddin Bhuiyan\nJagannath University\nDepartment of CSE\n2nd Batch");
                closeDoc();
                designer("Document is created in this D:/Exam Controller path.", "blue");
                JOptionPane.showMessageDialog(null, "Document is created in this D:/Exam Controller path.\nThank you.");
            } else {
                JOptionPane.showMessageDialog(null, "After finishing the exam you can make adocument\nPress \"End Exam\" Button to finish the exam.\nThank you.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Fill up Primary step.");
        }
    }//GEN-LAST:event_documentActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        stopAccActionPerformed(evt);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        cancelActionPerformed(evt);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        jButton1ActionPerformed(evt);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        documentActionPerformed(evt);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void pTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pTitleActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (getPrimaryStep() == 0) {
            if (("".equals(pTitle.getText()) || pTitle.getText() == null) || ("".equals(pTime.getText()) || pTime.getText() == null) || ("".equals(pNegative.getText()) || pNegative.getText() == null) || ("".equals(pathQuestion.getText()) || pathQuestion.getText() == null) || ("".equals(pathAnswer.getText()) || pathAnswer.getText() == null) || ("".equals(password.getText()) || password.getText() == null)) {
                JOptionPane.showMessageDialog(null, "Please fill up all the information");
            } else {
                output.setText("");
                setSpon(pTitle.getText());
                setTime(pTime.getText());
                setNegMark(Float.parseFloat(pNegative.getText()));
                checkFlie(pathQuestion.getText(), pathAnswer.getText());
                setPasswordRead(password.getText());

                if (questionCheck == 1 && answerCheck == 1) {
                    creatTimeFile();
                    openFile();
                    setTime();
                    //openTempraryFile();
                    icon.format("%s", iconArea.getText());
                    closeIconFile();
                    //output.setText(output.getText() + "Primary Step details:\nTitle: " + pTitle.getText() + "\nTime: " + pTime.getText() + "\nNegative mark(per incorrect answer): " + pNegative.getText() + "\nQuestion file path: " + pathQuestion.getText() + "\nAnswer file path: " + pathAnswer.getText() + "\nIcon Path:" + iconArea.getText() + "\nPassword: " + password.getText() + "\n");

                    designer("Primary Step details: Title: " + pTitle.getText(), "Olive");

                    designer("Time: " + pTime.getText(), "Olive");

                    designer("Negative mark(per incorrect answer): " + pNegative.getText(), "Olive");

                    designer("Question file path: " + pathQuestion.getText(), "Olive");

                    designer("Answer file path: " + pathAnswer.getText(), "Olive");

                    designer("Icon Path:" + iconArea.getText(), "Olive");

                    designer("Password: " + password.getText(), "Olive");

                    JOptionPane.showMessageDialog(null, "Primary step completed\nPress Let's Start button to star exam.\nThank you.");
                    setPrimaryStep(1);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Primary step is already completed.");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void pNegativeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pNegativeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pNegativeActionPerformed

    private void headMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_headMessageActionPerformed
        // TODO add your handling code here:
        if (getConnectionAgain() == 1) {
            try {
                tsp.os.writeObject("SSS" + getU_name() + " " + getRoomId() + ": " + headMessage.getText());
                designer("User: " + headMessage.getText(), "Black");
            } catch (Exception ex) {
                designer("Problem!!!! in chatting()Frame. unable to chat with the server" + ex + "\n", "RED");
            }
            headMessage.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Head Controller is not connected.");
            headMessage.setText("");
        }
    }//GEN-LAST:event_headMessageActionPerformed

    private void choose1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choose1ActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            int result = fc.showOpenDialog(this);
            if (result == JFileChooser.CANCEL_OPTION) {
            }
            File fileName = fc.getSelectedFile();
            if (fileName.exists()) {
                pathQuestion.setText("" + fileName.getPath());
                setQuestionFileName(fileName.getName());
            }
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_choose1ActionPerformed

    private void choose2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choose2ActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            int result = fc.showOpenDialog(this);
            if (result == JFileChooser.CANCEL_OPTION) {
            }
            File fileName = fc.getSelectedFile();
            if (fileName.exists()) {
                pathAnswer.setText("" + fileName.getPath());
                setAnswerFileName(fileName.getName());
                setTempFileName(fileName.getName());
            }
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_choose2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (primaryStep == 1) {
            if (getExamine() == 1) {
                if (getEndC() == 1) {
                    if (closingFrame == 0) {
                        if (JOptionPane.showConfirmDialog(null, "Are you sure...?\nClose all studens frame") < 1) {
                            ts.setMsg("Close");
                            ts.writer();
                            closingFrame = 1;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "All Students Frame is already closed.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "First end the exam.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Exam is not started yet, thus,\nyou can not end exam.\n\tThank you.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Fill up Primary step.");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (primaryStep == 1) {
            if (getExamine() == 1) {
                if (getEndC() == 1) {
                    DetailResult dr = new DetailResult(this);
                    dr.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "First end the exam.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Exam is not started yet, thus,\nThere is no result.\n\t\tThank you.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Fill up Primary step.");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void choose3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choose3ActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            int result = fc.showOpenDialog(this);
            if (result == JFileChooser.CANCEL_OPTION) {
            }
            File fileName = fc.getSelectedFile();
            if (fileName.exists()) {
                iconArea.setText(iconArea.getText() + fileName.getPath() + "\n");
            }
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_choose3ActionPerformed

    private void pTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pTimeActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        Sorting s = new Sorting();
        s.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
        QuestionCreator q = new QuestionCreator();
        q.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
        Startup s = new Startup();
        s.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        jButton4ActionPerformed(evt);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
        hcConnectActionPerformed(evt);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(null, "Do you want to exit?") < 1) {
            System.exit(0);
        } else {
        }
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        if (primaryStep == 1 && getTimerHandel() == 1) {
            ts.setStuCounter(0);
            ts.stu = new String[ts.getCancle()];
            controller = new Controller(ts);
            ts.setMsg("Info");
            ts.writer();
            controller.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Please First Start the exam.");
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    public void openFile() {
        try {
            time = new Scanner(new File("D://Exam Controller/time.doc"));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error to open time file");
        }

    }

    public void setTime() {
        if (time.hasNextInt()) {
            hourFile = time.nextInt();
            minFile = time.nextInt();
            secFile = time.nextInt();
            if (hourFile < 10) {
                hour1.setText("0" + hourFile);
            } else {
                hour1.setText("" + hourFile);
            }

            if (minFile < 10) {
                minute1.setText("0" + minFile);
            } else {
                minute1.setText("" + minFile);
            }

            if (secFile < 10) {
                seconds1.setText("0" + secFile);
            } else {
                seconds1.setText("" + secFile);
            }
        }

        if (time.hasNext() == false) {
            time.close();
        }
    }

    public void creatTimeFile() {
        try {
            Formatter t = new Formatter(new File("D://Exam Controller/time.doc"));
            t.format("%s", getTime());
            if (t != null) {
                t.close();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Problem to creat time file.");
        }
    }

    public void docFile() {
        try {
            Doc = new Formatter("D://Exam Controller/Exam Status.doc");
        } catch (Exception ex) {
            System.out.println("Error to creat Student answer file:(" + ex + ")");
        }
    }

    public void checkFlie(String q, String a) {

        try {
            File que = new File(q);
            if (que.exists()) {
                setQuestionFilePath(pathQuestion.getText());
                setQuestionFileName(que.getName());
                setTempQfile(que.getName());
                questionCheck = 1;
            } else {
                JOptionPane.showMessageDialog(null, "Wrong path or file name: " + q);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Wrong path or file name: " + q);
        }

        try {
            File an = new File(a);
            if (an.exists()) {
                //setAnswerFilePath(pathAnswer.getText());
                setAnswerFilePath(pathAnswer.getText());
                setAnswerFileName(an.getName());
                setTempFileName(an.getName());
                answerCheck = 1;
            } else {
                JOptionPane.showMessageDialog(null, "Wrong path or file name: " + a);
            }
        } catch (Exception ex) {
            setAnswerFilePath("");
            JOptionPane.showMessageDialog(null, "Wrong path or file name: " + a);
        }

    }

    public void closeDoc() {
        if (Doc != null) {
            Doc.close();
        }
    }

    public void resultFile() {
        try {
            inp = new Scanner(new File("D://Exam Controller/Exam Result.doc"));
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error to open Exam Result file.");
        }
    }

    public void closeinp() {
        if (inp != null) {
            inp.close();
        }
    }

    /*public void openTempraryFile() {
    String s = "temp" + getTempFileName();
    String q = "temp" + getTempQfile();
    try {
    Formatter temp = new Formatter(new File("E://" + s));
    temp.close();
    Formatter tempQue = new Formatter(new File("E://" + q));
    tempQue.close();
    } catch (Exception ex) {
    JOptionPane.showMessageDialog(null, "Error to creat Temporary file: " + ex);
    }
    }*/
    public void openIconFile() {
        try {
            icon = new Formatter(new File("D://Exam Controller/Icon File.doc"));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error to creat Icon File: " + ex);
        }
    }

    public void closeIconFile() {
        if (icon != null) {
            icon.close();
        }
    }

    public void designer(String line, String col) {
        try {
            text_panel_html_kit.insertHTML((HTMLDocument) output.getDocument(), output.getDocument().getLength(), "<font size=8 color=" + col + ">" + line + "</font><font size=8 color=" + col + ">" + "</font>", 0, 0, null);
            sR.recode.setText(sR.recode.getText() + line + "\n");
        } catch (Exception ex) {
        }
    }

    public void makingDir() {
        File mkc = new File("D://Exam Controller/");

        if (mkc.exists()) {
            if (JOptionPane.showConfirmDialog(null, "Do you want to overwrite D://Exam Controller file\nAll previous data will be lost.\nThank You.") < 1) {
                String[] s = mkc.list();
                try {
                    for (int i = 0; i < s.length; i++) {
                        File del = new File("D://Exam Controller/" + s[i]);
                        if ("Students answer file".equals(s[i])) {
                            String[] sa = del.list();
                            if (sa != null) {
                                for (int j = 0; j < sa.length; j++) {
                                    File dela = new File("D://Exam Controller/Students answer file/" + sa[j]);
                                    dela.delete();
                                }
                            }
                        } else {
                            del.delete();
                        }
                        if ("Formal Question".equals(s[i])) {
                            String[] sa = del.list();
                            if (sa != null) {
                                for (int j = 0; j < sa.length; j++) {
                                    File dela = new File("D://Exam Controller/Formal Question/" + sa[j]);
                                    dela.delete();
                                }
                            }
                        } else {
                            del.delete();
                        }
                    }
                    mkc.mkdir();
                    File cfs = new File("D://Exam Controller/Students answer file");
                    File cff = new File("D://Exam Controller/Formal Question");
                    cfs.mkdir();
                    cff.mkdir();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error to Overwrite! " + ex);
                }
            }
        } else {
            mkc.mkdir();
            File cfs = new File("D://Exam Controller/Students answer file");
            File cff = new File("D://Exam Controller/Formal Question");
            cfs.mkdir();
            cff.mkdir();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameNetwork.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameNetwork.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameNetwork.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameNetwork.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new FrameNetwork().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accept;
    private javax.swing.JButton cancel;
    private javax.swing.JButton choose1;
    private javax.swing.JButton choose2;
    private javax.swing.JButton choose3;
    private javax.swing.JButton disconnect;
    private javax.swing.JButton document;
    private javax.swing.JButton hcConnect;
    public javax.swing.JTextField headMessage;
    public javax.swing.JLabel hour;
    public javax.swing.JLabel hour1;
    private javax.swing.JTextArea iconArea;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    public javax.swing.JProgressBar jProgressBar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JProgressBar jprog;
    public javax.swing.JProgressBar jrec;
    public javax.swing.JTextField message;
    public javax.swing.JLabel minute;
    public javax.swing.JLabel minute1;
    public javax.swing.JTextPane output;
    public javax.swing.JTextField pNegative;
    public javax.swing.JTextField pTime;
    public javax.swing.JTextField pTitle;
    public javax.swing.JTextField password;
    public javax.swing.JTextField pathAnswer;
    public javax.swing.JTextField pathQuestion;
    public javax.swing.JProgressBar prog;
    public javax.swing.JLabel seconds;
    public javax.swing.JLabel seconds1;
    private javax.swing.JButton stopAcc;
    public javax.swing.JLabel stuNumber;
    private javax.swing.JButton timeChange;
    // End of variables declaration//GEN-END:variables
}
