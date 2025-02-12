package com.civi.cms.repository;

import ch.qos.logback.core.model.INamedModel;
import com.civi.cms.model.CaseHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseHistoryRepository extends JpaRepository<CaseHistory, Integer> {

}
