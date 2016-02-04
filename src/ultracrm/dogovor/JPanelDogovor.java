/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultracrm.dogovor;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
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
public class JPanelDogovor extends javax.swing.JPanel {
  private double scalingfactor = 1.0;
    private DatabaseTableModel dbm = new DatabaseTableModel(false);

    /**
     * Creates new form JPanelKontr
     */
    public JPanelDogovor() {
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
        rescaling();
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
        butImport = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dDogovorTable = new javax.swing.JTable();

        fileChooser.setDialogTitle("Выбор файла для импорта");
        fileChooser.setFileFilter(new FilterXML());

        setMaximumSize(new java.awt.Dimension(1920, 1280));
        setMinimumSize(null);
        setLayout(null);

        butAdd.setText("Добавить");
        butAdd.setMaximumSize(new java.awt.Dimension(1920, 1280));
        butAdd.setMinimumSize(null);
        butAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAddActionPerformed(evt);
            }
        });
        add(butAdd);
        butAdd.setBounds(0, 0, 210, 30);

        butUpdate.setText("Редактировать");
        butUpdate.setMaximumSize(new java.awt.Dimension(1920, 1280));
        butUpdate.setMinimumSize(null);
        butUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butUpdateActionPerformed(evt);
            }
        });
        add(butUpdate);
        butUpdate.setBounds(210, 0, 210, 30);

        butDel.setText("Удалить");
        butDel.setMaximumSize(new java.awt.Dimension(1920, 1280));
        butDel.setMinimumSize(null);
        butDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butDelActionPerformed(evt);
            }
        });
        add(butDel);
        butDel.setBounds(420, 0, 210, 30);

        butImport.setText("Импорт");
        butImport.setMaximumSize(new java.awt.Dimension(1920, 1280));
        butImport.setMinimumSize(null);
        butImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butImportActionPerformed(evt);
            }
        });
        add(butImport);
        butImport.setBounds(630, 0, 210, 30);

        jScrollPane1.setMaximumSize(new java.awt.Dimension(1920, 1280));
        jScrollPane1.setMinimumSize(null);

        dDogovorTable.setAutoCreateRowSorter(true);
        dDogovorTable.setModel(dbm);
        dDogovorTable.setMaximumSize(new java.awt.Dimension(1920, 1280));
        dDogovorTable.setMinimumSize(null);
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

        add(jScrollPane1);
        jScrollPane1.setBounds(0, 29, 1600, 740);
    }// </editor-fold>//GEN-END:initComponents

    private void butAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAddActionPerformed
        AddDogovor addForm = new AddDogovor(Start.mf, true, "Добавление нового договора", null);
        addForm.setVisible(true);
                addForm.setBounds(0, 0,addForm.getSize().width, addForm.getSize().height);

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

    private void butImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butImportActionPerformed
//        int returnVal = fileChooser.showOpenDialog(this);
//        if (returnVal == JFileChooser.APPROVE_OPTION) {
//            File file = fileChooser.getSelectedFile();
//            //try {
//            System.out.println("Путь к фалу - " + file.getPath());
//            // What to do with the file, e.g. display it in a TextArea
//            //textarea.read( new FileReader( file.getAbsolutePath() ), null );
//            //} catch (IOException ex) {
//            //System.out.println("problem accessing file"+file.getAbsolutePath());
//            //}
//        } else {
//            System.out.println("File access cancelled by user.");
//        }
//        ParserXMLDom parserXML = new ParserXMLDom();
//        File file = new File("E:\\javaproject\\UltraCRM\\file\\Выгрузка13112015.xml");
//        try {
//            parserXML.parseXML(file);
//        } catch (ParserConfigurationException ex) {
//            Logger.getLogger(JPanelDogovor.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SAXException ex) {
//            Logger.getLogger(JPanelDogovor.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(JPanelDogovor.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }//GEN-LAST:event_butImportActionPerformed

    private void dDogovorTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dDogovorTableMouseClicked
        if (evt.getClickCount() == 2) {
            DDogovor dog = MainFrame.sDb.getDogovor((int) dDogovorTable.getValueAt(dDogovorTable.getSelectedRow(), 0));
            AddDogovor addForm = new AddDogovor(Start.mf, true, "Редактирование договора", dog);
            addForm.setVisible(true);
        }
    }//GEN-LAST:event_dDogovorTableMouseClicked
   private void rescaling() //method used to rescale UI
    {
        scalingfactor = Start.interfaceScalingFactor;

       // System.out.println("getPreferredSize().width=" + getPreferredSize().width);
       // System.out.println("getPreferredSize().height=" + getPreferredSize().height);

        int width = (int) (getPreferredSize().width * scalingfactor);
        int height = (int) (getPreferredSize().height * scalingfactor);
       // System.out.println("MainFrame scalingfactor=" + scalingfactor + " width=" + width + " height=" + height);

        setPreferredSize(new Dimension((int) (getPreferredSize().width * scalingfactor), (int) (getPreferredSize().height * scalingfactor)));
        setBounds(0, 0, (int) (1680 * scalingfactor), (int) (1050 * scalingfactor));
        for (Component comp : this.getComponents()) {
            comp.setPreferredSize(new Dimension((int) (comp.getPreferredSize().width * scalingfactor), (int) (comp.getPreferredSize().height * scalingfactor)));
            comp.setBounds((int) (comp.getX() * scalingfactor), (int) (comp.getY() * scalingfactor), (int) (comp.getWidth() * scalingfactor), (int) (comp.getHeight() * scalingfactor));

            //comp=rescaleComponent(comp);
            rescaleComponent(comp);

            if (comp instanceof JMenuBar) {
                JMenuBar jM = (JMenuBar) comp;
                for (Component lComp : jM.getComponents()) {
                    rescaleComponent(lComp);
                }
            }
            if (comp instanceof JPanel) {
                JPanel jP = (JPanel) comp;
                for (Component lComp : jP.getComponents()) {
                    rescaleComponent(lComp);
                }
            }
            if (comp instanceof JScrollPane) {
                JScrollPane jSp = (JScrollPane) comp;
                for (Component lComp : jSp.getComponents()) {
                    rescaleComponent(lComp);
                }
            }
        }
        repaint();
        revalidate();
    }

    private Component rescaleComponent(Component comp) {
//        if (comp instanceof JButton) {
//            JButton jb = (JButton) comp;
//            comp.setBounds((int) (comp.getX() * scalingfactor), (int) (comp.getY() * scalingfactor), (int) (comp.getWidth() * scalingfactor), (int) (comp.getHeight() * scalingfactor));
//            jb.setFont(new Font("Tahoma", Font.PLAIN, (int) (jb.getFont().getSize() * scalingfactor)));
//        }
//        if (comp instanceof JLabel) {
//            JLabel jl = (JLabel) comp;
//            jl.setFont(new Font("Tahoma", Font.PLAIN, (int) (jl.getFont().getSize() * scalingfactor)));
//        }
        if (comp instanceof JComboBox) {
            JComboBox jl = (JComboBox) comp;
            jl.setFont(new Font("Tahoma", Font.PLAIN, (int) (jl.getFont().getSize() * scalingfactor)));
            comp.setBounds((int) (comp.getX() * scalingfactor), (int) (comp.getY() * scalingfactor), (int) (comp.getWidth() * scalingfactor), (int) (comp.getHeight() * scalingfactor));
        }
        if (comp instanceof JTable) {
            JTable jT = (JTable) comp;
            jT.setFont(new Font("Tahoma", Font.PLAIN, (int) (jT.getFont().getSize() * scalingfactor)));
            for (int i = 0; i < jT.getColumnModel().getColumnCount(); i++) {
               // System.err.println("123123123132");
               // System.out.println("widtbefore="+jT.getColumnModel().getColumn(i).getPreferredWidth()+" AFTER="+(int) (jT.getColumnModel().getColumn(i).getPreferredWidth() * scalingfactor));
                
                
                jT.getColumnModel().getColumn(i).setPreferredWidth((int) (jT.getColumnModel().getColumn(i).getPreferredWidth() * scalingfactor));
                jT.getColumnModel().getColumn(i).setWidth((int) (jT.getColumnModel().getColumn(i).getWidth() * scalingfactor));
                
                comp.repaint();
                comp.revalidate();
            }
            
            comp.setBounds((int) (comp.getX() * scalingfactor), (int) (comp.getY() * scalingfactor), (int) (comp.getWidth() * scalingfactor), (int) (comp.getHeight() * scalingfactor));
        }
        
        
        if (comp instanceof JViewport) {
            JViewport jV = (JViewport) comp;
             for (Component lComp : jV.getComponents()) {
                   // System.err.println("00001111");
                   // System.err.println(lComp.toString());
                    rescaleComponent(lComp);
                }
            jV.setFont(new Font("Tahoma", Font.PLAIN, (int) (jV.getFont().getSize() * scalingfactor)));
            comp.setBounds((int) (comp.getX() * scalingfactor), (int) (comp.getY() * scalingfactor), (int) (comp.getWidth() * scalingfactor), (int) (comp.getHeight() * scalingfactor));
        }
        
        
        return comp;
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butAdd;
    private javax.swing.JButton butDel;
    private javax.swing.JButton butImport;
    private javax.swing.JButton butUpdate;
    private javax.swing.JTable dDogovorTable;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
