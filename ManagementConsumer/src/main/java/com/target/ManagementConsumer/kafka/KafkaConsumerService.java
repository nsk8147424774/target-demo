package com.target.ManagementConsumer.kafka;

import com.target.ManagementConsumer.model.Email;
import com.target.ManagementConsumer.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

@Service
public final class KafkaConsumerService {

    @Autowired
    private EmailService emailService;

    @KafkaListener(topics = "TestTopic", groupId = "json")
    public void consume(Email email) {

       System.out.println(email.toString());

        emailService.sendmail(email);
    }
}
