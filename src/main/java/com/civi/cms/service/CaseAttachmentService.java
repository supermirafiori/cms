package com.civi.cms.service;

import com.civi.cms.model.CaseAttachment;
import com.civi.cms.model.CaseDetails;
import com.civi.cms.repository.CaseAttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaseAttachmentService 
{
   @Autowired
   private  CaseAttachmentRepository caseAttachmentRepository;

    public List<CaseAttachment> getAllCaseAttachment()
    {
        return caseAttachmentRepository.findAll();
    }

    public CaseAttachment createCaseAttachment(CaseAttachment caseAttachmentObj)
    {
        return caseAttachmentRepository.save(caseAttachmentObj);
    }


    public CaseAttachment getCaseAttachmentById(Long id)
    {
        Optional<CaseAttachment> caseAttachmentOptional = caseAttachmentRepository.findById(id);
        if (caseAttachmentOptional.isPresent()) {
            return caseAttachmentOptional.get();
        } else {
            throw new RuntimeException("Case not found with ID: " + id);
        }
    }

    public CaseAttachment updateCaseAt(CaseAttachment caseAttachmentObj)
    {
        return caseAttachmentRepository.save(caseAttachmentObj);
    }

    public Boolean deleteCaseAttachment(Long id)
    {
        if (caseAttachmentRepository.existsById(id)) {
            //throw new RuntimeException("Case not found with ID: " + id);
            caseAttachmentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
