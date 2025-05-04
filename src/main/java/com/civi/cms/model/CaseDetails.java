package com.civi.cms.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "caseId") // Prevents circular reference
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Getter
@Setter
public class CaseDetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long caseId;

    private String caseTitle;
    private String caseDescription;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id") // foreign key column in CaseDetails table
    @NotFound(action = NotFoundAction.IGNORE) // Add this
    private Client clientDetails;
    private CaseStatus caseStatus;
    private String priorityLevel;
    private String riskLevel;
    private String caseCategory;
    private String legalInvolvement;
    private String referralSource;

    private LocalDateTime dateOpened;
    private LocalDateTime dateClosed;
    private LocalDateTime nextReviewDate;

    private String createdBy;
    private String updatedBy;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "c", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FollowUp> followUps;

    @ElementCollection
    @OneToMany(mappedBy = "caseDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Member> membersInvolved;

    // Relationships
    @JsonIgnore
    @OneToMany(mappedBy = "caseDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<CaseAttachment> attachments;

    private Long attachmentCount;
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

//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinTable(
//            name = "case_worker_assignment",
//            joinColumns = @JoinColumn(name = "case_id"),
//            inverseJoinColumns = @JoinColumn(name = "case_worker_id")
//    )
//    private List<CaseWorker> assignedCaseWorkers = new ArrayList<>();
//    public void addCaseWorker(CaseWorker caseWorker) {
//        assignedCaseWorkers.add(caseWorker);
//        caseWorker.getCaseDetails().add(this);  // Ensure bidirectional update
//    }
    @JsonIgnore
    @OneToMany(mappedBy = "caseDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CaseWorkerAssignment> assignedCaseWorkers = new ArrayList<>();

    public List<CaseWorkerAssignment> getAssignedCaseWorkers() {
        return assignedCaseWorkers;
    }

    public void setAssignedCaseWorkers(List<CaseWorkerAssignment> assignedCaseWorkers) {
        this.assignedCaseWorkers = assignedCaseWorkers;
    }

    public List<FollowUp> getFollowUps() {
        return followUps;
    }

    public void setFollowUps(List<FollowUp> followUps) {
        this.followUps = followUps;
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

    public Client getClient() {
        return clientDetails;
    }

    public void setClient(Client clientId) {
        this.clientDetails = clientId;
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

    public Long getAttachmentCount() {
        return attachmentCount;
    }

    public void setAttachmentCount(Long attachmentCount) {
        this.attachmentCount = attachmentCount;
    }

    public enum CaseStatus{
        OPEN,
        IN_PROGRESS,
        HOLD,
        CLOSED
    }
}
