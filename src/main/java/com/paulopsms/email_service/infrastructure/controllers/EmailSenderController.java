package com.paulopsms.email_service.infrastructure.controllers;

import com.paulopsms.email_service.application.usecases.SendEmailUseCase;
import com.paulopsms.email_service.domain.exception.EmailSenderException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/emails")
public class EmailSenderController {


    private final SendEmailUseCase sendEmailUseCase;

    public EmailSenderController(SendEmailUseCase sendEmailUseCase) {
        this.sendEmailUseCase = sendEmailUseCase;
    }

    @PostMapping("send")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request) {
        try {
            this.sendEmailUseCase.sendEmail(request.to(), request.subject(), request.body());
            return ResponseEntity.ok("Email sent successfully!");
        } catch (Exception e) {
            throw new EmailSenderException("Error ocurred while sending email: " + e.getMessage());
        }
    }
}
