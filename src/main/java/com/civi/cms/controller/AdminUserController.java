package com.civi.cms.controller;

import com.civi.cms.model.AdminUser;
import com.civi.cms.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;

    // CREATE Admin User
    @PostMapping
    public ResponseEntity<?> createAdminUser(@RequestBody AdminUser user) {
        return adminUserService.createAdminUser(user);
    }

    // GET all Admin Users
    @GetMapping
    public ResponseEntity<List<AdminUser>> getAllAdminUsers() {
        List<AdminUser> users = adminUserService.getAllAdminUsers();
        return ResponseEntity.ok(users);
    }

    // GET Admin User by Email
    @GetMapping("/{email}")
    public ResponseEntity<?> getAdminUserByEmail(@PathVariable String email) {
        return adminUserService.getAdminUserById(email);
    }

    // UPDATE Admin User
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAdminUser(@PathVariable Long id, @RequestBody AdminUser updatedUser) {
        return adminUserService.AdminUser(id, updatedUser);
    }
}
