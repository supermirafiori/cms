package com.civi.cms.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ServiceProvider
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String providerId;
    private String providerName;
    private String phoneNumber;
    private String emailAddress;

    @ManyToMany(mappedBy = "serviceProviders")
    private List<Case> cases;

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
