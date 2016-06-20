/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package networking;

import java.io.File;
import java.util.Formatter;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author TOSHIBA
 */
public class SortingEngine {

    public Sorting frS;
    float[] marks = new float[200];
    String stuResult[] = new String[200];
    public Formatter fin;

    public int getJprogressCounter() {
        return jprogressCounter;
    }

    public void setJprogressCounter(int jprogressCounter) {
        this.jprogressCounter = jprogressCounter;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }
    public int jprogressCounter = 0;
    public int len = 0;

    public SortingEngine(Sorting ss) {
        frS = ss;
    }

    public void openFloat() {
        try {
            Scanner f = new Scanner(new File("D://Exam Controller/Final Result.doc"));
            int i = 0;
            String sl = "";
            while (f.hasNext()) {
                try {
                    if ("Marks:".equals(sl)) {
                        marks[i] = f.nextFloat();
                        i++;
                        len++;
                    } else {
                        sl = f.next();
                        continue;
                    }
                } catch (Exception ex) {
                    sl = f.next();
                    continue;
                }
            }
            f.close();
        } catch (Exception ex) {
            System.out.println("Error to open Student result file:(" + ex + ")");
        }
    }

    public void openLine() {
        try {
            Scanner l = new Scanner(new File("D://Exam Controller/Final Result.doc"));
            int i = 0;
            while (l.hasNext()) {
                stuResult[i] = l.nextLine();
                i++;
                jprogressCounter++;
                frS.prog.setValue(jprogressCounter);
            }
            l.close();
        } catch (Exception ex) {
            System.out.println("Error to open Student result file:(" + ex + ")");
        }
    }

    public void marksSort() {
        for (int k = 0; k < getLen() - 1; k++) {
            int ptr = 0;
            while (ptr < getLen() - 1 - k) {
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

    public void checkAndWrite() {
        openFile();
        int counter = 1;
        for (int i = 0; i < getLen(); i++) {
            for (int j = 0; j < getLen(); j++) {
                if (stuResult[j].endsWith("" + marks[i])) {
                    try {
                        fin.format("%d. %s\n", counter, stuResult[j]);
                        stuResult[j] = "OK";
                        counter++;
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error: " + ex);
                    }
                }
            }
            jprogressCounter++;
            frS.prog.setValue(jprogressCounter);
        }
        closeFile();
    }

    public void openFile() {
        try {
            fin = new Formatter(new File("D://Exam Controller/Final Result.doc"));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
        }
    }

    public void closeFile() {
        if (fin != null) {
            fin.close();
        }
    }

    public void writeResult() {
        try {
            frS.details.setText("");
            Scanner l = new Scanner(new File("D://Exam Controller/Final Result.doc"));
            while (l.hasNext()) {
                frS.details.setText(frS.details.getText() + l.nextLine() + "\n");
                frS.details.setText(frS.details.getText() + "--------------------------------------------------------------------------------------\n");
                jprogressCounter++;
                frS.prog.setValue(jprogressCounter);
            }
            l.close();
        } catch (Exception ex) {
            System.out.println("Error to open Student result file:(" + ex + ")");
        }
    }

    public void FinalResult() {
        try {
            Scanner l = new Scanner(new File("D://Exam Controller/Final Result.doc"));
            int i = 0;
            while (l.hasNext()) {
                frS.Result.format("%s\n", l.nextLine());
                i++;
            }
            l.close();
        } catch (Exception ex) {
            System.out.println("Error to open Student result file:(" + ex + ")");
        }
    }
}
