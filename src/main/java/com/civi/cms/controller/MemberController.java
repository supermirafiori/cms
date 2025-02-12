package com.civi.cms.controller;

import com.civi.cms.model.Member;
import com.civi.cms.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @Autowired
    MemberService service;

    @PostMapping("/addmember")
    public ResponseEntity<?> addMember(@RequestBody Member m){
        return service.addMember(m);
    }
}
