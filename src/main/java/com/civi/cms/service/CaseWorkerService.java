package com.civi.cms.service;
import com.civi.cms.model.*;
import com.civi.cms.repository.CaseDetailRepository;
import com.civi.cms.repository.CaseWorkerAssignmentRepository;
import com.civi.cms.repository.CaseWorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CaseWorkerService {

    @Autowired
    private CaseWorkerRepository caseWorkerRepository;

    @Autowired
    UserService userService;

    @Autowired
    EmailService emailService;

    @Autowired
    private CaseDetailRepository caseDetailsRepository;

    @Autowired
    CaseWorkerAssignmentRepository caseWorkerAssignmentRepository;

    // Create case worker
    @Transactional
    public ResponseEntity<?> createCaseWorker(CaseWorker caseWorker) {
        try {
            caseWorker.setEmail(caseWorker.getEmail().toLowerCase());
            Optional<CaseWorker> existingByEmail = caseWorkerRepository.findByEmail(caseWorker.getEmail());
            if (existingByEmail.isPresent()) {
                return new ResponseEntity<>("Email already exists", HttpStatus.CONFLICT);
            }

            Optional<CaseWorker> existingByPhone = caseWorkerRepository.findByPhoneNumber(caseWorker.getPhoneNumber());
            if (existingByPhone.isPresent()) {
                return new ResponseEntity<>("Phone number already exists", HttpStatus.CONFLICT);
            }

            CaseWorker savedCaseWorker = caseWorkerRepository.save(caseWorker);
            // Step 1: Generate random password
            String password = generateRandomPassword(8); // customize length as needed
            // Step 2: Save login info
            UserLogin login = new UserLogin();
            login.setEmail(savedCaseWorker.getEmail());
            login.setPassword(password); // store encoded if needed (BCrypt)
            login.setRole(UserLogin.Role.CASEWORKER);
            ResponseEntity<?> response = userService.save(login);
            if(response.getStatusCode() != HttpStatus.CREATED){
                return response;
            }


            // Step 3: Send email
            String subject = "Welcome to the Case Management Portal";

            String body = "<html>" +
                    "<body style='font-family: Arial, sans-serif; color: #333;'>"
                    + "<h2 style='color: #2E86C1;'>Welcome to the Case Management Portal!</h2>" +
                    "<p>Dear <strong>" + savedCaseWorker.getFirstName() + "</strong>,</p>" +
                    "<p>We're excited to have you onboard. Your account has been successfully created.</p>" +
                    "<p><strong>Here are your login details:</strong></p>" +
                    "<table style='border: 1px solid #ccc; padding: 10px; border-collapse: collapse;'>"
                    + "<tr><td style='padding: 8px;'><strong>Email</strong></td><td style='padding: 8px;'>" + savedCaseWorker.getEmail() + "</td></tr>"
                    + "<tr><td style='padding: 8px;'><strong>Password</strong></td><td style='padding: 8px;'>" + password + "</td></tr>"
                    + "</table>" +
                    "<p style='margin-top: 20px;'>For security reasons, please <strong>change your password</strong> after logging in for the first time.</p>" +
                    "<p>If you have any questions or need help, feel free to contact our support team.</p>" +
                    "<br>" +
                    "<p>Best regards,</p>" +
                    "<p><strong>Case Management Team</strong></p>" +
                    "</body>" +
                    "</html>";


            emailService.sendEmail(savedCaseWorker.getEmail(), subject, body);

            return new ResponseEntity<>(savedCaseWorker, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>("Error creating case worker: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private String generateRandomPassword(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#$%";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
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

    public ResponseEntity<?> getCaseWorkerById(Long id) {
        Optional<CaseWorker> existingCaseWorker = caseWorkerRepository.
                findByCaseWorkerIdAndIsDeletedFalse(id);
        if (existingCaseWorker.isEmpty()) {
            return ResponseEntity.status(404).body(null);
        }
        CaseWorker caseWorker = existingCaseWorker.get();
        Map<String, Object> response = getCaseWorkerDetails(caseWorker);
        return ResponseEntity.ok(response); // HTTP 200 OK
    }
    private Map<String, Object>  getCaseWorkerDetails(CaseWorker caseWorker) {
        Map<String, Object> response = new LinkedHashMap<>();
        List<AssignedCaseDTO> assignedCases = caseWorker.getAssignedCases()
                .stream()
                .map(ac -> new AssignedCaseDTO( ac.getCaseDetails().getCaseId(), ac.getAssignedDate()))
                .collect(Collectors.toList());
        response.put("caseWorker", caseWorker);
        response.put("assignedCases", assignedCases);
        return response;
    }


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
        existingCase.get().setCaseWorkerAssigned(true);
        caseDetailsRepository.save(existingCase.get());

        return ResponseEntity.ok("Case worker assigned successfully.");
    }

    return ResponseEntity.notFound().build();
}

}
