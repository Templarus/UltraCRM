package ultracrm.treker;

import java.util.Objects;

// класс предназначенный для комплексного хранения информации об устройстве в его полях.(сущность)
public class Device {

    private String id = "";
    private int port = 0;
    private boolean connection = false;
    private boolean status = false;
    private String password = "";
    private String tel = "";
    private Integer kod;
    private boolean flGeo;
    private boolean flDisable;

    public Device() {
        this("0000000000000000", 5600, "1234", false, false);
    }

    public Device(String id, int port, String password) {
        this(id, port, password, false, false);
    }

    public Device(String id, int port, String password, boolean connected, boolean status) {
        this.id = id;
        this.port = port;
        this.password = password;
        this.connection = connected;
        this.status = status;
    }

    public Device(String id, int port, String password, String tel, Integer kod, boolean flGeo, boolean flDisable) {
        this.id = id;
        this.port = port;
        this.password = password;
        this.tel = tel;
        this.kod = kod;
        this.flGeo = flGeo;
        this.flDisable = flDisable;
    }

    public Device(String id, int port, String password, String tel, boolean flGeo, boolean flDisable) {
        this.id = id;
        this.port = port;
        this.password = password;
        this.tel = tel;
        this.flGeo = flGeo;
        this.flDisable = flDisable;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getKod() {
        return kod;
    }

    public void setKod(Integer kod) {
        this.kod = kod;
    }

    public boolean isFlGeo() {
        return flGeo;
    }

    public void setFlGeo(boolean flGeo) {
        this.flGeo = flGeo;
    }

    public boolean isFlDisable() {
        return flDisable;
    }

    public void setFlDisable(boolean flDisable) {
        this.flDisable = flDisable;
    }

    public void setConnection(boolean connection) {
        this.connection = connection;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isConnected() {
        return connection;
    }

    public boolean isOnline() {
        return status;
    }

    public String getId() {
        return id;
    }

    public int getPort() {
        return port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Device other = (Device) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
