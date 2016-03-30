/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultracrm.dogovor;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;



/**
 *
 * @author Evgeny_Vart
 */

public class DDogOborudOplata {

 
    private Integer id;
    private Integer idOborud;
    private Integer idDogovor;
    private Date dt;
    private BigDecimal summa;

    public DDogOborudOplata(Integer idOborud, Integer idDogovor, Date dt, BigDecimal summa) {
        this.idOborud = idOborud;
        this.idDogovor = idDogovor;
        this.dt = dt;
        this.summa = summa;
    }

    public DDogOborudOplata(Integer id, Integer idOborud, Integer idDogovor, Date dt, BigDecimal summa) {
        this.id = id;
        this.idOborud = idOborud;
        this.idDogovor = idDogovor;
        this.dt = dt;
        this.summa = summa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdOborud() {
        return idOborud;
    }

    public void setIdOborud(Integer idOborud) {
        this.idOborud = idOborud;
    }

    public Integer getIdDogovor() {
        return idDogovor;
    }

    public void setIdDogovor(Integer idDogovor) {
        this.idDogovor = idDogovor;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    public BigDecimal getSumma() {
        return summa;
    }

    public void setSumma(BigDecimal summa) {
        this.summa = summa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.idOborud);
        hash = 13 * hash + Objects.hashCode(this.idDogovor);
        hash = 13 * hash + Objects.hashCode(this.dt);
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
        final DDogOborudOplata other = (DDogOborudOplata) obj;
        if (!Objects.equals(this.idOborud, other.idOborud)) {
            return false;
        }
        if (!Objects.equals(this.idDogovor, other.idDogovor)) {
            return false;
        }
        if (!Objects.equals(this.dt, other.dt)) {
            return false;
        }
        return true;
    }

    
    
    
}
