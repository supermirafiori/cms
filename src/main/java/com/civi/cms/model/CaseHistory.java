package com.civi.cms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
@Entity
public class CaseHistory
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long progressId;
    private long caseId;
    private String progressReport;
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
