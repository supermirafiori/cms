package com.civi.cms.model;

import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;


@Getter
@Setter
public class AssignedCaseWorkerDTO {

    private Long caseWorkerId;

    private String firstName;
    private String lastName;

    private String email;
    private String phoneNumber;

    public AssignedCaseWorkerDTO(CaseWorker caseWorker) {
        this.caseWorkerId= caseWorker.getCaseWorkerId();
        this.email= caseWorker.getEmail();
        this.phoneNumber= caseWorker.getPhoneNumber();
        this.firstName= caseWorker.getFirstName();
        this.lastName= caseWorker.getLastName();
    }
}
