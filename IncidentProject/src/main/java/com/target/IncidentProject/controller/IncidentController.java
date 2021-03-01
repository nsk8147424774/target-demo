package com.target.IncidentProject.controller;

import com.target.IncidentProject.constants.StatusType;
import com.target.IncidentProject.kafka.KafkaSender;
import com.target.IncidentProject.model.Incident;
import com.target.IncidentProject.model.IncidentResponse;
import com.target.IncidentProject.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class IncidentController {

    @Autowired
    private IncidentService incidentService;

    @Autowired
    private KafkaSender kafkaSender;

    @GetMapping(value = "getIncidents" , produces = "application/json", consumes = "application/json")
    @ResponseBody
    public List<IncidentResponse> getIncidents(){

        List<Incident> lists = incidentService.getIncidents();

        List<IncidentResponse> response = lists.stream().map(list -> new IncidentResponse(list.getId(),list.getUserName(),list.getIncidentDetails(),list.getImpactType(),list.getOtherDetails(), StatusType.getById(list.getStatusTypeId()).getMesage() )).collect(Collectors.toList());

        return response;
    }

    @PostMapping(value = "createIncident" , produces = "application/json", consumes = "application/json")
    @ResponseBody
    public HttpStatus createNewIncident(@RequestBody Incident incident){

        incident.setStatusTypeId(1L);

        incidentService.createNewIncident(incident);

        return HttpStatus.OK;
    }

    @PostMapping(value = "updateIncidentStatus")
    @ResponseBody
    public HttpStatus updateIncidentStatus( @RequestBody Incident incident){

        incidentService.updateIncidentStatus(incident);
        kafkaSender.send();

        return HttpStatus.OK;
    }

}
