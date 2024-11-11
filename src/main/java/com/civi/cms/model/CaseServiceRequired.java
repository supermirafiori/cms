package com.civi.cms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CaseServiceRequired
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long serviceRequirementId;
    private long caseId;
    private String serviceName;
    private long serviceProviderId;

    public long getServiceRequirementId() {
        return serviceRequirementId;
    }

    public void setServiceRequirementId(long serviceRequirementId) {
        this.serviceRequirementId = serviceRequirementId;
    }

    public long getCaseId() {
        return caseId;
    }

    public void setCaseId(long caseId) {
        this.caseId = caseId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public long getServiceProviderId() {
        return serviceProviderId;
    }

    public void setServiceProviderId(long serviceProviderId) {
        this.serviceProviderId = serviceProviderId;
    }
}
