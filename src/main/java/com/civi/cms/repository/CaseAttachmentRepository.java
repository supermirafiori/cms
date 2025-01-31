package com.civi.cms.repository;

import com.civi.cms.model.CaseAttachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseAttachmentRepository extends JpaRepository<CaseAttachment, Long>
{

}
