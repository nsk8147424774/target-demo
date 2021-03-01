package com.target.IncidentProject.service;

import com.target.IncidentProject.model.Incident;
import com.target.IncidentProject.respository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncidentService {

    @Autowired
    private IncidentRepository incidentRepository;

    public List<Incident> getIncidents(){

        return incidentRepository.findAll();
    }

    public void createNewIncident(Incident incident){

        incidentRepository.save(incident);
    }

    public void updateIncidentStatus(Incident incident){

        Incident incidentNew = new Incident();
        Optional<Incident> optional = incidentRepository.findById(incident.getId());
        if(optional.isPresent()){
            incidentNew = optional.get();
            incidentNew.setStatusTypeId(incident.getStatusTypeId());

        }

        incidentRepository.save(incidentNew);
    }
}
