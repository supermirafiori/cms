package com.civi.cms.controller;

import com.civi.cms.service.UserService;
import com.civi.cms.model.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/users")
@RestController
public class UserLoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> createUserLogin(@RequestBody UserLogin userLogin) {
        try {
            UserLogin createdUser = userService.save(userLogin);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error creating user: " + e.getMessage());
        }


    }

    @PostMapping("/login")
    public ResponseEntity<String> validateLogin(@RequestBody UserLogin loginRequest) {
        return userService.validateUsernameAndPassword(loginRequest.getEmail(), loginRequest.getPassword());

    }

    @PutMapping("/lockAccount/{emailId}")
    public ResponseEntity<String> lockAccount(@PathVariable String emailId) {

        if (emailId == null || emailId.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid request. Email ID is required.");
        }

        boolean isLocked = userService.lockUserAccount(emailId);
        if (isLocked) {
            return ResponseEntity.ok("Account successfully locked.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");

            //this lock will be implemented by admin
        }
    }


    @PutMapping("/unlockAccount/{emailId}")
    public ResponseEntity<String> unlockAccount(@PathVariable String emailId) {

        // Validate the emailId parameter
        if (emailId == null || emailId.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid request. Email ID is required.");
        }

        // Call the service method to unlock the account

        boolean isUnlocked = userService.unlockUserAccount(emailId);

        // Determine the response based on the result of the unlock attempt
        if (isUnlocked) {
            return ResponseEntity.ok("Account successfully unlocked.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
    }
}




