package com.paulopsms.email_service.infrastructure.gateways;

import com.paulopsms.email_service.infrastructure.controllers.EmailRequest;
import com.paulopsms.email_service.infrastructure.controllers.EmailResponse;
import com.paulopsms.email_service.domain.entities.email.Email;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface EmailDtoMapper {

    Email toDomain(EmailRequest request);

    EmailResponse toDto(Email domain);
}
