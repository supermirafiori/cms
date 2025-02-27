package com.civi.cms.service;
import com.civi.cms.model.CaseWorker;
import com.civi.cms.repository.CaseWorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CaseWorkerService {

    @Autowired
    private CaseWorkerRepository caseWorkerRepository;

    // Create case worker
    public ResponseEntity<?> createCaseWorker(CaseWorker caseWorker) {
        try{
            CaseWorker savedCaseWorker = caseWorkerRepository.save(caseWorker);
            return ResponseEntity.status(201).body(savedCaseWorker); // HTTP 201 Created
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    // Get all active (non-deleted) case workers
    public ResponseEntity<List<CaseWorker>> getAllActiveCaseWorkers() {
        try{
            List<CaseWorker> caseWorkers = caseWorkerRepository.findByIsDeletedFalse();
            return ResponseEntity.ok(caseWorkers); // HTTP 200 OK
        }catch (Exception e){
            return ResponseEntity.status(500).body(null);
        }
    }

    public ResponseEntity<List<CaseWorker>> getAllDeactivatedCaseWorkers() {
        try{
            List<CaseWorker> caseWorkers = caseWorkerRepository.findByIsDeletedTrue();
            return ResponseEntity.ok(caseWorkers); // HTTP 200 OK
        }catch (Exception e){
            return ResponseEntity.status(500).body(null);
        }
    }


    // Get a case worker by email
    public ResponseEntity<CaseWorker> getCaseWorkerByEmail(String email) {
        Optional<CaseWorker> caseWorker = caseWorkerRepository.findByEmailAndIsDeletedFalse(email);
        if(caseWorker.isEmpty()){
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok(caseWorker.get()); // HTTP 200 OK
    }

    // Update case worker
    public ResponseEntity<?> updateCaseWorker(CaseWorker updatedCaseWorker) {
        Optional<CaseWorker> existingCaseWorker = caseWorkerRepository.
                findByEmailAndIsDeletedFalse(updatedCaseWorker.getEmail());
        if (existingCaseWorker.isEmpty()) {
            return ResponseEntity.status(404).body("case worker not found");
        }

        CaseWorker updated = caseWorkerRepository.save(updatedCaseWorker);
        return ResponseEntity.ok(updated); // HTTP 200 OK
    }

    // Soft delete case worker (mark as deleted)
    @Transactional
    public ResponseEntity<String> softDeleteCaseWorker(String email) {
        Optional<CaseWorker> existingCaseWorker = caseWorkerRepository.
                findByEmailAndIsDeletedFalse(email);
        if (existingCaseWorker.isEmpty()) {
            return ResponseEntity.status(404).body("case worker not found");
        }
        CaseWorker c = existingCaseWorker.get();
        c.setDeleted(true);
        caseWorkerRepository.save(c);
        return ResponseEntity.ok("Case worker with email " + email + " has been marked as deleted."); // HTTP 200 OK
    }
}
