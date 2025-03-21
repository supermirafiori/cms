package com.civi.cms.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class AssignedCaseDTO {
    private Long caseId;
    private LocalDateTime assignedDate;


    public AssignedCaseDTO( Long caseId, LocalDateTime assignedDate) {
        this.caseId = caseId;
        this.assignedDate = assignedDate;
    }

    // Getters and setters
}

