package com.civi.cms.repository;

import com.civi.cms.model.AttachmentMetadata;
import com.civi.cms.model.CaseAttachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaseAttachmentRepository extends JpaRepository<CaseAttachment, Long>
{
    long countByCaseDetails_CaseId(Long caseId);
    List<AttachmentMetadata> findByCaseDetails_CaseId(Long caseId);
}
