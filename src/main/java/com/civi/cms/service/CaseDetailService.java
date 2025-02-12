package com.civi.cms.service;
import com.civi.cms.model.CaseDetails;
import com.civi.cms.model.CaseHistory;
import com.civi.cms.repository.CaseDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CaseDetailService
{
    @Autowired
    private CaseDetailRepository caseDetailRepository;

    // Get all cases
    public List<CaseDetails> getAllCases()
    {
        return caseDetailRepository.findAll();
    }

    // Get a case by ID
    public CaseDetails getCaseById(Long id) {
        Optional<CaseDetails> caseOptional = caseDetailRepository.findById(id);
        if (caseOptional.isPresent()) {
            return caseOptional.get();
        } else {
            throw new RuntimeException("Case not found with ID: " + id);
        }
    }

    // Create a new case
    public CaseDetails createCase(CaseDetails caseDetailsObj)
    {
        return caseDetailRepository.save(caseDetailsObj);
    }



    // Delete a case
    public boolean deleteCase(Long id)
    {
        if (caseDetailRepository.existsById(id)) {
            //throw new RuntimeException("Case not found with ID: " + id);
            caseDetailRepository.deleteById(id);
            return true;
        }
      return false;
    }


    public CaseDetails updateCase(CaseDetails caseDetailsObj)
    {
        return
        caseDetailRepository.save(caseDetailsObj);
    }


    public ResponseEntity<String> updateCaseHistory(Long CaseId, CaseHistory caseHistory) {
        Optional<CaseDetails> caseOptional = caseDetailRepository.findById(CaseId);
        if (caseOptional.isPresent()) {
            CaseDetails details= caseOptional.get();
            List<CaseHistory> histories=details.getCaseHistories();
            histories.add(caseHistory);
            caseDetailRepository.save(details);
            return ResponseEntity.ok("updated successfully");
        } else {
            return ResponseEntity.badRequest().body("invalid caseid");
        }
    }
}
