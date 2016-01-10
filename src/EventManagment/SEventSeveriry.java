/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EventManagment;

/**
 *
 * @author EvgenyVart
 */

public class SEventSeveriry {

  
    private Integer eventSeverityId;
    private String eventSeverityName;

    public SEventSeveriry() {
    }

    public SEventSeveriry(Integer eventSeverityId) {
        this.eventSeverityId = eventSeverityId;
    }

    public SEventSeveriry(Integer eventSeverityId, String eventSeverityName) {
        this.eventSeverityId = eventSeverityId;
        this.eventSeverityName = eventSeverityName;
    }

    public Integer getEventSeverityId() {
        return eventSeverityId;
    }

    public void setEventSeverityId(Integer eventSeverityId) {
        this.eventSeverityId = eventSeverityId;
    }

    public String getEventSeverityName() {
        return eventSeverityName;
    }

    public void setEventSeverityName(String eventSeverityName) {
        this.eventSeverityName = eventSeverityName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventSeverityId != null ? eventSeverityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SEventSeveriry)) {
            return false;
        }
        SEventSeveriry other = (SEventSeveriry) object;
        if ((this.eventSeverityId == null && other.eventSeverityId != null) || (this.eventSeverityId != null && !this.eventSeverityId.equals(other.eventSeverityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return eventSeverityName;
    }
    
}
