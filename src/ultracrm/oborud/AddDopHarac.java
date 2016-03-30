/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultracrm.oborud;

import ultracrm.kontragent.*;
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
public class AddDopHarac extends javax.swing.JDialog {

    
    
    AddOborud oborud;
    DOborudDopHarac dopHarac;
    /**
     * Creates new form AddKontr
     */
    public AddDopHarac(java.awt.Frame parent, boolean modal, String title, AddOborud oborud, DOborudDopHarac dopHarac) {
        super(parent, modal);
        initComponents();
        this.setTitle(title);
        this.oborud = oborud;
        this.dopHarac = dopHarac;
        idOborud.setText(oborud.getOborud().toString());
        idDopHarac.setSelectedIndex(-1);
        if (null != dopHarac) {
            idDopHarac.setSelectedItem(dopHarac.getIdDopHarac());
            pokaz.setText(dopHarac.getPokaz());
            idDopHarac.setEnabled(false);
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        idOborud = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pokaz = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        butCancel = new javax.swing.JButton();
        butSaveClose = new javax.swing.JButton();
        idDopHarac = new javax.swing.JComboBox(MainFrame.sDb.getSDopHarac());

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setMinimumSize(null);
        setModal(true);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Характеристика оборудования ");
        jLabel2.setMaximumSize(new java.awt.Dimension(1920, 1680));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Оборудование");
        jLabel3.setMaximumSize(new java.awt.Dimension(1920, 1680));

        idOborud.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        idOborud.setEnabled(false);
        idOborud.setMaximumSize(new java.awt.Dimension(1920, 1680));
        idOborud.setMinimumSize(null);
        idOborud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idOborudActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Характеристика");
        jLabel5.setMaximumSize(new java.awt.Dimension(1920, 1680));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Показатель");
        jLabel6.setMaximumSize(new java.awt.Dimension(1920, 1680));

        pokaz.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pokaz.setMaximumSize(new java.awt.Dimension(1920, 1680));
        pokaz.setMinimumSize(null);
        pokaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pokazActionPerformed(evt);
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(idOborud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(idDopHarac, 0, 244, Short.MAX_VALUE)
                                        .addComponent(pokaz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(0, 161, Short.MAX_VALUE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(77, 77, 77)
                            .addComponent(butCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(135, 135, 135)
                            .addComponent(butSaveClose, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap()))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idOborud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idDopHarac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pokaz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(butCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butSaveClose, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idOborudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idOborudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idOborudActionPerformed

    private void pokazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pokazActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pokazActionPerformed

    private void butCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCancelActionPerformed
        int reply = JOptionPane.showConfirmDialog(this, "Изменения будут потеряны", "Внимание", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            dispose();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_butCancelActionPerformed

    private void butSaveCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSaveCloseActionPerformed
        int rezult;

        if (idDopHarac.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Необходимо выбрать характерискику", "Внимание", JOptionPane.INFORMATION_MESSAGE);
        } else if (pokaz.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Необходимо заполнить показатель", "Внимание", JOptionPane.INFORMATION_MESSAGE);
        } else if (this.getTitle().equals("Добавление дополнительных характеристик")) {
            DOborudDopHarac dopHarac = new DOborudDopHarac(oborud.getOborud().getIdOborud(),(SDopHarac)idDopHarac.getSelectedItem(), pokaz.getText());
            
            rezult = MainFrame.sDb.setOborudDopHarac(dopHarac);
             
            
            
            if (MainFrame.sDb.err.equals("")) {
                if (rezult != 0) {
                    oborud.addDopHarac(dopHarac);
                    JOptionPane.showMessageDialog(this, "Характеристика успешно добавлена", "Внимание", JOptionPane.INFORMATION_MESSAGE);
                   dispose();
                }

            } else {
                JOptionPane.showMessageDialog(this, "Произошла ошибка " + MainFrame.sDb.err, "Внимание", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
                 DOborudDopHarac dopHarac = new DOborudDopHarac(oborud.getOborud().getIdOborud(),(SDopHarac)idDopHarac.getSelectedItem(), pokaz.getText());
                 rezult = MainFrame.sDb.updOborudDopHarac(dopHarac);
                 
                if (MainFrame.sDb.err.equals("")) {
                    if (rezult != 0) {
                        oborud.updDopHaracTable();
                        JOptionPane.showMessageDialog(this, "Характеристика успешно обновлена", "Внимание", JOptionPane.INFORMATION_MESSAGE);
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
            java.util.logging.Logger.getLogger(AddDopHarac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddDopHarac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddDopHarac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddDopHarac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddDopHarac dialog = new AddDopHarac(new javax.swing.JFrame(), true, "", null, null);
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
    private javax.swing.JComboBox<String> idDopHarac;
    private javax.swing.JTextField idOborud;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField pokaz;
    // End of variables declaration//GEN-END:variables
}