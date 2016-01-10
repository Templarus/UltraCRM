/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultracrm.kontragent;

public class DKontr {

    private Integer idKontr;
    private String userNameKontr;
    private String urNameKontr;
    private String innKontr;
    private String kppKontr;
    private String adressKontr;

    public DKontr(String userNameKontr, String urNameKontr, String innKontr, String kppKontr, String adressKontr) {
        this.userNameKontr = userNameKontr;
        this.urNameKontr = urNameKontr;
        this.innKontr = innKontr;
        this.kppKontr = kppKontr;
        this.adressKontr = adressKontr;
    }

    public DKontr(Integer idKontr, String userNameKontr, String urNameKontr, String innKontr, String kppKontr, String adressKontr) {
        this.idKontr = idKontr;
        this.userNameKontr = userNameKontr;
        this.urNameKontr = urNameKontr;
        this.innKontr = innKontr;
        this.kppKontr = kppKontr;
        this.adressKontr = adressKontr;
    }


    
    
    
    public DKontr() {
    }

    public DKontr(Integer idKontr) {
        this.idKontr = idKontr;
    }

    public DKontr(Integer idKontr, String userNameKontr) {
        this.idKontr = idKontr;
        this.userNameKontr = userNameKontr;
    }

    public Integer getIdKontr() {
        return idKontr;
    }

    public void setIdKontr(Integer idKontr) {
        this.idKontr = idKontr;
    }

    public String getUserNameKontr() {
        return userNameKontr;
    }

    public void setUserNameKontr(String userNameKontr) {
        this.userNameKontr = userNameKontr;
    }

    public String getUrNameKontr() {
        return urNameKontr;
    }

    public void setUrNameKontr(String urNameKontr) {
        this.urNameKontr = urNameKontr;
    }

    public String getInnKontr() {
        return innKontr;
    }

    public void setInnKontr(String innKontr) {
        this.innKontr = innKontr;
    }

    public String getKppKontr() {
        return kppKontr;
    }

    public void setKppKontr(String kppKontr) {
        this.kppKontr = kppKontr;
    }

    public String getAdressKontr() {
        return adressKontr;
    }

    public void setAdressKontr(String adressKontr) {
        this.adressKontr = adressKontr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKontr != null ? idKontr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DKontr)) {
            return false;
        }
        DKontr other = (DKontr) object;
        if ((this.idKontr == null && other.idKontr != null) || (this.idKontr != null && !this.idKontr.equals(other.idKontr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return userNameKontr;
    }
    
}
