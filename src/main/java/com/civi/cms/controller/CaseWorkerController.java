package com.civi.cms.controller;

import com.civi.cms.model.CaseWorker;
import com.civi.cms.service.CaseWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CaseWorkerController {

    @Autowired
    private CaseWorkerService caseWorkerService;

    // Create a new case worker
    @PostMapping("/create-caseworker")
    public ResponseEntity<?> createCaseWorker(@RequestBody CaseWorker caseWorker) {
        return caseWorkerService.createCaseWorker(caseWorker);
    }

    // Get all case workers
    @GetMapping("/get-caseworkers")
    public ResponseEntity<List<CaseWorker>> getAllCaseWorkers() {
        return (caseWorkerService.getAllActiveCaseWorkers());
    }

    // Get all case workers
    @GetMapping("/get-deactivated-caseworkers")
    public ResponseEntity<List<CaseWorker>> getDeactivatedCaseWorkers() {
        return (caseWorkerService.getAllDeactivatedCaseWorkers());
    }

    // Get a case worker by email (Primary Key)
    @GetMapping("/get-caseworker/{email}")
    public ResponseEntity<CaseWorker> getCaseWorkerByEmail(@PathVariable String email) {
        return (caseWorkerService.getCaseWorkerByEmail(email));
    }

    // Update a case worker
    @PutMapping("/update-caseworker")
    public ResponseEntity<?> updateCaseWorker(@RequestBody CaseWorker updatedCaseWorker) {
        return (caseWorkerService.updateCaseWorker(updatedCaseWorker));
    }

    // Delete a case worker
    @DeleteMapping("/delete-caseworker/{email}")
    public ResponseEntity<String> deleteCaseWorker(@PathVariable String email) {
        return caseWorkerService.softDeleteCaseWorker(email);
    }
}
