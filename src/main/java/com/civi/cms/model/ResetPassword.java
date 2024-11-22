package com.civi.cms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class ResetPassword
{
    @Id
    private String emailAddress;
    private int otp;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }
}
