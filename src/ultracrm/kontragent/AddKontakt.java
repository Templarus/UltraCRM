/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultracrm.kontragent;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ultracrm.DatabaseTableModel;
import ultracrm.MainFrame;
import ultracrm.Start;

/**
 *
 * @author Asus
 */
public class AddKontakt extends javax.swing.JDialog {

    private DatabaseTableModel dbm = new DatabaseTableModel(false);
    DKontr kontr;
    AddKontr addKont;
    DKontakt kontakt;

    /**
     * Creates new form AddKontr
     */
    public AddKontakt(java.awt.Frame parent, boolean modal, String title, DKontr kontr, AddKontr addKont, DKontakt kontakt) {
        super(parent, modal);
        initComponents();
        this.setTitle(title);
        this.kontr = kontr;
        this.addKont = addKont;
        this.kontakt = kontakt;
        try {
            dbm.setDataSource(Start.mf.sDb.getKontakt());
        } catch (Exception ex) {
            System.out.println("Создание таблицы оборудование в договоре ошибка доступа к RS" + ex);
        }

        if (null != kontakt) {

            idKontakt.setText(kontakt.getIdKontackt().toString());
            nameKontakt.setText(kontakt.getNameKontakt());
            telKontakt.setText(kontakt.getTelKontakt());
            emailKontakt.setText(kontakt.getEmailKontakt());

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        idKontakt = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nameKontakt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        telKontakt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        emailKontakt = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        butCancel = new javax.swing.JButton();
        butSaveClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setMinimumSize(null);
        setModal(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Код");
        jLabel1.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jLabel1.setMinimumSize(null);

        idKontakt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        idKontakt.setMaximumSize(new java.awt.Dimension(1920, 1680));
        idKontakt.setMinimumSize(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Контакты");
        jLabel2.setMaximumSize(new java.awt.Dimension(1920, 1680));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Имя");
        jLabel3.setMaximumSize(new java.awt.Dimension(1920, 1680));

        nameKontakt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameKontakt.setMaximumSize(new java.awt.Dimension(1920, 1680));
        nameKontakt.setMinimumSize(null);
        nameKontakt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameKontaktActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Телефон");
        jLabel5.setMaximumSize(new java.awt.Dimension(1920, 1680));

        telKontakt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        telKontakt.setMaximumSize(new java.awt.Dimension(1920, 1680));
        telKontakt.setMinimumSize(null);
        telKontakt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telKontaktActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("E-mail");
        jLabel6.setMaximumSize(new java.awt.Dimension(1920, 1680));

        emailKontakt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        emailKontakt.setMaximumSize(new java.awt.Dimension(1920, 1680));
        emailKontakt.setMinimumSize(null);
        emailKontakt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailKontaktActionPerformed(evt);
            }
        });

        jSeparator1.setMaximumSize(new java.awt.Dimension(1920, 1680));

        butCancel.setText("Отменить");
        butCancel.setMaximumSize(new java.awt.Dimension(1920, 1680));
        butCancel.setMinimumSize(null);
        butCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCancelActionPerformed(evt);
            }
        });

        butSaveClose.setText("Сохранить и закрыть");
        butSaveClose.setMaximumSize(new java.awt.Dimension(1920, 1680));
        butSaveClose.setMinimumSize(null);
        butSaveClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSaveCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(70, 70, 70)
                                    .addComponent(idKontakt, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nameKontakt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(telKontakt, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(emailKontakt, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(0, 232, Short.MAX_VALUE))))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(77, 77, 77)
                            .addComponent(butCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(135, 135, 135)
                            .addComponent(butSaveClose, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap()))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idKontakt, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameKontakt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telKontakt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailKontakt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(butCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butSaveClose, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameKontaktActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameKontaktActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameKontaktActionPerformed

    private void telKontaktActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telKontaktActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telKontaktActionPerformed

    private void emailKontaktActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailKontaktActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailKontaktActionPerformed

    private void butCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCancelActionPerformed
        int reply = JOptionPane.showConfirmDialog(this, "Изменения будут потеряны", "Внимание", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            dispose();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_butCancelActionPerformed

    private void butSaveCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSaveCloseActionPerformed
        int rezult;

        if (nameKontakt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Необходимо заполнить имя контакта", "Внимание", JOptionPane.INFORMATION_MESSAGE);
        } else if (telKontakt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Необходимо заполнить телефон контакта", "Внимание", JOptionPane.INFORMATION_MESSAGE);
        } else if (this.getTitle().equals("Добавление контакта в контрагента")) {
            DKontakt kontakt = new DKontakt(0, nameKontakt.getText(), telKontakt.getText(), emailKontakt.getText());
            rezult = MainFrame.sDb.setKontakt(kontakt, kontr.getIdKontr());
             
            addKont.updKontrArr();
            if (MainFrame.sDb.err.equals("")) {
                if (rezult != 0) {
                    JOptionPane.showMessageDialog(this, "Контакт успешно добавлен", "Внимание", JOptionPane.INFORMATION_MESSAGE);
                   dispose();
                }

            } else {
                JOptionPane.showMessageDialog(this, "Произошла ошибка " + MainFrame.sDb.err, "Внимание", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
                 DKontakt kontakt = new DKontakt(new Integer(idKontakt.getText()), nameKontakt.getText(), telKontakt.getText(), emailKontakt.getText());
                rezult = MainFrame.sDb.updKontakt(kontakt, kontr.getIdKontr());
                 
                 addKont.updKontrArr();
                if (MainFrame.sDb.err.equals("")) {
                    if (rezult != 0) {
                        JOptionPane.showMessageDialog(this, "Контакт успешно обновлен", "Внимание", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Произошла ошибка " + MainFrame.sDb.err, "Внимание", JOptionPane.INFORMATION_MESSAGE);
                }
        }
    }//GEN-LAST:event_butSaveCloseActionPerformed

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
            java.util.logging.Logger.getLogger(AddKontakt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddKontakt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddKontakt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddKontakt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddKontakt dialog = new AddKontakt(new javax.swing.JFrame(), true, "", null, null, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butCancel;
    private javax.swing.JButton butSaveClose;
    private javax.swing.JTextField emailKontakt;
    private javax.swing.JLabel idKontakt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField nameKontakt;
    private javax.swing.JTextField telKontakt;
    // End of variables declaration//GEN-END:variables
}
