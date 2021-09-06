/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.cnr.paci.j4p.lesson5.eccezioni.examples;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author sommovir
 */
public class Example02_GUI_step6 extends javax.swing.JFrame {

    private boolean connected = false;
    private boolean broken = false;

    public void connect() {
        if (this.connected) {
            this.jLabel1.setBackground(Color.yellow);
            this.jLabel1.setText("CONNECTION BROKEN");
            broken = true;
            return;
        }
        this.jLabel1.setBackground(Color.green);
        this.jLabel1.setText("CONNECTION OPEN");
        this.connected = true;
    }

    public int updateData(int divisore) {
        JOptionPane.showMessageDialog(null, "Sto per fare una divisione");
        if (!connected || broken) {
            System.err.println("IMPOSSIBLE TO PROCEED, CONNECTION NEEDED");
            divisore = 0;
        }
        int c = 100 / divisore;
        return c;
    }

    public void disconnect() {
        if (!this.connected) {
            this.jLabel1.setBackground(Color.yellow);
            this.jLabel1.setText("CONNECTION BROKEN");
            broken = true;
            return;
        }
        this.jLabel1.setBackground(Color.red);
        this.jLabel1.setText("CONNECTION CLOSED");
        this.connected = false;
    }

    //aggiunto questo metodo che si vuole usare invece del normale disconnect
    //quando tutto ha successo
    public void disconnect2(int divisore) {
        System.out.println("I need x: " + divisore);
        if (!this.connected) {
            this.jLabel1.setBackground(Color.yellow);
            this.jLabel1.setText("CONNECTION BROKEN");
            return;
        }
        this.jLabel1.setBackground(Color.red);
        this.jLabel1.setText("CONNECTION CLOSED");
        this.connected = false;
    }

    /**
     * Creates new form NewJFrame
     */
    public Example02_GUI_step6() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel_risultato = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Dividi");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CONNECTION CLOSED");
        jLabel1.setOpaque(true);

        jLabel2.setText("risultato: ");

        jLabel_risultato.setText("-");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_risultato)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel_risultato)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.out.println("before error");
        int c = 0;
        try {
             
            connect();
            JOptionPane.showMessageDialog(null, "mi sono connesso");
            int divisore = Integer.parseInt(this.jTextField1.getText());
            c = updateData(divisore);

            this.jLabel_risultato.setText("" + c);

        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(null, "Non puoi dividere per 0");
            
        } 
//        finally{   //ATTIVARE
            disconnect2(c); 
//        }          //ATTIVARE 
        //x luca provare prima caso negativo

        System.out.println("after error");
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Example02_GUI_step6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Example02_GUI_step6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Example02_GUI_step6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Example02_GUI_step6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>



        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Example02_GUI_step6().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_risultato;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}