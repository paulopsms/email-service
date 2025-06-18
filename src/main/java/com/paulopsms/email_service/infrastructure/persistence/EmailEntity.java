package com.paulopsms.email_service.infrastructure.persistence;

import jakarta.persistence.*;

@Entity
@Table(name = "email")
public class EmailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String to;
    private String subject;
    private String body;
}
