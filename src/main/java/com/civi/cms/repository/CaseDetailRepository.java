package com.civi.cms.repository;
import com.civi.cms.model.CaseDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
    public interface CaseDetailRepository extends JpaRepository<CaseDetails, Long>
    {
        List<CaseDetails> findByCaseStatus(CaseDetails.CaseStatus status);
        List<CaseDetails> findByIsCaseWorkerAssignedFalse();
        //all methods are created by JpaRep
        //line number12 -- that indicates the param used
    }




