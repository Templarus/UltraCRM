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

public class SGrupOborud{


    private Integer idGrupOborud;
    private String nameGrupOborud;

    public SGrupOborud() {
    }

    public SGrupOborud(Integer idGrupOborud) {
        this.idGrupOborud = idGrupOborud;
    }

    public SGrupOborud(Integer idGrupOborud, String nameGrupOborud) {
        this.idGrupOborud = idGrupOborud;
        this.nameGrupOborud = nameGrupOborud;
    }

    public Integer getIdGrupOborud() {
        return idGrupOborud;
    }

    public void setIdGrupOborud(Integer idGrupOborud) {
        this.idGrupOborud = idGrupOborud;
    }

    public String getNameGrupOborud() {
        return nameGrupOborud;
    }

    public void setNameGrupOborud(String nameGrupOborud) {
        this.nameGrupOborud = nameGrupOborud;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrupOborud != null ? idGrupOborud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SGrupOborud)) {
            return false;
        }
        SGrupOborud other = (SGrupOborud) object;
        if ((this.idGrupOborud == null && other.idGrupOborud != null) || (this.idGrupOborud != null && !this.idGrupOborud.equals(other.idGrupOborud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nameGrupOborud;
    }
    
}
