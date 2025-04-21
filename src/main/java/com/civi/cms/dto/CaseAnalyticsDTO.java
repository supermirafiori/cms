package com.civi.cms.dto;

public class CaseAnalyticsDTO {
    private long openCount;
    private long closedCount;
    private long inProgressCount;

    public CaseAnalyticsDTO(long openCount, long closedCount, long inProgressCount) {
        this.openCount = openCount;
        this.closedCount = closedCount;
        this.inProgressCount = inProgressCount;
    }

    // Getters and setters
    public long getOpenCount() { return openCount; }
    public void setOpenCount(long openCount) { this.openCount = openCount; }

    public long getClosedCount() { return closedCount; }
    public void setClosedCount(long closedCount) { this.closedCount = closedCount; }

    public long getInProgressCount() { return inProgressCount; }
    public void setInProgressCount(long inProgressCount) { this.inProgressCount = inProgressCount; }
}

