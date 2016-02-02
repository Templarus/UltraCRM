/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultracrm.oborud;

import java.util.Objects;

/**
 *
 * @author EvgenyVart
 */

public class DOborudDopHarac {

    private Integer idOborud;
    private SDopHarac idDopHarac;
    private String pokaz;

    public DOborudDopHarac() {
    
    }

    public DOborudDopHarac(Integer idOborud, SDopHarac idDopHarac, String pokaz) {
        this.idOborud = idOborud;
        this.idDopHarac = idDopHarac;
        this.pokaz = pokaz;
    }

    public Integer getIdOborud() {
        return idOborud;
    }

    public void setIdOborud(Integer idOborud) {
        this.idOborud = idOborud;
    }

    public SDopHarac getIdDopHarac() {
        return idDopHarac;
    }

    public void setIdDopHarac(SDopHarac idDopHarac) {
        this.idDopHarac = idDopHarac;
    }

    
    public String getPokaz() {
        return pokaz;
    }

    public void setPokaz(String pokaz) {
        this.pokaz = pokaz;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.idOborud);
        hash = 19 * hash + Objects.hashCode(this.idDopHarac);
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
        final DOborudDopHarac other = (DOborudDopHarac) obj;
        if (!Objects.equals(this.idOborud, other.idOborud)) {
            return false;
        }
        if (!Objects.equals(this.idDopHarac, other.idDopHarac)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  pokaz;
    }

    
    
    
}
