package com.target.IncidentProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

    @RequestMapping(value = "/")
    public String welcomePage(ModelMap model){

        return "welcome";
    }
}
