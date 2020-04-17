package com.example.covidback.infra;

import com.example.covidback.application.models.MailContent;
import com.example.covidback.exposition.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class MailController {

    @Autowired
    MailService emailService;

    @PostMapping("/sendMail")
    public String processForgotPasswordForm(@RequestBody MailContent mailContent) throws MessagingException {
        return emailService.sendSimpleMessageConfirmation(mailContent);
    }



}
