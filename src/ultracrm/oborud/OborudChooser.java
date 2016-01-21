/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultracrm.oborud;

import ultracrm.kontragent.*;
import ultracrm.treker.*;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import ultracrm.DatabaseTableModel;
import ultracrm.MainFrame;
import ultracrm.Start;
import ultracrm.dogovor.AddDogovor;
import ultracrm.dogovor.AddOborudDogovor;
import ultracrm.dogovor.DDogOborud;
import ultracrm.dogovor.DDogovor;

/**
 *
 * @author Asus
 */
public class OborudChooser extends javax.swing.JDialog {

    AddOborudDogovor dogOborud;
    private DatabaseTableModel dbm = new DatabaseTableModel(false);

    public OborudChooser(java.awt.Frame parent, boolean modal, AddOborudDogovor dialog) {
        super(parent, modal);
        this.dogOborud = dialog;
        initComponents();

        try {
            dbm.setDataSource(Start.mf.sDb.getDOborud());
        } catch (Exception ex) {
            System.out.println("Создание таблицы перенаправленные ошибка доступа к RS" + ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        oborudTable = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nameOborud = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setMaximumSize(new java.awt.Dimension(1920, 1680));
        setMinimumSize(null);

        jScrollPane1.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jScrollPane1.setMinimumSize(null);

        oborudTable.setAutoCreateRowSorter(true);
        oborudTable.setModel(dbm);
        oborudTable.setMaximumSize(new java.awt.Dimension(1920, 1680));
        oborudTable.setMinimumSize(null);
        oborudTable.setToolTipText("");
        oborudTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                oborudTableMouseClicked(evt);
            }
        });
        oborudTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(oborudTable);
        oborudTable.setFocusable(false);
        oborudTable.getTableHeader().setReorderingAllowed(false);

        jSeparator1.setMaximumSize(new java.awt.Dimension(1920, 1680));

        jSeparator2.setMaximumSize(new java.awt.Dimension(1920, 1680));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Выбор оборудования");
        jLabel1.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jLabel1.setMinimumSize(null);

        jLabel2.setText("Фильтр");
        jLabel2.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jLabel2.setMinimumSize(null);

        jLabel3.setText("Наименование");
        jLabel3.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jLabel3.setMinimumSize(null);

        nameOborud.setMaximumSize(new java.awt.Dimension(1920, 1680));
        nameOborud.setMinimumSize(null);
        nameOborud.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                nameOborudCaretUpdate(evt);
            }
        });
        nameOborud.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                nameOborudInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        nameOborud.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameOborudKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nameOborudKeyTyped(evt);
            }
        });

        jButton1.setText("Выбрать");
        jButton1.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jButton1.setMinimumSize(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Отменить");
        jButton2.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jButton2.setMinimumSize(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Очистить фильтр");
        jButton3.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jButton3.setMinimumSize(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(nameOborud, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(388, 388, 388)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nameOborud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void oborudTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oborudTableMouseClicked
        if (evt.getClickCount() == 2) {
            DOborud oborud = Start.mf.sDb.getOborud((int) oborudTable.getValueAt(oborudTable.getSelectedRow(), 0));
            dispose();
            dogOborud.setNameOborud(oborud);
        }
    }//GEN-LAST:event_oborudTableMouseClicked

    private void nameOborudInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_nameOborudInputMethodTextChanged

    }//GEN-LAST:event_nameOborudInputMethodTextChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int reply = JOptionPane.showConfirmDialog(this, "Выход без изменений?", "Внимание", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void nameOborudCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_nameOborudCaretUpdate

    }//GEN-LAST:event_nameOborudCaretUpdate

    private void nameOborudKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameOborudKeyTyped

    }//GEN-LAST:event_nameOborudKeyTyped

    private void nameOborudKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameOborudKeyReleased
        try {
            dbm.setDataSource(Start.mf.sDb.getDOborud(nameOborud.getText()));
        } catch (Exception ex) {
            System.out.println("Создание таблицы отфильтрованных по наименованию оборудования ошибка доступа к RS" + ex);
        }
    }//GEN-LAST:event_nameOborudKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        nameOborud.setText("");
        try {
            dbm.setDataSource(Start.mf.sDb.getDOborud());
        } catch (Exception ex) {
            System.out.println("Создание таблицы оборудования ошибка доступа к RS" + ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (oborudTable.getSelectedRow() != -1) {
            DOborud oborud = Start.mf.sDb.getOborud((int) oborudTable.getValueAt(oborudTable.getSelectedRow(), 0));
            dispose();
            dogOborud.setNameOborud(oborud);
        } else {
            JOptionPane.showMessageDialog(this, "Необходимо выделить оборудование", "Внимание", JOptionPane.INFORMATION_MESSAGE);
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
            java.util.logging.Logger.getLogger(OborudChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OborudChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OborudChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OborudChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                OborudChooser dialog = new OborudChooser(new javax.swing.JFrame(), true, null);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField nameOborud;
    private javax.swing.JTable oborudTable;
    // End of variables declaration//GEN-END:variables
}
