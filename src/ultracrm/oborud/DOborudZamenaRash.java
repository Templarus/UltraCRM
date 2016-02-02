/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultracrm.oborud;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author EvgenyVart
 */

public class DOborudZamenaRash {

    private Integer idOborud;
    private DOborud idOborudRas;
    private Date dtZam;
    private int kolvo;
    private int pokaz;

    public DOborudZamenaRash() {
    }

    public DOborudZamenaRash(Integer idOborud, DOborud idOborudRas, Date dtZam, int kolvo, int pokaz) {
        this.idOborud = idOborud;
        this.idOborudRas = idOborudRas;
        this.dtZam = dtZam;
        this.kolvo = kolvo;
        this.pokaz = pokaz;
    }

    public Integer getIdOborud() {
        return idOborud;
    }

    public void setIdOborud(Integer idOborud) {
        this.idOborud = idOborud;
    }

    public DOborud getIdOborudRas() {
        return idOborudRas;
    }

    public void setIdOborudRas(DOborud idOborudRas) {
        this.idOborudRas = idOborudRas;
    }

    
    public Date getDtZam() {
        return dtZam;
    }

    public void setDtZam(Date dtZam) {
        this.dtZam = dtZam;
    }

    public int getKolvo() {
        return kolvo;
    }

    public void setKolvo(int kolvo) {
        this.kolvo = kolvo;
    }

    public int getPokaz() {
        return pokaz;
    }

    public void setPokaz(int pokaz) {
        this.pokaz = pokaz;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.idOborud);
        hash = 11 * hash + Objects.hashCode(this.idOborudRas);
        hash = 11 * hash + Objects.hashCode(this.dtZam);
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
        final DOborudZamenaRash other = (DOborudZamenaRash) obj;
        if (!Objects.equals(this.idOborud, other.idOborud)) {
            return false;
        }
        if (!Objects.equals(this.idOborudRas, other.idOborudRas)) {
            return false;
        }
        if (!Objects.equals(this.dtZam, other.dtZam)) {
            return false;
        }
        return true;
    }


    
}
