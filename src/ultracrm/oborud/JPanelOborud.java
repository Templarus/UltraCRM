/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultracrm.oborud;

import ultracrm.dogovor.*;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import service.ParserXMLDom;
import ultracrm.DatabaseTableModel;
import ultracrm.FilterXML;
import ultracrm.MainFrame;
import ultracrm.Start;
import ultracrm.dogovor.AddDogovor;
import ultracrm.kontragent.AddKontr;
import ultracrm.kontragent.DKontr;

/**
 *
 * @author Asus
 */
public class JPanelOborud extends javax.swing.JPanel {

    private DatabaseTableModel dbm = new DatabaseTableModel(false);

    /**
     * Creates new form JPanelKontr
     */
    public JPanelOborud() {
        UIManager.put("FileChooser.openButtonText", "Открыть");
        UIManager.put("FileChooser.cancelButtonText", "Отмена");
        UIManager.put("FileChooser.lookInLabelText", "Смотреть в");
        UIManager.put("FileChooser.fileNameLabelText", "Имя файла");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Тип файла");

        UIManager.put("FileChooser.saveButtonText", "Сохранить");
        UIManager.put("FileChooser.saveButtonToolTipText", "Сохранить");
        UIManager.put("FileChooser.openButtonText", "Открыть");
        UIManager.put("FileChooser.openButtonToolTipText", "Открыть");
        UIManager.put("FileChooser.cancelButtonText", "Отмена");
        UIManager.put("FileChooser.cancelButtonToolTipText", "Отмена");

        UIManager.put("FileChooser.lookInLabelText", "Папка");
        UIManager.put("FileChooser.saveInLabelText", "Папка");
        UIManager.put("FileChooser.fileNameLabelText", "Имя файла");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Тип файлов");

        UIManager.put("FileChooser.upFolderToolTipText", "На один уровень вверх");
        UIManager.put("FileChooser.newFolderToolTipText", "Создание новой папки");
        UIManager.put("FileChooser.listViewButtonToolTipText", "Список");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Таблица");
        UIManager.put("FileChooser.fileNameHeaderText", "Имя");
        UIManager.put("FileChooser.fileSizeHeaderText", "Размер");
        UIManager.put("FileChooser.fileTypeHeaderText", "Тип");
        UIManager.put("FileChooser.fileDateHeaderText", "Изменен");
        UIManager.put("FileChooser.fileAttrHeaderText", "Атрибуты");

        UIManager.put("FileChooser.acceptAllFileFilterText", "Все файлы");
        initComponents();
        try {
            dbm.setDataSource(Start.mf.sDb.getDDogovor());
        } catch (Exception ex) {
            System.out.println("Создание таблицы перенаправленные ошибка доступа к RS" + ex);
        }

        dDogovorTable.getColumnModel().getColumn(0).setPreferredWidth(40);
        dDogovorTable.getColumnModel().getColumn(1).setPreferredWidth(120);
        dDogovorTable.getColumnModel().getColumn(2).setPreferredWidth(250);
        dDogovorTable.getColumnModel().getColumn(3).setPreferredWidth(80);
        dDogovorTable.getColumnModel().getColumn(4).setPreferredWidth(80);
        dDogovorTable.getColumnModel().getColumn(5).setPreferredWidth(800);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        butAdd = new javax.swing.JButton();
        butUpdate = new javax.swing.JButton();
        butDel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dDogovorTable = new javax.swing.JTable();

        fileChooser.setDialogTitle("Выбор файла для импорта");
        fileChooser.setFileFilter(new FilterXML());

        butAdd.setText("Добавить");
        butAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAddActionPerformed(evt);
            }
        });

        butUpdate.setText("Редактировать");
        butUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butUpdateActionPerformed(evt);
            }
        });

        butDel.setText("Удалить");
        butDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butDelActionPerformed(evt);
            }
        });

        dDogovorTable.setAutoCreateRowSorter(true);
        dDogovorTable.setModel(dbm);
        dDogovorTable.setToolTipText("");
        dDogovorTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dDogovorTableMouseClicked(evt);
            }
        });
        dDogovorTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(dDogovorTable);
        dDogovorTable.setFocusable(false);
        dDogovorTable.getTableHeader().setReorderingAllowed(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(butAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butDel, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1054, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butAdd)
                    .addComponent(butUpdate)
                    .addComponent(butDel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void butAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAddActionPerformed
        AddOborud addForm = new AddOborud(Start.mf, true, "Добавление нового оборудования", null);
        addForm.setVisible(true);
    }//GEN-LAST:event_butAddActionPerformed

    private void butUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butUpdateActionPerformed
        if (dDogovorTable.getSelectedRow() != -1) {
            DDogovor dog = MainFrame.sDb.getDogovor((int) dDogovorTable.getValueAt(dDogovorTable.getSelectedRow(), 0));
            AddDogovor addForm = new AddDogovor(Start.mf, true, "Редактирование договора", dog);
            addForm.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Необходимо выделить договор", "Внимание", JOptionPane.INFORMATION_MESSAGE);
        }


    }//GEN-LAST:event_butUpdateActionPerformed

    private void butDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butDelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_butDelActionPerformed

    private void dDogovorTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dDogovorTableMouseClicked
        if (evt.getClickCount() == 2) {
            DDogovor dog = MainFrame.sDb.getDogovor((int) dDogovorTable.getValueAt(dDogovorTable.getSelectedRow(), 0));
            AddDogovor addForm = new AddDogovor(Start.mf, true, "Редактирование договора", dog);
            addForm.setVisible(true);
        }
    }//GEN-LAST:event_dDogovorTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butAdd;
    private javax.swing.JButton butDel;
    private javax.swing.JButton butUpdate;
    private javax.swing.JTable dDogovorTable;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
