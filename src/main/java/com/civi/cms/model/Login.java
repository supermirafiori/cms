package com.civi.cms.model;

import java.time.LocalDateTime;

public class Login
{
    private Long userId;               // Primary Key
    private String username;           // Unique identifier for login (e.g., email or username)
    private String hashedPassword;     // Password stored as a hashed value for security
    private String status;             // e.g., Active, Inactive, Suspended
    private LocalDateTime createdAt;
    private LocalDateTime lastModified;
}
