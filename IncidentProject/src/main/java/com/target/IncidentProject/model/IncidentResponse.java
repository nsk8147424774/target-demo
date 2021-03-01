package com.target.IncidentProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class IncidentResponse {

    @Id @GeneratedValue
    Long id;
    String userName;
    String incidentDetails;
    String impactType;
    String otherDetails;
    String incidentStatus;

    public IncidentResponse() {
    }

    public IncidentResponse(Long id, String userName, String incidentDetails, String impactType, String otherDetails, String incidentStatus) {
        this.id = id;
        this.userName = userName;
        this.incidentDetails = incidentDetails;
        this.impactType = impactType;
        this.otherDetails = otherDetails;
        this.incidentStatus = incidentStatus;
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

    public String getIncidentStatus() {
        return incidentStatus;
    }

    public void setIncidentStatus(String incidentStatus) {
        this.incidentStatus = incidentStatus;
    }
}
