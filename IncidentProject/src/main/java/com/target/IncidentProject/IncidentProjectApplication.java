package com.target.IncidentProject;

import com.target.IncidentProject.model.Email;
import com.target.IncidentProject.model.Incident;
import com.target.IncidentProject.respository.EmailRepository;
import com.target.IncidentProject.respository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class IncidentProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(IncidentProjectApplication.class, args);
	}

	@Autowired
	private IncidentRepository incidentRepository;

	@Autowired
	private EmailRepository emailRepository;

	@Override
	public void run(String... args) throws Exception {

		Incident i1 = new Incident("nitish","login issues","low","mobile number", 1L);
		Incident i2 = new Incident("krishna","login issues","high","mobile number: ****",1L);
		Incident i3 = new Incident("guru","app is down","medium","deploy app in cloud",1L);
		Incident i4 = new Incident("mallu","forgotten password","low","call: ****",1L);

		incidentRepository.saveAll(Arrays.asList(i1,i2,i3,i4));

		Email email = new Email(5L, "nsk8147424774@gmail.com", "8147424774", "nsk8147424774@gmail.com");

		emailRepository.save(email);
	}
}
