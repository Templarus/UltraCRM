/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultracrm;


import ultracrm.kontragent.JPanelKontr;
import ultracrm.treker.JPanelTreker;
import ultracrm.dogovor.JPanelDogovor;
import server.ServerDb;
import ultracrm.oborud.JPanelOborud;

/**
 *
 * @author RusTe
 */
public class MainFrame extends javax.swing.JFrame {

    public static ServerDb sDb;
    private static String connectionString = "jdbc:sqlserver://ASUSG46:1433;databaseName=UltraFiolet";
    private static String userName = "sa";
    private static String userPwd = "sa";

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {

        sDb = new ServerDb(connectionString, userName, userPwd);

        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMenuBar = new javax.swing.JPanel();
        butDogovor = new javax.swing.JButton();
        butTreker = new javax.swing.JButton();
        butKontr = new javax.swing.JButton();
        butDogovor1 = new javax.swing.JButton();
        butOborud = new javax.swing.JButton();
        jPanelContainer = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setMaximumSize(new java.awt.Dimension(1600, 900));
        setMinimumSize(new java.awt.Dimension(1600, 900));
        setPreferredSize(new java.awt.Dimension(1600, 900));
        getContentPane().setLayout(null);

        jPanelMenuBar.setMaximumSize(new java.awt.Dimension(1600, 90));
        jPanelMenuBar.setMinimumSize(new java.awt.Dimension(1600, 90));
        jPanelMenuBar.setPreferredSize(new java.awt.Dimension(1600, 90));
        jPanelMenuBar.setLayout(null);

        butDogovor.setText("Договора");
        butDogovor.setPreferredSize(new java.awt.Dimension(120, 95));
        butDogovor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butDogovorActionPerformed(evt);
            }
        });
        jPanelMenuBar.add(butDogovor);
        butDogovor.setBounds(250, 0, 130, 90);

        butTreker.setText("Трекеры");
        butTreker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butTrekerActionPerformed(evt);
            }
        });
        jPanelMenuBar.add(butTreker);
        butTreker.setBounds(0, 0, 120, 90);

        butKontr.setText("Контрагент");
        butKontr.setPreferredSize(new java.awt.Dimension(120, 95));
        butKontr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butKontrActionPerformed(evt);
            }
        });
        jPanelMenuBar.add(butKontr);
        butKontr.setBounds(120, 0, 130, 90);

        butDogovor1.setText("Справочники");
        butDogovor1.setPreferredSize(new java.awt.Dimension(120, 95));
        butDogovor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butDogovor1ActionPerformed(evt);
            }
        });
        jPanelMenuBar.add(butDogovor1);
        butDogovor1.setBounds(510, 0, 130, 90);

        butOborud.setText("Оборудование");
        butOborud.setPreferredSize(new java.awt.Dimension(120, 95));
        butOborud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butOborudActionPerformed(evt);
            }
        });
        jPanelMenuBar.add(butOborud);
        butOborud.setBounds(380, 0, 130, 90);

        getContentPane().add(jPanelMenuBar);
        jPanelMenuBar.setBounds(0, 0, 1600, 90);

        jPanelContainer.setMaximumSize(new java.awt.Dimension(1600, 780));
        jPanelContainer.setPreferredSize(new java.awt.Dimension(1600, 780));
        jPanelContainer.setLayout(null);
        getContentPane().add(jPanelContainer);
        jPanelContainer.setBounds(0, 90, 1600, 790);

        jMenu1.setText("Файл");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Вставка");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butTrekerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butTrekerActionPerformed
        clearJPanelComponent();
        JPanelTreker jPanTreker = new JPanelTreker();
        jPanTreker.setBounds(0, 0, 1600, 780);
        jPanTreker.setVisible(true);
        jPanelContainer.add(jPanTreker);
        jPanelContainer.updateUI();
        this.repaint();
    }//GEN-LAST:event_butTrekerActionPerformed

    private void butDogovorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butDogovorActionPerformed
        clearJPanelComponent();
        JPanelDogovor jPanDogovor = new JPanelDogovor();
        jPanDogovor.setBounds(0, 0, 1600, 780);
        jPanDogovor.setVisible(true);
        jPanelContainer.add(jPanDogovor);
        jPanelContainer.updateUI();
    }//GEN-LAST:event_butDogovorActionPerformed

    private void butKontrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butKontrActionPerformed
        clearJPanelComponent();
        JPanelKontr jPanKontr = new JPanelKontr();
        jPanKontr.setBounds(0, 0, 1600, 780);
        jPanKontr.setVisible(true);
        jPanelContainer.add(jPanKontr);
        jPanelContainer.updateUI();
    }//GEN-LAST:event_butKontrActionPerformed

    private void butDogovor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butDogovor1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_butDogovor1ActionPerformed

    private void butOborudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butOborudActionPerformed
        clearJPanelComponent();
        JPanelOborud jPanOborud = new JPanelOborud();
        jPanOborud.setBounds(0, 0, 1600, 780);
        jPanOborud.setVisible(true);
        jPanelContainer.add(jPanOborud);
        jPanelContainer.updateUI();      
    }//GEN-LAST:event_butOborudActionPerformed

    private void clearJPanelComponent() {
        jPanelContainer.removeAll();
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butDogovor;
    private javax.swing.JButton butDogovor1;
    private javax.swing.JButton butKontr;
    private javax.swing.JButton butOborud;
    private javax.swing.JButton butTreker;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanelContainer;
    private javax.swing.JPanel jPanelMenuBar;
    // End of variables declaration//GEN-END:variables
}
