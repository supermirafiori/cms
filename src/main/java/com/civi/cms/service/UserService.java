package com.civi.cms.service;

import com.civi.cms.model.UserLogin;
import com.civi.cms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService
{

    UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder(); // Initialize password encoder
    }

    public ResponseEntity<?> save(UserLogin userlogin)
    {
        Optional<UserLogin> userLoginOptional = userRepository.findById(userlogin.getEmail());
        if(userLoginOptional.isPresent()){
            return ResponseEntity.badRequest().body("User already exists.");
        }
        userlogin.setPassword(passwordEncoder.encode(userlogin.getPassword()));
        userlogin.setLastLogin(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(userlogin));
    }

    public ResponseEntity<?> validateUsernameAndPassword(String username, String password) {
        Optional<UserLogin> userOptional = userRepository.findById(username);
        if (userOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid username. Please check and try again.");
        }

        UserLogin user = userOptional.get();
        if (!passwordEncoder.matches(password, user.getPassword())) {
            return ResponseEntity.badRequest().body("Invalid password. Please check and try again.");
        }
        else{
            if(user.isLocked())
            {
                return ResponseEntity.badRequest().body("Account is locked!");
            }

        }

        return ResponseEntity.ok(user);
    }


    public boolean lockUserAccount(String userId) {
        Optional<UserLogin> userOpt = userRepository.findById(userId);
        if (userOpt.isPresent()) {
            UserLogin user = userOpt.get();
            user.setLocked(true);  // Assume there's a 'locked' field
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public boolean unlockUserAccount(String emailId) {
        Optional<UserLogin> userOpt = userRepository.findById(emailId); // Assuming emailId is the user ID in the repository
        if (userOpt.isPresent()) {
            UserLogin user = userOpt.get();
            user.setLocked(false);  // Assume 'locked' is a boolean field in UserLogin
            userRepository.save(user);
            return true;
        }
        return false;
    }
}


