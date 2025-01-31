package com.civi.cms.controller;

import com.civi.cms.model.Appointment;
import com.civi.cms.model.CaseAttachment;
import com.civi.cms.model.CaseDetails;
import com.civi.cms.service.CaseAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/caseAttachments")
public class CaseAttachmentController
{
    @Autowired
    private CaseAttachmentService caseAttachmentService;

    @PostMapping("/create")
    public ResponseEntity<CaseAttachment> createCaseAttachment(@RequestBody CaseAttachment caseAttachmentObj)
    {

        //Appointment createAppointment = appointmentService.createAppointment(appointmentObj);
        CaseAttachment createCaseAttachment = caseAttachmentService.createCaseAttachment(caseAttachmentObj);
        //return ResponseEntity.ok(createAppointment);
        return ResponseEntity.ok(createCaseAttachment);

    }

    @GetMapping("/get")
    public ResponseEntity<List<CaseAttachment>> getAllCaseAttachment()
    {
        List<CaseAttachment> caseAttachments = caseAttachmentService.getAllCaseAttachment();
        return ResponseEntity.ok(caseAttachments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CaseAttachment> getCaseById(@PathVariable Long id)
    {
       // CaseDetails caseDetailsObj = caseDetailService.getCaseById(id);
        CaseAttachment caseAttachmentObj = caseAttachmentService.getCaseAttachmentById(id);
        return ResponseEntity.ok(caseAttachmentObj);
    }

    @PutMapping("/update")
    public ResponseEntity<CaseAttachment> updateCaseAttachment(@RequestBody CaseAttachment caseAttachmentObj)
    {

        CaseAttachment updatedCaseAttachment = caseAttachmentService.updateCaseAt(caseAttachmentObj);
        return ResponseEntity.ok(updatedCaseAttachment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCaseAttachment(@PathVariable Long id)
    {

        return ResponseEntity.ok(caseAttachmentService.deleteCaseAttachment(id));
    }



}
