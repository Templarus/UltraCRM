/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultracrm.treker;

import ultracrm.dogovor.*;
import ultracrm.kontragent.*;
import javax.swing.JOptionPane;
import ultracrm.MainFrame;
import java.sql.Date;
import yandexPack.YandexRequest;
/**
 *
 * @author Asus
 */
public class AddDevice extends javax.swing.JDialog {

    /**
     * Creates new form AddKontr
     */
    public AddDevice(java.awt.Frame parent, boolean modal, String title, Device dev) {
        super(parent, modal);
        initComponents();
        this.setTitle(title);
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
        id = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        deviceId = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        butCancel = new javax.swing.JButton();
        butSaveClose = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        port = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        balans = new javax.swing.JLabel();
        tel = new javax.swing.JFormattedTextField();
        password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setMaximumSize(new java.awt.Dimension(1920, 1680));
        setMinimumSize(null);
        setModal(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Код");
        jLabel1.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jLabel1.setMinimumSize(null);

        id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        id.setMaximumSize(new java.awt.Dimension(1920, 1680));
        id.setMinimumSize(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Трекер");
        jLabel2.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jLabel2.setMinimumSize(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Идентификатор трекера");
        jLabel3.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jLabel3.setMinimumSize(null);

        deviceId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deviceId.setMaximumSize(new java.awt.Dimension(1920, 1680));
        deviceId.setMinimumSize(null);
        deviceId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deviceIdActionPerformed(evt);
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

        jButton1.setText("Тест GEO");
        jButton1.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jButton1.setMinimumSize(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Порт");
        jLabel4.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jLabel4.setMinimumSize(null);

        port.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        port.setMaximumSize(new java.awt.Dimension(1920, 1680));
        port.setMinimumSize(null);
        port.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Пароль");
        jLabel5.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jLabel5.setMinimumSize(null);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Телефон");
        jLabel6.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jLabel6.setMinimumSize(null);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Баланс");
        jLabel7.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jLabel7.setMinimumSize(null);

        balans.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        balans.setMaximumSize(new java.awt.Dimension(1920, 1680));
        balans.setMinimumSize(null);

        try {
            tel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("+7(###)###-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tel.setMaximumSize(new java.awt.Dimension(1920, 1680));
        tel.setMinimumSize(null);

        password.setToolTipText("");
        password.setMaximumSize(new java.awt.Dimension(1920, 1680));
        password.setMinimumSize(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(deviceId, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(port, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(balans, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(butCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(butSaveClose, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(deviceId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(balans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(butCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butSaveClose, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deviceIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deviceIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deviceIdActionPerformed

    private void butCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCancelActionPerformed
        int reply = JOptionPane.showConfirmDialog(this, "Изменения будут потеряны", "Внимание", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            dispose();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_butCancelActionPerformed

    private void butSaveCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSaveCloseActionPerformed
//        System.out.println("Телефон : " + tel.getText());







//  //        System.out.println("Наименование контрагента - " +  Kontr.getSelectedItem().toString());
//          
//          
//       // new Date(dtBegin.getDate().getTime());
//      
//        int rezult;
//
//        if (nameDogovor.getText().equals("")) {
//            JOptionPane.showMessageDialog(this, "Необходимо заполнить наименование договора", "Внимание", JOptionPane.INFORMATION_MESSAGE);
//        } else 
//        if (Kontr.getSelectedItem().toString().equals("")) {
//            JOptionPane.showMessageDialog(this, "Необходимо выбрать контрагента", "Внимание", JOptionPane.INFORMATION_MESSAGE);
//        } else 
//            if (this.getTitle().equals("Добавление нового договора")) {
//            DKontr kontr = (DKontr)Kontr.getSelectedItem();
//            //    System.out.println("IdKontragent : " + kontr.getIdKontr());
//           
//            
//            rezult = MainFrame.sDb.setDogovor(new DDogovor(kontr, new Date(dtBegin.getDate().getTime()), new Date(dtEnd.getDate().getTime()), nameDogovor.getText(), flClose.isSelected(), (SUslovieDogovor)idUslovie.getSelectedItem(), (SVidOplat)idVidOplat.getSelectedItem(), prim.getText()));
//
//            if (MainFrame.sDb.err.equals("")) {
//                if (rezult != 0) {
//                    JOptionPane.showMessageDialog(this, "Контрагент успешно добавлен", "Внимание", JOptionPane.INFORMATION_MESSAGE);
//                    dispose();
//                }
//
//            } else {
//                JOptionPane.showMessageDialog(this, "Произошла ошибка " + MainFrame.sDb.err, "Внимание", JOptionPane.INFORMATION_MESSAGE);
//            }
//        } else {
//////            rezult = MainFrame.sDb.updKontr(new DKontr(new Integer(idDogovor.getText()),nameDogovor.getText(), urNameKontr.getText(), innKontr.getText(), kppKontr.getText(), adressKontr.getText()));
//////
//////            if (MainFrame.sDb.err.equals("")) {
//////                if (rezult != 0) {
//////                    JOptionPane.showMessageDialog(this, "Контрагент успешно обновлен", "Внимание", JOptionPane.INFORMATION_MESSAGE);
//////                    dispose();
//////                }
//////
//////            } else {
//////                JOptionPane.showMessageDialog(this, "Произошла ошибка " + MainFrame.sDb.err, "Внимание", JOptionPane.INFORMATION_MESSAGE);
//////            }
  //      }
    }//GEN-LAST:event_butSaveCloseActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      YandexRequest yr = new YandexRequest();
      deviceId.setText(yr.getLocation(MainFrame.sDb.getCellKoordinats("863591026612469"),false));
      deviceId.updateUI();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void portActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_portActionPerformed

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
            java.util.logging.Logger.getLogger(AddDevice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddDevice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddDevice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddDevice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddDevice dialog = new AddDevice(new javax.swing.JFrame(), true, "", null);
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
    private javax.swing.JLabel balans;
    private javax.swing.JButton butCancel;
    private javax.swing.JButton butSaveClose;
    private javax.swing.JTextField deviceId;
    private javax.swing.JLabel id;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField port;
    private javax.swing.JFormattedTextField tel;
    // End of variables declaration//GEN-END:variables
}
