package com.paulopsms.email_service.infrastructure.client.aws;

import com.paulopsms.email_service.adapters.EmailSenderGateway;
import com.paulopsms.email_service.domain.exception.EmailSenderException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.ses.SesClient;
import software.amazon.awssdk.services.ses.model.*;

@Service
public class SesEmailSender implements EmailSenderGateway {

    private static final Logger logger = LoggerFactory.getLogger(SesEmailSender.class);


    private final SesClient sesClient;
    private final String sourceEmail;

    @Autowired
    public SesEmailSender(@Value("${aws.ses.region}") String region,
                          @Value("${email.sender.source}") String sourceEmail) {
        this.sesClient = SesClient.builder()
                .region(Region.of(region))
                .build();
        this.sourceEmail = sourceEmail;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        Destination destination = Destination.builder().toAddresses(to).build();

        Message message = Message.builder()
                .subject(Content.builder().data(subject).build())
                .body(Body.builder().text(Content.builder().data(body).build()).build())
                .build();

        SendEmailRequest request = SendEmailRequest.builder()
                .source(sourceEmail)
                .destination(destination)
                .message(message)
                .build();

        try {
            SendEmailResponse result = sesClient.sendEmail(request);
            logger.info("Email sent! Message ID: " + result.messageId());
        } catch (Exception ex) {
            logger.error("The email was not sent.");
            logger.error("Error message: " + ex.getMessage());

            throw new EmailSenderException("Failure while sending email.", ex);
        }
    }
}
