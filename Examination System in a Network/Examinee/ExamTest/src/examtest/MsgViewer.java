/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MsgViewer.java
 *
 * Created on Dec 25, 2012, 10:57:33 PM
 */
package examtest;

/**
 *
 * @author TOSHIBA
 */
public class MsgViewer extends javax.swing.JFrame {

    /** Creates new form MsgViewer */
    public MsgViewer() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        col = new javax.swing.JPanel();
        msgLebel = new javax.swing.JLabel();
        picLebel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        col.setBackground(new java.awt.Color(204, 204, 255));

        msgLebel.setFont(new java.awt.Font("Times New Roman", 1, 18));
        msgLebel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        picLebel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout colLayout = new javax.swing.GroupLayout(col);
        col.setLayout(colLayout);
        colLayout.setHorizontalGroup(
            colLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, colLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(colLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(msgLebel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                    .addComponent(picLebel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE))
                .addContainerGap())
        );
        colLayout.setVerticalGroup(
            colLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(colLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(picLebel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(msgLebel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(col, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(col, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel col;
    public javax.swing.JLabel msgLebel;
    public javax.swing.JLabel picLebel;
    // End of variables declaration//GEN-END:variables
}
