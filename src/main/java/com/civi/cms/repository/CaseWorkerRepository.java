package com.civi.cms.repository;

import com.civi.cms.model.CaseWorker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CaseWorkerRepository extends JpaRepository<CaseWorker,String> {
    List<CaseWorker> findByIsDeletedFalse();

    List<CaseWorker> findByIsDeletedTrue();

    Optional<CaseWorker> findByEmailAndIsDeletedFalse(String email);
}
