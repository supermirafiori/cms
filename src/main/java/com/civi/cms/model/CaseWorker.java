package com.civi.cms.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "caseWorkerId") // Prevents circular reference
public class CaseWorker {
    private String firstName;
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long caseWorkerId;
    private String phoneNumber;
    private String jobTitle;
    private String departmentName;
    private String homeAddress;
    private String officeAddress;
    private List<String> qualification;
    @ManyToMany(mappedBy = "assignedCaseWorkers", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<CaseDetails> caseDetails = new ArrayList<>();

    @Column(nullable = false)
    private boolean isDeleted = false;

}


