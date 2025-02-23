package com.civi.cms.model;

public interface AttachmentMetadata {
    Long getAttachmentId();
    String getFileName();
    String getFileType();
    String getDownloadUrl();
}
