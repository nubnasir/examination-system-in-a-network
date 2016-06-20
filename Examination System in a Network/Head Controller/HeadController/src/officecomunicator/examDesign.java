/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package officecomunicator;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

/**
 *
 * @author TOSHIBA
 */
public class examDesign implements Runnable {

    public mgs exam;
    public int serverMsg = 0;

    public int getServerMsg() {
        return serverMsg;
    }

    public void setServerMsg(int serverMsg) {
        this.serverMsg = serverMsg;
    }

    public examDesign(mgs e) {
        exam = e;
    }

    @Override
    public void run() {
        int i = 0;
        while (serverMsg <= 3) {
            if (serverMsg == 3) {
                exam.ms.setBackground(Color.WHITE);
                exam.message.setFont(new Font("" + exam.message.getFont(), Font.BOLD, 14));
                exam.message.setText("1 New Message");
                setServerMsg(4);
                break;
            } else if (serverMsg == 2) {
                exam.ms.setBackground(Color.GREEN);
                exam.message.setFont(new Font("" + exam.message.getFont(), Font.BOLD, 18));
                exam.message.setText("MESSAGE");
                serverMsg++;
            } else if (serverMsg == 1) {
                exam.ms.setBackground(Color.BLUE);
                exam.message.setFont(new Font("" + exam.message.getFont(), Font.BOLD, 18));
                exam.message.setText("NEW");
                serverMsg++;
                playAudio();
            } else if (serverMsg == 0) {
                exam.ms.setBackground(Color.red);
                exam.message.setFont(new Font("" + exam.message.getFont(), Font.BOLD, 18));
                exam.message.setText("1");
                serverMsg++;
            }

            exam.repaint();
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
            }
        }
    }

    public void playAudio() {
        try {
            Sequence sequence = MidiSystem.getSequence(getClass().getResource("cse.mid"));
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.setSequence(sequence);

            sequencer.start();
            Thread.sleep(1000);
            sequencer.stop();
        } catch (Exception ex) {
        }
    }
}
