package com.target.IncidentProject.model;

import javax.persistence.*;

@Entity
@Table(name = "Incident")
public class Incident {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String userName;
    String incidentDetails;
    String impactType;
    String otherDetails;

    Long statusTypeId;

    public Long getStatusTypeId() {
        return statusTypeId;
    }

    public void setStatusTypeId(Long statusTypeId) {
        this.statusTypeId = statusTypeId;
    }
    /*@OneToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;*/


    public Incident() {
    }

    public Incident(String userName, String incidentDetails, String impactType, String otherDetails, Long statusTypeId) {
        this.userName = userName;
        this.incidentDetails = incidentDetails;
        this.impactType = impactType;
        this.otherDetails = otherDetails;
        this.statusTypeId = statusTypeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIncidentDetails() {
        return incidentDetails;
    }

    public void setIncidentDetails(String incidentDetails) {
        this.incidentDetails = incidentDetails;
    }

    public String getImpactType() {
        return impactType;
    }

    public void setImpactType(String impactType) {
        this.impactType = impactType;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

    @Override
    public String toString() {
        return "Incident{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", incidentDetails='" + incidentDetails + '\'' +
                ", impactType='" + impactType + '\'' +
                ", otherDetails='" + otherDetails + '\'' +
                ", statusTypeId=" + statusTypeId +
                '}';
    }
}
