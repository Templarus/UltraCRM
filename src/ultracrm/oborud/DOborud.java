/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultracrm.oborud;

import java.util.ArrayList;
import ultracrm.treker.Device;

/**
 *
 * @author EvgenyVart
 */
public class DOborud {

    private Integer idOborud;
    private String nameOborud;
    private SGrupOborud idGrupOborud;
    private Device treker;
    private String sn = "";
    private String inventNum = "";
    private String osnPok = "";
    private String schet = "";

    private ArrayList<DOborudDopHarac> haracArr;
    private ArrayList<DOborudZamenaRash> rashArr;

    public DOborud() {
    }

    public DOborud(Integer idOborud) {
        this.idOborud = idOborud;
    }

    public DOborud(Integer idOborud, String nameOborud) {
        this.idOborud = idOborud;
        this.nameOborud = nameOborud;
    }

    public DOborud(Integer idOborud, String nameOborud, SGrupOborud idGrupOborud, Device treker, String sn, String inventNum, String osnPok, String schet) {
        this.idOborud = idOborud;
        this.nameOborud = nameOborud;
        this.idGrupOborud = idGrupOborud;
        this.treker = treker;
        this.sn = sn;
        this.inventNum = inventNum;
        this.osnPok = osnPok;
        this.schet = schet;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getInventNum() {
        return inventNum;
    }

    public void setInventNum(String inventNum) {
        this.inventNum = inventNum;
    }

    public String getOsnPok() {
        return osnPok;
    }

    public void setOsnPok(String osnPok) {
        this.osnPok = osnPok;
    }

    public String getSchet() {
        return schet;
    }

    public void setSchet(String schet) {
        this.schet = schet;
    }

    public Integer getIdOborud() {
        return idOborud;
    }

    public void setIdOborud(Integer idOborud) {
        this.idOborud = idOborud;
    }

    public String getNameOborud() {
        return nameOborud;
    }

    public void setNameOborud(String nameOborud) {
        this.nameOborud = nameOborud;
    }

    public SGrupOborud getIdGrupOborud() {
        return idGrupOborud;
    }

    public void setIdGrupOborud(SGrupOborud idGrupOborud) {
        this.idGrupOborud = idGrupOborud;
    }

    public Device getTreker() {
        return treker;
    }

    public void setTreker(Device treker) {
        this.treker = treker;
    }

    public ArrayList<DOborudDopHarac> getHaracArr() {
        return haracArr;
    }

    public void setHaracArr(ArrayList<DOborudDopHarac> haracArr) {
        this.haracArr = haracArr;
    }

    public ArrayList<DOborudZamenaRash> getRashArr() {
        return rashArr;
    }

    public void setRashArr(ArrayList<DOborudZamenaRash> rashArr) {
        this.rashArr = rashArr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOborud != null ? idOborud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DOborud)) {
            return false;
        }
        DOborud other = (DOborud) object;
        if ((this.idOborud == null && other.idOborud != null) || (this.idOborud != null && !this.idOborud.equals(other.idOborud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nameOborud;
    }

}
