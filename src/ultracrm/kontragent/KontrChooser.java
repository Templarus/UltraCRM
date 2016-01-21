/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultracrm.kontragent;

import ultracrm.treker.*;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import ultracrm.DatabaseTableModel;
import ultracrm.MainFrame;
import ultracrm.Start;
import ultracrm.dogovor.AddDogovor;
import ultracrm.dogovor.DDogovor;
import ultracrm.oborud.AddOborud;

/**
 *
 * @author Asus
 */
public class KontrChooser extends javax.swing.JDialog {
    AddDogovor addODogovor;
    private DatabaseTableModel dbm = new DatabaseTableModel(false);

    public KontrChooser(java.awt.Frame parent, boolean modal, AddDogovor dialog) {
        super(parent, modal);
        this.addODogovor = dialog;
        initComponents();

        try {
            dbm.setDataSource(Start.mf.sDb.getDKontr());
        } catch (Exception ex) {
            System.out.println("Создание таблицы перенаправленные ошибка доступа к RS" + ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        sKontrTable = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nameKontr = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        nameKontrUr = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setMaximumSize(new java.awt.Dimension(1920, 1680));
        setMinimumSize(null);
        getContentPane().setLayout(null);

        jScrollPane1.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jScrollPane1.setMinimumSize(null);

        sKontrTable.setAutoCreateRowSorter(true);
        sKontrTable.setModel(dbm);
        sKontrTable.setMaximumSize(new java.awt.Dimension(1920, 1680));
        sKontrTable.setMinimumSize(null);
        sKontrTable.setToolTipText("");
        sKontrTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sKontrTableMouseClicked(evt);
            }
        });
        sKontrTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(sKontrTable);
        sKontrTable.setFocusable(false);
        sKontrTable.getTableHeader().setReorderingAllowed(false);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 170, 588, 467);

        jSeparator1.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jSeparator1.setMinimumSize(null);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(10, 44, 588, 2);

        jSeparator2.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jSeparator2.setMinimumSize(null);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(10, 162, 588, 2);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Выбор контрагента");
        jLabel1.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jLabel1.setMinimumSize(null);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 0, 369, 38);

        jLabel2.setText("Фильтр");
        jLabel2.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jLabel2.setMinimumSize(null);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 52, 85, 14);

        jLabel3.setText("Наименование");
        jLabel3.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jLabel3.setMinimumSize(null);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 75, 112, 14);

        nameKontr.setMaximumSize(new java.awt.Dimension(1920, 1680));
        nameKontr.setMinimumSize(null);
        nameKontr.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                nameKontrCaretUpdate(evt);
            }
        });
        nameKontr.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                nameKontrInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        nameKontr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameKontrKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nameKontrKeyTyped(evt);
            }
        });
        getContentPane().add(nameKontr);
        nameKontr.setBounds(126, 72, 291, 20);

        jButton1.setText("Выбрать");
        jButton1.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jButton1.setMinimumSize(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(388, 4, 102, 34);

        jButton2.setText("Отменить");
        jButton2.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jButton2.setMinimumSize(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(496, 4, 102, 34);

        jButton3.setText("Очистить фильтр");
        jButton3.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jButton3.setMinimumSize(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(388, 133, 210, 23);

        nameKontrUr.setMaximumSize(new java.awt.Dimension(1920, 1680));
        nameKontrUr.setMinimumSize(null);
        nameKontrUr.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                nameKontrUrCaretUpdate(evt);
            }
        });
        nameKontrUr.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                nameKontrUrInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        nameKontrUr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameKontrUrKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nameKontrUrKeyTyped(evt);
            }
        });
        getContentPane().add(nameKontrUr);
        nameKontrUr.setBounds(126, 98, 291, 20);

        jLabel4.setText("Юр.  наименование");
        jLabel4.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jLabel4.setMinimumSize(null);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 101, 112, 14);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sKontrTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sKontrTableMouseClicked
        if (evt.getClickCount() == 2) {
                DKontr kontr = Start.mf.sDb.getKontr((int) sKontrTable.getValueAt(sKontrTable.getSelectedRow(), 0));
                dispose();
                addODogovor.setKontrCombo(kontr);
        }
    }//GEN-LAST:event_sKontrTableMouseClicked

    private void nameKontrInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_nameKontrInputMethodTextChanged

    }//GEN-LAST:event_nameKontrInputMethodTextChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int reply = JOptionPane.showConfirmDialog(this, "Выход без изменений?", "Внимание", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void nameKontrCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_nameKontrCaretUpdate

    }//GEN-LAST:event_nameKontrCaretUpdate

    private void nameKontrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKontrKeyTyped

    }//GEN-LAST:event_nameKontrKeyTyped

    private void nameKontrKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKontrKeyReleased
        nameKontrUr.setText("");
        try {
            dbm.setDataSource(Start.mf.sDb.getDKontr(nameKontr.getText()));
        } catch (Exception ex) {
            System.out.println("Создание таблицы отфильтрованных по наименованию контрагента ошибка доступа к RS" + ex);
        }
    }//GEN-LAST:event_nameKontrKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        nameKontr.setText("");
        nameKontrUr.setText("");
        try {
            dbm.setDataSource(Start.mf.sDb.getDKontr());
        } catch (Exception ex) {
            System.out.println("Создание таблицы перенаправленные ошибка доступа к RS" + ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void nameKontrUrCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_nameKontrUrCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_nameKontrUrCaretUpdate

    private void nameKontrUrInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_nameKontrUrInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_nameKontrUrInputMethodTextChanged

    private void nameKontrUrKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKontrUrKeyReleased
        nameKontr.setText("");
        try {
            dbm.setDataSource(Start.mf.sDb.getDKontrUr(nameKontrUr.getText()));
        } catch (Exception ex) {
            System.out.println("Создание таблицы отфильтрованных по юридическому наименованию контрагента ошибка доступа к RS" + ex);
        }        
    }//GEN-LAST:event_nameKontrUrKeyReleased

    private void nameKontrUrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKontrUrKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_nameKontrUrKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                if(sKontrTable.getSelectedRow() != -1){  
        DKontr kontr = Start.mf.sDb.getKontr((int) sKontrTable.getValueAt(sKontrTable.getSelectedRow(), 0));
                dispose();
                addODogovor.setKontrCombo(kontr); 
      } else {
          JOptionPane.showMessageDialog(this, "Необходимо выделить контрагента", "Внимание", JOptionPane.INFORMATION_MESSAGE);
      }     
      
                
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
            java.util.logging.Logger.getLogger(KontrChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KontrChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KontrChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KontrChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                KontrChooser dialog = new KontrChooser(new javax.swing.JFrame(), true, null);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField nameKontr;
    private javax.swing.JTextField nameKontrUr;
    private javax.swing.JTable sKontrTable;
    // End of variables declaration//GEN-END:variables
}
