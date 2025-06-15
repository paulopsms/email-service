package com.paulopsms.email_service.infrastructure.controllers;

import com.paulopsms.email_service.domain.exception.EmailSenderException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvicer {

    @ExceptionHandler(EmailSenderException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> emailSenderExceptionHandler(EmailSenderException ex) {
        return ResponseEntity.internalServerError().body(ex.getMessage());
    }
}
