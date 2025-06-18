package com.paulopsms.email_service.infrastructure.gateways;

import com.paulopsms.email_service.application.gateways.EmailRepositoryGateway;
import com.paulopsms.email_service.domain.entities.email.Email;
import com.paulopsms.email_service.infrastructure.persistence.EmailEntity;
import com.paulopsms.email_service.infrastructure.persistence.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailRepositoryGatewayImpl implements EmailRepositoryGateway {

    private final EmailRepository emailRepository;

    private final EmailMapper emailMapper;

    @Autowired
    public EmailRepositoryGatewayImpl(EmailRepository emailRepository, EmailMapper emailMapper) {
        this.emailRepository = emailRepository;
        this.emailMapper = emailMapper;
    }

    @Override
    public Email save(Email email) {
        EmailEntity entity = this.emailMapper.toEntity(email);
        EmailEntity savedEmail = this.emailRepository.save(entity);
        return this.emailMapper.toDomain(savedEmail);
    }
}
