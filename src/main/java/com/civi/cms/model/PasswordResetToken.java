package com.civi.cms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class PasswordResetToken {

    @Id
    private String email;

    private String otp;

    private LocalDateTime createdAt;

    // Expiry duration: 10 minutes or so
    public boolean isExpired() {
        return createdAt.isBefore(LocalDateTime.now().minusMinutes(10));
    }
}
