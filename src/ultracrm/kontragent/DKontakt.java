package ultracrm.kontragent;

/**
 *
 * @author EvgenyVart
 */
public class DKontakt {

    private Integer idKontackt;
    private String nameKontakt;
    private String telKontakt;
    private String emailKontakt;

    public DKontakt() {
    }

    public DKontakt(Integer idKontackt, String nameKontakt, String telKontakt, String emailKontakt) {
        this.idKontackt = idKontackt;
        this.nameKontakt = nameKontakt;
        this.telKontakt = telKontakt;
        this.emailKontakt = emailKontakt;
    }

    
    
    
    public DKontakt(Integer idKontackt) {
        this.idKontackt = idKontackt;
    }

    public Integer getIdKontackt() {
        return idKontackt;
    }

    public void setIdKontackt(Integer idKontackt) {
        this.idKontackt = idKontackt;
    }

    public String getNameKontakt() {
        return nameKontakt;
    }

    public void setNameKontakt(String nameKontakt) {
        this.nameKontakt = nameKontakt;
    }

    public String getTelKontakt() {
        return telKontakt;
    }

    public void setTelKontakt(String telKontakt) {
        this.telKontakt = telKontakt;
    }

    public String getEmailKontakt() {
        return emailKontakt;
    }

    public void setEmailKontakt(String emailKontakt) {
        this.emailKontakt = emailKontakt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKontackt != null ? idKontackt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DKontakt)) {
            return false;
        }
        DKontakt other = (DKontakt) object;
        if ((this.idKontackt == null && other.idKontackt != null) || (this.idKontackt != null && !this.idKontackt.equals(other.idKontackt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ultracrm.kontragent.DKontakt[ idKontackt=" + idKontackt + " ]";
    }

}
