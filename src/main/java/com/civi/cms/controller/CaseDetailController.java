package com.civi.cms.controller;

import com.civi.cms.model.CaseDetails;
import com.civi.cms.service.CaseDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cases")
public class CaseDetailController {

    @Autowired
    private CaseDetailService caseDetailService;

    // Get all cases
    @GetMapping
    public ResponseEntity<List<CaseDetails>> getAllCases() {
        List<CaseDetails> caseDetails = caseDetailService.getAllCases();
        return ResponseEntity.ok(caseDetails);
    }

    // Get case by ID
    @GetMapping("/{id}") //tested already in postman
    public ResponseEntity<CaseDetails> getCaseById(@PathVariable Long id) {
        CaseDetails caseDetailsObj = caseDetailService.getCaseById(id);
        return ResponseEntity.ok(caseDetailsObj);
    }

    // Create a new case
    @PostMapping("/create") //tested already in postman
    public ResponseEntity<CaseDetails> createCase(@RequestBody CaseDetails caseDetailsObj) {
        CaseDetails createdCaseDetails = caseDetailService.createCase(caseDetailsObj);
        return ResponseEntity.ok(createdCaseDetails);
    }

    // Update an existing case
    //@PutMapping("/{id}")
   //public ResponseEntity<CaseDetails> updateCase(@PathVariable Long id, @RequestBody CaseDetails caseDetailsObj) {
       // CaseDetails updatedCaseDetails = caseDetailService.updateCase(id, caseDetailsObj);
        //return ResponseEntity.ok(updatedCaseDetails);
    //}

    //updated put - for updating cases
    @PutMapping("/update") //already tested in postman
    public ResponseEntity<CaseDetails> updateCase(

            @RequestBody CaseDetails caseDetailsObj)
    {

        CaseDetails updatedCaseDetails = caseDetailService.updateCase(caseDetailsObj);
        return ResponseEntity.ok(updatedCaseDetails);
    }



    // Delete a case
    @DeleteMapping("/{id}") //tested in postman already, its working
    public ResponseEntity<Boolean> deleteCase(@PathVariable Long id) {

        return ResponseEntity.ok(caseDetailService.deleteCase(id));
    }

    //get all case with clientId
    @GetMapping("/clientId/{id}") //tested already in postman
    public ResponseEntity<CaseDetails> getCaseByClientId(@PathVariable Long id) {
        CaseDetails caseDetailsObj = caseDetailService.getCaseById(id);
        return ResponseEntity.ok(caseDetailsObj);
    }
}
