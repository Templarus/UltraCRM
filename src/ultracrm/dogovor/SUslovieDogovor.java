/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultracrm.dogovor;



/**
 *
 * @author EvgenyVart
 */

public class SUslovieDogovor {


    private Integer idUslovie;
    private String nameUslovie;

    public SUslovieDogovor() {
    }

    public SUslovieDogovor(Integer idUslovie) {
        this.idUslovie = idUslovie;
    }

    public SUslovieDogovor(Integer idUslovie, String nameUslovie) {
        this.idUslovie = idUslovie;
        this.nameUslovie = nameUslovie;
    }

    public Integer getIdUslovie() {
        return idUslovie;
    }

    public void setIdUslovie(Integer idUslovie) {
        this.idUslovie = idUslovie;
    }

    public String getNameUslovie() {
        return nameUslovie;
    }

    public void setNameUslovie(String nameUslovie) {
        this.nameUslovie = nameUslovie;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUslovie != null ? idUslovie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SUslovieDogovor)) {
            return false;
        }
        SUslovieDogovor other = (SUslovieDogovor) object;
        if ((this.idUslovie == null && other.idUslovie != null) || (this.idUslovie != null && !this.idUslovie.equals(other.idUslovie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nameUslovie;
    }
    
}
