package com.civi.cms.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class CaseDetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long caseId;

    private String caseTitle;
    private String caseDescription;
    private long clientId;
    private CaseStatus caseStatus;
    private String priorityLevel;
    private String riskLevel;
    private String caseCategory;
    private String legalInvolvement;
    private String referralSource;

    private LocalDateTime dateOpened;
    private LocalDateTime dateClosed;
    private LocalDateTime nextReviewDate;

    @OneToMany(mappedBy = "c", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FollowUp> followUps;

    @ElementCollection
    @OneToMany(mappedBy = "caseDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Member> membersInvolved;

    // Relationships
    @OneToMany(mappedBy = "caseDetails1", cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    private List<CaseAttachment> attachments;

    @OneToMany(mappedBy = "caseDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<CaseHistory> caseHistories;

    @ManyToMany
    @JoinTable(
            name = "serviceProvider",
            joinColumns = @JoinColumn(name = "case_id"),
            inverseJoinColumns = @JoinColumn(name = "provider_id")
    )
    private List<ServiceProvider> serviceProviders;

    @ManyToOne
    @JoinColumn(name = "case_worker_id", referencedColumnName = "caseWorkerId")
    private CaseWorker assignedCaseWorker;

    public void setAssignedCaseWorker(CaseWorker assignedCaseWorker) {
        this.assignedCaseWorker = assignedCaseWorker;
    }

    public List<FollowUp> getFollowUps() {
        return followUps;
    }

    public void setFollowUps(List<FollowUp> followUps) {
        this.followUps = followUps;
    }

    public CaseWorker getAssignedCaseWorker() {
        return assignedCaseWorker;
    }

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public String getCaseTitle() {
        return caseTitle;
    }

    public void setCaseTitle(String caseTitle) {
        this.caseTitle = caseTitle;
    }

    public String getCaseDescription() {
        return caseDescription;
    }

    public void setCaseDescription(String caseDescription) {
        this.caseDescription = caseDescription;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }


    public CaseStatus getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(CaseStatus caseStatus) {
        this.caseStatus = caseStatus;
    }

    public String getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(String priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getCaseCategory() {
        return caseCategory;
    }

    public void setCaseCategory(String caseCategory) {
        this.caseCategory = caseCategory;
    }

    public String getLegalInvolvement() {
        return legalInvolvement;
    }

    public void setLegalInvolvement(String legalInvolvement) {
        this.legalInvolvement = legalInvolvement;
    }

    public String getReferralSource() {
        return referralSource;
    }

    public void setReferralSource(String referralSource) {
        this.referralSource = referralSource;
    }

    public LocalDateTime getDateOpened() {
        return dateOpened;
    }

    public void setDateOpened(LocalDateTime dateOpened) {
        this.dateOpened = dateOpened;
    }

    public LocalDateTime getDateClosed() {
        return dateClosed;
    }

    public void setDateClosed(LocalDateTime dateClosed) {
        this.dateClosed = dateClosed;
    }

    public LocalDateTime getNextReviewDate() {
        return nextReviewDate;
    }

    public void setNextReviewDate(LocalDateTime nextReviewDate) {
        this.nextReviewDate = nextReviewDate;
    }

    public List<Member> getMembersInvolved() {
        return membersInvolved;
    }

    public void setMembersInvolved(List<Member> membersInvolved) {
        this.membersInvolved = membersInvolved;
    }

    public List<CaseAttachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<CaseAttachment> attachments) {
        this.attachments = attachments;
    }

    public List<CaseHistory> getCaseHistories() {
        return caseHistories;
    }

    public void setCaseHistories(List<CaseHistory> caseHistories) {
        this.caseHistories = caseHistories;
    }

    public List<ServiceProvider> getServiceProviders() {
        return serviceProviders;
    }

    public void setServiceProviders(List<ServiceProvider> serviceProviders) {
        this.serviceProviders = serviceProviders;
    }

    public enum CaseStatus{
        OPEN,
        IN_PROGRESS,
        HOLD,
        CLOSED
    }
}
