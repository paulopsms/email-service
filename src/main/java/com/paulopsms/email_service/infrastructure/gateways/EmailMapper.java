package com.paulopsms.email_service.infrastructure.gateways;

import com.paulopsms.email_service.domain.entities.email.Email;
import com.paulopsms.email_service.infrastructure.persistence.EmailEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface EmailMapper {

    Email toDomain(EmailEntity entity);

    EmailEntity toEntity(Email domain);
}
