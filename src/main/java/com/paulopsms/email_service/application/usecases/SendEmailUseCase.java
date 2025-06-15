package com.paulopsms.email_service.application.usecases;

import com.paulopsms.email_service.adapters.EmailSenderGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendEmailUseCase {

    private final EmailSenderGateway emailSenderGateway;

    @Autowired
    public SendEmailUseCase(EmailSenderGateway emailSenderGateway) {
        this.emailSenderGateway = emailSenderGateway;
    }

    public void sendEmail(String to, String subject, String body) {
        this.emailSenderGateway.sendEmail(to, subject, body);
    }
}
