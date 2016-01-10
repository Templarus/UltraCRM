/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultracrm.dogovor;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Asus
 */
@Entity
@Table(name = "sUslovieDogovor")
@NamedQueries({
    @NamedQuery(name = "SUslovieDogovor.findAll", query = "SELECT s FROM SUslovieDogovor s")})
public class SUslovieDogovor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idUslovie")
    private Integer idUslovie;
    @Basic(optional = false)
    @Column(name = "nameUslovie")
    private String nameUslovie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sUslovieDogovor")
    private Collection<DDogovor> dDogovorCollection;

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

    public Collection<DDogovor> getDDogovorCollection() {
        return dDogovorCollection;
    }

    public void setDDogovorCollection(Collection<DDogovor> dDogovorCollection) {
        this.dDogovorCollection = dDogovorCollection;
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
