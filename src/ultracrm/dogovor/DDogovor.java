/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultracrm.dogovor;

import java.sql.Date;
import ultracrm.kontragent.DKontr;

public class DDogovor {
    private DKontr kontr;
    private Integer idDogovor;
    private Date dtBegin;
    private Date dtEnd;
    private String nameDogovor;
    private boolean flclose;
    private SUslovieDogovor sUslovieDogovor;
    private SVidOplat sVidOplat;
    private String prim;

    public DDogovor() {
    }

    public DDogovor(Integer idDogovor) {
        this.idDogovor = idDogovor;
    }

    public DDogovor(Integer idDogovor, Date dtBegin, Date dtEnd, boolean flclose) {
        this.idDogovor = idDogovor;
        this.dtBegin = dtBegin;
        this.dtEnd = dtEnd;
        this.flclose = flclose;
    }


    public DDogovor(DKontr kontr, Date dtBegin, Date dtEnd, String nameDogovor, boolean flclose, SUslovieDogovor sUslovieDogovor, SVidOplat sVidOplat, String prim) {
        this.kontr = kontr;
        this.dtBegin = dtBegin;
        this.dtEnd = dtEnd;
        this.nameDogovor = nameDogovor;
        this.flclose = flclose;
        this.sUslovieDogovor = sUslovieDogovor;
        this.sVidOplat = sVidOplat;
        this.prim = prim;
    }

    public DDogovor(Integer idDogovor,DKontr kontr, Date dtBegin, Date dtEnd, String nameDogovor, boolean flclose, SUslovieDogovor sUslovieDogovor, SVidOplat sVidOplat, String prim) {
        this.idDogovor = idDogovor;
        this.kontr = kontr;
        this.dtBegin = dtBegin;
        this.dtEnd = dtEnd;
        this.nameDogovor = nameDogovor;
        this.flclose = flclose;
        this.sUslovieDogovor = sUslovieDogovor;
        this.sVidOplat = sVidOplat;
        this.prim = prim;
    }
    
    
    
    public DKontr getKontr() {
        return kontr;
    }

    public void setKontr(DKontr kontr) {
        this.kontr = kontr;
    }

    
    
    public Integer getIdDogovor() {
        return idDogovor;
    }

    public void setIdDogovor(Integer idDogovor) {
        this.idDogovor = idDogovor;
    }

    public Date getDtBegin() {
        return dtBegin;
    }

    public void setDtBegin(Date dtBegin) {
        this.dtBegin = dtBegin;
    }

    public Date getDtEnd() {
        return dtEnd;
    }

    public void setDtEnd(Date dtEnd) {
        this.dtEnd = dtEnd;
    }

    public String getNameDogovor() {
        return nameDogovor;
    }

    public void setNameDogovor(String nameDogovor) {
        this.nameDogovor = nameDogovor;
    }

    public boolean getFlclose() {
        return flclose;
    }

    public void setFlclose(boolean flclose) {
        this.flclose = flclose;
    }

    public SUslovieDogovor getSUslovieDogovor() {
        return sUslovieDogovor;
    }

    public void setSUslovieDogovor(SUslovieDogovor sUslovieDogovor) {
        this.sUslovieDogovor = sUslovieDogovor;
    }

    public SVidOplat getSVidOplat() {
        return sVidOplat;
    }

    public void setSVidOplat(SVidOplat sVidOplat) {
        this.sVidOplat = sVidOplat;
    }

    public String getPrim() {
        return prim;
    }

    public void setPrim(String prim) {
        this.prim = prim;
    }

    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDogovor != null ? idDogovor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DDogovor)) {
            return false;
        }
        DDogovor other = (DDogovor) object;
        if ((this.idDogovor == null && other.idDogovor != null) || (this.idDogovor != null && !this.idDogovor.equals(other.idDogovor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nameDogovor;
    }
    
}
