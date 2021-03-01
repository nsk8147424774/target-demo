package com.target.ManagementConsumer.service;

import com.target.ManagementConsumer.model.Email;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

@Service
public class EmailService {

    public void sendmail(Email email) {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email.getEmailFrom(), email.getEmailPassword());
            }
        });

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(email.getEmailFrom(), false));

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getEmialTo()));
            msg.setSubject("Target Demo Project: email sent by Incident application for changing ticket status");
            msg.setContent("Hi  Incident ticket is updated", "text/html");
            msg.setSentDate(new Date());

            Transport.send(msg);
        }
        catch (Exception e){
            System.out.println("Exception occurred wile sending email");
        }

    }
}
