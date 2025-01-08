package com.civi.cms.model;

import java.time.LocalDate;

public class Client
{
    private Long clientId;            // Primary Key
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private String clientStatus;
    private String clientEmail;
    private String clientPhoneNumber;
}
