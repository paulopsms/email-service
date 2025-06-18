package com.paulopsms.email_service.infrastructure.controllers;

public record EmailResponse(String to, String subject, String body) {
}
