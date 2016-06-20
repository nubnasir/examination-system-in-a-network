/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package networking;

import java.io.File;
import java.util.Formatter;
import javax.swing.JOptionPane;

/**
 *
 * @author TOSHIBA
 */
public class SavingFile {

    public QuestionCreator quesCreat;
    Formatter ques;
    Formatter ans;
    Formatter formalQues;

    public SavingFile(QuestionCreator q) {
        quesCreat = q;
    }

    public void openFile() {
        try {
            ques = new Formatter(new File("D://Exam Controller/" + quesCreat.getQuestionName()) + ".doc");
            ans = new Formatter(new File("D://Exam Controller/" + quesCreat.getAnswerName()) + ".doc");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
        }
        try {
            formalQues = new Formatter(new File("D://Exam Controller/Formal Question/" + "Formal_" + quesCreat.getQuestionName()) + ".doc");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
        }
    }

    public void writting() {
        int i = 0;
        ques.format("%s\nTotal Marks: %s\n", quesCreat.getExamName(), quesCreat.getTotalMarks());
        formalQues.format("%s\nTotal Marks: %s\n", quesCreat.getExamName(), quesCreat.getTotalMarks());
        while (i < quesCreat.getCount()) {

            ques.format("%s\n----)\n%s\n%s\n%s\n%s\n%s\n%s\n", quesCreat.Question[i], quesCreat.option1[i], quesCreat.option2[i], quesCreat.option3[i], quesCreat.option4[i], quesCreat.image[i], quesCreat.fontType[i]);
            formalQues.format("%s\na) %s\nb) %s\nc) %s\nd) %s\n\n", quesCreat.Question[i], quesCreat.option1[i], quesCreat.option2[i], quesCreat.option3[i], quesCreat.option4[i]);
            ans.format("%s\n", quesCreat.answer[i]);
            quesCreat.progress.setValue(i);
            i++;
        }
        quesCreat.progress.setMaximum(100);
        quesCreat.progress.setValue(quesCreat.progress.getMaximum());
    }

    public void closeFile() {
        if (ques != null) {
            ques.close();
        }
        if (ans != null) {
            ans.close();
        }
        if (formalQues != null) {
            formalQues.close();
        }
        quesCreat.progress.setString("Check D:/Exam Conlroller Folder");

    }
}
