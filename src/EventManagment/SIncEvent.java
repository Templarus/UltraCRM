
package EventManagment;

/**
 *
 * @author EvgenyVart
 */

public class SIncEvent {

   
    private Integer incEventId;
    private String incEventName;

    public SIncEvent() {
    }

    public SIncEvent(Integer incEventId) {
        this.incEventId = incEventId;
    }

    public SIncEvent(Integer incEventId, String incEventName) {
        this.incEventId = incEventId;
        this.incEventName = incEventName;
    }

    public Integer getIncEventId() {
        return incEventId;
    }

    public void setIncEventId(Integer incEventId) {
        this.incEventId = incEventId;
    }

    public String getIncEventName() {
        return incEventName;
    }

    public void setIncEventName(String incEventName) {
        this.incEventName = incEventName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (incEventId != null ? incEventId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SIncEvent)) {
            return false;
        }
        SIncEvent other = (SIncEvent) object;
        if ((this.incEventId == null && other.incEventId != null) || (this.incEventId != null && !this.incEventId.equals(other.incEventId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return incEventName;
    }
    
}
