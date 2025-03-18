package com.civi.cms.service;
import com.civi.cms.model.CaseDetails;
import com.civi.cms.model.CaseWorker;
import com.civi.cms.model.CaseWorkerAssignment;
import com.civi.cms.repository.CaseDetailRepository;
import com.civi.cms.repository.CaseWorkerAssignmentRepository;
import com.civi.cms.repository.CaseWorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CaseWorkerService {

    @Autowired
    private CaseWorkerRepository caseWorkerRepository;

    @Autowired
    private CaseDetailRepository caseDetailsRepository;

    @Autowired
    CaseWorkerAssignmentRepository caseWorkerAssignmentRepository;

    // Create case worker
    public ResponseEntity<?> createCaseWorker(CaseWorker caseWorker) {



        return ResponseEntity.ok(caseWorkerRepository.save(caseWorker));


//        try{
//            CaseWorker savedCaseWorker = caseWorkerRepository.save(caseWorker);
//            return ResponseEntity.status(201).body(savedCaseWorker); // HTTP 201 Created
//        }catch (Exception e){
//            return ResponseEntity.status(500).body(e.getMessage());
       // }
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
    public ResponseEntity<CaseWorker> getCaseWorkerByEmail(Long id) {
        Optional<CaseWorker> caseWorker = caseWorkerRepository.findByCaseWorkerIdAndIsDeletedFalse(id);
        if(caseWorker.isEmpty()){
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok(caseWorker.get()); // HTTP 200 OK
    }

    // Update case worker
    public ResponseEntity<?> updateCaseWorker(CaseWorker updatedCaseWorker) {
        Optional<CaseWorker> existingCaseWorker = caseWorkerRepository.
                findByCaseWorkerIdAndIsDeletedFalse(updatedCaseWorker.getCaseWorkerId());
        if (existingCaseWorker.isEmpty()) {
            return ResponseEntity.status(404).body("case worker not found");
        }

        CaseWorker updated = caseWorkerRepository.save(updatedCaseWorker);
        return ResponseEntity.ok(updated); // HTTP 200 OK
    }

    // Soft delete case worker (mark as deleted)
    @Transactional
    public ResponseEntity<String> softDeleteCaseWorker(Long id ) {
        Optional<CaseWorker> existingCaseWorker = caseWorkerRepository.
                findByCaseWorkerIdAndIsDeletedFalse(id);
        if (existingCaseWorker.isEmpty()) {
            return ResponseEntity.status(404).body("case worker not found");
        }
        CaseWorker c = existingCaseWorker.get();
        c.setDeleted(true);
        caseWorkerRepository.save(c);
        return ResponseEntity.ok("case worker deleted successfully"); // HTTP 200 OK
    }

    public ResponseEntity<CaseWorker> getCaseWorkerById(Long id) {
        Optional<CaseWorker> existingCaseWorker = caseWorkerRepository.
                findByCaseWorkerIdAndIsDeletedFalse(id);
        if (existingCaseWorker.isEmpty()) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok(existingCaseWorker.get()); // HTTP 200 OK
    }


//    public ResponseEntity<?> assignCaseWorkerToCase(Long caseid, int workerid) {
//        List<CaseDetails> updatedCaseDetails = new ArrayList<>();
//        Optional<CaseDetails> existingCase = caseDetailsRepository.findById(caseid);
//        if (existingCase.isPresent()) {
//            Optional<CaseWorker> existingCaseWorker = caseWorkerRepository.findById(workerid);
//            if (existingCaseWorker.isPresent()) {
//                CaseWorker worker = existingCaseWorker.get();
//                CaseDetails caseDetails = existingCase.get();
//                caseDetails.addCaseWorker(worker);
//                updatedCaseDetails.add(caseDetails);
//                caseDetailsRepository.saveAll(updatedCaseDetails);
//                return ResponseEntity.ok("Case worker assigned successfully");
//            }
//        }
//        return ResponseEntity.notFound().build();
//    }
public ResponseEntity<?> assignCaseWorkerToCase(Long caseId, int workerId) {
    Optional<CaseDetails> existingCase = caseDetailsRepository.findById(caseId);
    Optional<CaseWorker> existingCaseWorker = caseWorkerRepository.findById(workerId);

    if (existingCase.isPresent() && existingCaseWorker.isPresent()) {
        CaseDetails caseDetails = existingCase.get();
        CaseWorker caseWorker = existingCaseWorker.get();

        // Check if this assignment already exists to prevent duplicates
        boolean alreadyAssigned = caseWorkerAssignmentRepository.existsByCaseDetailsAndCaseWorker(caseDetails, caseWorker);
        if (alreadyAssigned) {
            return ResponseEntity.ok("Case worker already assigned to this case.");
        }

        // Create a new assignment
        CaseWorkerAssignment assignment = new CaseWorkerAssignment();
        assignment.setCaseDetails(caseDetails);
        assignment.setCaseWorker(caseWorker);
        assignment.setAssignedDate(LocalDateTime.now());

        // Save the assignment
        caseWorkerAssignmentRepository.save(assignment);

        return ResponseEntity.ok("Case worker assigned successfully.");
    }

    return ResponseEntity.notFound().build();
}

}
