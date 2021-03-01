package com.target.IncidentProject.service;

import com.target.IncidentProject.model.Email;
import com.target.IncidentProject.respository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    public Email emailDetails(){

       return emailRepository.findById(5L).get();
    }

    public void emailDetailsUpdate(Email email){

        emailRepository.saveAndFlush(email);
    }
}
