package com.example.covidback.exposition.service;

import com.example.covidback.application.models.MailContent;
import org.apache.commons.codec.CharEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailService {

    @Value("${mail.from}")
    private String mailFrom;

    @Value("${mail.to}")
    private String mailTo;

    private JavaMailSender emailSender;

    @Autowired
    public MailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public String sendSimpleMessageConfirmation(MailContent mailContent) throws MessagingException {

        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, CharEncoding.UTF_8);
            String EMAIL_TEXT = "Hello Doctor Ayoub  \n \n \n" +"Email ou numero: "+ mailContent.getAdress()+" \n \n \n"+ "Description : "+ mailContent.getDescription()+" \n";
            message.setSubject("New consultation");
            message.setText(EMAIL_TEXT);
            message.setTo(mailTo);
            message.setFrom(mailFrom);
            emailSender.send(mimeMessage);
            return "success";
        } catch (MailException exception) {
            exception.printStackTrace();
        }
        return "failed";
    }



}
