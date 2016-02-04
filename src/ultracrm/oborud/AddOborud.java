/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultracrm.oborud;

import ultracrm.treker.*;
import ultracrm.dogovor.*;
import ultracrm.kontragent.*;
import javax.swing.JOptionPane;
import ultracrm.MainFrame;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ultracrm.Start;
import yandexPack.YandexRequest;
import ultracrm.DatabaseTableModel;

/**
 *
 * @author Asus
 */
public class AddOborud extends javax.swing.JDialog {

    DatabaseTableModel dbmZamRash = new DatabaseTableModel(false);
    DatabaseTableModel dbmDopHarac = new DatabaseTableModel(false);
    DOborud oborud;

    /**
     * Creates new form AddKontr
     */
    public AddOborud(java.awt.Frame parent, boolean modal, String title, DOborud oborud) {
        super(parent, modal);
        initComponents();
        this.setTitle(title);
        this.oborud = oborud;

        try {
            dbmDopHarac.setDataSource(MainFrame.sDb.getOborudDopHarac());
            dbmZamRash.setDataSource(MainFrame.sDb.getOborudZamenaRash());
        } catch (Exception ex) {
            System.out.println("Создание таблицы доп. характеристик оборудования ошибка" + ex);
        }

        if (null != oborud) {
            idOborud.setText(oborud.getIdOborud().toString());
            nameOborud.setText(oborud.getNameOborud());
            idGrupOborud.setSelectedItem(oborud.getIdGrupOborud());
            if (oborud.getTreker() == null) {
                deviceId.setSelectedItem(null);
            } else {
                deviceId.setSelectedItem(oborud.getTreker());
            }
            sn.setText(oborud.getSn());
            inventNum.setText(oborud.getInventNum());
            osnPok.setText(oborud.getOsnPok());
            schet.setText(oborud.getSchet());

//            for(DOborudDopHarac dopHara : oborud.getHaracArr()){
//                try {
//                    dbmDopHarac.addData(dopHara);
//                } catch (Exception ex) {
//                     System.out.println("Создание таблицы доп. характеристик оборудования ошибка" + ex);
//                }
//            }
            updDopHaracTable();
            updZamRashTable();
        } else {
            idGrupOborud.setSelectedItem(null);
            deviceId.setSelectedItem(null);
        }
    }

    public void setTrekerCombo(Device dev) {
        deviceId.setSelectedItem(dev);
    }

    public DOborud getOborud() {
        return oborud;
    }

    public void addDopHarac(DOborudDopHarac dopHarac) {
        oborud.getHaracArr().add(dopHarac);
        updDopHaracTable();
    }

    public void addZamRash(DOborudZamenaRash zamRash) {
        oborud.getRashArr().add(zamRash);
        updZamRashTable();
    }

    public void updDopHaracTable() {
        dbmDopHarac.clearData();
        this.oborud = MainFrame.sDb.getOborud(oborud.getIdOborud());
        for (DOborudDopHarac dopHara : oborud.getHaracArr()) {
            try {
                dbmDopHarac.addData(dopHara);
            } catch (Exception ex) {
                System.out.println("Создание таблицы доп. характеристик оборудования ошибка" + ex);
            }
        }
    }

    public void updZamRashTable() {
        dbmZamRash.clearData();
        this.oborud = MainFrame.sDb.getOborud(oborud.getIdOborud());
        for (DOborudZamenaRash zamRash : oborud.getRashArr()) {
            try {
                dbmZamRash.addData(zamRash);
            } catch (Exception ex) {
                System.out.println("Создание таблицы замена расходников оборудования ошибка" + ex);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        idOborud = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nameOborud = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        butCancel = new javax.swing.JButton();
        butSaveClose = new javax.swing.JButton();
        balans = new javax.swing.JLabel();
        deviceId = new javax.swing.JComboBox(MainFrame.sDb.getDeviceList().toArray());
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        idGrupOborud = new javax.swing.JComboBox(MainFrame.sDb.getSGrupOborud());
        clearGrupBut = new javax.swing.JButton();
        clearTrekerBut = new javax.swing.JButton();
        addTrekerBut = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        sn = new javax.swing.JTextField();
        inventNum = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        osnPok = new javax.swing.JTextField();
        schet = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        dOborudDopHaracTable = new javax.swing.JTable();
        addDopHaracBut = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        addZamRashBut = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        dOborudZamenaRashTable = new javax.swing.JTable();
        changeOborudBut = new javax.swing.JButton();
        changeOborudBut1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setMaximumSize(new java.awt.Dimension(1920, 1680));
        setMinimumSize(null);
        setModal(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Код");
        jLabel1.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jLabel1.setMinimumSize(null);

        idOborud.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        idOborud.setMaximumSize(new java.awt.Dimension(1920, 1680));
        idOborud.setMinimumSize(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Оборудование");
        jLabel2.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jLabel2.setMinimumSize(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Наименование оборудования");
        jLabel3.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jLabel3.setMinimumSize(null);

        nameOborud.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameOborud.setMaximumSize(new java.awt.Dimension(1920, 1680));
        nameOborud.setMinimumSize(null);
        nameOborud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameOborudActionPerformed(evt);
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

        balans.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        balans.setMaximumSize(new java.awt.Dimension(1920, 1680));
        balans.setMinimumSize(null);

        deviceId.setEditor(null);
        deviceId.setEnabled(false);
        deviceId.setMaximumSize(new java.awt.Dimension(1920, 1680));
        deviceId.setMinimumSize(null);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Трекер");
        jLabel6.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jLabel6.setMinimumSize(null);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Группа");
        jLabel8.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jLabel8.setMinimumSize(null);

        idGrupOborud.setMaximumSize(new java.awt.Dimension(1920, 1680));
        idGrupOborud.setMinimumSize(null);

        clearGrupBut.setText("Очистить");
        clearGrupBut.setMaximumSize(new java.awt.Dimension(1920, 1680));
        clearGrupBut.setMinimumSize(null);
        clearGrupBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearGrupButActionPerformed(evt);
            }
        });

        clearTrekerBut.setText("Очистить");
        clearTrekerBut.setMaximumSize(new java.awt.Dimension(1920, 1680));
        clearTrekerBut.setMinimumSize(null);
        clearTrekerBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearTrekerButActionPerformed(evt);
            }
        });

        addTrekerBut.setText("Выбрать");
        addTrekerBut.setMaximumSize(new java.awt.Dimension(1920, 1680));
        addTrekerBut.setMinimumSize(null);
        addTrekerBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTrekerButActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Сер. №");
        jLabel7.setMaximumSize(new java.awt.Dimension(1920, 1680));

        sn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        inventNum.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Ин. №");
        jLabel9.setMaximumSize(new java.awt.Dimension(1920, 1680));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Основание покупки");
        jLabel10.setMaximumSize(new java.awt.Dimension(1920, 1680));

        osnPok.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        schet.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Счетчик");
        jLabel11.setMaximumSize(new java.awt.Dimension(1920, 1680));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jScrollPane1.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jScrollPane1.setMinimumSize(null);

        dOborudDopHaracTable.setAutoCreateRowSorter(true);
        dOborudDopHaracTable.setModel(dbmDopHarac);
        dOborudDopHaracTable.setToolTipText("");
        jScrollPane1.setViewportView(dOborudDopHaracTable);
        dOborudDopHaracTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        dOborudDopHaracTable.setFocusable(false);
        dOborudDopHaracTable.getTableHeader().setReorderingAllowed(false);

        addDopHaracBut.setText("Добавить");
        addDopHaracBut.setMaximumSize(new java.awt.Dimension(1920, 1680));
        addDopHaracBut.setMinimumSize(null);
        addDopHaracBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDopHaracButActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Дополнительные характеристики");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Замена расходных материалов");

        addZamRashBut.setText("Добавить");
        addZamRashBut.setMaximumSize(new java.awt.Dimension(1920, 1680));
        addZamRashBut.setMinimumSize(null);
        addZamRashBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addZamRashButActionPerformed(evt);
            }
        });

        jScrollPane2.setMaximumSize(new java.awt.Dimension(1920, 1680));
        jScrollPane2.setMinimumSize(null);

        dOborudDopHaracTable.setAutoCreateRowSorter(true);
        dOborudZamenaRashTable.setModel(dbmZamRash);
        dOborudDopHaracTable.setToolTipText("");
        jScrollPane2.setViewportView(dOborudZamenaRashTable);
        dOborudDopHaracTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        dOborudDopHaracTable.setFocusable(false);
        dOborudDopHaracTable.getTableHeader().setReorderingAllowed(false);

        changeOborudBut.setText("Редактировать");
        changeOborudBut.setMaximumSize(new java.awt.Dimension(1920, 1680));
        changeOborudBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeOborudButActionPerformed(evt);
            }
        });

        changeOborudBut1.setText("Редактировать");
        changeOborudBut1.setMaximumSize(new java.awt.Dimension(1920, 1680));
        changeOborudBut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeOborudBut1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(idOborud, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(idGrupOborud, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clearGrupBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(butCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(188, 188, 188)
                                        .addComponent(butSaveClose, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(deviceId, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2)
                                        .addComponent(addTrekerBut, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(clearTrekerBut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sn, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inventNum, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(schet, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(osnPok, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameOborud, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addDopHaracBut, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(changeOborudBut, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addZamRashBut, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(changeOborudBut1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(idOborud, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(nameOborud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(clearGrupBut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(idGrupOborud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addTrekerBut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(clearTrekerBut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(deviceId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inventNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(schet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(osnPok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(butCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(butSaveClose, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addDopHaracBut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(changeOborudBut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addZamRashBut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(changeOborudBut1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameOborudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameOborudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameOborudActionPerformed

    private void butCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCancelActionPerformed
        int reply = JOptionPane.showConfirmDialog(this, "Изменения будут потеряны", "Внимание", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_butCancelActionPerformed

    private void butSaveCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSaveCloseActionPerformed

        int rezult;

        if (nameOborud.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Необходимо заполнить наименование оборудования", "Внимание", JOptionPane.INFORMATION_MESSAGE);
        } else if (null == idGrupOborud.getSelectedItem()) {
            JOptionPane.showMessageDialog(this, "Необходимо выбрать группу оборудования", "Внимание", JOptionPane.INFORMATION_MESSAGE);
        } else if (this.getTitle().equals("Добавление нового оборудования")) {

            Device device = (Device) deviceId.getSelectedItem();
            SGrupOborud grup = (SGrupOborud) idGrupOborud.getSelectedItem();

            rezult = MainFrame.sDb.setOborud(new DOborud(0, nameOborud.getText(), grup, device, sn.getText(), inventNum.getText(), osnPok.getText(), schet.getText()));

            if (MainFrame.sDb.err.equals("")) {
                if (rezult != 0) {
                    JOptionPane.showMessageDialog(this, "Оборудование успешно добавлено", "Внимание", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }

            } else {
                JOptionPane.showMessageDialog(this, "Произошла ошибка " + MainFrame.sDb.err, "Внимание", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            Device device = (Device) deviceId.getSelectedItem();
            SGrupOborud grup = (SGrupOborud) idGrupOborud.getSelectedItem();

            rezult = MainFrame.sDb.updOborud(new DOborud(new Integer(idOborud.getText()), nameOborud.getText(), grup, device, sn.getText(), inventNum.getText(), osnPok.getText(), schet.getText()));

            if (MainFrame.sDb.err.equals("")) {
                if (rezult != 0) {
                    JOptionPane.showMessageDialog(this, "Оборудование успешно обновлено", "Внимание", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }

            } else {
                JOptionPane.showMessageDialog(this, "Произошла ошибка " + MainFrame.sDb.err, "Внимание", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_butSaveCloseActionPerformed

    private void clearGrupButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearGrupButActionPerformed
        idGrupOborud.setSelectedItem(null);
    }//GEN-LAST:event_clearGrupButActionPerformed

    private void clearTrekerButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearTrekerButActionPerformed
        deviceId.setSelectedItem(null);
    }//GEN-LAST:event_clearTrekerButActionPerformed

    private void addTrekerButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTrekerButActionPerformed
        TrekerChooser trekChoose = new TrekerChooser(null, true, this);
        trekChoose.setVisible(true);
    }//GEN-LAST:event_addTrekerButActionPerformed


    private void portActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portActionPerformed

    }//GEN-LAST:event_portActionPerformed

    private void addDopHaracButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDopHaracButActionPerformed
        if (idOborud.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Необходимо сохранить оборудование", "Внимание", JOptionPane.INFORMATION_MESSAGE);
        } else {
            AddDopHarac dopHarac = new AddDopHarac(null, true, "Добавление дополнительных характеристик", this, null);
            dopHarac.setVisible(true);
        }
    }//GEN-LAST:event_addDopHaracButActionPerformed

    private void addZamRashButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addZamRashButActionPerformed
        if (idOborud.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Необходимо сохранить оборудование", "Внимание", JOptionPane.INFORMATION_MESSAGE);
        } else {
            AddZamRash zamRash = new AddZamRash(null, true, "Добавление расходных материалов", this, null);
            zamRash.setVisible(true);
        }
    }//GEN-LAST:event_addZamRashButActionPerformed

    private void changeOborudButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeOborudButActionPerformed
        if (dOborudDopHaracTable.getSelectedRow() != -1) {
            DOborudDopHarac dopHarac = null;

            for (DOborudDopHarac dop : oborud.getHaracArr()) {
                if (dop.getIdDopHarac().getIdDopHarac() == dOborudDopHaracTable.getValueAt(dOborudDopHaracTable.getSelectedRow(), 0)) {
                    dopHarac = dop;
                }
            }

            AddDopHarac dopHar = new AddDopHarac(null, true, "Редактирование дополнительных характеристик", this, dopHarac);
            dopHar.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(this, "Необходимо выделить оборудование", "Внимание", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_changeOborudButActionPerformed

    private void changeOborudBut1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeOborudBut1ActionPerformed
        if (dOborudZamenaRashTable.getSelectedRow() != -1) {
            DOborudZamenaRash zamRash = null;

            for (DOborudZamenaRash zam : oborud.getRashArr()) {
                if (zam.getIdOborudRas().getIdOborud() == dOborudZamenaRashTable.getValueAt(dOborudZamenaRashTable.getSelectedRow(), 0)) {
                    zamRash = zam;
                }
            }

            AddZamRash zamRas = new AddZamRash(null, true, "Редактирование расходных материалов", this, zamRash);
            zamRas.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(this, "Необходимо выделить оборудование", "Внимание", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_changeOborudBut1ActionPerformed

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
            java.util.logging.Logger.getLogger(AddOborud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddOborud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddOborud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddOborud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                AddOborud dialog = new AddOborud(new javax.swing.JFrame(), true, "", null);
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
    private javax.swing.JButton addDopHaracBut;
    private javax.swing.JButton addTrekerBut;
    private javax.swing.JButton addZamRashBut;
    private javax.swing.JLabel balans;
    private javax.swing.JButton butCancel;
    private javax.swing.JButton butSaveClose;
    private javax.swing.JButton changeOborudBut;
    private javax.swing.JButton changeOborudBut1;
    private javax.swing.JButton clearGrupBut;
    private javax.swing.JButton clearTrekerBut;
    private javax.swing.JTable dOborudDopHaracTable;
    private javax.swing.JTable dOborudZamenaRashTable;
    private javax.swing.JComboBox<String> deviceId;
    private javax.swing.JComboBox<String> idGrupOborud;
    private javax.swing.JLabel idOborud;
    private javax.swing.JTextField inventNum;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField nameOborud;
    private javax.swing.JTextField osnPok;
    private javax.swing.JTextField schet;
    private javax.swing.JTextField sn;
    // End of variables declaration//GEN-END:variables
}
