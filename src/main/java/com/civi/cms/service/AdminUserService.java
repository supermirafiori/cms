package com.civi.cms.service;

import com.civi.cms.model.AdminUser;
import com.civi.cms.model.CaseWorker;
import com.civi.cms.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminUserService {

    @Autowired
    AdminRepository adminUserRepository;

    // CREATE
    public ResponseEntity<?> createAdminUser(AdminUser user) {

        Optional<AdminUser> existingByEmail = adminUserRepository.findById(user.getEmail().toLowerCase());
        if (existingByEmail.isPresent()) {
            return new ResponseEntity<>("Email already exists", HttpStatus.CONFLICT);
        }

        Optional<CaseWorker> existingByPhone = adminUserRepository.findByPhoneNumber(user.getPhoneNumber());
        if (existingByPhone.isPresent()) {
            return new ResponseEntity<>("Phone number already exists", HttpStatus.CONFLICT);
        }
        return ResponseEntity.ok(adminUserRepository.save(user));
    }

    // READ - Get All
    public List<AdminUser> getAllAdminUsers() {
        return adminUserRepository.findAll();
    }

    // READ - Get by ID
    public ResponseEntity<?> getAdminUserById(String email) {

        Optional<AdminUser> existingByEmail = adminUserRepository.findById(email.toLowerCase());
        if(existingByEmail.isEmpty()){
            return new ResponseEntity<>("user does not exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(existingByEmail.get(), HttpStatus.OK);
    }

    // UPDATE
    public ResponseEntity<?> AdminUser (Long id, AdminUser updatedUser) {
        return new ResponseEntity<>(adminUserRepository.save(updatedUser),HttpStatus.OK);
    }

}
