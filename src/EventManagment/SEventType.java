
package EventManagment;

/**
 *
 * @author EvgenyVart
 */
public class SEventType {

  
    private Integer eventTypeId;
    private String eventTypeName;

    public SEventType() {
    }

    public SEventType(Integer eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public SEventType(Integer eventTypeId, String eventTypeName) {
        this.eventTypeId = eventTypeId;
        this.eventTypeName = eventTypeName;
    }

    public Integer getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(Integer eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public String getEventTypeName() {
        return eventTypeName;
    }

    public void setEventTypeName(String eventTypeName) {
        this.eventTypeName = eventTypeName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventTypeId != null ? eventTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SEventType)) {
            return false;
        }
        SEventType other = (SEventType) object;
        if ((this.eventTypeId == null && other.eventTypeId != null) || (this.eventTypeId != null && !this.eventTypeId.equals(other.eventTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return eventTypeName;
    }
    
}
