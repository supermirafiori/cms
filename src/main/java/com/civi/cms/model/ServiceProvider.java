package com.civi.cms.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ServiceProvider
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "provider_id")
    private int providerId;

    @Column(name = "provider_name")
    private String providerName;

    @Column(name = "phone_number")

    private String phoneNumber;
    @Column(name = "email_address")
    private String emailAddress;

    @ManyToMany(mappedBy = "serviceProviders")
    private List<CaseDetails> caseDetails;

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
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
