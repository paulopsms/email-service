package com.paulopsms.email_service.application.gateways;

import com.paulopsms.email_service.domain.entities.email.Email;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepositoryGateway {

    Email save(Email email);
}
