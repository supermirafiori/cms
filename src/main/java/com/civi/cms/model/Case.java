package com.civi.cms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Case
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long casecaseIdId;
    private String caseTitle;
    private String caseDescription;
    private long clientId;
    private String assignedCaseWorker;
    private String caseStatus;
    private String priorityLevel;
    private LocalDateTime dateOpened;   //need to check
    private LocalDateTime dateClosed;   //need to check
    private LocalDateTime nextReviewDate;    //need to check
    private String riskLevel;
    private String attachement;
    // need to check with Dibya,because there needs to be a container here
    private String caseCategory;
    private String legalInvolvement;
    private String referralSource;
    private List<String> familyMembersInvolved;
    private String serviceProvider;



}
