package server;

import EventManagment.Event;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ultracrm.dogovor.AddDogovor;
import ultracrm.dogovor.DDogOborud;
import ultracrm.dogovor.DDogovor;
import ultracrm.dogovor.SUslovieDogovor;
import ultracrm.dogovor.SVidOplat;
import ultracrm.kontragent.DKontakt;
import ultracrm.kontragent.DKontr;
import ultracrm.oborud.DOborud;
import ultracrm.oborud.DOborudDopHarac;
import ultracrm.oborud.DOborudZamenaRash;
import ultracrm.oborud.SDopHarac;
import ultracrm.oborud.SGrupOborud;
import ultracrm.treker.Device;
import ultracrm.treker.DeviceTimeWork;

public class ServerDb implements Constatnts {

    protected Connection conn;
    private Statement st;
    private String sql;
    private ResultSet rs;
    public ResultSet rsClientFind;
    public String err = "";

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public ServerDb(String url, String user, String password) {
        if (connect(url, user, password) != Constatnts.READY) {
            JOptionPane.showMessageDialog(null, "Не удается устрановить соединение с базой", "Внимание", 0);
        }
        System.out.println("SERVERDb: constructor");
    }

    public int connect(String url, String user, String password) {

        try {
            conn = DriverManager.getConnection(url, user, password);//Подключаемся к баде данных
            st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//Делаем многонаправленный ResultSet
            System.out.println("SUCCESSFULLY connected with database!");
        } catch (SQLException ex) {
            System.out.println("ServerDb:getData():Ошибка подключения или создание Statement - " + ex);
            return Constatnts.ERROR;
        }
        return Constatnts.READY;
    }

    @Override
    public int connect() {
        System.out.println("SERVERDb: connect");
        String[] args = {""};
        if (this.connect(args) == Constatnts.ERROR) {
            return Constatnts.ERROR;
        }
        return Constatnts.READY;
    }

    @Override
    public int connect(String[] args) {
        System.out.println("SERVERDb: connect");
        String url = args[0];//--Разбираем массив параметров
        String user = args[1];
        String password = args[2];
        try {
            conn = DriverManager.getConnection(url, user, password);//Подключаемся к баде данных
            st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//Делаем многонаправленный ResultSet
            System.out.println("SUCCESSFULLY connected with database!");
        } catch (SQLException ex) {
            System.out.println("ServerDb:getData():Ошибка подключения или создание Statement - " + ex);
            return Constatnts.ERROR;
        }
        System.out.println("ok good connection with DATABASE");
        return Constatnts.READY;
    }

    public int insertDb(String sql) {
        int rezult = 0;
        try {
            st = conn.createStatement();
            rezult = st.executeUpdate(sql);
            st.close();
        } catch (SQLTimeoutException ex) {
            System.out.println("ServerDb:insertDb():Ошибка подключения или создание Statement - " + ex + " sql: " + sql);
            err = "ServerDb:insertDb():Ошибка подключения или создание Statement - " + ex + " sql: " + sql;
        } catch (SQLException ex) {
            System.out.println("ServerDb:insertDb():Ошибка подключения или создание Statement - " + ex + " sql: " + sql);
            err = "ServerDb:insertDb():Ошибка подключения или создание Statement - " + ex + " sql: " + sql;
        }
        return rezult;
    }

    public int updateDb(String sql) {
        int rezult = 0;
        try {
            st = conn.createStatement();
            rezult = st.executeUpdate(sql);
            st.close();
        } catch (SQLTimeoutException ex) {
            System.out.println("ServerDb:updateDb():Ошибка подключения или создание Statement - " + ex + " sql: " + sql);
            err = "ServerDb:updateDb():Ошибка подключения или создание Statement - " + ex + " sql: " + sql;
        } catch (SQLException ex) {
            System.out.println("ServerDb:updateDb():Ошибка подключения или создание Statement - " + ex + " sql: " + sql);
            err = "ServerDb:updateDb():Ошибка подключения или создание Statement - " + ex + " sql: " + sql;
        }
        return rezult;
    }

    public ResultSet selectDb(String sql) {
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("ServerDb:selectDb():Ошибка подключения или создание Statement - " + ex + " sql: " + sql);
            err = "ServerDb:selectDb():Ошибка подключения или создание Statement - " + ex + " sql: " + sql;
        }
        return rs;
    }

    public int exBatch() {
        try {
            conn.setAutoCommit(false);
            st.executeBatch();
            conn.commit();
        } catch (SQLException ex) {
            System.out.println("ServerDb:exBatch():Ошибка выполнения пакета - " + ex + " sql: " + sql);
            err = "ServerDb:exBatch():Ошибка выполнения пакета - " + ex + " sql: " + sql;
        }
        return 1;
    }

//работа с трекерами
    public int setDevice(Device dev) {
        sql = "INSERT INTO [dbo].[STreker] "
                + "        ([deviceId],[port],[password],[tel],[flGeo],[flDisable])"
                + " VALUES ('" + dev.getId() + "' ," + dev.getPort() + ",'" + dev.getPassword() + "','" + dev.getTel() + "','" + dev.isFlGeo() + "','" + dev.isFlDisable() + "')";
        return insertDb(sql);
    }

    public ResultSet getSTreker() {
        sql = "SELECT deviceId as Устройство, port as Порт, dbo.f_getOborudTreker(deviceId) as [Привязан к оборудованию] FROM STreker ORDER BY deviceId DESC";
        return selectDb(sql);
    }

    public ResultSet getSTreker(String deviceId) {
        sql = "SELECT deviceId as Устройство, port as Порт, dbo.f_getOborudTreker(deviceId) as [Привязан к оборудованию] FROM STreker "
                + "WHERE deviceId Like N'%" + deviceId + "%' ORDER BY deviceId DESC";
        return selectDb(sql);
    }

    public ResultSet getDeviceTimeWork() {
        String deviceId = "";
        try {
            sql = "SELECT TOP(1) deviceId, port, password FROM STreker ORDER BY deviceId DESC";
            rs = selectDb(sql);
            while (rs.next()) {
                deviceId = rs.getString(1);
            }
        } catch (SQLException ex) {
            System.out.println("ServerDb:getDeviceTimeWork()ПолучениеТекущегоУстройства:Ошибка подключения или создание Statement");
        }

        sql = "SELECT deviceId AS Устройство, dtWork AS Дата, SUM(timeWorkin) AS [Время отработанное(мин)] FROM DeviceTimeWork GROUP BY deviceId, dtWork HAVING (deviceId = N'" + deviceId + "') ORDER BY Дата";
        System.out.println("");
        return selectDb(sql);
    }

    public ResultSet getDeviceTimeWorkExtend() {
        String deviceId = "";
        Date dtFirst = new Date(-2208978000000L);
        try {
            sql = "SELECT TOP(1) deviceId, port, password FROM STreker ORDER BY deviceId DESC";
            rs = selectDb(sql);
            while (rs.next()) {
                deviceId = rs.getString(1);
            }
        } catch (SQLException ex) {
            System.out.println("ServerDb:getDeviceTimeWork()ПолучениеТекущегоУстройства:Ошибка подключения или создание Statement");
        }

        try {
            sql = "SELECT TOP(1) deviceId AS Устройство, dtWork AS Дата, SUM(timeWorkin) AS [Время отработанное(мин)] FROM DeviceTimeWork GROUP BY deviceId, dtWork HAVING (deviceId = N'" + deviceId + "') ORDER BY Дата";
            rs = selectDb(sql);
            while (rs.next()) {
                dtFirst = rs.getDate(2);
            }
        } catch (SQLException ex) {
            System.out.println("ServerDb:getDeviceTimeWork()ПолучениеТекущейДаты:Ошибка подключения или создание Statement");
        }

        sql = "SELECT deviceId AS Устройство, dtWork AS Дата, CONVERT(nvarchar(8),timeBegin) as [Время начала работы], CONVERT(nvarchar(8),timeEnd) as [Время окончания работы], timeWorkin  AS [Время отработанное(мин)] FROM DeviceTimeWork WHERE deviceId = N'" + deviceId + "' AND dtWork = '" + dtFirst.toString() + "' ORDER BY timeBegin";
        System.out.println("");
        return selectDb(sql);
    }

    public ArrayList<Device> getDeviceList() {
        ArrayList<Device> deviceList = new ArrayList<Device>();
        Device device;
        try {
            sql = "SELECT deviceId, port, password FROM STreker";
            ResultSet rs = selectDb(sql);
            while (rs.next()) {
                device = new Device(rs.getString(1), rs.getInt(2), rs.getString(3));
                deviceList.add(device);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("ServerDb:getDeviceList():Ошибка подключения или создание Statement");
        }
        return deviceList;
    }

    public Device getDevice(String deviceId) {
        Device device = null;
        try {
            sql = "SELECT deviceId, port, password FROM STreker WHERE deviceId = '" + deviceId + "'";
            ResultSet rs = selectDb(sql);
            while (rs.next()) {
                device = new Device(rs.getString(1), rs.getInt(2), rs.getString(3));
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("ServerDb:getDevice():Ошибка подключения или создание Statement");
        }
        return device;
    }

    public boolean getDeviceOborud(String deviceId) {
        boolean fl = false;

        try {
            sql = "SELECT [dbo].[f_getOborudTreker]('" + deviceId + "')";
            ResultSet rs = selectDb(sql);
            while (rs.next()) {
                String otvet = rs.getString(1);
                if (otvet.equals("Да")) {
                    fl = true;
                }

            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("ServerDb:getDeviceOborud():Ошибка подключения или создание Statement");
        }
        return fl;
    }

    public void updDeviceTimeWork() {

        for (Device dev : getDeviceList()) {
            Date dtLast = new Date(-2208978000000L);
            Time timeLast = new Time(-10800000l);
            
            
            sql = "DELETE FROM DeviceTimeWork WHERE id IN (SELECT    TOP(1) id FROM DeviceTimeWork WHERE (deviceId = N'" + dev.getId() + "') ORDER BY dtWork DESC, timeBegin DESC, timeEnd DESC)";
            updateDb(sql);
            
            
            try {
                sql = "SELECT    TOP(1)    deviceId, ISNULL(dtWork,''), timeBegin, ISNULL(timeEnd,ISNULL(timeBegin,'')) FROM DeviceTimeWork WHERE (deviceId = N'" + dev.getId() + "') ORDER BY dtWork DESC, timeBegin DESC, timeEnd DESC";
                rs = selectDb(sql);
                System.out.println("ДАТА ЗАВЕРШЕНИЯ" + sql);
                while (rs.next()) {
                    dtLast = rs.getDate(2);
                    timeLast = rs.getTime(4);
                }
            } catch (SQLException ex) {
                System.out.println("ServerDb:updDeviceTimeWork()ПолучениеДатфЗавершения:Ошибка подключения или создание Statement");
            }

            while (hasNextTimeWork(dev, dtLast, timeLast) > 0) {

                //if (dtLast.equals(dtLastW) | timeLast.equals(timeLastW)) {
                try {
                    sql = "SELECT TOP(1) date, time FROM PackageDate WHERE (deviceId = '" + dev.getId() + "') AND (date > '" + dtLast + "') AND (ISNULL(input2, 0) = 1) OR (deviceId = N'" + dev.getId() + "') AND (date >= '" + dtLast + "') AND (ISNULL(input2, 0) = 1) AND (time > '" + timeLast.toString() + "')";
                    //sql = "SELECT  TOP(1)  date, time FROM PackageDate WHERE (ISNULL(input2,0) = 1) AND deviceId = '" + dev.getId() + "' AND date > = '" + dtLast + "' AND time > '" + timeLast.toString() + "' ORDER BY date, time";

                    rs = selectDb(sql);
                    System.out.println("Получение данных по последней дате работы" + sql);
                    while (rs.next()) {
                        dtLast = rs.getDate(1);
                        timeLast = rs.getTime(2);
                    }
                } catch (SQLException ex) {
                    System.out.println("ServerDb:updDeviceTimeWork()ПолучениеДанныхПоПоследнейРаботе:Ошибка подключения или создание Statement");
                }

                sql = "INSERT INTO DeviceTimeWork "
                        + "      (deviceId, dtWork, timeBegin) "
                        + "VALUES('" + dev.getId() + "','" + dtLast.toString() + "','" + timeLast.toString() + "')";

                System.out.println("SQL43:" + sql);
                //};
                updateDb(sql);

                sql = "UPDATE DeviceTimeWork "
                        + "SET timeEnd = "
                        + "ISNULL("
                        + "(SELECT TOP(1) time FROM PackageDate WHERE deviceId = '" + dev.getId() + "' AND (date = '" + dtLast + "') AND (time >= '" + timeLast + "') and ISNULL(input2,0) = 0 ORDER BY time),"
                        + "'23:59:59') "
                        + "WHERE  deviceId = '" + dev.getId() + "' ANd dtWork = '" + dtLast + "' And timeBegin = '" + timeLast + "'";
                System.out.println("setDeviceTimeWorkEnd - SQL : " + sql);
                if (updateDb(sql) > 0) {
                };
                try {
                    sql = "SELECT    TOP(1)    deviceId, dtWork, timeBegin, ISNULL(timeEnd,'') FROM DeviceTimeWork WHERE (deviceId = N'" + dev.getId() + "') ORDER BY dtWork DESC, timeBegin DESC, timeEnd DESC";
                    rs = selectDb(sql);
                    System.out.println("ДАТА ЗАВЕРШЕНИЯ" + sql);
                    while (rs.next()) {
                        dtLast = rs.getDate(2);
                        timeLast = rs.getTime(4);
                    }
                } catch (SQLException ex) {
                    System.out.println("ServerDb:updDeviceTimeWork()ПолучениеДатфЗавершения:Ошибка подключения или создание Statement");
                }

            }

            System.out.println("Закончили формирования работы...");

        }
    }

    private int hasNextTimeWork(Device dev, Date dtLast, Time timeLast) {
        int countRecord = 0;
        sql = "SELECT        COUNT(*) AS Count "
                + "FROM            PackageDate "
                + "WHERE        (deviceId = '" + dev.getId() + "') AND (date > '" + dtLast.toString() + "') AND (ISNULL(input2, 0) = 1) OR (deviceId = N'" + dev.getId() + "') AND (date >= '" + dtLast.toString() + "') AND (ISNULL(input2, 0) = 1) AND (time > '" + timeLast + "')";
//sql = "SELECT COUNT(*) AS Count FROM PackageDate WHERE ((deviceId = '" + dev.getId() + "' ) AND  (date > '" + dtLast.toString() + "')AND (ISNULL(input2,0) = 1)) OR ((deviceId = '" + dev.getId() + "' ) AND  (date >= '" + dtLast.toString() + "')AND (ISNULL(input2,0) = 1) AND (time > '" + timeLast + "')) ";
        System.out.println("hasNextTimeWork - SQL : " + sql);
        rs = selectDb(sql);
        try {
            while (rs.next()) {
                countRecord = rs.getInt(1);
            }

        } catch (SQLException ex) {
            System.out.println("ServerDb:hasNextTimeWork():Ошибка подключения или создание Statement");
        }

        return countRecord;
    }

    public DeviceTimeWork getDeviceTimeWorkLast(Device dev) {
        DeviceTimeWork devLastWork = new DeviceTimeWork("", new Date(-2208988800000L), new Time(-10800000l), new Time(-10800000l));
        sql = "SELECT TOP (1) deviceId, dtWork, timeBegin, ISNULL(timeEnd,'') FROM UltraFiolet.dbo.DeviceTimeWork WHERE (deviceId = '" + dev.getId() + "') ORDER BY dtWork DESC, timeEnd DESC, timeBegin DESC";
        System.out.println("getDeviceTimeWorkLast - SQL:" + sql);
        rs = selectDb(sql);
        try {

            while (rs.next()) {
                devLastWork.setDeviceId(rs.getString(1));
                devLastWork.setDtWork(rs.getDate(2));
                devLastWork.setTimeBegin(rs.getTime(3));
                devLastWork.setTimeEnd(rs.getTime(4));
            }

            if (devLastWork.getDeviceId().equals("")) {
                return devLastWork;
            }

            if (devLastWork.getTimeEnd().toString().equals("00:00:00")) {
                System.out.println("1 Девайс : " + devLastWork.getDeviceId() + "Время работы начало: " + devLastWork.getTimeBegin());
                setDeviceTimeWorkEnd(devLastWork, dev);
                getDeviceTimeWorkLast(dev);
            }

        } catch (SQLException ex) {
            System.out.println("ServerDb:getDeviceTimeWorkLast():Ошибка подключения или создание Statement");
        }
        return devLastWork;
    }
    //Вызываем если время конца работы на устройсве не заполнено

    public void setDeviceTimeWorkEnd(DeviceTimeWork devLastWork, Device dev) {
        sql = "UPDATE DeviceTimeWork "
                + "SET timeEnd = "
                + "ISNULL("
                + "(SELECT TOP(1) time FROM PackageDate WHERE deviceId = '" + devLastWork.getDeviceId() + "' AND (date = '" + devLastWork.getDtWork() + "') AND (time >= '" + devLastWork.getTimeBegin() + "') and ISNULL(input2,0) = 0 ORDER BY time),"
                + "'" + devLastWork.getDtWork() + "') "
                //+ "'23:59:59') "
                + "WHERE  deviceId = '" + devLastWork.getDeviceId() + "' ANd dtWork = '" + devLastWork.getDtWork() + "' And timeBegin = '" + devLastWork.getTimeBegin() + "'";
        System.out.println("setDeviceTimeWorkEnd - SQL : " + sql);
        if (updateDb(sql) > 0) {
            System.out.println("Обновлено удачно!");
            getDeviceTimeWorkLast(dev);

        };

    }

    public String getGPSKoordinats(String deviceId) {
        String koordinat = "";
        sql = " SELECT TOP 1 [lat] + ';' + [lon] FROM [UltraFiolet].[dbo].[PackageDate] WHERE deviceId = '" + deviceId + "' AND [lat] NOT LIKE 'NA,NA' AND [lon] NOT LIKE 'NA,NA' ORDER BY date DESC ,time DESC";
        rs = selectDb(sql);
        try {
            while (rs.next()) {
                koordinat = rs.getString(1);
            }

        } catch (SQLException ex) {
            System.out.println("ServerDb:getGPSKoordinats():Ошибка подключения или создание Statement");
        }

        return koordinat;
    }

    public String getCellKoordinats(String deviceId) {
        String koordinat = "";
        sql = " SELECT TOP 1 [params] FROM [UltraFiolet].[dbo].[PackageDate] WHERE deviceId = '" + deviceId + "' ORDER BY date DESC ,time DESC";
        rs = selectDb(sql);
        try {
            while (rs.next()) {
                koordinat = rs.getString(1);
            }

        } catch (SQLException ex) {
            System.out.println("ServerDb:getCellKoordinats():Ошибка подключения или создание Statement");
        }

        return koordinat;
    }
//работа с контактами

    public ResultSet getKontakt() {
        sql = "SELECT    '1' as Код, '1' as Имя, '1' as Телефон, '1' as [e-mail] "
                + " FROM  dKontakt WHERE idKontackt = -101";
        return selectDb(sql);
    }

    public ArrayList<DKontakt> getKontakt(int idKontr) {
        ResultSet rsQ;
        ArrayList<DKontakt> kontrArr = new ArrayList<>();
        DKontakt kontrEdit;
        sql = "SELECT    dKontakt.idKontackt, dKontakt.nameKontakt, dKontakt.telKontakt, dKontakt.emailKontakt, dKontrKontakt.idKontr "
                + "FROM  dKontakt INNER JOIN "
                + "      dKontrKontakt ON dKontakt.idKontackt = dKontrKontakt.idKontackt "
                + "WHERE (dKontrKontakt.idKontr = " + idKontr + ")";
        rsQ = selectDb(sql);
        try {
            while (rsQ.next()) {
                kontrEdit = new DKontakt(rsQ.getInt(1), rsQ.getString(2), rsQ.getString(3), rsQ.getString(4));
                kontrArr.add(kontrEdit);
            }
        } catch (SQLException ex) {
            System.out.println("ServerDb:getKontakt():Ошибка подключения или создание Statement - " + ex + " sql: " + sql);
        }
        return kontrArr;
    }

    public int setKontakt(DKontakt kont, int idKont) {
        int rez = 0;
        sql = "INSERT INTO dKontakt "
                + "       (nameKontakt, telKontakt, emailKontakt)\n"
                + "VALUES ('" + kont.getNameKontakt() + "','" + kont.getTelKontakt() + "','" + kont.getEmailKontakt() + "')";

        rez = insertDb(sql);

        sql = "INSERT INTO dKontrKontakt "
                + "       (idKontackt, idKontr) "
                + "VALUES ((SELECT MAX(idKontackt) FROM dKontakt)," + idKont + ")";

        rez = insertDb(sql);

        return rez;

    }

    public int updKontakt(DKontakt kont, int idKont) {
        int rez = 0;

        sql = "UPDATE       dKontakt "
                + "SET nameKontakt ='" + kont.getNameKontakt() + "', telKontakt ='" + kont.getTelKontakt() + "', emailKontakt ='" + kont.getEmailKontakt() + "' "
                + "WHERE idKontackt = " + kont.getIdKontackt() + "";

        rez = updateDb(sql);

        return rez;

    }

    public DKontakt getKont(int idKontakt) {

        DKontakt kont = null;
        ResultSet rsQ;
        sql = "SELECT        idKontackt, nameKontakt, telKontakt, emailKontakt "
                + "FROM            dKontakt "
                + "WHERE        (idKontackt = " + idKontakt + ")";
        rsQ = selectDb(sql);
        try {
            while (rsQ.next()) {
                kont = new DKontakt(rsQ.getInt(1), rsQ.getString(2), rsQ.getString(3), rsQ.getString(4));
            }
        } catch (SQLException ex) {
            System.out.println("ServerDb:getKont():Ошибка подключения или создание Statement - " + ex + " sql: " + sql);
        }
        return kont;
    }

//работа с контрагентом
    public ResultSet getDKontr() {
        sql = "SELECT idKontr AS Код, userNameKontr AS Наименование, urNameKontr AS [Полное наименование], innKontr AS ИНН, kppKontr AS КПП, adressKontr AS Адрес FROM dKontr ORDER BY userNameKontr";
        return selectDb(sql);
    }

    public ResultSet getDKontr(String nameKontr) {
        sql = "SELECT idKontr AS Код, userNameKontr AS Наименование, urNameKontr AS [Полное наименование], innKontr AS ИНН, kppKontr AS КПП, adressKontr AS Адрес FROM dKontr WHERE userNameKontr like N'%" + nameKontr + "%' ORDER BY userNameKontr";
        return selectDb(sql);
    }

    public ResultSet getDKontrUr(String nameKontr) {
        sql = "SELECT idKontr AS Код, userNameKontr AS Наименование, urNameKontr AS [Полное наименование], innKontr AS ИНН, kppKontr AS КПП, adressKontr AS Адрес FROM dKontr WHERE urNameKontr like N'%" + nameKontr + "%' ORDER BY userNameKontr";
        return selectDb(sql);
    }

    public DKontr getKontr(int idKontr) {

        DKontr kontr = new DKontr();
        ResultSet rsQ;
        sql = "SELECT idKontr AS Код, userNameKontr AS Наименование, urNameKontr AS [Полное наименование], innKontr AS ИНН, kppKontr AS КПП, adressKontr AS Адрес FROM dKontr WHERE idKontr = " + idKontr + "";
        rsQ = selectDb(sql);
        try {
            while (rsQ.next()) {
                kontr.setIdKontr(rsQ.getInt(1));
                kontr.setUserNameKontr(rsQ.getString(2));
                kontr.setUrNameKontr(rsQ.getString(3));
                kontr.setInnKontr(rsQ.getString(4));
                kontr.setKppKontr(rsQ.getString(5));
                kontr.setAdressKontr(rsQ.getString(6));
                kontr.setKontArr(getKontakt(rsQ.getInt(1)));
            }
        } catch (SQLException ex) {
            System.out.println("ServerDb:getKontr():Ошибка подключения или создание Statement - " + ex + " sql: " + sql);
        }
        return kontr;
    }

    public int setKontr(DKontr kontr) {
        sql = "INSERT INTO dKontr \n"
                + "       (userNameKontr, urNameKontr, innKontr, kppKontr, adressKontr) \n"
                + "VALUES ('" + kontr.getUserNameKontr() + "','" + kontr.getUrNameKontr() + "','" + kontr.getInnKontr() + "','" + kontr.getKppKontr() + "','" + kontr.getAdressKontr() + "')";
        return insertDb(sql);
    }

    public int updKontr(DKontr kontr) {
        sql = "UPDATE dKontr "
                + "SET userNameKontr = '" + kontr.getUserNameKontr() + "', urNameKontr = '" + kontr.getUrNameKontr() + "', innKontr = '" + kontr.getInnKontr() + "', kppKontr = '" + kontr.getKppKontr() + "' WHERE idKontr = " + kontr.getIdKontr() + "";
        return updateDb(sql);
    }

    public DKontr[] getKontrArr() {
        int countRec = 0;
        DKontr kontrEdit;
        sql = "SELECT COUNT(*) FROM dKontr ";
        selectDb(sql);
        try {
            while (rs.next()) {
                countRec = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("ServerDb:getKontrArr():Ошибка подключения или создание Statement(метод подсчета кол-ва записей в таблице Контрагентов) - " + ex + " sql: " + sql);
        }

        if (countRec == 0) {
            return new DKontr[0];
        }
        //System.out.println("Количество записей - " + countRec);
        DKontr[] arrKontr = new DKontr[countRec];

        try {
            sql = "SELECT idKontr AS Код, userNameKontr AS Наименование FROM dKontr ORDER BY userNameKontr";
            rs = selectDb(sql);
            while (rs.next()) {
                //System.out.println("Получаем с базы : " + rs.getString(2));
                kontrEdit = new DKontr(new Integer(rs.getInt(1)), rs.getString(2));
                arrKontr[countRec - 1] = kontrEdit;
                countRec = countRec - 1;
            }
        } catch (SQLException ex) {
            System.out.println("ServerDb:getKontrArr():Ошибка подключения или создание Statement(метод заполнения массива Контрагентов) - " + ex + " sql: " + sql);
        }

//        for (DKontr o : arrKontr) {
//            System.out.println("Контрагент - " + o);
//        }
        return arrKontr;
    }
//работа с договорами

    public int setDogovor(DDogovor dog) {
        sql = "INSERT INTO dDogovor \n"
                + "       (idKontr, idUslovie, idVidOplat, dtBegin, dtEnd, nameDogovor, flclose, prim)"
                + "VALUES (" + dog.getKontr().getIdKontr() + "," + dog.getSUslovieDogovor().getIdUslovie() + "," + dog.getSVidOplat().getIdVidOplat() + ",'" + dog.getDtBegin() + "','" + dog.getDtEnd() + "','" + dog.getNameDogovor() + "','" + dog.getFlclose() + "','" + dog.getPrim() + "')";
        System.out.println("SQL - " + sql);
        return insertDb(sql);
    }

    public int updDogovor(DDogovor dog) {
        sql = "UPDATE dDogovor "
                + " SET  idKontr = " + dog.getKontr().getIdKontr() + ", idUslovie =  " + dog.getSUslovieDogovor().getIdUslovie() + ", idVidOplat = " + dog.getSVidOplat().getIdVidOplat() + ", dtBegin = '" + dog.getDtBegin() + "', dtEnd = '" + dog.getDtEnd() + "', nameDogovor = '" + dog.getNameDogovor() + "', flclose = '" + dog.getFlclose() + "', prim = '" + dog.getPrim() + "'   WHERE idDogovor = " + dog.getIdDogovor() + "";
        return updateDb(sql);
    }

    public ResultSet getDDogovor() {
        sql = "SELECT        dDogovor.idDogovor AS Код, dDogovor.nameDogovor AS Наименование, dKontr.userNameKontr AS Контрагент, dDogovor.dtBegin AS [Дата начала], dDogovor.dtEnd AS [Дата окончания], \n"
                + "                         sVidOplat.nameVidOplat AS [Вид оплаты], sUslovieDogovor.nameUslovie AS [Условия оплаты], CASE WHEN ISNULL(dDogovor.flclose,0) = 0 THEN 'Нет' ELSE 'Да' END AS Закрыт, dDogovor.prim\n"
                + "FROM            dDogovor LEFT OUTER JOIN\n"
                + "                         dKontr ON dDogovor.idKontr = dKontr.idKontr LEFT OUTER JOIN\n"
                + "                         sUslovieDogovor ON dDogovor.idUslovie = sUslovieDogovor.idUslovie LEFT OUTER JOIN\n"
                + "                         sVidOplat ON dDogovor.idVidOplat = sVidOplat.idVidOplat";
        return selectDb(sql);
    }

    public ResultSet getOplata(int idDogovor) {
        sql = "SELECT [id] as Код,nameOborud as Оборудование,[dt] as Дата,[summa] as Сумма FROM [dbo].[dDogOborudOplata] LEFT JOIN dOborud ON dOborud.idOborud = dDogOborudOplata.idOborud WHERE idDogovor = " + idDogovor + "";
        return selectDb(sql);
    }

    public DDogovor getDogovor(int idDog) {
        ResultSet rsQ;
        DDogovor dog = new DDogovor();
        sql = "SELECT idDogovor, idKontr, idUslovie, idVidOplat, dtBegin, dtEnd, nameDogovor, flclose, prim FROM dDogovor WHERE idDogovor = " + idDog + "";
        rsQ = selectDb(sql);
        try {
            while (rsQ.next()) {
                dog.setIdDogovor(rsQ.getInt(1));
                dog.setKontr(getKontr(rsQ.getInt(2)));

                int idUslovie = rsQ.getInt(3);

                for (SUslovieDogovor usl : getSUslovie()) {
                    if (usl.getIdUslovie() == idUslovie) {
                        dog.setSUslovieDogovor(usl);
                        break;
                    }
                }

                int idVidOplat = rsQ.getInt(4);

                for (SVidOplat opl : getSVidOplat()) {
                    if (opl.getIdVidOplat() == idVidOplat) {
                        dog.setSVidOplat(opl);
                        break;
                    }
                }

                dog.setDtBegin(rsQ.getDate(5));
                dog.setDtEnd(rsQ.getDate(6));
                dog.setNameDogovor(rsQ.getString(7));
                dog.setFlclose(rsQ.getBoolean(8));
                dog.setPrim(rsQ.getString(9));

            }
        } catch (SQLException ex) {
            System.out.println("ServerDb:getDogovor():Ошибка подключения или создание Statement - " + ex + " sql: " + sql);
        }

        return dog;
    }

    public SVidOplat[] getSVidOplat() {

        int countRec = 0;
        SVidOplat vidOplatEdit;

        sql = "SELECT [idVidOplat],[nameVidOplat] FROM [dbo].[sVidOplat] ORDER BY [idVidOplat] DESC";
        selectDb(sql);

        try {
            while (rs.next()) {
                countRec = countRec + 1;
            }
        } catch (SQLException ex) {
            System.out.println("ServerDb:getSVidOplat():Ошибка подключения или создание Statement(метод подсчета кол-ва записей в таблице Оплат) - " + ex + " sql: " + sql);
        }

        if (countRec == 0) {
            return new SVidOplat[0];
        }

        SVidOplat[] arrVidOplat = new SVidOplat[countRec];

        try {

            selectDb(sql);

            while (rs.next()) {
                //System.out.println("Получаем с базы : " + rs.getString(2));
                vidOplatEdit = new SVidOplat(new Integer(rs.getInt(1)), rs.getString(2));
                arrVidOplat[countRec - 1] = vidOplatEdit;
                countRec = countRec - 1;
            }
        } catch (SQLException ex) {
            System.out.println("ServerDb:getSVidOplat():Ошибка подключения или создание Statement(метод заполнения массива Оплат) - " + ex + " sql: " + sql);
        }

//        for (SVidOplat o : arrVidOplat) {
//            System.out.println("Вид оплаты - " + o);
//        }
        return arrVidOplat;
    }

    public SUslovieDogovor[] getSUslovie() {
        int countRec = 0;
        SUslovieDogovor uslovieEdit;
        sql = "SELECT COUNT(*) FROM sUslovieDogovor";
        selectDb(sql);
        try {
            while (rs.next()) {
                countRec = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("ServerDb:getUslovie():Ошибка подключения или создание Statement(метод подсчета кол-ва записей в таблице Условия договора) - " + ex + " sql: " + sql);
        }

        if (countRec == 0) {
            return new SUslovieDogovor[0];
        }
        //System.out.println("Количество записей - " + countRec);
        SUslovieDogovor[] arrUslovieDogovor = new SUslovieDogovor[countRec];

        try {
            sql = "SELECT [idUslovie] as Код,[nameUslovie] as Наименование FROM [sUslovieDogovor]";
            rs = selectDb(sql);
            while (rs.next()) {
                //System.out.println("Получаем с базы : " + rs.getString(2));
                uslovieEdit = new SUslovieDogovor(new Integer(rs.getInt(1)), rs.getString(2));
                arrUslovieDogovor[countRec - 1] = uslovieEdit;
                countRec = countRec - 1;
            }
        } catch (SQLException ex) {
            System.out.println("ServerDb:getUslovie():Ошибка подключения или создание Statement(метод заполнения массива Условия договора) - " + ex + " sql: " + sql);
        }

        return arrUslovieDogovor;
    }

    public SUslovieDogovor getSUslovie(int idUslovie) {

        SUslovieDogovor uslovieEdit = null;

        try {
            sql = "SELECT [idUslovie] as Код,[nameUslovie] as Наименование FROM [sUslovieDogovor] WHERE [idUslovie] = " + idUslovie + "";
            rs = selectDb(sql);
            while (rs.next()) {
                uslovieEdit = new SUslovieDogovor(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException ex) {
            System.out.println("ServerDb:getSUslovie():Ошибка подключения или создание Statement(метод заполнения массива Условия договора) - " + ex + " sql: " + sql);
        }

        return uslovieEdit;
    }

    public ResultSet getDDogovorOborud(int idDogovor) {
        sql = "SELECT '1' AS Код,'1' AS Оборудование FROM dDogOborud INNER JOIN dOborud ON dDogOborud.idOborud = dOborud.idOborud WHERE idDogovor = " + idDogovor + "";

        return selectDb(sql);
    }

    public ArrayList<DDogOborud> getDDogOborud(int idDogovor) {

        ArrayList<DDogOborud> arr = new ArrayList<>();
        DDogOborud dogOborud;
        ResultSet rsQ;

        sql = "SELECT        dDogOborud.idDogovor, dDogOborud.idOborud, dDogOborud.kolvo, dDogOborud.dtEndArenda, dDogOborud.gorod, dDogOborud.ulica, dDogOborud.dom, dDogOborud.korp, dDogOborud.office, dDogOborud.prim, "
                + "                         dDogOborud.cenaPoTarif, dDogOborud.idUslovie, dOborud.nameOborud "
                + "FROM            dDogOborud INNER JOIN "
                + "                         dOborud ON dDogOborud.idOborud = dOborud.idOborud WHERE idDogovor = " + idDogovor + "";
        rsQ = selectDb(sql);

        try {
            while (rsQ.next()) {
                dogOborud = new DDogOborud(rsQ.getInt(1), rsQ.getInt(2), rsQ.getInt(3), rsQ.getDate(4), rsQ.getString(5), rsQ.getString(6), rsQ.getString(7), rsQ.getString(8), rsQ.getString(9), rsQ.getString(10), rsQ.getBigDecimal(11));
                dogOborud.setIdUslovie(getSUslovie(rsQ.getInt(12)));
                dogOborud.setNameOborud(rsQ.getString(13));
                arr.add(dogOborud);
            }
        } catch (SQLException ex) {
            System.out.println("ServerDb:getDDogovorOborud():Ошибка подключения или создание Statement - " + ex + " sql: " + sql);
        }

        return arr;
    }

        public DDogOborud[] getDDogOborudList(int idDogovor) {
         
        
        ArrayList<DDogOborud> arr = new ArrayList<>();
        DDogOborud dogOborud;
        ResultSet rsQ;

        sql = "SELECT        dDogOborud.idDogovor, dDogOborud.idOborud, dDogOborud.kolvo, dDogOborud.dtEndArenda, dDogOborud.gorod, dDogOborud.ulica, dDogOborud.dom, dDogOborud.korp, dDogOborud.office, dDogOborud.prim, "
                + "                         dDogOborud.cenaPoTarif, dDogOborud.idUslovie, dOborud.nameOborud "
                + "FROM            dDogOborud INNER JOIN "
                + "                         dOborud ON dDogOborud.idOborud = dOborud.idOborud WHERE idDogovor = " + idDogovor + "";
        rsQ = selectDb(sql);

        try {
            while (rsQ.next()) {
                dogOborud = new DDogOborud(rsQ.getInt(1), rsQ.getInt(2), rsQ.getInt(3), rsQ.getDate(4), rsQ.getString(5), rsQ.getString(6), rsQ.getString(7), rsQ.getString(8), rsQ.getString(9), rsQ.getString(10), rsQ.getBigDecimal(11));
                dogOborud.setIdUslovie(getSUslovie(rsQ.getInt(12)));
                dogOborud.setNameOborud(rsQ.getString(13));
                arr.add(dogOborud);
            }
        } catch (SQLException ex) {
            System.out.println("ServerDb:getDDogovorOborud():Ошибка подключения или создание Statement - " + ex + " sql: " + sql);
        }

        DDogOborud[] obArr = new DDogOborud[arr.size()];
        
            System.out.println("Длина массива - " + arr.size());
        
        
        for(int i = 0; i < arr.size(); i++){
            System.out.println("Оборудование - " + arr.get(i));
            obArr[i] = arr.get(i);
        }
                
        return obArr;
    }
    
    
    
    
    //Работа с событиями
    public int setEvent(Event ev) {
        sql = "INSERT INTO dEvent \n"
                + "(eventId, eventDt, eventSeverityId, eventText, eventTypeId, incEventId, eventStatus) \n"
                + "VALUES (" + ev.getEventId() + ",'" + ev.getEventDt() + "'," + ev.getEventSeverity().getEventSeverityId() + ",'" + ev.getEventText() + "'," + ev.getEventType().getEventTypeId() + "," + ev.getIncId().getIncEventId() + ",'" + ev.isEventStatus() + "')";
        System.out.println("SQLsetEvent - " + sql);
        return insertDb(sql);

    }

    //Работа с оборудованием
    public SGrupOborud[] getSGrupOborud() {

        int countRec = 0;
        SGrupOborud sGrupOborud;

        sql = "SELECT idGrupOborud, nameGrupOborud FROM sGrupOborud ORDER BY idGrupOborud";
        selectDb(sql);

        try {
            while (rs.next()) {
                countRec = countRec + 1;
            }
        } catch (SQLException ex) {
            System.out.println("ServerDb:getSGrupOborud():Ошибка подключения или создание Statement(метод подсчета кол-ва записей в таблице Группы оборудования) - " + ex + " sql: " + sql);
        }

        if (countRec == 0) {
            return new SGrupOborud[0];
        }

        SGrupOborud[] arrGrupOborud = new SGrupOborud[countRec];

        try {

            selectDb(sql);

            while (rs.next()) {
                //System.out.println("Получаем с базы : " + rs.getString(2));
                sGrupOborud = new SGrupOborud(new Integer(rs.getInt(1)), rs.getString(2));
                arrGrupOborud[countRec - 1] = sGrupOborud;
                countRec = countRec - 1;
            }
        } catch (SQLException ex) {
            System.out.println("ServerDb:getSGrupOborud():Ошибка подключения или создание Statement(метод заполнения массива Группы оборудования) - " + ex + " sql: " + sql);
        }

        return arrGrupOborud;
    }

    public SGrupOborud getGrupOborud(int idGrup) {
        SGrupOborud sGrupOborud = null;
        sql = "SELECT idGrupOborud, nameGrupOborud FROM sGrupOborud WHERE idGrupOborud = " + idGrup + " ORDER BY idGrupOborud";
        selectDb(sql);
        try {
            while (rs.next()) {
                sGrupOborud = new SGrupOborud(new Integer(rs.getInt(1)), rs.getString(2));
            }
        } catch (SQLException ex) {
            System.out.println("ServerDb:getSGrupOborud():Ошибка подключения или создание Statement - " + ex + " sql: " + sql);
        }

        return sGrupOborud;
    }

    public ResultSet getDOborud() {
        sql = "SELECT dOborud.idOborud AS Код, dOborud.nameOborud AS [Наименование оборудования], dOborud.deviceId AS Трекер, sGrupOborud.nameGrupOborud AS [Группа оборудования] FROM dOborud LEFT OUTER JOIN sGrupOborud ON dOborud.idGrupOborud = sGrupOborud.idGrupOborud";
        return selectDb(sql);
    }

    public ResultSet getDOborud(int idDogovor, String oborDog) {

        sql = "SELECT dOborud.idOborud AS Код, dOborud.nameOborud AS [Наименование оборудования], dOborud.deviceId AS Трекер, sGrupOborud.nameGrupOborud AS [Группа оборудования] FROM dOborud LEFT OUTER JOIN sGrupOborud ON dOborud.idGrupOborud = sGrupOborud.idGrupOborud WHERE idOborud NOT IN (SELECT idOborud FROM dDogOborud WHERE idDogovor = " + idDogovor + ")";
        if (!oborDog.equals("")) {
            sql = sql + " AND dOborud.idOborud NOT IN (" + oborDog + ")";
        }
        return selectDb(sql);
    }

    public ResultSet getDOborud(String name) {
        sql = "SELECT dOborud.idOborud AS Код, dOborud.nameOborud AS [Наименование оборудования], dOborud.deviceId AS Трекер, sGrupOborud.nameGrupOborud AS [Группа оборудования] FROM dOborud LEFT OUTER JOIN sGrupOborud ON dOborud.idGrupOborud = sGrupOborud.idGrupOborud "
                + "WHERE dOborud.nameOborud LIKE N'%" + name + "%'";
        return selectDb(sql);
    }

//    public ResultSet getDopHarac(int IdOborud) {
//        sql = "SELECT sDopHarac.nameDopHarac AS Наименование, dOborudDopHarac.pokaz AS Показатель FROM dOborudDopHarac INNER JOIN sDopHarac ON dOborudDopHarac.idDopHarac = sDopHarac.idDopHarac WHERE idOborud = " + IdOborud + "";
//        return selectDb(sql);
//    }
//
//    public ResultSet getZamRash(int IdOborud) {
//        sql = "SELECT dOborud.nameOborud AS Расходник, dOborudZamenaRash.dtZam AS [Дт замены], dOborudZamenaRash.kolvo AS [Кол-во], dOborudZamenaRash.pokaz AS Счетчик FROM  dOborudZamenaRash INNER JOIN dOborud ON dOborudZamenaRash.idOborudRas = dOborud.idOborud WHERE (dOborudZamenaRash.idOborud = " + IdOborud + ")";
//        return selectDb(sql);
//    }
    public SDopHarac[] getSDopHarac() {
        int countRec = 0;
        SDopHarac dopHarac;
        sql = "SELECT COUNT(*) FROM sDopHarac";
        selectDb(sql);
        try {
            while (rs.next()) {
                countRec = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("ServerDb:getSDopHarac():Ошибка подключения или создание Statement(метод подсчета кол-ва записей в таблице доп характеристик) - " + ex + " sql: " + sql);
        }

        if (countRec == 0) {
            return new SDopHarac[0];
        }

        SDopHarac[] SDopHaracArr = new SDopHarac[countRec];

        try {
            sql = "SELECT idDopHarac,nameDopHarac FROM sDopHarac";
            rs = selectDb(sql);
            while (rs.next()) {
                //System.out.println("Получаем с базы : " + rs.getString(2));
                dopHarac = new SDopHarac(rs.getInt(1), rs.getString(2));
                SDopHaracArr[countRec - 1] = dopHarac;
                countRec = countRec - 1;
            }
        } catch (SQLException ex) {
            System.out.println("ServerDb:getSDopHarac():Ошибка подключения или создание Statement(метод заполнения массива доп характеристик) - " + ex + " sql: " + sql);
        }

        return SDopHaracArr;
    }

    public int setOborDogovor(DDogOborud obor) {

        sql = "INSERT INTO dDogOborud "
                + "      (idDogovor, idOborud, kolvo, dtEndArenda, gorod, ulica, dom, korp, office, prim, cenaPoTarif, idUslovie) "
                + "VALUES(" + obor.getIdDogovor() + "," + obor.getIdOborud() + "," + obor.getKolvo() + ",'" + obor.getDtEndArenda() + "','" + obor.getGorod() + "','" + obor.getUlica() + "','" + obor.getDom() + "','" + obor.getKorp() + "','" + obor.getOffice() + "','" + obor.getPrim() + "'," + obor.getCenaPoTarif() + "," + obor.getIdUslovie().getIdUslovie() + ")";
        return insertDb(sql);

    }

    public int setOborudDopHarac(DOborudDopHarac dopHarac) {

        sql = "INSERT INTO dOborudDopHarac "
                + "      (idOborud,idDopHarac,pokaz) "
                + "VALUES(" + dopHarac.getIdOborud() + "," + dopHarac.getIdDopHarac().getIdDopHarac() + ",'" + dopHarac.getPokaz() + "')";
        return insertDb(sql);

    }

    public int setOborudZamRash(DOborudZamenaRash zamRash) {

        sql = "INSERT INTO dOborudZamenaRash "
                + "       (idOborud, idOborudRas, dtZam, kolvo, pokaz) "
                + "VALUES (" + zamRash.getIdOborud() + "," + zamRash.getIdOborudRas().getIdOborud() + ",'" + zamRash.getDtZam() + "'," + zamRash.getKolvo() + "," + zamRash.getPokaz() + ")";
        return insertDb(sql);

    }

    public int updOborudDopHarac(DOborudDopHarac dopHarac) {
        sql = "UPDATE dOborudDopHarac "
                + " SET pokaz = '" + dopHarac.getPokaz() + "' "
                + " WHERE idOborud = " + dopHarac.getIdOborud() + " AND idDopHarac = " + dopHarac.getIdDopHarac().getIdDopHarac() + "";
        return insertDb(sql);

    }

    public int updOborudZamRash(DOborudZamenaRash zamRash) {
        sql = "UPDATE dOborudZamenaRash "
                + " SET kolvo = " + zamRash.getKolvo() + ",pokaz = " + zamRash.getPokaz() + ""
                + " WHERE idOborud = " + zamRash.getIdOborud() + " AND idOborudRas = " + zamRash.getIdOborudRas().getIdOborud() + " AND dtZam = '" + zamRash.getDtZam() + "'";
        return updateDb(sql);

    }

    public int updOborDogovor(DDogOborud obor) {

        sql = "UPDATE       dDogOborud "
                + "SET                idDogovor =" + obor.getIdDogovor() + ", idOborud =" + obor.getIdOborud() + ", kolvo =" + obor.getKolvo() + ", dtEndArenda ='" + obor.getDtEndArenda() + "', gorod ='" + obor.getGorod() + "', ulica ='" + obor.getUlica() + "', dom = '" + obor.getDom() + "', korp = '" + obor.getKorp() + "', office = '" + obor.getOffice() + "', prim = '" + obor.getPrim() + "', cenaPoTarif = " + obor.getCenaPoTarif() + ", idUslovie = " + obor.getIdUslovie().getIdUslovie() + "";
        return insertDb(sql);

    }

    public int getOborInDog(int idDogovor, int idOborud) {
        int rezult = 0;
        sql = "SELECT COUNT(*) FROM dDogOborud WHERE (idOborud = " + idOborud + ") AND (idDogovor = " + idDogovor + ")";

        selectDb(sql);
        try {
            while (rs.next()) {
                rezult = rs.getInt(1);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("ServerDb:setDogovor():Ошибка подключения или создание Statement");
        }
        return rezult;
    }

    public int setOborud(DOborud ob) {
        String deviceId = ob.getTreker() == null ? "" : ob.getTreker().getId();
        sql = "INSERT INTO dOborud \n"
                + "       (nameOborud, deviceId, idGrupOborud,sn,inventNum,osnPok,schet) "
                + "VALUES ('" + ob.getNameOborud() + "','" + deviceId + "'," + ob.getIdGrupOborud().getIdGrupOborud() + ",'" + ob.getSn() + "','" + ob.getInventNum() + "','" + ob.getOsnPok() + "','" + ob.getSchet() + "')";
        return insertDb(sql);
    }

    public int updOborud(DOborud ob) {
        String deviceId = ob.getTreker() == null ? "" : ob.getTreker().getId();
        sql = "UPDATE       dOborud "
                + "SET  nameOborud = '" + ob.getNameOborud() + "', deviceId ='" + deviceId + "', idGrupOborud =" + ob.getIdGrupOborud().getIdGrupOborud() + ", "
                + "sn = '" + ob.getSn() + "', inventNum = '" + ob.getInventNum() + "', osnPok = '" + ob.getOsnPok() + "', schet = '" + ob.getSchet() + "'  WHERE idOborud = " + ob.getIdOborud() + "";
        return updateDb(sql);
    }

    public DOborud getOborud(int idOborud) {
        ResultSet rsQ;
        DOborud oborud = new DOborud();
        sql = "SELECT idOborud, nameOborud, ISNULL(deviceId,''), idGrupOborud,sn,inventNum,osnPok,schet FROM dOborud WHERE (idOborud = " + idOborud + ")";
        rsQ = selectDb(sql);
        try {
            while (rs.next()) {
                oborud.setIdOborud(rsQ.getInt(1));
                oborud.setNameOborud(rsQ.getString(2));
                String deviceId = rsQ.getString(3);
                if (!deviceId.equals("")) {
                    Device dev = getDevice(rsQ.getString(3));
                    oborud.setTreker(dev);
                }
                oborud.setIdGrupOborud(getGrupOborud(rsQ.getInt(4)));
                oborud.setSn(rsQ.getString(5));
                oborud.setInventNum(rsQ.getString(6));
                oborud.setOsnPok(rsQ.getString(7));
                oborud.setSchet(rsQ.getString(8));

                oborud.setHaracArr(getOborudDopHarac(rsQ.getInt(1)));
                oborud.setRashArr(getOborudZamenaRash(rsQ.getInt(1)));
            }
        } catch (SQLException ex) {
            System.out.println("ServerDb:getOborud():Ошибка подключения или создание Statement - " + ex + " sql: " + sql);
        }

        return oborud;
    }

    public ArrayList<DOborudDopHarac> getOborudDopHarac(int idOborud) {

        ArrayList<DOborudDopHarac> arr = new ArrayList<>();
        DOborudDopHarac dopHarac;
        ResultSet rsQ;

        sql = "SELECT idOborud, idDopHarac, pokaz "
                + "FROM  dOborudDopHarac "
                + "WHERE idOborud = " + idOborud + "";

        rsQ = selectDb(sql);

        try {
            while (rsQ.next()) {
                dopHarac = new DOborudDopHarac(rsQ.getInt(1), getDopHarac(rsQ.getInt(2)), rsQ.getString(3));
                arr.add(dopHarac);
            }
        } catch (SQLException ex) {
            System.out.println("ServerDb:getOborudDopHarac():Ошибка подключения или создание Statement - " + ex + " sql: " + sql);
        }

        return arr;
    }

    public ArrayList<DOborudZamenaRash> getOborudZamenaRash(int idOborud) {

        ArrayList<DOborudZamenaRash> arr = new ArrayList<>();
        DOborudZamenaRash zamenaResh;
        ResultSet rsQ;

        sql = "SELECT idOborud, idOborudRas, dtZam, kolvo, pokaz "
                + "FROM  dOborudZamenaRash "
                + "WHERE idOborud = " + idOborud + "";

        rsQ = selectDb(sql);

        try {
            while (rsQ.next()) {
                zamenaResh = new DOborudZamenaRash(rsQ.getInt(1), getOborud(rsQ.getInt(2)), rsQ.getDate(3), rsQ.getInt(4), rsQ.getInt(5));
                arr.add(zamenaResh);
            }
        } catch (SQLException ex) {
            System.out.println("ServerDb:getOborudZamenaRash():Ошибка подключения или создание Statement - " + ex + " sql: " + sql);
        }

        return arr;
    }

    public ResultSet getOborudZamenaRash() {

        sql = "SELECT '' as Код, '' as [Расходник], '' as [Дата замены], '' as [Кол-во], '' as Показатель "
                + "FROM  dOborudZamenaRash "
                + "WHERE idOborud = -101";

        return selectDb(sql);
    }

    public ResultSet getOborudDopHarac() {

        sql = "SELECT '' as Код,'' as Характеристика, '' as Показатель "
                + "FROM  dOborudDopHarac "
                + "WHERE idOborud = -101";

        return selectDb(sql);
    }

    public SDopHarac getDopHarac(int idDopHarac) {

        SDopHarac dopHarac = null;

        sql = "SELECT        idDopHarac, nameDopHarac "
                + "FROM            sDopHarac "
                + "WHERE idDopHarac = " + idDopHarac + "";

        selectDb(sql);

        try {
            while (rs.next()) {
                dopHarac = new SDopHarac(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException ex) {
            System.out.println("ServerDb:getDopHarac():Ошибка подключения или создание Statement - " + ex + " sql: " + sql);
        }

        return dopHarac;
    }

    //Справочники
    public ResultSet getSUslovieDogobor() {
        sql = "SELECT [idUslovie] as Код,[nameUslovie] as Наименование FROM [sUslovieDogovor]";
        return selectDb(sql);
    }

    @Override
    public int disconnect() {
        try {
            if (!conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServerDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Constatnts.DISCONNECT;
    }

}
