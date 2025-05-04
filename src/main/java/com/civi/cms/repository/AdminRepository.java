package com.civi.cms.repository;

import com.civi.cms.model.AdminUser;
import com.civi.cms.model.CaseWorker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<AdminUser,String> {
    Optional<CaseWorker> findByPhoneNumber(String phoneNumber);
}
