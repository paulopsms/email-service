package com.paulopsms.email_service.infrastructure.controllers;

public record EmailRequest(String to, String subject, String body) {
}
