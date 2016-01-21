/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultracrm.dogovor;

import java.util.Properties;
import ultracrm.kontragent.*;
import javax.swing.JOptionPane;
import ultracrm.MainFrame;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import ultracrm.DatabaseTableModel;
import ultracrm.Start;
import ultracrm.oborud.OborudChooser;
import ultracrm.treker.Device;

/**
 *
 * @author Asus
 */
public class AddDogovor extends javax.swing.JDialog {

    private DatabaseTableModel dbm = new DatabaseTableModel(false);

    /**
     * Creates new form AddKontr
     */
    public AddDogovor(java.awt.Frame parent, boolean modal, String title, DDogovor dog) {
        super(parent, modal);
        initComponents();
        this.setTitle(title);
        if (null != dog) {
            idDogovor.setText(new Integer(dog.getIdDogovor()).toString());
            nameDogovor.setText(dog.getNameDogovor());
            kontrBox.setSelectedItem(dog.getKontr());
            dtBegin.setDate(dog.getDtBegin());
            dtEnd.setDate(dog.getDtEnd());
            idVidOplat.setSelectedItem(dog.getSVidOplat());
            idUslovie.setSelectedItem(dog.getSUslovieDogovor());
            flClose.setSelected(dog.getFlclose());
            prim.setText(dog.getPrim());
        }
        try {
            int idDog = 0;
            if (!idDogovor.getText().equals("")) {
                idDog = new Integer(idDogovor.getText()).intValue();
                //System.out.println("Код договора : " + idDog);
            }
            dbm.setDataSource(Start.mf.sDb.getDDogovorOborud(idDog));
        } catch (Exception ex) {
            System.out.println("Создание таблицы оборудование в договоре ошибка доступа к RS" + ex);
        }

//        dDogovorOborudTable.getColumnModel().getColumn(0).setPreferredWidth(40);
//        dDogovorOborudTable.getColumnModel().getColumn(1).setPreferredWidth(120);
//        dDogovorOborudTable.getColumnModel().getColumn(2).setPreferredWidth(250);
//        dDogovorOborudTable.getColumnModel().getColumn(3).setPreferredWidth(80);
//        dDogovorOborudTable.getColumnModel().getColumn(4).setPreferredWidth(80);
//        dDogovorOborudTable.getColumnModel().getColumn(5).setPreferredWidth(800);
    }

    public void setKontrCombo(DKontr kontr) {
        kontrBox.setSelectedItem(kontr);
    }
    
    public void addDateTable(){
        try {
            dbm.addData();
        } catch (Exception ex) {
            System.out.println("Обновление таблицы оборудование в договоре ошибка доступа к RS" + ex);
        }
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        idDogovor = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nameDogovor = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        butCancel = new javax.swing.JButton();
        butSaveClose = new javax.swing.JButton();
        dtBegin = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dtEnd = new com.toedter.calendar.JDateChooser();
        idVidOplat = new javax.swing.JComboBox(MainFrame.sDb.getSVidOplat());
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        kontrBox = new javax.swing.JComboBox(MainFrame.sDb.getKontrArr());
        jLabel8 = new javax.swing.JLabel();
        idUslovie = new javax.swing.JComboBox(MainFrame.sDb.getSUslovie());
        flClose = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        prim = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dDogovorOborudTable = new javax.swing.JTable();
        addKontrBut = new javax.swing.JButton();
        clearKontrBut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setMaximumSize(new java.awt.Dimension(1920, 1680));
        setMinimumSize(null);
        setModal(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1103, 477));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Код");
        jLabel1.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jLabel1.setMinimumSize(null);

        idDogovor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        idDogovor.setMaximumSize(new java.awt.Dimension(1920, 1680));
        idDogovor.setMinimumSize(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Договор");
        jLabel2.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jLabel2.setMinimumSize(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Наименование");
        jLabel3.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jLabel3.setMinimumSize(null);

        nameDogovor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameDogovor.setMaximumSize(new java.awt.Dimension(1920, 1680));
        nameDogovor.setMinimumSize(null);
        nameDogovor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameDogovorActionPerformed(evt);
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

        dtBegin.setMaximumSize(new java.awt.Dimension(1920, 1680));
        dtBegin.setMinimumSize(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Дата начала");
        jLabel4.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jLabel4.setMinimumSize(null);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Дата окончания");
        jLabel5.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jLabel5.setMinimumSize(null);

        dtEnd.setMaximumSize(new java.awt.Dimension(1920, 1680));
        dtEnd.setMinimumSize(null);

        idVidOplat.setMaximumSize(new java.awt.Dimension(1920, 1680));
        idVidOplat.setMinimumSize(null);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Вид оплаты");
        jLabel6.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jLabel6.setMinimumSize(null);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Контрагент");
        jLabel7.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jLabel7.setMinimumSize(null);

        kontrBox.setMaximumSize(new java.awt.Dimension(1920, 1680));
        kontrBox.setMinimumSize(null);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Условия оплаты");
        jLabel8.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jLabel8.setMinimumSize(null);

        idUslovie.setMaximumSize(new java.awt.Dimension(1920, 1680));
        idUslovie.setMinimumSize(null);

        flClose.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        flClose.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        flClose.setMaximumSize(new java.awt.Dimension(1920, 1680));
        flClose.setMinimumSize(null);
        flClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flCloseActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Закрыт");
        jLabel9.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jLabel9.setMinimumSize(null);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Примечание");
        jLabel10.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jLabel10.setMinimumSize(null);

        prim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        prim.setMaximumSize(new java.awt.Dimension(1920, 1680));
        prim.setMinimumSize(null);
        prim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                primActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setMaximumSize(new java.awt.Dimension(1920, 1680));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Список оборудования");
        jLabel11.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jLabel11.setMinimumSize(null);

        jButton1.setText("Добавить");
        jButton1.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jButton1.setMinimumSize(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jScrollPane1.setMinimumSize(null);

        dDogovorOborudTable.setAutoCreateRowSorter(true);
        dDogovorOborudTable.setModel(dbm);
        dDogovorOborudTable.setToolTipText("");
        jScrollPane1.setViewportView(dDogovorOborudTable);
        dDogovorOborudTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        dDogovorOborudTable.setFocusable(false);
        dDogovorOborudTable.getTableHeader().setReorderingAllowed(false);

        addKontrBut.setText("Выбрать");
        addKontrBut.setMaximumSize(new java.awt.Dimension(1920, 1680));
        addKontrBut.setMinimumSize(null);
        addKontrBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addKontrButActionPerformed(evt);
            }
        });

        clearKontrBut.setText("Очистить");
        clearKontrBut.setMaximumSize(new java.awt.Dimension(1920, 1680));
        clearKontrBut.setMinimumSize(null);
        clearKontrBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearKontrButActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1103, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(idDogovor, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(309, 309, 309)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameDogovor, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(kontrBox, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(addKontrBut, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(clearKontrBut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(dtBegin, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(dtEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(idVidOplat, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(idUslovie, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(flClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prim, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(butCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116)
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
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(idDogovor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameDogovor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(kontrBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(addKontrBut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clearKontrBut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtBegin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idVidOplat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idUslovie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(flClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(prim, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(butCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butSaveClose, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameDogovorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameDogovorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameDogovorActionPerformed

    private void butCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCancelActionPerformed
        int reply = JOptionPane.showConfirmDialog(this, "Изменения будут потеряны", "Внимание", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            dispose();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_butCancelActionPerformed

    private void butSaveCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSaveCloseActionPerformed

        int rezult;

        if (nameDogovor.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Необходимо заполнить наименование договора", "Внимание", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (kontrBox.getSelectedItem()==null) {
                JOptionPane.showMessageDialog(this, "Необходимо выбрать контрагента", "Внимание", JOptionPane.INFORMATION_MESSAGE);
            } else if (this.getTitle().equals("Добавление нового договора")) {
                DKontr kontr = (DKontr) kontrBox.getSelectedItem();
                rezult = MainFrame.sDb.setDogovor(new DDogovor(kontr, new Date(dtBegin.getDate().getTime()), new Date(dtEnd.getDate().getTime()), nameDogovor.getText(), flClose.isSelected(), (SUslovieDogovor) idUslovie.getSelectedItem(), (SVidOplat) idVidOplat.getSelectedItem(), prim.getText()));

                if (MainFrame.sDb.err.equals("")) {
                    if (rezult != 0) {
                        JOptionPane.showMessageDialog(this, "Контрагент успешно добавлен", "Внимание", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Произошла ошибка " + MainFrame.sDb.err, "Внимание", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                DKontr kontr = (DKontr) kontrBox.getSelectedItem();
                rezult = MainFrame.sDb.updDogovor(new DDogovor(new Integer(idDogovor.getText()),kontr, new Date(dtBegin.getDate().getTime()), new Date(dtEnd.getDate().getTime()), nameDogovor.getText(), flClose.isSelected(), (SUslovieDogovor) idUslovie.getSelectedItem(), (SVidOplat) idVidOplat.getSelectedItem(), prim.getText()));

                if (MainFrame.sDb.err.equals("")) {
                    if (rezult != 0) {
                        JOptionPane.showMessageDialog(this, "Контрагент успешно обновлен", "Внимание", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Произошла ошибка " + MainFrame.sDb.err, "Внимание", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_butSaveCloseActionPerformed

    private void flCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flCloseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_flCloseActionPerformed

    private void primActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_primActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_primActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(idDogovor.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Необходимо сохранить договор", "Внимание", JOptionPane.INFORMATION_MESSAGE);
        } else {
            AddOborudDogovor obDog = new AddOborudDogovor(null,true,"Title",this);
            obDog.setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void addKontrButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addKontrButActionPerformed
        KontrChooser kontrChoose = new KontrChooser(null, true, this);
        kontrChoose.setVisible(true);
    }//GEN-LAST:event_addKontrButActionPerformed

    private void clearKontrButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearKontrButActionPerformed
        kontrBox.setSelectedItem(null);
    }//GEN-LAST:event_clearKontrButActionPerformed

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
            java.util.logging.Logger.getLogger(AddDogovor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddDogovor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddDogovor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddDogovor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddDogovor dialog = new AddDogovor(new javax.swing.JFrame(), true, "", null);
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
    private javax.swing.JButton addKontrBut;
    private javax.swing.JButton butCancel;
    private javax.swing.JButton butSaveClose;
    private javax.swing.JButton clearKontrBut;
    private javax.swing.JTable dDogovorOborudTable;
    private com.toedter.calendar.JDateChooser dtBegin;
    private com.toedter.calendar.JDateChooser dtEnd;
    private javax.swing.JCheckBox flClose;
    private javax.swing.JLabel idDogovor;
    private javax.swing.JComboBox<String> idUslovie;
    private javax.swing.JComboBox<String> idVidOplat;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox<String> kontrBox;
    private javax.swing.JTextField nameDogovor;
    private javax.swing.JTextField prim;
    // End of variables declaration//GEN-END:variables
}
