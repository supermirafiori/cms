package com.civi.cms.model;

import java.time.LocalDateTime;

public class Case
{
    private Long caseId;
    private String caseTitle;
    private String caseDescription;
    private String caseType;
    private long clientId;
    private String assignedCaseWorker;
    private String caseStatus;
    private String priorityLevel;
    private LocalDateTime dateOpened;   //need to check
    private LocalDateTime dateClosed;   //need to check
    private LocalDateTime initialAssessmentDate;  //need to check
    private LocalDateTime nextReviewDate;    //need to check
    private String riskLevel;
    private String caseNotes;
    private String attachement;
    // need to check with Dibya,because there needs to be a container here
    private String caseCategory;
    private String legalInvolvement;
    private String lastUpdated;
    private String referralSource;
    private String familyMembersInvolved;
    private String interventionPlan;
    private String serviceProvider;
    private String collaborators;
    private String confidentialityAlert;


}
