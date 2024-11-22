package com.civi.cms.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
public class CaseHistory
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long progressId;
    private long caseId;
    private String progressReport;

    @ManyToOne
    @JoinColumn(name = "case_id", nullable = false)
    private Case c;

    private LocalDateTime reportDate;

    public long getProgressId() {
        return progressId;
    }

    public void setProgressId(long progressId) {
        this.progressId = progressId;
    }

    public long getCaseId() {
        return caseId;
    }

    public void setCaseId(long caseId) {
        this.caseId = caseId;
    }

    public String getProgressReport() {
        return progressReport;
    }

    public void setProgressReport(String progressReport) {
        this.progressReport = progressReport;
    }

    public LocalDateTime getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDateTime reportDate) {
        this.reportDate = reportDate;
    }
}
