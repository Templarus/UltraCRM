/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultracrm.oborud;

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
    
    public DOborud() {
    }

    public DOborud(Integer idOborud) {
        this.idOborud = idOborud;
    }

    public DOborud(Integer idOborud, String nameOborud) {
        this.idOborud = idOborud;
        this.nameOborud = nameOborud;
    }

    public DOborud(Integer idOborud, String nameOborud, SGrupOborud idGrupOborud, Device treker) {
        this.idOborud = idOborud;
        this.nameOborud = nameOborud;
        this.idGrupOborud = idGrupOborud;
        this.treker = treker;
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
