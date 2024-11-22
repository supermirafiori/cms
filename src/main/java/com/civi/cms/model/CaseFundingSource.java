package com.civi.cms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CaseFundingSource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long fundingSourceId;
    private long caseId;
    private String fundingSourceName;
    private int amountAllocated;

    public long getFundingSourceId() {
        return fundingSourceId;
    }

    public void setFundingSourceId(long fundingSourceId) {
        this.fundingSourceId = fundingSourceId;
    }

    public long getCaseId() {
        return caseId;
    }

    public void setCaseId(long caseId) {
        this.caseId = caseId;
    }

    public String getFundingSourceName() {
        return fundingSourceName;
    }

    public void setFundingSourceName(String fundingSourceName) {
        this.fundingSourceName = fundingSourceName;
    }

    public int getAmountAllocated() {
        return amountAllocated;
    }

    public void setAmountAllocated(int amountAllocated) {
        this.amountAllocated = amountAllocated;
    }
}