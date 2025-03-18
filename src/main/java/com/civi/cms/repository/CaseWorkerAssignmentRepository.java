package com.civi.cms.repository;

import com.civi.cms.model.CaseDetails;
import com.civi.cms.model.CaseWorker;
import com.civi.cms.model.CaseWorkerAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaseWorkerAssignmentRepository extends JpaRepository<CaseWorkerAssignment, Long> {
    boolean existsByCaseDetailsAndCaseWorker(CaseDetails caseDetails, CaseWorker caseWorker);
}

