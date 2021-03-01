package com.target.IncidentProject.kafka;

import com.target.IncidentProject.model.Email;
import com.target.IncidentProject.respository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KafkaSender {
	
	@Autowired
	private KafkaTemplate<String, Email> kafkaTemplate;

	@Autowired
	private EmailRepository emailRepository;
	
	String kafkaTopic = "TestTopic";
	
	public void send() {

		Optional<Email> email = emailRepository.findById(5L);

	    kafkaTemplate.send(kafkaTopic, email.get());
	}

}
