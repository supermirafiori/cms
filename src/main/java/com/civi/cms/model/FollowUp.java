package com.civi.cms.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
public class FollowUp
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long followUpActionId;
    @ManyToOne
    @JoinColumn(name = "case_id", nullable = false)
    private Case c;
    private String actionDescription;
    private LocalDateTime scheduledDate; // need to check
    private String completionStatus;  //need to check
}
