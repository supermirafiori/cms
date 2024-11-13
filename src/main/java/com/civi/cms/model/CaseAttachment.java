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
    @JoinColumn(name = "case_id", nullable = false)
    private Case c1;
}
