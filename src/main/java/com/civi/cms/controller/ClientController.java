package com.civi.cms.controller;

import com.civi.cms.model.Client;
import com.civi.cms.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {
    //create crud operation
    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<?> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @PostMapping
    public ResponseEntity<?> createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateClient(@PathVariable Long id, @RequestBody Client clientDetails) {
        return clientService.updateClient(id, clientDetails);
    }

    @GetMapping("/email/{emailId}")
    public ResponseEntity<?> getClientByEmail(@PathVariable String emailId) {
        return clientService.getClientByEmail(emailId);

    }

    @GetMapping("/associated-case/id/{id}")
    public ResponseEntity<?> getCaseByClientId(@PathVariable Long id) {
        return clientService.getCaseByClientId(id);

    }
    @GetMapping("/associated-case/email/{email}")
    public ResponseEntity<?> getCaseByClientEmail(@PathVariable String email) {
        return clientService.getCaseByClientEmail(email);

    }

}
