package com.civi.cms.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Client
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;            // Primary Key
    private String firstName;
    private String lastName;
    private String gender;
    private String clientEmail;
    private String clientPhoneNumber;
}
