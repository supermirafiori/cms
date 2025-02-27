package com.civi.cms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class CaseWorker {
    private String firstName;
    private String lastName;
    @Id
    private String email;
    @Column(nullable = false, unique = true)
   // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "case_worker_id_seq")
    @SequenceGenerator(name = "auto_increment_seq", sequenceName = "auto_increment_seq", allocationSize = 1)

    private long caseWorkerId;  //similar to userId
    private String phoneNumber;
    private String jobTitle;
    private String departmentName;
    private String homeAddress;
    private String officeAddress;
    private List<String> qualification;

    @OneToMany(mappedBy = "assignedCaseWorker", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CaseDetails> caseDetails;

    @Column(nullable = false)
    private boolean isDeleted = false;

}


