/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultracrm.oborud;

/**
 *
 * @author EvgenyVart
 */

public class SDopHarac  {

   
    private Integer idDopHarac;
    private String nameDopHarac;

    public SDopHarac() {
    }

    public SDopHarac(Integer idDopHarac) {
        this.idDopHarac = idDopHarac;
    }

    public SDopHarac(Integer idDopHarac, String nameDopHarac) {
        this.idDopHarac = idDopHarac;
        this.nameDopHarac = nameDopHarac;
    }

    public Integer getIdDopHarac() {
        return idDopHarac;
    }

    public void setIdDopHarac(Integer idDopHarac) {
        this.idDopHarac = idDopHarac;
    }

    public String getNameDopHarac() {
        return nameDopHarac;
    }

    public void setNameDopHarac(String nameDopHarac) {
        this.nameDopHarac = nameDopHarac;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDopHarac != null ? idDopHarac.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof SDopHarac)) {
            return false;
        }
        SDopHarac other = (SDopHarac) object;
        if ((this.idDopHarac == null && other.idDopHarac != null) || (this.idDopHarac != null && !this.idDopHarac.equals(other.idDopHarac))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nameDopHarac;
    }
    
}
