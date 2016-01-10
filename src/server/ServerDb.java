package server;

import EventManagment.Event;
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
import ultracrm.dogovor.DDogovor;
import ultracrm.dogovor.SUslovieDogovor;
import ultracrm.dogovor.SVidOplat;
import ultracrm.kontragent.DKontr;
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
//работа с трекерами

    public ResultSet getSTreker() {
        sql = "SELECT deviceId as Устройство, port as Порт, password as Пароль FROM STreker ORDER BY deviceId DESC";
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

    public void updDeviceTimeWork() {

        for (Device dev : getDeviceList()) {
            //Получаем данные по последней работе
            // Date dtLastW = new Date(-2208978000000L);
            //Time timeLastW = new Time(-10800000l);
            //DeviceTimeWork devLastWork = getDeviceTimeWorkLast(dev);
            Date dtLast = new Date(-2208978000000L);
            Time timeLast = new Time(-10800000l);

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
                + "'23:59:59') "
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
//работа с контрагентом
    public ResultSet getDKontr() {
        sql = "SELECT idKontr AS Код, userNameKontr AS Наименование, urNameKontr AS [Полное наименование], innKontr AS ИНН, kppKontr AS КПП, adressKontr AS Адрес FROM dKontr ORDER BY userNameKontr";
        return selectDb(sql);
    }

    public DKontr getKontr(int idKontr) {

        DKontr kontr = new DKontr();
        sql = "SELECT idKontr AS Код, userNameKontr AS Наименование, urNameKontr AS [Полное наименование], innKontr AS ИНН, kppKontr AS КПП, adressKontr AS Адрес FROM dKontr WHERE idKontr = " + idKontr + "";
        rs = selectDb(sql);
        try {
            while (rs.next()) {
                kontr.setIdKontr(rs.getInt(1));
                kontr.setUserNameKontr(rs.getString(2));
                kontr.setUrNameKontr(rs.getString(3));
                kontr.setInnKontr(rs.getString(4));
                kontr.setKppKontr(rs.getString(5));
                kontr.setAdressKontr(rs.getString(6));
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
        sql = "INSERT INTO dDogovor\n"
                + "       (idKontr, idUslovie, idVidOplat, dtBegin, dtEnd, nameDogovor, flclose, prim)"
                + "VALUES (" + dog.getKontr().getIdKontr() + "," + dog.getSUslovieDogovor().getIdUslovie() + "," + dog.getSVidOplat().getIdVidOplat() + ",'" + dog.getDtBegin() + "','" + dog.getDtEnd() + "','" + dog.getNameDogovor() + "','" + dog.getFlclose() + "','" + dog.getPrim() + "')";
        System.out.println("SQL - " + sql);
        return insertDb(sql);

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

//        for (DKontr o : arrKontr) {
//            System.out.println("Контрагент - " + o);
//        }
        return arrUslovieDogovor;
    }

    //Работа с событиями
    public int setEvent(Event ev) {
        sql = "INSERT INTO dEvent \n"
                + "(eventId, eventDt, eventSeverityId, eventText, eventTypeId, incEventId, eventStatus) \n"
                + "VALUES (" + ev.getEventId() + ",'" + ev.getEventDt() + "'," + ev.getEventSeverity().getEventSeverityId() + ",'" + ev.getEventText() + "'," + ev.getEventType().getEventTypeId() + "," + ev.getIncId().getIncEventId() + ",'" + ev.isEventStatus() + "')";
        System.out.println("SQLsetEvent - " + sql);
        return insertDb(sql);

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
