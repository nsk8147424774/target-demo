package com.target.IncidentProject.controller;

import com.target.IncidentProject.model.Email;
import com.target.IncidentProject.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class emailController {

    @Autowired
    private EmailService emailService;

    @GetMapping(value = "email")
    @ResponseBody
    public Email emailDetails(){

        return emailService.emailDetails();
    }

    @PostMapping(value = "emailUpdate")
    @ResponseBody
    public HttpStatus emailDetailsUpdate(@RequestBody Email email){

        emailService.emailDetailsUpdate(email);

        return HttpStatus.OK;
    }
}
