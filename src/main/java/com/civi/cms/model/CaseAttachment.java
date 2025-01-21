package com.civi.cms.model;

import jakarta.persistence.*;

@Entity
public class CaseAttachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attachmentId;

    private String fileName;
    private String fileType;
    private byte[] fileData;

    @ManyToOne
    @JoinColumn(name = "caseId", nullable = false)
    private CaseDetails caseDetails1;
}
