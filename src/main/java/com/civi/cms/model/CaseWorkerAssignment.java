package com.civi.cms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class CaseWorkerAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "case_id")
    private CaseDetails caseDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "case_worker_id")
    private CaseWorker caseWorker;

    private LocalDateTime assignedDate; // Optional

    // Getters and Setters
}

