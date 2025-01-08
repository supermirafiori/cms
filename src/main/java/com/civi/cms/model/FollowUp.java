package com.civi.cms.model;

import java.time.LocalDateTime;

public class FollowUp
{
    private long followUpActionId;
    private long caseId;
    private String actionDescription;
    private LocalDateTime scheduledDate; // need to check
    private String completionStatus;  //need to check
}
