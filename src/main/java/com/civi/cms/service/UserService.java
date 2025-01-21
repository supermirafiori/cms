package com.civi.cms.service;

import com.civi.cms.model.UserLogin;
import com.civi.cms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService
{
    @Autowired
    UserRepository userRepository;

    public UserLogin save(UserLogin userlogin)
    {


        return userRepository.save(userlogin); //user repository was made static
        //why was user repository made static
    }

    public ResponseEntity<String> validateUsernameAndPassword(String username, String password) {
        Optional<UserLogin> userOptional = userRepository.findById(username);
        if (userOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid username. Please check and try again.");
        }

        UserLogin user = userOptional.get();
        if (!user.getPassword().equals(password)) {
            return ResponseEntity.badRequest().body("Invalid password. Please check and try again.");
        }
        else{
            if(user.isLocked())
            {
                return ResponseEntity.badRequest().body("Account is locked!");
            }

        }

        return ResponseEntity.ok("Login successful.");
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


