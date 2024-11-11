package com.civi.cms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
@Entity
public class FollowUp
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long followUpActionId;
    private long caseId;
    private String actionDescription;
    private LocalDateTime scheduledDate; // need to check
    private String completionStatus;  //need to check
}
